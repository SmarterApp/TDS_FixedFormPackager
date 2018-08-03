package tds.packager.mapper;

import org.junit.Test;
import tds.testpackage.model.TestPackage;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class TestPackageMapperTest extends MapperBaseTest {
    @Test
    public void shouldMapTestPackage() {
        TestPackage testPackage = TestPackageMapper.map(mockWorkbook, new HashMap<>());
        assertThat(testPackage).isNotNull();
        assertThat(testPackage.getId()).isEqualTo("SBAC-IAB-FIXED-G11M");
        assertThat(testPackage.getPublisher()).isEqualTo("SBAC");
        assertThat(testPackage.getSubject()).isEqualTo("MATH");
        assertThat(testPackage.getType()).isEqualTo("interim");
        assertThat(testPackage.getSubType()).isEmpty();
        assertThat(testPackage.getAcademicYear()).isEqualTo("Winter-2017-2018");
        assertThat(testPackage.getBankKey()).isEqualTo(200);
    }
}
