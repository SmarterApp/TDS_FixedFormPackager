package tds.packager.mapper;

import org.junit.Test;
import tds.testpackage.model.Dependency;
import tds.testpackage.model.Option;
import tds.testpackage.model.Tool;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


public class ToolMapperTest extends MapperBaseTest {

    @Test
    public void shouldMapTools() {
        List<Tool> tools = ToolMapper.map(mockWorkbook, "SBAC-IAB-FIXED-G11M-AlgLin");
        assertThat(tools).hasSize(11);

        Tool maskingTool = tools.stream()
                .filter(tool -> tool.getName().equals("Masking"))
                .findFirst()
                .get();

        assertThat(maskingTool.required()).isTrue();
        assertThat(maskingTool.getStudentPackageFieldName()).isEmpty();
        assertThat(maskingTool.getDisableOnGuest().get()).isEqualTo("false");
        assertThat(maskingTool.allowMultipleOptions()).isFalse();
        assertThat(maskingTool.allowChange()).isTrue();
        assertThat(maskingTool.options()).hasSize(2);

        Option offOption = maskingTool.options().get(0);
        assertThat(offOption.getCode()).isEqualTo("TDS_Masking0");
        assertThat(offOption.getLabel().get()).isEqualTo("Masking Not Available");
        assertThat(offOption.getSortOrder()).isEqualTo(0);
        assertThat(offOption.dependencies()).hasSize(3);

        Optional<Dependency> brailleOffDependency = offOption.dependencies().stream()
                .filter(dep -> dep.getIfToolCode().equals("ENU-Braille"))
                .findFirst();

        assertThat(brailleOffDependency).isPresent();
        assertThat(brailleOffDependency.get().getIfToolType()).isEqualTo("Language");
        assertThat(brailleOffDependency.get().defaultValue()).isFalse();

        Option onOption = maskingTool.options().get(1);
        assertThat(onOption.getCode()).isEqualTo("TDS_Masking1");
        assertThat(onOption.getLabel().get()).isEqualTo("Masking Available");
        assertThat(onOption.getSortOrder()).isEqualTo(1);
        assertThat(onOption.dependencies()).hasSize(2);

        Optional<Dependency> brailleOnDependency = onOption.dependencies().stream()
                .filter(dep -> dep.getIfToolCode().equals("ENU-Braille"))
                .findFirst();

        assertThat(brailleOnDependency).isNotPresent();

        Optional<Dependency> enuOnDependency = onOption.dependencies().stream()
                .filter(dep -> dep.getIfToolCode().equals("ENU"))
                .findFirst();

        assertThat(enuOnDependency).isPresent();
        assertThat(enuOnDependency.get().getIfToolType()).isEqualTo("Language");
        assertThat(enuOnDependency.get().defaultValue()).isTrue();
    }
}
