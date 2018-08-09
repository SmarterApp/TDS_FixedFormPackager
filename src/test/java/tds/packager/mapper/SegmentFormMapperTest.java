package tds.packager.mapper;

import org.junit.Test;
import tds.testpackage.model.Segment;
import tds.testpackage.model.SegmentForm;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class SegmentFormMapperTest extends MapperBaseTest {
    @Test
    public void shouldMapSegmentsForAssessment() {
        /*
        List<Segment> segments = SegmentMapper.map(mockWorkbook, "SBAC-IAB-FIXED-G11M-AlgLin", this.itemMetadata);
        assertThat(segments).hasSize(2);

        List<SegmentForm> segmentForms1 = SegmentFormMapper.map(mockWorkbook, segments.get(0).getId(), this.itemMetadata, "SBAC-IAB-FIXED-G11M-AlgLin");
        assertThat(segmentForms1).hasSize(1);
        SegmentForm segmentForm1 = segmentForms1.get(0);
        assertThat(segmentForm1.getId()).isEqualTo("SBAC-IAB-FIXED-G11M-AlgLinearFun-NoCalc");
        */
    }
}
