package tds.packager.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;

import tds.packager.model.xlsx.TestPackageSheet;
import tds.packager.model.xlsx.TestPackageSheetNames;
import tds.packager.model.xlsx.TestPackageWorkbook;
import tds.testpackage.model.BlueprintElement;
import tds.testpackage.model.Parameter;
import tds.testpackage.model.PerformanceLevel;
import tds.testpackage.model.Property;
import tds.testpackage.model.Rule;
import tds.testpackage.model.Scoring;
import tds.testpackage.model.Value;
import static tds.packager.mapper.BlueprintConsts.*;

public class BlueprintMapper {
    private static String getValue(final String name, List<Pair<String, String>> column) {
        return ColumnUtil.getValue(name, column).
            orElseThrow(() -> new RuntimeException(String.format("Error while mapping scoring sheet. Varible not found: %s", name)));
    }

    private static int getInt(final String name, List<Pair<String, String>> column) {
        return Integer.parseInt(getValue(name, column));
    }

    public static List<Pair<String, Scoring>> mapBlueprintScoring(final TestPackageWorkbook workbook) {
        final TestPackageSheet sheet = workbook.getSheet(TestPackageSheetNames.SCORING);
        final List<List<Pair<String, String>>> columns = sheet.getColumnPairs();

        final Map<String, List<List<Pair<String, String>>>> blueprintElements =
            columns.stream().collect(Collectors.groupingBy(column -> getValue(BLUEPRINT_ELEMENT_ID, column)));

        final List<Pair<String, Scoring>> scorings = blueprintElements.entrySet().stream().
            map(e -> Pair.of(e.getKey(), mapScoring(e.getValue()))).collect(Collectors.toList());

        return scorings;
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