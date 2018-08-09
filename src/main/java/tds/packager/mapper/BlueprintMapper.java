package tds.packager.mapper;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.util.StringUtils;
import tds.packager.model.gitlab.GitLabItemMetaData;
import tds.packager.model.gitlab.ItemMetaDataUtil;
import tds.packager.model.xlsx.TestPackageSheet;
import tds.packager.model.xlsx.TestPackageSheetNames;
import tds.packager.model.xlsx.TestPackageWorkbook;
import tds.testpackage.model.*;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static tds.packager.mapper.BlueprintConsts.*;

public class BlueprintMapper {
    public static List<BlueprintElement> map(final String testPackageId,
                                             final TestPackageWorkbook workbook,
                                             final Map<String, String> testPackageValues,
                                             final Map<String, GitLabItemMetaData> itemMetaData) {
        //TODO: Map scoring performancelevels
        final Set<String> itemIds = findItemIds(workbook.getSheet(TestPackageSheetNames.SEGMENT_FORMS));
        final Map<String, Scoring> scoringMap = mapBlueprintScoring(workbook, testPackageValues);

        final List<BlueprintElement> rootBlueprintElements = mapPackageAndTests(testPackageId, workbook, scoringMap);
        rootBlueprintElements.addAll(mapMiscellaneousElements(workbook, scoringMap));
        rootBlueprintElements.addAll(mapClaimsAndTargets(itemIds, itemMetaData, scoringMap));

        return rootBlueprintElements;
    }

    private static List<BlueprintElement> mapPackageAndTests(final String testPackageId,
                                                             final TestPackageWorkbook workbook,
                                                             final Map<String, Scoring> scoringMap) {
        final List<BlueprintElement> blueprintElements = new ArrayList<>();
        final TestPackageSheet testsSheet = workbook.getSheet(TestPackageSheetNames.TESTS);
        final TestPackageSheet segmentsSheet = workbook.getSheet(TestPackageSheetNames.SEGMENTS);

        final Multimap<String, BlueprintElement> parentMap = HashMultimap.create();

        final boolean isMultiAssessment = testsSheet.getTotalNumberOfInputColumns() > 1;

        if (isMultiAssessment) {
            final BlueprintElement packageBlueprintEl = BlueprintElement.builder()
                    .setId(testPackageId)
                    .setType(BlueprintElementTypes.PACKAGE)
                    .setScoring(Optional.ofNullable(scoringMap.get(testPackageId)))
                    .setBlueprintElements(mapTestBlueprintElements(testsSheet, segmentsSheet, scoringMap))
                    .build();
            blueprintElements.add(packageBlueprintEl);
        } else {
            return mapTestBlueprintElements(testsSheet, segmentsSheet, scoringMap);
        }


        return blueprintElements;
    }

    private static List<BlueprintElement> mapTestBlueprintElements(final TestPackageSheet testsSheet,
                                                                   final TestPackageSheet segmentsSheet,
                                                                   final Map<String, Scoring> scoringMap) {
        final List<BlueprintElement> testBlueprintElements = new ArrayList<>();
        for (int i = 0; i < testsSheet.getTotalNumberOfInputColumns(); i++) {
            final String assessmentId = testsSheet.getString("TestId", i);

            testBlueprintElements.add(BlueprintElement.builder()
                    .setId(assessmentId)
                    .setType(BlueprintElementTypes.TEST)
                    .setScoring(Optional.ofNullable(scoringMap.get(assessmentId)))
                    .setBlueprintElements(mapSegmentBlueprintElements(assessmentId, segmentsSheet, scoringMap))
                    .build());
        }

        return testBlueprintElements;
    }

    private static List<BlueprintElement> mapSegmentBlueprintElements(final String assessmentId, final TestPackageSheet segmentsSheet,
                                                                      final Map<String, Scoring> scoringMap) {
        final List<BlueprintElement> segmentBlueprintElements = new ArrayList<>();

        for (int i = 0; i < segmentsSheet.getTotalNumberOfInputColumns(); i++) {
            final Map<String, String> segmentInputValuesMap = segmentsSheet.getInputVariableValuesMap(i);

            if (!assessmentId.equals(segmentInputValuesMap.get("TestId"))) {
                // Skip this column if it does not correspond to the assessment ID we are dealing with
                continue;
            }
            final String segmentId = segmentInputValuesMap.get("SegmentId");

            segmentBlueprintElements.add(BlueprintElement.builder()
                    .setId(segmentId)
                    .setType(BlueprintElementTypes.SEGMENT)
                    .setScoring(Optional.ofNullable(scoringMap.get(segmentId)))
                    .build());

        }

        return segmentBlueprintElements;
    }

    private static List<BlueprintElement> mapMiscellaneousElements(final TestPackageWorkbook workbook, final Map<String, Scoring> scoringMap) {
        return new ArrayList<>();
    }

    private static Map<String, Scoring> mapBlueprintScoring(final TestPackageWorkbook workbook, final Map<String, String> testPackageValues) {
        final TestPackageSheet sheet = workbook.getSheet(TestPackageSheetNames.SCORING);
        final List<List<Pair<String, String>>> columns = sheet.getColumnPairs();

        final Map<String, List<List<Pair<String, String>>>> blueprintElements =
                columns.stream().collect(Collectors.groupingBy(column -> getValue(BLUEPRINT_ELEMENT_ID, column)));

        final Map<String, Scoring> scorings = blueprintElements.entrySet().stream().collect(
            Collectors.toMap(Entry::getKey, e -> mapScoring(e.getValue())));

        return scorings;
    }

    private static String getValue(final String name, List<Pair<String, String>> column) {
        return ColumnUtil.getValue(name, column).
                orElseThrow(() -> new RuntimeException(String.format("Error while mapping scoring sheet. Variable not found: %s", name)));
    }

    private static List<BlueprintElement> mapClaimsAndTargets(final Set<String> itemIds,
                                                              final Map<String, GitLabItemMetaData> itemMetaData,
                                                              final Map<String, Scoring> scoringMap) {
        final Multimap<String, BlueprintElement> bpElParentMap = HashMultimap.create();
        final Set<String> claimIds = new HashSet<>();

        itemIds.forEach(id -> {
            if (!itemMetaData.containsKey(id)) {
                throw new RuntimeException(String.format("Error locating the item metadata file for item %s", id));
            }

            final ItemMetaDataUtil util = new ItemMetaDataUtil(itemMetaData.get(id).getItemMetadata());

            final String standard = util.getPrimaryStandard();
            final List<String> blueprintElementIds = parseBlueprintId(standard);

            final String claimBpElementId = blueprintElementIds.get(0); // always the first id in the ordered list
            claimIds.add(claimBpElementId);

            BlueprintElement currEl = BlueprintElement.builder()
                    .setId(claimBpElementId)
                    .setType(BlueprintElementTypes.CLAIM)
                    .build();

            for (int i = 1; i < blueprintElementIds.size(); i++) {
                BlueprintElement childEl = BlueprintElement.builder()
                        .setId(blueprintElementIds.get(i))
                        .setType(BlueprintElementTypes.TARGET)
                        .build();

                bpElParentMap.put(currEl.getId(), childEl);
                currEl = childEl;
            }

        });

        List<String> sortedClaimIds = new ArrayList<>(claimIds);
        Collections.sort(sortedClaimIds); // Sort the claims alphanumerically
        List<BlueprintElement> claimBlueprintElements = sortedClaimIds.stream()
                .map(bpElId -> BlueprintElement.builder()
                        .setId(bpElId)
                        .setType(BlueprintElementTypes.CLAIM)
                        .setBlueprintElements(new ArrayList<>())
                        .setScoring(Optional.ofNullable(scoringMap.get(bpElId)))
                        .build())
                .collect(Collectors.toList());

        claimBlueprintElements.forEach(blueprintElement -> mapBlueprintElement(blueprintElement, bpElParentMap, scoringMap));

        return new ArrayList<>(claimBlueprintElements);
    }

    // Recursively map all blueprint elements breadth-first
    private static void mapBlueprintElement(final BlueprintElement currentEl, final Multimap<String, BlueprintElement> parentMap,
                                            final Map<String, Scoring> scoringMap) {
        if (parentMap.containsKey(currentEl.getId())) {
            final List<BlueprintElement> blueprintElements = currentEl.blueprintElements();
            final List<BlueprintElement> bpEl = new ArrayList<>(parentMap.get(currentEl.getId()));

            bpEl.forEach(childEl -> {
                final BlueprintElement currBpEl = BlueprintElement.builder()
                        .setId(childEl.getId())
                        .setType(BlueprintElementTypes.TARGET)
                        .setBlueprintElements(new ArrayList<>())
                        .setScoring(Optional.ofNullable(scoringMap.get(childEl.getId())))
                        .build();
                blueprintElements.add(currBpEl);
                mapBlueprintElement(currBpEl, parentMap, scoringMap);
            });
        }
    }

    private static List<String> parseBlueprintId(final String standard) {
        //SBAC-MA-v6:1|P|TS06|M - > 1|P|TS06|M
        final String bottomLevelBpRef = standard.split(":")[1];

        // If its not a target string (containing a pipe), then simply return this id
        if (!bottomLevelBpRef.contains("|")) {
            return Collections.singletonList(bottomLevelBpRef);
        }

        List<String> refIds = new ArrayList<>();

        final String[] targetSections = bottomLevelBpRef.split("\\|");

        for (int i = 0; i < targetSections.length; i++) {
            if (i == 0) {
                refIds.add(targetSections[i]);
            } else {
                StringBuilder id = new StringBuilder();
                for (int j = 0; j <= i; j++) {
                    if (j > 0) {
                        id.append("|");
                    }
                    id.append(targetSections[j]);
                }

                refIds.add(id.toString());
            }
        }

        return refIds;
    }

    private static Set<String> findItemIds(final TestPackageSheet segmentFormsSheet) {
        final Set<String> itemIds = new HashSet<>();

        for (int i = 0; i <= segmentFormsSheet.getTotalNumberOfInputColumns(); i++) {
            final String itemId = segmentFormsSheet.getString("ItemId", i);
            if (!StringUtils.isEmpty(itemId)) {
                itemIds.add(segmentFormsSheet.getString("ItemId", i));
            }
        }

        return itemIds;
    }

    private static int getInt(final String name, List<Pair<String, String>> column) {
        return Integer.parseInt(getValue(name, column));
    }

    private static Scoring mapScoring(final List<List<Pair<String, String>>> columns) {
        final Scoring.Builder builder = Scoring.builder();

        final List<Rule> rules = columns.stream().map(BlueprintMapper::mapRule).collect(Collectors.toList());
        builder.setRules(rules);

        return builder.build();
    }

    private static PerformanceLevel mapPerformanceLevel(final List<Pair<String, String>> column) {
        final PerformanceLevel.Builder builder = PerformanceLevel.builder();

        return builder.build();
    }

    private static Rule mapRule(final List<Pair<String, String>> column) {
        final Rule.Builder builder = Rule.builder();

        builder.setComputationOrder(getInt(COMPUTATION_ORDER, column));
        builder.setName(getValue(NAME, column));
        builder.setMeasure(ColumnUtil.getValue(MEASURE, column));
        final List<Parameter> parameters = ColumnUtil.mapList(PARAMETER_TYPE, column, BlueprintMapper::mapParameter);
        builder.setParameters(parameters);

        return builder.build();
    }

    private static Parameter mapParameter(final int position, final List<Pair<String, String>> column) {
        final Parameter.Builder builder = Parameter.builder();

        builder.setId(UUID.randomUUID().toString());
        builder.setPosition(position);

        builder.setType(getValue(PARAMETER_TYPE, column));
        builder.setName(getValue(PARAMETER_NAME, column));

        final List<Property> properties = ColumnUtil.mapList(PROPERTY_NAME, column, BlueprintMapper::mapProperty);
        final List<Value> values = ColumnUtil.mapList(PARAMETER_TYPE, column, BlueprintMapper::mapValue);
        builder.setProperties(properties);
        builder.setValues(values);

        return builder.build();
    }

    private static Property mapProperty(final int position, final List<Pair<String, String>> column) {
        final Property.Builder builder = Property.builder();

        builder.setName(getValue(PROPERTY_NAME, column));
        builder.setValue(getValue(PROPERTY_VALUE, column));

        return builder.build();
    }

    private static Value mapValue(final int position, final List<Pair<String, String>> column) {
        final Value.Builder builder = Value.builder();

        builder.setIndex(ColumnUtil.getValue(VALUE_INDEX, column));
        builder.setValue(getValue(VALUE, column));

        return builder.build();
    }
}