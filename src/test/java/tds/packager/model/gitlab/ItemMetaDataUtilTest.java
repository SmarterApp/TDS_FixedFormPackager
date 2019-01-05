package tds.packager.model.gitlab;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


public class ItemMetaDataUtilTest {

    @Test
    public void shouldReadElaLegacyStandardPublication() throws Exception {
        String metadata = readMetadataFile("/ELA-legacy-only-metadata.xml");
        ItemMetaDataUtil itemMetaDataUtil = new ItemMetaDataUtil(metadata);
        assertThat("Not ELA v1", itemMetaDataUtil.getPrimaryStandard().startsWith("SBAC-ELA-v1:"));
    }

    @Test
    public void shouldReadElaLEnhancedStandardPublication() throws Exception {
        String metadata = readMetadataFile("/ELA-enhanced-metadata.xml");
        ItemMetaDataUtil itemMetaDataUtil = new ItemMetaDataUtil(metadata);
        assertThat("Not ELA enhanced", itemMetaDataUtil.getRawPrimaryStandard().startsWith("E."));
        assertThat("Not ELA v1", itemMetaDataUtil.getPrimaryStandard().startsWith("SBAC-ELA-v1:"));
    }

    @Test
    public void shouldReadMathLegacyStandardPublication() throws Exception {
        String metadata = readMetadataFile("/MATH-legacy-only-metadata.xml");
        ItemMetaDataUtil itemMetaDataUtil = new ItemMetaDataUtil(metadata);
        assertThat("Not Math v6", itemMetaDataUtil.getPrimaryStandard().startsWith("SBAC-MA-v6:"));
    }

    @Test
    public void shouldReadMathLEnhancedStandardPublication() throws Exception {
        String metadata = readMetadataFile("/MATH-enhanced-metadata.xml");
        ItemMetaDataUtil itemMetaDataUtil = new ItemMetaDataUtil(metadata);
        assertThat("Not Math enhanced", itemMetaDataUtil.getRawPrimaryStandard().startsWith("M."));
        assertThat("Not Math v6", itemMetaDataUtil.getPrimaryStandard().startsWith("SBAC-MA-v6:"));
    }

    @Test
    public void shouldErrorOnMissingPrimaryStandard() throws Exception {
        String metadata = readMetadataFile("/No-standard-publication-metadata.xml");
        ItemMetaDataUtil itemMetaDataUtil = new ItemMetaDataUtil(metadata);
        try {
            itemMetaDataUtil.getPrimaryStandard();
            fail("Expected an error for missing Standard Publication section");
        } catch (RuntimeException re) {
            // Expected path
        }
    }

    private String readMetadataFile(final String fileName) throws IOException {
        File metadataFile = new File(ItemMetaDataUtilTest.class.getResource(fileName).getFile());
        return FileUtils.readFileToString(metadataFile, "iso-8859-1");
    }
}
