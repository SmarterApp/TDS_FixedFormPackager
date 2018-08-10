package tds.packager.mapper;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import tds.testpackage.model.*;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class BlueprintMapperTest extends MapperBaseTest {
    @Test
    public void shouldMapBlueprintForIAB() {
        final String testPackageId = "SBAC-IAB-FIXED-G11M";
        final Map<String, String> mockPerformanceLevelsMap = ImmutableMap.<String, String>builder()
                .put("PackageId", "SBAC-IAB-FIXED-G11M")
                .put("ScaledLo", "2.280000E+03")
                .put("ScaledPartition1", "2.543000E+03")
                .put("ScaledPartition2", "2.628000E+03")
                .put("ScaledPartition3", "2.718000E+03")
                .put("ScaledHi", "2.862000E+03")
                .build();

        List<BlueprintElement> blueprint = BlueprintMapper.map(testPackageId, mockWorkbook, mockPerformanceLevelsMap, itemMetadata);
        assertThat(blueprint).hasSize(5);

        BlueprintElement testBpEl = blueprint.stream()
                .filter(bpEl -> bpEl.getType().equals(BlueprintElementTypes.TEST))
                .findFirst()
                .get();

        assertThat(testBpEl.getId()).isEqualTo(testPackageId);
        assertThat(testBpEl.blueprintElements()).hasSize(2); // two segments
        assertThat(testBpEl.getScoring()).isPresent();

        Scoring scoring = testBpEl.getScoring().get();
        assertThat(scoring.getRules()).hasSize(5);
        assertThat(scoring.getRules().get(1).getName()).isEqualTo("SBACTheta");
        assertThat(scoring.getRules().get(1).getComputationOrder()).isEqualTo(20);
        assertThat(scoring.getRules().get(1).measure()).isEqualTo("ThetaScore");
        assertThat(scoring.getRules().get(1).parameters()).hasSize(3);

        Parameter param1 = scoring.getRules().get(1).parameters().get(0);
        assertThat(param1.getId()).isNotNull();
        assertThat(param1.getName()).isEqualTo("LOT");
        assertThat(param1.getType()).isEqualTo("double");
        assertThat(param1.getPosition()).isEqualTo(1);
        assertThat(param1.getValues()).hasSize(1);

        Value paramVal = param1.getValues().get(0);
        assertThat(paramVal.getValue()).isEqualTo("-2.9564");

        assertThat(scoring.performanceLevels()).hasSize(4);

        PerformanceLevel pl1 = scoring.performanceLevels().get(0);
        assertThat(pl1.getPLevel()).isEqualTo(1);
        assertThat(pl1.getScaledLo()).isEqualTo(2280D);
        assertThat(pl1.getScaledHi()).isEqualTo(2543D);

        BlueprintElement seg1BpEl = testBpEl.blueprintElements().get(0);
        assertThat(seg1BpEl.getId()).isEqualTo("SBAC-IAB-FIXED-G11M-AlgLinearFun-NoCalc");
        assertThat(seg1BpEl.getType()).isEqualTo(BlueprintElementTypes.SEGMENT);
        assertThat(seg1BpEl.blueprintElements()).isEmpty();

        BlueprintElement seg2BpEl = testBpEl.blueprintElements().get(1);
        assertThat(seg2BpEl.getId()).isEqualTo("SBAC-IAB-FIXED-G11M-AlgLinearFun-Calc");
        assertThat(seg2BpEl.getType()).isEqualTo(BlueprintElementTypes.SEGMENT);
        assertThat(seg2BpEl.blueprintElements()).isEmpty();

        BlueprintElement claimBpEl = blueprint.stream()
                .filter(bpEl -> bpEl.getId().equalsIgnoreCase("1"))
                .findFirst()
                .get();

        assertThat(claimBpEl.getType()).isEqualTo(BlueprintElementTypes.CLAIM);
        assertThat(claimBpEl.blueprintElements()).hasSize(1);

        assertThat(claimBpEl.blueprintElements().get(0).getId()).isEqualTo("1|P");
        assertThat(claimBpEl.blueprintElements().get(0).getType()).isEqualTo(BlueprintElementTypes.TARGET);
        assertThat(claimBpEl.blueprintElements().get(0).blueprintElements()).hasSize(3);
    }
}
