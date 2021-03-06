package tds.packager.mapper;

import org.springframework.util.StringUtils;
import tds.common.Algorithm;
import tds.packager.model.gitlab.GitLabItemMetaData;
import tds.packager.model.gitlab.ItemMetaDataUtil;
import tds.packager.model.xlsx.TestPackageSheet;
import tds.packager.model.xlsx.TestPackageSheetNames;
import tds.packager.model.xlsx.TestPackageWorkbook;
import tds.testpackage.model.Presentation;
import tds.testpackage.model.Property;
import tds.testpackage.model.Segment;
import tds.testpackage.model.SegmentBlueprintElement;

import java.util.*;

public class SegmentMapper {
    public static List<Segment> map(final TestPackageWorkbook workbook, final String assessmentId,
                                    final Map<String, GitLabItemMetaData> itemMetaData) {
        final List<Segment> segments = new ArrayList<>();
        final TestPackageSheet sheet = workbook.getSheet(TestPackageSheetNames.SEGMENTS);
        final TestPackageSheet segmentFormsSheet = workbook.getSheet(TestPackageSheetNames.SEGMENT_FORMS);

        for (int i = 0; i < sheet.getTotalNumberOfInputColumns(); i++) {
            final Map<String, String> segmentInputValuesMap = sheet.getInputVariableValuesMap(i);

            if (!assessmentId.equals(segmentInputValuesMap.get("TestId"))) {
                // Skip this column if it does not correspond to the assessment ID we are dealing with
                continue;
            }

            final String segmentId = segmentInputValuesMap.get("SegmentId");
            segments.add(Segment.builder()
                    .setId(segmentId)
                    .setPosition(Integer.valueOf(segmentInputValuesMap.get("SegmentPosition")))
                    .setLabel(StringUtils.isEmpty(segmentInputValuesMap.get("SegmentLabel"))
                            ? Optional.empty()
                            : Optional.of(segmentInputValuesMap.get("SegmentLabel")))
                    .setEntryApproval(StringUtils.isEmpty(segmentInputValuesMap.get("SegmentEntryApproval"))
                            ? false
                            : Boolean.valueOf(segmentInputValuesMap.get("SegmentEntryApproval")))
                    .setExitApproval(StringUtils.isEmpty(segmentInputValuesMap.get("SegmentExitApproval"))
                            ? false
                            : Boolean.valueOf(segmentInputValuesMap.get("SegmentExitApproval")))
                    .setAlgorithmType(Algorithm.FIXED_FORM.getType())
                    .setAlgorithmImplementation("FAIRWAY FIXEDFORM")
                    .setSegmentForms(SegmentFormMapper.map(workbook, segmentId, itemMetaData, assessmentId))
                    .setTools(!segmentId.equalsIgnoreCase(assessmentId) ? ToolMapper.map(workbook, segmentId) : new ArrayList<>())
                    .setSegmentBlueprint(mapSegmentBlueprint(segmentId, segmentInputValuesMap, itemMetaData, findItemIdsForSegment(segmentId, segmentFormsSheet)))
                    .build());
        }

        segments.sort(Comparator.comparingInt(Segment::position));

        return segments;
    }

    private static Map<String, BlueprintElementCounts> getBlueprintReferenceCounts(final String segmentId, final List<String> itemIds,
                                                                                   final Map<String, GitLabItemMetaData> itemMetaData) {
        final Map<String, BlueprintElementCounts> blueprintElementCountsMap = new HashMap<>();

        itemIds.forEach(id -> {
            if (!itemMetaData.containsKey(id)) {
                throw new RuntimeException(String.format("Error locating the item metadata file for item %s", id));
            }

            ItemMetaDataUtil util = new ItemMetaDataUtil(itemMetaData.get(id).getItemMetadata());

            final String standard = util.getPrimaryStandard();
            final List<String> blueprintElementIds = BlueprintMapper.parseBlueprintId(standard);
            final boolean fieldTestItem = !util.getStatus().equalsIgnoreCase("Operational");

            // Increment the segment counts
            incrementCounts(blueprintElementCountsMap, fieldTestItem, segmentId);

            // Increment all the other blueprint reference counts
            for (String refId : blueprintElementIds) {
                incrementCounts(blueprintElementCountsMap, fieldTestItem, refId);
            }
        });

        return blueprintElementCountsMap;
    }

    private static void incrementCounts(final Map<String, BlueprintElementCounts> blueprintElementCountsMap, final boolean fieldTestItem, final String refId) {
        if (!blueprintElementCountsMap.containsKey(refId)) {
            BlueprintElementCounts counts = new BlueprintElementCounts(refId);

            if (fieldTestItem) {
                counts.incrementFieldTestItemCount();
            } else {
                counts.incrementExamItemCount();
            }

            blueprintElementCountsMap.put(refId, counts);
        } else {
            final BlueprintElementCounts counts = blueprintElementCountsMap.get(refId);
            if (fieldTestItem) {
                counts.incrementFieldTestItemCount();
            } else {
                counts.incrementExamItemCount();
            }
        }
    }

    private static List<String> findItemIdsForSegment(final String segmentId, final TestPackageSheet segmentFormsSheet) {
        final List<String> itemIds = new ArrayList<>();

        for (int i = 0; i <= segmentFormsSheet.getTotalNumberOfInputColumns(); i++) {
            if (segmentFormsSheet.getString("SegmentId", i).equals(segmentId)) {
                itemIds.add(segmentFormsSheet.getString("ItemId", i));
            }
        }

        return itemIds;
    }

    private static List<SegmentBlueprintElement> mapSegmentBlueprint(final String segmentId,
                                                                     final Map<String, String> segmentInputValuesMap,
                                                                     final Map<String, GitLabItemMetaData> itemMetaData,
                                                                     final List<String> itemIds) {
        final List<SegmentBlueprintElement> segmentBlueprint = new ArrayList<>();
        final Map<String, BlueprintElementCounts> bpRefCounts = getBlueprintReferenceCounts(segmentId, itemIds, itemMetaData);

        bpRefCounts.forEach((bpId, counts) ->
                segmentBlueprint.add(SegmentBlueprintElement.builder()
                        .setIdRef(bpId)
                        .setMinExamItems(0)
                        .setMaxExamItems(counts.getExamItemCount())
                        .setMinFieldTestItems(Optional.of(0))
                        .setMaxFieldTestItems(Optional.of(counts.getFieldTestItemCount()))
                        .setItemSelection(bpId.equals(segmentId) // Primary segment blueprint element should have item selection data
                                ? mapItemSelection(segmentInputValuesMap.get("SegmentSlope"), segmentInputValuesMap.get("SegmentIntercept"))
                                : null)
                        .build())
        );

        return segmentBlueprint;
    }

    private static List<Property> mapItemSelection(final String slope, final String intercept) {
        return Arrays.asList(
                Property.builder()
                        .setName("slope")
                        .setValue(slope)
                        .build(),
                Property.builder()
                        .setName("intercept")
                        .setValue(intercept)
                        .build()
        );
    }

    private static List<Presentation> mapPresentations(final Map<String, String> segmentInputValuesMap) {
        final List<Presentation> presentations = new ArrayList<>();

        if (Boolean.valueOf(segmentInputValuesMap.get("SegmentEnglishPresentation"))) {
            presentations.add(Presentation.builder()
                    .setCode("ENU")
                    .setLabel("English")
                    .build());
        }
        if (Boolean.valueOf(segmentInputValuesMap.get("SegmentBraillePresentation"))) {
            presentations.add(Presentation.builder()
                    .setCode("ENU-Braille")
                    .setLabel("Braille")
                    .build());
        }
        if (Boolean.valueOf(segmentInputValuesMap.get("SegmentSpanishPresentation"))) {
            presentations.add(Presentation.builder()
                    .setCode("ESN")
                    .setLabel("Spanish")
                    .build());
        }

        return presentations;
    }
}
