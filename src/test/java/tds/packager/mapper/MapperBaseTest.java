package tds.packager.mapper;

import com.google.common.collect.ImmutableMap;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import tds.packager.model.gitlab.GitLabItemMetaData;
import tds.packager.model.xlsx.TestPackageWorkbook;

import java.util.Map;

public class MapperBaseTest {
    protected TestPackageWorkbook mockWorkbook;

    protected Map<String, GitLabItemMetaData> itemMetadata;

    @Before
    public void setup() throws Exception {
        mockWorkbook = new TestPackageWorkbook(new XSSFWorkbook(
                this.getClass().getResourceAsStream("/SBAC-IAB-FIXED-G11M-Winter-2017-2018.xlsx")));

        itemMetadata = ImmutableMap.<String, GitLabItemMetaData>builder()
                .put("83834", new GitLabItemMetaData( "<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>\n" +
                        "<metadata>\n" +
                        "  <smarterAppMetadata xmlns=\"http://www.smarterapp.org/ns/1/assessment_item_metadata\">\n" +
                        "    <Identifier>83834</Identifier>\n" +
                        "    <Subject>MATH</Subject>\n" +
                        "    <Version>9</Version>\n" +
                        "    <SecurityStatus>Secure</SecurityStatus>\n" +
                        "    <SmarterAppItemDescriptor>MATH.11.1.A-REI.1I</SmarterAppItemDescriptor>\n" +
                        "    <StimulusFormat>Standard</StimulusFormat>\n" +
                        "    <ItemAuthorIdentifier>Sridhar_Ravva</ItemAuthorIdentifier>\n" +
                        "    <ItemSpecFormat>SmarterApp</ItemSpecFormat>\n" +
                        "    <LastModifiedBy>Sridhar_Ravva</LastModifiedBy>\n" +
                        "    <IntendedGrade>11</IntendedGrade>\n" +
                        "    <MinimumGrade>9</MinimumGrade>\n" +
                        "    <MaximumGrade>11</MaximumGrade>\n" +
                        "    <DepthOfKnowledge>1</DepthOfKnowledge>\n" +
                        "    <AchievementQuintile>1</AchievementQuintile>\n" +
                        "    <AllowCalculator>N</AllowCalculator>\n" +
                        "    <InteractionType>EQ</InteractionType>\n" +
                        "    <MaximumNumberOfPoints>1</MaximumNumberOfPoints>\n" +
                        "    <ScorePoints>\"0, 1\"</ScorePoints>\n" +
                        "    <ScoringEngine>Automatic with Machine Rubric</ScoringEngine>\n" +
                        "    <PresentationFormat>Text</PresentationFormat>\n" +
                        "    <AdministrationDate>Phase 2</AdministrationDate>\n" +
                        "    <ContentTaskModel>TM1a_Rpdv</ContentTaskModel>\n" +
                        "    <AlgebraFunctionDescriptor>Linear</AlgebraFunctionDescriptor>\n" +
                        "    <BrailleType>BRF_EBAE_UEB</BrailleType>\n" +
                        "    <EnemyItem></EnemyItem>\n" +
                        "    <CopyrightAndOtherRestrictions></CopyrightAndOtherRestrictions>\n" +
                        "    <StimulusScource></StimulusScource>\n" +
                        "    <Notes></Notes>\n" +
                        "    <PerformanceTaskComponentItem>N</PerformanceTaskComponentItem>\n" +
                        "    <PtClassroomActivity></PtClassroomActivity>\n" +
                        "    <PtEnemy></PtEnemy>\n" +
                        "    <AccessibilityTagsASLLanguage>Y</AccessibilityTagsASLLanguage>\n" +
                        "    <IrtDimension>\n" +
                        "      <IrtStatDomain>Online</IrtStatDomain>\n" +
                        "      <IrtModelType>IRT3PLN</IrtModelType>\n" +
                        "      <IrtDimensionPurpose></IrtDimensionPurpose>\n" +
                        "      <IrtScore>1</IrtScore>\n" +
                        "      <IrtWeight>1</IrtWeight>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>a</Name>\n" +
                        "        <Value>0.9329</Value>\n" +
                        "      </IrtParameter>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>b</Name>\n" +
                        "        <Value>0.5231</Value>\n" +
                        "      </IrtParameter>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>c</Name>\n" +
                        "        <Value>0</Value>\n" +
                        "      </IrtParameter>\n" +
                        "    </IrtDimension>\n" +
                        "    <Status>Operational</Status>\n" +
                        "    <StandardPublication>\n" +
                        "      <Publication>SBAC-MA-v4</Publication>\n" +
                        "      <PrimaryStandard>SBAC-MA-v4:1|A-REI|I|m|A-REI.3</PrimaryStandard>\n" +
                        "    </StandardPublication>\n" +
                        "    <StandardPublication>\n" +
                        "      <Publication>SBAC-MA-v6</Publication>\n" +
                        "      <PrimaryStandard>SBAC-MA-v6:1|P|TS03|I</PrimaryStandard>\n" +
                        "    </StandardPublication>\n" +
                        "    <AssociatedTutorial>67863</AssociatedTutorial>\n" +
                        "    <AssociatedWordlist>123853</AssociatedWordlist>\n" +
                        "    <Language>eng</Language>\n" +
                        "    <Language>spa</Language>\n" +
                        "  </smarterAppMetadata>\n" +
                        "</metadata>\n", "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<itemrelease version=\"2.0\">\n" +
                        "  <item format=\"eq\" id=\"83834\" version=\"9\" bankkey=\"200\">\n" +
                        "    <attriblist>\n" +
                        "      <attrib attid=\"itm_item_id\">\n" +
                        "        <name>Item: ITS ID</name>\n" +
                        "        <val>83834</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_item_subject\">\n" +
                        "        <name>Item: Subject</name>\n" +
                        "        <val>MATH</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_item_desc\">\n" +
                        "        <name>Item: Item Description</name>\n" +
                        "        <val>MATH.11.1.A-REI.1I</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_FTUse\">\n" +
                        "        <name>Fieldtest Use</name>\n" +
                        "        <val>Math OP G11 No Calc 2015 ENG (318); Math MAAC G9 No Calc 2015 ENG (24); Math Oregon OP G11 No Calc 2015 ENG (179); Math OP G11 No Calc 2015 ENG COMBINED (327); Math MAAC G9 No Calc 2015 ENG COMBINED (27); Math Oregon OP G11 No Calc 2015 ENG COMBINED (179); SBAC-Int-PR1-FM1-Math-11 (13); SBAC-Int-PR1-FM1-Math-11-SPA (13);</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_OPUse\">\n" +
                        "        <name>Operational Use</name>\n" +
                        "        <val>IAB-G11M-AlgLin-NoCalc-2017 ENG (1); IAB-G11M-AlgLin-NoCalc-2017 BRL (1); IAB-G11M-AlgLin-NoCalc-2017 SPA (1); IAB-G11M-AlgLin-NoCalc-2017 ENG COMBINED (1); IAB-G11M-AlgLin-NoCalc-2017 BRL COMBINED (1); IAB-G11M-AlgLin-NoCalc-2017 SPA COMBINED (1); IAB-G11M-AlgLin-NoCalc-2018 ENG (1); IAB-G11M-AlgLin-NoCalc-2018 BRL (1); IAB-G11M-AlgLin-NoCalc-2018 SPA (1); IAB-G11M-AlgLin-NoCalc-2018 ENG COMBINED (1); IAB-G11M-AlgLin-NoCalc-2018 BRL COMBINED (1); IAB-G11M-AlgLin-NoCalc-2018 SPA COMBINED (1); IAB-G11M-AlgLin-NoCalc-2019 ENG (1); IAB-G11M-AlgLin-NoCalc-2019 BRL (1); IAB-G11M-AlgLin-NoCalc-2019 SPA (1);</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Answer Key\">\n" +
                        "        <name>Item: Answer Key</name>\n" +
                        "        <val>EQ</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Grade\">\n" +
                        "        <name>Item: Grade</name>\n" +
                        "        <val>11</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Item Format\">\n" +
                        "        <name>Item: Item Format</name>\n" +
                        "        <val>EQ</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Page Layout\">\n" +
                        "        <name>Item: Page Layout</name>\n" +
                        "        <val>8</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Response Type\">\n" +
                        "        <name>Item: Response Type</name>\n" +
                        "        <val>EquationEditor</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Item Point\">\n" +
                        "        <name>Item: Item Point</name>\n" +
                        "        <val>1 pt.</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Answer Key (Part II)\">\n" +
                        "        <name>Item: Answer Key (Part II)</name>\n" +
                        "        <val>NA</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Max Choices\">\n" +
                        "        <name>Item:Max Choices</name>\n" +
                        "        <val>NA</val>\n" +
                        "        <desc>NA</desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Max Choices (Part II)\">\n" +
                        "        <name>Item:Max Choices (Part II)</name>\n" +
                        "        <val></val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "    </attriblist>\n" +
                        "    <tutorial id=\"67863\" bankkey=\"200\" />\n" +
                        "    <resourceslist>\n" +
                        "      <resource type=\"wordList\" id=\"123853\" index=\"1\" bankkey=\"200\" />\n" +
                        "    </resourceslist>\n" +
                        "    <statistic />\n" +
                        "    <MachineRubric filename=\"Item_83834_v9.qrx\" />\n" +
                        "    <RendererSpec filename=\"Item_83834_v9.eax\" />\n" +
                        "    <content language=\"ENU\" version=\"2.0\" approvedVersion=\"9\">\n" +
                        "      <rationaleoptlist />\n" +
                        "      <stem><![CDATA[<p style=\"\"><span id=\"item_83834_TAG_3\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>Enter<span class=\"its-tag\" data-tag-ref=\"item_83834_TAG_3\" data-tag-boundary=\"end\"></span> the value of <span style=\"font-style:italic; \">x</span> <span id=\"item_83834_TAG_4\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>that makes<span class=\"its-tag\" data-tag-ref=\"item_83834_TAG_4\" data-tag-boundary=\"end\"></span> the <span id=\"item_83834_TAG_5\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"3\"></span>given<span class=\"its-tag\" data-tag-ref=\"item_83834_TAG_5\" data-tag-boundary=\"end\"></span> equation <span id=\"item_83834_TAG_6\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"4\"></span>true<span class=\"its-tag\" data-tag-ref=\"item_83834_TAG_6\" data-tag-boundary=\"end\"></span>.</p><p style=\"\">&#xA0;</p><p style=\"\"><span id=\"item_83834_TAG_2_BEGIN\">12<span style=\"font-style:italic; \">x </span>= 3</span></p>]]></stem>\n" +
                        "      <rubriclist>\n" +
                        "        <rubric scorepoint=\"\">\n" +
                        "          <name>\n" +
                        "        Rubric </name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p><p style=\"\">Exemplar:</p><p style=\"\">&#xA0;</p><ul style=\"padding-left:1.5000em; \"><li><p style=\"\">0.25 or equivalent</p></li></ul><p style=\"\">&#xA0;</p><p style=\"\">For this item, a full-credit response includes</p><p style=\"\">&#xA0;</p><ul style=\"padding-left:1.5000em; \"><li><p style=\"\">The student enters 0.25 (or equivalent) in the response box. (1 point) </p></li></ul><p style=\"\">&#xA0;&#xA0;&#xA0;&#xA0;&#xA0;&#xA0;&#xA0;&#xA0;</p><p style=\"\">&#xA0;</p><p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rubric>\n" +
                        "        <samplelist maxval=\"\" minval=\"\" />\n" +
                        "      </rubriclist>\n" +
                        "      <attachmentlist>\n" +
                        "        <attachment id=\"braillefile1\" type=\"BRF\" subtype=\"TDS_BT_ECN\" file=\"item_83834_enu_brf_ebae_contracted_nemeth_ecn.brf\" />\n" +
                        "        <attachment id=\"braillefile19\" type=\"BRF\" subtype=\"TDS_BT_UCN\" file=\"item_83834_enu_brf_ueb_contracted_nemeth_ucn.brf\" />\n" +
                        "        <attachment id=\"braillefile31\" type=\"BRF\" subtype=\"TDS_BT_UCT\" file=\"item_83834_enu_brf_ueb_contracted_ueb_math_uct.brf\" />\n" +
                        "        <attachment id=\"braillefile3\" type=\"BRF\" subtype=\"TDS_BT_EXN\" file=\"item_83834_enu_brf_ebae_uncontracted_nemeth_exn.brf\" />\n" +
                        "        <attachment id=\"braillefile16\" type=\"BRF\" subtype=\"TDS_BT_UXN\" file=\"item_83834_enu_brf_ueb_uncontracted_nemeth_uxn.brf\" />\n" +
                        "        <attachment id=\"braillefile27\" type=\"BRF\" subtype=\"TDS_BT_UXT\" file=\"item_83834_enu_brf_ueb_uncontracted_ueb_math_uxt.brf\" />\n" +
                        "        <attachment id=\"aslfile1\" type=\"ASL\" subtype=\"STEM\" file=\"item_83834_ASL_STEM.mp4\">\n" +
                        "          <source src=\"item_83834_ASL_STEM.webm\" type=\"video/webm\" />\n" +
                        "          <source src=\"item_83834_ASL_STEM.mp4\" type=\"video/mp4\" />\n" +
                        "        </attachment>\n" +
                        "      </attachmentlist>\n" +
                        "      <apipAccessibility>\n" +
                        "        <accessibilityInfo>\n" +
                        "          <accessElement identifier=\"ae5\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_83834_TAG_2_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>12 x equals three. The equation tool has two sections. In the left section, from left to right and top to bottom the equation tool reeds, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, point, negative.  In the right section mathematical functions are shown.</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>12x = 3</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>12x = 3</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "        </accessibilityInfo>\n" +
                        "      </apipAccessibility>\n" +
                        "    </content>\n" +
                        "    <content language=\"ESN\" version=\"2.0\" approvedVersion=\"9\">\n" +
                        "      <stem><![CDATA[<p style=\"\">Escribe el valor de <span style=\"font-style:italic; \">x</span> que hace que la ecuación dada sea verdadera.</p><p style=\"\">&#xA0;</p><p style=\"\">12<span style=\"font-style:italic; \">x </span>= 3</p><p class=\"languagedivider\">&#xA0;</p><p style=\"\"><span id=\"item_83834_TAG_3\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>Enter<span class=\"its-tag\" data-tag-ref=\"item_83834_TAG_3\" data-tag-boundary=\"end\"></span> the value of <span style=\"font-style:italic; \">x</span> <span id=\"item_83834_TAG_4\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>that makes<span class=\"its-tag\" data-tag-ref=\"item_83834_TAG_4\" data-tag-boundary=\"end\"></span> the <span id=\"item_83834_TAG_5\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"3\"></span>given<span class=\"its-tag\" data-tag-ref=\"item_83834_TAG_5\" data-tag-boundary=\"end\"></span> equation <span id=\"item_83834_TAG_6\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"4\"></span>true<span class=\"its-tag\" data-tag-ref=\"item_83834_TAG_6\" data-tag-boundary=\"end\"></span>.</p><p style=\"\">&#xA0;</p><p style=\"\"><span id=\"item_83834_TAG_2_BEGIN\">12<span style=\"font-style:italic; \">x </span>= 3</span></p>]]></stem>\n" +
                        "      <rubriclist>\n" +
                        "        <rubric scorepoint=\"_Spanish\">\n" +
                        "          <name>\n" +
                        "        Rubric _Spanish</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rubric>\n" +
                        "        <samplelist maxval=\"_Spanish\" minval=\"_Spanish\" />\n" +
                        "      </rubriclist>\n" +
                        "      <attachmentlist />\n" +
                        "      <apipAccessibility>\n" +
                        "        <accessibilityInfo>\n" +
                        "          <accessElement identifier=\"ae5\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_83834_TAG_2_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>12 x equals three. The equation tool has two sections. In the left section, from left to right and top to bottom the equation tool reeds, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, point, negative.  In the right section mathematical functions are shown.</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>12x = 3</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>12x = 3</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "        </accessibilityInfo>\n" +
                        "      </apipAccessibility>\n" +
                        "    </content>\n" +
                        "  </item>\n" +
                        "</itemrelease>\n"))
                .put("12164", new GitLabItemMetaData("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>\n" +
                        "<metadata>\n" +
                        "  <smarterAppMetadata xmlns=\"http://www.smarterapp.org/ns/1/assessment_item_metadata\">\n" +
                        "    <Identifier>12164</Identifier>\n" +
                        "    <ItemAuthorIdentifier>Sridhar_Ravva</ItemAuthorIdentifier>\n" +
                        "    <ItemSpecFormat>SmarterApp</ItemSpecFormat>\n" +
                        "    <LastModifiedBy>Sridhar_Ravva</LastModifiedBy>\n" +
                        "    <SecurityStatus>Secure</SecurityStatus>\n" +
                        "    <SmarterAppItemDescriptor>65674</SmarterAppItemDescriptor>\n" +
                        "    <StimulusFormat>Standard</StimulusFormat>\n" +
                        "    <Subject>MATH</Subject>\n" +
                        "    <Version>10</Version>\n" +
                        "    <IntendedGrade>11</IntendedGrade>\n" +
                        "    <MinimumGrade>8</MinimumGrade>\n" +
                        "    <MaximumGrade>11</MaximumGrade>\n" +
                        "    <MathematicalPractice>None</MathematicalPractice>\n" +
                        "    <DepthOfKnowledge>2</DepthOfKnowledge>\n" +
                        "    <AchievementQuintile>1</AchievementQuintile>\n" +
                        "    <AllowCalculator>N</AllowCalculator>\n" +
                        "    <InteractionType>MC</InteractionType>\n" +
                        "    <MaximumNumberOfPoints>1</MaximumNumberOfPoints>\n" +
                        "    <ScorePoints>\"0, 1\"</ScorePoints>\n" +
                        "    <ScoringEngine>Automatic with Key</ScoringEngine>\n" +
                        "    <PresentationFormat>Text</PresentationFormat>\n" +
                        "    <AdministrationDate>Field Test</AdministrationDate>\n" +
                        "    <ContentTaskModel>TM2c_Rpdv</ContentTaskModel>\n" +
                        "    <AlgebraFunctionDescriptor>Linear</AlgebraFunctionDescriptor>\n" +
                        "    <BrailleType>BRF_EBAE_UEB</BrailleType>\n" +
                        "    <EnemyItem>0</EnemyItem>\n" +
                        "    <CopyrightAndOtherRestrictions>Commissioned</CopyrightAndOtherRestrictions>\n" +
                        "    <PerformanceTaskComponentItem>N</PerformanceTaskComponentItem>\n" +
                        "    <PtEnemy>0</PtEnemy>\n" +
                        "    <AccessibilityTagsASLLanguage>Y</AccessibilityTagsASLLanguage>\n" +
                        "    <IrtDimension>\n" +
                        "      <IrtStatDomain>Online</IrtStatDomain>\n" +
                        "      <IrtModelType>IRT3PLN</IrtModelType>\n" +
                        "      <IrtDimensionPurpose></IrtDimensionPurpose>\n" +
                        "      <IrtScore>1</IrtScore>\n" +
                        "      <IrtWeight>1</IrtWeight>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>a</Name>\n" +
                        "        <Value>0.25633</Value>\n" +
                        "      </IrtParameter>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>b</Name>\n" +
                        "        <Value>1.23069</Value>\n" +
                        "      </IrtParameter>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>c</Name>\n" +
                        "        <Value>0</Value>\n" +
                        "      </IrtParameter>\n" +
                        "    </IrtDimension>\n" +
                        "    <Status>Operational</Status>\n" +
                        "    <StandardPublication>\n" +
                        "      <Publication>SBAC-MA-v4</Publication>\n" +
                        "      <PrimaryStandard>SBAC-MA-v4:1|A-REI|I|m|A-REI.3</PrimaryStandard>\n" +
                        "    </StandardPublication>\n" +
                        "    <StandardPublication>\n" +
                        "      <Publication>SBAC-MA-v6</Publication>\n" +
                        "      <PrimaryStandard>SBAC-MA-v6:1|P|TS03|I</PrimaryStandard>\n" +
                        "    </StandardPublication>\n" +
                        "    <AssociatedTutorial>67708</AssociatedTutorial>\n" +
                        "    <AssociatedWordlist>49524</AssociatedWordlist>\n" +
                        "    <Language>eng</Language>\n" +
                        "    <Language>spa</Language>\n" +
                        "  </smarterAppMetadata>\n" +
                        "</metadata>\n", "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<itemrelease version=\"2.0\">\n" +
                        "  <item format=\"mc\" id=\"12164\" version=\"10\" bankkey=\"200\">\n" +
                        "    <attriblist>\n" +
                        "      <attrib attid=\"itm_item_id\">\n" +
                        "        <name>Item: ITS ID</name>\n" +
                        "        <val>12164</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_item_subject\">\n" +
                        "        <name>Item: Subject</name>\n" +
                        "        <val>MATH</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_item_desc\">\n" +
                        "        <name>Item: Item Description</name>\n" +
                        "        <val>65674</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_FTUse\">\n" +
                        "        <name>Fieldtest Use</name>\n" +
                        "        <val>Platform::MG11::12.3 (597); SBAC-Int-PR1-FM1-Math-11 (15); SBAC-Int-PR1-FM1-Math-11-SPA (15);</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_OPUse\">\n" +
                        "        <name>Operational Use</name>\n" +
                        "        <val>CAT::MG8::UPnoCALC-S3-B::SP14 (18); CAT::MG11::ONONnoCALC-S2-A1::SP14 (75); CAT::MG11::ONnoCALC-S2-D::SP14 (539); FAKE MATH FORM (4009); CAT::MG11::ONnoCALC-S2-A2::SP14 (75); CAT::MG11::ONnoCALC-S3-A3::SP14 (75); CAT::MG11::ONnoCALC-S2-A3::SP14 (75); CAT::MG10::ONnoCALC-S2-A4::SP14 (75); CAT::MG8::UPnoCALC-S2-B::SP14 (18); CAT::MG11::CA-ONNoCalc::SP14 (75); CAT::MG10::ONnoCALC-S2-A4::SP14-ESN (75); CAT::MG11::ONONnoCALC-S2-A1::SP14-ESN (75); CAT::MG11::ONnoCALC-S2-D::SP14-ESN (75); CAT::MG11::ONnoCALC-S3-A3::SP14-ESN (75); CAT::MG11::ONnoCALC-S2-A2::SP14-ESN (75); CAT::MG11::ONnoCALC-S2-A3::SP14-ESN (75); CAT::MG8::UPnoCALC-S2-B::SP14-ESN (75); CAT::MG8::UPnoCALC-S3-B::SP14-ESN (75); CAT::MG11::CA-ONNoCalc::SP14-ESN (75); CAT::MG910::VL11CALC-S1-C::SP14 (18); CAT::MG910::VL11CALC-S1-C::SP14-ESN (75); CAT::MG910::VL11CALC-S4-C::SP14 (18); CAT::MG910::VL11CALC-S4-C::SP14-ESN (75); CAT::MG11::CA-ONNoCalc::D::SP14 (539); CAT::MG11::CA-ONNoCalc::D::SP14-ESN (75); CAT::MG11::CA-ONNoCalc::D (539); Math ICA G11 No Calc 2015 ENG (1); Math ICA G11 No Calc 2015 BRL (1); Math ICA G11 No Calc 2015 SPA (1); Math ICA G11 No Calc COMBINED 2015 ENG (1); Math ICA G11 No Calc COMBINED 2015 BRL (1); Math ICA G11 No Calc COMBINED 2015 SPA (1); IAB-G11M-AlgLinearFun-NoCalc-2015 ENG (1); IAB-G11M-AlgLinearFun-NoCalc-2015 BRL (1); IAB-G11M-AlgLinearFun-NoCalc-2015 SPA (1); IAB-G11M-AlgLinearFun-NoCalc-2015 ENG-COMBINED (1); IAB-G11M-AlgLinearFun-NoCalc-2015 BRL-COMBINED (1); IAB-G11M-AlgLinearFun-NoCalc-2015 SPA-COMBINED (1); Math ICA G11 No Calc 2017 ENG (1); Math ICA G11 No Calc 2017 BRL (1); Math ICA G11 No Calc 2017 SPA (1); IAB-G11M-AlgLin-NoCalc-2017 ENG (3); IAB-G11M-AlgLin-NoCalc-2017 BRL (3); IAB-G11M-AlgLin-NoCalc-2017 SPA (3); Math ICA G11 No Calc 2017 ENG COMBINED (1); Math ICA G11 No Calc 2017 BRL COMBINED (1); Math ICA G11 No Calc 2017 SPA COMBINED (1); IAB-G11M-AlgLin-NoCalc-2017 ENG COMBINED (3); IAB-G11M-AlgLin-NoCalc-2017 BRL COMBINED (3); IAB-G11M-AlgLin-NoCalc-2017 SPA COMBINED (3); Math ICA G11 No Calc 2018 ENG (1); Math ICA G11 No Calc 2018 BRL (1); Math ICA G11 No Calc 2018 SPA (1); IAB-G11M-AlgLin-NoCalc-2018 ENG (3); IAB-G11M-AlgLin-NoCalc-2018 BRL (3); IAB-G11M-AlgLin-NoCalc-2018 SPA (3); Math ICA G11 No Calc 2018 ENG COMBINED (1); Math ICA G11 No Calc 2018 BRL COMBINED (1); Math ICA G11 No Calc 2018 SPA COMBINED (1); IAB-G11M-AlgLin-NoCalc-2018 ENG COMBINED (3); IAB-G11M-AlgLin-NoCalc-2018 BRL COMBINED (3); IAB-G11M-AlgLin-NoCalc-2018 SPA COMBINED (3); HI Math ICA G11 No Calc 2018 ENG (1); HI Math ICA G11 No Calc 2018 BRL (1); HI Math ICA G11 No Calc 2018 SPA (1); IAB-G11M-AlgLin-NoCalc-2019 ENG (3); IAB-G11M-AlgLin-NoCalc-2019 BRL (3); IAB-G11M-AlgLin-NoCalc-2019 SPA (3); Math ICA G11 No Calc 2018 ENG_copy1 (1); Math ICA G11 No Calc 2018 BRL_copy1 (1); Math ICA G11 No Calc 2018 SPA_copy1 (1);</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Answer Key\">\n" +
                        "        <name>Item: Answer Key</name>\n" +
                        "        <val>C</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Grade\">\n" +
                        "        <name>Item: Grade</name>\n" +
                        "        <val>11</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Item Format\">\n" +
                        "        <name>Item: Item Format</name>\n" +
                        "        <val>MC</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Page Layout\">\n" +
                        "        <name>Item: Page Layout</name>\n" +
                        "        <val>8</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Response Type\">\n" +
                        "        <name>Item: Response Type</name>\n" +
                        "        <val>Vertical</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Item Point\">\n" +
                        "        <name>Item: Item Point</name>\n" +
                        "        <val>1 pt.</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Answer Key (Part II)\">\n" +
                        "        <name>Item: Answer Key (Part II)</name>\n" +
                        "        <val></val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Max Choices\">\n" +
                        "        <name>Item:Max Choices</name>\n" +
                        "        <val></val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Max Choices (Part II)\">\n" +
                        "        <name>Item:Max Choices (Part II)</name>\n" +
                        "        <val></val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "    </attriblist>\n" +
                        "    <tutorial id=\"67708\" bankkey=\"200\" />\n" +
                        "    <resourceslist>\n" +
                        "      <resource type=\"wordList\" id=\"49524\" index=\"1\" bankkey=\"200\" />\n" +
                        "    </resourceslist>\n" +
                        "    <statistic />\n" +
                        "    <content language=\"ENU\" version=\"2.0\" approvedVersion=\"10\">\n" +
                        "      <concept>\n" +
                        "        <name>What Knowledge Do Students Need to Understand This Concept?</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </concept>\n" +
                        "      <es>\n" +
                        "        <name>Explanation of Correct Answer</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </es>\n" +
                        "      <himi>\n" +
                        "        <name>Explanation of Correct Answer</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </himi>\n" +
                        "      <rationaleoptlist>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option A</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option B</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option C</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option D</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "      </rationaleoptlist>\n" +
                        "      <stem><![CDATA[<p style=\"\">&#xA0;</p><p style=\"\"><span id=\"item_12164_TAG_6\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>Which<span class=\"its-tag\" data-tag-ref=\"item_12164_TAG_6\" data-tag-boundary=\"end\"></span> inequality represents <span id=\"item_12164_TAG_7\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>all<span class=\"its-tag\" data-tag-ref=\"item_12164_TAG_7\" data-tag-boundary=\"end\"></span> <span id=\"item_12164_TAG_8\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"3\"></span>possible<span class=\"its-tag\" data-tag-ref=\"item_12164_TAG_8\" data-tag-boundary=\"end\"></span> solutions of <img id=\"item_12164_Object1\" style=\"vertical-align:middle;\" src=\"item_12164_v10_Object1_png16malpha.png\" width=\"76\" height=\"13\" />?</p><p style=\"\">&#xA0;</p>]]></stem>\n" +
                        "      <optionlist>\n" +
                        "        <option>\n" +
                        "          <name>Option A</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><span id=\"item_12164_TAG_2_BEGIN\"><img id=\"CrossReference0\" src=\"item_12164_v10_item_12164_mml_svg_png__1.png\"/></span></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">The student keeps the fraction negative.</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option B</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><span id=\"item_12164_TAG_3_BEGIN\"><img id=\"CrossReference1\" src=\"item_12164_v10_item_12164_mml_svg_png__2.png\"/></span></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">The student keeps the fraction negative and does not flip the inequality sign.</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option C</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><span id=\"item_12164_TAG_4_BEGIN\"><img id=\"CrossReference2\" src=\"item_12164_v10_item_12164_mml_svg_png__3.png\"/></span></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">key</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option D</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><span id=\"item_12164_TAG_5_BEGIN\"><img id=\"CrossReference3\" src=\"item_12164_v10_item_12164_mml_svg_png__4.png\"/></span></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">The student does not flip the inequality sign.</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "      </optionlist>\n" +
                        "      <attachmentlist>\n" +
                        "        <attachment id=\"braillefile1\" type=\"BRF\" subtype=\"TDS_BT_ECN\" file=\"item_12164_enu_brf_ebae_contracted_nemeth_ecn.brf\" />\n" +
                        "        <attachment id=\"braillefile19\" type=\"BRF\" subtype=\"TDS_BT_UCN\" file=\"item_12164_enu_brf_ueb_contracted_nemeth_ucn.brf\" />\n" +
                        "        <attachment id=\"braillefile31\" type=\"BRF\" subtype=\"TDS_BT_UCT\" file=\"item_12164_enu_brf_ueb_contracted_ueb_math_uct.brf\" />\n" +
                        "        <attachment id=\"braillefile3\" type=\"BRF\" subtype=\"TDS_BT_EXN\" file=\"item_12164_enu_brf_ebae_uncontracted_nemeth_exn.brf\" />\n" +
                        "        <attachment id=\"braillefile16\" type=\"BRF\" subtype=\"TDS_BT_UXN\" file=\"item_12164_enu_brf_ueb_uncontracted_nemeth_uxn.brf\" />\n" +
                        "        <attachment id=\"braillefile27\" type=\"BRF\" subtype=\"TDS_BT_UXT\" file=\"item_12164_enu_brf_ueb_uncontracted_ueb_math_uxt.brf\" />\n" +
                        "        <attachment id=\"aslfile1\" type=\"ASL\" subtype=\"STEM\" file=\"item_12164_ASL_STEM.mp4\">\n" +
                        "          <source src=\"item_12164_ASL_STEM.webm\" type=\"video/webm\" />\n" +
                        "          <source src=\"item_12164_ASL_STEM.mp4\" type=\"video/mp4\" />\n" +
                        "        </attachment>\n" +
                        "      </attachmentlist>\n" +
                        "      <apipAccessibility>\n" +
                        "        <accessibilityInfo>\n" +
                        "          <accessElement identifier=\"ae4\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_12164_Object1\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>, negative 12 d is greater than or equal to negative 6</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">-12d .1: -6</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae5\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_12164_TAG_2_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>d is less than or equal to negative one half</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate></textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">`i'\\x00bb'8\"kmath\n" +
                        "_+xmlns=\"http://www.w3.org/1998/Math/Ma-\n" +
                        "thML\"&gt;_: \"kmi.1d\"k_/mi.1\n" +
                        "\"kmo.1`a'\\x0089'$\"k_/mo.1\n" +
                        "\"kmo.1`a'\\x0088''\"k_/mo.1 \"kmfrac\n" +
                        "bevelled.k8false0.1 \"kmn.1#a\"k_/mn.1\n" +
                        "\"kmn.1#b\"k_/mn.1 \"k_/mfrac.1 \"k_/math.1\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae6\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_12164_TAG_3_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>d is greater than or equal to negative one half</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate></textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">`i'\\x00bb'8\"kmath\n" +
                        "_+xmlns=\"http://www.w3.org/1998/Math/Ma-\n" +
                        "thML\"&gt;_: \"kmi.1d\"k_/mi.1\n" +
                        "\"kmo.1`a'\\x0089''\\x00a5'\"k_/mo.1\n" +
                        "\"kmo.1`a'\\x0088''\"k_/mo.1 \"kmfrac\n" +
                        "bevelled.k8false0.1 \"kmn.1#a\"k_/mn.1\n" +
                        "\"kmn.1#b\"k_/mn.1 \"k_/mfrac.1 \"k_/math.1\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae7\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_12164_TAG_4_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>d is less than or equal to one half</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate></textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">`i'\\x00bb'8\"kmath\n" +
                        "_+xmlns=\"http://www.w3.org/1998/Math/Ma-\n" +
                        "thML\"&gt;_: \"kmi.1d\"k_/mi.1\n" +
                        "\"kmo.1`a'\\x0089'$\"k_/mo.1 \"kmfrac\n" +
                        "bevelled.k8false0.1 \"kmn.1#a\"k_/mn.1\n" +
                        "\"kmn.1#b\"k_/mn.1 \"k_/mfrac.1 \"k_/math.1\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae8\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_12164_TAG_5_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>d is greater than or equal to one half</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate></textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">`i'\\x00bb'8\"kmath\n" +
                        "_+xmlns=\"http://www.w3.org/1998/Math/Ma-\n" +
                        "thML\"&gt;_: \"kmi.1d\"k_/mi.1\n" +
                        "\"kmo.1`a'\\x0089''\\x00a5'\"k_/mo.1 \"kmfrac\n" +
                        "bevelled.k8false0.1 \"kmn.1#a\"k_/mn.1\n" +
                        "\"kmn.1#b\"k_/mn.1 \"k_/mfrac.1 \"k_/math.1\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "        </accessibilityInfo>\n" +
                        "      </apipAccessibility>\n" +
                        "    </content>\n" +
                        "    <content language=\"ESN\" version=\"2.0\" approvedVersion=\"10\">\n" +
                        "      <concept>\n" +
                        "        <name>What Knowledge Do Students Need to Understand This Concept?</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </concept>\n" +
                        "      <es>\n" +
                        "        <name>Explanation of Correct Answer</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </es>\n" +
                        "      <himi>\n" +
                        "        <name>Explanation of Correct Answer</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </himi>\n" +
                        "      <rationaleoptlist>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option A</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option B</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option C</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option D</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "      </rationaleoptlist>\n" +
                        "      <stem><![CDATA[<p style=\"\">¿Cuál desigualdad representa todas las soluciones posibles para <img id=\"item_12164_Object2\" style=\"vertical-align:middle;\" src=\"item_12164_v10_Object2_png16malpha.png\" width=\"76\" height=\"13\" />?</p><p class=\"languagedivider\">&#xA0;</p><p style=\"\">&#xA0;</p><p style=\"\"><span id=\"item_12164_TAG_6\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>Which<span class=\"its-tag\" data-tag-ref=\"item_12164_TAG_6\" data-tag-boundary=\"end\"></span> inequality represents <span id=\"item_12164_TAG_7\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>all<span class=\"its-tag\" data-tag-ref=\"item_12164_TAG_7\" data-tag-boundary=\"end\"></span> <span id=\"item_12164_TAG_8\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"3\"></span>possible<span class=\"its-tag\" data-tag-ref=\"item_12164_TAG_8\" data-tag-boundary=\"end\"></span> solutions of <img id=\"item_12164_Object1\" style=\"vertical-align:middle;\" src=\"item_12164_v10_Object1_png16malpha.png\" width=\"76\" height=\"13\" />?</p><p style=\"\">&#xA0;</p>]]></stem>\n" +
                        "      <optionlist>\n" +
                        "        <option>\n" +
                        "          <name>Option A</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><span id=\"item_12164_TAG_2_BEGIN\"><img id=\"CrossReference0\" src=\"item_12164_v10_item_12164_mml_svg_png__1.png\"/></span></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option B</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><span id=\"item_12164_TAG_3_BEGIN\"><img id=\"CrossReference1\" src=\"item_12164_v10_item_12164_mml_svg_png__2.png\"/></span></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option C</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><span id=\"item_12164_TAG_4_BEGIN\"><img id=\"CrossReference2\" src=\"item_12164_v10_item_12164_mml_svg_png__3.png\"/></span></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option D</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><span id=\"item_12164_TAG_5_BEGIN\"><img id=\"CrossReference3\" src=\"item_12164_v10_item_12164_mml_svg_png__4.png\"/></span></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "      </optionlist>\n" +
                        "      <attachmentlist />\n" +
                        "      <apipAccessibility>\n" +
                        "        <accessibilityInfo>\n" +
                        "          <accessElement identifier=\"ae4\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_12164_Object1\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>, negative 12 d is greater than or equal to negative 6</audioShortDesc>\n" +
                        "                <audioLongDesc />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">-12d .1: -6</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae5\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_12164_TAG_2_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>d is less than or equal to negative one half</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">`i'\\x00bb'8\"kmath\n" +
                        "_+xmlns=\"http://www.w3.org/1998/Math/Ma-\n" +
                        "thML\"&gt;_: \"kmi.1d\"k_/mi.1\n" +
                        "\"kmo.1`a'\\x0089'$\"k_/mo.1\n" +
                        "\"kmo.1`a'\\x0088''\"k_/mo.1 \"kmfrac\n" +
                        "bevelled.k8false0.1 \"kmn.1#a\"k_/mn.1\n" +
                        "\"kmn.1#b\"k_/mn.1 \"k_/mfrac.1 \"k_/math.1\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae6\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_12164_TAG_3_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>d is greater than or equal to negative one half</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">`i'\\x00bb'8\"kmath\n" +
                        "_+xmlns=\"http://www.w3.org/1998/Math/Ma-\n" +
                        "thML\"&gt;_: \"kmi.1d\"k_/mi.1\n" +
                        "\"kmo.1`a'\\x0089''\\x00a5'\"k_/mo.1\n" +
                        "\"kmo.1`a'\\x0088''\"k_/mo.1 \"kmfrac\n" +
                        "bevelled.k8false0.1 \"kmn.1#a\"k_/mn.1\n" +
                        "\"kmn.1#b\"k_/mn.1 \"k_/mfrac.1 \"k_/math.1\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae7\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_12164_TAG_4_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>d is less than or equal to one half</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">`i'\\x00bb'8\"kmath\n" +
                        "_+xmlns=\"http://www.w3.org/1998/Math/Ma-\n" +
                        "thML\"&gt;_: \"kmi.1d\"k_/mi.1\n" +
                        "\"kmo.1`a'\\x0089'$\"k_/mo.1 \"kmfrac\n" +
                        "bevelled.k8false0.1 \"kmn.1#a\"k_/mn.1\n" +
                        "\"kmn.1#b\"k_/mn.1 \"k_/mfrac.1 \"k_/math.1\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae8\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_12164_TAG_5_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>d is greater than or equal to one half</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">`i'\\x00bb'8\"kmath\n" +
                        "_+xmlns=\"http://www.w3.org/1998/Math/Ma-\n" +
                        "thML\"&gt;_: \"kmi.1d\"k_/mi.1\n" +
                        "\"kmo.1`a'\\x0089''\\x00a5'\"k_/mo.1 \"kmfrac\n" +
                        "bevelled.k8false0.1 \"kmn.1#a\"k_/mn.1\n" +
                        "\"kmn.1#b\"k_/mn.1 \"k_/mfrac.1 \"k_/math.1\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "        </accessibilityInfo>\n" +
                        "      </apipAccessibility>\n" +
                        "    </content>\n" +
                        "  </item>\n" +
                        "</itemrelease>\n"))
                .put("501", new GitLabItemMetaData("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>\n" +
                        "<metadata>\n" +
                        "  <smarterAppMetadata xmlns=\"http://www.smarterapp.org/ns/1/assessment_item_metadata\">\n" +
                        "    <Identifier>501</Identifier>\n" +
                        "    <ItemAuthorIdentifier>Teddy_Xiong</ItemAuthorIdentifier>\n" +
                        "    <ItemSpecFormat>SmarterApp</ItemSpecFormat>\n" +
                        "    <LastModifiedBy>Shashank_Abhyankar</LastModifiedBy>\n" +
                        "    <SecurityStatus>Secure</SecurityStatus>\n" +
                        "    <SmarterAppItemDescriptor>MATH.11.1.A-CED.1G</SmarterAppItemDescriptor>\n" +
                        "    <Subject>MATH</Subject>\n" +
                        "    <Version>16</Version>\n" +
                        "    <StimulusFormat>Standard</StimulusFormat>\n" +
                        "    <IntendedGrade>11</IntendedGrade>\n" +
                        "    <MinimumGrade>11</MinimumGrade>\n" +
                        "    <MaximumGrade>11</MaximumGrade>\n" +
                        "    <MathematicalPractice>8</MathematicalPractice>\n" +
                        "    <DepthOfKnowledge>2</DepthOfKnowledge>\n" +
                        "    <AchievementQuintile>4</AchievementQuintile>\n" +
                        "    <AllowCalculator>Y</AllowCalculator>\n" +
                        "    <InteractionType>EQ</InteractionType>\n" +
                        "    <MaximumNumberOfPoints>2</MaximumNumberOfPoints>\n" +
                        "    <ScorePoints>\"0, 1, 2\"</ScorePoints>\n" +
                        "    <ScoringEngine>Automatic with Machine Rubric</ScoringEngine>\n" +
                        "    <PresentationFormat>Text</PresentationFormat>\n" +
                        "    <AdministrationDate>Field Test</AdministrationDate>\n" +
                        "    <ContentTaskModel>TM1c_Det</ContentTaskModel>\n" +
                        "    <AlgebraFunctionDescriptor>Linear</AlgebraFunctionDescriptor>\n" +
                        "    <BrailleType>BRF_EBAE_UEB</BrailleType>\n" +
                        "    <EnemyItem></EnemyItem>\n" +
                        "    <CopyrightAndOtherRestrictions></CopyrightAndOtherRestrictions>\n" +
                        "    <StimulusScource></StimulusScource>\n" +
                        "    <Notes></Notes>\n" +
                        "    <PtClassroomActivity></PtClassroomActivity>\n" +
                        "    <PtEnemy></PtEnemy>\n" +
                        "    <AccessibilityTagsASLLanguage>Y</AccessibilityTagsASLLanguage>\n" +
                        "    <IrtDimension>\n" +
                        "      <IrtStatDomain>Online</IrtStatDomain>\n" +
                        "      <IrtModelType>IRTGPC</IrtModelType>\n" +
                        "      <IrtDimensionPurpose></IrtDimensionPurpose>\n" +
                        "      <IrtScore>2</IrtScore>\n" +
                        "      <IrtWeight>1</IrtWeight>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>a</Name>\n" +
                        "        <Value>0.44024</Value>\n" +
                        "      </IrtParameter>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>b0</Name>\n" +
                        "        <Value>0.5853</Value>\n" +
                        "      </IrtParameter>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>b1</Name>\n" +
                        "        <Value>0.47514</Value>\n" +
                        "      </IrtParameter>\n" +
                        "    </IrtDimension>\n" +
                        "    <Status>Operational</Status>\n" +
                        "    <StandardPublication>\n" +
                        "      <Publication>SBAC-MA-v6</Publication>\n" +
                        "      <PrimaryStandard>SBAC-MA-v6:2|A|NA|A</PrimaryStandard>\n" +
                        "    </StandardPublication>\n" +
                        "    <StandardPublication>\n" +
                        "      <Publication>SBAC-MA-v4</Publication>\n" +
                        "      <PrimaryStandard>SBAC-MA-v4:2|A-CED|A|NA|NA</PrimaryStandard>\n" +
                        "      <SecondaryStandard>SBAC-MA-v5:1|A-CED|G|a/s|A-CED.1</SecondaryStandard>\n" +
                        "    </StandardPublication>\n" +
                        "    <AssociatedTutorial>67863</AssociatedTutorial>\n" +
                        "    <AssociatedWordlist>57072</AssociatedWordlist>\n" +
                        "    <Language>eng</Language>\n" +
                        "    <Language>spa</Language>\n" +
                        "  </smarterAppMetadata>\n" +
                        "</metadata>\n", "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<itemrelease version=\"2.0\">\n" +
                        "  <item format=\"eq\" id=\"501\" version=\"16\" bankkey=\"200\">\n" +
                        "    <attriblist>\n" +
                        "      <attrib attid=\"itm_item_id\">\n" +
                        "        <name>Item: ITS ID</name>\n" +
                        "        <val>501</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_item_subject\">\n" +
                        "        <name>Item: Subject</name>\n" +
                        "        <val>MATH</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_item_desc\">\n" +
                        "        <name>Item: Item Description</name>\n" +
                        "        <val>MATH.11.1.A-CED.1G</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_FTUse\">\n" +
                        "        <name>Fieldtest Use</name>\n" +
                        "        <val>Platform::MG11::12.3 (70); Platform Math::March2014::GR11::ESN (1); Platform Math::March2014::GR11::ENUASL (5); CRESST G11 (2); SBAC-Int-PR1-FM1-Math-11 (1); SBAC-Int-PR1-FM1-Math-11-SPA (1);</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_OPUse\">\n" +
                        "        <name>Operational Use</name>\n" +
                        "        <val>CAT::MG11::ONCalc-S1-D::SP14 (4); CAT::MG11::ONONCalc-S1-A1::SP14 (1); FAKE MATH FORM (161); CAT::MG11::ONCalc-S1-A2::SP14 (1); CAT::MG11::ONCalc-S1-A4::SP14 (1); CAT::MG10::ONCalc-S1-A4::SP14 (1); CAT::MG11::ONCalc-S1-A3::SP14 (1); CAT::MG11::ONCalc-S4-A3::SP14 (1); CAT::MG11::CA-ONCalc::SP14 (1); CAT::MG10::ONCalc-S1-A4::SP14-ESN (1); CAT::MG11::ONONCalc-S1-A1::SP14-ESN (1); CAT::MG11::ONCalc-S1-D::SP14-ESN (1); CAT::MG11::ONCalc-S4-A3::SP14-ESN (1); CAT::MG11::ONCalc-S1-A2::SP14-ESN (1); CAT::MG11::ONCalc-S1-A3::SP14-ESN (1); CAT::MG8::UPCALC-S1-B::SP14-ESN (1); CAT::MG8::UPCALC-S4-B::SP14-ESN (1); CAT::MG11::CA-ONCalc::SP14-ESN (1); CAT::MATH910::VL11NoCALC-S2-C::SP14-ESN (1); CAT::MATH910::VL11NoCALC-S3-C::SP14-ESN (1); CAT::MG11::CA-ONCalc::D::SP14 (4); CAT::MG11::CA-ONCalc::D::SP14-ESN (1); CAT::MG11::CA-ONCalc::D (4); Math ICA G11 Calc 2015 ENG (6); Math ICA G11 Calc 2015 BRL (6); Math ICA G11 Calc 2015 SPA (6); Math ICA G11 Calc COMBINED 2015 ENG (6); Math ICA G11 Calc COMBINED 2015 BRL (6); Math ICA G11 Calc COMBINED 2015 SPA (6); IAB-G11M-AlgLinearFun-Calc-2015 ENG (4); IAB-G11M-AlgLinearFun-Calc-2015 BRL (4); IAB-G11M-AlgLinearFun-Calc-2015 SPA (4); IAB-G11M-AlgLinearFun-Calc-2015 ENG-COMBINED (4); IAB-G11M-AlgLinearFun-Calc-2015 BRL-COMBINED (4); IAB-G11M-AlgLinearFun-Calc-2015 SPA-COMBINED (4); Math ICA G11 Calc 2017 ENG (6); Math ICA G11 Calc 2017 BRL (6); Math ICA G11 Calc 2017 SPA (6); IAB-G11M-AlgLin-Calc-2017 ENG (1); IAB-G11M-AlgLin-Calc-2017 BRL (1); IAB-G11M-AlgLin-Calc-2017 SPA (1); Math ICA G11 Calc 2017 ENG COMBINED (6); Math ICA G11 Calc 2017 BRL COMBINED (6); Math ICA G11 Calc 2017 SPA COMBINED (6); IAB-G11M-AlgLin-Calc-2017 ENG COMBINED (1); IAB-G11M-AlgLin-Calc-2017 BRL COMBINED (1); IAB-G11M-AlgLin-Calc-2017 SPA COMBINED (1); Math ICA G11 Calc 2018 ENG (6); Math ICA G11 Calc 2018 BRL (6); Math ICA G11 Calc 2018 SPA (6); IAB-G11M-AlgLin-Calc-2018 ENG (1); IAB-G11M-AlgLin-Calc-2018 BRL (1); IAB-G11M-AlgLin-Calc-2018 SPA (1); Math ICA G11 Calc 2018 ENG COMBINED (6); Math ICA G11 Calc 2018 BRL COMBINED (6); Math ICA G11 Calc 2018 SPA COMBINED (6); IAB-G11M-AlgLin-Calc-2018 ENG COMBINED (1); IAB-G11M-AlgLin-Calc-2018 BRL COMBINED (1); IAB-G11M-AlgLin-Calc-2018 SPA COMBINED (1); HI Math ICA G11 Calc 2018 ENG (6); HI Math ICA G11 Calc 2018 BRL (6); HI Math ICA G11 Calc 2018 SPA (6); IAB-G11M-AlgLin-Calc-2019 ENG (1); IAB-G11M-AlgLin-Calc-2019 BRL (1); IAB-G11M-AlgLin-Calc-2019 SPA (1); Math ICA G11 Calc 2018 ENG_copy1 (6); Math ICA G11 Calc 2018 BRL_copy1 (6); Math ICA G11 Calc 2018 SPA_copy1 (6);</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Answer Key\">\n" +
                        "        <name>Item: Answer Key</name>\n" +
                        "        <val>EQ</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Grade\">\n" +
                        "        <name>Item: Grade</name>\n" +
                        "        <val>11</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Item Format\">\n" +
                        "        <name>Item: Item Format</name>\n" +
                        "        <val>EQ</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Page Layout\">\n" +
                        "        <name>Item: Page Layout</name>\n" +
                        "        <val>8</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Response Type\">\n" +
                        "        <name>Item: Response Type</name>\n" +
                        "        <val>EquationEditor</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Item Point\">\n" +
                        "        <name>Item: Item Point</name>\n" +
                        "        <val>2 pts.</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Answer Key (Part II)\">\n" +
                        "        <name>Item: Answer Key (Part II)</name>\n" +
                        "        <val>NA</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Max Choices\">\n" +
                        "        <name>Item:Max Choices</name>\n" +
                        "        <val>NA</val>\n" +
                        "        <desc>NA</desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Max Choices (Part II)\">\n" +
                        "        <name>Item:Max Choices (Part II)</name>\n" +
                        "        <val></val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "    </attriblist>\n" +
                        "    <tutorial id=\"67863\" bankkey=\"200\" />\n" +
                        "    <resourceslist>\n" +
                        "      <resource type=\"wordList\" id=\"57072\" index=\"1\" bankkey=\"200\" />\n" +
                        "    </resourceslist>\n" +
                        "    <statistic />\n" +
                        "    <MachineRubric filename=\"Item_501_v16.qrx\" />\n" +
                        "    <RendererSpec filename=\"Item_501_v16.eax\" />\n" +
                        "    <content language=\"ENU\" version=\"2.0\" approvedVersion=\"16\">\n" +
                        "      <rationaleoptlist />\n" +
                        "      <stem><![CDATA[<p style=\"\">There are <span id=\"item_501_TAG_1_BEGIN\">221</span> students on a <span id=\"item_501_TAG_9\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"4\"></span>field trip<span class=\"its-tag\" data-tag-ref=\"item_501_TAG_9\" data-tag-boundary=\"end\"></span>.<br /><br /></p><ul style=\"padding-left:1.5000em; \"><li><p style=\"\">Five students ride in a van.</p></li><li><p style=\"\">The rest of the students fill 6 buses.</p></li></ul><p style=\"\">&#xA0;</p><p style=\"\"><span id=\"item_501_TAG_3\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>Enter<span class=\"its-tag\" data-tag-ref=\"item_501_TAG_3\" data-tag-boundary=\"end\"></span> an equation that can be solved to find the number of students, <span style=\"font-style:italic; \">s</span>, that are on each bus. <span id=\"item_501_TAG_4\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>Enter<span class=\"its-tag\" data-tag-ref=\"item_501_TAG_4\" data-tag-boundary=\"end\"></span> your response in the <span id=\"item_501_TAG_5\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>first response box<span class=\"its-tag\" data-tag-ref=\"item_501_TAG_5\" data-tag-boundary=\"end\"></span>.</p><p style=\"\">&#xA0;</p><p style=\"\"><span id=\"item_501_TAG_6\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>Enter<span class=\"its-tag\" data-tag-ref=\"item_501_TAG_6\" data-tag-boundary=\"end\"></span> the number of students that are on each bus. <span id=\"item_501_TAG_7\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>Enter<span class=\"its-tag\" data-tag-ref=\"item_501_TAG_7\" data-tag-boundary=\"end\"></span> your response in the <span id=\"item_501_TAG_8\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"3\"></span>second response <span id=\"item_501_TAG_2_BEGIN\">box.</span><span class=\"its-tag\" data-tag-ref=\"item_501_TAG_8\" data-tag-boundary=\"end\"></span></p>]]></stem>\n" +
                        "      <rubriclist>\n" +
                        "        <rubric scorepoint=\"\">\n" +
                        "          <name>\n" +
                        "        Rubric </name>\n" +
                        "          <val><![CDATA[<p style=\"\"><span style=\"font-weight:bold; \">Exemplar</span>: 6<span style=\"font-style:italic; \">s</span> + 5 = 221;<span style=\"font-style:italic; \">s</span> = 36<br /><br /><span style=\"font-weight:bold; \">2 points</span>: student enters correct answer (e.g.,6<span style=\"font-style:italic; \">s</span> + 5 = 221;<span style=\"font-style:italic; \">s</span> = 36 or 36).<br /><br /><span style=\"font-weight:bold; \">1 point</span>: student enters only one correct answer (either an equivalent equation or the correct solution).</p>]]></val>\n" +
                        "        </rubric>\n" +
                        "        <samplelist maxval=\"\" minval=\"\" />\n" +
                        "      </rubriclist>\n" +
                        "      <attachmentlist>\n" +
                        "        <attachment id=\"braillefile1\" type=\"BRF\" subtype=\"TDS_BT_ECN\" file=\"item_501_enu_brf_ebae_contracted_nemeth_ecn.brf\" />\n" +
                        "        <attachment id=\"braillefile19\" type=\"BRF\" subtype=\"TDS_BT_UCN\" file=\"item_501_enu_brf_ueb_contracted_nemeth_ucn.brf\" />\n" +
                        "        <attachment id=\"braillefile31\" type=\"BRF\" subtype=\"TDS_BT_UCT\" file=\"item_501_enu_brf_ueb_contracted_ueb_math_uct.brf\" />\n" +
                        "        <attachment id=\"braillefile3\" type=\"BRF\" subtype=\"TDS_BT_EXN\" file=\"item_501_enu_brf_ebae_uncontracted_nemeth_exn.brf\" />\n" +
                        "        <attachment id=\"braillefile16\" type=\"BRF\" subtype=\"TDS_BT_UXN\" file=\"item_501_enu_brf_ueb_uncontracted_nemeth_uxn.brf\" />\n" +
                        "        <attachment id=\"braillefile27\" type=\"BRF\" subtype=\"TDS_BT_UXT\" file=\"item_501_enu_brf_ueb_uncontracted_ueb_math_uxt.brf\" />\n" +
                        "        <attachment id=\"aslfile1\" type=\"ASL\" subtype=\"STEM\" file=\"item_501_ASL_STEM.mp4\">\n" +
                        "          <source src=\"item_501_ASL_STEM.webm\" type=\"video/webm\" />\n" +
                        "          <source src=\"item_501_ASL_STEM.mp4\" type=\"video/mp4\" />\n" +
                        "        </attachment>\n" +
                        "      </attachmentlist>\n" +
                        "      <apipAccessibility>\n" +
                        "        <accessibilityInfo>\n" +
                        "          <accessElement identifier=\"ae1\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_501_TAG_1_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>2 hundred 21</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>221</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae9\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_501_TAG_2_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>box.  The equation tool has two sections. In the left section, from left to right and top to bottom the equation tool reeds, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, point, negative. In the right section mathematical functions are shown.</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>box.</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "        </accessibilityInfo>\n" +
                        "      </apipAccessibility>\n" +
                        "    </content>\n" +
                        "    <content language=\"ESN\" version=\"2.0\" approvedVersion=\"16\">\n" +
                        "      <stem><![CDATA[<p style=\"\">221 estudiantes van en una excursión.<br /><br /></p><ul style=\"padding-left:1.5000em; \"><li><p style=\"\">Cinco estudiantes van en una camioneta.</p></li><li><p style=\"\">El resto de los estudiantes ha llenado 6 autobuses.</p></li></ul><p style=\"\">&#xA0;</p><p style=\"\">Escribe una ecuación que pueda resolverse para encontrar el número de estudiantes, <span style=\"font-style:italic; \">s</span>, que van en cada autobús. Escribe tu contestación en la primera casilla de respuesta.</p><p style=\"\">&#xA0;</p><p style=\"\">Escribe el número de estudiantes que van en cada autobús. Escribe tu contestación en la segunda casilla de respuesta.</p><p class=\"languagedivider\">&#xA0;</p><p style=\"\">There are <span id=\"item_501_TAG_1_BEGIN\">221</span> students on a <span id=\"item_501_TAG_9\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"4\"></span>field trip<span class=\"its-tag\" data-tag-ref=\"item_501_TAG_9\" data-tag-boundary=\"end\"></span>.<br /><br /></p><ul style=\"padding-left:1.5000em; \"><li><p style=\"\">Five students ride in a van.</p></li><li><p style=\"\">The rest of the students fill 6 buses.</p></li></ul><p style=\"\">&#xA0;</p><p style=\"\"><span id=\"item_501_TAG_3\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>Enter<span class=\"its-tag\" data-tag-ref=\"item_501_TAG_3\" data-tag-boundary=\"end\"></span> an equation that can be solved to find the number of students, <span style=\"font-style:italic; \">s</span>, that are on each bus. <span id=\"item_501_TAG_4\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>Enter<span class=\"its-tag\" data-tag-ref=\"item_501_TAG_4\" data-tag-boundary=\"end\"></span> your response in the <span id=\"item_501_TAG_5\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>first response box<span class=\"its-tag\" data-tag-ref=\"item_501_TAG_5\" data-tag-boundary=\"end\"></span>.</p><p style=\"\">&#xA0;</p><p style=\"\"><span id=\"item_501_TAG_6\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>Enter<span class=\"its-tag\" data-tag-ref=\"item_501_TAG_6\" data-tag-boundary=\"end\"></span> the number of students that are on each bus. <span id=\"item_501_TAG_7\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>Enter<span class=\"its-tag\" data-tag-ref=\"item_501_TAG_7\" data-tag-boundary=\"end\"></span> your response in the <span id=\"item_501_TAG_8\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"3\"></span>second response <span id=\"item_501_TAG_2_BEGIN\">box.</span><span class=\"its-tag\" data-tag-ref=\"item_501_TAG_8\" data-tag-boundary=\"end\"></span></p>]]></stem>\n" +
                        "      <rubriclist>\n" +
                        "        <rubric scorepoint=\"_Spanish\">\n" +
                        "          <name>\n" +
                        "        Rubric _Spanish</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rubric>\n" +
                        "        <samplelist maxval=\"_Spanish\" minval=\"_Spanish\" />\n" +
                        "      </rubriclist>\n" +
                        "      <attachmentlist />\n" +
                        "      <apipAccessibility>\n" +
                        "        <accessibilityInfo>\n" +
                        "          <accessElement identifier=\"ae1\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_501_TAG_1_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>2 hundred 21</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>221</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae9\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_501_TAG_2_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>box.  The equation tool has two sections. In the left section, from left to right and top to bottom the equation tool reeds, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, point, negative. In the right section mathematical functions are shown.</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>box.</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "        </accessibilityInfo>\n" +
                        "      </apipAccessibility>\n" +
                        "    </content>\n" +
                        "  </item>\n" +
                        "</itemrelease>\n"))
                .put("35334", new GitLabItemMetaData("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>\n" +
                        "<metadata>\n" +
                        "  <smarterAppMetadata xmlns=\"http://www.smarterapp.org/ns/1/assessment_item_metadata\">\n" +
                        "    <Identifier>35334</Identifier>\n" +
                        "    <StimulusFormat>Standard</StimulusFormat>\n" +
                        "    <Subject>MATH</Subject>\n" +
                        "    <Version>20</Version>\n" +
                        "    <SecurityStatus>Secure</SecurityStatus>\n" +
                        "    <SmarterAppItemDescriptor>69980</SmarterAppItemDescriptor>\n" +
                        "    <ItemAuthorIdentifier>Sridhar_Ravva</ItemAuthorIdentifier>\n" +
                        "    <ItemSpecFormat>SmarterApp</ItemSpecFormat>\n" +
                        "    <LastModifiedBy>Sridhar_Ravva</LastModifiedBy>\n" +
                        "    <IntendedGrade>11</IntendedGrade>\n" +
                        "    <MinimumGrade>8</MinimumGrade>\n" +
                        "    <MaximumGrade>11</MaximumGrade>\n" +
                        "    <MathematicalPractice>None</MathematicalPractice>\n" +
                        "    <DepthOfKnowledge>2</DepthOfKnowledge>\n" +
                        "    <AchievementQuintile>3</AchievementQuintile>\n" +
                        "    <AllowCalculator>Y</AllowCalculator>\n" +
                        "    <InteractionType>MC</InteractionType>\n" +
                        "    <MaximumNumberOfPoints>1</MaximumNumberOfPoints>\n" +
                        "    <ScorePoints>\"0, 1\"</ScorePoints>\n" +
                        "    <ScoringEngine>Automatic with Key</ScoringEngine>\n" +
                        "    <PresentationFormat>Text With Graphics</PresentationFormat>\n" +
                        "    <AdministrationDate>Field Test</AdministrationDate>\n" +
                        "    <ContentTaskModel>TM4c_Rpdv</ContentTaskModel>\n" +
                        "    <AlgebraFunctionDescriptor>Linear</AlgebraFunctionDescriptor>\n" +
                        "    <BrailleType>PRN_EBAE_UEB</BrailleType>\n" +
                        "    <EnemyItem>0</EnemyItem>\n" +
                        "    <CopyrightAndOtherRestrictions>Not Set</CopyrightAndOtherRestrictions>\n" +
                        "    <PerformanceTaskComponentItem>N</PerformanceTaskComponentItem>\n" +
                        "    <PtEnemy>0</PtEnemy>\n" +
                        "    <AccessibilityTagsASLLanguage>Y</AccessibilityTagsASLLanguage>\n" +
                        "    <IrtDimension>\n" +
                        "      <IrtStatDomain>Online</IrtStatDomain>\n" +
                        "      <IrtModelType>IRT3PLN</IrtModelType>\n" +
                        "      <IrtDimensionPurpose></IrtDimensionPurpose>\n" +
                        "      <IrtScore>1</IrtScore>\n" +
                        "      <IrtWeight>1</IrtWeight>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>a</Name>\n" +
                        "        <Value>0.27484</Value>\n" +
                        "      </IrtParameter>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>b</Name>\n" +
                        "        <Value>0.61251</Value>\n" +
                        "      </IrtParameter>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>c</Name>\n" +
                        "        <Value>0</Value>\n" +
                        "      </IrtParameter>\n" +
                        "    </IrtDimension>\n" +
                        "    <Status>Operational</Status>\n" +
                        "    <StandardPublication>\n" +
                        "      <Publication>SBAC-MA-v6</Publication>\n" +
                        "      <PrimaryStandard>SBAC-MA-v6:1|P|TS04|J</PrimaryStandard>\n" +
                        "    </StandardPublication>\n" +
                        "    <StandardPublication>\n" +
                        "      <Publication>SBAC-MA-v4</Publication>\n" +
                        "      <PrimaryStandard>SBAC-MA-v4:1|A-REI|J|m|A-REI.12</PrimaryStandard>\n" +
                        "    </StandardPublication>\n" +
                        "    <AssociatedTutorial>67708</AssociatedTutorial>\n" +
                        "    <AssociatedWordlist>55711</AssociatedWordlist>\n" +
                        "    <Language>eng</Language>\n" +
                        "    <Language>spa</Language>\n" +
                        "  </smarterAppMetadata>\n" +
                        "</metadata>\n", "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<itemrelease version=\"2.0\">\n" +
                        "  <item format=\"mc\" id=\"35334\" version=\"20\" bankkey=\"200\">\n" +
                        "    <attriblist>\n" +
                        "      <attrib attid=\"itm_item_id\">\n" +
                        "        <name>Item: ITS ID</name>\n" +
                        "        <val>35334</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_item_subject\">\n" +
                        "        <name>Item: Subject</name>\n" +
                        "        <val>MATH</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_item_desc\">\n" +
                        "        <name>Item: Item Description</name>\n" +
                        "        <val>69980</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_FTUse\">\n" +
                        "        <name>Fieldtest Use</name>\n" +
                        "        <val>Platform::MG11::1.7C (284); SBAC-Int-PR1-FM1-Math-11 (2); SBAC-Int-PR1-FM1-Math-11-SPA (2);</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_OPUse\">\n" +
                        "        <name>Operational Use</name>\n" +
                        "        <val>CAT::MG11::ONCalc-S1-D::SP14 (1662); CAT::MG11::ONONCalc-S1-A1::SP14 (334); FAKE MATH FORM (7793); CAT::MG11::ONCalc-S1-A2::SP14 (334); CAT::MG11::ONCalc-S1-A4::SP14 (334); CAT::MG10::ONCalc-S1-A4::SP14 (334); CAT::MG11::ONCalc-S1-A3::SP14 (334); CAT::MG11::ONCalc-S4-A3::SP14 (334); CAT::MG11::CA-ONCalc::SP14 (334); CAT::MG10::ONCalc-S1-A4::SP14-ESN (331); CAT::MG11::ONONCalc-S1-A1::SP14-ESN (331); CAT::MG11::ONCalc-S1-D::SP14-ESN (331); CAT::MG11::ONCalc-S4-A3::SP14-ESN (331); CAT::MG11::ONCalc-S1-A2::SP14-ESN (331); CAT::MG11::ONCalc-S1-A3::SP14-ESN (331); CAT::MG8::UPCALC-S1-B::SP14-ESN (331); CAT::MG8::UPCALC-S4-B::SP14-ESN (331); CAT::MG11::CA-ONCalc::SP14-ESN (331); CAT::MATH910::VL11NoCALC-S2-C::SP14-ESN (331); CAT::MATH910::VL11NoCALC-S3-C::SP14-ESN (331); CAT::MG11::CA-ONCalc::D::SP14 (1662); CAT::MG11::CA-ONCalc::D::SP14-ESN (331); CAT::MG11::CA-ONCalc::D (1662); IAB-G11M-AlgLinearFun-Calc-2015 ENG (5); IAB-G11M-AlgLinearFun-Calc-2015 BRL (5); IAB-G11M-AlgLinearFun-Calc-2015 SPA (5); IAB-G11M-AlgLinearFun-Calc-2015 ENG-COMBINED (5); IAB-G11M-AlgLinearFun-Calc-2015 BRL-COMBINED (5); IAB-G11M-AlgLinearFun-Calc-2015 SPA-COMBINED (5); IAB-G11M-AlgLin-Calc-2017 ENG (2); IAB-G11M-AlgLin-Calc-2017 BRL (2); IAB-G11M-AlgLin-Calc-2017 SPA (2); IAB-G11M-AlgLin-Calc-2017 ENG COMBINED (2); IAB-G11M-AlgLin-Calc-2017 BRL COMBINED (2); IAB-G11M-AlgLin-Calc-2017 SPA COMBINED (2); IAB-G11M-AlgLin-Calc-2018 ENG (2); IAB-G11M-AlgLin-Calc-2018 BRL (2); IAB-G11M-AlgLin-Calc-2018 SPA (2); IAB-G11M-AlgLin-Calc-2018 ENG COMBINED (2); IAB-G11M-AlgLin-Calc-2018 BRL COMBINED (2); IAB-G11M-AlgLin-Calc-2018 SPA COMBINED (2); IAB-G11M-AlgLin-Calc-2019 ENG (2); IAB-G11M-AlgLin-Calc-2019 BRL (2); IAB-G11M-AlgLin-Calc-2019 SPA (2);</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Answer Key\">\n" +
                        "        <name>Item: Answer Key</name>\n" +
                        "        <val>B</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Grade\">\n" +
                        "        <name>Item: Grade</name>\n" +
                        "        <val>11</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Item Format\">\n" +
                        "        <name>Item: Item Format</name>\n" +
                        "        <val>MC</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Page Layout\">\n" +
                        "        <name>Item: Page Layout</name>\n" +
                        "        <val>8</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Response Type\">\n" +
                        "        <name>Item: Response Type</name>\n" +
                        "        <val>Vertical</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Item Point\">\n" +
                        "        <name>Item: Item Point</name>\n" +
                        "        <val>1 pt.</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Answer Key (Part II)\">\n" +
                        "        <name>Item: Answer Key (Part II)</name>\n" +
                        "        <val></val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Max Choices\">\n" +
                        "        <name>Item:Max Choices</name>\n" +
                        "        <val>NA</val>\n" +
                        "        <desc>NA</desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Max Choices (Part II)\">\n" +
                        "        <name>Item:Max Choices (Part II)</name>\n" +
                        "        <val></val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "    </attriblist>\n" +
                        "    <tutorial id=\"67708\" bankkey=\"200\" />\n" +
                        "    <resourceslist>\n" +
                        "      <resource type=\"wordList\" id=\"55711\" index=\"1\" bankkey=\"200\" />\n" +
                        "    </resourceslist>\n" +
                        "    <statistic />\n" +
                        "    <content language=\"ENU\" version=\"2.0\" approvedVersion=\"20\">\n" +
                        "      <concept>\n" +
                        "        <name>What Knowledge Do Students Need to Understand This Concept?</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </concept>\n" +
                        "      <es>\n" +
                        "        <name>Explanation of Correct Answer</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </es>\n" +
                        "      <himi>\n" +
                        "        <name>Explanation of Correct Answer</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </himi>\n" +
                        "      <rationaleoptlist>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option A</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option B</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option C</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option D</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "      </rationaleoptlist>\n" +
                        "      <stem><![CDATA[<p style=\"\"><span id=\"item_35334_TAG_7\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>Select<span class=\"its-tag\" data-tag-ref=\"item_35334_TAG_7\" data-tag-boundary=\"end\"></span> the graph that best represents the solution set of the system of linear inequalities.<br /> <br /><img id=\"CrossReference0\" src=\"item_35334_v20_item_35334_mml_svg_png__0.png\"/></p><p style=\"\"><br /><img id=\"CrossReference1\" src=\"item_35334_v20_item_35334_mml_svg_png__1.png\"/></p>]]></stem>\n" +
                        "      <optionlist>\n" +
                        "        <option>\n" +
                        "          <name>Option A</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"item_35334_graphics1\" src=\"item_35334_v20_graphics1_png256.png\" width=\"288\" height=\"234\" style=\"vertical-align:baseline;\" /></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\"> The student makes both lines dashed.</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option B</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"item_35334_graphics2\" src=\"item_35334_v20_graphics2_png256.png\" width=\"288\" height=\"234\" style=\"vertical-align:baseline;\" /></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">Key</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option C</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"item_35334_graphics3\" src=\"item_35334_v20_graphics3_png256.png\" width=\"288\" height=\"234\" style=\"vertical-align:baseline;\" /></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\"> The student makes the wrong line dashed.</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option D</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"item_35334_graphics4\" src=\"item_35334_v20_graphics4_png256.png\" width=\"288\" height=\"234\" style=\"vertical-align:baseline;\" /></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\"> The student makes both lines solid.</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "      </optionlist>\n" +
                        "      <attachmentlist>\n" +
                        "        <attachment id=\"braillefile2\" type=\"PRN\" subtype=\"TDS_BT_ECN\" file=\"item_35334_enu_prn_ebae_contracted_nemeth_ecn.prn\" />\n" +
                        "        <attachment id=\"braillefile21\" type=\"PRN\" subtype=\"TDS_BT_UCN\" file=\"item_35334_enu_prn_ueb_contracted_nemeth_ucn.prn\" />\n" +
                        "        <attachment id=\"braillefile32\" type=\"PRN\" subtype=\"TDS_BT_UCT\" file=\"item_35334_enu_prn_ueb_contracted_ueb_math_uct.prn\" />\n" +
                        "        <attachment id=\"braillefile4\" type=\"PRN\" subtype=\"TDS_BT_EXN\" file=\"item_35334_enu_prn_ebae_uncontracted_nemeth_exn.prn\" />\n" +
                        "        <attachment id=\"braillefile18\" type=\"PRN\" subtype=\"TDS_BT_UXN\" file=\"item_35334_enu_prn_ueb_uncontracted_nemeth_uxn.prn\" />\n" +
                        "        <attachment id=\"braillefile28\" type=\"PRN\" subtype=\"TDS_BT_UXT\" file=\"item_35334_enu_prn_ueb_uncontracted_ueb_math_uxt.prn\" />\n" +
                        "        <attachment id=\"aslfile1\" type=\"ASL\" subtype=\"STEM\" file=\"item_35334_ASL_STEM.mp4\">\n" +
                        "          <source src=\"item_35334_ASL_STEM.webm\" type=\"video/webm\" />\n" +
                        "          <source src=\"item_35334_ASL_STEM.mp4\" type=\"video/mp4\" />\n" +
                        "        </attachment>\n" +
                        "      </attachmentlist>\n" +
                        "      <apipAccessibility>\n" +
                        "        <accessibilityInfo>\n" +
                        "          <accessElement identifier=\"ae2\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference0\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>why is greater than or equal to negative two fifths x plus 4,</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">y .1: -?2/5#x+4</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae3\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference1\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>why  is greater than  5 x  plus  2;</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">y .1 #5x+2</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae4\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_35334_graphics1\" type=\"Graphic\" subtype=\"Generic\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioText>The horizontal axis has a range from  negative 5 to 9, \n" +
                        "increasing in increments of 1;  The vertical axis  has a range from negative 1 to 10, increasing in increments of 1.</audioText>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>The horizontal axis has a range from  negative 5 to 9, \n" +
                        "increasing in increments of 1;  The vertical axis  has a range from negative 1 to 10, increasing in increments of 1. There are two straight dotted lines on the graph. The first dotted line passes through the points, negative five comma six, zero comma four, and five comma two. The section of the graph above this line is shaded. The second dotted line passes through the points, zero comma two, and one comma seven. The section of the graph to the left of this line is shaded. The top left section of the graph that is shaded due to both lines is shaded darker than the other shaded sections.</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae5\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_35334_graphics2\" type=\"Graphic\" subtype=\"Generic\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioText>The horizontal axis has a range from negative 5 to 9, \n" +
                        "increasing in increments of 1;  The vertical axis has a range from negative 1 to 10, increasing in increments of 1.</audioText>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>The horizontal axis has a range from  negative 5 to 9, \n" +
                        "increasing in increments of 1;  The vertical axis  has a range from negative 1 to 10, increasing in increments of 1. There are two straight  lines on the graph. The first line is solid and passes through the points, negative five comma six, zero comma four, and five comma two. The section of the graph above this line is shaded. The second  line is dotted and passes through the points, zero comma two, and one comma seven. The section of the graph to the left of this line is shaded. The top left section of the graph that is shaded due to both lines is shaded darker than the other shaded sections.</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae6\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_35334_graphics3\" type=\"Graphic\" subtype=\"Generic\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioText>The horizontal axis has a range from negative 5 to 9, \n" +
                        "increasing in increments of 1;  The vertical axis has a range from negative 1 to 10, increasing in increments of 1.</audioText>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>The horizontal axis has a range from  negative 5 to 9, \n" +
                        "increasing in increments of 1;  The vertical axis  has a range from negative 1 to 10, increasing in increments of 1. There are two straight  lines on the graph. The first line is dotted and passes through the points, negative five comma six, zero comma four, and five comma two. The section of the graph above this line is shaded. The second  line is solid and passes through the points, zero comma two, and one comma seven. The section of the graph to the left of this line is shaded. The top left section of the graph that is shaded due to both lines is shaded darker than the other shaded sections.</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae7\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_35334_graphics4\" type=\"Graphic\" subtype=\"Generic\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioText>The horizontal axis has a range from negative 5 to 9, \n" +
                        "increasing in increments of 1;  The vertical axis has a range from negative 1 to 10, increasing in increments of 1.</audioText>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>The horizontal axis has a range from  negative 5 to 9, \n" +
                        "increasing in increments of 1;  The vertical axis  has a range from negative 1 to 10, increasing in increments of 1. There are two straight solid lines on the graph. The first solid line passes through the points, negative five comma six, zero comma four, and five comma two. The section of the graph above this line is shaded. The second solid line passes through the points, zero comma two, and one comma seven. The section of the graph to the left of this line is shaded. The top left section of the graph that is shaded due to both lines is shaded darker than the other shaded sections.</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "        </accessibilityInfo>\n" +
                        "      </apipAccessibility>\n" +
                        "    </content>\n" +
                        "    <content language=\"ESN\" version=\"2.0\" approvedVersion=\"11\">\n" +
                        "      <concept>\n" +
                        "        <name>What Knowledge Do Students Need to Understand This Concept?</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </concept>\n" +
                        "      <es>\n" +
                        "        <name>Explanation of Correct Answer</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </es>\n" +
                        "      <himi>\n" +
                        "        <name>Explanation of Correct Answer</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </himi>\n" +
                        "      <rationaleoptlist>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option A</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option B</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option C</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option D</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "      </rationaleoptlist>\n" +
                        "      <stem><![CDATA[<p style=\"\">Selecciona la gráfica que muestra el cojunto de soluciones del sistema de desigualdades lineales.</p><p class=\"languagedivider\">&#xA0;</p><p style=\"\"><span id=\"item_35334_TAG_7\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>Select<span class=\"its-tag\" data-tag-ref=\"item_35334_TAG_7\" data-tag-boundary=\"end\"></span> the graph that best represents the solution set of the system of linear inequalities.<br /> <br /><img id=\"CrossReference0\" src=\"item_35334_v11_item_35334_mml_svg_png__0.png\"/></p><p style=\"\"><br /><img id=\"CrossReference1\" src=\"item_35334_v11_item_35334_mml_svg_png__1.png\"/></p>]]></stem>\n" +
                        "      <optionlist>\n" +
                        "        <option>\n" +
                        "          <name>Option A</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"item_35334_graphics5\" src=\"item_35334_v11_graphics5_png256.png\" width=\"288\" height=\"234\" style=\"vertical-align:baseline;\" /></p><p class=\"languagedivider\">&#xA0;</p><p style=\"\"><img id=\"item_35334_graphics1\" src=\"item_35334_v11_graphics1_png256.png\" width=\"288\" height=\"234\" style=\"vertical-align:baseline;\" /></p><p class=\"optiondivider\">&#xA0;</p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option B</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"item_35334_graphics6\" src=\"item_35334_v11_graphics6_png256.png\" width=\"288\" height=\"234\" style=\"vertical-align:baseline;\" /></p><p class=\"languagedivider\">&#xA0;</p><p style=\"\"><img id=\"item_35334_graphics2\" src=\"item_35334_v11_graphics2_png256.png\" width=\"288\" height=\"234\" style=\"vertical-align:baseline;\" /></p><p class=\"optiondivider\">&#xA0;</p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option C</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"item_35334_graphics7\" src=\"item_35334_v11_graphics7_png256.png\" width=\"288\" height=\"234\" style=\"vertical-align:baseline;\" /></p><p class=\"languagedivider\">&#xA0;</p><p style=\"\"><img id=\"item_35334_graphics3\" src=\"item_35334_v11_graphics3_png256.png\" width=\"288\" height=\"234\" style=\"vertical-align:baseline;\" /></p><p class=\"optiondivider\">&#xA0;</p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option D</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"item_35334_graphics8\" src=\"item_35334_v11_graphics8_png256.png\" width=\"288\" height=\"234\" style=\"vertical-align:baseline;\" /></p><p class=\"languagedivider\">&#xA0;</p><p style=\"\"><img id=\"item_35334_graphics4\" src=\"item_35334_v11_graphics4_png256.png\" width=\"288\" height=\"234\" style=\"vertical-align:baseline;\" /></p><p class=\"optiondivider\">&#xA0;</p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "      </optionlist>\n" +
                        "      <attachmentlist />\n" +
                        "      <apipAccessibility>\n" +
                        "        <accessibilityInfo>\n" +
                        "          <accessElement identifier=\"ae2\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference0\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>why is greater than or equal to negative two fifths x plus 4,</audioShortDesc>\n" +
                        "                <audioLongDesc />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">y .1: -?2/5#x+4</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae3\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference1\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>why  is greater than  5 x  plus  2;</audioShortDesc>\n" +
                        "                <audioLongDesc />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">y .1 #5x+2</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae4\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_35334_graphics1\" type=\"Graphic\" subtype=\"Generic\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioText>The horizontal axis has a range from  negative 5 to 9, \n" +
                        "increasing in increments of 1;  The vertical axis  has a range from negative 1 to 10, increasing in increments of 1.</audioText>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText />\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae5\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_35334_graphics2\" type=\"Graphic\" subtype=\"Generic\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioText>The horizontal axis has a range from negative 5 to 9, \n" +
                        "increasing in increments of 1;  The vertical axis has a range from negative 1 to 10, increasing in increments of 1.</audioText>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText />\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae6\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_35334_graphics3\" type=\"Graphic\" subtype=\"Generic\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioText>The horizontal axis has a range from negative 5 to 9, \n" +
                        "increasing in increments of 1;  The vertical axis has a range from negative 1 to 10, increasing in increments of 1.</audioText>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText />\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae7\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_35334_graphics4\" type=\"Graphic\" subtype=\"Generic\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioText>The horizontal axis has a range from negative 5 to 9, \n" +
                        "increasing in increments of 1;  The vertical axis has a range from negative 1 to 10, increasing in increments of 1.</audioText>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText />\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "        </accessibilityInfo>\n" +
                        "      </apipAccessibility>\n" +
                        "    </content>\n" +
                        "  </item>\n" +
                        "</itemrelease>\n"))
                .put("33727", new GitLabItemMetaData("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>\n" +
                        "<metadata>\n" +
                        "  <smarterAppMetadata xmlns=\"http://www.smarterapp.org/ns/1/assessment_item_metadata\">\n" +
                        "    <Identifier>33727</Identifier>\n" +
                        "    <ItemAuthorIdentifier>Sridhar_Ravva</ItemAuthorIdentifier>\n" +
                        "    <ItemSpecFormat>SmarterApp</ItemSpecFormat>\n" +
                        "    <LastModifiedBy>Sridhar_Ravva</LastModifiedBy>\n" +
                        "    <SecurityStatus>Secure</SecurityStatus>\n" +
                        "    <SmarterAppItemDescriptor>70410</SmarterAppItemDescriptor>\n" +
                        "    <StimulusFormat>Standard</StimulusFormat>\n" +
                        "    <Subject>MATH</Subject>\n" +
                        "    <Version>11</Version>\n" +
                        "    <IntendedGrade>11</IntendedGrade>\n" +
                        "    <MinimumGrade>8</MinimumGrade>\n" +
                        "    <MaximumGrade>11</MaximumGrade>\n" +
                        "    <MathematicalPractice>None</MathematicalPractice>\n" +
                        "    <DepthOfKnowledge>2</DepthOfKnowledge>\n" +
                        "    <AchievementQuintile>1</AchievementQuintile>\n" +
                        "    <AllowCalculator>Y</AllowCalculator>\n" +
                        "    <InteractionType>MC</InteractionType>\n" +
                        "    <MaximumNumberOfPoints>1</MaximumNumberOfPoints>\n" +
                        "    <ScorePoints>\"0, 1\"</ScorePoints>\n" +
                        "    <ScoringEngine>Automatic with Key</ScoringEngine>\n" +
                        "    <PresentationFormat>Text With Graphics</PresentationFormat>\n" +
                        "    <AdministrationDate>Field Test</AdministrationDate>\n" +
                        "    <ContentTaskModel>TM1a_Rpdv</ContentTaskModel>\n" +
                        "    <AlgebraFunctionDescriptor>Linear</AlgebraFunctionDescriptor>\n" +
                        "    <BrailleType>PRN_EBAE_UEB</BrailleType>\n" +
                        "    <EnemyItem>0</EnemyItem>\n" +
                        "    <CopyrightAndOtherRestrictions>Not Set</CopyrightAndOtherRestrictions>\n" +
                        "    <PerformanceTaskComponentItem>N</PerformanceTaskComponentItem>\n" +
                        "    <PtEnemy>0</PtEnemy>\n" +
                        "    <AccessibilityTagsASLLanguage>Y</AccessibilityTagsASLLanguage>\n" +
                        "    <IrtDimension>\n" +
                        "      <IrtStatDomain>Online</IrtStatDomain>\n" +
                        "      <IrtModelType>IRT3PLN</IrtModelType>\n" +
                        "      <IrtDimensionPurpose></IrtDimensionPurpose>\n" +
                        "      <IrtScore>1</IrtScore>\n" +
                        "      <IrtWeight>1</IrtWeight>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>a</Name>\n" +
                        "        <Value>0.38809</Value>\n" +
                        "      </IrtParameter>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>b</Name>\n" +
                        "        <Value>-0.87142</Value>\n" +
                        "      </IrtParameter>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>c</Name>\n" +
                        "        <Value>0</Value>\n" +
                        "      </IrtParameter>\n" +
                        "    </IrtDimension>\n" +
                        "    <Status>Operational</Status>\n" +
                        "    <StandardPublication>\n" +
                        "      <Publication>SBAC-MA-v4</Publication>\n" +
                        "      <PrimaryStandard>SBAC-MA-v4:1|A-REI|J|m|A-REI.10</PrimaryStandard>\n" +
                        "    </StandardPublication>\n" +
                        "    <StandardPublication>\n" +
                        "      <Publication>SBAC-MA-v6</Publication>\n" +
                        "      <PrimaryStandard>SBAC-MA-v6:1|P|TS04|J</PrimaryStandard>\n" +
                        "    </StandardPublication>\n" +
                        "    <AssociatedTutorial>67708</AssociatedTutorial>\n" +
                        "    <AssociatedWordlist>55706</AssociatedWordlist>\n" +
                        "    <Language>eng</Language>\n" +
                        "    <Language>spa</Language>\n" +
                        "  </smarterAppMetadata>\n" +
                        "</metadata>\n", "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<itemrelease version=\"2.0\">\n" +
                        "  <item format=\"mc\" id=\"33727\" version=\"11\" bankkey=\"200\">\n" +
                        "    <attriblist>\n" +
                        "      <attrib attid=\"itm_item_id\">\n" +
                        "        <name>Item: ITS ID</name>\n" +
                        "        <val>33727</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_item_subject\">\n" +
                        "        <name>Item: Subject</name>\n" +
                        "        <val>MATH</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_item_desc\">\n" +
                        "        <name>Item: Item Description</name>\n" +
                        "        <val>70410</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_FTUse\">\n" +
                        "        <name>Fieldtest Use</name>\n" +
                        "        <val>Platform::MG11::1.7C (150); SBAC-Int-PR1-FM1-Math-11 (3); SBAC-Int-PR1-FM1-Math-11-SPA (3);</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_OPUse\">\n" +
                        "        <name>Operational Use</name>\n" +
                        "        <val>CAT::MG11::ONCalc-S1-D::SP14 (1539); CAT::MG11::ONONCalc-S1-A1::SP14 (318); FAKE MATH FORM (7612); CAT::MG11::ONCalc-S1-A2::SP14 (318); CAT::MG11::ONCalc-S1-A4::SP14 (318); CAT::MG10::ONCalc-S1-A4::SP14 (318); CAT::MG11::ONCalc-S1-A3::SP14 (318); CAT::MG11::ONCalc-S4-A3::SP14 (318); CAT::MG11::CA-ONCalc::SP14 (318); CAT::MG10::ONCalc-S1-A4::SP14-ESN (315); CAT::MG11::ONONCalc-S1-A1::SP14-ESN (315); CAT::MG11::ONCalc-S1-D::SP14-ESN (315); CAT::MG11::ONCalc-S4-A3::SP14-ESN (315); CAT::MG11::ONCalc-S1-A2::SP14-ESN (315); CAT::MG11::ONCalc-S1-A3::SP14-ESN (315); CAT::MG8::UPCALC-S1-B::SP14-ESN (315); CAT::MG8::UPCALC-S4-B::SP14-ESN (315); CAT::MG11::CA-ONCalc::SP14-ESN (315); CAT::MATH910::VL11NoCALC-S2-C::SP14-ESN (315); CAT::MATH910::VL11NoCALC-S3-C::SP14-ESN (315); CAT::MG11::CA-ONCalc::D::SP14 (1539); CAT::MG11::CA-ONCalc::D::SP14-ESN (315); CAT::MG11::CA-ONCalc::D (1539); IAB-G11M-AlgLinearFun-Calc-2015 ENG (1); IAB-G11M-AlgLinearFun-Calc-2015 BRL (1); IAB-G11M-AlgLinearFun-Calc-2015 SPA (1); IAB-G11M-AlgLinearFun-Calc-2015 ENG-COMBINED (1); IAB-G11M-AlgLinearFun-Calc-2015 BRL-COMBINED (1); IAB-G11M-AlgLinearFun-Calc-2015 SPA-COMBINED (1); IAB-G11M-AlgLin-Calc-2017 ENG (3); IAB-G11M-AlgLin-Calc-2017 BRL (3); IAB-G11M-AlgLin-Calc-2017 SPA (3); IAB-G11M-AlgLin-Calc-2017 ENG COMBINED (3); IAB-G11M-AlgLin-Calc-2017 BRL COMBINED (3); IAB-G11M-AlgLin-Calc-2017 SPA COMBINED (3); IAB-G11M-AlgLin-Calc-2018 ENG (3); IAB-G11M-AlgLin-Calc-2018 BRL (3); IAB-G11M-AlgLin-Calc-2018 SPA (3); IAB-G11M-AlgLin-Calc-2018 ENG COMBINED (3); IAB-G11M-AlgLin-Calc-2018 BRL COMBINED (3); IAB-G11M-AlgLin-Calc-2018 SPA COMBINED (3); IAB-G11M-AlgLin-Calc-2019 ENG (3); IAB-G11M-AlgLin-Calc-2019 BRL (3); IAB-G11M-AlgLin-Calc-2019 SPA (3);</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Answer Key\">\n" +
                        "        <name>Item: Answer Key</name>\n" +
                        "        <val>A</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Grade\">\n" +
                        "        <name>Item: Grade</name>\n" +
                        "        <val>11</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Item Format\">\n" +
                        "        <name>Item: Item Format</name>\n" +
                        "        <val>MC</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Page Layout\">\n" +
                        "        <name>Item: Page Layout</name>\n" +
                        "        <val>8</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Response Type\">\n" +
                        "        <name>Item: Response Type</name>\n" +
                        "        <val>Vertical</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Item Point\">\n" +
                        "        <name>Item: Item Point</name>\n" +
                        "        <val>1 pt.</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Answer Key (Part II)\">\n" +
                        "        <name>Item: Answer Key (Part II)</name>\n" +
                        "        <val></val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Max Choices\">\n" +
                        "        <name>Item:Max Choices</name>\n" +
                        "        <val></val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Max Choices (Part II)\">\n" +
                        "        <name>Item:Max Choices (Part II)</name>\n" +
                        "        <val></val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "    </attriblist>\n" +
                        "    <tutorial id=\"67708\" bankkey=\"200\" />\n" +
                        "    <resourceslist>\n" +
                        "      <resource type=\"wordList\" id=\"55706\" index=\"1\" bankkey=\"200\" />\n" +
                        "    </resourceslist>\n" +
                        "    <statistic />\n" +
                        "    <content language=\"ENU\" version=\"2.0\" approvedVersion=\"11\">\n" +
                        "      <concept>\n" +
                        "        <name>What Knowledge Do Students Need to Understand This Concept?</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </concept>\n" +
                        "      <es>\n" +
                        "        <name>Explanation of Correct Answer</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </es>\n" +
                        "      <himi>\n" +
                        "        <name>Explanation of Correct Answer</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </himi>\n" +
                        "      <rationaleoptlist>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option A</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option B</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option C</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option D</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "      </rationaleoptlist>\n" +
                        "      <stem><![CDATA[<p style=\"\"><span id=\"item_33727_TAG_6\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>Select<span class=\"its-tag\" data-tag-ref=\"item_33727_TAG_6\" data-tag-boundary=\"end\"></span> the ordered pair that is a solution to the equation represented by the graph.</p><p style=\"\"><br /><img id=\"item_33727_graphics1\" src=\"item_33727_v11_graphics1_png256.png\" width=\"289\" height=\"297\" style=\"vertical-align:baseline;\" /></p>]]></stem>\n" +
                        "      <optionlist>\n" +
                        "        <option>\n" +
                        "          <name>Option A</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><span id=\"item_33727_TAG_2_BEGIN\">(4, 0)</span></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">Correct</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option B</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><span id=\"item_33727_TAG_3_BEGIN\">(2, 3)</span></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">The student picks a point near line with integer coordinates.</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option C</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><span id=\"item_33727_TAG_4_BEGIN\">(5, 0)</span></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">The student reverses x and y.</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option D</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><span id=\"item_33727_TAG_5_BEGIN\">(3, 2)</span></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">The student picks a point near line with integer coordinates.</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "      </optionlist>\n" +
                        "      <attachmentlist>\n" +
                        "        <attachment id=\"braillefile2\" type=\"PRN\" subtype=\"TDS_BT_ECN\" file=\"item_33727_enu_prn_ebae_contracted_nemeth_ecn.prn\" />\n" +
                        "        <attachment id=\"braillefile21\" type=\"PRN\" subtype=\"TDS_BT_UCN\" file=\"item_33727_enu_prn_ueb_contracted_nemeth_ucn.prn\" />\n" +
                        "        <attachment id=\"braillefile32\" type=\"PRN\" subtype=\"TDS_BT_UCT\" file=\"item_33727_enu_prn_ueb_contracted_ueb_math_uct.prn\" />\n" +
                        "        <attachment id=\"braillefile4\" type=\"PRN\" subtype=\"TDS_BT_EXN\" file=\"item_33727_enu_prn_ebae_uncontracted_nemeth_exn.prn\" />\n" +
                        "        <attachment id=\"braillefile18\" type=\"PRN\" subtype=\"TDS_BT_UXN\" file=\"item_33727_enu_prn_ueb_uncontracted_nemeth_uxn.prn\" />\n" +
                        "        <attachment id=\"braillefile28\" type=\"PRN\" subtype=\"TDS_BT_UXT\" file=\"item_33727_enu_prn_ueb_uncontracted_ueb_math_uxt.prn\" />\n" +
                        "        <attachment id=\"aslfile1\" type=\"ASL\" subtype=\"STEM\" file=\"item_33727_ASL_STEM.mp4\">\n" +
                        "          <source src=\"item_33727_ASL_STEM.webm\" type=\"video/webm\" />\n" +
                        "          <source src=\"item_33727_ASL_STEM.mp4\" type=\"video/mp4\" />\n" +
                        "        </attachment>\n" +
                        "      </attachmentlist>\n" +
                        "      <apipAccessibility>\n" +
                        "        <accessibilityInfo>\n" +
                        "          <accessElement identifier=\"ae2\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_33727_graphics1\" type=\"Graphic\" subtype=\"Generic\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioText>The x axis has a range from negative 2 to 8, increasing in increments of 2.  The why axis has a range from negative 2 to 8, increasing in increments of 2;</audioText>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>The x axis has a range from negative 2 to 8, increasing in increments of 2.  The why axis has a range from negative 2 to 8, increasing in increments of 2; A straight line passes through the points, zero comma five, and two comma two point five.</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae3\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_33727_TAG_2_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>4 comma 0</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>(4, 0)</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae4\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_33727_TAG_3_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>2 comma 3</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>(2, 3)</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae5\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_33727_TAG_4_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>5 comma 0</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>(5, 0)</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae6\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_33727_TAG_5_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>3 comma 2</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>(3, 2)</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "        </accessibilityInfo>\n" +
                        "      </apipAccessibility>\n" +
                        "    </content>\n" +
                        "    <content language=\"ESN\" version=\"2.0\" approvedVersion=\"6\">\n" +
                        "      <concept>\n" +
                        "        <name>What Knowledge Do Students Need to Understand This Concept?</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </concept>\n" +
                        "      <es>\n" +
                        "        <name>Explanation of Correct Answer</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </es>\n" +
                        "      <himi>\n" +
                        "        <name>Explanation of Correct Answer</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </himi>\n" +
                        "      <rationaleoptlist>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option A</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option B</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option C</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option D</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "      </rationaleoptlist>\n" +
                        "      <stem><![CDATA[<p style=\"\">Selecciona el par ordenado que es una solución para la ecuación representada por la gráfica.</p><p class=\"languagedivider\">&#xA0;</p><p style=\"\"><span id=\"item_33727_TAG_6\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>Select<span class=\"its-tag\" data-tag-ref=\"item_33727_TAG_6\" data-tag-boundary=\"end\"></span> the ordered pair that is a solution to the equation represented by the graph.</p><p style=\"\"><br /><img id=\"item_33727_graphics1\" src=\"item_33727_v6_graphics1_png256.png\" width=\"289\" height=\"297\" style=\"vertical-align:baseline;\" /></p>]]></stem>\n" +
                        "      <optionlist>\n" +
                        "        <option>\n" +
                        "          <name>Option A</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><span id=\"item_33727_TAG_2_BEGIN\">(4, 0)</span></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option B</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><span id=\"item_33727_TAG_3_BEGIN\">(2, 3)</span></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option C</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><span id=\"item_33727_TAG_4_BEGIN\">(5, 0)</span></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option D</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><span id=\"item_33727_TAG_5_BEGIN\">(3, 2)</span></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "      </optionlist>\n" +
                        "      <attachmentlist />\n" +
                        "      <apipAccessibility>\n" +
                        "        <accessibilityInfo>\n" +
                        "          <accessElement identifier=\"ae2\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_33727_graphics1\" type=\"Graphic\" subtype=\"Generic\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioText>From left to right, The x axis has a range from negative 2 to 8, increasing in increments of 2. From bottom to top, The why axis has a range from negative 2 to 8, increasing in increments of 2;</audioText>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText />\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae3\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_33727_TAG_2_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>4 comma 0</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>(4, 0)</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae4\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_33727_TAG_3_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>2 comma 3</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>(2, 3)</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae5\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_33727_TAG_4_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>5 comma 0</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>(5, 0)</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae6\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_33727_TAG_5_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>3 comma 2</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>(3, 2)</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "        </accessibilityInfo>\n" +
                        "      </apipAccessibility>\n" +
                        "    </content>\n" +
                        "  </item>\n" +
                        "</itemrelease>\n"))
                .put("12327", new GitLabItemMetaData("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>\n" +
                        "<metadata>\n" +
                        "  <smarterAppMetadata xmlns=\"http://www.smarterapp.org/ns/1/assessment_item_metadata\">\n" +
                        "    <Identifier>12327</Identifier>\n" +
                        "    <ItemAuthorIdentifier>Sridhar_Ravva</ItemAuthorIdentifier>\n" +
                        "    <ItemSpecFormat>SmarterApp</ItemSpecFormat>\n" +
                        "    <LastModifiedBy>Sridhar_Ravva</LastModifiedBy>\n" +
                        "    <SecurityStatus>Secure</SecurityStatus>\n" +
                        "    <SmarterAppItemDescriptor>58282</SmarterAppItemDescriptor>\n" +
                        "    <Subject>MATH</Subject>\n" +
                        "    <Version>12</Version>\n" +
                        "    <StimulusFormat>Standard</StimulusFormat>\n" +
                        "    <IntendedGrade>11</IntendedGrade>\n" +
                        "    <MinimumGrade>9</MinimumGrade>\n" +
                        "    <MaximumGrade>11</MaximumGrade>\n" +
                        "    <MathematicalPractice>None</MathematicalPractice>\n" +
                        "    <DepthOfKnowledge>1</DepthOfKnowledge>\n" +
                        "    <AchievementQuintile>2</AchievementQuintile>\n" +
                        "    <AllowCalculator>Y</AllowCalculator>\n" +
                        "    <InteractionType>MC</InteractionType>\n" +
                        "    <MaximumNumberOfPoints>1</MaximumNumberOfPoints>\n" +
                        "    <ScorePoints>\"0, 1\"</ScorePoints>\n" +
                        "    <ScoringEngine>Automatic with Key</ScoringEngine>\n" +
                        "    <PresentationFormat>Text With Graphics</PresentationFormat>\n" +
                        "    <AdministrationDate>Field Test</AdministrationDate>\n" +
                        "    <ContentTaskModel>TM4c_Rpdv</ContentTaskModel>\n" +
                        "    <AlgebraFunctionDescriptor>Linear</AlgebraFunctionDescriptor>\n" +
                        "    <BrailleType>PRN_EBAE_UEB</BrailleType>\n" +
                        "    <EnemyItem>0</EnemyItem>\n" +
                        "    <CopyrightAndOtherRestrictions>Commissioned</CopyrightAndOtherRestrictions>\n" +
                        "    <StimulusScource></StimulusScource>\n" +
                        "    <Notes></Notes>\n" +
                        "    <PerformanceTaskComponentItem>N</PerformanceTaskComponentItem>\n" +
                        "    <PtClassroomActivity></PtClassroomActivity>\n" +
                        "    <PtEnemy>0</PtEnemy>\n" +
                        "    <AccessibilityTagsASLLanguage>Y</AccessibilityTagsASLLanguage>\n" +
                        "    <IrtDimension>\n" +
                        "      <IrtStatDomain>Online</IrtStatDomain>\n" +
                        "      <IrtModelType>IRT3PLN</IrtModelType>\n" +
                        "      <IrtDimensionPurpose></IrtDimensionPurpose>\n" +
                        "      <IrtScore>1</IrtScore>\n" +
                        "      <IrtWeight>1</IrtWeight>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>a</Name>\n" +
                        "        <Value>0.28119</Value>\n" +
                        "      </IrtParameter>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>b</Name>\n" +
                        "        <Value>1.20715</Value>\n" +
                        "      </IrtParameter>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>c</Name>\n" +
                        "        <Value>0</Value>\n" +
                        "      </IrtParameter>\n" +
                        "    </IrtDimension>\n" +
                        "    <Status>Operational</Status>\n" +
                        "    <StandardPublication>\n" +
                        "      <Publication>SBAC-MA-v6</Publication>\n" +
                        "      <PrimaryStandard>SBAC-MA-v6:1|P|TS04|J</PrimaryStandard>\n" +
                        "    </StandardPublication>\n" +
                        "    <StandardPublication>\n" +
                        "      <Publication>SBAC-MA-v4</Publication>\n" +
                        "      <PrimaryStandard>SBAC-MA-v4:1|A-REI|J|m|A-REI.12</PrimaryStandard>\n" +
                        "    </StandardPublication>\n" +
                        "    <AssociatedTutorial>67708</AssociatedTutorial>\n" +
                        "    <AssociatedWordlist>64633</AssociatedWordlist>\n" +
                        "    <Language>eng</Language>\n" +
                        "    <Language>spa</Language>\n" +
                        "  </smarterAppMetadata>\n" +
                        "</metadata>\n", "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<itemrelease version=\"2.0\">\n" +
                        "  <item format=\"mc\" id=\"12327\" version=\"12\" bankkey=\"200\">\n" +
                        "    <attriblist>\n" +
                        "      <attrib attid=\"itm_item_id\">\n" +
                        "        <name>Item: ITS ID</name>\n" +
                        "        <val>12327</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_item_subject\">\n" +
                        "        <name>Item: Subject</name>\n" +
                        "        <val>MATH</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_item_desc\">\n" +
                        "        <name>Item: Item Description</name>\n" +
                        "        <val>58282</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_FTUse\">\n" +
                        "        <name>Fieldtest Use</name>\n" +
                        "        <val>Platform::MG11::1.7A (723); Platform Math::March2014::GR11::ESN (39); SBAC-Int-PR1-FM1-Math-11 (4); SBAC-Int-PR1-FM1-Math-11-SPA (4);</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_OPUse\">\n" +
                        "        <name>Operational Use</name>\n" +
                        "        <val>CAT::MG8::UPCALC-S4-B::SP14 (15); CAT::MG11::ONCalc-S1-D::SP14 (509); CAT::MG11::ONONCalc-S1-A1::SP14 (90); FAKE MATH FORM (4083); CAT::MG11::ONCalc-S1-A2::SP14 (90); CAT::MG11::ONCalc-S1-A4::SP14 (90); CAT::MG10::ONCalc-S1-A4::SP14 (90); CAT::MG11::ONCalc-S1-A3::SP14 (90); CAT::MG11::ONCalc-S4-A3::SP14 (90); CAT::MG8::UPCALC-S1-B::SP14 (15); CAT::MG11::CA-ONCalc::SP14 (90); CAT::MG10::ONCalc-S1-A4::SP14-ESN (89); CAT::MG11::ONONCalc-S1-A1::SP14-ESN (89); CAT::MG11::ONCalc-S1-D::SP14-ESN (89); CAT::MG11::ONCalc-S4-A3::SP14-ESN (89); CAT::MG11::ONCalc-S1-A2::SP14-ESN (89); CAT::MG11::ONCalc-S1-A3::SP14-ESN (89); CAT::MG8::UPCALC-S1-B::SP14-ESN (89); CAT::MG8::UPCALC-S4-B::SP14-ESN (89); CAT::MG11::CA-ONCalc::SP14-ESN (89); CAT::MATH910::VL11NoCALC-S2-C::SP14 (15); CAT::MATH910::VL11NoCALC-S2-C::SP14-ESN (89); CAT::MATH910::VL11NoCALC-S3-C::SP14 (15); CAT::MATH910::VL11NoCALC-S3-C::SP14-ESN (89); CAT::MG11::CA-ONCalc::D::SP14 (509); CAT::MG11::CA-ONCalc::D::SP14-ESN (89); CAT::MG11::CA-ONCalc::D (509); IAB-G11M-AlgLin-Calc-2017 ENG (4); IAB-G11M-AlgLin-Calc-2017 BRL (4); IAB-G11M-AlgLin-Calc-2017 SPA (4); IAB-G11M-AlgLin-Calc-2017 ENG COMBINED (4); IAB-G11M-AlgLin-Calc-2017 BRL COMBINED (4); IAB-G11M-AlgLin-Calc-2017 SPA COMBINED (4); IAB-G11M-AlgLin-Calc-2018 ENG (4); IAB-G11M-AlgLin-Calc-2018 BRL (4); IAB-G11M-AlgLin-Calc-2018 SPA (4); IAB-G11M-AlgLin-Calc-2018 ENG COMBINED (4); IAB-G11M-AlgLin-Calc-2018 BRL COMBINED (4); IAB-G11M-AlgLin-Calc-2018 SPA COMBINED (4); IAB-G11M-AlgLin-Calc-2019 ENG (4); IAB-G11M-AlgLin-Calc-2019 BRL (4); IAB-G11M-AlgLin-Calc-2019 SPA (4);</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Answer Key\">\n" +
                        "        <name>Item: Answer Key</name>\n" +
                        "        <val>A</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Grade\">\n" +
                        "        <name>Item: Grade</name>\n" +
                        "        <val>11</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Item Format\">\n" +
                        "        <name>Item: Item Format</name>\n" +
                        "        <val>MC</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Page Layout\">\n" +
                        "        <name>Item: Page Layout</name>\n" +
                        "        <val>8</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Response Type\">\n" +
                        "        <name>Item: Response Type</name>\n" +
                        "        <val>Vertical</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Item Point\">\n" +
                        "        <name>Item: Item Point</name>\n" +
                        "        <val>1 pt.</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Answer Key (Part II)\">\n" +
                        "        <name>Item: Answer Key (Part II)</name>\n" +
                        "        <val>NA</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Max Choices\">\n" +
                        "        <name>Item:Max Choices</name>\n" +
                        "        <val>NA</val>\n" +
                        "        <desc>NA</desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Max Choices (Part II)\">\n" +
                        "        <name>Item:Max Choices (Part II)</name>\n" +
                        "        <val></val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "    </attriblist>\n" +
                        "    <tutorial id=\"67708\" bankkey=\"200\" />\n" +
                        "    <resourceslist>\n" +
                        "      <resource type=\"wordList\" id=\"64633\" index=\"1\" bankkey=\"200\" />\n" +
                        "    </resourceslist>\n" +
                        "    <statistic />\n" +
                        "    <content language=\"ENU\" version=\"2.0\" approvedVersion=\"12\">\n" +
                        "      <concept>\n" +
                        "        <name>What Knowledge Do Students Need to Understand This Concept?</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </concept>\n" +
                        "      <es>\n" +
                        "        <name>Explanation of Correct Answer</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </es>\n" +
                        "      <himi>\n" +
                        "        <name>Explanation of Correct Answer</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </himi>\n" +
                        "      <rationaleoptlist>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option A</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option B</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option C</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option D</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "      </rationaleoptlist>\n" +
                        "      <stem><![CDATA[<p style=\"\"><span id=\"item_12327_TAG_7\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>Select<span class=\"its-tag\" data-tag-ref=\"item_12327_TAG_7\" data-tag-boundary=\"end\"></span> the graph that shows the solution set of the system of linear inequalities.</p><p style=\"\"><br /><img id=\"CrossReference0\" src=\"item_12327_v12_item_12327_mml_svg_png__0.png\"/></p><p style=\"\"><br /><img id=\"CrossReference1\" src=\"item_12327_v12_item_12327_mml_svg_png__1.png\"/></p>]]></stem>\n" +
                        "      <optionlist>\n" +
                        "        <option>\n" +
                        "          <name>Option A</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"item_12327_graphics1\" src=\"item_12327_v12_graphics1_png256.png\" width=\"240\" height=\"207\" style=\"vertical-align:baseline;\" /></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">key</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option B</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"item_12327_graphics2\" src=\"item_12327_v12_graphics2_png256.png\" width=\"240\" height=\"207\" style=\"vertical-align:baseline;\" /></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">The student incorrectly determined inclusion/exclusion of boundaries.</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option C</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"item_12327_graphics3\" src=\"item_12327_v12_graphics3_png256.png\" width=\"240\" height=\"207\" style=\"vertical-align:baseline;\" /></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">The student incorrectly determined the inequality signs.</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option D</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"item_12327_graphics4\" src=\"item_12327_v12_graphics4_png256.png\" width=\"240\" height=\"207\" style=\"vertical-align:baseline;\" /></p><p style=\"\"> </p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">The student incorrectly determined the inequality signs and the inclusion of boundaries.</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "      </optionlist>\n" +
                        "      <attachmentlist>\n" +
                        "        <attachment id=\"braillefile2\" type=\"PRN\" subtype=\"TDS_BT_ECN\" file=\"item_12327_enu_prn_ebae_contracted_nemeth_ecn.prn\" />\n" +
                        "        <attachment id=\"braillefile21\" type=\"PRN\" subtype=\"TDS_BT_UCN\" file=\"item_12327_enu_prn_ueb_contracted_nemeth_ucn.prn\" />\n" +
                        "        <attachment id=\"braillefile32\" type=\"PRN\" subtype=\"TDS_BT_UCT\" file=\"item_12327_enu_prn_ueb_contracted_ueb_math_uct.prn\" />\n" +
                        "        <attachment id=\"braillefile4\" type=\"PRN\" subtype=\"TDS_BT_EXN\" file=\"item_12327_enu_prn_ebae_uncontracted_nemeth_exn.prn\" />\n" +
                        "        <attachment id=\"braillefile18\" type=\"PRN\" subtype=\"TDS_BT_UXN\" file=\"item_12327_enu_prn_ueb_uncontracted_nemeth_uxn.prn\" />\n" +
                        "        <attachment id=\"braillefile28\" type=\"PRN\" subtype=\"TDS_BT_UXT\" file=\"item_12327_enu_prn_ueb_uncontracted_ueb_math_uxt.prn\" />\n" +
                        "        <attachment id=\"aslfile1\" type=\"ASL\" subtype=\"STEM\" file=\"item_12327_ASL_STEM.mp4\">\n" +
                        "          <source src=\"item_12327_ASL_STEM.webm\" type=\"video/webm\" />\n" +
                        "          <source src=\"item_12327_ASL_STEM.mp4\" type=\"video/mp4\" />\n" +
                        "        </attachment>\n" +
                        "      </attachmentlist>\n" +
                        "      <apipAccessibility>\n" +
                        "        <accessibilityInfo>\n" +
                        "          <accessElement identifier=\"ae2\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference0\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>Why  is less than or equal to  3 plus   1 half  x,</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">y  k: 3+?1/2#x</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae3\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference1\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>y  is greater than  6 minus  2 thirds  x;</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">y .1 #6-?2/3#x</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae4\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_12327_graphics1\" type=\"Graphic\" subtype=\"Generic\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioText>The x axis has a range from 0 to 10, increasing in increments of     1;\n" +
                        "\n" +
                        "The why axis has a range from 0 to 8, increasing in increments of 1;</audioText>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText />\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae5\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_12327_graphics2\" type=\"Graphic\" subtype=\"Generic\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioText>The x axis has a range from 0 to 10, increasing in increments of     1;\n" +
                        "\n" +
                        "The why axis has a range from 0 to 8, increasing in increments of 1;</audioText>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText />\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae6\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_12327_graphics3\" type=\"Graphic\" subtype=\"Generic\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioText>The x axis has a range from 0 to 10, increasing in increments of     1;\n" +
                        "\n" +
                        "The why axis has a range from 0 to 8, increasing in increments of 1;</audioText>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText />\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae7\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_12327_graphics4\" type=\"Graphic\" subtype=\"Generic\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioText>The x axis has a range from 0 to 10, increasing in increments of     1;\n" +
                        "\n" +
                        "The why axis has a range from 0 to 8, increasing in increments of 1;</audioText>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText />\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "        </accessibilityInfo>\n" +
                        "      </apipAccessibility>\n" +
                        "    </content>\n" +
                        "    <content language=\"ESN\" version=\"2.0\" approvedVersion=\"12\">\n" +
                        "      <concept>\n" +
                        "        <name>What Knowledge Do Students Need to Understand This Concept?</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </concept>\n" +
                        "      <es>\n" +
                        "        <name>Explanation of Correct Answer</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </es>\n" +
                        "      <himi>\n" +
                        "        <name>Explanation of Correct Answer</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </himi>\n" +
                        "      <rationaleoptlist>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option A</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option B</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option C</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option D</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "      </rationaleoptlist>\n" +
                        "      <stem><![CDATA[<p style=\"\">Selecciona la gráfica que muestre el conjunto de soluciones del sistema de desigualdades lineales.</p><p style=\"\"><br /><img id=\"CrossReference2\" src=\"item_12327_v12_item_12327_mml_svg_png__0.png\"/></p><p style=\"\"><br /><img id=\"CrossReference3\" src=\"item_12327_v12_item_12327_mml_svg_png__1.png\"/></p><p class=\"languagedivider\">&#xA0;</p><p style=\"\"><span id=\"item_12327_TAG_7\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>Select<span class=\"its-tag\" data-tag-ref=\"item_12327_TAG_7\" data-tag-boundary=\"end\"></span> the graph that shows the solution set of the system of linear inequalities.</p><p style=\"\"><br /><img id=\"CrossReference0\" src=\"item_12327_v12_item_12327_mml_svg_png__0.png\"/></p><p style=\"\"><br /><img id=\"CrossReference1\" src=\"item_12327_v12_item_12327_mml_svg_png__1.png\"/></p>]]></stem>\n" +
                        "      <optionlist>\n" +
                        "        <option>\n" +
                        "          <name>Option A</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"item_12327_graphics1\" src=\"item_12327_v12_graphics1_png256.png\" width=\"240\" height=\"207\" style=\"vertical-align:baseline;\" /></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option B</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"item_12327_graphics2\" src=\"item_12327_v12_graphics2_png256.png\" width=\"240\" height=\"207\" style=\"vertical-align:baseline;\" /></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option C</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"item_12327_graphics3\" src=\"item_12327_v12_graphics3_png256.png\" width=\"240\" height=\"207\" style=\"vertical-align:baseline;\" /></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option D</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"item_12327_graphics4\" src=\"item_12327_v12_graphics4_png256.png\" width=\"240\" height=\"207\" style=\"vertical-align:baseline;\" /></p><p style=\"\"> </p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "      </optionlist>\n" +
                        "      <attachmentlist>\n" +
                        "        <attachment id=\"aslfile1\" type=\"ASL\" subtype=\"STEM\" file=\"item_12327_ASL_STEM.mp4\" />\n" +
                        "      </attachmentlist>\n" +
                        "      <apipAccessibility>\n" +
                        "        <accessibilityInfo>\n" +
                        "          <accessElement identifier=\"ae2\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference0\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>Why  is less than or equal to  3 plus   1 half  x,</audioShortDesc>\n" +
                        "                <audioLongDesc />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">y  k: 3+?1/2#x</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae3\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference1\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>y  is greater than  6 minus  2 thirds  x;</audioShortDesc>\n" +
                        "                <audioLongDesc />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">y .1 #6-?2/3#x</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae4\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_12327_graphics1\" type=\"Graphic\" subtype=\"Generic\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioText>The x axis has a range from 0 to 10, increasing in increments of     1;\n" +
                        "\n" +
                        "The why axis has a range from 0 to 8, increasing in increments of 1;</audioText>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText />\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae5\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_12327_graphics2\" type=\"Graphic\" subtype=\"Generic\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioText>The x axis has a range from 0 to 10, increasing in increments of     1;\n" +
                        "\n" +
                        "The why axis has a range from 0 to 8, increasing in increments of 1;</audioText>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText />\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae6\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_12327_graphics3\" type=\"Graphic\" subtype=\"Generic\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioText>The x axis has a range from 0 to 10, increasing in increments of     1;\n" +
                        "\n" +
                        "The why axis has a range from 0 to 8, increasing in increments of 1;</audioText>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText />\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae7\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_12327_graphics4\" type=\"Graphic\" subtype=\"Generic\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioText>The x axis has a range from 0 to 10, increasing in increments of     1;\n" +
                        "\n" +
                        "The why axis has a range from 0 to 8, increasing in increments of 1;</audioText>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText />\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae8\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference2\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>y  is less than or equal to  3 plus  the fraction 1 over 2,  x</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>y  is less than or equal to  3 plus  the fraction 1 over 2,  x</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">y\t k:\t3+?1/2#x\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae9\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference3\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>y  is greater than  6 minus  the fraction 2 over 3,  x</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>y  is greater than  6 minus  the fraction 2 over 3,  x</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">y .1 #6-?2/3#x\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "        </accessibilityInfo>\n" +
                        "      </apipAccessibility>\n" +
                        "    </content>\n" +
                        "  </item>\n" +
                        "</itemrelease>\n"))
                .put("19513", new GitLabItemMetaData("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>\n" +
                        "<metadata>\n" +
                        "  <smarterAppMetadata xmlns=\"http://www.smarterapp.org/ns/1/assessment_item_metadata\">\n" +
                        "    <Identifier>19513</Identifier>\n" +
                        "    <StimulusFormat>Standard</StimulusFormat>\n" +
                        "    <Subject>MATH</Subject>\n" +
                        "    <Version>21</Version>\n" +
                        "    <SecurityStatus>Secure</SecurityStatus>\n" +
                        "    <SmarterAppItemDescriptor>66268</SmarterAppItemDescriptor>\n" +
                        "    <ItemAuthorIdentifier>Sridhar_Ravva</ItemAuthorIdentifier>\n" +
                        "    <ItemSpecFormat>SmarterApp</ItemSpecFormat>\n" +
                        "    <LastModifiedBy>Sridhar_Ravva</LastModifiedBy>\n" +
                        "    <IntendedGrade>11</IntendedGrade>\n" +
                        "    <MinimumGrade>9</MinimumGrade>\n" +
                        "    <MaximumGrade>11</MaximumGrade>\n" +
                        "    <DepthOfKnowledge>1</DepthOfKnowledge>\n" +
                        "    <AchievementQuintile>1</AchievementQuintile>\n" +
                        "    <AllowCalculator>Y</AllowCalculator>\n" +
                        "    <InteractionType>MI</InteractionType>\n" +
                        "    <MaximumNumberOfPoints>1</MaximumNumberOfPoints>\n" +
                        "    <ScorePoints>\"0, 1\"</ScorePoints>\n" +
                        "    <ScoringEngine>Automatic with Machine Rubric</ScoringEngine>\n" +
                        "    <PresentationFormat>Text With Graphics</PresentationFormat>\n" +
                        "    <AdministrationDate>Field Test</AdministrationDate>\n" +
                        "    <ContentTaskModel>TM1a_Det</ContentTaskModel>\n" +
                        "    <AlgebraFunctionDescriptor>Linear</AlgebraFunctionDescriptor>\n" +
                        "    <BrailleType>PRN_EBAE_UEB</BrailleType>\n" +
                        "    <EnemyItem>0</EnemyItem>\n" +
                        "    <CopyrightAndOtherRestrictions>Commissioned</CopyrightAndOtherRestrictions>\n" +
                        "    <PerformanceTaskComponentItem>N</PerformanceTaskComponentItem>\n" +
                        "    <PtEnemy>0</PtEnemy>\n" +
                        "    <AccessibilityTagsASLLanguage>Y</AccessibilityTagsASLLanguage>\n" +
                        "    <IrtDimension>\n" +
                        "      <IrtStatDomain>Online</IrtStatDomain>\n" +
                        "      <IrtModelType>IRT3PLN</IrtModelType>\n" +
                        "      <IrtDimensionPurpose></IrtDimensionPurpose>\n" +
                        "      <IrtScore>1</IrtScore>\n" +
                        "      <IrtWeight>1</IrtWeight>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>a</Name>\n" +
                        "        <Value>0.58904</Value>\n" +
                        "      </IrtParameter>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>b</Name>\n" +
                        "        <Value>0.99459</Value>\n" +
                        "      </IrtParameter>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>c</Name>\n" +
                        "        <Value>0</Value>\n" +
                        "      </IrtParameter>\n" +
                        "    </IrtDimension>\n" +
                        "    <Status>Operational</Status>\n" +
                        "    <StandardPublication>\n" +
                        "      <Publication>SBAC-MA-v4</Publication>\n" +
                        "      <PrimaryStandard>SBAC-MA-v4:1|F-IF|L|m|F-IF.4</PrimaryStandard>\n" +
                        "    </StandardPublication>\n" +
                        "    <StandardPublication>\n" +
                        "      <Publication>SBAC-MA-v6</Publication>\n" +
                        "      <PrimaryStandard>SBAC-MA-v6:1|P|TS06|L</PrimaryStandard>\n" +
                        "    </StandardPublication>\n" +
                        "    <AssociatedTutorial>67859</AssociatedTutorial>\n" +
                        "    <AssociatedWordlist>62823</AssociatedWordlist>\n" +
                        "    <Language>eng</Language>\n" +
                        "    <Language>spa</Language>\n" +
                        "  </smarterAppMetadata>\n" +
                        "</metadata>\n", "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<itemrelease version=\"2.0\">\n" +
                        "  <item format=\"mi\" id=\"19513\" version=\"21\" bankkey=\"200\">\n" +
                        "    <attriblist>\n" +
                        "      <attrib attid=\"itm_item_id\">\n" +
                        "        <name>Item: ITS ID</name>\n" +
                        "        <val>19513</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_item_subject\">\n" +
                        "        <name>Item: Subject</name>\n" +
                        "        <val>MATH</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_item_desc\">\n" +
                        "        <name>Item: Item Description</name>\n" +
                        "        <val>66268</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_FTUse\">\n" +
                        "        <name>Fieldtest Use</name>\n" +
                        "        <val>Platform::MG11::1.7B (261); Platform Math::March2014::GR11::ESN (63); SBAC-Int-PR1-FM1-Math-11 (5); SBAC-Int-PR1-FM1-Math-11-SPA (5);</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_OPUse\">\n" +
                        "        <name>Operational Use</name>\n" +
                        "        <val>CAT::MG8::UPCALC-S4-B::SP14 (33); CAT::MG11::ONCalc-S1-D::SP14 (947); CAT::MG11::ONONCalc-S1-A1::SP14 (195); FAKE MATH FORM (5677); CAT::MG11::ONCalc-S1-A2::SP14 (195); CAT::MG11::ONCalc-S1-A4::SP14 (195); CAT::MG10::ONCalc-S1-A4::SP14 (195); CAT::MG11::ONCalc-S1-A3::SP14 (195); CAT::MG11::ONCalc-S4-A3::SP14 (195); CAT::MG8::UPCALC-S1-B::SP14 (33); CAT::MG11::CA-ONCalc::SP14 (195); CAT::MG10::ONCalc-S1-A4::SP14-ESN (192); CAT::MG11::ONONCalc-S1-A1::SP14-ESN (192); CAT::MG11::ONCalc-S1-D::SP14-ESN (192); CAT::MG11::ONCalc-S4-A3::SP14-ESN (192); CAT::MG11::ONCalc-S1-A2::SP14-ESN (192); CAT::MG11::ONCalc-S1-A3::SP14-ESN (192); CAT::MG8::UPCALC-S1-B::SP14-ESN (192); CAT::MG8::UPCALC-S4-B::SP14-ESN (192); CAT::MG11::CA-ONCalc::SP14-ESN (192); CAT::MATH910::VL11NoCALC-S2-C::SP14 (33); CAT::MATH910::VL11NoCALC-S2-C::SP14-ESN (192); CAT::MATH910::VL11NoCALC-S3-C::SP14 (33); CAT::MATH910::VL11NoCALC-S3-C::SP14-ESN (192); CAT::MG11::CA-ONCalc::D::SP14 (947); CAT::MG11::CA-ONCalc::D::SP14-ESN (192); CAT::MG11::CA-ONCalc::D (947); Math ICA G11 Calc 2015 ENG (15); Math ICA G11 Calc 2015 BRL (15); Math ICA G11 Calc 2015 SPA (15); Math ICA G11 Calc COMBINED 2015 ENG (15); Math ICA G11 Calc COMBINED 2015 BRL (15); Math ICA G11 Calc COMBINED 2015 SPA (15); IAB-G11M-AlgLinearFun-Calc-2015 ENG (13); IAB-G11M-AlgLinearFun-Calc-2015 BRL (13); IAB-G11M-AlgLinearFun-Calc-2015 SPA (13); IAB-G11M-AlgLinearFun-Calc-2015 ENG-COMBINED (13); IAB-G11M-AlgLinearFun-Calc-2015 BRL-COMBINED (13); IAB-G11M-AlgLinearFun-Calc-2015 SPA-COMBINED (13); Math ICA G11 Calc 2017 ENG (15); Math ICA G11 Calc 2017 BRL (15); Math ICA G11 Calc 2017 SPA (15); IAB-G11M-AlgLin-Calc-2017 ENG (5); IAB-G11M-AlgLin-Calc-2017 BRL (5); IAB-G11M-AlgLin-Calc-2017 SPA (5); Math ICA G11 Calc 2017 ENG COMBINED (15); Math ICA G11 Calc 2017 BRL COMBINED (15); Math ICA G11 Calc 2017 SPA COMBINED (15); IAB-G11M-AlgLin-Calc-2017 ENG COMBINED (5); IAB-G11M-AlgLin-Calc-2017 BRL COMBINED (5); IAB-G11M-AlgLin-Calc-2017 SPA COMBINED (5); Math ICA G11 Calc 2018 ENG (15); Math ICA G11 Calc 2018 BRL (15); Math ICA G11 Calc 2018 SPA (15); IAB-G11M-AlgLin-Calc-2018 ENG (5); IAB-G11M-AlgLin-Calc-2018 BRL (5); IAB-G11M-AlgLin-Calc-2018 SPA (5); Math ICA G11 Calc 2018 ENG COMBINED (15); Math ICA G11 Calc 2018 BRL COMBINED (15); Math ICA G11 Calc 2018 SPA COMBINED (15); IAB-G11M-AlgLin-Calc-2018 ENG COMBINED (5); IAB-G11M-AlgLin-Calc-2018 BRL COMBINED (5); IAB-G11M-AlgLin-Calc-2018 SPA COMBINED (5); HI Math ICA G11 Calc 2018 ENG (15); HI Math ICA G11 Calc 2018 BRL (15); HI Math ICA G11 Calc 2018 SPA (15); IAB-G11M-AlgLin-Calc-2019 ENG (5); IAB-G11M-AlgLin-Calc-2019 BRL (5); IAB-G11M-AlgLin-Calc-2019 SPA (5); Math ICA G11 Calc 2018 ENG_copy1 (15); Math ICA G11 Calc 2018 BRL_copy1 (15); Math ICA G11 Calc 2018 SPA_copy1 (15);</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Answer Key\">\n" +
                        "        <name>Item: Answer Key</name>\n" +
                        "        <val>MI</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Grade\">\n" +
                        "        <name>Item: Grade</name>\n" +
                        "        <val>11</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Item Format\">\n" +
                        "        <name>Item: Item Format</name>\n" +
                        "        <val>MI</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Page Layout\">\n" +
                        "        <name>Item: Page Layout</name>\n" +
                        "        <val>8</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Response Type\">\n" +
                        "        <name>Item: Response Type</name>\n" +
                        "        <val>TableMatch</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Item Point\">\n" +
                        "        <name>Item: Item Point</name>\n" +
                        "        <val>1 pt.</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Answer Key (Part II)\">\n" +
                        "        <name>Item: Answer Key (Part II)</name>\n" +
                        "        <val></val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Max Choices\">\n" +
                        "        <name>Item:Max Choices</name>\n" +
                        "        <val></val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Max Choices (Part II)\">\n" +
                        "        <name>Item:Max Choices (Part II)</name>\n" +
                        "        <val></val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "    </attriblist>\n" +
                        "    <tutorial id=\"67859\" bankkey=\"200\" />\n" +
                        "    <resourceslist>\n" +
                        "      <resource type=\"wordList\" id=\"62823\" index=\"1\" bankkey=\"200\" />\n" +
                        "    </resourceslist>\n" +
                        "    <statistic />\n" +
                        "    <MachineRubric filename=\"Item_19513_v21.qrx\" xmlns:its-scripts=\"urn:its-scripts\" />\n" +
                        "    <content language=\"ENU\" version=\"2.0\" xmlns:its-scripts=\"urn:its-scripts\" approvedVersion=\"21\">\n" +
                        "      <qti spec=\"itemBody\"><![CDATA[<matchInteraction responseIdentifier=\"RESPONSE\" minAssociations=\"1\" maxAssociations=\"\"><prompt /><simpleMatchSet><simpleAssociableChoice identifier=\"1\"><p style=\"\">The maximum amount of <span id=\"item_19513_TAG_12\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>gas<span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_12\" data-tag-boundary=\"end\"></span> in the <span id=\"item_19513_TAG_16\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>gas <span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_16\" data-tag-boundary=\"end\"></span><span id=\"item_19513_TAG_18\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"3\"></span>tank<span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_18\" data-tag-boundary=\"end\"></span> was 60 ounces.</p></simpleAssociableChoice><simpleAssociableChoice identifier=\"2\"><p style=\"\">The amount of <span id=\"item_19513_TAG_13\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>gas<span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_13\" data-tag-boundary=\"end\"></span> in the <span id=\"item_19513_TAG_17\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>gas <span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_17\" data-tag-boundary=\"end\"></span><span id=\"item_19513_TAG_19\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"3\"></span>tank<span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_19\" data-tag-boundary=\"end\"></span> is at a maximum at 0 minutes.</p></simpleAssociableChoice><simpleAssociableChoice identifier=\"3\"><p style=\"\">The <span id=\"item_19513_TAG_14\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>gas <span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_14\" data-tag-boundary=\"end\"></span><span id=\"item_19513_TAG_15\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"3\"></span>tank<span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_15\" data-tag-boundary=\"end\"></span> will be empty after 60 minutes.</p></simpleAssociableChoice></simpleMatchSet><simpleMatchSet><simpleAssociableChoice identifier=\"a\"><p style=\"\"><span id=\"item_19513_TAG_20\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"7\"></span>True<span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_20\" data-tag-boundary=\"end\"></span></p></simpleAssociableChoice><simpleAssociableChoice identifier=\"b\"><p style=\"\"><span id=\"item_19513_TAG_21\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"8\"></span>False<span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_21\" data-tag-boundary=\"end\"></span></p></simpleAssociableChoice></simpleMatchSet></matchInteraction>]]></qti>\n" +
                        "      <stem><![CDATA[<p style=\"\">This graph shows the amount of gas, in ounces, in a <span id=\"item_19513_TAG_22\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>lawn mower<span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_22\" data-tag-boundary=\"end\"></span> <span id=\"item_19513_TAG_4\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>gas<span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_4\" data-tag-boundary=\"end\"></span> <span id=\"item_19513_TAG_23\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"3\"></span>tank<span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_23\" data-tag-boundary=\"end\"></span>, modeled as a function of time. </p><p style=\"\"><br /><img id=\"item_19513_graphics1\" src=\"item_19513_v21_graphics1_png256.png\" width=\"228\" height=\"249\" style=\"vertical-align:baseline;\" /></p><p style=\"\"><br />Determine <span id=\"item_19513_TAG_6\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"4\"></span>whether<span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_6\" data-tag-boundary=\"end\"></span> each <span id=\"item_19513_TAG_7\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"5\"></span>statement<span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_7\" data-tag-boundary=\"end\"></span> is true according to the graph. <span id=\"item_19513_TAG_8\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"6\"></span>Select<span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_8\" data-tag-boundary=\"end\"></span> <span id=\"item_19513_TAG_9\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"7\"></span>True<span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_9\" data-tag-boundary=\"end\"></span> or <span id=\"item_19513_TAG_10\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"8\"></span>False<span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_10\" data-tag-boundary=\"end\"></span> for each <span id=\"item_19513_TAG_11\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"5\"></span><span id=\"item_19513_TAG_2_BEGIN\">statement.</span><span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_11\" data-tag-boundary=\"end\"></span></p>]]></stem>\n" +
                        "      <rubriclist>\n" +
                        "        <rubric scorepoint=\"\">\n" +
                        "          <name>\n" +
                        "        Rubric </name>\n" +
                        "          <val><![CDATA[<p style=\"\">The student receives full credit by selecting:</p><p style=\"\">&#xA0;</p><ul style=\"padding-left:1.5000em; \"><li><p style=\"\">The maximum amount of gas in the gas tank was 60 ounces.: False</p><p style=\"\">AND</p></li><li><p style=\"\">The amount of gas in the gas tank is at a maximum at 0 minutes.: True</p><p style=\"\">AND</p></li><li><p style=\"\">The gas tank will be empty after 60 minutes.: True</p></li></ul>]]></val>\n" +
                        "        </rubric>\n" +
                        "        <samplelist maxval=\"\" minval=\"\" />\n" +
                        "      </rubriclist>\n" +
                        "      <attachmentlist>\n" +
                        "        <attachment id=\"braillefile2\" type=\"PRN\" subtype=\"TDS_BT_ECN\" file=\"item_19513_enu_prn_ebae_contracted_nemeth_ecn.prn\" />\n" +
                        "        <attachment id=\"braillefile21\" type=\"PRN\" subtype=\"TDS_BT_UCN\" file=\"item_19513_enu_prn_ueb_contracted_nemeth_ucn.prn\" />\n" +
                        "        <attachment id=\"braillefile32\" type=\"PRN\" subtype=\"TDS_BT_UCT\" file=\"item_19513_enu_prn_ueb_contracted_ueb_math_uct.prn\" />\n" +
                        "        <attachment id=\"braillefile4\" type=\"PRN\" subtype=\"TDS_BT_EXN\" file=\"item_19513_enu_prn_ebae_uncontracted_nemeth_exn.prn\" />\n" +
                        "        <attachment id=\"braillefile18\" type=\"PRN\" subtype=\"TDS_BT_UXN\" file=\"item_19513_enu_prn_ueb_uncontracted_nemeth_uxn.prn\" />\n" +
                        "        <attachment id=\"braillefile28\" type=\"PRN\" subtype=\"TDS_BT_UXT\" file=\"item_19513_enu_prn_ueb_uncontracted_ueb_math_uxt.prn\" />\n" +
                        "        <attachment id=\"aslfile1\" type=\"ASL\" subtype=\"STEM\" file=\"item_19513_ASL_STEM.mp4\">\n" +
                        "          <source src=\"item_19513_ASL_STEM.webm\" type=\"video/webm\" />\n" +
                        "          <source src=\"item_19513_ASL_STEM.mp4\" type=\"video/mp4\" />\n" +
                        "        </attachment>\n" +
                        "      </attachmentlist>\n" +
                        "      <apipAccessibility>\n" +
                        "        <accessibilityInfo>\n" +
                        "          <accessElement identifier=\"ae4\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_19513_graphics1\" type=\"Graphic\" subtype=\"Generic\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioText>The title of the graph is, Lawn Mower Gas Tank.  The x-axis is titled, Time, minutes. The axis has a range from 10 to 60, increasing in increments of ten.  The why-axis is titled, Amount of gas, ounces. The axis has a range from 10 to 60, increasing in increments of 10.</audioText>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>The title of the graph is, Lawn Mower Gas Tank.  The x-axis is titled, Time, minutes. The axis has a range from 10 to 60, increasing in increments of ten.  The why-axis is titled, Amount of gas, ounces. The axis has a range from 10 to 60, increasing in increments of 10. A line segment is graphed on the grid, with end points at zero comma thirty, and sixty comma zero.</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae11\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_19513_TAG_2_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>statement.  The table has 2 columns and 3 rows.  From left to right, the column headings reed, true, false.  From top to bottom, the row headings reed, the maximum amount of gas in the gas tank was 60 ounces; the amount of gas in the gas tank is at a maximum at 0 minutes.  The gas tank will be empty after 60 minutes.</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>statement.</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "        </accessibilityInfo>\n" +
                        "      </apipAccessibility>\n" +
                        "    </content>\n" +
                        "    <content language=\"ESN\" version=\"2.0\" xmlns:its-scripts=\"urn:its-scripts\" approvedVersion=\"15\">\n" +
                        "      <qti spec=\"itemBody\"><![CDATA[<matchInteraction responseIdentifier=\"RESPONSE\" minAssociations=\"1\" maxAssociations=\"0\"><prompt /><simpleMatchSet><simpleAssociableChoice identifier=\"1\"><p style=\"\">La cantidad máxima de gasolina en el tanque de gasolina fue de 60 onzas.</p><p class=\"languagedivider\"> </p><p style=\"\">The maximum amount of <span id=\"item_19513_TAG_12\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>gas<span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_12\" data-tag-boundary=\"end\"></span> in the <span id=\"item_19513_TAG_16\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>gas <span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_16\" data-tag-boundary=\"end\"></span><span id=\"item_19513_TAG_18\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"3\"></span>tank<span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_18\" data-tag-boundary=\"end\"></span> was 60 ounces.</p></simpleAssociableChoice><simpleAssociableChoice identifier=\"2\"><p style=\"\">La cantidad de gasolina en el tanque de gasolina está en su máximo a los 0 minutos.</p><p class=\"languagedivider\"> </p><p style=\"\">The amount of <span id=\"item_19513_TAG_13\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>gas<span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_13\" data-tag-boundary=\"end\"></span> in the <span id=\"item_19513_TAG_17\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>gas <span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_17\" data-tag-boundary=\"end\"></span><span id=\"item_19513_TAG_19\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"3\"></span>tank<span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_19\" data-tag-boundary=\"end\"></span> is at a maximum at 0 minutes.</p></simpleAssociableChoice><simpleAssociableChoice identifier=\"3\"><p style=\"\">El tanque de gasolina estará vacío después de 60 minutos.</p><p class=\"languagedivider\"> </p><p style=\"\">The <span id=\"item_19513_TAG_14\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>gas <span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_14\" data-tag-boundary=\"end\"></span><span id=\"item_19513_TAG_15\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"3\"></span>tank<span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_15\" data-tag-boundary=\"end\"></span> will be empty after 60 minutes.</p></simpleAssociableChoice></simpleMatchSet><simpleMatchSet><simpleAssociableChoice identifier=\"a\"><p style=\"\">Verdadera</p><p class=\"languagedivider\"> </p><p style=\"\"><span id=\"item_19513_TAG_20\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"7\"></span>True<span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_20\" data-tag-boundary=\"end\"></span></p></simpleAssociableChoice><simpleAssociableChoice identifier=\"b\"><p style=\"\">Falsa</p><p class=\"languagedivider\"> </p><p style=\"\"><span id=\"item_19513_TAG_21\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"8\"></span>False<span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_21\" data-tag-boundary=\"end\"></span></p></simpleAssociableChoice></simpleMatchSet></matchInteraction>]]></qti>\n" +
                        "      <stem><![CDATA[<p style=\"\">Esta gráfica muestra la cantidad de gasolina, en onzas, en el tanque de gasolina de una podadora, representada en función del tiempo.</p><p style=\"\"><br /></p><p style=\"\"><img id=\"item_19513_graphics2\" src=\"item_19513_v15_graphics2_png256.png\" width=\"420\" height=\"332\" style=\"vertical-align:baseline;\" /></p><p style=\"\"><br />Determina si cada afirmación es verdadera de acuerdo a la gráfica. Selecciona verdadera o falsa para cada afirmación.</p><p class=\"languagedivider\">&#xA0;</p><p style=\"\">This graph shows the amount of gas, in ounces, in a <span id=\"item_19513_TAG_22\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>lawn mower<span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_22\" data-tag-boundary=\"end\"></span> <span id=\"item_19513_TAG_4\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>gas<span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_4\" data-tag-boundary=\"end\"></span> <span id=\"item_19513_TAG_23\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"3\"></span>tank<span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_23\" data-tag-boundary=\"end\"></span>, modeled as a function of time. </p><p style=\"\"><br /><img id=\"item_19513_graphics1\" src=\"item_19513_v15_graphics1_png256.png\" width=\"228\" height=\"249\" style=\"vertical-align:baseline;\" /></p><p style=\"\"><br />Determine <span id=\"item_19513_TAG_6\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"4\"></span>whether<span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_6\" data-tag-boundary=\"end\"></span> each <span id=\"item_19513_TAG_7\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"5\"></span>statement<span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_7\" data-tag-boundary=\"end\"></span> is true according to the graph. <span id=\"item_19513_TAG_8\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"6\"></span>Select<span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_8\" data-tag-boundary=\"end\"></span> <span id=\"item_19513_TAG_9\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"7\"></span>True<span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_9\" data-tag-boundary=\"end\"></span> or <span id=\"item_19513_TAG_10\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"8\"></span>False<span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_10\" data-tag-boundary=\"end\"></span> for each <span id=\"item_19513_TAG_11\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"5\"></span><span id=\"item_19513_TAG_2_BEGIN\">statement.</span><span class=\"its-tag\" data-tag-ref=\"item_19513_TAG_11\" data-tag-boundary=\"end\"></span></p>]]></stem>\n" +
                        "      <attachmentlist />\n" +
                        "      <apipAccessibility>\n" +
                        "        <accessibilityInfo>\n" +
                        "          <accessElement identifier=\"ae4\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_19513_graphics1\" type=\"Graphic\" subtype=\"Generic\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioText>The title of the graph is Lawn Mower Gas Tank.  The x axis is titled, Time, minutes.  From left to right, the axis has a range from 0 to 60, increasing in increments of ten.  The y axis is titled, Amoung of gas, ounces.  From bottom to top, the axis has a range from 0 to 60, increasing in increments of 10.</audioText>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText />\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae11\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_19513_TAG_2_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>statement.  The table has 2 columns and 3 rows.  From left to right, the column headings reed, true, false.  From top to bottom, the row headings reed, the maximum amount of gas in the gas tank was 60 ounces; the amount of gas in the gas tank is at a maximum at 0 minutes.  The gas tank will be empty after 60 minutes.</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>statement.</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "        </accessibilityInfo>\n" +
                        "      </apipAccessibility>\n" +
                        "    </content>\n" +
                        "  </item>\n" +
                        "</itemrelease>\n"))
                .put("20702", new GitLabItemMetaData("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>\n" +
                        "<metadata>\n" +
                        "  <smarterAppMetadata xmlns=\"http://www.smarterapp.org/ns/1/assessment_item_metadata\">\n" +
                        "    <Identifier>20702</Identifier>\n" +
                        "    <ItemAuthorIdentifier>Sridhar_Ravva</ItemAuthorIdentifier>\n" +
                        "    <ItemSpecFormat>SmarterApp</ItemSpecFormat>\n" +
                        "    <LastModifiedBy>Sridhar_Ravva</LastModifiedBy>\n" +
                        "    <SecurityStatus>Secure</SecurityStatus>\n" +
                        "    <SmarterAppItemDescriptor>MATH.11.1.A-CED.1G</SmarterAppItemDescriptor>\n" +
                        "    <StimulusFormat>Standard</StimulusFormat>\n" +
                        "    <Subject>MATH</Subject>\n" +
                        "    <Version>6</Version>\n" +
                        "    <IntendedGrade>11</IntendedGrade>\n" +
                        "    <MinimumGrade>9</MinimumGrade>\n" +
                        "    <MaximumGrade>11</MaximumGrade>\n" +
                        "    <MathematicalPractice>1</MathematicalPractice>\n" +
                        "    <DepthOfKnowledge>2</DepthOfKnowledge>\n" +
                        "    <AchievementQuintile>2</AchievementQuintile>\n" +
                        "    <AllowCalculator>Y</AllowCalculator>\n" +
                        "    <InteractionType>EQ</InteractionType>\n" +
                        "    <MaximumNumberOfPoints>2</MaximumNumberOfPoints>\n" +
                        "    <ScorePoints>\"0, 1, 2\"</ScorePoints>\n" +
                        "    <ScoringEngine>Automatic with Machine Rubric</ScoringEngine>\n" +
                        "    <PresentationFormat>Text</PresentationFormat>\n" +
                        "    <AdministrationDate>Field Test</AdministrationDate>\n" +
                        "    <ContentTaskModel>TM1c_Det</ContentTaskModel>\n" +
                        "    <AlgebraFunctionDescriptor>Linear</AlgebraFunctionDescriptor>\n" +
                        "    <BrailleType>BRF_EBAE_UEB</BrailleType>\n" +
                        "    <EnemyItem></EnemyItem>\n" +
                        "    <CopyrightAndOtherRestrictions></CopyrightAndOtherRestrictions>\n" +
                        "    <StimulusScource></StimulusScource>\n" +
                        "    <Notes></Notes>\n" +
                        "    <PtClassroomActivity></PtClassroomActivity>\n" +
                        "    <PtEnemy></PtEnemy>\n" +
                        "    <AccessibilityTagsASLLanguage>Y</AccessibilityTagsASLLanguage>\n" +
                        "    <IrtDimension>\n" +
                        "      <IrtStatDomain>Online</IrtStatDomain>\n" +
                        "      <IrtModelType>IRTGPC</IrtModelType>\n" +
                        "      <IrtDimensionPurpose></IrtDimensionPurpose>\n" +
                        "      <IrtScore>2</IrtScore>\n" +
                        "      <IrtWeight>1</IrtWeight>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>a</Name>\n" +
                        "        <Value>0.46796</Value>\n" +
                        "      </IrtParameter>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>b0</Name>\n" +
                        "        <Value>2.65325</Value>\n" +
                        "      </IrtParameter>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>b1</Name>\n" +
                        "        <Value>1.83613</Value>\n" +
                        "      </IrtParameter>\n" +
                        "    </IrtDimension>\n" +
                        "    <Status>Operational</Status>\n" +
                        "    <StandardPublication>\n" +
                        "      <Publication>SBAC-MA-v4</Publication>\n" +
                        "      <PrimaryStandard>SBAC-MA-v4:2|A-CED|A|NA|NA</PrimaryStandard>\n" +
                        "      <SecondaryStandard>SBAC-MA-v5:1|A-CED|G|a/s|A-CED.1</SecondaryStandard>\n" +
                        "    </StandardPublication>\n" +
                        "    <StandardPublication>\n" +
                        "      <Publication>SBAC-MA-v6</Publication>\n" +
                        "      <PrimaryStandard>SBAC-MA-v6:2|A|NA|A</PrimaryStandard>\n" +
                        "    </StandardPublication>\n" +
                        "    <AssociatedTutorial>67863</AssociatedTutorial>\n" +
                        "    <AssociatedWordlist>116440</AssociatedWordlist>\n" +
                        "    <Language>eng</Language>\n" +
                        "    <Language>spa</Language>\n" +
                        "  </smarterAppMetadata>\n" +
                        "</metadata>\n", "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<itemrelease version=\"2.0\">\n" +
                        "  <item format=\"eq\" id=\"20702\" version=\"6\" bankkey=\"200\">\n" +
                        "    <attriblist>\n" +
                        "      <attrib attid=\"itm_item_id\">\n" +
                        "        <name>Item: ITS ID</name>\n" +
                        "        <val>20702</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_item_subject\">\n" +
                        "        <name>Item: Subject</name>\n" +
                        "        <val>MATH</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_item_desc\">\n" +
                        "        <name>Item: Item Description</name>\n" +
                        "        <val>MATH.11.1.A-CED.1G</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_FTUse\">\n" +
                        "        <name>Fieldtest Use</name>\n" +
                        "        <val>Platform::MG11::1.7B (345); SBAC-Int-PR1-FM1-Math-11 (6); SBAC-Int-PR1-FM1-Math-11-SPA (6);</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_OPUse\">\n" +
                        "        <name>Operational Use</name>\n" +
                        "        <val>CAT::MG11::ONCalc-S1-D::SP14 (1018); FAKE MATH FORM (5913); CAT::MG11::CA-ONCalc::D::SP14 (1018); CAT::MG11::CA-ONCalc::D (1018); IAB-G11M-AlgLinearFun-Calc-2015 ENG (14); IAB-G11M-AlgLinearFun-Calc-2015 BRL (14); IAB-G11M-AlgLinearFun-Calc-2015 SPA (14); IAB-G11M-AlgLinearFun-Calc-2015 ENG-COMBINED (14); IAB-G11M-AlgLinearFun-Calc-2015 BRL-COMBINED (14); IAB-G11M-AlgLinearFun-Calc-2015 SPA-COMBINED (14); IAB-G11M-AlgLin-Calc-2017 ENG (6); IAB-G11M-AlgLin-Calc-2017 BRL (6); IAB-G11M-AlgLin-Calc-2017 SPA (6); IAB-G11M-AlgLin-Calc-2017 ENG COMBINED (6); IAB-G11M-AlgLin-Calc-2017 BRL COMBINED (6); IAB-G11M-AlgLin-Calc-2017 SPA COMBINED (6); IAB-G11M-AlgLin-Calc-2018 ENG (6); IAB-G11M-AlgLin-Calc-2018 BRL (6); IAB-G11M-AlgLin-Calc-2018 SPA (6); IAB-G11M-AlgLin-Calc-2018 ENG COMBINED (6); IAB-G11M-AlgLin-Calc-2018 BRL COMBINED (6); IAB-G11M-AlgLin-Calc-2018 SPA COMBINED (6); IAB-G11M-AlgLin-Calc-2019 ENG (6); IAB-G11M-AlgLin-Calc-2019 BRL (6); IAB-G11M-AlgLin-Calc-2019 SPA (6);</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Answer Key\">\n" +
                        "        <name>Item: Answer Key</name>\n" +
                        "        <val>EQ</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Grade\">\n" +
                        "        <name>Item: Grade</name>\n" +
                        "        <val>11</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Item Format\">\n" +
                        "        <name>Item: Item Format</name>\n" +
                        "        <val>EQ</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Page Layout\">\n" +
                        "        <name>Item: Page Layout</name>\n" +
                        "        <val>8</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Response Type\">\n" +
                        "        <name>Item: Response Type</name>\n" +
                        "        <val>EquationEditor</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Item Point\">\n" +
                        "        <name>Item: Item Point</name>\n" +
                        "        <val>2 pts.</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Answer Key (Part II)\">\n" +
                        "        <name>Item: Answer Key (Part II)</name>\n" +
                        "        <val>NA</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Max Choices\">\n" +
                        "        <name>Item:Max Choices</name>\n" +
                        "        <val>NA</val>\n" +
                        "        <desc>NA</desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Max Choices (Part II)\">\n" +
                        "        <name>Item:Max Choices (Part II)</name>\n" +
                        "        <val></val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "    </attriblist>\n" +
                        "    <tutorial id=\"67863\" bankkey=\"200\" />\n" +
                        "    <resourceslist>\n" +
                        "      <resource type=\"wordList\" id=\"116440\" index=\"1\" bankkey=\"200\" />\n" +
                        "    </resourceslist>\n" +
                        "    <statistic />\n" +
                        "    <MachineRubric filename=\"Item_20702_v6.qrx\" />\n" +
                        "    <RendererSpec filename=\"Item_20702_v6.eax\" />\n" +
                        "    <content language=\"ENU\" version=\"2.0\" approvedVersion=\"6\">\n" +
                        "      <rationaleoptlist />\n" +
                        "      <stem><![CDATA[<p style=\"\">Bob and Nina make dog <span id=\"item_20702_TAG_2\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>leashes<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_2\" data-tag-boundary=\"end\"></span>. Bob can make 7 <span id=\"item_20702_TAG_3\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>leashes<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_3\" data-tag-boundary=\"end\"></span> in 2 hours and Nina can make 4 <span id=\"item_20702_TAG_4\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>leashes<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_4\" data-tag-boundary=\"end\"></span> in 1 hour.</p><p style=\"\">&#xA0;</p><p style=\"\"><span id=\"item_20702_TAG_5\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>Enter<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_5\" data-tag-boundary=\"end\"></span> an equation <span id=\"item_20702_TAG_6\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"3\"></span>that can be used<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_6\" data-tag-boundary=\"end\"></span> to <span id=\"item_20702_TAG_7\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"4\"></span>find<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_7\" data-tag-boundary=\"end\"></span> the number of hours, <span style=\"font-style:italic; \">t</span>, <span id=\"item_20702_TAG_8\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"8\"></span>it takes<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_8\" data-tag-boundary=\"end\"></span> Bob and Nina <span id=\"item_20702_TAG_9\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"5\"></span>to make<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_9\" data-tag-boundary=\"end\"></span> 60 <span id=\"item_20702_TAG_10\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>leashes<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_10\" data-tag-boundary=\"end\"></span> <span id=\"item_20702_TAG_11\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"6\"></span>together<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_11\" data-tag-boundary=\"end\"></span>. <span id=\"item_20702_TAG_12\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>Enter<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_12\" data-tag-boundary=\"end\"></span> your response in the <span id=\"item_20702_TAG_13\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"7\"></span>first response box<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_13\" data-tag-boundary=\"end\"></span>.</p><p style=\"\">&#xA0;</p><p style=\"\"><span id=\"item_20702_TAG_14\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>Enter<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_14\" data-tag-boundary=\"end\"></span> the number of hours, <span style=\"font-style:italic; \">t</span>, <span id=\"item_20702_TAG_15\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"8\"></span>it takes<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_15\" data-tag-boundary=\"end\"></span> Bob and Nina <span id=\"item_20702_TAG_16\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"5\"></span>to make<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_16\" data-tag-boundary=\"end\"></span> 60 <span id=\"item_20702_TAG_17\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>leashes<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_17\" data-tag-boundary=\"end\"></span> <span id=\"item_20702_TAG_18\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"6\"></span>together<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_18\" data-tag-boundary=\"end\"></span>. <span id=\"item_20702_TAG_19\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>Enter<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_19\" data-tag-boundary=\"end\"></span> your response in the <span id=\"item_20702_TAG_20\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"9\"></span>second response <span id=\"item_20702_TAG_1_BEGIN\">box.</span><span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_20\" data-tag-boundary=\"end\"></span></p>]]></stem>\n" +
                        "      <rubriclist>\n" +
                        "        <rubric scorepoint=\"\">\n" +
                        "          <name>\n" +
                        "        Rubric </name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p><p style=\"\">Exemplar:</p><p style=\"\">&#xA0;</p><ul style=\"padding-left:1.5000em; \"><li><p style=\"\">3.5<span style=\"font-style:italic; \">t</span> + 4<span style=\"font-style:italic; \">t</span> = 60 or equivalent</p></li><li><p style=\"\">8</p></li></ul><p style=\"\">&#xA0;</p><p style=\"\">For this item, a full-credit response includes</p><p style=\"\">&#xA0;</p><ul style=\"padding-left:1.5000em; \"><li><p style=\"\">2 Points – The student enters an equation equivalent to 3.5t +4t = 60 (excluding t=8) in the first response box AND 8 or t=8 in the second response box.</p></li><li><p style=\"\">1 Point – The student enters an equation equivalent to 3.5t +4t = 60 (excluding t=8) in the first response box OR 8 or t=8 in the second response box.</p></li></ul><p style=\"\">&#xA0;</p><p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rubric>\n" +
                        "        <samplelist maxval=\"\" minval=\"\" />\n" +
                        "      </rubriclist>\n" +
                        "      <attachmentlist>\n" +
                        "        <attachment id=\"braillefile1\" type=\"BRF\" subtype=\"TDS_BT_ECN\" file=\"item_20702_enu_brf_ebae_contracted_nemeth_ecn.brf\" />\n" +
                        "        <attachment id=\"braillefile19\" type=\"BRF\" subtype=\"TDS_BT_UCN\" file=\"item_20702_enu_brf_ueb_contracted_nemeth_ucn.brf\" />\n" +
                        "        <attachment id=\"braillefile31\" type=\"BRF\" subtype=\"TDS_BT_UCT\" file=\"item_20702_enu_brf_ueb_contracted_ueb_math_uct.brf\" />\n" +
                        "        <attachment id=\"braillefile3\" type=\"BRF\" subtype=\"TDS_BT_EXN\" file=\"item_20702_enu_brf_ebae_uncontracted_nemeth_exn.brf\" />\n" +
                        "        <attachment id=\"braillefile16\" type=\"BRF\" subtype=\"TDS_BT_UXN\" file=\"item_20702_enu_brf_ueb_uncontracted_nemeth_uxn.brf\" />\n" +
                        "        <attachment id=\"braillefile27\" type=\"BRF\" subtype=\"TDS_BT_UXT\" file=\"item_20702_enu_brf_ueb_uncontracted_ueb_math_uxt.brf\" />\n" +
                        "        <attachment id=\"aslfile1\" type=\"ASL\" subtype=\"STEM\" file=\"item_20702_ASL_STEM.mp4\">\n" +
                        "          <source src=\"item_20702_ASL_STEM.webm\" type=\"video/webm; codecs=&quot;vp8&quot;\" />\n" +
                        "          <source src=\"item_20702_ASL_STEM.mp4\" type=\"video/mp4; codecs=&quot;avc1.4D40D&quot;\" />\n" +
                        "        </attachment>\n" +
                        "      </attachmentlist>\n" +
                        "      <apipAccessibility>\n" +
                        "        <accessibilityInfo>\n" +
                        "          <accessElement identifier=\"ae20\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_20702_TAG_1_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>box. \n" +
                        "The equation tool has two sections. \n" +
                        "In the left section, from left to right and top to bottom the equation tool reeds, one, two, three, four, five, six, seven, eight, nine, zero, point, negative. \n" +
                        "In the right section mathematical functions are shown.</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>box.</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>box.</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "        </accessibilityInfo>\n" +
                        "      </apipAccessibility>\n" +
                        "    </content>\n" +
                        "    <content language=\"ESN\" version=\"2.0\" approvedVersion=\"5\">\n" +
                        "      <stem><![CDATA[<p style=\"\">Bob y Nina hacen correas para perros. Bob puede hacer 7 correas en 2 horas y Nina puede hacer 4 correas en 1 hora.</p><p style=\"\">&#xA0;</p><p style=\"\">Escribe una ecuación que pueda usarse para encontrar el número de horas, <span style=\"font-style:italic; \">t</span>, que tardan Bob y Nina en hacer 60 correas juntos. Escribe tu contestación en la primera casilla de respuestas.</p><p style=\"\">&#xA0;</p><p style=\"\">Escribe el número de horas, <span style=\"font-style:italic; \">t</span>, que tardan Bob y Nina en hacer 60 correas juntos. Escribe tu contestación en la segunda casilla de respuestas.</p><p class=\"languagedivider\">&#xA0;</p><p style=\"\">Bob and Nina make dog <span id=\"item_20702_TAG_2\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>leashes<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_2\" data-tag-boundary=\"end\"></span>. Bob can make 7 <span id=\"item_20702_TAG_3\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>leashes<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_3\" data-tag-boundary=\"end\"></span> in 2 hours and Nina can make 4 <span id=\"item_20702_TAG_4\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>leashes<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_4\" data-tag-boundary=\"end\"></span> in 1 hour.</p><p style=\"\">&#xA0;</p><p style=\"\"><span id=\"item_20702_TAG_5\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>Enter<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_5\" data-tag-boundary=\"end\"></span> an equation <span id=\"item_20702_TAG_6\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"3\"></span>that can be used<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_6\" data-tag-boundary=\"end\"></span> to <span id=\"item_20702_TAG_7\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"4\"></span>find<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_7\" data-tag-boundary=\"end\"></span> the number of hours, <span style=\"font-style:italic; \">t</span>, <span id=\"item_20702_TAG_8\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"8\"></span>it takes<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_8\" data-tag-boundary=\"end\"></span> Bob and Nina <span id=\"item_20702_TAG_9\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"5\"></span>to make<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_9\" data-tag-boundary=\"end\"></span> 60 <span id=\"item_20702_TAG_10\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>leashes<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_10\" data-tag-boundary=\"end\"></span> <span id=\"item_20702_TAG_11\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"6\"></span>together<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_11\" data-tag-boundary=\"end\"></span>. <span id=\"item_20702_TAG_12\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>Enter<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_12\" data-tag-boundary=\"end\"></span> your response in the <span id=\"item_20702_TAG_13\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"7\"></span>first response box<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_13\" data-tag-boundary=\"end\"></span>.</p><p style=\"\">&#xA0;</p><p style=\"\"><span id=\"item_20702_TAG_14\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>Enter<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_14\" data-tag-boundary=\"end\"></span> the number of hours, <span style=\"font-style:italic; \">t</span>, <span id=\"item_20702_TAG_15\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"8\"></span>it takes<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_15\" data-tag-boundary=\"end\"></span> Bob and Nina <span id=\"item_20702_TAG_16\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"5\"></span>to make<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_16\" data-tag-boundary=\"end\"></span> 60 <span id=\"item_20702_TAG_17\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>leashes<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_17\" data-tag-boundary=\"end\"></span> <span id=\"item_20702_TAG_18\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"6\"></span>together<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_18\" data-tag-boundary=\"end\"></span>. <span id=\"item_20702_TAG_19\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>Enter<span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_19\" data-tag-boundary=\"end\"></span> your response in the <span id=\"item_20702_TAG_20\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"9\"></span>second response <span id=\"item_20702_TAG_1_BEGIN\">box.</span><span class=\"its-tag\" data-tag-ref=\"item_20702_TAG_20\" data-tag-boundary=\"end\"></span></p>]]></stem>\n" +
                        "      <rubriclist>\n" +
                        "        <rubric scorepoint=\"_Spanish\">\n" +
                        "          <name>\n" +
                        "        Rubric _Spanish</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rubric>\n" +
                        "        <samplelist maxval=\"_Spanish\" minval=\"_Spanish\" />\n" +
                        "      </rubriclist>\n" +
                        "      <attachmentlist />\n" +
                        "      <apipAccessibility>\n" +
                        "        <accessibilityInfo>\n" +
                        "          <accessElement identifier=\"ae20\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_20702_TAG_1_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>box. ;\n" +
                        "the equation tool has two sections;\n" +
                        "in the left section, from left to right and top to bottom the equation tool reeds, one, two, three, four, five, six, seven, eight, nine, zero, point, negative;\n" +
                        "in the right section mathmatical functions are shown;</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>box.</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>box.</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "        </accessibilityInfo>\n" +
                        "      </apipAccessibility>\n" +
                        "    </content>\n" +
                        "  </item>\n" +
                        "</itemrelease>\n"))
                .put("50197", new GitLabItemMetaData("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>\n" +
                        "<metadata>\n" +
                        "  <smarterAppMetadata xmlns=\"http://www.smarterapp.org/ns/1/assessment_item_metadata\">\n" +
                        "    <Identifier>50197</Identifier>\n" +
                        "    <StimulusFormat>Standard</StimulusFormat>\n" +
                        "    <Subject>MATH</Subject>\n" +
                        "    <Version>44</Version>\n" +
                        "    <SecurityStatus>Secure</SecurityStatus>\n" +
                        "    <SmarterAppItemDescriptor>84775</SmarterAppItemDescriptor>\n" +
                        "    <ItemAuthorIdentifier>Sridhar_Ravva</ItemAuthorIdentifier>\n" +
                        "    <ItemSpecFormat>SmarterApp</ItemSpecFormat>\n" +
                        "    <LastModifiedBy>Sridhar_Ravva</LastModifiedBy>\n" +
                        "    <IntendedGrade>11</IntendedGrade>\n" +
                        "    <MinimumGrade>11</MinimumGrade>\n" +
                        "    <MaximumGrade>11</MaximumGrade>\n" +
                        "    <DepthOfKnowledge>2</DepthOfKnowledge>\n" +
                        "    <AchievementQuintile>3</AchievementQuintile>\n" +
                        "    <AllowCalculator>Y</AllowCalculator>\n" +
                        "    <InteractionType>MI</InteractionType>\n" +
                        "    <MaximumNumberOfPoints>1</MaximumNumberOfPoints>\n" +
                        "    <ScorePoints>\"0, 1\"</ScorePoints>\n" +
                        "    <ScoringEngine>Automatic with Machine Rubric</ScoringEngine>\n" +
                        "    <PresentationFormat>Text With Graphics</PresentationFormat>\n" +
                        "    <AdministrationDate>Field Test</AdministrationDate>\n" +
                        "    <ContentTaskModel>TM4d_Rpdv</ContentTaskModel>\n" +
                        "    <AlgebraFunctionDescriptor>Linear</AlgebraFunctionDescriptor>\n" +
                        "    <BrailleType>BRF_EBAE_UEB</BrailleType>\n" +
                        "    <EnemyItem>0</EnemyItem>\n" +
                        "    <CopyrightAndOtherRestrictions>Not Set</CopyrightAndOtherRestrictions>\n" +
                        "    <StimulusScource></StimulusScource>\n" +
                        "    <Notes></Notes>\n" +
                        "    <PerformanceTaskComponentItem>N</PerformanceTaskComponentItem>\n" +
                        "    <PtClassroomActivity></PtClassroomActivity>\n" +
                        "    <PtEnemy>0</PtEnemy>\n" +
                        "    <AccessibilityTagsASLLanguage>Y</AccessibilityTagsASLLanguage>\n" +
                        "    <IrtDimension>\n" +
                        "      <IrtStatDomain>Online</IrtStatDomain>\n" +
                        "      <IrtModelType>IRT3PLN</IrtModelType>\n" +
                        "      <IrtDimensionPurpose></IrtDimensionPurpose>\n" +
                        "      <IrtScore>1</IrtScore>\n" +
                        "      <IrtWeight>1</IrtWeight>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>a</Name>\n" +
                        "        <Value>0.73479</Value>\n" +
                        "      </IrtParameter>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>b</Name>\n" +
                        "        <Value>1.12309</Value>\n" +
                        "      </IrtParameter>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>c</Name>\n" +
                        "        <Value>0</Value>\n" +
                        "      </IrtParameter>\n" +
                        "    </IrtDimension>\n" +
                        "    <Status>Operational</Status>\n" +
                        "    <StandardPublication>\n" +
                        "      <Publication>SBAC-MA-v4</Publication>\n" +
                        "      <PrimaryStandard>SBAC-MA-v4:1|F-IF|M|m|F-IF.9</PrimaryStandard>\n" +
                        "    </StandardPublication>\n" +
                        "    <StandardPublication>\n" +
                        "      <Publication>SBAC-MA-v6</Publication>\n" +
                        "      <PrimaryStandard>SBAC-MA-v6:1|P|TS06|M</PrimaryStandard>\n" +
                        "    </StandardPublication>\n" +
                        "    <AssociatedTutorial>67859</AssociatedTutorial>\n" +
                        "    <AssociatedWordlist>116536</AssociatedWordlist>\n" +
                        "    <Language>eng</Language>\n" +
                        "    <Language>spa</Language>\n" +
                        "  </smarterAppMetadata>\n" +
                        "</metadata>\n", "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<itemrelease version=\"2.0\">\n" +
                        "  <item format=\"mi\" id=\"50197\" version=\"44\" bankkey=\"200\">\n" +
                        "    <attriblist>\n" +
                        "      <attrib attid=\"itm_item_id\">\n" +
                        "        <name>Item: ITS ID</name>\n" +
                        "        <val>50197</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_item_subject\">\n" +
                        "        <name>Item: Subject</name>\n" +
                        "        <val>MATH</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_item_desc\">\n" +
                        "        <name>Item: Item Description</name>\n" +
                        "        <val>84775</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_FTUse\">\n" +
                        "        <name>Fieldtest Use</name>\n" +
                        "        <val>Platform::MG11::1.7C (708); SBAC-Int-PR1-FM1-Math-11 (7); SBAC-Int-PR1-FM1-Math-11-SPA (7);</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_OPUse\">\n" +
                        "        <name>Operational Use</name>\n" +
                        "        <val>CAT::MG11::ONCalc-S1-D::SP14 (2068); FAKE MATH FORM (8827); CAT::MG11::CA-ONCalc::D::SP14 (2068); CAT::MG11::CA-ONCalc::D (2068); IAB-G11M-AlgLinearFun-Calc-2015 ENG (6); IAB-G11M-AlgLinearFun-Calc-2015 BRL (6); IAB-G11M-AlgLinearFun-Calc-2015 SPA (6); IAB-G11M-AlgLinearFun-Calc-2015 ENG-COMBINED (6); IAB-G11M-AlgLinearFun-Calc-2015 BRL-COMBINED (6); IAB-G11M-AlgLinearFun-Calc-2015 SPA-COMBINED (6); IAB-G11M-AlgLin-Calc-2017 ENG (7); IAB-G11M-AlgLin-Calc-2017 BRL (7); IAB-G11M-AlgLin-Calc-2017 SPA (7); IAB-G11M-AlgLin-Calc-2017 ENG COMBINED (7); IAB-G11M-AlgLin-Calc-2017 BRL COMBINED (7); IAB-G11M-AlgLin-Calc-2017 SPA COMBINED (7); IAB-G11M-AlgLin-Calc-2018 ENG (7); IAB-G11M-AlgLin-Calc-2018 BRL (7); IAB-G11M-AlgLin-Calc-2018 SPA (7); IAB-G11M-AlgLin-Calc-2018 ENG COMBINED (7); IAB-G11M-AlgLin-Calc-2018 BRL COMBINED (7); IAB-G11M-AlgLin-Calc-2018 SPA COMBINED (7); IAB-G11M-AlgLin-Calc-2019 ENG (7); IAB-G11M-AlgLin-Calc-2019 BRL (7); IAB-G11M-AlgLin-Calc-2019 SPA (7);</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Answer Key\">\n" +
                        "        <name>Item: Answer Key</name>\n" +
                        "        <val>MI</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Grade\">\n" +
                        "        <name>Item: Grade</name>\n" +
                        "        <val>11</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Item Format\">\n" +
                        "        <name>Item: Item Format</name>\n" +
                        "        <val>MI</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Page Layout\">\n" +
                        "        <name>Item: Page Layout</name>\n" +
                        "        <val>8</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Response Type\">\n" +
                        "        <name>Item: Response Type</name>\n" +
                        "        <val>TableMatch</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Item Point\">\n" +
                        "        <name>Item: Item Point</name>\n" +
                        "        <val>1 pt.</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Answer Key (Part II)\">\n" +
                        "        <name>Item: Answer Key (Part II)</name>\n" +
                        "        <val>NA</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Max Choices\">\n" +
                        "        <name>Item:Max Choices</name>\n" +
                        "        <val>0</val>\n" +
                        "        <desc>No Limit</desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Max Choices (Part II)\">\n" +
                        "        <name>Item:Max Choices (Part II)</name>\n" +
                        "        <val></val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "    </attriblist>\n" +
                        "    <tutorial id=\"67859\" bankkey=\"200\" />\n" +
                        "    <resourceslist>\n" +
                        "      <resource type=\"wordList\" id=\"116536\" index=\"1\" bankkey=\"200\" />\n" +
                        "    </resourceslist>\n" +
                        "    <statistic />\n" +
                        "    <MachineRubric filename=\"Item_50197_v44.qrx\" xmlns:its-scripts=\"urn:its-scripts\" />\n" +
                        "    <content language=\"ENU\" version=\"2.0\" xmlns:its-scripts=\"urn:its-scripts\" approvedVersion=\"44\">\n" +
                        "      <qti spec=\"itemBody\"><![CDATA[<matchInteraction responseIdentifier=\"RESPONSE\" minAssociations=\"1\" maxAssociations=\"0\"><prompt /><simpleMatchSet><simpleAssociableChoice identifier=\"1\"><p style=\"\"><img id=\"CrossReference0\" src=\"item_50197_v44_item_50197_mml_svg_png__0.png\" /></p></simpleAssociableChoice><simpleAssociableChoice identifier=\"2\"><p style=\"\"><img id=\"CrossReference1\" src=\"item_50197_v44_item_50197_mml_svg_png__1.png\" /></p></simpleAssociableChoice><simpleAssociableChoice identifier=\"3\"><p style=\"\"><img id=\"CrossReference2\" src=\"item_50197_v44_item_50197_mml_svg_png__2.png\" /></p></simpleAssociableChoice></simpleMatchSet><simpleMatchSet><simpleAssociableChoice identifier=\"a\"><p style=\"\">Table A</p></simpleAssociableChoice><simpleAssociableChoice identifier=\"b\"><p style=\"\">Table B</p></simpleAssociableChoice><simpleAssociableChoice identifier=\"c\"><p style=\"\">Table C</p></simpleAssociableChoice></simpleMatchSet></matchInteraction>]]></qti>\n" +
                        "      <stem><![CDATA[<p style=\"\"><span id=\"item_50197_TAG_6\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>Click<span class=\"its-tag\" data-tag-ref=\"item_50197_TAG_6\" data-tag-boundary=\"end\"></span> in the <span id=\"item_50197_TAG_5\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>appropriate<span class=\"its-tag\" data-tag-ref=\"item_50197_TAG_5\" data-tag-boundary=\"end\"></span> <span id=\"item_50197_TAG_7\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"3\"></span>box<span class=\"its-tag\" data-tag-ref=\"item_50197_TAG_7\" data-tag-boundary=\"end\"></span> to indicate the <span id=\"item_50197_TAG_8\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"4\"></span>match<span class=\"its-tag\" data-tag-ref=\"item_50197_TAG_8\" data-tag-boundary=\"end\"></span> of <span id=\"item_50197_TAG_9\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"5\"></span>each<span class=\"its-tag\" data-tag-ref=\"item_50197_TAG_9\" data-tag-boundary=\"end\"></span> table of values to its equation.</p><p style=\"\">&#xA0;</p><div align=\"left\"><table role=\"presentation\" class=\"newtable\" id=\"item_50197_Table2\" style=\"width:18.6em; border-spacing:0;\" cellpadding=\"0\" cellspacing=\"0\"><colgroup span=\"3\" style=\"width:6.1998em; \" /><tbody><tr><td style=\"padding:0.6000em; vertical-align:top; \"><div align=\"margins\"><table class=\"newtable\" id=\"item_50197_Table4\" style=\"width:4.9998000000000005em; border-spacing:0;\" cellpadding=\"0\" cellspacing=\"0\"><colgroup style=\"width:1.8000em; \" /><colgroup style=\"width:3.1998em; \" /><tbody><tr><td style=\"padding:0.2292em;  border-left:0.06em solid #000000; border-top:0.06em solid #000000; border-bottom:0.06em solid #000000;vertical-align:top; \"><p style=\"text-align:center; font-style:italic; font-weight:bold; font-family:Arial; \"><span id=\"item_50197_TAG_28_BEGIN\">x</span></p></td><td style=\"padding:0.2292em;  border:0.06em solid #000000;vertical-align:top; \"><p style=\"text-align:center; font-style:italic; font-weight:bold; font-family:Arial; \"><span id=\"item_50197_TAG_29_BEGIN\">f(x)</span></p></td></tr><tr><td style=\"vertical-align:middle; padding:0.0582em;  border-left:0.06em solid #000000; border-bottom:0.06em solid #000000;\"><p style=\"text-align:center; font-family:Arial; \"><span id=\"item_50197_TAG_34_BEGIN\">–4</span></p></td><td style=\"padding:0.0582em;  border-left:0.06em solid #000000; border-right:0.06em solid #000000; border-bottom:0.06em solid #000000;vertical-align:top; \"><p style=\"text-align:center; font-family:Arial; \"><img id=\"item_50197_Object1\" style=\"vertical-align:middle;\" src=\"item_50197_v44_Object1_png16malpha.png\" width=\"37\" height=\"33\" /></p></td></tr><tr><td style=\"vertical-align:middle; padding:0.0582em;  border-left:0.06em solid #000000; border-bottom:0.06em solid #000000;\"><p style=\"text-align:center; font-family:Arial; \"><span id=\"item_50197_TAG_37_BEGIN\">–1</span></p></td><td style=\"padding:0.0582em;  border-left:0.06em solid #000000; border-right:0.06em solid #000000; border-bottom:0.06em solid #000000;vertical-align:top; \"><p style=\"text-align:center; font-family:Arial; \"><img id=\"item_50197_Object4\" style=\"vertical-align:middle;\" src=\"item_50197_v44_Object4_png16malpha.png\" width=\"29\" height=\"33\" /></p></td></tr><tr><td style=\"vertical-align:middle; padding:0.0582em;  border-left:0.06em solid #000000; border-bottom:0.06em solid #000000;\"><p style=\"text-align:center; font-family:Arial; \">&#xA0;<span id=\"item_50197_TAG_40_BEGIN\">0</span></p></td><td style=\"padding:0.0582em;  border-left:0.06em solid #000000; border-right:0.06em solid #000000; border-bottom:0.06em solid #000000;vertical-align:top; \"><p style=\"text-align:center; font-family:Arial; \"><img id=\"item_50197_Object5\" style=\"vertical-align:middle;\" src=\"item_50197_v44_Object5_png16malpha.png\" width=\"12\" height=\"33\" /></p></td></tr><tr><td style=\"vertical-align:middle; padding:0.0582em;  border-left:0.06em solid #000000; border-bottom:0.06em solid #000000;\"><p style=\"text-align:center; font-family:Arial; \"><span id=\"item_50197_TAG_43_BEGIN\"> 1</span></p></td><td style=\"padding:0.0582em;  border-left:0.06em solid #000000; border-right:0.06em solid #000000; border-bottom:0.06em solid #000000;vertical-align:top; \"><p style=\"text-align:center; font-family:Arial; \"><img id=\"item_50197_Object6\" style=\"vertical-align:middle;\" src=\"item_50197_v44_Object6_png16malpha.png\" width=\"21\" height=\"33\" /></p></td></tr><tr><td style=\"vertical-align:middle; padding:0.0582em;  border-left:0.06em solid #000000; border-bottom:0.06em solid #000000;\"><p style=\"text-align:center; font-family:Arial; \"><span id=\"item_50197_TAG_46_BEGIN\"> 4</span></p></td><td style=\"padding:0.0582em;  border-left:0.06em solid #000000; border-right:0.06em solid #000000; border-bottom:0.06em solid #000000;vertical-align:top; \"><p style=\"text-align:center; font-family:Arial; \"><img id=\"item_50197_Object7\" style=\"vertical-align:middle;\" src=\"item_50197_v44_Object7_png16malpha.png\" width=\"28\" height=\"33\" /></p></td></tr></tbody></table></div><p style=\"text-align:center; font-weight:bold; font-family:Arial; \">&#xA0;</p></td><td style=\"padding:0.6000em; vertical-align:top; \"><div align=\"margins\"><table class=\"newtable\" id=\"item_50197_Table5\" style=\"width:4.9998000000000005em; border-spacing:0;\" cellpadding=\"0\" cellspacing=\"0\"><colgroup style=\"width:1.8000em; \" /><colgroup style=\"width:3.1998em; \" /><tbody><tr><td style=\"padding:0.2292em;  border-left:0.06em solid #000000; border-top:0.06em solid #000000; border-bottom:0.06em solid #000000;vertical-align:top; \"><p style=\"text-align:center; font-style:italic; font-weight:bold; font-family:Arial; \"><span id=\"item_50197_TAG_32_BEGIN\">x</span></p></td><td style=\"padding:0.2292em;  border:0.06em solid #000000;vertical-align:top; \"><p style=\"text-align:center; font-style:italic; font-weight:bold; font-family:Arial; \"><span id=\"item_50197_TAG_30_BEGIN\">f(x)</span></p></td></tr><tr><td style=\"vertical-align:middle; padding:0.0582em;  border-left:0.06em solid #000000; border-bottom:0.06em solid #000000;\"><p style=\"text-align:center; font-family:Arial; \"><span id=\"item_50197_TAG_35_BEGIN\">–4</span></p></td><td style=\"padding:0.0582em;  border-left:0.06em solid #000000; border-right:0.06em solid #000000; border-bottom:0.06em solid #000000;vertical-align:top; \"><p style=\"text-align:center; font-family:Arial; \"><img id=\"item_50197_Object2\" style=\"vertical-align:middle;\" src=\"item_50197_v44_Object2_png16malpha.png\" width=\"28\" height=\"33\" /></p></td></tr><tr><td style=\"vertical-align:middle; padding:0.0582em;  border-left:0.06em solid #000000; border-bottom:0.06em solid #000000;\"><p style=\"text-align:center; font-family:Arial; \"><span id=\"item_50197_TAG_38_BEGIN\">–1</span></p></td><td style=\"padding:0.0582em;  border-left:0.06em solid #000000; border-right:0.06em solid #000000; border-bottom:0.06em solid #000000;vertical-align:top; \"><p style=\"text-align:center; font-family:Arial; \"><img id=\"item_50197_Object8\" style=\"\" src=\"item_50197_v44_Object8_png16malpha.png\" width=\"21\" height=\"33\" /></p></td></tr><tr><td style=\"vertical-align:middle; padding:0.0582em;  border-left:0.06em solid #000000; border-bottom:0.06em solid #000000;\"><p style=\"text-align:center; font-family:Arial; \"><span id=\"item_50197_TAG_41_BEGIN\"> 0</span></p></td><td style=\"padding:0.0582em;  border-left:0.06em solid #000000; border-right:0.06em solid #000000; border-bottom:0.06em solid #000000;vertical-align:top; \"><p style=\"text-align:center; font-family:Arial; \"><img id=\"item_50197_Object9\" style=\"vertical-align:middle;\" src=\"item_50197_v44_Object9_png16malpha.png\" width=\"12\" height=\"33\" /></p></td></tr><tr><td style=\"vertical-align:middle; padding:0.0582em;  border-left:0.06em solid #000000; border-bottom:0.06em solid #000000;\"><p style=\"text-align:center; font-family:Arial; \"><span id=\"item_50197_TAG_44_BEGIN\"> 1</span></p></td><td style=\"padding:0.0582em;  border-left:0.06em solid #000000; border-right:0.06em solid #000000; border-bottom:0.06em solid #000000;vertical-align:top; \"><p style=\"text-align:center; font-family:Arial; \"><img id=\"item_50197_Object10\" style=\"vertical-align:middle;\" src=\"item_50197_v44_Object10_png16malpha.png\" width=\"29\" height=\"33\" /></p></td></tr><tr><td style=\"vertical-align:middle; padding:0.0582em;  border-left:0.06em solid #000000; border-bottom:0.06em solid #000000;\"><p style=\"text-align:center; font-family:Arial; \"><span id=\"item_50197_TAG_47_BEGIN\"> 4</span></p></td><td style=\"padding:0.0582em;  border-left:0.06em solid #000000; border-right:0.06em solid #000000; border-bottom:0.06em solid #000000;vertical-align:top; \"><p style=\"text-align:center; font-family:Arial; \"><img id=\"item_50197_Object11\" style=\"vertical-align:middle;\" src=\"item_50197_v44_Object11_png16malpha.png\" width=\"37\" height=\"33\" /></p></td></tr></tbody></table></div><p style=\"text-align:center; font-weight:bold; font-family:Arial; \">&#xA0;</p></td><td style=\"padding:0.6000em; vertical-align:top; \"><div align=\"margins\"><table class=\"newtable\" id=\"item_50197_Table6\" style=\"width:4.9998000000000005em; border-spacing:0;\" cellpadding=\"0\" cellspacing=\"0\"><colgroup style=\"width:1.8000em; \" /><colgroup style=\"width:3.1998em; \" /><tbody><tr><td style=\"padding:0.2292em;  border-left:0.06em solid #000000; border-top:0.06em solid #000000; border-bottom:0.06em solid #000000;vertical-align:top; \"><p style=\"text-align:center; font-style:italic; font-weight:bold; font-family:Arial; \"><span id=\"item_50197_TAG_33_BEGIN\">x</span></p></td><td style=\"padding:0.2292em;  border:0.06em solid #000000;vertical-align:top; \"><p style=\"text-align:center; font-style:italic; font-weight:bold; font-family:Arial; \"><span id=\"item_50197_TAG_31_BEGIN\">f(x)</span></p></td></tr><tr><td style=\"vertical-align:middle; padding:0.0582em;  border-left:0.06em solid #000000; border-bottom:0.06em solid #000000;\"><p style=\"text-align:center; font-family:Arial; \"><span id=\"item_50197_TAG_36_BEGIN\">–4</span></p></td><td style=\"padding:0.0582em;  border-left:0.06em solid #000000; border-right:0.06em solid #000000; border-bottom:0.06em solid #000000;vertical-align:top; \"><p style=\"text-align:center; font-family:Arial; \"><img id=\"item_50197_Object3\" style=\"vertical-align:middle;\" src=\"item_50197_v44_Object3_png16malpha.png\" width=\"28\" height=\"33\" /></p></td></tr><tr><td style=\"vertical-align:middle; padding:0.0582em;  border-left:0.06em solid #000000; border-bottom:0.06em solid #000000;\"><p style=\"text-align:center; font-family:Arial; \"><span id=\"item_50197_TAG_39_BEGIN\">–1</span></p></td><td style=\"padding:0.0582em;  border-left:0.06em solid #000000; border-right:0.06em solid #000000; border-bottom:0.06em solid #000000;vertical-align:top; \"><p style=\"text-align:center; font-family:Arial; \"><img id=\"item_50197_Object12\" style=\"vertical-align:middle;\" src=\"item_50197_v44_Object12_png16malpha.png\" width=\"21\" height=\"33\" /></p></td></tr><tr><td style=\"vertical-align:middle; padding:0.0582em;  border-left:0.06em solid #000000; border-bottom:0.06em solid #000000;\"><p style=\"text-align:center; font-family:Arial; \"><span id=\"item_50197_TAG_42_BEGIN\"> 0</span></p></td><td style=\"padding:0.0582em;  border-left:0.06em solid #000000; border-right:0.06em solid #000000; border-bottom:0.06em solid #000000;vertical-align:top; \"><p style=\"text-align:center; font-family:Arial; \"><img id=\"item_50197_Object13\" style=\"vertical-align:middle;\" src=\"item_50197_v44_Object13_png16malpha.png\" width=\"23\" height=\"33\" /></p></td></tr><tr><td style=\"vertical-align:middle; padding:0.0582em;  border-left:0.06em solid #000000; border-bottom:0.06em solid #000000;\"><p style=\"text-align:center; font-family:Arial; \"><span id=\"item_50197_TAG_45_BEGIN\"> 1</span></p></td><td style=\"padding:0.0582em;  border-left:0.06em solid #000000; border-right:0.06em solid #000000; border-bottom:0.06em solid #000000;vertical-align:top; \"><p style=\"text-align:center; font-family:Arial; \"><img id=\"item_50197_Object14\" style=\"vertical-align:middle;\" src=\"item_50197_v44_Object14_png16malpha.png\" width=\"29\" height=\"33\" /></p></td></tr><tr><td style=\"vertical-align:middle; padding:0.0582em;  border-left:0.06em solid #000000; border-bottom:0.06em solid #000000;\"><p style=\"text-align:center; font-family:Arial; \"><span id=\"item_50197_TAG_48_BEGIN\"> 4</span></p></td><td style=\"padding:0.0582em;  border-left:0.06em solid #000000; border-right:0.06em solid #000000; border-bottom:0.06em solid #000000;vertical-align:top; \"><p style=\"text-align:center; font-family:Arial; \"><img id=\"item_50197_Object15\" style=\"vertical-align:middle;\" src=\"item_50197_v44_Object15_png16malpha.png\" width=\"37\" height=\"33\" /></p></td></tr></tbody></table></div><p style=\"text-align:center; font-weight:bold; font-family:Arial; \">&#xA0;</p></td></tr><tr><td style=\"padding-left:0.1in; padding-right:0.1in; padding-top:0in; padding-bottom:0.1in; vertical-align:top; \"><p style=\"text-align:center; font-style:normal; font-weight:bold; font-family:Arial; \"><span id=\"item_50197_TAG_50_BEGIN\">Table A</span></p></td><td style=\"padding-left:0.1in; padding-right:0.1in; padding-top:0in; padding-bottom:0.1in; vertical-align:top; \"><p style=\"text-align:center; font-style:normal; font-weight:bold; font-family:Arial; \"><span id=\"item_50197_TAG_51_BEGIN\">Table B</span></p></td><td style=\"padding-left:0.1in; padding-right:0.1in; padding-top:0in; padding-bottom:0.1in; vertical-align:top; \"><p style=\"text-align:center; font-style:normal; font-weight:bold; font-family:Arial; \"><span id=\"item_50197_TAG_52_BEGIN\">Table C</span></p></td></tr></tbody></table></div><p style=\"\"> </p>]]></stem>\n" +
                        "      <rubriclist>\n" +
                        "        <rubric scorepoint=\"\">\n" +
                        "          <name>\n" +
                        "        Rubric </name>\n" +
                        "          <val><![CDATA[<p style=\"\">The student receives full credit by selecting:</p><p style=\"\">&#xA0;</p><ul style=\"padding-left:1.5000em; \"><li><p style=\"\"><img id=\"item_50197_Object16\" style=\"vertical-align:middle;\" src=\"item_50197_v44_Object16_png16malpha.png\" width=\"120\" height=\"33\" />: Table B</p><p style=\"\">AND</p></li><li><p style=\"\"><img id=\"item_50197_Object17\" style=\"vertical-align:middle;\" src=\"item_50197_v44_Object17_png16malpha.png\" width=\"120\" height=\"33\" />: Table C</p><p style=\"\">AND</p></li><li><p style=\"\"><img id=\"item_50197_Object18\" style=\"vertical-align:middle;\" src=\"item_50197_v44_Object18_png16malpha.png\" width=\"97\" height=\"33\" />: Table A</p></li></ul>]]></val>\n" +
                        "        </rubric>\n" +
                        "        <samplelist maxval=\"\" minval=\"\" />\n" +
                        "      </rubriclist>\n" +
                        "      <attachmentlist>\n" +
                        "        <attachment id=\"braillefile1\" type=\"BRF\" subtype=\"TDS_BT_ECN\" file=\"item_50197_enu_brf_ebae_contracted_nemeth_ecn.brf\" />\n" +
                        "        <attachment id=\"braillefile19\" type=\"BRF\" subtype=\"TDS_BT_UCN\" file=\"item_50197_enu_brf_ueb_contracted_nemeth_ucn.brf\" />\n" +
                        "        <attachment id=\"braillefile31\" type=\"BRF\" subtype=\"TDS_BT_UCT\" file=\"item_50197_enu_brf_ueb_contracted_ueb_math_uct.brf\" />\n" +
                        "        <attachment id=\"braillefile3\" type=\"BRF\" subtype=\"TDS_BT_EXN\" file=\"item_50197_enu_brf_ebae_uncontracted_nemeth_exn.brf\" />\n" +
                        "        <attachment id=\"braillefile16\" type=\"BRF\" subtype=\"TDS_BT_UXN\" file=\"item_50197_enu_brf_ueb_uncontracted_nemeth_uxn.brf\" />\n" +
                        "        <attachment id=\"braillefile27\" type=\"BRF\" subtype=\"TDS_BT_UXT\" file=\"item_50197_enu_brf_ueb_uncontracted_ueb_math_uxt.brf\" />\n" +
                        "        <attachment id=\"aslfile1\" type=\"ASL\" subtype=\"STEM\" file=\"item_50197_ASL_STEM.mp4\">\n" +
                        "          <source src=\"item_50197_ASL_STEM.webm\" type=\"video/webm\" />\n" +
                        "          <source src=\"item_50197_ASL_STEM.mp4\" type=\"video/mp4\" />\n" +
                        "        </attachment>\n" +
                        "      </attachmentlist>\n" +
                        "      <apipAccessibility>\n" +
                        "        <accessibilityInfo>\n" +
                        "          <accessElement identifier=\"ae6\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_Table2\" type=\"Table\" subtype=\"Formatting\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioText>Tables A. , B, and C, are shown. They show X and F of X values for different equations.</audioText>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>Tables A. , B, and C, are shown. They show X and F of X values for different equations.</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae7\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_TAG_28_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>There are three tables shown. The first table is titled, Table-A; The table has 2 columns and 5 rows. From left to right the column headings reed, X,</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>x</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>x</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae8\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_TAG_29_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>F of X;</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>f(x)</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>f(x)</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae9\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_TAG_34_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>From left to right the first row reeds, negative four,</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>–4</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>–4</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae10\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_Object1\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>negative fifteen and one fourth,</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">--15_?1/4#</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae11\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_TAG_37_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>The second row reeds, negative one,</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>–1</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>–1</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae12\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_Object4\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>negative three and one fourth,</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">--3_?1/4#</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae13\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_TAG_40_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>The third row reeds, zero,</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>0</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>0</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae14\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_Object5\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>three force,</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">?3/4#</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae15\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_TAG_43_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>The fourth row reeds, one,</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>1</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>1</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae16\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_Object6\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>four and three force,</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">#4_?3/4#</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae17\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_TAG_46_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>The fifth row reeds, four,</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>4</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>4</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae18\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_Object7\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>sixteen and three force,</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">#16_?3/4#</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae19\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_TAG_32_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>The second table is titled, Table-B; The table has 2 columns and 5 rows. From left to right the column headings reed, X,</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>x</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>x</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae20\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_TAG_30_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>F of X;</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>f(x)</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>f(x)</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae21\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_TAG_35_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>From left to right the first row reeds, negative four,</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>–4</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>–4</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae22\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_Object2\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>sixteen and one fourth,</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>16 the fraction 1 over 4,</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">#16_?1/4#</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae23\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_TAG_38_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>The second row reeds, negative one,</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>–1</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>–1</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae24\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_Object8\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>four and one fourth</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">#4_?1/4#</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae25\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_TAG_41_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>The third row reeds, zero,</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>0</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>0</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae26\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_Object9\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>one fourth,</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">?1/4#</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae27\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_TAG_44_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>The fourth row reeds, one,</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>1</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>1</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae28\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_Object10\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>negative three and three force,</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">--3_?3/4#</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae29\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_TAG_47_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>The fifth row reeds, four,</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>4</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>4</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae30\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_Object11\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>negative fifteen and three force,</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">--15_?3/4#</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae31\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_TAG_33_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>The third table is titled, Table-C; The table has 2 columns and 5 rows. From left to right the column headings reed, X,</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>x</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>x</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae32\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_TAG_31_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>F of X;</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>f(x)</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>f(x)</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae33\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_TAG_36_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>From left to right the first row reeds, negative four,</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>–4</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>–4</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae34\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_Object3\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>fifteen and three force,</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">#15_?3/4#</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae35\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_TAG_39_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>The second row reeds, negative one,</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>–1</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>–1</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae36\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_Object12\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>three and three force,</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">#3_?3/4#</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae37\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_TAG_42_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>The third row reeds, zero,</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>0</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>0</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae38\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_Object13\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>negative one fourth,</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">--?1/4#</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae39\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_TAG_45_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>The fourth row reeds, one,</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>1</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>1</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae40\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_Object14\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>negative four and one fourth,</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">--4_?1/4#</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae41\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_TAG_48_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>The fifth row reeds, four,</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>4</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>4</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae42\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_Object15\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>negative sixteen and one fourth; The table has three columns and three rows. From left to right the column headings reed, Table-A, Table-B, Table-C; From top to bottom the row headings reed, F of X equals negative four X minus, open parenthesis, negative one fourth, closed parenthesis; F of X equals negative four X plus, open parenthesis, negative one fourth, closed parenthesis; F of X equals 4 x plus, open parenthesis, three force, closed parenthesis.</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">--16_?1/4#</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae43\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_TAG_50_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation></textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate></textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae44\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_TAG_51_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation></textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate></textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae45\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_TAG_52_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation></textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate></textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae46\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference0\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>F of X equals negative four X minus, open parenthesis, negative one fourth, closed parenthesis;</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">f (x) .k -4x-(-)?1/4#</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae47\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference1\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>F of X equals negative four X plus, open parenthesis, negative one fourth, closed parenthesis;</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">f (x) .k -4x+(-)?1/4#</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae48\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference2\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>F of X equals 4 x plus, open parenthesis, three force, closed parenthesis.</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">f (x) .k #4x+(?3/4#)</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae49\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_Object16\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>f  the quantity  x  ,   is equal to  minus  4x  minus  the quantity  minus  the fraction 1 over 4,   ,</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>f  the quantity  x  ,   is equal to  minus  4x  minus  the quantity  minus  the fraction 1 over 4,   ,</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">f(x) .k -4x-(-?1/4#)\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae50\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_Object17\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>f  the quantity  x  ,   is equal to  minus  4x  plus  the quantity  minus  the fraction 1 over 4,   ,</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>f  the quantity  x  ,   is equal to  minus  4x  plus  the quantity  minus  the fraction 1 over 4,   ,</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">f(x) .k -4x+(-?1/4#)\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae51\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_Object18\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>f  the quantity  x  ,   is equal to  4x plus  the quantity  the fraction 3 over 4,  ,</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>f  the quantity  x  ,   is equal to  4x plus  the quantity  the fraction 3 over 4,  ,</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">f(x) .k #4x+(?3/4#)\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "        </accessibilityInfo>\n" +
                        "      </apipAccessibility>\n" +
                        "    </content>\n" +
                        "    <content language=\"ESN\" version=\"2.0\" xmlns:its-scripts=\"urn:its-scripts\" approvedVersion=\"11\">\n" +
                        "      <qti spec=\"itemBody\"><![CDATA[<matchInteraction responseIdentifier=\"RESPONSE\" minAssociations=\"1\" maxAssociations=\"0\"><prompt /><simpleMatchSet><simpleAssociableChoice identifier=\"1\"><p style=\"\"><img id=\"CrossReference0\" src=\"item_50197_v11_item_50197_mml_svg_png__0.png\" /></p></simpleAssociableChoice><simpleAssociableChoice identifier=\"2\"><p style=\"\"><img id=\"CrossReference1\" src=\"item_50197_v11_item_50197_mml_svg_png__1.png\" /></p></simpleAssociableChoice><simpleAssociableChoice identifier=\"3\"><p style=\"\"><img id=\"CrossReference2\" src=\"item_50197_v11_item_50197_mml_svg_png__2.png\" /></p></simpleAssociableChoice></simpleMatchSet><simpleMatchSet><simpleAssociableChoice identifier=\"a\"><p style=\"\">Tabla A</p><p class=\"languagedivider\"> </p><p style=\"\">Table A</p></simpleAssociableChoice><simpleAssociableChoice identifier=\"b\"><p style=\"\">Tabla B</p><p class=\"languagedivider\"> </p><p style=\"\">Table B</p></simpleAssociableChoice><simpleAssociableChoice identifier=\"c\"><p style=\"\">Tabla C</p><p class=\"languagedivider\"> </p><p style=\"\">Table C</p></simpleAssociableChoice></simpleMatchSet></matchInteraction>]]></qti>\n" +
                        "      <stem><![CDATA[<p style=\"\">Haz clic en la casilla apropiada para indicar cuál tabla de valores corresponde a cada ecuación.</p><p style=\"\"><br /></p><p style=\"\"><img id=\"item_50197_graphics2\" src=\"item_50197_v11_graphics2_png256.png\" width=\"420\" height=\"312\" style=\"vertical-align:baseline;\" /></p><p class=\"languagedivider\">&#xA0;</p><p style=\"\"><span id=\"item_50197_TAG_6\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>Click<span class=\"its-tag\" data-tag-ref=\"item_50197_TAG_6\" data-tag-boundary=\"end\"></span> in the <span id=\"item_50197_TAG_5\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>appropriate<span class=\"its-tag\" data-tag-ref=\"item_50197_TAG_5\" data-tag-boundary=\"end\"></span> <span id=\"item_50197_TAG_7\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"3\"></span>box<span class=\"its-tag\" data-tag-ref=\"item_50197_TAG_7\" data-tag-boundary=\"end\"></span> to indicate the <span id=\"item_50197_TAG_8\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"4\"></span>match<span class=\"its-tag\" data-tag-ref=\"item_50197_TAG_8\" data-tag-boundary=\"end\"></span> of <span id=\"item_50197_TAG_9\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"5\"></span>each<span class=\"its-tag\" data-tag-ref=\"item_50197_TAG_9\" data-tag-boundary=\"end\"></span> table of values to its equation.</p><p style=\"\"><br /><img id=\"item_50197_graphics1\" src=\"item_50197_v11_graphics1_png256.png\" width=\"314\" height=\"233\" style=\"vertical-align:baseline;\" /></p>]]></stem>\n" +
                        "      <attachmentlist />\n" +
                        "      <apipAccessibility>\n" +
                        "        <accessibilityInfo>\n" +
                        "          <accessElement identifier=\"ae6\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_50197_graphics1\" type=\"Graphic\" subtype=\"Generic\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioText>The title of the left table is, Table A;   The table has 2 columns and 5 rows.  From left to right the column headings reed: x, f of ex.  From left to right the first row reeds: negative 4, negative 15 and 1 fourth.  The second row reeds: negative 1, negative 3 and 1 fourth.  The third row reeds, 0, 3 fourths.  The fourth row reeds: 1, 4 and 3 fourths.  The fifth row reeds: 4, 16 and 3 fourths.\n" +
                        "\n" +
                        "The title of the middle table is, Table Bee.  The table has 2 columns and 5 rows.  From left to right the column headings reed: x, f of ex.  From left to right the first row reeds: negative 4, 16 and 1 fourth.  The second row reeds: negative 1, 4 and 1 fourth.  The third row reeds, 0,  1 fourth.  The fourth row reeds: 1, negative 3 and 3 fourths.  The fifth row reeds: 4, negative 15 and 3 fourths.\n" +
                        "\n" +
                        "The title of the right table is, Table C;  The table has 2 columns and 5 rows.  From left to right the column headings reed: x, f of ex.  From left to right, the first row reeds: negative 4, 15 and 3 fourths.  The second row reeds: negative 1,  3 and 3 fourths.  The third row reeds, 0, negative 1 fourth.  The fourth row reeds: 1, negative 4 and 1 fourth.  The fifth row reeds: 4, negative 16 and 1 fourth.\n" +
                        "\n" +
                        "The bottom table has 3 columns and 3 rows.  From left to right the column headings reed: Table A., Table B, Table C; \n" +
                        "\n" +
                        "From top to bottom the row headings reed: f of x equals negative 4 x minus, open parenthesis, negative 1 fourth, closed parenthesis.   F of x equals negative 4 x plus, open parenthesis, negative 1 fourth, closed parenthesis.   F of x equals 4 x plus, open parenthesis, 3 fourths, closed parenthesis.</audioText>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText />\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "        </accessibilityInfo>\n" +
                        "      </apipAccessibility>\n" +
                        "    </content>\n" +
                        "  </item>\n" +
                        "</itemrelease>\n"))
                .put("32678", new GitLabItemMetaData("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>\n" +
                        "<metadata>\n" +
                        "  <smarterAppMetadata xmlns=\"http://www.smarterapp.org/ns/1/assessment_item_metadata\">\n" +
                        "    <Identifier>32678</Identifier>\n" +
                        "    <ItemAuthorIdentifier>Sridhar_Ravva</ItemAuthorIdentifier>\n" +
                        "    <ItemSpecFormat>SmarterApp</ItemSpecFormat>\n" +
                        "    <LastModifiedBy>Sridhar_Ravva</LastModifiedBy>\n" +
                        "    <SecurityStatus>Secure</SecurityStatus>\n" +
                        "    <SmarterAppItemDescriptor>88613</SmarterAppItemDescriptor>\n" +
                        "    <StimulusFormat>Standard</StimulusFormat>\n" +
                        "    <Subject>MATH</Subject>\n" +
                        "    <Version>6</Version>\n" +
                        "    <IntendedGrade>11</IntendedGrade>\n" +
                        "    <MinimumGrade>8</MinimumGrade>\n" +
                        "    <MaximumGrade>11</MaximumGrade>\n" +
                        "    <MathematicalPractice>3</MathematicalPractice>\n" +
                        "    <DepthOfKnowledge>3</DepthOfKnowledge>\n" +
                        "    <AchievementQuintile>2</AchievementQuintile>\n" +
                        "    <AllowCalculator>Y</AllowCalculator>\n" +
                        "    <InteractionType>MC</InteractionType>\n" +
                        "    <MaximumNumberOfPoints>1</MaximumNumberOfPoints>\n" +
                        "    <ScorePoints>\"0, 1\"</ScorePoints>\n" +
                        "    <ScoringEngine>Automatic with Key</ScoringEngine>\n" +
                        "    <PresentationFormat>Text</PresentationFormat>\n" +
                        "    <AdministrationDate>Field Test</AdministrationDate>\n" +
                        "    <ContentTaskModel>TM5</ContentTaskModel>\n" +
                        "    <AlgebraFunctionDescriptor>Linear</AlgebraFunctionDescriptor>\n" +
                        "    <BrailleType>BRF_EBAE_UEB</BrailleType>\n" +
                        "    <EnemyItem>0</EnemyItem>\n" +
                        "    <CopyrightAndOtherRestrictions>Commissioned</CopyrightAndOtherRestrictions>\n" +
                        "    <PerformanceTaskComponentItem>N</PerformanceTaskComponentItem>\n" +
                        "    <PtEnemy>0</PtEnemy>\n" +
                        "    <AccessibilityTagsASLLanguage>Y</AccessibilityTagsASLLanguage>\n" +
                        "    <IrtDimension>\n" +
                        "      <IrtStatDomain>Online</IrtStatDomain>\n" +
                        "      <IrtModelType>IRT3PLN</IrtModelType>\n" +
                        "      <IrtDimensionPurpose></IrtDimensionPurpose>\n" +
                        "      <IrtScore>1</IrtScore>\n" +
                        "      <IrtWeight>1</IrtWeight>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>a</Name>\n" +
                        "        <Value>0.34044</Value>\n" +
                        "      </IrtParameter>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>b</Name>\n" +
                        "        <Value>2.07126</Value>\n" +
                        "      </IrtParameter>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>c</Name>\n" +
                        "        <Value>0</Value>\n" +
                        "      </IrtParameter>\n" +
                        "    </IrtDimension>\n" +
                        "    <Status>Operational</Status>\n" +
                        "    <StandardPublication>\n" +
                        "      <Publication>SBAC-MA-v4</Publication>\n" +
                        "      <PrimaryStandard>SBAC-MA-v4:3|A-SSE|E|NA|NA</PrimaryStandard>\n" +
                        "      <SecondaryStandard>SBAC-MA-v5:1|A-SSE|D|m|A-SSE.2</SecondaryStandard>\n" +
                        "    </StandardPublication>\n" +
                        "    <StandardPublication>\n" +
                        "      <Publication>SBAC-MA-v6</Publication>\n" +
                        "      <PrimaryStandard>SBAC-MA-v6:3|A|NA|E</PrimaryStandard>\n" +
                        "    </StandardPublication>\n" +
                        "    <AssociatedTutorial>67708</AssociatedTutorial>\n" +
                        "    <AssociatedWordlist>118278</AssociatedWordlist>\n" +
                        "    <Language>eng</Language>\n" +
                        "    <Language>spa</Language>\n" +
                        "  </smarterAppMetadata>\n" +
                        "</metadata>\n", "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<itemrelease version=\"2.0\">\n" +
                        "  <item format=\"mc\" id=\"32678\" version=\"6\" bankkey=\"200\">\n" +
                        "    <attriblist>\n" +
                        "      <attrib attid=\"itm_item_id\">\n" +
                        "        <name>Item: ITS ID</name>\n" +
                        "        <val>32678</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_item_subject\">\n" +
                        "        <name>Item: Subject</name>\n" +
                        "        <val>MATH</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_item_desc\">\n" +
                        "        <name>Item: Item Description</name>\n" +
                        "        <val>88613</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_FTUse\">\n" +
                        "        <name>Fieldtest Use</name>\n" +
                        "        <val>Platform::MG11::1.7C (80); SBAC-Int-PR1-FM1-Math-11 (8); SBAC-Int-PR1-FM1-Math-11-SPA (8);</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_OPUse\">\n" +
                        "        <name>Operational Use</name>\n" +
                        "        <val>CAT::MG11::ONCalc-S1-D::SP14 (1477); FAKE MATH FORM (7494); CAT::MG11::CA-ONCalc::D::SP14 (1477); CAT::MG11::CA-ONCalc::D (1477); IAB-G11M-AlgLinearFun-Calc-2015 ENG (7); IAB-G11M-AlgLinearFun-Calc-2015 BRL (7); IAB-G11M-AlgLinearFun-Calc-2015 SPA (7); IAB-G11M-AlgLinearFun-Calc-2015 ENG-COMBINED (7); IAB-G11M-AlgLinearFun-Calc-2015 BRL-COMBINED (7); IAB-G11M-AlgLinearFun-Calc-2015 SPA-COMBINED (7); IAB-G11M-AlgLin-Calc-2017 ENG (8); IAB-G11M-AlgLin-Calc-2017 BRL (8); IAB-G11M-AlgLin-Calc-2017 SPA (8); IAB-G11M-AlgLin-Calc-2017 ENG COMBINED (8); IAB-G11M-AlgLin-Calc-2017 BRL COMBINED (8); IAB-G11M-AlgLin-Calc-2017 SPA COMBINED (8); IAB-G11M-AlgLin-Calc-2018 ENG (8); IAB-G11M-AlgLin-Calc-2018 BRL (8); IAB-G11M-AlgLin-Calc-2018 SPA (8); IAB-G11M-AlgLin-Calc-2018 ENG COMBINED (8); IAB-G11M-AlgLin-Calc-2018 BRL COMBINED (8); IAB-G11M-AlgLin-Calc-2018 SPA COMBINED (8); IAB-G11M-AlgLin-Calc-2019 ENG (8); IAB-G11M-AlgLin-Calc-2019 BRL (8); IAB-G11M-AlgLin-Calc-2019 SPA (8);</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Answer Key\">\n" +
                        "        <name>Item: Answer Key</name>\n" +
                        "        <val>C</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Grade\">\n" +
                        "        <name>Item: Grade</name>\n" +
                        "        <val>11</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Item Format\">\n" +
                        "        <name>Item: Item Format</name>\n" +
                        "        <val>MC</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Page Layout\">\n" +
                        "        <name>Item: Page Layout</name>\n" +
                        "        <val>8</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Response Type\">\n" +
                        "        <name>Item: Response Type</name>\n" +
                        "        <val>Vertical</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Item Point\">\n" +
                        "        <name>Item: Item Point</name>\n" +
                        "        <val>1 pt.</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Answer Key (Part II)\">\n" +
                        "        <name>Item: Answer Key (Part II)</name>\n" +
                        "        <val></val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Max Choices\">\n" +
                        "        <name>Item:Max Choices</name>\n" +
                        "        <val></val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Max Choices (Part II)\">\n" +
                        "        <name>Item:Max Choices (Part II)</name>\n" +
                        "        <val></val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "    </attriblist>\n" +
                        "    <tutorial id=\"67708\" bankkey=\"200\" />\n" +
                        "    <resourceslist>\n" +
                        "      <resource type=\"wordList\" id=\"118278\" index=\"1\" bankkey=\"200\" />\n" +
                        "    </resourceslist>\n" +
                        "    <statistic />\n" +
                        "    <content language=\"ENU\" version=\"2.0\" approvedVersion=\"6\">\n" +
                        "      <concept>\n" +
                        "        <name>What Knowledge Do Students Need to Understand This Concept?</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </concept>\n" +
                        "      <es>\n" +
                        "        <name>Explanation of Correct Answer</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </es>\n" +
                        "      <himi>\n" +
                        "        <name>Explanation of Correct Answer</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </himi>\n" +
                        "      <rationaleoptlist>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option A</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option B</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option C</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option D</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "      </rationaleoptlist>\n" +
                        "      <stem><![CDATA[<p style=\"\"><span id=\"item_32678_TAG_14\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>Use<span class=\"its-tag\" data-tag-ref=\"item_32678_TAG_14\" data-tag-boundary=\"end\"></span> the equation below to answer the question.</p><p style=\"\"><br /><span id=\"item_32678_TAG_1_BEGIN\"><img id=\"CrossReference0\" src=\"item_32678_v6_item_32678_mml_svg_png__0.png\"/></span></p><p style=\"\"><br /><span id=\"item_32678_TAG_15\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>Which<span class=\"its-tag\" data-tag-ref=\"item_32678_TAG_15\" data-tag-boundary=\"end\"></span> equivalent equation is correctly matched with a key feature of the graph of the function it represents?</p>]]></stem>\n" +
                        "      <optionlist>\n" +
                        "        <option>\n" +
                        "          <name>Option A</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><span id=\"item_32678_TAG_2_BEGIN\"><img id=\"CrossReference1\" src=\"item_32678_v6_item_32678_mml_svg_png__1.png\"/></span> highlights that the <span id=\"item_32678_TAG_3_BEGIN\"><img id=\"CrossReference2\" src=\"item_32678_v6_item_32678_mml_svg_png__2.png\"/></span>-intercept is at <span id=\"item_32678_TAG_4_BEGIN\"><img id=\"CrossReference3\" src=\"item_32678_v6_item_32678_mml_svg_png__3.png\"/></span>.</p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option B</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><span id=\"item_32678_TAG_5_BEGIN\"><img id=\"CrossReference4\" src=\"item_32678_v6_item_32678_mml_svg_png__4.png\"/></span> highlights that the <img id=\"CrossReference5\" src=\"item_32678_v6_item_32678_mml_svg_png__5.png\"/>-intercept is at <span id=\"item_32678_TAG_7_BEGIN\"><img id=\"CrossReference6\" src=\"item_32678_v6_item_32678_mml_svg_png__6.png\"/></span>.</p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option C</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><span id=\"item_32678_TAG_8_BEGIN\"><img id=\"CrossReference7\" src=\"item_32678_v6_item_32678_mml_svg_png__7.png\"/></span> highlights that the <img id=\"CrossReference8\" src=\"item_32678_v6_item_32678_mml_svg_png__8.png\"/>-intercept is at <span id=\"item_32678_TAG_10_BEGIN\"><img id=\"CrossReference9\" src=\"item_32678_v6_item_32678_mml_svg_png__9.png\"/></span>.</p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option D</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><span id=\"item_32678_TAG_11_BEGIN\"><img id=\"CrossReference10\" src=\"item_32678_v6_item_32678_mml_svg_png__10.png\"/></span> highlights that the <img id=\"CrossReference11\" src=\"item_32678_v6_item_32678_mml_svg_png__11.png\"/>-intercept is at <span id=\"item_32678_TAG_13_BEGIN\"><img id=\"CrossReference12\" src=\"item_32678_v6_item_32678_mml_svg_png__12.png\"/></span>.</p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "      </optionlist>\n" +
                        "      <attachmentlist>\n" +
                        "        <attachment id=\"braillefile1\" type=\"BRF\" subtype=\"TDS_BT_ECN\" file=\"item_32678_enu_brf_ebae_contracted_nemeth_ecn.brf\" />\n" +
                        "        <attachment id=\"braillefile19\" type=\"BRF\" subtype=\"TDS_BT_UCN\" file=\"item_32678_enu_brf_ueb_contracted_nemeth_ucn.brf\" />\n" +
                        "        <attachment id=\"braillefile31\" type=\"BRF\" subtype=\"TDS_BT_UCT\" file=\"item_32678_enu_brf_ueb_contracted_ueb_math_uct.brf\" />\n" +
                        "        <attachment id=\"braillefile3\" type=\"BRF\" subtype=\"TDS_BT_EXN\" file=\"item_32678_enu_brf_ebae_uncontracted_nemeth_exn.brf\" />\n" +
                        "        <attachment id=\"braillefile16\" type=\"BRF\" subtype=\"TDS_BT_UXN\" file=\"item_32678_enu_brf_ueb_uncontracted_nemeth_uxn.brf\" />\n" +
                        "        <attachment id=\"braillefile27\" type=\"BRF\" subtype=\"TDS_BT_UXT\" file=\"item_32678_enu_brf_ueb_uncontracted_ueb_math_uxt.brf\" />\n" +
                        "        <attachment id=\"aslfile1\" type=\"ASL\" subtype=\"STEM\" file=\"item_32678_ASL_STEM.mp4\">\n" +
                        "          <source src=\"item_32678_ASL_STEM.webm\" type=\"video/webm\" />\n" +
                        "          <source src=\"item_32678_ASL_STEM.mp4\" type=\"video/mp4\" />\n" +
                        "        </attachment>\n" +
                        "      </attachmentlist>\n" +
                        "      <apipAccessibility>\n" +
                        "        <accessibilityInfo>\n" +
                        "          <accessElement identifier=\"ae2\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_32678_TAG_1_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>y equals 3 x plus 6.</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate></textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">y .k #3x+6\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae4\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_32678_TAG_2_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>Why equals 3 times, open parenthesis, x plus 2, closed parenthesis,</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate></textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">y .k #3(x)+2\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae5\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_32678_TAG_3_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>why</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>&lt;insert_Item_32678_MML_SVG_PNG__2&gt;</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">;y\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae6\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_32678_TAG_4_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>negative 2</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate></textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">-2\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae7\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_32678_TAG_5_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>Why equals 3 times, open parenthesis, x plus 2, closed parenthesis,</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate></textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">y .k #3(x)+2\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae8\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference5\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>why</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">;y</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae9\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_32678_TAG_7_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>2</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate></textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">#2\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae10\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_32678_TAG_8_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>Why equals 3 times, open parenthesis, x plus 2, closed parenthesis,</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate></textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">y .k #3(x)+2\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae11\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference8\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>x</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">;x</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae12\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_32678_TAG_10_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>negative 2</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate></textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">-2\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae13\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_32678_TAG_11_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>Why equals 3 times, open parenthesis, x plus 2, closed parenthesis,</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate></textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">y .k #3(x)+2\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae14\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference11\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>x</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">;x</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae15\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_32678_TAG_13_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>2</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate></textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">#2\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "        </accessibilityInfo>\n" +
                        "      </apipAccessibility>\n" +
                        "    </content>\n" +
                        "    <content language=\"ESN\" version=\"2.0\" approvedVersion=\"6\">\n" +
                        "      <concept>\n" +
                        "        <name>What Knowledge Do Students Need to Understand This Concept?</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </concept>\n" +
                        "      <es>\n" +
                        "        <name>Explanation of Correct Answer</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </es>\n" +
                        "      <himi>\n" +
                        "        <name>Explanation of Correct Answer</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </himi>\n" +
                        "      <rationaleoptlist>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option A</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option B</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option C</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option D</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "      </rationaleoptlist>\n" +
                        "      <stem><![CDATA[<p style=\"\">Usa la siguiente ecuación para contestar la pregunta.</p><p style=\"\"><br /><img id=\"CrossReference13\" src=\"item_32678_v6_item_32678_mml_svg_png__0.png\"/></p><p style=\"\"><br />¿<span style=\"language:es; country:ES; \">Cuál ecuación equivalente está relacionada correctamente con una característica importante de la gráfica de la función que representa</span>?</p><p class=\"languagedivider\">&#xA0;</p><p style=\"\"><span id=\"item_32678_TAG_14\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>Use<span class=\"its-tag\" data-tag-ref=\"item_32678_TAG_14\" data-tag-boundary=\"end\"></span> the equation below to answer the question.</p><p style=\"\"><br /><span id=\"item_32678_TAG_1_BEGIN\"><img id=\"CrossReference0\" src=\"item_32678_v6_item_32678_mml_svg_png__0.png\"/></span></p><p style=\"\"><br /><span id=\"item_32678_TAG_15\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>Which<span class=\"its-tag\" data-tag-ref=\"item_32678_TAG_15\" data-tag-boundary=\"end\"></span> equivalent equation is correctly matched with a key feature of the graph of the function it represents?</p>]]></stem>\n" +
                        "      <optionlist>\n" +
                        "        <option>\n" +
                        "          <name>Option A</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"CrossReference14\" src=\"item_32678_v6_item_32678_mml_svg_png__1.png\"/> resalta que el intercepto de <img id=\"CrossReference15\" src=\"item_32678_v6_item_32678_mml_svg_png__2.png\"/> está en <img id=\"CrossReference16\" src=\"item_32678_v6_item_32678_mml_svg_png__3.png\"/>.</p><p class=\"languagedivider\">&#xA0;</p><p style=\"\"><span id=\"item_32678_TAG_2_BEGIN\"><img id=\"CrossReference1\" src=\"item_32678_v6_item_32678_mml_svg_png__1.png\"/></span> highlights that the <span id=\"item_32678_TAG_3_BEGIN\"><img id=\"CrossReference2\" src=\"item_32678_v6_item_32678_mml_svg_png__2.png\"/></span>-intercept is at <span id=\"item_32678_TAG_4_BEGIN\"><img id=\"CrossReference3\" src=\"item_32678_v6_item_32678_mml_svg_png__3.png\"/></span>.</p><p class=\"optiondivider\">&#xA0;</p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option B</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"CrossReference17\" src=\"item_32678_v6_item_32678_mml_svg_png__4.png\"/> resalta que el intercepto de <img id=\"CrossReference18\" src=\"item_32678_v6_item_32678_mml_svg_png__5.png\"/> está en &#xA0;<img id=\"CrossReference19\" src=\"item_32678_v6_item_32678_mml_svg_png__6.png\"/>.</p><p class=\"languagedivider\">&#xA0;</p><p style=\"\"><span id=\"item_32678_TAG_5_BEGIN\"><img id=\"CrossReference4\" src=\"item_32678_v6_item_32678_mml_svg_png__4.png\"/></span> highlights that the <img id=\"CrossReference5\" src=\"item_32678_v6_item_32678_mml_svg_png__5.png\"/>-intercept is at <span id=\"item_32678_TAG_7_BEGIN\"><img id=\"CrossReference6\" src=\"item_32678_v6_item_32678_mml_svg_png__6.png\"/></span>.</p><p class=\"optiondivider\">&#xA0;</p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option C</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"CrossReference20\" src=\"item_32678_v6_item_32678_mml_svg_png__7.png\"/> resalta que el intercepto de <img id=\"CrossReference21\" src=\"item_32678_v6_item_32678_mml_svg_png__8.png\"/> está en <img id=\"CrossReference22\" src=\"item_32678_v6_item_32678_mml_svg_png__9.png\"/>.</p><p class=\"languagedivider\">&#xA0;</p><p style=\"\"><span id=\"item_32678_TAG_8_BEGIN\"><img id=\"CrossReference7\" src=\"item_32678_v6_item_32678_mml_svg_png__7.png\"/></span> highlights that the <img id=\"CrossReference8\" src=\"item_32678_v6_item_32678_mml_svg_png__8.png\"/>-intercept is at <span id=\"item_32678_TAG_10_BEGIN\"><img id=\"CrossReference9\" src=\"item_32678_v6_item_32678_mml_svg_png__9.png\"/></span>.</p><p class=\"optiondivider\">&#xA0;</p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option D</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"CrossReference23\" src=\"item_32678_v6_item_32678_mml_svg_png__10.png\"/> resalta que el intercepto de <img id=\"CrossReference24\" src=\"item_32678_v6_item_32678_mml_svg_png__11.png\"/> está en <img id=\"CrossReference25\" src=\"item_32678_v6_item_32678_mml_svg_png__12.png\"/>.</p><p class=\"languagedivider\">&#xA0;</p><p style=\"\"><span id=\"item_32678_TAG_11_BEGIN\"><img id=\"CrossReference10\" src=\"item_32678_v6_item_32678_mml_svg_png__10.png\"/></span> highlights that the <img id=\"CrossReference11\" src=\"item_32678_v6_item_32678_mml_svg_png__11.png\"/>-intercept is at <span id=\"item_32678_TAG_13_BEGIN\"><img id=\"CrossReference12\" src=\"item_32678_v6_item_32678_mml_svg_png__12.png\"/></span>.</p><p class=\"optiondivider\">&#xA0;</p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "      </optionlist>\n" +
                        "      <attachmentlist />\n" +
                        "      <apipAccessibility>\n" +
                        "        <accessibilityInfo>\n" +
                        "          <accessElement identifier=\"ae2\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_32678_TAG_1_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>y equals 3 x plus 6.</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">y .k #3x+6\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae4\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_32678_TAG_2_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>Why equals 3 times, open parenthesis, x plus 2, closed parenthesis,</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">y .k #3(x)+2\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae5\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_32678_TAG_3_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>why</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>&lt;insert_Item_32678_MML_SVG_PNG__2&gt;</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">;y\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae6\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_32678_TAG_4_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>negative 2</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">-2\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae7\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_32678_TAG_5_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>Why equals 3 times, open parenthesis, x plus 2, closed parenthesis,</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">y .k #3(x)+2\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae8\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference5\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>why</audioShortDesc>\n" +
                        "                <audioLongDesc />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">;y</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae9\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_32678_TAG_7_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>2</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">#2\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae10\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_32678_TAG_8_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>Why equals 3 times, open parenthesis, x plus 2, closed parenthesis,</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">y .k #3(x)+2\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae11\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference8\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>x</audioShortDesc>\n" +
                        "                <audioLongDesc />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">;x</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae12\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_32678_TAG_10_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>negative 2</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">-2\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae13\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_32678_TAG_11_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>Why equals 3 times, open parenthesis, x plus 2, closed parenthesis,</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">y .k #3(x)+2\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae14\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference11\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>x</audioShortDesc>\n" +
                        "                <audioLongDesc />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">;x</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae15\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_32678_TAG_13_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>2</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">#2\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae16\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference13\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>y  is equal to  3 x  plus  6</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>y  is equal to  3 x  plus  6</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">y .k #3x+6\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae17\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference14\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>y  is equal to  3 UNKNOWN</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>y  is equal to  3 UNKNOWN</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">y .k #3(x)+2\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae18\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference15\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>y</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>y</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">;y\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae19\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference16\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>minus  2</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>minus  2</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">-2\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae20\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference17\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>y  is equal to  3 UNKNOWN</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>y  is equal to  3 UNKNOWN</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">y .k #3(x)+2\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae21\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference18\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>y</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>y</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">;y\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae22\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference19\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>2</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>2</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">#2\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae23\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference20\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>y  is equal to  3 UNKNOWN</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>y  is equal to  3 UNKNOWN</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">y .k #3(x)+2\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae24\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference21\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>x</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>x</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">;x\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae25\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference22\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>minus  2</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>minus  2</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">-2\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae26\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference23\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>y  is equal to  3 UNKNOWN</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>y  is equal to  3 UNKNOWN</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">y .k #3(x)+2\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae27\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference24\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>x</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>x</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">;x\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae28\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference25\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>2</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>2</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">#2\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "        </accessibilityInfo>\n" +
                        "      </apipAccessibility>\n" +
                        "    </content>\n" +
                        "  </item>\n" +
                        "</itemrelease>\n"))
                .put("31336", new GitLabItemMetaData("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>\n" +
                        "<metadata>\n" +
                        "  <smarterAppMetadata xmlns=\"http://www.smarterapp.org/ns/1/assessment_item_metadata\">\n" +
                        "    <Identifier>31336</Identifier>\n" +
                        "    <ItemAuthorIdentifier>Sridhar_Ravva</ItemAuthorIdentifier>\n" +
                        "    <ItemSpecFormat>SmarterApp</ItemSpecFormat>\n" +
                        "    <LastModifiedBy>Sridhar_Ravva</LastModifiedBy>\n" +
                        "    <StimulusFormat>Standard</StimulusFormat>\n" +
                        "    <Subject>MATH</Subject>\n" +
                        "    <Version>14</Version>\n" +
                        "    <SecurityStatus>Secure</SecurityStatus>\n" +
                        "    <SmarterAppItemDescriptor>86576</SmarterAppItemDescriptor>\n" +
                        "    <IntendedGrade>11</IntendedGrade>\n" +
                        "    <MinimumGrade>9</MinimumGrade>\n" +
                        "    <MaximumGrade>11</MaximumGrade>\n" +
                        "    <MathematicalPractice>None</MathematicalPractice>\n" +
                        "    <DepthOfKnowledge>2</DepthOfKnowledge>\n" +
                        "    <AchievementQuintile>3</AchievementQuintile>\n" +
                        "    <AllowCalculator>Y</AllowCalculator>\n" +
                        "    <InteractionType>MI</InteractionType>\n" +
                        "    <MaximumNumberOfPoints>1</MaximumNumberOfPoints>\n" +
                        "    <ScorePoints>\"0, 1\"</ScorePoints>\n" +
                        "    <ScoringEngine>Automatic with Machine Rubric</ScoringEngine>\n" +
                        "    <PresentationFormat>Text</PresentationFormat>\n" +
                        "    <AdministrationDate>Field Test</AdministrationDate>\n" +
                        "    <ContentTaskModel>TM2b_Rpdv</ContentTaskModel>\n" +
                        "    <AlgebraFunctionDescriptor>Linear</AlgebraFunctionDescriptor>\n" +
                        "    <BrailleType>BRF_EBAE_UEB</BrailleType>\n" +
                        "    <EnemyItem>0</EnemyItem>\n" +
                        "    <CopyrightAndOtherRestrictions>Not Set</CopyrightAndOtherRestrictions>\n" +
                        "    <PerformanceTaskComponentItem>N</PerformanceTaskComponentItem>\n" +
                        "    <PtEnemy>0</PtEnemy>\n" +
                        "    <AccessibilityTagsASLLanguage>Y</AccessibilityTagsASLLanguage>\n" +
                        "    <IrtDimension>\n" +
                        "      <IrtStatDomain>Online</IrtStatDomain>\n" +
                        "      <IrtModelType>IRT3PLN</IrtModelType>\n" +
                        "      <IrtDimensionPurpose></IrtDimensionPurpose>\n" +
                        "      <IrtScore>1</IrtScore>\n" +
                        "      <IrtWeight>1</IrtWeight>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>a</Name>\n" +
                        "        <Value>0.27157</Value>\n" +
                        "      </IrtParameter>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>b</Name>\n" +
                        "        <Value>2.68704</Value>\n" +
                        "      </IrtParameter>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>c</Name>\n" +
                        "        <Value>0</Value>\n" +
                        "      </IrtParameter>\n" +
                        "    </IrtDimension>\n" +
                        "    <Status>Operational</Status>\n" +
                        "    <StandardPublication>\n" +
                        "      <Publication>SBAC-MA-v6</Publication>\n" +
                        "      <PrimaryStandard>SBAC-MA-v6:1|P|TS06|N</PrimaryStandard>\n" +
                        "    </StandardPublication>\n" +
                        "    <StandardPublication>\n" +
                        "      <Publication>SBAC-MA-v4</Publication>\n" +
                        "      <PrimaryStandard>SBAC-MA-v4:1|F-BF|N|m|F-BF.2</PrimaryStandard>\n" +
                        "    </StandardPublication>\n" +
                        "    <AssociatedTutorial>67859</AssociatedTutorial>\n" +
                        "    <AssociatedWordlist>64706</AssociatedWordlist>\n" +
                        "    <Language>eng</Language>\n" +
                        "    <Language>spa</Language>\n" +
                        "  </smarterAppMetadata>\n" +
                        "</metadata>\n", "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<itemrelease version=\"2.0\">\n" +
                        "  <item format=\"mi\" id=\"31336\" version=\"14\" bankkey=\"200\">\n" +
                        "    <attriblist>\n" +
                        "      <attrib attid=\"itm_item_id\">\n" +
                        "        <name>Item: ITS ID</name>\n" +
                        "        <val>31336</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_item_subject\">\n" +
                        "        <name>Item: Subject</name>\n" +
                        "        <val>MATH</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_item_desc\">\n" +
                        "        <name>Item: Item Description</name>\n" +
                        "        <val>86576</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_FTUse\">\n" +
                        "        <name>Fieldtest Use</name>\n" +
                        "        <val>Platform::MG11::1.7B (805); SBAC-Int-PR1-FM1-Math-11 (9); SBAC-Int-PR1-FM1-Math-11-SPA (9);</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_OPUse\">\n" +
                        "        <name>Operational Use</name>\n" +
                        "        <val>CAT::MG11::ONCalc-S1-D::SP14 (1403); CAT::MG11::ONONCalc-S1-A1::SP14 (283); FAKE MATH FORM (7340); CAT::MG11::ONCalc-S1-A2::SP14 (283); CAT::MG11::ONCalc-S1-A4::SP14 (283); CAT::MG10::ONCalc-S1-A4::SP14 (283); CAT::MG11::ONCalc-S1-A3::SP14 (283); CAT::MG11::ONCalc-S4-A3::SP14 (283); CAT::MG11::CA-ONCalc::SP14 (283); CAT::MG10::ONCalc-S1-A4::SP14-ESN (281); CAT::MG11::ONONCalc-S1-A1::SP14-ESN (281); CAT::MG11::ONCalc-S1-D::SP14-ESN (281); CAT::MG11::ONCalc-S4-A3::SP14-ESN (281); CAT::MG11::ONCalc-S1-A2::SP14-ESN (281); CAT::MG11::ONCalc-S1-A3::SP14-ESN (281); CAT::MG8::UPCALC-S1-B::SP14-ESN (281); CAT::MG8::UPCALC-S4-B::SP14-ESN (281); CAT::MG11::CA-ONCalc::SP14-ESN (281); CAT::MATH910::VL11NoCALC-S2-C::SP14-ESN (281); CAT::MATH910::VL11NoCALC-S3-C::SP14-ESN (281); CAT::MG11::CA-ONCalc::D::SP14 (1403); CAT::MG11::CA-ONCalc::D::SP14-ESN (281); CAT::MG11::CA-ONCalc::D (1403); IAB-G11M-AlgLinearFun-Calc-2015 ENG (10); IAB-G11M-AlgLinearFun-Calc-2015 BRL (10); IAB-G11M-AlgLinearFun-Calc-2015 SPA (10); IAB-G11M-AlgLinearFun-Calc-2015 ENG-COMBINED (10); IAB-G11M-AlgLinearFun-Calc-2015 BRL-COMBINED (10); IAB-G11M-AlgLinearFun-Calc-2015 SPA-COMBINED (10); IAB-G11M-AlgLin-Calc-2017 ENG (9); IAB-G11M-AlgLin-Calc-2017 BRL (9); IAB-G11M-AlgLin-Calc-2017 SPA (9); IAB-G11M-AlgLin-Calc-2017 ENG COMBINED (9); IAB-G11M-AlgLin-Calc-2017 BRL COMBINED (9); IAB-G11M-AlgLin-Calc-2017 SPA COMBINED (9); IAB-G11M-AlgLin-Calc-2018 ENG (9); IAB-G11M-AlgLin-Calc-2018 BRL (9); IAB-G11M-AlgLin-Calc-2018 SPA (9); IAB-G11M-AlgLin-Calc-2018 ENG COMBINED (9); IAB-G11M-AlgLin-Calc-2018 BRL COMBINED (9); IAB-G11M-AlgLin-Calc-2018 SPA COMBINED (9); IAB-G11M-AlgLin-Calc-2019 ENG (9); IAB-G11M-AlgLin-Calc-2019 BRL (9); IAB-G11M-AlgLin-Calc-2019 SPA (9);</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Answer Key\">\n" +
                        "        <name>Item: Answer Key</name>\n" +
                        "        <val>MI</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Grade\">\n" +
                        "        <name>Item: Grade</name>\n" +
                        "        <val>11</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Item Format\">\n" +
                        "        <name>Item: Item Format</name>\n" +
                        "        <val>MI</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Page Layout\">\n" +
                        "        <name>Item: Page Layout</name>\n" +
                        "        <val>8</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Response Type\">\n" +
                        "        <name>Item: Response Type</name>\n" +
                        "        <val>TableMatch</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Item Point\">\n" +
                        "        <name>Item: Item Point</name>\n" +
                        "        <val>1 pt.</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Answer Key (Part II)\">\n" +
                        "        <name>Item: Answer Key (Part II)</name>\n" +
                        "        <val></val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Max Choices\">\n" +
                        "        <name>Item:Max Choices</name>\n" +
                        "        <val></val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Max Choices (Part II)\">\n" +
                        "        <name>Item:Max Choices (Part II)</name>\n" +
                        "        <val></val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "    </attriblist>\n" +
                        "    <tutorial id=\"67859\" bankkey=\"200\" />\n" +
                        "    <resourceslist>\n" +
                        "      <resource type=\"wordList\" id=\"64706\" index=\"1\" bankkey=\"200\" />\n" +
                        "    </resourceslist>\n" +
                        "    <statistic />\n" +
                        "    <MachineRubric filename=\"Item_31336_v14.qrx\" xmlns:its-scripts=\"urn:its-scripts\" />\n" +
                        "    <content language=\"ENU\" version=\"2.0\" xmlns:its-scripts=\"urn:its-scripts\" approvedVersion=\"14\">\n" +
                        "      <qti spec=\"itemBody\"><![CDATA[<matchInteraction responseIdentifier=\"RESPONSE\" minAssociations=\"1\" maxAssociations=\"\"><prompt /><simpleMatchSet><simpleAssociableChoice identifier=\"1\"><p style=\"\"><img id=\"CrossReference0\" src=\"item_31336_v14_item_31336_mml_svg_png__0.png\" /></p></simpleAssociableChoice><simpleAssociableChoice identifier=\"2\"><p style=\"\"><br /><img id=\"CrossReference1\" src=\"item_31336_v14_item_31336_mml_svg_png__1.png\" /></p></simpleAssociableChoice><simpleAssociableChoice identifier=\"3\"><p style=\"\"><br /><img id=\"CrossReference2\" src=\"item_31336_v14_item_31336_mml_svg_png__2.png\" /></p></simpleAssociableChoice></simpleMatchSet><simpleMatchSet><simpleAssociableChoice identifier=\"a\"><p style=\"\"><img id=\"CrossReference3\" src=\"item_31336_v14_item_31336_mml_svg_png__3.png\" /></p></simpleAssociableChoice><simpleAssociableChoice identifier=\"b\"><p style=\"\"><img id=\"CrossReference4\" src=\"item_31336_v14_item_31336_mml_svg_png__4.png\" /></p></simpleAssociableChoice><simpleAssociableChoice identifier=\"c\"><p style=\"\"><img id=\"CrossReference5\" src=\"item_31336_v14_item_31336_mml_svg_png__5.png\" /></p></simpleAssociableChoice></simpleMatchSet></matchInteraction>]]></qti>\n" +
                        "      <stem><![CDATA[<p style=\"\"><span id=\"item_31336_TAG_8\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>Match<span class=\"its-tag\" data-tag-ref=\"item_31336_TAG_8\" data-tag-boundary=\"end\"></span> each recursive function with the equivalent explicit <span id=\"item_31336_TAG_7_BEGIN\">function.</span></p>]]></stem>\n" +
                        "      <rubriclist>\n" +
                        "        <rubric scorepoint=\"\">\n" +
                        "          <name>\n" +
                        "        Rubric </name>\n" +
                        "          <val><![CDATA[<p style=\"\">The student receives full credit by selecting:</p><p style=\"\">&#xA0;</p><ul style=\"padding-left:1.5000em; \"><li><p style=\"\"><img id=\"item_31336_Object1\" style=\"vertical-align:middle;\" src=\"item_31336_v14_Object1_png16malpha.png\" width=\"219\" height=\"18\" />: <img id=\"item_31336_Object2\" style=\"vertical-align:middle;\" src=\"item_31336_v14_Object2_png16malpha.png\" width=\"84\" height=\"18\" /></p><p style=\"\">AND</p></li><li><p style=\"\"><img id=\"item_31336_Object3\" style=\"vertical-align:middle;\" src=\"item_31336_v14_Object3_png16malpha.png\" width=\"219\" height=\"18\" />: <img id=\"item_31336_Object4\" style=\"vertical-align:middle;\" src=\"item_31336_v14_Object4_png16malpha.png\" width=\"104\" height=\"18\" /></p><p style=\"\">AND</p></li><li><p style=\"\"><img id=\"item_31336_Object5\" style=\"vertical-align:middle;\" src=\"item_31336_v14_Object5_png16malpha.png\" width=\"219\" height=\"18\" />: <img id=\"item_31336_Object6\" style=\"vertical-align:middle;\" src=\"item_31336_v14_Object6_png16malpha.png\" width=\"104\" height=\"18\" /></p></li></ul>]]></val>\n" +
                        "        </rubric>\n" +
                        "        <samplelist maxval=\"\" minval=\"\" />\n" +
                        "      </rubriclist>\n" +
                        "      <attachmentlist>\n" +
                        "        <attachment id=\"braillefile1\" type=\"BRF\" subtype=\"TDS_BT_ECN\" file=\"item_31336_enu_brf_ebae_contracted_nemeth_ecn.brf\" />\n" +
                        "        <attachment id=\"braillefile19\" type=\"BRF\" subtype=\"TDS_BT_UCN\" file=\"item_31336_enu_brf_ueb_contracted_nemeth_ucn.brf\" />\n" +
                        "        <attachment id=\"braillefile31\" type=\"BRF\" subtype=\"TDS_BT_UCT\" file=\"item_31336_enu_brf_ueb_contracted_ueb_math_uct.brf\" />\n" +
                        "        <attachment id=\"braillefile3\" type=\"BRF\" subtype=\"TDS_BT_EXN\" file=\"item_31336_enu_brf_ebae_uncontracted_nemeth_exn.brf\" />\n" +
                        "        <attachment id=\"braillefile16\" type=\"BRF\" subtype=\"TDS_BT_UXN\" file=\"item_31336_enu_brf_ueb_uncontracted_nemeth_uxn.brf\" />\n" +
                        "        <attachment id=\"braillefile27\" type=\"BRF\" subtype=\"TDS_BT_UXT\" file=\"item_31336_enu_brf_ueb_uncontracted_ueb_math_uxt.brf\" />\n" +
                        "        <attachment id=\"aslfile1\" type=\"ASL\" subtype=\"STEM\" file=\"item_31336_ASL_STEM.mp4\">\n" +
                        "          <source src=\"item_31336_ASL_STEM.webm\" type=\"video/webm\" />\n" +
                        "          <source src=\"item_31336_ASL_STEM.mp4\" type=\"video/mp4\" />\n" +
                        "        </attachment>\n" +
                        "      </attachmentlist>\n" +
                        "      <apipAccessibility>\n" +
                        "        <accessibilityInfo>\n" +
                        "          <accessElement identifier=\"ae2\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_31336_TAG_7_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>function. The table has three columns and three rows. From left to right the column headings reed; f of n equals 2 n plus 6; f of n equals negative 2 n plus 10; f of n equals negative 3 n plus 12. From top to bottom the row headings reed,  F of 1 equals 8, f of n equals f, of  n minus 1, plus 2, n is greater than or equal to 2.   F of 1 equals 8, F of n equals f, of n minus 1, minus 2, n is greater than or equal to 2.  F of 1 equals 9,  f of n equals f, of n minus 1, minus 3, n is greater than or equal to 2.</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>function.</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae3\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference0\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>UNKNOWN</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>UNKNOWN</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">`,(f (1) .k #8`,)\n" +
                        "`,(f (n) .k f (n)-1+2\n" +
                        "; '\\x200a''\\x200a'n .1: 2`,)\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae4\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference1\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>UNKNOWN</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>UNKNOWN</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">`,(f (1) .k #8`,)\n" +
                        "`,(f (n) .k f (n)-1-2\n" +
                        "; '\\x200a''\\x200a'n .1: 2`,)\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae5\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference2\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>UNKNOWN</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>UNKNOWN</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">`,(f (1) .k #9`,)\n" +
                        "`,(f (n) .k f (n)-1-3\n" +
                        "; '\\x200a''\\x200a'n .1: 2`,)\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae6\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference3\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>f  UNKNOWN  absolute value of n    is equal to  2 n  plus  6</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>f  UNKNOWN  absolute value of n    is equal to  2 n  plus  6</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">f (n) .k #2n+6\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae7\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference4\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>f  UNKNOWN  absolute value of n    is equal to  minus  2 n  plus  10</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>f  UNKNOWN  absolute value of n    is equal to  minus  2 n  plus  10</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">f (n) .k -2n+10\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae8\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference5\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>f  UNKNOWN  absolute value of n    is equal to  minus  3 n  plus  12</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>f  UNKNOWN  absolute value of n    is equal to  minus  3 n  plus  12</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">f (n) .k -3n+12\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae9\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_31336_Object1\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>f  the quantity  1 ,   is equal to  8,  f  the quantity  n  ,   is equal to  f   the quantity  n  minus  1  ,   plus  2  ;  n  is greater than or equal to  2</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>f  the quantity  1 ,   is equal to  8,  f  the quantity  n  ,   is equal to  f   the quantity  n  minus  1  ,   plus  2  ;  n  is greater than or equal to  2</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">f(1) .k #8, f(n) .k f(n-1)+2;n .1: 2\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae10\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_31336_Object2\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>f  the quantity  n  ,   is equal to  2  n  plus  6</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>f  the quantity  n  ,   is equal to  2  n  plus  6</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">f(n) .k #2n+6\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae11\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_31336_Object3\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>f  the quantity  1 ,   is equal to  8,  f  the quantity  n  ,   is equal to  f   the quantity  n  minus  1  ,   minus  2  ;  n  is greater than or equal to  2</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>f  the quantity  1 ,   is equal to  8,  f  the quantity  n  ,   is equal to  f   the quantity  n  minus  1  ,   minus  2  ;  n  is greater than or equal to  2</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">f(1) .k #8, f(n) .k f(n-1)-2;n .1: 2\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae12\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_31336_Object4\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>f  the quantity  n  ,   is equal to  minus  2   n  plus  10</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>f  the quantity  n  ,   is equal to  minus  2   n  plus  10</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">f(n) .k -2n+10\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae13\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_31336_Object5\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>f  the quantity  1 ,   is equal to  9,  f  the quantity  n  ,   is equal to  f   the quantity  n  minus  1  ,   minus  2  ;  n  is greater than or equal to  2</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>f  the quantity  1 ,   is equal to  9,  f  the quantity  n  ,   is equal to  f   the quantity  n  minus  1  ,   minus  2  ;  n  is greater than or equal to  2</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">f(1) .k #9, f(n) .k f(n-1)-2;n .1: 2\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae14\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_31336_Object6\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>f  the quantity  n  ,   is equal to  minus  3   n  plus  12</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>f  the quantity  n  ,   is equal to  minus  3   n  plus  12</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">f(n) .k -3n+12\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "        </accessibilityInfo>\n" +
                        "      </apipAccessibility>\n" +
                        "    </content>\n" +
                        "    <content language=\"ESN\" version=\"2.0\" xmlns:its-scripts=\"urn:its-scripts\" approvedVersion=\"10\">\n" +
                        "      <qti spec=\"itemBody\"><![CDATA[<matchInteraction responseIdentifier=\"RESPONSE\" minAssociations=\"1\" maxAssociations=\"0\"><prompt /><simpleMatchSet><simpleAssociableChoice identifier=\"1\"><p style=\"\"><img id=\"CrossReference0\" src=\"item_31336_v10_item_31336_mml_svg_png__0.png\" /></p></simpleAssociableChoice><simpleAssociableChoice identifier=\"2\"><p style=\"\"><br /><img id=\"CrossReference1\" src=\"item_31336_v10_item_31336_mml_svg_png__1.png\" /></p></simpleAssociableChoice><simpleAssociableChoice identifier=\"3\"><p style=\"\"><br /><img id=\"CrossReference2\" src=\"item_31336_v10_item_31336_mml_svg_png__2.png\" /></p></simpleAssociableChoice></simpleMatchSet><simpleMatchSet><simpleAssociableChoice identifier=\"a\"><p style=\"\"><img id=\"CrossReference3\" src=\"item_31336_v10_item_31336_mml_svg_png__3.png\" /></p></simpleAssociableChoice><simpleAssociableChoice identifier=\"b\"><p style=\"\"><img id=\"CrossReference4\" src=\"item_31336_v10_item_31336_mml_svg_png__4.png\" /></p></simpleAssociableChoice><simpleAssociableChoice identifier=\"c\"><p style=\"\"><img id=\"CrossReference5\" src=\"item_31336_v10_item_31336_mml_svg_png__5.png\" /></p></simpleAssociableChoice></simpleMatchSet></matchInteraction>]]></qti>\n" +
                        "      <stem><![CDATA[<p style=\"\">Haz corresponder cada función recursiva con la función explícita equivalente.</p><p class=\"languagedivider\">&#xA0;</p><p style=\"\"><span id=\"item_31336_TAG_8\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>Match<span class=\"its-tag\" data-tag-ref=\"item_31336_TAG_8\" data-tag-boundary=\"end\"></span> each recursive function with the equivalent explicit <span id=\"item_31336_TAG_7_BEGIN\">function.</span></p>]]></stem>\n" +
                        "      <attachmentlist />\n" +
                        "      <apipAccessibility>\n" +
                        "        <accessibilityInfo>\n" +
                        "          <accessElement identifier=\"ae2\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_31336_TAG_7_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>function. The table has three columns and three rows. From left to right the column headings reed; f of n equals 2 n plus 6; f of n equals negative 2 n plus 10; f of n equals negative 3 n plus 12. From top to bottom the row headings reed,  F of 1 equals 8, f of n equals f, of  n minus 1, plus 2, n is greater than or equal to 2.   F of 1 equals 8, F of n equals f, of n minus 1, minus 2, n is greater than or equal to 2.  F of 1 equals 9,  f of n equals f, of n minus 1, minus 3, n is greater than or equal to 2.</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>function.</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "        </accessibilityInfo>\n" +
                        "      </apipAccessibility>\n" +
                        "    </content>\n" +
                        "  </item>\n" +
                        "</itemrelease>\n"))
                .put("11984", new GitLabItemMetaData("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>\n" +
                        "<metadata>\n" +
                        "  <smarterAppMetadata xmlns=\"http://www.smarterapp.org/ns/1/assessment_item_metadata\">\n" +
                        "    <Identifier>11984</Identifier>\n" +
                        "    <SecurityStatus>Secure</SecurityStatus>\n" +
                        "    <SmarterAppItemDescriptor>MATH.11.1.A-CED.1G</SmarterAppItemDescriptor>\n" +
                        "    <StimulusFormat>Standard</StimulusFormat>\n" +
                        "    <Subject>MATH</Subject>\n" +
                        "    <Version>15</Version>\n" +
                        "    <ItemAuthorIdentifier>Sridhar_Ravva</ItemAuthorIdentifier>\n" +
                        "    <ItemSpecFormat>SmarterApp</ItemSpecFormat>\n" +
                        "    <LastModifiedBy>Sridhar_Ravva</LastModifiedBy>\n" +
                        "    <IntendedGrade>11</IntendedGrade>\n" +
                        "    <MinimumGrade>8</MinimumGrade>\n" +
                        "    <MaximumGrade>11</MaximumGrade>\n" +
                        "    <MathematicalPractice>None</MathematicalPractice>\n" +
                        "    <DepthOfKnowledge>2</DepthOfKnowledge>\n" +
                        "    <AchievementQuintile>2</AchievementQuintile>\n" +
                        "    <AllowCalculator>Y</AllowCalculator>\n" +
                        "    <InteractionType>EQ</InteractionType>\n" +
                        "    <MaximumNumberOfPoints>1</MaximumNumberOfPoints>\n" +
                        "    <ScorePoints>\"0, 1\"</ScorePoints>\n" +
                        "    <ScoringEngine>Automatic with Machine Rubric</ScoringEngine>\n" +
                        "    <PresentationFormat>Text</PresentationFormat>\n" +
                        "    <AdministrationDate>Field Test</AdministrationDate>\n" +
                        "    <ContentTaskModel>TM1b_Det</ContentTaskModel>\n" +
                        "    <AlgebraFunctionDescriptor>Linear</AlgebraFunctionDescriptor>\n" +
                        "    <BrailleType>BRF_EBAE_UEB</BrailleType>\n" +
                        "    <AccessibilityTagsASLLanguage>Y</AccessibilityTagsASLLanguage>\n" +
                        "    <IrtDimension>\n" +
                        "      <IrtStatDomain>Online</IrtStatDomain>\n" +
                        "      <IrtModelType>IRT3PLN</IrtModelType>\n" +
                        "      <IrtDimensionPurpose></IrtDimensionPurpose>\n" +
                        "      <IrtScore>1</IrtScore>\n" +
                        "      <IrtWeight>1</IrtWeight>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>a</Name>\n" +
                        "        <Value>0.74903</Value>\n" +
                        "      </IrtParameter>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>b</Name>\n" +
                        "        <Value>1.83847</Value>\n" +
                        "      </IrtParameter>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>c</Name>\n" +
                        "        <Value>0</Value>\n" +
                        "      </IrtParameter>\n" +
                        "    </IrtDimension>\n" +
                        "    <Status>Operational</Status>\n" +
                        "    <StandardPublication>\n" +
                        "      <Publication>SBAC-MA-v4</Publication>\n" +
                        "      <PrimaryStandard>SBAC-MA-v4:1|A-CED|G|a/s|A-CED.1</PrimaryStandard>\n" +
                        "    </StandardPublication>\n" +
                        "    <StandardPublication>\n" +
                        "      <Publication>SBAC-MA-v6</Publication>\n" +
                        "      <PrimaryStandard>SBAC-MA-v6:1|P|TS03|G</PrimaryStandard>\n" +
                        "    </StandardPublication>\n" +
                        "    <AssociatedTutorial>67863</AssociatedTutorial>\n" +
                        "    <AssociatedWordlist>55204</AssociatedWordlist>\n" +
                        "    <Language>eng</Language>\n" +
                        "    <Language>spa</Language>\n" +
                        "  </smarterAppMetadata>\n" +
                        "</metadata>\n", "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<itemrelease version=\"2.0\">\n" +
                        "  <item format=\"eq\" id=\"11984\" version=\"15\" bankkey=\"200\">\n" +
                        "    <attriblist>\n" +
                        "      <attrib attid=\"itm_item_id\">\n" +
                        "        <name>Item: ITS ID</name>\n" +
                        "        <val>11984</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_item_subject\">\n" +
                        "        <name>Item: Subject</name>\n" +
                        "        <val>MATH</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_item_desc\">\n" +
                        "        <name>Item: Item Description</name>\n" +
                        "        <val>MATH.11.1.A-CED.1G</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_FTUse\">\n" +
                        "        <name>Fieldtest Use</name>\n" +
                        "        <val>Platform::MG11::12.3 (585); Platform Math::March2014::GR11::ENUASL (20); SBAC-Int-PR1-FM1-Math-11 (10); SBAC-Int-PR1-FM1-Math-11-SPA (10);</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_OPUse\">\n" +
                        "        <name>Operational Use</name>\n" +
                        "        <val>CAT::MG8::UPCALC-S4-B::SP14 (12); CAT::MG11::ONCalc-S1-D::SP14 (457); CAT::MG11::ONONCalc-S1-A1::SP14 (79); FAKE MATH FORM (3913); CAT::MG11::ONCalc-S1-A2::SP14 (79); CAT::MG11::ONCalc-S1-A4::SP14 (79); CAT::MG10::ONCalc-S1-A4::SP14 (79); CAT::MG11::ONCalc-S1-A3::SP14 (79); CAT::MG11::ONCalc-S4-A3::SP14 (79); CAT::MG8::UPCALC-S1-B::SP14 (12); CAT::MG11::CA-ONCalc::SP14 (79); CAT::MG10::ONCalc-S1-A4::SP14-ESN (78); CAT::MG11::ONONCalc-S1-A1::SP14-ESN (78); CAT::MG11::ONCalc-S1-D::SP14-ESN (78); CAT::MG11::ONCalc-S4-A3::SP14-ESN (78); CAT::MG11::ONCalc-S1-A2::SP14-ESN (78); CAT::MG11::ONCalc-S1-A3::SP14-ESN (78); CAT::MG8::UPCALC-S1-B::SP14-ESN (78); CAT::MG8::UPCALC-S4-B::SP14-ESN (78); CAT::MG11::CA-ONCalc::SP14-ESN (78); CAT::MATH910::VL11NoCALC-S2-C::SP14 (12); CAT::MATH910::VL11NoCALC-S2-C::SP14-ESN (78); CAT::MATH910::VL11NoCALC-S3-C::SP14 (12); CAT::MATH910::VL11NoCALC-S3-C::SP14-ESN (78); CAT::MG11::CA-ONCalc::D::SP14 (457); CAT::MG11::CA-ONCalc::D::SP14-ESN (78); CAT::MG11::CA-ONCalc::D (457); Math ICA G11 Calc 2015 ENG (24); Math ICA G11 Calc 2015 BRL (24); Math ICA G11 Calc 2015 SPA (24); Math ICA G11 Calc COMBINED 2015 ENG (24); Math ICA G11 Calc COMBINED 2015 BRL (24); Math ICA G11 Calc COMBINED 2015 SPA (24); IAB-G11M-AlgLinearFun-Calc-2015 ENG (12); IAB-G11M-AlgLinearFun-Calc-2015 BRL (12); IAB-G11M-AlgLinearFun-Calc-2015 SPA (12); IAB-G11M-AlgLinearFun-Calc-2015 ENG-COMBINED (12); IAB-G11M-AlgLinearFun-Calc-2015 BRL-COMBINED (12); IAB-G11M-AlgLinearFun-Calc-2015 SPA-COMBINED (12); Math ICA G11 Calc 2017 ENG (23); Math ICA G11 Calc 2017 BRL (23); Math ICA G11 Calc 2017 SPA (23); IAB-G11M-AlgLin-Calc-2017 ENG (10); IAB-G11M-AlgLin-Calc-2017 BRL (10); IAB-G11M-AlgLin-Calc-2017 SPA (10); Math ICA G11 Calc 2017 ENG COMBINED (23); Math ICA G11 Calc 2017 BRL COMBINED (23); Math ICA G11 Calc 2017 SPA COMBINED (23); IAB-G11M-AlgLin-Calc-2017 ENG COMBINED (10); IAB-G11M-AlgLin-Calc-2017 BRL COMBINED (10); IAB-G11M-AlgLin-Calc-2017 SPA COMBINED (10); Math ICA G11 Calc 2018 ENG (23); Math ICA G11 Calc 2018 BRL (23); Math ICA G11 Calc 2018 SPA (23); IAB-G11M-AlgLin-Calc-2018 ENG (10); IAB-G11M-AlgLin-Calc-2018 BRL (10); IAB-G11M-AlgLin-Calc-2018 SPA (10); Math ICA G11 Calc 2018 ENG COMBINED (23); Math ICA G11 Calc 2018 BRL COMBINED (23); Math ICA G11 Calc 2018 SPA COMBINED (23); IAB-G11M-AlgLin-Calc-2018 ENG COMBINED (10); IAB-G11M-AlgLin-Calc-2018 BRL COMBINED (10); IAB-G11M-AlgLin-Calc-2018 SPA COMBINED (10); HI Math ICA G11 Calc 2018 ENG (22); HI Math ICA G11 Calc 2018 BRL (22); HI Math ICA G11 Calc 2018 SPA (22); IAB-G11M-AlgLin-Calc-2019 ENG (10); IAB-G11M-AlgLin-Calc-2019 BRL (10); IAB-G11M-AlgLin-Calc-2019 SPA (10); Math ICA G11 Calc 2018 ENG_copy1 (23); Math ICA G11 Calc 2018 BRL_copy1 (23); Math ICA G11 Calc 2018 SPA_copy1 (23);</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Answer Key\">\n" +
                        "        <name>Item: Answer Key</name>\n" +
                        "        <val>EQ</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Grade\">\n" +
                        "        <name>Item: Grade</name>\n" +
                        "        <val>11</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Item Format\">\n" +
                        "        <name>Item: Item Format</name>\n" +
                        "        <val>EQ</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Page Layout\">\n" +
                        "        <name>Item: Page Layout</name>\n" +
                        "        <val>8</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Response Type\">\n" +
                        "        <name>Item: Response Type</name>\n" +
                        "        <val>EquationEditor</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Item Point\">\n" +
                        "        <name>Item: Item Point</name>\n" +
                        "        <val>1 pt.</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Answer Key (Part II)\">\n" +
                        "        <name>Item: Answer Key (Part II)</name>\n" +
                        "        <val></val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Max Choices\">\n" +
                        "        <name>Item:Max Choices</name>\n" +
                        "        <val></val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Max Choices (Part II)\">\n" +
                        "        <name>Item:Max Choices (Part II)</name>\n" +
                        "        <val></val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "    </attriblist>\n" +
                        "    <tutorial id=\"67863\" bankkey=\"200\" />\n" +
                        "    <resourceslist>\n" +
                        "      <resource type=\"wordList\" id=\"55204\" index=\"1\" bankkey=\"200\" />\n" +
                        "    </resourceslist>\n" +
                        "    <statistic />\n" +
                        "    <MachineRubric filename=\"Item_11984_v15.qrx\" />\n" +
                        "    <RendererSpec filename=\"Item_11984_v15.eax\" />\n" +
                        "    <content language=\"ENU\" version=\"2.0\" approvedVersion=\"15\">\n" +
                        "      <rationaleoptlist />\n" +
                        "      <stem><![CDATA[<p style=\"\">Two types of <span id=\"item_11984_TAG_9\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"3\"></span>memberships<span class=\"its-tag\" data-tag-ref=\"item_11984_TAG_9\" data-tag-boundary=\"end\"></span> are available for a water <span id=\"item_11984_TAG_6_BEGIN\">park:</span></p><p style=\"\">&#xA0;</p><ul style=\"padding-left:1.5000em; \"><li><p style=\"\">an unlimited use <span id=\"item_11984_TAG_11\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>membership<span class=\"its-tag\" data-tag-ref=\"item_11984_TAG_11\" data-tag-boundary=\"end\"></span> for <span id=\"item_11984_TAG_2_BEGIN\">$70</span> per month, <span id=\"item_11984_TAG_7_BEGIN\">or</span></p></li><li><p style=\"\">a monthly <span id=\"item_11984_TAG_3_BEGIN\">$10</span> fee plus <span id=\"item_11984_TAG_4_BEGIN\">$5.00</span> per visit.</p></li></ul><p style=\"\">&#xA0;</p><p style=\"\"><span id=\"item_11984_TAG_10\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>Enter<span class=\"its-tag\" data-tag-ref=\"item_11984_TAG_10\" data-tag-boundary=\"end\"></span> an equation that can be used to find the number of visits <span id=\"item_11984_TAG_8_BEGIN\">(<span style=\"font-style:italic; \">v</span>)</span> per month needed for the two <span id=\"item_11984_TAG_12\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>membership<span class=\"its-tag\" data-tag-ref=\"item_11984_TAG_12\" data-tag-boundary=\"end\"></span> types to cost the same <span id=\"item_11984_TAG_5_BEGIN\">amount.</span></p>]]></stem>\n" +
                        "      <rubriclist>\n" +
                        "        <rubric scorepoint=\"\">\n" +
                        "          <name>\n" +
                        "        Rubric </name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p><p style=\"\">Exemplar:</p><p style=\"\">&#xA0;</p><ul style=\"padding-left:1.5000em; \"><li><p style=\"\"><img id=\"item_11984_Object1\" style=\"vertical-align:middle;\" src=\"item_11984_v15_Object1_png16malpha.png\" width=\"87\" height=\"13\" /> or equivalent</p></li></ul><p style=\"\">&#xA0;</p><p style=\"\">For this item, a full-credit response includes</p><p style=\"\">&#xA0;</p><ul style=\"padding-left:1.5000em; \"><li><p style=\"\">The student enters the correct equation (1 point) </p></li></ul><ul style=\"padding-left:1.5000em; \"><li><p style=\"\">&#xA0;</p></li></ul><p style=\"\">&#xA0;</p><p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rubric>\n" +
                        "        <samplelist maxval=\"\" minval=\"\" />\n" +
                        "      </rubriclist>\n" +
                        "      <attachmentlist>\n" +
                        "        <attachment id=\"braillefile1\" type=\"BRF\" subtype=\"TDS_BT_ECN\" file=\"item_11984_enu_brf_ebae_contracted_nemeth_ecn.brf\" />\n" +
                        "        <attachment id=\"braillefile19\" type=\"BRF\" subtype=\"TDS_BT_UCN\" file=\"item_11984_enu_brf_ueb_contracted_nemeth_ucn.brf\" />\n" +
                        "        <attachment id=\"braillefile31\" type=\"BRF\" subtype=\"TDS_BT_UCT\" file=\"item_11984_enu_brf_ueb_contracted_ueb_math_uct.brf\" />\n" +
                        "        <attachment id=\"braillefile3\" type=\"BRF\" subtype=\"TDS_BT_EXN\" file=\"item_11984_enu_brf_ebae_uncontracted_nemeth_exn.brf\" />\n" +
                        "        <attachment id=\"braillefile16\" type=\"BRF\" subtype=\"TDS_BT_UXN\" file=\"item_11984_enu_brf_ueb_uncontracted_nemeth_uxn.brf\" />\n" +
                        "        <attachment id=\"braillefile27\" type=\"BRF\" subtype=\"TDS_BT_UXT\" file=\"item_11984_enu_brf_ueb_uncontracted_ueb_math_uxt.brf\" />\n" +
                        "        <attachment id=\"aslfile1\" type=\"ASL\" subtype=\"STEM\" file=\"item_11984_ASL_STEM.mp4\">\n" +
                        "          <source src=\"item_11984_ASL_STEM.webm\" type=\"video/webm\" />\n" +
                        "          <source src=\"item_11984_ASL_STEM.mp4\" type=\"video/mp4\" />\n" +
                        "        </attachment>\n" +
                        "      </attachmentlist>\n" +
                        "      <apipAccessibility>\n" +
                        "        <accessibilityInfo>\n" +
                        "          <accessElement identifier=\"ae2\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_11984_TAG_6_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>park;</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>park:</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae4\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_11984_TAG_2_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>70 dollars</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>$70</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae5\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_11984_TAG_7_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>or,</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>or</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae6\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_11984_TAG_3_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>10 dollar</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>$10</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae7\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_11984_TAG_4_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>5 dollars and 0 cents</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>$5.00</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae9\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_11984_TAG_8_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>, v,</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>(v)</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae11\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_11984_TAG_5_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>amount.  The equation tool has 2 sections.  In the left section, from left to right and top to bottom, the equation tool reeds, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, point, negative.  In the right section, mathematical functions are shown.</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>amount.</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae12\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_11984_Object1\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>70 is equal to  10 plus  5   v</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>70 is equal to  10 plus  5   v</brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">#70 .k #10+5v\n" +
                        "</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "        </accessibilityInfo>\n" +
                        "      </apipAccessibility>\n" +
                        "    </content>\n" +
                        "    <content language=\"ESN\" version=\"2.0\" approvedVersion=\"12\">\n" +
                        "      <stem><![CDATA[<p style=\"\">Hay dos tipos de membresía disponibles para un parque acuático:</p><p style=\"\">&#xA0;</p><ul style=\"padding-left:1.5000em; \"><li><p style=\"\">una membresía de uso ilimitado por $70 al mes o</p></li><li><p style=\"\">una cuota mensual de $10 más $5.00 por visita.</p></li></ul><p style=\"\">&#xA0;</p><p style=\"\">Escribe una ecuación que se puede usar para encontrar el número de visitas (<span style=\"font-style:italic; \">v</span>) necesarias por mes para que los dos tipos de membresías cuesten la misma cantidad.</p><p class=\"languagedivider\">&#xA0;</p><p style=\"\">Two types of <span id=\"item_11984_TAG_9\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"3\"></span>memberships<span class=\"its-tag\" data-tag-ref=\"item_11984_TAG_9\" data-tag-boundary=\"end\"></span> are available for a water <span id=\"item_11984_TAG_6_BEGIN\">park:</span></p><p style=\"\">&#xA0;</p><ul style=\"padding-left:1.5000em; \"><li><p style=\"\">an unlimited use membership for <span id=\"item_11984_TAG_2_BEGIN\">$70</span> per month, <span id=\"item_11984_TAG_7_BEGIN\">or</span></p></li><li><p style=\"\">a monthly <span id=\"item_11984_TAG_3_BEGIN\">$10</span> fee plus <span id=\"item_11984_TAG_4_BEGIN\">$5.00</span> per visit.</p></li></ul><p style=\"\">&#xA0;</p><p style=\"\"><span id=\"item_11984_TAG_10\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>Enter<span class=\"its-tag\" data-tag-ref=\"item_11984_TAG_10\" data-tag-boundary=\"end\"></span> an equation that can be used to find the number of visits <span id=\"item_11984_TAG_8_BEGIN\">(<span style=\"font-style:italic; \">v</span>)</span> per month needed for the two membership types to cost the same <span id=\"item_11984_TAG_5_BEGIN\">amount.</span></p>]]></stem>\n" +
                        "      <rubriclist>\n" +
                        "        <rubric scorepoint=\"_Spanish\">\n" +
                        "          <name>\n" +
                        "        Rubric _Spanish</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rubric>\n" +
                        "        <samplelist maxval=\"_Spanish\" minval=\"_Spanish\" />\n" +
                        "      </rubriclist>\n" +
                        "      <attachmentlist />\n" +
                        "      <apipAccessibility>\n" +
                        "        <accessibilityInfo>\n" +
                        "          <accessElement identifier=\"ae2\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_11984_TAG_6_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>park;</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>park:</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae3\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_11984_TAG_2_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>70 dollars</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>$70</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae4\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_11984_TAG_7_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>or,</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>or</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae5\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_11984_TAG_3_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>10 dollar</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>$10</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae6\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_11984_TAG_4_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>5 dollars and 0 cents</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>$5.00</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae8\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_11984_TAG_8_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>, v,</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>(v)</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae9\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_11984_TAG_5_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>amount.  The equation tool has 2 sections.  In the left section, from left to right and top to bottom, the equation tool reeds, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, point, negative.  In the right section, mathematical functions are shown.</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>amount.</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "        </accessibilityInfo>\n" +
                        "      </apipAccessibility>\n" +
                        "    </content>\n" +
                        "  </item>\n" +
                        "</itemrelease>\n"))
                .put("31344", new GitLabItemMetaData("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>\n" +
                        "<metadata>\n" +
                        "  <smarterAppMetadata xmlns=\"http://www.smarterapp.org/ns/1/assessment_item_metadata\">\n" +
                        "    <Identifier>31344</Identifier>\n" +
                        "    <ItemAuthorIdentifier>Sridhar_Ravva</ItemAuthorIdentifier>\n" +
                        "    <ItemSpecFormat>SmarterApp</ItemSpecFormat>\n" +
                        "    <LastModifiedBy>Sridhar_Ravva</LastModifiedBy>\n" +
                        "    <SecurityStatus>Secure</SecurityStatus>\n" +
                        "    <SmarterAppItemDescriptor>86579</SmarterAppItemDescriptor>\n" +
                        "    <StimulusFormat>Standard</StimulusFormat>\n" +
                        "    <Subject>MATH</Subject>\n" +
                        "    <Version>4</Version>\n" +
                        "    <IntendedGrade>11</IntendedGrade>\n" +
                        "    <MinimumGrade>8</MinimumGrade>\n" +
                        "    <MaximumGrade>11</MaximumGrade>\n" +
                        "    <MathematicalPractice>None</MathematicalPractice>\n" +
                        "    <DepthOfKnowledge>2</DepthOfKnowledge>\n" +
                        "    <AchievementQuintile>1</AchievementQuintile>\n" +
                        "    <AllowCalculator>Y</AllowCalculator>\n" +
                        "    <InteractionType>MC</InteractionType>\n" +
                        "    <MaximumNumberOfPoints>1</MaximumNumberOfPoints>\n" +
                        "    <ScorePoints>\"0, 1\"</ScorePoints>\n" +
                        "    <ScoringEngine>Automatic with Key</ScoringEngine>\n" +
                        "    <PresentationFormat>Text With Graphics</PresentationFormat>\n" +
                        "    <AdministrationDate>Field Test</AdministrationDate>\n" +
                        "    <ContentTaskModel>TM1a_Rpdv</ContentTaskModel>\n" +
                        "    <AlgebraFunctionDescriptor>Linear</AlgebraFunctionDescriptor>\n" +
                        "    <BrailleType>PRN_EBAE_UEB</BrailleType>\n" +
                        "    <EnemyItem>0</EnemyItem>\n" +
                        "    <CopyrightAndOtherRestrictions>Not Set</CopyrightAndOtherRestrictions>\n" +
                        "    <StimulusScource></StimulusScource>\n" +
                        "    <Notes></Notes>\n" +
                        "    <PerformanceTaskComponentItem>N</PerformanceTaskComponentItem>\n" +
                        "    <PtClassroomActivity></PtClassroomActivity>\n" +
                        "    <PtEnemy>0</PtEnemy>\n" +
                        "    <AccessibilityTagsASLLanguage>Y</AccessibilityTagsASLLanguage>\n" +
                        "    <IrtDimension>\n" +
                        "      <IrtStatDomain>Online</IrtStatDomain>\n" +
                        "      <IrtModelType>IRT3PLN</IrtModelType>\n" +
                        "      <IrtDimensionPurpose></IrtDimensionPurpose>\n" +
                        "      <IrtScore>1</IrtScore>\n" +
                        "      <IrtWeight>1</IrtWeight>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>a</Name>\n" +
                        "        <Value>0.64248</Value>\n" +
                        "      </IrtParameter>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>b</Name>\n" +
                        "        <Value>0.79542</Value>\n" +
                        "      </IrtParameter>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>c</Name>\n" +
                        "        <Value>0</Value>\n" +
                        "      </IrtParameter>\n" +
                        "    </IrtDimension>\n" +
                        "    <Status>Operational</Status>\n" +
                        "    <StandardPublication>\n" +
                        "      <Publication>SBAC-MA-v4</Publication>\n" +
                        "      <PrimaryStandard>SBAC-MA-v4:1|A-REI|J|m|A-REI.10</PrimaryStandard>\n" +
                        "    </StandardPublication>\n" +
                        "    <StandardPublication>\n" +
                        "      <Publication>SBAC-MA-v6</Publication>\n" +
                        "      <PrimaryStandard>SBAC-MA-v6:1|P|TS04|J</PrimaryStandard>\n" +
                        "    </StandardPublication>\n" +
                        "    <AssociatedTutorial>67708</AssociatedTutorial>\n" +
                        "    <AssociatedWordlist>64707</AssociatedWordlist>\n" +
                        "    <Language>eng</Language>\n" +
                        "    <Language>spa</Language>\n" +
                        "  </smarterAppMetadata>\n" +
                        "</metadata>\n", "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<itemrelease version=\"2.0\">\n" +
                        "  <item format=\"mc\" id=\"31344\" version=\"4\" bankkey=\"200\">\n" +
                        "    <attriblist>\n" +
                        "      <attrib attid=\"itm_item_id\">\n" +
                        "        <name>Item: ITS ID</name>\n" +
                        "        <val>31344</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_item_subject\">\n" +
                        "        <name>Item: Subject</name>\n" +
                        "        <val>MATH</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_item_desc\">\n" +
                        "        <name>Item: Item Description</name>\n" +
                        "        <val>86579</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_FTUse\">\n" +
                        "        <name>Fieldtest Use</name>\n" +
                        "        <val>Platform::MG11::1.7B (808); SBAC-Int-PR1-FM1-Math-11 (11); SBAC-Int-PR1-FM1-Math-11-SPA (11);</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_OPUse\">\n" +
                        "        <name>Operational Use</name>\n" +
                        "        <val>CAT::MG11::ONCalc-S1-D::SP14 (1406); CAT::MG11::ONONCalc-S1-A1::SP14 (284); FAKE MATH FORM (7343); CAT::MG11::ONCalc-S1-A2::SP14 (284); CAT::MG11::ONCalc-S1-A4::SP14 (284); CAT::MG10::ONCalc-S1-A4::SP14 (284); CAT::MG11::ONCalc-S1-A3::SP14 (284); CAT::MG11::ONCalc-S4-A3::SP14 (284); CAT::MG11::CA-ONCalc::SP14 (284); CAT::MG10::ONCalc-S1-A4::SP14-ESN (282); CAT::MG11::ONONCalc-S1-A1::SP14-ESN (282); CAT::MG11::ONCalc-S1-D::SP14-ESN (282); CAT::MG11::ONCalc-S4-A3::SP14-ESN (282); CAT::MG11::ONCalc-S1-A2::SP14-ESN (282); CAT::MG11::ONCalc-S1-A3::SP14-ESN (282); CAT::MG8::UPCALC-S1-B::SP14-ESN (282); CAT::MG8::UPCALC-S4-B::SP14-ESN (282); CAT::MG11::CA-ONCalc::SP14-ESN (282); CAT::MATH910::VL11NoCALC-S2-C::SP14-ESN (282); CAT::MATH910::VL11NoCALC-S3-C::SP14-ESN (282); CAT::MG11::CA-ONCalc::D::SP14 (1406); CAT::MG11::CA-ONCalc::D::SP14-ESN (282); CAT::MG11::CA-ONCalc::D (1406); IAB-G11M-AlgLin-Calc-2017 ENG (11); IAB-G11M-AlgLin-Calc-2017 BRL (11); IAB-G11M-AlgLin-Calc-2017 SPA (11); IAB-G11M-AlgLin-Calc-2017 ENG COMBINED (11); IAB-G11M-AlgLin-Calc-2017 BRL COMBINED (11); IAB-G11M-AlgLin-Calc-2017 SPA COMBINED (11); IAB-G11M-AlgLin-Calc-2018 ENG (11); IAB-G11M-AlgLin-Calc-2018 BRL (11); IAB-G11M-AlgLin-Calc-2018 SPA (11); IAB-G11M-AlgLin-Calc-2018 ENG COMBINED (11); IAB-G11M-AlgLin-Calc-2018 BRL COMBINED (11); IAB-G11M-AlgLin-Calc-2018 SPA COMBINED (11); IAB-G11M-AlgLin-Calc-2019 ENG (11); IAB-G11M-AlgLin-Calc-2019 BRL (11); IAB-G11M-AlgLin-Calc-2019 SPA (11);</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Answer Key\">\n" +
                        "        <name>Item: Answer Key</name>\n" +
                        "        <val>B</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Grade\">\n" +
                        "        <name>Item: Grade</name>\n" +
                        "        <val>11</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Item Format\">\n" +
                        "        <name>Item: Item Format</name>\n" +
                        "        <val>MC</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Page Layout\">\n" +
                        "        <name>Item: Page Layout</name>\n" +
                        "        <val>8</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Response Type\">\n" +
                        "        <name>Item: Response Type</name>\n" +
                        "        <val>Vertical</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Item Point\">\n" +
                        "        <name>Item: Item Point</name>\n" +
                        "        <val>1 pt.</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Answer Key (Part II)\">\n" +
                        "        <name>Item: Answer Key (Part II)</name>\n" +
                        "        <val>NA</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Max Choices\">\n" +
                        "        <name>Item:Max Choices</name>\n" +
                        "        <val>NA</val>\n" +
                        "        <desc>NA</desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Max Choices (Part II)\">\n" +
                        "        <name>Item:Max Choices (Part II)</name>\n" +
                        "        <val></val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "    </attriblist>\n" +
                        "    <tutorial id=\"67708\" bankkey=\"200\" />\n" +
                        "    <resourceslist>\n" +
                        "      <resource type=\"wordList\" id=\"64707\" index=\"1\" bankkey=\"200\" />\n" +
                        "    </resourceslist>\n" +
                        "    <statistic />\n" +
                        "    <content language=\"ENU\" version=\"2.0\" approvedVersion=\"4\">\n" +
                        "      <concept>\n" +
                        "        <name>What Knowledge Do Students Need to Understand This Concept?</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </concept>\n" +
                        "      <es>\n" +
                        "        <name>Explanation of Correct Answer</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </es>\n" +
                        "      <himi>\n" +
                        "        <name>Explanation of Correct Answer</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </himi>\n" +
                        "      <rationaleoptlist>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option A</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option B</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option C</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option D</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "      </rationaleoptlist>\n" +
                        "      <stem><![CDATA[<p style=\"\"><span id=\"item_31344_TAG_6\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>Select<span class=\"its-tag\" data-tag-ref=\"item_31344_TAG_6\" data-tag-boundary=\"end\"></span> the ordered pair that is a solution to the equation represented by the graph.</p><p style=\"\"><br /><img id=\"item_31344_graphics1\" src=\"item_31344_v4_graphics1_png256.png\" width=\"259\" height=\"264\" style=\"vertical-align:baseline;\" /></p>]]></stem>\n" +
                        "      <optionlist>\n" +
                        "        <option>\n" +
                        "          <name>Option A</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"CrossReference0\" src=\"item_31344_v4_item_31344_mml_svg_png__0.png\"/></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">The student confuses the value for <span style=\"font-style:italic; \">y</span>.</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option B</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"CrossReference1\" src=\"item_31344_v4_item_31344_mml_svg_png__1.png\"/></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">Key</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option C</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"CrossReference2\" src=\"item_31344_v4_item_31344_mml_svg_png__2.png\"/></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">The student combines the intercepts to create an ordered pair.</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option D</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"CrossReference3\" src=\"item_31344_v4_item_31344_mml_svg_png__3.png\"/></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">The student mixes up the <span style=\"font-style:italic; \">x </span>and <span style=\"font-style:italic; \">y</span> coordinates.</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "      </optionlist>\n" +
                        "      <attachmentlist>\n" +
                        "        <attachment id=\"braillefile2\" type=\"PRN\" subtype=\"TDS_BT_ECN\" file=\"item_31344_enu_prn_ebae_contracted_nemeth_ecn.prn\" />\n" +
                        "        <attachment id=\"braillefile21\" type=\"PRN\" subtype=\"TDS_BT_UCN\" file=\"item_31344_enu_prn_ueb_contracted_nemeth_ucn.prn\" />\n" +
                        "        <attachment id=\"braillefile32\" type=\"PRN\" subtype=\"TDS_BT_UCT\" file=\"item_31344_enu_prn_ueb_contracted_ueb_math_uct.prn\" />\n" +
                        "        <attachment id=\"braillefile4\" type=\"PRN\" subtype=\"TDS_BT_EXN\" file=\"item_31344_enu_prn_ebae_uncontracted_nemeth_exn.prn\" />\n" +
                        "        <attachment id=\"braillefile18\" type=\"PRN\" subtype=\"TDS_BT_UXN\" file=\"item_31344_enu_prn_ueb_uncontracted_nemeth_uxn.prn\" />\n" +
                        "        <attachment id=\"braillefile28\" type=\"PRN\" subtype=\"TDS_BT_UXT\" file=\"item_31344_enu_prn_ueb_uncontracted_ueb_math_uxt.prn\" />\n" +
                        "        <attachment id=\"aslfile1\" type=\"ASL\" subtype=\"STEM\" file=\"item_31344_ASL_STEM.mp4\">\n" +
                        "          <source src=\"item_31344_ASL_STEM.webm\" type=\"video/webm\" />\n" +
                        "          <source src=\"item_31344_ASL_STEM.mp4\" type=\"video/mp4\" />\n" +
                        "        </attachment>\n" +
                        "      </attachmentlist>\n" +
                        "      <apipAccessibility>\n" +
                        "        <accessibilityInfo>\n" +
                        "          <accessElement identifier=\"ae2\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_31344_graphics1\" type=\"Graphic\" subtype=\"Generic\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>The x axis has a range from negative 8 to 8, increasing in increments of 2. the why axis has a range from negative 8 to 8, increasing in increments of 2.</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText />\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae3\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference0\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>Negative 4 comma 4;</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">(-)4,4</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae4\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference1\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>Negative 2 comma 0;</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">(-)2,0</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae5\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference2\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>Negative 2 comma 4;</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">(-)2,4</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae6\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference3\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>Four comma 0</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">(4),0</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "        </accessibilityInfo>\n" +
                        "      </apipAccessibility>\n" +
                        "    </content>\n" +
                        "    <content language=\"ESN\" version=\"2.0\" approvedVersion=\"4\">\n" +
                        "      <concept>\n" +
                        "        <name>What Knowledge Do Students Need to Understand This Concept?</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </concept>\n" +
                        "      <es>\n" +
                        "        <name>Explanation of Correct Answer</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </es>\n" +
                        "      <himi>\n" +
                        "        <name>Explanation of Correct Answer</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </himi>\n" +
                        "      <rationaleoptlist>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option A</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option B</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option C</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option D</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "      </rationaleoptlist>\n" +
                        "      <stem><![CDATA[<p style=\"\">Selecciona el par ordenado que sea una solución de la ecuación representada en la gráfica.</p><p style=\"\"><br /><img id=\"item_31344_graphics2\" src=\"item_31344_v4_graphics2_png256.png\" width=\"259\" height=\"264\" style=\"vertical-align:baseline;\" /></p><p class=\"languagedivider\">&#xA0;</p><p style=\"\"><span id=\"item_31344_TAG_6\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>Select<span class=\"its-tag\" data-tag-ref=\"item_31344_TAG_6\" data-tag-boundary=\"end\"></span> the ordered pair that is a solution to the equation represented by the graph.</p><p style=\"\"><br /><img id=\"item_31344_graphics1\" src=\"item_31344_v4_graphics1_png256.png\" width=\"259\" height=\"264\" style=\"vertical-align:baseline;\" /></p>]]></stem>\n" +
                        "      <optionlist>\n" +
                        "        <option>\n" +
                        "          <name>Option A</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"CrossReference0\" src=\"item_31344_v4_item_31344_mml_svg_png__0.png\"/></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option B</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"CrossReference1\" src=\"item_31344_v4_item_31344_mml_svg_png__1.png\"/></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option C</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"CrossReference2\" src=\"item_31344_v4_item_31344_mml_svg_png__2.png\"/></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option D</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"CrossReference3\" src=\"item_31344_v4_item_31344_mml_svg_png__3.png\"/></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "      </optionlist>\n" +
                        "      <attachmentlist>\n" +
                        "        <attachment id=\"aslfile1\" type=\"ASL\" subtype=\"STEM\" file=\"item_31344_ASL_STEM.mp4\" />\n" +
                        "      </attachmentlist>\n" +
                        "      <apipAccessibility>\n" +
                        "        <accessibilityInfo>\n" +
                        "          <accessElement identifier=\"ae2\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_31344_graphics1\" type=\"Graphic\" subtype=\"Generic\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>The x axis has a range from negative 8 to 8, increasing in increments of 2. the why axis has a range from negative 8 to 8, increasing in increments of 2.</audioShortDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText />\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae3\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference0\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>Negative 4 comma 4;</audioShortDesc>\n" +
                        "                <audioLongDesc />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">(-)4,4</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae4\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference1\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>Negative 2 comma 0;</audioShortDesc>\n" +
                        "                <audioLongDesc />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">(-)2,0</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae5\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference2\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>Negative 2 comma 4;</audioShortDesc>\n" +
                        "                <audioLongDesc />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">(-)2,4</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae6\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference3\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>Four comma 0</audioShortDesc>\n" +
                        "                <audioLongDesc />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">(4),0</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "        </accessibilityInfo>\n" +
                        "      </apipAccessibility>\n" +
                        "    </content>\n" +
                        "  </item>\n" +
                        "</itemrelease>\n"))
                .put("30309", new GitLabItemMetaData("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>\n" +
                        "<metadata>\n" +
                        "  <smarterAppMetadata xmlns=\"http://www.smarterapp.org/ns/1/assessment_item_metadata\">\n" +
                        "    <Identifier>30309</Identifier>\n" +
                        "    <ItemAuthorIdentifier>Sridhar_Ravva</ItemAuthorIdentifier>\n" +
                        "    <ItemSpecFormat>SmarterApp</ItemSpecFormat>\n" +
                        "    <LastModifiedBy>Sridhar_Ravva</LastModifiedBy>\n" +
                        "    <StimulusFormat>Standard</StimulusFormat>\n" +
                        "    <Subject>MATH</Subject>\n" +
                        "    <Version>11</Version>\n" +
                        "    <SecurityStatus>Secure</SecurityStatus>\n" +
                        "    <SmarterAppItemDescriptor>87659</SmarterAppItemDescriptor>\n" +
                        "    <IntendedGrade>11</IntendedGrade>\n" +
                        "    <MinimumGrade>9</MinimumGrade>\n" +
                        "    <MaximumGrade>11</MaximumGrade>\n" +
                        "    <MathematicalPractice>1</MathematicalPractice>\n" +
                        "    <MathematicalPractice>4</MathematicalPractice>\n" +
                        "    <DepthOfKnowledge>3</DepthOfKnowledge>\n" +
                        "    <AchievementQuintile>4</AchievementQuintile>\n" +
                        "    <AllowCalculator>Y</AllowCalculator>\n" +
                        "    <InteractionType>MC</InteractionType>\n" +
                        "    <MaximumNumberOfPoints>1</MaximumNumberOfPoints>\n" +
                        "    <ScorePoints>\"0, 1\"</ScorePoints>\n" +
                        "    <ScoringEngine>Automatic with Key</ScoringEngine>\n" +
                        "    <PresentationFormat>Text</PresentationFormat>\n" +
                        "    <AdministrationDate>Field Test</AdministrationDate>\n" +
                        "    <ContentTaskModel>TM5</ContentTaskModel>\n" +
                        "    <AlgebraFunctionDescriptor>Linear</AlgebraFunctionDescriptor>\n" +
                        "    <BrailleType>BRF_EBAE_UEB</BrailleType>\n" +
                        "    <EnemyItem>0</EnemyItem>\n" +
                        "    <CopyrightAndOtherRestrictions>Not Set</CopyrightAndOtherRestrictions>\n" +
                        "    <PerformanceTaskComponentItem>N</PerformanceTaskComponentItem>\n" +
                        "    <PtEnemy>0</PtEnemy>\n" +
                        "    <AccessibilityTagsASLLanguage>Y</AccessibilityTagsASLLanguage>\n" +
                        "    <IrtDimension>\n" +
                        "      <IrtStatDomain>Online</IrtStatDomain>\n" +
                        "      <IrtModelType>IRT3PLN</IrtModelType>\n" +
                        "      <IrtDimensionPurpose></IrtDimensionPurpose>\n" +
                        "      <IrtScore>1</IrtScore>\n" +
                        "      <IrtWeight>1</IrtWeight>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>a</Name>\n" +
                        "        <Value>0.30647</Value>\n" +
                        "      </IrtParameter>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>b</Name>\n" +
                        "        <Value>4.09345</Value>\n" +
                        "      </IrtParameter>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>c</Name>\n" +
                        "        <Value>0</Value>\n" +
                        "      </IrtParameter>\n" +
                        "    </IrtDimension>\n" +
                        "    <Status>Operational</Status>\n" +
                        "    <StandardPublication>\n" +
                        "      <Publication>SBAC-MA-v6</Publication>\n" +
                        "      <PrimaryStandard>SBAC-MA-v6:4|F|NA|E</PrimaryStandard>\n" +
                        "    </StandardPublication>\n" +
                        "    <StandardPublication>\n" +
                        "      <Publication>SBAC-MA-v4</Publication>\n" +
                        "      <PrimaryStandard>SBAC-MA-v4:4|F-BF|E|NA|NA</PrimaryStandard>\n" +
                        "      <SecondaryStandard>SBAC-MA-v5:1|F-BF|N|m|F-BF.1a</SecondaryStandard>\n" +
                        "    </StandardPublication>\n" +
                        "    <AssociatedTutorial>67708</AssociatedTutorial>\n" +
                        "    <AssociatedWordlist>67180</AssociatedWordlist>\n" +
                        "    <Language>eng</Language>\n" +
                        "    <Language>spa</Language>\n" +
                        "  </smarterAppMetadata>\n" +
                        "</metadata>\n", "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<itemrelease version=\"2.0\">\n" +
                        "  <item format=\"mc\" id=\"30309\" version=\"11\" bankkey=\"200\">\n" +
                        "    <attriblist>\n" +
                        "      <attrib attid=\"itm_item_id\">\n" +
                        "        <name>Item: ITS ID</name>\n" +
                        "        <val>30309</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_item_subject\">\n" +
                        "        <name>Item: Subject</name>\n" +
                        "        <val>MATH</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_item_desc\">\n" +
                        "        <name>Item: Item Description</name>\n" +
                        "        <val>87659</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_FTUse\">\n" +
                        "        <name>Fieldtest Use</name>\n" +
                        "        <val>Platform::MG11::1.7B (759); SBAC-Int-PR1-FM1-Math-11 (12); SBAC-Int-PR1-FM1-Math-11-SPA (12);</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_OPUse\">\n" +
                        "        <name>Operational Use</name>\n" +
                        "        <val>CAT::MG11::ONCalc-S1-D::SP14 (1358); CAT::MG11::ONONCalc-S1-A1::SP14 (269); FAKE MATH FORM (7273); CAT::MG11::ONCalc-S1-A2::SP14 (269); CAT::MG11::ONCalc-S1-A4::SP14 (269); CAT::MG10::ONCalc-S1-A4::SP14 (269); CAT::MG11::ONCalc-S1-A3::SP14 (269); CAT::MG11::ONCalc-S4-A3::SP14 (269); CAT::MG11::CA-ONCalc::SP14 (269); CAT::MG10::ONCalc-S1-A4::SP14-ESN (267); CAT::MG11::ONONCalc-S1-A1::SP14-ESN (267); CAT::MG11::ONCalc-S1-D::SP14-ESN (267); CAT::MG11::ONCalc-S4-A3::SP14-ESN (267); CAT::MG11::ONCalc-S1-A2::SP14-ESN (267); CAT::MG11::ONCalc-S1-A3::SP14-ESN (267); CAT::MG8::UPCALC-S1-B::SP14-ESN (267); CAT::MG8::UPCALC-S4-B::SP14-ESN (267); CAT::MG11::CA-ONCalc::SP14-ESN (267); CAT::MATH910::VL11NoCALC-S2-C::SP14-ESN (267); CAT::MATH910::VL11NoCALC-S3-C::SP14-ESN (267); CAT::MG11::CA-ONCalc::D::SP14 (1358); CAT::MG11::CA-ONCalc::D::SP14-ESN (267); CAT::MG11::CA-ONCalc::D (1358); IAB-G11M-AlgLinearFun-Calc-2015 ENG (3); IAB-G11M-AlgLinearFun-Calc-2015 BRL (3); IAB-G11M-AlgLinearFun-Calc-2015 SPA (3); IAB-G11M-AlgLinearFun-Calc-2015 ENG-COMBINED (3); IAB-G11M-AlgLinearFun-Calc-2015 BRL-COMBINED (3); IAB-G11M-AlgLinearFun-Calc-2015 SPA-COMBINED (3); IAB-G11M-AlgLin-Calc-2017 ENG (12); IAB-G11M-AlgLin-Calc-2017 BRL (12); IAB-G11M-AlgLin-Calc-2017 SPA (12); IAB-G11M-AlgLin-Calc-2017 ENG COMBINED (12); IAB-G11M-AlgLin-Calc-2017 BRL COMBINED (12); IAB-G11M-AlgLin-Calc-2017 SPA COMBINED (12); IAB-G11M-AlgLin-Calc-2018 ENG (12); IAB-G11M-AlgLin-Calc-2018 BRL (12); IAB-G11M-AlgLin-Calc-2018 SPA (12); IAB-G11M-AlgLin-Calc-2018 ENG COMBINED (12); IAB-G11M-AlgLin-Calc-2018 BRL COMBINED (12); IAB-G11M-AlgLin-Calc-2018 SPA COMBINED (12); IAB-G11M-AlgLin-Calc-2019 ENG (12); IAB-G11M-AlgLin-Calc-2019 BRL (12); IAB-G11M-AlgLin-Calc-2019 SPA (12);</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Answer Key\">\n" +
                        "        <name>Item: Answer Key</name>\n" +
                        "        <val>D</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Grade\">\n" +
                        "        <name>Item: Grade</name>\n" +
                        "        <val>11</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Item Format\">\n" +
                        "        <name>Item: Item Format</name>\n" +
                        "        <val>MC</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Page Layout\">\n" +
                        "        <name>Item: Page Layout</name>\n" +
                        "        <val>8</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Response Type\">\n" +
                        "        <name>Item: Response Type</name>\n" +
                        "        <val>Vertical</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Item Point\">\n" +
                        "        <name>Item: Item Point</name>\n" +
                        "        <val>1 pt.</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Answer Key (Part II)\">\n" +
                        "        <name>Item: Answer Key (Part II)</name>\n" +
                        "        <val></val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Max Choices\">\n" +
                        "        <name>Item:Max Choices</name>\n" +
                        "        <val></val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Max Choices (Part II)\">\n" +
                        "        <name>Item:Max Choices (Part II)</name>\n" +
                        "        <val></val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "    </attriblist>\n" +
                        "    <tutorial id=\"67708\" bankkey=\"200\" />\n" +
                        "    <resourceslist>\n" +
                        "      <resource type=\"wordList\" id=\"67180\" index=\"1\" bankkey=\"200\" />\n" +
                        "    </resourceslist>\n" +
                        "    <statistic />\n" +
                        "    <content language=\"ENU\" version=\"2.0\" approvedVersion=\"11\">\n" +
                        "      <concept>\n" +
                        "        <name>What Knowledge Do Students Need to Understand This Concept?</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </concept>\n" +
                        "      <es>\n" +
                        "        <name>Explanation of Correct Answer</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </es>\n" +
                        "      <himi>\n" +
                        "        <name>Explanation of Correct Answer</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </himi>\n" +
                        "      <rationaleoptlist>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option A</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option B</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option C</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option D</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "      </rationaleoptlist>\n" +
                        "      <stem><![CDATA[<p style=\"\">Jared creates a number sequence that has a first term of <img id=\"CrossReference0\" src=\"item_30309_v11_item_30309_mml_svg_png__0.png\"/> and a second term of <img id=\"CrossReference1\" src=\"item_30309_v11_item_30309_mml_svg_png__1.png\"/>. Each term after the second is created by subtracting the term before the previous term from twice the previous term. He <span id=\"item_30309_TAG_14_BEGIN\">uses</span> <img id=\"CrossReference2\" src=\"item_30309_v11_item_30309_mml_svg_png__2.png\"/> to denote term number <img id=\"CrossReference3\" src=\"item_30309_v11_item_30309_mml_svg_png__3.png\"/> in his sequence. For example, <img id=\"CrossReference4\" src=\"item_30309_v11_item_30309_mml_svg_png__4.png\"/> and <img id=\"CrossReference5\" src=\"item_30309_v11_item_30309_mml_svg_png__5.png\"/>.</p><p style=\"\"><br /><span id=\"item_30309_TAG_15\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>Which<span class=\"its-tag\" data-tag-ref=\"item_30309_TAG_15\" data-tag-boundary=\"end\"></span> of the following can be used <span id=\"item_30309_TAG_16\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>to find<span class=\"its-tag\" data-tag-ref=\"item_30309_TAG_16\" data-tag-boundary=\"end\"></span> the value of <img id=\"CrossReference6\" src=\"item_30309_v11_item_30309_mml_svg_png__6.png\"/> for some positive integer <img id=\"CrossReference7\" src=\"item_30309_v11_item_30309_mml_svg_png__7.png\"/> greater than <img id=\"CrossReference8\" src=\"item_30309_v11_item_30309_mml_svg_png__8.png\"/>?</p>]]></stem>\n" +
                        "      <optionlist>\n" +
                        "        <option>\n" +
                        "          <name>Option A</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"CrossReference9\" src=\"item_30309_v11_item_30309_mml_svg_png__9.png\"/></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">The student gets the order of the terms wrong.</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option B</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"CrossReference10\" src=\"item_30309_v11_item_30309_mml_svg_png__10.png\"/></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">The student gets the order of the terms wrong and doubles the wrong term.</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option C</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"CrossReference11\" src=\"item_30309_v11_item_30309_mml_svg_png__11.png\"/></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">The student doubles the wrong term.</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option D</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"CrossReference12\" src=\"item_30309_v11_item_30309_mml_svg_png__12.png\"/></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">Key</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "      </optionlist>\n" +
                        "      <attachmentlist>\n" +
                        "        <attachment id=\"braillefile1\" type=\"BRF\" subtype=\"TDS_BT_ECN\" file=\"item_30309_enu_brf_ebae_contracted_nemeth_ecn.brf\" />\n" +
                        "        <attachment id=\"braillefile19\" type=\"BRF\" subtype=\"TDS_BT_UCN\" file=\"item_30309_enu_brf_ueb_contracted_nemeth_ucn.brf\" />\n" +
                        "        <attachment id=\"braillefile31\" type=\"BRF\" subtype=\"TDS_BT_UCT\" file=\"item_30309_enu_brf_ueb_contracted_ueb_math_uct.brf\" />\n" +
                        "        <attachment id=\"braillefile3\" type=\"BRF\" subtype=\"TDS_BT_EXN\" file=\"item_30309_enu_brf_ebae_uncontracted_nemeth_exn.brf\" />\n" +
                        "        <attachment id=\"braillefile16\" type=\"BRF\" subtype=\"TDS_BT_UXN\" file=\"item_30309_enu_brf_ueb_uncontracted_nemeth_uxn.brf\" />\n" +
                        "        <attachment id=\"braillefile27\" type=\"BRF\" subtype=\"TDS_BT_UXT\" file=\"item_30309_enu_brf_ueb_uncontracted_ueb_math_uxt.brf\" />\n" +
                        "        <attachment id=\"aslfile1\" type=\"ASL\" subtype=\"STEM\" file=\"item_30309_ASL_STEM.mp4\">\n" +
                        "          <source src=\"item_30309_ASL_STEM.webm\" type=\"video/webm\" />\n" +
                        "          <source src=\"item_30309_ASL_STEM.mp4\" type=\"video/mp4\" />\n" +
                        "        </attachment>\n" +
                        "      </attachmentlist>\n" +
                        "      <apipAccessibility>\n" +
                        "        <accessibilityInfo>\n" +
                        "          <accessElement identifier=\"ae1\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference0\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>2</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">#2</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae2\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference1\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>five</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">#5</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae3\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_30309_TAG_14_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>eweses</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>uses</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae4\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference2\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>S of t</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">,s(t)</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae5\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference3\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>t</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">;t</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae6\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference4\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>S of 1  equals  two</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">,s(1) .k #2</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae7\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference5\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>S  of 2  equals  five</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">,s(2) .k #5</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae10\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference6\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>S  of n</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">,s(n)</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae11\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference7\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>n,</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">;n</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae12\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference8\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>two</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">#2</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae13\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference9\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>s of n equals s, of n minus 2,  minus 2 times s, of n minus 1</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">,s(n) .k ,s(n)-2-2,s(n)-1</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae14\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference10\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>s of n equals 2 times s, of n minus 2,  minus  s, of n minus 1</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">,s(n) .k #2,s(n)-2-,s(n)-1</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae15\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference11\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>s of n equals s, of n minus 1,  minus 2 times s, of n minus 2</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">,s(n) .k ,s(n)-1-2,s(n)-2</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae16\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference12\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>s of n equals 2 times s, of n minus 1,  minus  s, of n minus 2</audioShortDesc>\n" +
                        "                <audioLongDesc></audioLongDesc>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString></brailleTextString>\n" +
                        "                <brailleCode type=\"Nemeth\">,s(n) .k #2,s(n)-1-,s(n)-2</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "        </accessibilityInfo>\n" +
                        "      </apipAccessibility>\n" +
                        "    </content>\n" +
                        "    <content language=\"ESN\" version=\"2.0\" approvedVersion=\"11\">\n" +
                        "      <concept>\n" +
                        "        <name>What Knowledge Do Students Need to Understand This Concept?</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </concept>\n" +
                        "      <es>\n" +
                        "        <name>Explanation of Correct Answer</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </es>\n" +
                        "      <himi>\n" +
                        "        <name>Explanation of Correct Answer</name>\n" +
                        "        <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "      </himi>\n" +
                        "      <rationaleoptlist>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option A</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option B</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option C</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "        <rationale>\n" +
                        "          <name>Rationale for Option D</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rationale>\n" +
                        "      </rationaleoptlist>\n" +
                        "      <stem><![CDATA[<p style=\"\">Jared crea una sucesión de números cuyo primer término es <img id=\"CrossReference13\" src=\"item_30309_v11_item_30309_mml_svg_png__0.png\"/> y cuyo segundo término es <img id=\"CrossReference14\" src=\"item_30309_v11_item_30309_mml_svg_png__1.png\"/>. Cada término después del segundo término se crea restando el término anterior al término previo al doble del término previo. Él usa <img id=\"CrossReference15\" src=\"item_30309_v11_item_30309_mml_svg_png__2.png\"/> para denotar el término número <img id=\"CrossReference16\" src=\"item_30309_v11_item_30309_mml_svg_png__3.png\"/> en su sucesión. Por ejemplo, <img id=\"CrossReference17\" src=\"item_30309_v11_item_30309_mml_svg_png__4.png\"/> y <img id=\"CrossReference18\" src=\"item_30309_v11_item_30309_mml_svg_png__5.png\"/>.</p><p style=\"\"><br />¿Cuál de las siguientes opciones se pueden usar para encontrar el valor de <img id=\"CrossReference19\" src=\"item_30309_v11_item_30309_mml_svg_png__6.png\"/> para algún número entero positivo <img id=\"CrossReference20\" src=\"item_30309_v11_item_30309_mml_svg_png__7.png\"/> mayor que <img id=\"CrossReference21\" src=\"item_30309_v11_item_30309_mml_svg_png__8.png\"/>?</p><p class=\"languagedivider\">&#xA0;</p><p style=\"\">Jared creates a number sequence that has a first term of <img id=\"CrossReference0\" src=\"item_30309_v11_item_30309_mml_svg_png__0.png\"/> and a second term of <img id=\"CrossReference1\" src=\"item_30309_v11_item_30309_mml_svg_png__1.png\"/>. Each term after the second is created by subtracting the term before the previous term from twice the previous term. He <span id=\"item_30309_TAG_14_BEGIN\">uses</span> <img id=\"CrossReference2\" src=\"item_30309_v11_item_30309_mml_svg_png__2.png\"/> to denote term number <img id=\"CrossReference3\" src=\"item_30309_v11_item_30309_mml_svg_png__3.png\"/> in his sequence. For example, <img id=\"CrossReference4\" src=\"item_30309_v11_item_30309_mml_svg_png__4.png\"/> and <img id=\"CrossReference5\" src=\"item_30309_v11_item_30309_mml_svg_png__5.png\"/>.</p><p style=\"\"><br /><span id=\"item_30309_TAG_15\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"1\"></span>Which<span class=\"its-tag\" data-tag-ref=\"item_30309_TAG_15\" data-tag-boundary=\"end\"></span> of the following can be used <span id=\"item_30309_TAG_16\" class=\"its-tag\" data-tag=\"word\" data-tag-boundary=\"start\" data-word-index=\"2\"></span>to find<span class=\"its-tag\" data-tag-ref=\"item_30309_TAG_16\" data-tag-boundary=\"end\"></span> the value of <img id=\"CrossReference6\" src=\"item_30309_v11_item_30309_mml_svg_png__6.png\"/> for some positive integer <img id=\"CrossReference7\" src=\"item_30309_v11_item_30309_mml_svg_png__7.png\"/> greater than <img id=\"CrossReference8\" src=\"item_30309_v11_item_30309_mml_svg_png__8.png\"/>?</p>]]></stem>\n" +
                        "      <optionlist>\n" +
                        "        <option>\n" +
                        "          <name>Option A</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"CrossReference9\" src=\"item_30309_v11_item_30309_mml_svg_png__9.png\"/></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option B</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"CrossReference10\" src=\"item_30309_v11_item_30309_mml_svg_png__10.png\"/></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option C</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"CrossReference11\" src=\"item_30309_v11_item_30309_mml_svg_png__11.png\"/></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "        <option>\n" +
                        "          <name>Option D</name>\n" +
                        "          <val><![CDATA[<p style=\"\"><img id=\"CrossReference12\" src=\"item_30309_v11_item_30309_mml_svg_png__12.png\"/></p>]]></val>\n" +
                        "          <feedback><![CDATA[<p style=\"\">&#xA0;</p>]]></feedback>\n" +
                        "        </option>\n" +
                        "      </optionlist>\n" +
                        "      <attachmentlist />\n" +
                        "      <apipAccessibility>\n" +
                        "        <accessibilityInfo>\n" +
                        "          <accessElement identifier=\"ae1\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference0\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>2</audioShortDesc>\n" +
                        "                <audioLongDesc />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">#2</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae2\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference1\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>five</audioShortDesc>\n" +
                        "                <audioLongDesc />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">#5</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae3\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_30309_TAG_14_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>eweses</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>uses</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae4\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference2\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>S of t</audioShortDesc>\n" +
                        "                <audioLongDesc />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">,s(t)</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae5\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference3\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>t</audioShortDesc>\n" +
                        "                <audioLongDesc />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">;t</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae6\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference4\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>S of 1  equals  two</audioShortDesc>\n" +
                        "                <audioLongDesc />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">,s(1) .k #2</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae7\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference5\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>S  of 2  equals  five</audioShortDesc>\n" +
                        "                <audioLongDesc />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">,s(2) .k #5</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae10\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference6\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>S  of n</audioShortDesc>\n" +
                        "                <audioLongDesc />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">,s(n)</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae11\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference7\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>n,</audioShortDesc>\n" +
                        "                <audioLongDesc />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">;n</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae12\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference8\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>two</audioShortDesc>\n" +
                        "                <audioLongDesc />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">#2</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae13\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference9\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>s of n equals s, of n minus 2,  minus 2 times s, of n minus 1</audioShortDesc>\n" +
                        "                <audioLongDesc />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">,s(n) .k ,s(n)-2-2,s(n)-1</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae14\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference10\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>s of n equals 2 times s, of n minus 2,  minus  s, of n minus 1</audioShortDesc>\n" +
                        "                <audioLongDesc />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">,s(n) .k #2,s(n)-2-,s(n)-1</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae15\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference11\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>s of n equals s, of n minus 1,  minus 2 times s, of n minus 2</audioShortDesc>\n" +
                        "                <audioLongDesc />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">,s(n) .k ,s(n)-1-2,s(n)-2</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "          <accessElement identifier=\"ae16\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"CrossReference12\" type=\"Equation\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <audioShortDesc>s of n equals 2 times s, of n minus 1,  minus  s, of n minus 2</audioShortDesc>\n" +
                        "                <audioLongDesc />\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString />\n" +
                        "                <brailleCode type=\"Nemeth\">,s(n) .k #2,s(n)-1-,s(n)-2</brailleCode>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "        </accessibilityInfo>\n" +
                        "      </apipAccessibility>\n" +
                        "    </content>\n" +
                        "  </item>\n" +
                        "</itemrelease>\n"))
                .put("83838", new GitLabItemMetaData("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>\n" +
                        "<metadata>\n" +
                        "  <smarterAppMetadata xmlns=\"http://www.smarterapp.org/ns/1/assessment_item_metadata\">\n" +
                        "    <Identifier>83834</Identifier>\n" +
                        "    <Subject>MATH</Subject>\n" +
                        "    <Version>9</Version>\n" +
                        "    <SecurityStatus>Secure</SecurityStatus>\n" +
                        "    <SmarterAppItemDescriptor>MATH.11.1.A-REI.1I</SmarterAppItemDescriptor>\n" +
                        "    <StimulusFormat>Standard</StimulusFormat>\n" +
                        "    <ItemAuthorIdentifier>Sridhar_Ravva</ItemAuthorIdentifier>\n" +
                        "    <ItemSpecFormat>SmarterApp</ItemSpecFormat>\n" +
                        "    <LastModifiedBy>Sridhar_Ravva</LastModifiedBy>\n" +
                        "    <IntendedGrade>11</IntendedGrade>\n" +
                        "    <MinimumGrade>9</MinimumGrade>\n" +
                        "    <MaximumGrade>11</MaximumGrade>\n" +
                        "    <DepthOfKnowledge>1</DepthOfKnowledge>\n" +
                        "    <AchievementQuintile>1</AchievementQuintile>\n" +
                        "    <AllowCalculator>N</AllowCalculator>\n" +
                        "    <InteractionType>EQ</InteractionType>\n" +
                        "    <MaximumNumberOfPoints>1</MaximumNumberOfPoints>\n" +
                        "    <ScorePoints>\"0, 1\"</ScorePoints>\n" +
                        "    <ScoringEngine>Automatic with Machine Rubric</ScoringEngine>\n" +
                        "    <PresentationFormat>Text</PresentationFormat>\n" +
                        "    <AdministrationDate>Phase 2</AdministrationDate>\n" +
                        "    <ContentTaskModel>TM1a_Rpdv</ContentTaskModel>\n" +
                        "    <AlgebraFunctionDescriptor>Linear</AlgebraFunctionDescriptor>\n" +
                        "    <BrailleType>BRF_EBAE_UEB</BrailleType>\n" +
                        "    <EnemyItem></EnemyItem>\n" +
                        "    <CopyrightAndOtherRestrictions></CopyrightAndOtherRestrictions>\n" +
                        "    <StimulusScource></StimulusScource>\n" +
                        "    <Notes></Notes>\n" +
                        "    <PerformanceTaskComponentItem>N</PerformanceTaskComponentItem>\n" +
                        "    <PtClassroomActivity></PtClassroomActivity>\n" +
                        "    <PtEnemy></PtEnemy>\n" +
                        "    <AccessibilityTagsASLLanguage>Y</AccessibilityTagsASLLanguage>\n" +
                        "    <IrtDimension>\n" +
                        "      <IrtStatDomain>Online</IrtStatDomain>\n" +
                        "      <IrtModelType>IRT3PLN</IrtModelType>\n" +
                        "      <IrtDimensionPurpose></IrtDimensionPurpose>\n" +
                        "      <IrtScore>1</IrtScore>\n" +
                        "      <IrtWeight>1</IrtWeight>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>a</Name>\n" +
                        "        <Value>0.9329</Value>\n" +
                        "      </IrtParameter>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>b</Name>\n" +
                        "        <Value>0.5231</Value>\n" +
                        "      </IrtParameter>\n" +
                        "      <IrtParameter>\n" +
                        "        <Name>c</Name>\n" +
                        "        <Value>0</Value>\n" +
                        "      </IrtParameter>\n" +
                        "    </IrtDimension>\n" +
                        "    <Status>Operational</Status>\n" +
                        "    <StandardPublication>\n" +
                        "      <Publication>SBAC-MA-v4</Publication>\n" +
                        "      <PrimaryStandard>SBAC-MA-v4:1|A-REI|I|m|A-REI.3</PrimaryStandard>\n" +
                        "    </StandardPublication>\n" +
                        "    <StandardPublication>\n" +
                        "      <Publication>SBAC-MA-v6</Publication>\n" +
                        "      <PrimaryStandard>SBAC-MA-v6:1|P|TS03|I</PrimaryStandard>\n" +
                        "    </StandardPublication>\n" +
                        "    <AssociatedTutorial>67863</AssociatedTutorial>\n" +
                        "    <AssociatedWordlist>123853</AssociatedWordlist>\n" +
                        "    <Language>eng</Language>\n" +
                        "    <Language>spa</Language>\n" +
                        "  </smarterAppMetadata>\n" +
                        "</metadata>\n","<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<itemrelease version=\"2.0\">\n" +
                        "  <item format=\"eq\" id=\"83838\" version=\"3\" bankkey=\"200\">\n" +
                        "    <attriblist>\n" +
                        "      <attrib attid=\"itm_item_id\">\n" +
                        "        <name>Item: ITS ID</name>\n" +
                        "        <val>83838</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_item_subject\">\n" +
                        "        <name>Item: Subject</name>\n" +
                        "        <val>MATH</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_item_desc\">\n" +
                        "        <name>Item: Item Description</name>\n" +
                        "        <val>MATH.11.1.A-REI.1I</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_FTUse\">\n" +
                        "        <name>Fieldtest Use</name>\n" +
                        "        <val>Math OP G11 No Calc 2015 ENG (320); Math MAAC G9 No Calc 2015 ENG (26); Math OP G11 No Calc 2015 ENG COMBINED (329); Math MAAC G9 No Calc 2015 ENG COMBINED (29); SBAC-Int-PR1-FM1-Math-11 (14); SBAC-Int-PR1-FM1-Math-11-SPA (14);</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_OPUse\">\n" +
                        "        <name>Operational Use</name>\n" +
                        "        <val>IAB-G11M-AlgLin-NoCalc-2017 ENG (2); IAB-G11M-AlgLin-NoCalc-2017 BRL (2); IAB-G11M-AlgLin-NoCalc-2017 SPA (2); IAB-G11M-AlgLin-NoCalc-2017 ENG COMBINED (2); IAB-G11M-AlgLin-NoCalc-2017 BRL COMBINED (2); IAB-G11M-AlgLin-NoCalc-2017 SPA COMBINED (2); IAB-G11M-AlgLin-NoCalc-2018 ENG (2); IAB-G11M-AlgLin-NoCalc-2018 BRL (2); IAB-G11M-AlgLin-NoCalc-2018 SPA (2); IAB-G11M-AlgLin-NoCalc-2018 ENG COMBINED (2); IAB-G11M-AlgLin-NoCalc-2018 BRL COMBINED (2); IAB-G11M-AlgLin-NoCalc-2018 SPA COMBINED (2); IAB-G11M-AlgLin-NoCalc-2019 ENG (2); IAB-G11M-AlgLin-NoCalc-2019 BRL (2); IAB-G11M-AlgLin-NoCalc-2019 SPA (2);</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Answer Key\">\n" +
                        "        <name>Item: Answer Key</name>\n" +
                        "        <val>EQ</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Grade\">\n" +
                        "        <name>Item: Grade</name>\n" +
                        "        <val>11</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Item Format\">\n" +
                        "        <name>Item: Item Format</name>\n" +
                        "        <val>EQ</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Page Layout\">\n" +
                        "        <name>Item: Page Layout</name>\n" +
                        "        <val>8</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Response Type\">\n" +
                        "        <name>Item: Response Type</name>\n" +
                        "        <val>EquationEditor</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Item Point\">\n" +
                        "        <name>Item: Item Point</name>\n" +
                        "        <val>1 pt.</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Answer Key (Part II)\">\n" +
                        "        <name>Item: Answer Key (Part II)</name>\n" +
                        "        <val>NA</val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Max Choices\">\n" +
                        "        <name>Item:Max Choices</name>\n" +
                        "        <val>NA</val>\n" +
                        "        <desc>NA</desc>\n" +
                        "      </attrib>\n" +
                        "      <attrib attid=\"itm_att_Max Choices (Part II)\">\n" +
                        "        <name>Item:Max Choices (Part II)</name>\n" +
                        "        <val></val>\n" +
                        "        <desc></desc>\n" +
                        "      </attrib>\n" +
                        "    </attriblist>\n" +
                        "    <tutorial id=\"67863\" bankkey=\"200\" />\n" +
                        "    <resourceslist>\n" +
                        "      <resource type=\"wordList\" id=\"124317\" index=\"1\" bankkey=\"200\" />\n" +
                        "    </resourceslist>\n" +
                        "    <statistic />\n" +
                        "    <MachineRubric filename=\"Item_83838_v3.qrx\" />\n" +
                        "    <RendererSpec filename=\"Item_83838_v3.eax\" />\n" +
                        "    <content language=\"ENU\" version=\"2.0\" approvedVersion=\"3\">\n" +
                        "      <rationaleoptlist />\n" +
                        "      <stem><![CDATA[<p style=\"\">Solve the inequality for <span style=\"font-style:italic; \">n</span>.</p><p style=\"\">&#xA0;</p><p style=\"\"><span id=\"item_83838_TAG_1_BEGIN\">14 &lt; <span style=\"font-style:italic; \">n</span> – 3 </span></p>]]></stem>\n" +
                        "      <rubriclist>\n" +
                        "        <rubric scorepoint=\"\">\n" +
                        "          <name>\n" +
                        "        Rubric </name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p><p style=\"\">Exemplar:</p><p style=\"\">&#xA0;</p><ul style=\"padding-left:1.5000em; \"><li><p style=\"\">17 &lt; <span style=\"font-style:italic; \">n</span></p></li></ul><p style=\"\">&#xA0;</p><p style=\"\">Other Correct Responses:</p><p style=\"\">&#xA0;</p><ul style=\"padding-left:1.5000em; \"><li><p style=\"\"><span style=\"font-style:italic; \">n</span> &gt; 17</p></li></ul><p style=\"\">&#xA0;</p><p style=\"\">For this item, a full-credit response includes</p><p style=\"\">&#xA0;</p><ul style=\"padding-left:1.5000em; \"><li><p style=\"\">The student enters the correct inequality. (1 point) </p></li></ul><p style=\"\">&#xA0;&#xA0;&#xA0;&#xA0;&#xA0;&#xA0;&#xA0;&#xA0;</p><p style=\"\">&#xA0;</p><p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rubric>\n" +
                        "        <samplelist maxval=\"\" minval=\"\" />\n" +
                        "      </rubriclist>\n" +
                        "      <attachmentlist>\n" +
                        "        <attachment id=\"braillefile1\" type=\"BRF\" subtype=\"TDS_BT_ECN\" file=\"item_83838_enu_brf_ebae_contracted_nemeth_ecn.brf\" />\n" +
                        "        <attachment id=\"braillefile19\" type=\"BRF\" subtype=\"TDS_BT_UCN\" file=\"item_83838_enu_brf_ueb_contracted_nemeth_ucn.brf\" />\n" +
                        "        <attachment id=\"braillefile31\" type=\"BRF\" subtype=\"TDS_BT_UCT\" file=\"item_83838_enu_brf_ueb_contracted_ueb_math_uct.brf\" />\n" +
                        "        <attachment id=\"braillefile3\" type=\"BRF\" subtype=\"TDS_BT_EXN\" file=\"item_83838_enu_brf_ebae_uncontracted_nemeth_exn.brf\" />\n" +
                        "        <attachment id=\"braillefile16\" type=\"BRF\" subtype=\"TDS_BT_UXN\" file=\"item_83838_enu_brf_ueb_uncontracted_nemeth_uxn.brf\" />\n" +
                        "        <attachment id=\"braillefile27\" type=\"BRF\" subtype=\"TDS_BT_UXT\" file=\"item_83838_enu_brf_ueb_uncontracted_ueb_math_uxt.brf\" />\n" +
                        "        <attachment id=\"aslfile1\" type=\"ASL\" subtype=\"STEM\" file=\"item_83838_ASL_STEM.mp4\">\n" +
                        "          <source src=\"item_83838_ASL_STEM.webm\" type=\"video/webm\" />\n" +
                        "          <source src=\"item_83838_ASL_STEM.mp4\" type=\"video/mp4\" />\n" +
                        "        </attachment>\n" +
                        "      </attachmentlist>\n" +
                        "      <apipAccessibility>\n" +
                        "        <accessibilityInfo>\n" +
                        "          <accessElement identifier=\"ae1\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_83838_TAG_1_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>; 14 is less than n minus 3;  \n" +
                        "The equation tool has two sections. In the left \n" +
                        "section, from left to right and top to bottom \n" +
                        "the equation tool reeds, 1, 2, 3, 4, 5, 6, 7, \n" +
                        "8, 9, 0, point, negative. In the \n" +
                        "right section mathematical functions are shown.</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>14 &lt; n – 3</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>14 &lt; n – 3</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "        </accessibilityInfo>\n" +
                        "      </apipAccessibility>\n" +
                        "    </content>\n" +
                        "    <content language=\"ESN\" version=\"2.0\" approvedVersion=\"3\">\n" +
                        "      <stem><![CDATA[<p style=\"\">Resuelve la siguiente desigualdad para <span style=\"font-style:italic; \">n</span>.</p><p style=\"\">&#xA0;</p><p style=\"\">14 &lt; <span style=\"font-style:italic; \">n</span> – 3 </p><p class=\"languagedivider\">&#xA0;</p><p style=\"\">Solve the inequality for <span style=\"font-style:italic; \">n</span>.</p><p style=\"\">&#xA0;</p><p style=\"\"><span id=\"item_83838_TAG_1_BEGIN\">14 &lt; <span style=\"font-style:italic; \">n</span> – 3 </span></p>]]></stem>\n" +
                        "      <rubriclist>\n" +
                        "        <rubric scorepoint=\"_Spanish\">\n" +
                        "          <name>\n" +
                        "        Rubric _Spanish</name>\n" +
                        "          <val><![CDATA[<p style=\"\">&#xA0;</p>]]></val>\n" +
                        "        </rubric>\n" +
                        "        <samplelist maxval=\"_Spanish\" minval=\"_Spanish\" />\n" +
                        "      </rubriclist>\n" +
                        "      <attachmentlist />\n" +
                        "      <apipAccessibility>\n" +
                        "        <accessibilityInfo>\n" +
                        "          <accessElement identifier=\"ae1\">\n" +
                        "            <contentLinkInfo itsLinkIdentifierRef=\"item_83838_TAG_1_BEGIN\" type=\"Text\">\n" +
                        "              <objectLink />\n" +
                        "            </contentLinkInfo>\n" +
                        "            <relatedElementInfo>\n" +
                        "              <readAloud>\n" +
                        "                <textToSpeechPronunciation>; 14 is less than n minus 3;  \n" +
                        "The equation tool has two sections. In the left \n" +
                        "section, from left to right and top to bottom \n" +
                        "the equation tool reeds, 1, 2, 3, 4, 5, 6, 7, \n" +
                        "8, 9, 0, point, negative. In the \n" +
                        "right section mathematical functions are shown.</textToSpeechPronunciation>\n" +
                        "                <textToSpeechPronunciationAlternate>14 &lt; n – 3</textToSpeechPronunciationAlternate>\n" +
                        "              </readAloud>\n" +
                        "              <brailleText>\n" +
                        "                <brailleTextString>14 &lt; n – 3</brailleTextString>\n" +
                        "              </brailleText>\n" +
                        "            </relatedElementInfo>\n" +
                        "          </accessElement>\n" +
                        "        </accessibilityInfo>\n" +
                        "      </apipAccessibility>\n" +
                        "    </content>\n" +
                        "  </item>\n" +
                        "</itemrelease>\n"))
                .build();
    }
}
