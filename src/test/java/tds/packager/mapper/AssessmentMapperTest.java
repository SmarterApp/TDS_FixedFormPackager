package tds.packager.mapper;

import org.junit.Test;
import tds.testpackage.model.Assessment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssessmentMapperTest extends MapperBaseTest {
    @Test
    public void shouldMapAssessmentIAB() {
        List<Assessment> assessments = AssessmentMapper.map(mockIABWorkbook, Arrays.asList("05", "06"), itemMetadataIAB);
        assertThat(assessments).hasSize(1);
        Assessment assessment = assessments.get(0);
        assertThat(assessment.getId()).isEqualTo("SBAC-IAB-FIXED-G11M");
        assertThat(assessment.getLabel()).isEqualTo("High School Math - Algebra and Functions I (IAB)");
        assertThat(assessment.getGrades()).hasSize(2);
    }

    @Test
    public void shouldMapAssessmentsICA() {
        List<Assessment> assessments = AssessmentMapper.map(mockICAWorkbook, Arrays.asList("05", "06"), itemMetadataICA);
        assertThat(assessments).hasSize(2);
        Assessment assessment1 = assessments.get(0);
        assertThat(assessment1.getId()).isEqualTo("SBAC-ICA-FIXED-G11M");
        assertThat(assessment1.getLabel()).isEqualTo("High School Math Interim Test (ICA)");
        assertThat(assessment1.getGrades()).hasSize(2);
        Assessment assessment2 = assessments.get(1);
        assertThat(assessment2.getId()).isEqualTo("SBAC-ICA-FIXED-G11M-Perf-TeenDrivingRestricitons");
        assertThat(assessment2.getLabel()).isEqualTo("High School Math Performance Task - Teen Driving Restrictions (ICA)");
        assertThat(assessment2.getGrades()).hasSize(2);
    }
}
