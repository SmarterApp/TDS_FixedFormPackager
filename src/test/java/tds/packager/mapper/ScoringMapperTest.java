package tds.packager.mapper;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import org.junit.Test;

import tds.testpackage.model.Parameter;
import tds.testpackage.model.Rule;
import tds.testpackage.model.Scoring;
import tds.testpackage.model.TestPackage;
import tds.testpackage.model.Value;

public class ScoringMapperTest extends MapperBaseTest {

    static void valuesEqual(Value expected, Value actual) {
        assertEquals(actual, expected);
        assertThat("Value", actual, is(expected));
    }

    static void parametersEqual(Parameter expected, Parameter actual) {
        assertThat("Rule parameter should have same name", actual.getName(), is(expected.getName()));
        assertThat("Rule parameter should have same position", actual.getPosition(), is(expected.getPosition()));
        assertThat("Rule parameter should have same type", actual.getType(), is(expected.getType()));

        IntStream.range(0, expected.getValues().size()).forEach(i ->
            valuesEqual(expected.getValues().get(i), actual.getValues().get(i)));
    }

    static void rulesEqual(Rule expected, Rule actual) {
        assertThat("Rules should have same number of parameters", actual.parameters().size(), is(expected.parameters().size()));
        assertThat("Rules should have same computation order", actual.getComputationOrder(), is(expected.getComputationOrder()));
        assertThat("Rules should have same name", actual.getName(), is(expected.getName()));
        assertThat("Rules should have same measure label", actual.measure(), is(expected.measure()));

        IntStream.range(0, expected.parameters().size()).forEach(i ->
            parametersEqual(expected.parameters().get(i), actual.parameters().get(i)));
    }

    static void scoresEqual(Scoring expected, Scoring actual) {
        IntStream.range(0, expected.getRules().size()).forEach(i -> {
            Rule expectedRule = expected.getRules().get(i);
            rulesEqual(expectedRule, actual.getRules().stream().filter(r -> r.getName().equals(expectedRule.getName())).findFirst().get());
        });
    }

    @Test
    public void shouldMapScores() throws Exception {
        Map<String, Scoring> scores = BlueprintMapper.mapBlueprintScoring(mockWorkbook, Collections.emptyMap());
        Scoring scoring = scores.get("SBAC-IAB-FIXED-G11M");
        assertThat(scoring.getRules().size(), is(5));
    }

    @Test
    public void shouldMapRuleValues() throws Exception {
        Map<String, Scoring> scores = BlueprintMapper.mapBlueprintScoring(mockWorkbook, Collections.emptyMap());
        Scoring scoring = scores.get("SBAC-IAB-FIXED-G11M");
        assertThat(scoring.getRules().get(1).parameters().get(0).getValues().size(), is(1));
    }

    @Test
    public void shouldMapParameters() throws Exception {
        Map<String, Scoring> scores = BlueprintMapper.mapBlueprintScoring(mockWorkbook, Collections.emptyMap());
        Scoring scoring = scores.get("SBAC-IAB-FIXED-G11M");
        assertThat(scoring.getRules().stream().filter(r -> r.getName().equals("SBACTheta")).findFirst().get().parameters().size(), is(3));
    }

    @Test
    public void shouldEqualScoresFromDeserializedTestPackage() throws Exception {
        Map<String, Scoring> scores = BlueprintMapper.mapBlueprintScoring(mockWorkbook, Collections.emptyMap());
        Scoring scoring = scores.get("SBAC-IAB-FIXED-G11M");

        InputStream is = this.getClass().getResourceAsStream("/SBAC-IAB-FIXED-G11M-Winter-2017-2018-New.xml");
        TestPackage testPackage = this.xmlMapper.readValue(is, TestPackage.class);
        Scoring expectedScoring = testPackage.getBlueprintElement("SBAC-IAB-FIXED-G11M").orElseThrow(IllegalStateException::new).getScoring().orElseThrow(()-> new IllegalStateException());

        scoresEqual(expectedScoring, scoring);
    }
}