package tds.packager.mapper;

import org.junit.Test;
import tds.testpackage.model.Assessment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssessmentMapperTest extends MapperBaseTest {
    @Test
    public void shouldMapAssessments() {
        List<Assessment> assessments = AssessmentMapper.map(mockWorkbook, Arrays.asList("05", "06"), itemMetadata);
        assertThat(assessments).hasSize(1);
        Assessment assessment = assessments.get(0);
        assertThat(assessment.getId()).isEqualTo("SBAC-IAB-FIXED-G11M");
        assertThat(assessment.getLabel()).isEqualTo("High School Math - Algebra and Functions I (IAB)");
        assertThat(assessment.getGrades()).hasSize(2);
    }
}
