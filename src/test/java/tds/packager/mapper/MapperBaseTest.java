package tds.packager.mapper;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.google.common.collect.ImmutableMap;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import tds.packager.model.gitlab.GitLabItemMetaData;
import tds.packager.model.xlsx.TestPackageWorkbook;

import java.util.Map;

public class MapperBaseTest {
    protected TestPackageWorkbook mockWorkbook;

    protected Map<String, GitLabItemMetaData> itemMetadata;

    protected XmlMapper xmlMapper;

    @Before
    public void setup() throws Exception {
        xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new Jdk8Module());

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
                        "</metadata>\n", ""))
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
                        "</metadata>\n", ""))
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
                        "</metadata>\n", ""))
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
                        "</metadata>\n", ""))
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
                        "</metadata>\n", ""))
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
                        "</metadata>\n", ""))
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
                        "</metadata>\n", ""))
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
                        "</metadata>\n", ""))
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
                        "</metadata>\n", ""))
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
                        "</metadata>\n", ""))
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
                        "</metadata>\n", ""))
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
                        "</metadata>\n", ""))
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
                        "</metadata>\n", ""))
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
                        "</metadata>\n", ""))
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
                        "</metadata>\n",""))
                .build();
    }
}
