package tds.packager.mapper;

import org.junit.Test;
import tds.testpackage.model.*;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class SegmentFormMapperTest extends MapperBaseTest {
    @Test
    public void shouldMapSegmentsForAssessment() {

        List<Segment> segments = SegmentMapper.map(mockWorkbook, "SBAC-IAB-FIXED-G11M-AlgLin", this.itemMetadata);
        assertThat(segments).hasSize(2);

        List<SegmentForm> segmentForms1 = SegmentFormMapper.map(mockWorkbook, segments.get(0).getId(), this.itemMetadata, "SBAC-IAB-FIXED-G11M-AlgLin");
        assertThat(segmentForms1).hasSize(1);
        SegmentForm segmentForm1 = segmentForms1.get(0);
        assertThat(segmentForm1.getId()).isEqualTo("SBAC-IAB-FIXED-G11M-AlgLinearFun-NoCalc");

        List <Presentation> sf1Presentations = segmentForm1.getPresentations();
        assertThat(sf1Presentations).hasSize(3);
        assertThat(sf1Presentations).contains(Presentation.builder().setCode("ENU").setLabel("English").build());
        assertThat(sf1Presentations).contains(Presentation.builder().setCode("ENU-Braille").setLabel("Braille").build());
        assertThat(sf1Presentations).contains(Presentation.builder().setCode("ESN").setLabel("Spanish").build());

        List <ItemGroup> itemGroups1 = segmentForm1.itemGroups();
        assertThat(itemGroups1).hasSize(3);
        ItemGroup ig1 = itemGroups1.get(0);
        assertThat(ig1.getId()).isEqualTo("83834");
        assertThat(ig1.maxItems()).isEqualTo("ALL");
        assertThat(ig1.maxResponses()).isEqualTo("0");

        List<Item> ig1Items = ig1.items();
        assertThat(ig1Items).hasSize(1);
        Item ig1Item1 = ig1Items.get(0);
        assertThat(ig1Item1.active()).isTrue();
        assertThat(ig1Item1.fieldTest()).isFalse();
        assertThat(ig1Item1.administrationRequired()).isTrue();
        assertThat(ig1Item1.responseRequired()).isTrue();
        assertThat(ig1Item1.handScored()).isFalse();
        assertThat(ig1Item1.doNotScore()).isFalse();
        assertThat(ig1Item1.getId()).isEqualTo("83834");
        assertThat(ig1.getId()).isEqualTo(ig1Item1.getId());
        assertThat(ig1Item1.getType()).isEqualTo("EQ");

        List <ItemScoreDimension> itemScoreDimensions1 = ig1Item1.getItemScoreDimensions();
        assertThat(itemScoreDimensions1).hasSize(1);
        ItemScoreDimension itemScoreDimension1 = itemScoreDimensions1.get(0);
        assertThat(itemScoreDimension1.getWeight()).isEqualTo(1.0);
        assertThat(itemScoreDimension1.getScorePoints()).isEqualTo(1);
        assertThat(itemScoreDimension1.getMeasurementModel()).isEqualTo("IRT3PLn");

        List<ItemScoreParameter> params1 =  itemScoreDimension1.itemScoreParameters();
        assertThat(params1).hasSize(3);
        assertThat(params1).contains(ItemScoreParameter.builder().setMeasurementParameter("a").setValue(0.9329).build());
        assertThat(params1).contains(ItemScoreParameter.builder().setMeasurementParameter("b").setValue(0.5231).build());
        assertThat(params1).contains(ItemScoreParameter.builder().setMeasurementParameter("c").setValue(0.0).build());

        List<BlueprintReference> blueprintReferences1 = ig1Item1.getBlueprintReferences();
        assertThat(blueprintReferences1).hasSize(5);
        assertThat(blueprintReferences1.get(0).getIdRef()).isEqualTo("SBAC-IAB-FIXED-G11M-AlgLin");
        assertThat(blueprintReferences1.get(1).getIdRef()).isEqualTo("1");
        assertThat(blueprintReferences1.get(2).getIdRef()).isEqualTo("1|P");
        assertThat(blueprintReferences1.get(3).getIdRef()).isEqualTo("1|P|TS03");
        assertThat(blueprintReferences1.get(4).getIdRef()).isEqualTo("1|P|TS03|I");

        List <Presentation> item1Presentations = ig1Item1.getPresentations();
        assertThat(item1Presentations).hasSize(3);
        assertThat(item1Presentations).contains(Presentation.builder().setCode("ENU").setLabel("English").build());
        assertThat(item1Presentations).contains(Presentation.builder().setCode("ENU-Braille").setLabel("Braille").build());
        assertThat(item1Presentations).contains(Presentation.builder().setCode("ESN").setLabel("Spanish").build());

        ItemGroup ig2 = itemGroups1.get(1);
        assertThat(ig2.getId()).isEqualTo("83838");
        ItemGroup ig3 = itemGroups1.get(2);
        assertThat(ig3.getId()).isEqualTo("12164");

        List<SegmentForm> segmentForms2 = SegmentFormMapper.map(mockWorkbook, segments.get(1).getId(), this.itemMetadata, "SBAC-IAB-FIXED-G11M-AlgLin");
        assertThat(segmentForms2).hasSize(1);
        SegmentForm segmentForm2 = segmentForms2.get(0);
        assertThat(segmentForm2.getId()).isEqualTo("SBAC-IAB-FIXED-G11M-AlgLinearFun-Calc");
        assertThat(segmentForm2.getCohort()).isEqualTo("Default");


        assertThat(segmentForm2.getPresentations()).hasSize(3);
        assertThat(segmentForm2.itemGroups()).hasSize(12);
        assertThat(segmentForm2.itemGroups().get(0).getId()).isEqualTo("501");
        assertThat(segmentForm2.itemGroups().get(11).getId()).isEqualTo("30309");

    }
}
