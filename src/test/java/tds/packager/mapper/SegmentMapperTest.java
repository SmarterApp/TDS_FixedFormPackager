package tds.packager.mapper;

import org.junit.Test;
import tds.testpackage.model.Segment;
import tds.testpackage.model.SegmentBlueprintElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SegmentMapperTest extends MapperBaseTest {

    @Test
    public void shouldMapSegmentsForAssessmentIAB() {
        List<Segment> segments = SegmentMapper.map(mockIABWorkbook, "SBAC-IAB-FIXED-G11M-AlgLin", itemMetadataIAB);
        assertThat(segments).hasSize(2);

        Segment segment1 = segments.get(0);
        assertThat(segment1.getId()).isEqualTo("SBAC-IAB-FIXED-G11M-AlgLinearFun-NoCalc-MATH-11");
        assertThat(segment1.position()).isEqualTo(1);
        assertThat(segment1.entryApproval()).isFalse();
        assertThat(segment1.exitApproval()).isFalse();
        assertThat(segment1.getLabel().get()).isEqualTo("(SBAC)SBAC-IAB-FIXED-G11M-AlgLinearFun-NoCalc-MATH-11-Winter-2017-2018");
        assertThat(segment1.getAlgorithmType()).isEqualTo("fixedform");
        assertThat(segment1.getAlgorithmImplementation()).isEqualTo("FAIRWAY FIXEDFORM");

        List<SegmentBlueprintElement> seg1Elements = segment1.segmentBlueprint();
        assertThat(seg1Elements).hasSize(6);

        Segment segment2 = segments.get(1);
        assertThat(segment2.getId()).isEqualTo("SBAC-IAB-FIXED-G11M-AlgLinearFun-Calc-MATH-11");
        assertThat(segment2.position()).isEqualTo(2);
        assertThat(segment2.entryApproval()).isFalse();
        assertThat(segment2.exitApproval()).isFalse();
        assertThat(segment2.getLabel().get()).isEqualTo("(SBAC)SBAC-IAB-FIXED-G11M-AlgLinearFun-Calc-MATH-11-Winter-2017-2018");
        assertThat(segment2.getAlgorithmType()).isEqualTo("fixedform");
        assertThat(segment2.getAlgorithmImplementation()).isEqualTo("FAIRWAY FIXEDFORM");

        List<SegmentBlueprintElement> seg2Elements = segment2.segmentBlueprint();
        assertThat(seg2Elements).hasSize(23);
        SegmentBlueprintElement segmentBpEl = seg2Elements.stream()
                .filter(bpEl -> bpEl.getIdRef().equals("SBAC-IAB-FIXED-G11M-AlgLinearFun-Calc-MATH-11"))
                .findFirst()
                .get();

        assertThat(segmentBpEl.getMinExamItems()).isEqualTo(0);
        assertThat(segmentBpEl.getMaxExamItems()).isEqualTo(12);
    }

    @Test
    public void shouldMapSegmentsForAssessmentsICA() {
        List<Segment> segments = SegmentMapper.map(mockICAWorkbook, "SBAC-ICA-FIXED-G11M", itemMetadataICA);
        assertThat(segments).hasSize(2);

        Segment segment1 = segments.get(0);
        assertThat(segment1.getId()).isEqualTo("SBAC-ICA-FIXED-G11M-Calc");
        assertThat(segment1.position()).isEqualTo(1);
        assertThat(segment1.entryApproval()).isFalse();
        assertThat(segment1.exitApproval()).isFalse();
        assertThat(segment1.getLabel().get()).isEqualTo("SBAC-ICA-FIXED-G11M-Calc");
        assertThat(segment1.getAlgorithmType()).isEqualTo("fixedform");
        assertThat(segment1.getAlgorithmImplementation()).isEqualTo("FAIRWAY FIXEDFORM");

        List<SegmentBlueprintElement> seg1Elements = segment1.segmentBlueprint();
        assertThat(seg1Elements).hasSize(43);

        Segment segment2 = segments.get(1);
        assertThat(segment2.getId()).isEqualTo("SBAC-ICA-FIXED-G11M-NoCalc");
        assertThat(segment2.position()).isEqualTo(2);
        assertThat(segment2.entryApproval()).isFalse();
        assertThat(segment2.exitApproval()).isFalse();
        assertThat(segment2.getLabel().get()).isEqualTo("SBAC-ICA-FIXED-G11M-NoCalc");
        assertThat(segment2.getAlgorithmType()).isEqualTo("fixedform");
        assertThat(segment2.getAlgorithmImplementation()).isEqualTo("FAIRWAY FIXEDFORM");

        List<SegmentBlueprintElement> seg2Elements = segment2.segmentBlueprint();
        assertThat(seg2Elements).hasSize(15);
        SegmentBlueprintElement segmentBpEl = seg2Elements.stream()
                .filter(bpEl -> bpEl.getIdRef().equals("SBAC-ICA-FIXED-G11M-NoCalc"))
                .findFirst()
                .get();

        assertThat(segmentBpEl.getMinExamItems()).isEqualTo(0);
        assertThat(segmentBpEl.getMaxExamItems()).isEqualTo(6);

    }
}
