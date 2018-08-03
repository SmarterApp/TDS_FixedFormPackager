package tds.packager.service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tds.itemrenderer.data.xml.itemrelease.Itemrelease;
import tds.packager.mapper.TestPackageMapper;
import tds.packager.model.gitlab.*;
import tds.packager.model.xlsx.TestPackageWorkbook;
import tds.support.tool.testpackage.configuration.TestPackageObjectMapperConfiguration;
import tds.testpackage.model.TestPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

@Service
public class FixedFormPackagerServiceImpl implements FixedFormPackagerService {
    private static final Logger log = LoggerFactory.getLogger(FixedFormPackagerServiceImpl.class);
    private final XmlMapper xmlMapper;

    @Autowired
    public FixedFormPackagerServiceImpl(final TestPackageObjectMapperConfiguration configuration) {
        this.xmlMapper = configuration.getLegacyTestSpecXmlMapper();
    }

    private TestPackageWorkbook createTestPackageWorkbook(final String inputSpreadsheetPath) {
        try {
            return new TestPackageWorkbook(new XSSFWorkbook(new FileInputStream(inputSpreadsheetPath)));
        } catch (IOException e) {
            throw new RuntimeException("Error reading test package spreadsheet.", e);
        }
    }

    @Override
    public void generateFixedFormPackage(final String inputSpreadsheetPath, final String outputFilePath,
                                         final GitCredentials credentials) {

        // TODO: read/process input spreadsheet + map to TestPackage

        //TODO: get Iterable list of Item ids and pass to GitLabUtil.getItemMetaData
        String [] items = new String[] { "200-12164", "200-14286"};

        final HashMap<String, GitLabItemMetaData> itemMetaData = GitLabUtil.getItemMetaData(credentials, Arrays.asList(items));
        GitLabItemMetaData gli = itemMetaData.get(items[0]);
        final ItemreleaseUnmarshaller unmarshaller = new ItemreleaseUnmarshaller();
        Itemrelease ir = unmarshaller.unmarshallItem(gli.getItemReleaseMetadata(),items[0]);
        System.out.println("unmarshalled: " + ir.getItemPassage().getId());

        // TODO: get item data from gitlab using the GitCredentials
        final TestPackageWorkbook testPackageWorkbook = createTestPackageWorkbook(inputSpreadsheetPath);
        final TestPackage testPackage = TestPackageMapper.map(testPackageWorkbook, itemMetaData);
        // Example of getting the PrimaryStandard from the item metadata.xml
        String itemMetaString = gli.getItemMetadata();
        ItemMetaDataUtil itemMetaDataUtil = new ItemMetaDataUtil(itemMetaString);
        System.out.println("PrimaryStandard v6= " + itemMetaDataUtil.getPrimaryStandard());

        final String outputFileFullPath = outputFilePath + File.separator + testPackage.getId() + ".xml";

        try {
            createTestPackageFile(outputFileFullPath, testPackage);
            System.out.println("Successfully created the fixed form test package " + testPackage.getId() + ".xml");
        } catch (IOException e) {
            throw new RuntimeException(String.format("An exception occurred while creating the file %s", outputFileFullPath), e);
        }
    }

    private void createTestPackageFile(final String outputFilePath, final TestPackage testPackage) throws IOException {
        final File testPackageFile = new File(outputFilePath);
        xmlMapper.writeValue(testPackageFile, testPackage);
        testPackageFile.createNewFile();
    }
}
