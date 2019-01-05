package tds.packager.service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import tds.packager.mapper.TestPackageMapper;
import tds.packager.model.gitlab.GitCredentials;
import tds.packager.model.gitlab.GitLabItemMetaData;
import tds.packager.model.gitlab.GitLabUtil;
import tds.packager.model.xlsx.TestPackageSheet;
import tds.packager.model.xlsx.TestPackageSheetNames;
import tds.packager.model.xlsx.TestPackageWorkbook;
import tds.support.tool.testpackage.configuration.TestPackageObjectMapperConfiguration;
import tds.testpackage.model.TestPackage;

import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@Service
public class FixedFormPackagerServiceImpl implements FixedFormPackagerService {
    private final XmlMapper xmlMapper;
    private final Validator schemaValidator;

    @Autowired
    public FixedFormPackagerServiceImpl(final TestPackageObjectMapperConfiguration configuration) throws SAXException {
        xmlMapper = configuration.getLegacyTestSpecXmlMapper();
        schemaValidator = configuration.getTestPackageSchemaValidator();
    }

    @Override
    public void generateFixedFormPackage(final String inputSpreadsheetPath, final String outputFilePath,
                                         final GitCredentials credentials, final boolean debug) {
        final TestPackageWorkbook testPackageWorkbook = createTestPackageWorkbook(inputSpreadsheetPath);
        final String bankKey = getBankKey(testPackageWorkbook.getSheet(TestPackageSheetNames.PACKAGE));
        final String[] items = getItemIds(bankKey, testPackageWorkbook.getSheet(TestPackageSheetNames.SEGMENT_FORMS));

        final Map<String, GitLabItemMetaData> itemMetaData = GitLabUtil.getItemMetaData(credentials, Arrays.asList(items));
        final TestPackage testPackage = TestPackageMapper.map(testPackageWorkbook, itemMetaData);
        final String outputFileFullPath = outputFilePath + File.separator + testPackage.getId() + ".xml";

        try {
            createAndValidateTestPackageFile(outputFileFullPath, testPackage, debug);
            System.out.println("Successfully created the fixed form test package " + testPackage.getId() + ".xml");
        } catch (IOException e) {
            throw new RuntimeException(String.format("An exception occurred while creating the file %s", outputFileFullPath), e);
        }
    }

    private static String getBankKey(final TestPackageSheet sheet) {
        return sheet.getString("BankKey");
    }

    private static String[] getItemIds(final String bankKey, final TestPackageSheet sheet) {
        final String[] itemIds = sheet.getStrings("ItemId");

        // Item IDs in the input file do not include the bank key - but the items are keyed by the entire item key (which is
        // prefixed by the bank key) in gitlab
        for (int i = 0; i < itemIds.length; i++) {
            itemIds[i] = String.format("%s-%s", bankKey, itemIds[i]);
        }

        return itemIds;
    }

    private TestPackageWorkbook createTestPackageWorkbook(final String inputSpreadsheetPath) {
        try {
            return new TestPackageWorkbook(new XSSFWorkbook(new FileInputStream(inputSpreadsheetPath)));
        } catch (IOException e) {
            throw new RuntimeException("Error reading test package spreadsheet.", e);
        }
    }

    private void createAndValidateTestPackageFile(final String outputFilePath, final TestPackage testPackage,
                                                 final boolean debug) throws IOException {
        final File testPackageFile = new File(outputFilePath);
        xmlMapper.writeValue(testPackageFile, testPackage);

        try (FileInputStream fis = new FileInputStream(testPackageFile)) {
            final StreamSource xmlFile = new StreamSource(fis);
            schemaValidator.validate(xmlFile);
            testPackageFile.createNewFile();
        } catch (SAXException e) {
            System.out.println("Error during XSD validation of the test package " + testPackage.getId());

            if (debug) {
                e.printStackTrace();
            }
        }
    }
}
