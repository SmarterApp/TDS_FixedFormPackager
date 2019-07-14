package tds.packager.mapper;

import com.google.common.collect.ImmutableMap;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import tds.itemrenderer.data.xml.itemrelease.Attrib;
import tds.itemrenderer.data.xml.itemrelease.Itemrelease;
import tds.packager.model.gitlab.GitLabItemMetaData;
import tds.packager.model.gitlab.ItemMetaDataUtil;
import tds.packager.model.gitlab.ItemreleaseUnmarshaller;
import tds.packager.model.xlsx.TestPackageSheet;
import tds.packager.model.xlsx.TestPackageSheetNames;
import tds.packager.model.xlsx.TestPackageWorkbook;
import tds.teacherhandscoring.model.TeacherHandScoring;
import tds.testpackage.model.BlueprintReference;
import tds.testpackage.model.Item;
import tds.testpackage.model.ItemGroup;
import tds.testpackage.model.ItemScoreDimension;
import tds.testpackage.model.ItemScoreParameter;
import tds.testpackage.model.PoolProperty;
import tds.testpackage.model.Presentation;
import tds.testpackage.model.SegmentForm;
import tds.testpackage.model.Stimulus;

public class SegmentFormMapper {
    private static final String EMPTY_STRING = "";

    public static List<SegmentForm> map(final TestPackageWorkbook workbook, final String segmentId,
                                        final Map<String, GitLabItemMetaData> itemMetaData, final String assessmentId) {
        final List<SegmentForm> segmentForms = new ArrayList<>();
        final TestPackageSheet sheet = workbook.getSheet(TestPackageSheetNames.SEGMENT_FORMS);
        final int cols = sheet.getTotalNumberOfInputColumns();
        final ItemreleaseUnmarshaller unmarshaller = new ItemreleaseUnmarshaller();

        final LinkedHashSet<String> segFormIds = new LinkedHashSet();
        final HashMap<String, Set<String>> segFormPresentations = new HashMap<>();
        final LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> itemGroups = new LinkedHashMap<>();
        final HashMap<String, Item> items = new HashMap<>();

        // Iterate over all the columns / items
        for (int i = 0; i < cols; i++) {
            final Map<String, String> column = sheet.getInputVariableValuesMap(i);
            if (!segmentId.equals(column.get("SegmentId"))) {
                // Skip this column if it does not correspond to the segment ID we are dealing with
                continue;
            }
            String segFormId = column.get("SegmentFormId");
            segFormIds.add(segFormId);
            String itemId = column.get("ItemId");
            GitLabItemMetaData gitMeta = itemMetaData.get(itemId);
            ItemMetaDataUtil itemMetaDataUtil = new ItemMetaDataUtil(gitMeta.getItemMetadata());
            Itemrelease itemrelease = unmarshaller.unmarshallItem(gitMeta.getItemReleaseMetadata(), itemId);

            NodeList stimNodes = itemMetaDataUtil.xpathQuery("metadata/smarterAppMetadata/AssociatedStimulus");
            String stimulusId = stimNodes.getLength() == 1 ? stimNodes.item(0).getTextContent() : EMPTY_STRING;

            //If no stimulus associated with this item then it gets its own itemgroup with the id=itemId
            if (stimulusId.isEmpty()) {
                stimulusId = itemId;
            }

            if (!itemGroups.containsKey(segFormId)) {
                ArrayList<String> itemList = new ArrayList<>();
                itemList.add(itemId);
                LinkedHashMap<String, ArrayList<String>> stimulusItemList = new LinkedHashMap<>();
                stimulusItemList.put(stimulusId, itemList);
                itemGroups.put(segFormId, stimulusItemList);
            } else {
                if (!itemGroups.get(segFormId).containsKey(stimulusId)) {
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

            if (!segFormPresentations.containsKey(segFormId)) {
                segFormPresentations.put(segFormId, new HashSet<>());
            }
            if (english.equalsIgnoreCase("TRUE")) {
                segFormPresentations.get(segFormId).add("English");
                itemPresentations.add("English");
            }
            if (braille.equalsIgnoreCase("TRUE")) {
                segFormPresentations.get(segFormId).add("Braille");
                itemPresentations.add("Braille");
            }
            if (spanish.equalsIgnoreCase("TRUE")) {
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
                    .setBlueprintReferences(getBlueprintReferences(itemMetaDataUtil.getPrimaryStandard(), segmentId))
                    .setPoolProperties(getPoolProperties(itemrelease, itemMetaDataUtil))
                    .setPresentations(getPresentations(itemPresentations))
                    .build());
        }

        segFormIds.forEach((segFormId) -> {
            segmentForms.add(
                    SegmentForm.builder()
                            .setId(segFormId)
                            .setCohort(getCohort(segFormId, sheet))
                            .setPresentations(getPresentations(segFormPresentations.get(segFormId)))
                            .setItemGroups(getItemGroups(itemGroups.get(segFormId), items))
                            .build());
        });

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

    private static String fixMeasurementModelFormat(final String modelType) {
        if (modelType != null && modelType.equalsIgnoreCase("IRT3PLN")) {
            return "IRT3PLn";
        }
        return modelType;
    }

    private static List<PoolProperty> getPoolProperties(final Itemrelease itemrelease, final ItemMetaDataUtil itemMetaDataUtil) {
        // Was not able to find:
        //Appropriate for Hearing Impaired
        //Difficulty Category
        //Rubric Source
        //Spanish Translation
        //Test Pool
        //Glossary
        final List<PoolProperty> poolProperties = new ArrayList<>();
        final List<Attrib> attrList = itemrelease.getItemPassage().getAttriblist().getAttrib();
        for (final Attrib attrib : attrList) {
            if (attrib.getAttid().equals("itm_att_Answer Key") || attrib.getAttid().equals("itm_att_Answer Key (Part II)")) {
                getPoolProperty(attrib.getAttid().substring(attrib.getAttid().lastIndexOf("_") + 1), attrib.getVal())
                        .ifPresent(poolProperties::add);
            }
        }

        getPoolProperty("ASL", itemMetaDataUtil.getASL()).ifPresent(poolProperties::add);
        getPoolProperty("Braille", itemMetaDataUtil.getBraille()).ifPresent(poolProperties::add);
        getPoolProperty("Depth of Knowledge", itemMetaDataUtil.getDepthOfKnowledge()).ifPresent(poolProperties::add);
        getPoolProperty("Grade", itemMetaDataUtil.getIntendedGrade()).ifPresent(poolProperties::add);
        getPoolProperty("Scoring Engine", itemMetaDataUtil.getScoringEngine()).ifPresent(poolProperties::add);

        return poolProperties;
    }

    /**
     * Get a {@link tds.testpackage.model.PoolProperty} for the specified name and value.
     * <p>
     * In some Item metadata files, there are elements that describe a pool property but have no value.  For
     * example, a metadata.xml file can have <BrailleType></BrailleType>, indicating this item is not Braille-able
     * or Braille content has not yet been provided.  A <PoolProperty></PoolProperty> element should only be created
     * if there is a name and a value.  Pool properties with a name but no value should be ignored.
     * </p>
     *
     * @param name  The name attribute of the {@link tds.testpackage.model.PoolProperty} element
     * @param value The value attribute of the {@link tds.testpackage.model.PoolProperty} element
     * @return An {@link Optional#of(Object)} if a name and value are present;
     * otherwise {@link java.util.Optional#empty()}
     */
    private static Optional<PoolProperty> getPoolProperty(final String name, final String value) {
        return StringUtils.isEmpty(value)
                ? Optional.empty()
                : Optional.of(PoolProperty.builder().setName(name).setValue(value).build());
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
        } else {
            int irtDimensionCount = itemMetaDataUtil.getIrtDimensionCount();

            for (i = 0; i < irtDimensionCount; i++) {
                //if nothing in the Measurementmodel_x field then fetch from metadata.xml
                String modelType = fixMeasurementModelFormat(itemMetaDataUtil.getIrtElement("IrtModelType", i));
                String dimension = itemMetaDataUtil.getIrtElement("IrtDimensionPurpose", i);
                int scorePoints = Integer.parseInt(itemMetaDataUtil.getIrtElement("IrtScore", i));
                double weight = Double.parseDouble(itemMetaDataUtil.getIrtElement("IrtWeight", i));
                NodeList irtParameterNodes = itemMetaDataUtil.getIrtParameters(i + 1);
                Set<ItemScoreParameter> itemScoreParameters = new HashSet<>();
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
                        .setItemScoreParameters(new ArrayList<>(itemScoreParameters))
                        .setWeight(weight)
                        .build());
            }

            return itemScoreDimensions;
        }
    }

    private static List<BlueprintReference> getBlueprintReferences(final String standard, final String segmentId) {
        //SBAC-MA-v6:1|P|TS06|M - > 1|P|TS06|M
        final List<BlueprintReference> blueprintReferences = new ArrayList<>();
        final String bottomLevelBpRef = standard.split(":")[1];

        // If its not a target string (containing a pipe), then simply return this id
        if (!bottomLevelBpRef.contains("|")) {
            blueprintReferences.add(BlueprintReference.builder().setIdRef(bottomLevelBpRef).build());
            return blueprintReferences;
        }
        blueprintReferences.add(BlueprintReference.builder().setIdRef(segmentId).build());
        final List<String> refIds = new ArrayList<>();

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
        refIds.forEach(refId -> {
            blueprintReferences.add(BlueprintReference.builder().setIdRef(refId).build());
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

    private static List<Presentation> getPresentations(final Set<String> presentationStrings) {
        final List<Presentation> presentations = new ArrayList<>();
        presentationStrings.forEach(presentation -> {
            if (presentation.equalsIgnoreCase("English")) {
                presentations.add(Presentation.builder()
                        .setCode("ENU")
                        .setLabel("English")
                        .build());
            }
            if (presentation.equalsIgnoreCase("Spanish")) {
                presentations.add(Presentation.builder()
                        .setCode("ESN")
                        .setLabel("Spanish")
                        .build());
            }
            if (presentation.equalsIgnoreCase("Braille")) {
                presentations.add(Presentation.builder()
                        .setCode("ENU-Braille")
                        .setLabel("Braille")
                        .build());
            }
        });
        return presentations;
    }

    private static List<ItemGroup> getItemGroups(final HashMap<String, ArrayList<String>> itemGroup, final HashMap<String, Item> items) {
        final List<ItemGroup> itemGroups = new ArrayList<>();
        itemGroup.forEach((stimId, itemList) -> {
            List<Item> itemsList = new ArrayList<>();
            itemList.forEach((itemId) -> {
                itemsList.add(items.get(itemId));
            });
            // If group has only one item, and item's ID matches stim ID, then item has no stim, don't emit stim element
            if (itemList.size() == 1 && itemList.get(0).equals(stimId)) {
                itemGroups.add(ItemGroup.builder()
                        .setMaxResponses(Optional.of("0"))
                        .setId(stimId)
                        .setItems(itemsList).build());
            } else {
                itemGroups.add(ItemGroup.builder()
                        .setMaxResponses(Optional.of(itemList.size() == 1 ? "0" : "ALL"))
                        .setId(stimId)
                        .setStimulus(Optional.of(Stimulus.builder().setId(stimId).build()))
                        .setItems(itemsList).build());
            }
        });
        return itemGroups;
    }
}
