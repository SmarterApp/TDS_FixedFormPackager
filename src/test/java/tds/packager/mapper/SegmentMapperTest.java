package tds.packager.mapper;

import org.junit.Test;
import tds.testpackage.model.Segment;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SegmentMapperTest extends MapperBaseTest {
    @Test
    public void shouldMapSegmentsForAssessment() {
        List<Segment> segments = SegmentMapper.map(mockWorkbook, "SBAC-IAB-FIXED-G11M-AlgLin", new HashMap<>());
        assertThat(segments).hasSize(2);

        Segment segment1 = segments.get(0);
        assertThat(segment1.getId()).isEqualTo("SBAC-IAB-FIXED-G11M-AlgLinearFun-Calc");
        assertThat(segment1.position()).isEqualTo(1);
        assertThat(segment1.entryApproval()).isFalse();
        assertThat(segment1.exitApproval()).isFalse();
        assertThat(segment1.getLabel().get()).isEqualTo("SBAC-IAB-FIXED-G11M-AlgLinearFun-Calc");
        assertThat(segment1.getAlgorithmType()).isEqualTo("fixedform");
        assertThat(segment1.getAlgorithmImplementation()).isEqualTo("FAIRWAY FIXEDFORM");

        Segment segment2 = segments.get(1);
        assertThat(segment2.getId()).isEqualTo("SBAC-IAB-FIXED-G11M-AlgLinearFun-NoCalc");
        assertThat(segment2.position()).isEqualTo(2);
        assertThat(segment2.entryApproval()).isFalse();
        assertThat(segment2.exitApproval()).isFalse();
        assertThat(segment2.getLabel().get()).isEqualTo("SBAC-IAB-FIXED-G11M-AlgLinearFun-NoCalc");
        assertThat(segment2.getAlgorithmType()).isEqualTo("fixedform");
        assertThat(segment2.getAlgorithmImplementation()).isEqualTo("FAIRWAY FIXEDFORM");

        //TODO: segment blueprint assertions
    }
}
