package tds.packager.mapper;

import org.junit.Test;
import tds.testpackage.model.Segment;
import tds.testpackage.model.SegmentBlueprintElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SegmentMapperTest extends MapperBaseTest {

    @Test
    public void shouldMapSegmentsForAssessment() {
        List<Segment> segments = SegmentMapper.map(mockWorkbook, "SBAC-IAB-FIXED-G11M-AlgLin", this.itemMetadata);
        assertThat(segments).hasSize(2);

        Segment segment1 = segments.get(0);
        assertThat(segment1.getId()).isEqualTo("SBAC-IAB-FIXED-G11M-AlgLinearFun-NoCalc");
        assertThat(segment1.position()).isEqualTo(1);
        assertThat(segment1.entryApproval()).isFalse();
        assertThat(segment1.exitApproval()).isFalse();
        assertThat(segment1.getLabel().get()).isEqualTo("SBAC-IAB-FIXED-G11M-AlgLinearFun-NoCalc");
        assertThat(segment1.getAlgorithmType()).isEqualTo("fixedform");
        assertThat(segment1.getAlgorithmImplementation()).isEqualTo("FAIRWAY FIXEDFORM");

        List<SegmentBlueprintElement> seg1Elements = segment1.segmentBlueprint();
        assertThat(seg1Elements).hasSize(5);

        Segment segment2 = segments.get(1);
        assertThat(segment2.getId()).isEqualTo("SBAC-IAB-FIXED-G11M-AlgLinearFun-Calc");
        assertThat(segment2.position()).isEqualTo(2);
        assertThat(segment2.entryApproval()).isFalse();
        assertThat(segment2.exitApproval()).isFalse();
        assertThat(segment2.getLabel().get()).isEqualTo("SBAC-IAB-FIXED-G11M-AlgLinearFun-Calc");
        assertThat(segment2.getAlgorithmType()).isEqualTo("fixedform");
        assertThat(segment2.getAlgorithmImplementation()).isEqualTo("FAIRWAY FIXEDFORM");

        List<SegmentBlueprintElement> seg2Elements = segment2.segmentBlueprint();
        assertThat(seg2Elements).hasSize(23);
        SegmentBlueprintElement segmentBpEl = seg2Elements.stream()
                .filter(bpEl -> bpEl.getIdRef().equals("SBAC-IAB-FIXED-G11M-AlgLinearFun-Calc"))
                .findFirst()
                .get();

        assertThat(segmentBpEl.getMinExamItems()).isEqualTo(0);
        assertThat(segmentBpEl.getMaxExamItems()).isEqualTo(12);

    }
}
