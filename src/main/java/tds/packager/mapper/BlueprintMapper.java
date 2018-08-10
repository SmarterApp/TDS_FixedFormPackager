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
    public static List<BlueprintElement> map(final TestPackageWorkbook workbook,
                                             final Map<String, String> testPackageValues,
                                             final Map<String, GitLabItemMetaData> itemMetaData) {
        final List<BlueprintElement> rootBlueprintElements = new ArrayList<>();

        // TODO: Map package/test/segment blueprints
        // TODO: Map other misc blueprint elements (sock, affinitygroup)

        final Set<String> itemIds = findItemIds(workbook.getSheet(TestPackageSheetNames.SEGMENT_FORMS));

        rootBlueprintElements.addAll(mapPackageAndTests(workbook));
        rootBlueprintElements.addAll(mapMiscellaneousElements(workbook));
        rootBlueprintElements.addAll(mapClaimsAndTargets(itemIds, itemMetaData, new HashMap<>()));

        return rootBlueprintElements;
    }

    private static List<BlueprintElement> mapPackageAndTests(final TestPackageWorkbook workbook) {
        return new ArrayList<>();
    }

    private static List<BlueprintElement> mapMiscellaneousElements(final TestPackageWorkbook workbook) {
        return new ArrayList<>();
    }

    public static Map<String, Scoring> mapBlueprintScoring(final TestPackageWorkbook workbook) {
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
                orElseThrow(() -> new RuntimeException(String.format("Error while mapping scoring sheet. Varible not found: %s", name)));
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
        builder.setMeasure(ColumnUtil.getValue(MEASURE, column).filter(s -> !s.isEmpty()));
        final List<Parameter> parameters = ColumnUtil.mapList(PARAMETER_TYPE, column, BlueprintMapper::mapParameter);
        builder.setParameters(parameters);

        return builder.build();
    }

    private static Optional<Parameter> mapParameter(final int position, final List<Pair<String, String>> column) {
        final String parameterName = getValue(PARAMETER_NAME, column);
        if (!parameterName.isEmpty()) {
            final Parameter.Builder builder = Parameter.builder();

            builder.setId(UUID.randomUUID().toString());
            builder.setPosition(position);

            builder.setType(getValue(PARAMETER_TYPE, column));
            builder.setName(parameterName);

            final List<Property> properties = ColumnUtil.mapList(PROPERTY_NAME, column, BlueprintMapper::mapProperty);
            final List<Value> values = ColumnUtil.mapList(VALUE_INDEX, column, BlueprintMapper::mapValue);
            builder.setProperties(properties);
            builder.setValues(values);

            return Optional.of(builder.build());
        }
        return Optional.empty();
    }

    private static Optional<Property> mapProperty(final int position, final List<Pair<String, String>> column) {
        final String propertyName = getValue(PROPERTY_NAME, column);
        if (!propertyName.isEmpty()) {
            final Property.Builder builder = Property.builder();

            builder.setName(propertyName);
            builder.setValue(getValue(PROPERTY_VALUE, column));

            return Optional.of(builder.build());
        }
        return Optional.empty();
    }

    private static Optional<Value> mapValue(final int position, final List<Pair<String, String>> column) {
        final String value = getValue(VALUE, column);
        if (!value.isEmpty()) {
            final Value.Builder builder = Value.builder();

            builder.setIndex(ColumnUtil.getValue(VALUE_INDEX, column).filter(s -> !s.isEmpty()));
            builder.setValue(getValue(VALUE, column));

            return Optional.of(builder.build());
        }
        return Optional.empty();
    }
}