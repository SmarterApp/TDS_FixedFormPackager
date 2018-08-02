package tds.packager.mapper;

import org.springframework.util.StringUtils;
import tds.common.Algorithm;
import tds.packager.model.xlsx.TestPackageSheet;
import tds.packager.model.xlsx.TestPackageSheetNames;
import tds.packager.model.xlsx.TestPackageWorkbook;
import tds.testpackage.model.Presentation;
import tds.testpackage.model.Property;
import tds.testpackage.model.Segment;
import tds.testpackage.model.SegmentBlueprintElement;

import java.util.*;

public class SegmentMapper {
    public static List<Segment> map(final TestPackageWorkbook workbook, final String assessmentId) {
        final List<Segment> segments = new ArrayList<>();
        final TestPackageSheet sheet = workbook.getSheet(TestPackageSheetNames.SEGMENTS);

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
                    .setAlgorithmImplementation(Algorithm.FIXED_FORM.getType())
                    .setSegmentForms(SegmentFormMapper.map(workbook, segmentId, mapPresentations(segmentInputValuesMap)))
                    .setTools(ToolMapper.map(workbook, segmentId))
                    .setSegmentBlueprint(mapSegmentBlueprint(segmentId, segmentInputValuesMap))
                    .build());
        }

        return segments;
    }

    private static List<SegmentBlueprintElement> mapSegmentBlueprint(final String segmentId, final Map<String, String> segmentInputValuesMap) {
        final List<SegmentBlueprintElement> segmentBlueprint = new ArrayList<>();

        // Add the segment blueprint, containing the slope and intercept values
        segmentBlueprint.add(SegmentBlueprintElement.builder()
                .setIdRef(segmentId)
                .setItemSelection(mapItemSelection(segmentInputValuesMap.get("SegmentSlope"), segmentInputValuesMap.get("SegmentIntercept")))
                .build());

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
