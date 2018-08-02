package tds.packager.service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tds.packager.model.gitlab.GitCredentials;
import tds.support.tool.testpackage.configuration.TestPackageObjectMapperConfiguration;
import tds.testpackage.model.TestPackage;
import tds.packager.model.gitlab.*;

import java.io.File;
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

    @Override
    public void generateFixedFormPackage(final String inputSpreadsheetPath, final String outputFilePath,
                                         final GitCredentials credentials) {

        // TODO: read/process input spreadsheet + map to TestPackage

        //TODO: get Iterable list of Item ids and pass to GitLabUtil.getItemMetaData
        String [] items = new String[] { "200-12164", "200-14286", "200-12585", "200-3453", "200-14426", "200-16433", "200-13888", "200-13923", "200-32704", "200-14241", "200-50961","200-501","200-28171"};
        final HashMap<String, GitLabItemMetaData> itemMetaData = GitLabUtil.getItemMetaData(credentials, Arrays.asList(items));

        final TestPackage testPackage = TestPackage.builder().setId("testPackageId").build();
        final String outputFileFullPath = outputFilePath + File.separator + testPackage.getId() + ".xml";

        try {
            createTestPackageFile(outputFileFullPath, testPackage);
            System.out.println("Successfully created the fixed form test package " + testPackage.getId() + ".xml");
        } catch (IOException e) {
            log.error("An exception occurred while creating the file {}", outputFileFullPath, e);
            throw new RuntimeException(e);
        }
    }

    private void createTestPackageFile(final String outputFilePath, final TestPackage testPackage) throws IOException {

        final File testPackageFile = new File(outputFilePath);
        xmlMapper.writeValue(testPackageFile, testPackage);
        testPackageFile.createNewFile();
    }
}
