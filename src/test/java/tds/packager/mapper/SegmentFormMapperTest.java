package tds.packager.mapper;

import org.junit.Test;
import tds.testpackage.model.*;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class SegmentFormMapperTest extends MapperBaseTest {
    @Test
    public void shouldMapSegmentsForAssessment() {

        List<Segment> segments = SegmentMapper.map(mockIABWorkbook, "SBAC-IAB-FIXED-G11M-AlgLin", itemMetadataIAB);
        assertThat(segments).hasSize(2);

        List<SegmentForm> segmentForms1 = SegmentFormMapper.map(mockIABWorkbook, segments.get(0).getId(), itemMetadataIAB, "SBAC-IAB-FIXED-G11M-AlgLin");
        assertThat(segmentForms1).hasSize(1);
        SegmentForm segmentForm1 = segmentForms1.get(0);
        assertThat(segmentForm1.getId()).isEqualTo("IAB-G11M-AlgLin-NoCalc-2018 ENG");



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

        List<PoolProperty> poolProperties1 = ig1Item1.poolProperties();
        assertThat(poolProperties1).contains(PoolProperty.builder().setName("Answer Key").setValue("EQ").build());
        assertThat(poolProperties1).contains(PoolProperty.builder().setName("Answer Key (Part II)").setValue("NA").build());
        assertThat(poolProperties1).contains(PoolProperty.builder().setName("ASL").setValue("Y").build());
        assertThat(poolProperties1).contains(PoolProperty.builder().setName("Braille").setValue("BRF").build());
        assertThat(poolProperties1).contains(PoolProperty.builder().setName("Grade").setValue("11").build());
        assertThat(poolProperties1).contains(PoolProperty.builder().setName("Scoring Engine").setValue("Automatic with Machine Rubric").build());

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
        assertThat(blueprintReferences1.get(4).getIdRef()).isEqualTo("1|P|TS03|I-11");

        List <Presentation> item1Presentations = ig1Item1.getPresentations();
        assertThat(item1Presentations).hasSize(3);
        assertThat(item1Presentations).contains(Presentation.builder().setCode("ENU").setLabel("English").build());
        assertThat(item1Presentations).contains(Presentation.builder().setCode("ENU-Braille").setLabel("Braille").build());
        assertThat(item1Presentations).contains(Presentation.builder().setCode("ESN").setLabel("Spanish").build());

        ItemGroup ig2 = itemGroups1.get(1);
        assertThat(ig2.getId()).isEqualTo("83838");
        ItemGroup ig3 = itemGroups1.get(2);
        assertThat(ig3.getId()).isEqualTo("12164");

        // 2nd segment (Only contains 1 SegmentForm

        List<SegmentForm> segmentForms2 = SegmentFormMapper.map(mockIABWorkbook, segments.get(1).getId(), itemMetadataIAB, "SBAC-IAB-FIXED-G11M-AlgLin-MATH-11");
        assertThat(segmentForms2).hasSize(1);
        SegmentForm segmentForm2 = segmentForms2.get(0);
        assertThat(segmentForm2.getId()).isEqualTo("IAB-G11M-AlgLin-Calc-2018 ENG");
        assertThat(segmentForm2.getCohort()).isEqualTo("Default");


        assertThat(segmentForm2.getPresentations()).hasSize(3);
        assertThat(segmentForm2.getPresentations()).contains(Presentation.builder().setCode("ENU").setLabel("English").build());
        assertThat(segmentForm2.getPresentations()).contains(Presentation.builder().setCode("ENU-Braille").setLabel("Braille").build());
        assertThat(segmentForm2.getPresentations()).contains(Presentation.builder().setCode("ESN").setLabel("Spanish").build());
        assertThat(segmentForm2.itemGroups()).hasSize(12);
        //full proper ordering of the ItemGroups / Items and that ItemGroup Id is the same as the Item Id (because single item itemgroups)
        assertThat(segmentForm2.itemGroups().get(0).getId()).isEqualTo("501");
        assertThat(segmentForm2.itemGroups().get(0).getId()).isEqualTo(segmentForm2.itemGroups().get(0).items().get(0).getId());
        assertThat(segmentForm2.itemGroups().get(1).getId()).isEqualTo("35334");
        assertThat(segmentForm2.itemGroups().get(1).getId()).isEqualTo(segmentForm2.itemGroups().get(1).items().get(0).getId());
        assertThat(segmentForm2.itemGroups().get(2).getId()).isEqualTo("33727");
        assertThat(segmentForm2.itemGroups().get(2).getId()).isEqualTo(segmentForm2.itemGroups().get(2).items().get(0).getId());
        assertThat(segmentForm2.itemGroups().get(3).getId()).isEqualTo("12327");
        assertThat(segmentForm2.itemGroups().get(3).getId()).isEqualTo(segmentForm2.itemGroups().get(3).items().get(0).getId());
        assertThat(segmentForm2.itemGroups().get(4).getId()).isEqualTo("19513");
        assertThat(segmentForm2.itemGroups().get(4).getId()).isEqualTo(segmentForm2.itemGroups().get(4).items().get(0).getId());
        assertThat(segmentForm2.itemGroups().get(5).getId()).isEqualTo("20702");
        assertThat(segmentForm2.itemGroups().get(5).getId()).isEqualTo(segmentForm2.itemGroups().get(5).items().get(0).getId());
        assertThat(segmentForm2.itemGroups().get(6).getId()).isEqualTo("50197");
        assertThat(segmentForm2.itemGroups().get(6).getId()).isEqualTo(segmentForm2.itemGroups().get(6).items().get(0).getId());
        assertThat(segmentForm2.itemGroups().get(7).getId()).isEqualTo("32678");
        assertThat(segmentForm2.itemGroups().get(7).getId()).isEqualTo(segmentForm2.itemGroups().get(7).items().get(0).getId());
        assertThat(segmentForm2.itemGroups().get(8).getId()).isEqualTo("31336");
        assertThat(segmentForm2.itemGroups().get(8).getId()).isEqualTo(segmentForm2.itemGroups().get(8).items().get(0).getId());
        assertThat(segmentForm2.itemGroups().get(9).getId()).isEqualTo("11984");
        assertThat(segmentForm2.itemGroups().get(9).getId()).isEqualTo(segmentForm2.itemGroups().get(9).items().get(0).getId());
        assertThat(segmentForm2.itemGroups().get(10).getId()).isEqualTo("31344");
        assertThat(segmentForm2.itemGroups().get(10).getId()).isEqualTo(segmentForm2.itemGroups().get(10).items().get(0).getId());
        assertThat(segmentForm2.itemGroups().get(11).getId()).isEqualTo("30309");
        assertThat(segmentForm2.itemGroups().get(11).getId()).isEqualTo(segmentForm2.itemGroups().get(11).items().get(0).getId());
    }
}
