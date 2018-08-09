package tds.packager.mapper;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tds.itemrenderer.data.xml.itemrelease.Attrib;
import tds.itemrenderer.data.xml.itemrelease.Attriblist;
import tds.itemrenderer.data.xml.itemrelease.Itemrelease;
import tds.packager.model.gitlab.GitLabItemMetaData;
import tds.packager.model.gitlab.ItemMetaDataUtil;
import tds.packager.model.gitlab.ItemreleaseUnmarshaller;
import tds.packager.model.xlsx.TestPackageSheet;
import tds.packager.model.xlsx.TestPackageSheetNames;
import tds.packager.model.xlsx.TestPackageWorkbook;
import tds.teacherhandscoring.model.TeacherHandScoring;
import tds.testpackage.model.*;
import org.springframework.util.StringUtils;

import java.util.*;

public class SegmentFormMapper {
    private static final String EMPTY_STRING = "";

    public static List<SegmentForm> map(final TestPackageWorkbook workbook, final String segmentId,
                                        final Map<String, GitLabItemMetaData> itemMetaData, final String assessmentId) {
        final List<SegmentForm> segmentForms = new ArrayList<>();
        final TestPackageSheet sheet = workbook.getSheet(TestPackageSheetNames.SEGMENT_FORMS);
        final int cols = sheet.getTotalNumberOfInputColumns();
        final ItemreleaseUnmarshaller unmarshaller = new ItemreleaseUnmarshaller();

        LinkedHashSet<String> segFormIds = new LinkedHashSet();
        HashMap<String,Set<String>> segFormPresentations = new HashMap<>();
        LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> itemGroups = new LinkedHashMap<>();
        HashMap<String, Item> items = new HashMap<>();

        // Iterate over all the columns / items
        for(int i = 0; i < cols; i++) {
            final Map<String, String> column = sheet.getInputVariableValuesMap(i);
            if (!segmentId.equals(column.get("SegmentId"))) {
                // Skip this column if it does not correspond to the segment ID we are dealing with
                continue;
            }
            String segFormId = column.get("SegmentFormId");
            segFormIds.add(segFormId);
            String itemId = column.get("ItemId");
            System.out.println("ItemId: " + itemId);
            System.out.println("SegmentFormId: " + segFormId);
            GitLabItemMetaData gitMeta = itemMetaData.get(itemId);
            ItemMetaDataUtil itemMetaDataUtil = new ItemMetaDataUtil(gitMeta.getItemMetadata());
            Itemrelease itemrelease = unmarshaller.unmarshallItem(gitMeta.getItemReleaseMetadata(), itemId);

            NodeList stimNodes = itemMetaDataUtil.xpathQuery("metadata/smarterAppMetadata/AssociatedStimulus");
            String stimulusId = stimNodes.getLength() == 1 ? stimNodes.item(0).getTextContent() : EMPTY_STRING;

            System.out.println("Stimulus ID =" + stimulusId );

            if(!itemGroups.containsKey(segFormId)) {
                ArrayList<String> itemList = new ArrayList<>();
                itemList.add(itemId);
                LinkedHashMap<String, ArrayList<String>> stimulusItemList = new LinkedHashMap<>();
                stimulusItemList.put(stimulusId, itemList);
                itemGroups.put(segFormId, stimulusItemList);
            } else {
                if(!itemGroups.get(segFormId).containsKey(stimulusId)) {
                    ArrayList<String> itemList = new ArrayList<>();
                    itemList.add(itemId);
                    itemGroups.get(segFormId).put(stimulusId, itemList);
                } else {
                    itemGroups.get(segFormId).get(stimulusId).add(itemId);
                }
            }

            HashSet itemPresentations = new HashSet();
            String english = column.get("ItemEnglishPresentation");
            String braille = column.get("ItemBraillePresentation");
            String spanish = column.get("ItemSpanishPresentation");

            if(!segFormPresentations.containsKey(segFormId)) {
                segFormPresentations.put(segFormId, new HashSet<>());
            }
            if(english.equalsIgnoreCase("TRUE")) {
                segFormPresentations.get(segFormId).add("English");
                itemPresentations.add("English");
            }
            if(braille.equalsIgnoreCase("TRUE")) {
                segFormPresentations.get(segFormId).add("Braille");
                itemPresentations.add("Braille");
            }
            if(spanish.equalsIgnoreCase("TRUE")) {
                segFormPresentations.get(segFormId).add("Spanish");
                itemPresentations.add("Spanish");
            }


            items.put(itemId, Item.builder()
                    .setId(itemId)
                    .setType(itemrelease.getItemPassage().getFormat().toUpperCase())
                    .setActive(Optional.of("true"))
                    .setAdministrationRequired(Optional.of("true"))
                    .setHandScored(
                            StringUtils.isEmpty(column.get("ItemHandScored"))
                                    ? Optional.of("false")
                                    : Optional.of(column.get("ItemHandScored"))
                    )
                    .setDoNotScore(
                            StringUtils.isEmpty(column.get("ItemDoNotScore"))
                                    ? Optional.of("false")
                                    : Optional.of(column.get("ItemDoNotScore"))
                    )
                    .setTeacherHandScoring(getTeacherHandScoring(column))
                    .setItemScoreDimensions(getItemScoreDimensions(column, itemMetaDataUtil))
                    .setBlueprintReferences(getBlueprintReferences(itemMetaDataUtil.getPrimaryStandard(), assessmentId))
                    .setPoolProperties(getPoolProperties(itemrelease, itemMetaDataUtil))
                    .setPresentations(getPresentations(itemPresentations))
                    .build());


        }

        System.out.println(itemGroups.entrySet());
        //List<ItemGroup> itemGroupList = getItemGroups(itemGroups);

        segFormIds.forEach((segFormId)->{
            segmentForms.add(
                    SegmentForm.builder()
                            .setId(segFormId)
                            .setCohort(getCohort(segFormId, sheet))
                            .setPresentations(getPresentations(segFormPresentations.get(segFormId)))
                            .setItemGroups(getItemGroups(segFormId, itemGroups.get(segFormId), items))
                            .build());
        });

        System.out.println("returning the segmentforms:: " + segmentForms.toString());

        return segmentForms;
    }

    private static Optional<TeacherHandScoring> getTeacherHandScoring(final Map<String, String> column) {
        if (column.get("THSDimensions").isEmpty() && column.get("THSExemplar").isEmpty()
                && column.get("THSTrainingGuide").isEmpty() && column.get("THSLayout").isEmpty()
                && column.get("THSDescription").isEmpty() && column.get("THSPassage").isEmpty()
                && column.get("THSItemName").isEmpty()
        ) {
            return Optional.empty();
        }
        TeacherHandScoring teacherHandScoring = TeacherHandScoring.builder()
                .setDimensions(
                        Optional.of(column.get("THSDimensions"))
                )
                .setExemplar(column.get("THSExemplar"))
                .setTrainingGuide(column.get("THSTrainingGuide"))
                .setLayout(Optional.of(column.get("THSLayout")))
                .setDescription(column.get("THSDescription"))
                .setPassage(column.get("THSPassage"))
                .setItemName(column.get("THSItemName"))
                .build();

        return Optional.of(teacherHandScoring);
    }

    private static String fixMeasurementModelFormat(String modelType) {
        if (modelType != null && modelType.equalsIgnoreCase("IRT3PLN"))
        {
            return "IRT3PLn";
        }
        return modelType;
    }

    private static List<PoolProperty> getPoolProperties(Itemrelease itemrelease, ItemMetaDataUtil itemMetaDataUtil) {
        final List<PoolProperty> poolProperties = new ArrayList<>();
        final List<Attrib> attrList = itemrelease.getItemPassage().getAttriblist().getAttrib();
        final Attrib ansKey = attrList.stream().filter(attrib -> attrib.getAttid().equals("itm_att_Answer Key")).findFirst().get();
        poolProperties.add(PoolProperty.builder()
                .setName("Answer Key").setValue(ansKey.getVal())
                .build());
        //"Appropriate for Hearing Impaired" ??
        //ASL ??
        //Braille ??

        poolProperties.add(PoolProperty.builder()
                .setName("Depth of Knowledge").setValue(itemMetaDataUtil.getDepthOfKnowledge())
                .build());
        // Difficulty Category ??

        poolProperties.add(PoolProperty.builder()
                .setName("Grade").setValue(itemMetaDataUtil.getIntendedGrade())
                .build());
        // Rubric Source ??
        poolProperties.add(PoolProperty.builder()
                .setName("Scoring Engine").setValue(itemMetaDataUtil.getScoringEngine())
                .build());
        /*
          <PoolProperty name="Rubric Source" value="Answer Key"/>
          <PoolProperty name="Spanish Translation" value="N"/>
          <PoolProperty name="Test Pool" value="Interim"/>
         */

        return poolProperties;
    }

    private static List<ItemScoreDimension> getItemScoreDimensions(final Map<String, String> column, final ItemMetaDataUtil itemMetaDataUtil) {
        final List<ItemScoreDimension> itemScoreDimensions = new ArrayList<>();
        int i = 1;

        // try to get the data from the spreadsheet
        if (!column.get("MeasurementModel_" + i).isEmpty()) {
            while (column.containsKey("MeasurementModel_" + i) && !column.get("MeasurementModel_" + i).isEmpty()) {
                String modelType = fixMeasurementModelFormat(column.get("MeasurementModel_" + i));
                String dimension = column.get("Dimension_" + i);
                int scorePoints = Integer.parseInt(column.get("ScorePoints_" + i));
                double weight = Double.parseDouble(column.get("Weight_" + i));
                List<ItemScoreParameter> itemScoreParameters = new ArrayList<>();
                final String[] paramNames = {"a", "b", "b0", "b1", "b2", "b3", "b4", "c"};
                int fi = i;
                Arrays.asList(paramNames).forEach((param) -> {
                    final String paramname = param + "_" + fi;
                    String val = column.get(paramname);
                    if (!StringUtils.isEmpty(val)) {
                        itemScoreParameters.add(
                                ItemScoreParameter.builder()
                                        .setMeasurementParameter(param)
                                        .setValue(Double.parseDouble(val))
                                        .build()
                        );
                    }
                });
                itemScoreDimensions.add(ItemScoreDimension.builder()
                        .setDimension(Optional.of(dimension))
                        .setMeasurementModel(modelType)
                        .setScorePoints(scorePoints)
                        .setItemScoreParameters(itemScoreParameters)
                        .setWeight(weight)
                        .build());
                i++;
            }
            return itemScoreDimensions;
        } else { //if nothing in the measurementmodel field then fetch from metadata.xml
            String modelType = fixMeasurementModelFormat(itemMetaDataUtil.getIrtElement("IrtModelType"));

            String dimension = itemMetaDataUtil.getIrtElement("IrtDimensionPurpose");
            int scorePoints = Integer.parseInt(itemMetaDataUtil.getIrtElement("IrtScore"));
            double weight = Double.parseDouble(itemMetaDataUtil.getIrtElement("IrtWeight"));
            NodeList irtParameterNodes = itemMetaDataUtil.getIrtParameters();
            List<ItemScoreParameter> itemScoreParameters = new ArrayList<>();
            for (int n = 0; n < irtParameterNodes.getLength(); n++) {
                Element node = (Element) irtParameterNodes.item(n);
                itemScoreParameters.add(
                        ItemScoreParameter.builder()
                                .setMeasurementParameter(node.getElementsByTagName("Name").item(0).getTextContent())
                                .setValue(Double.parseDouble(node.getElementsByTagName("Value").item(0).getTextContent()))
                                .build());
            }
            itemScoreDimensions.add(ItemScoreDimension.builder()
                    .setDimension(Optional.of(dimension))
                    .setMeasurementModel(modelType)
                    .setScorePoints(scorePoints)
                    .setItemScoreParameters(itemScoreParameters)
                    .setWeight(weight)
                    .build());
            return itemScoreDimensions;
        }
    }

    private static List<BlueprintReference> getBlueprintReferences(final String standard, final String assessmentId) {
        //SBAC-MA-v6:1|P|TS06|M - > 1|P|TS06|M
        final List<BlueprintReference> blueprintReferences = new ArrayList<>();
        final String bottomLevelBpRef = standard.split(":")[1];

        // If its not a target string (containing a pipe), then simply return this id
        if (!bottomLevelBpRef.contains("|")) {
            blueprintReferences.add(BlueprintReference.builder().setIdRef(bottomLevelBpRef).build());
            return blueprintReferences;
        }
        blueprintReferences.add(BlueprintReference.builder().setIdRef(assessmentId).build());
        List<String> refIds = new ArrayList<>();

        final String[] targetSections = bottomLevelBpRef.split("\\|");

        for (int i = 0; i < targetSections.length; i++) {
            if (i == 0) {
                refIds.add(targetSections[i]);
            } else {
                StringBuilder id = new StringBuilder();
                for (int j = 0; j <= i; j++) {
                    if (j > 0) {
                        id.append("|");
                    }
                    id.append(targetSections[j]);
                }

                refIds.add(id.toString());
            }
        }
        refIds.forEach(refId->{
            if(!refId.contains(".")){
                System.out.println("BpRef: " + refId);
                blueprintReferences.add(BlueprintReference.builder().setIdRef(refId).build());
            }
        });
        return blueprintReferences;
    }

    private static String getCohort(final String segmentFormId, final TestPackageSheet segmentFormsSheet) {
        for (int i = 0; i <= segmentFormsSheet.getTotalNumberOfInputColumns(); i++) {
            if (segmentFormsSheet.getString("SegmentFormId", i).equals(segmentFormId))
               return segmentFormsSheet.getString("SegmentFormCohort", i);
        }
        return EMPTY_STRING;
    }

    private static List<Presentation> getPresentations(Set<String> presentationStrings) {
        final List<Presentation> presentations = new ArrayList<>();
        presentationStrings.forEach( presentation-> {
            if(presentation.equalsIgnoreCase("English")) {
                presentations.add(Presentation.builder()
                        .setCode("ENU")
                        .setLabel("English")
                        .build());
            }
            if(presentation.equalsIgnoreCase("Spanish")) {
                presentations.add(Presentation.builder()
                        .setCode("ESN")
                        .setLabel("Spanish")
                        .build());
            }
            if(presentation.equalsIgnoreCase("Braille")) {
                presentations.add(Presentation.builder()
                        .setCode("ENU-Braille")
                        .setLabel("Braille")
                        .build());
            }
        });
        return presentations;
    }

    private static List<ItemGroup> getItemGroups(String segFormId , HashMap<String, ArrayList<String>> itemGroup, HashMap<String, Item> items) {
        final List<ItemGroup> itemGroups = new ArrayList<>();
            System.out.println("SegmentFormId: " + segFormId);
            itemGroup.forEach((stimId, itemList) -> {
                System.out.println("Stimulus ID: " + stimId);
                List <Item> itemsList= new ArrayList<>();
                itemList.forEach((itemId)->{
                    System.out.println("item: " + itemId);
                    itemsList.add(items.get(itemId));
                });
                itemGroups.add(ItemGroup.builder().setId(stimId).setStimulus(Optional.of(Stimulus.builder().setId(stimId).build()))
                        .setItems(itemsList).build());
            });

        return itemGroups;
    }
}
