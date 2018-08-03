package tds.packager.mapper;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import tds.packager.model.xlsx.TestPackageWorkbook;

public class MapperBaseTest {
    protected TestPackageWorkbook mockWorkbook;

    @Before
    public void setup() throws Exception {
        mockWorkbook = new TestPackageWorkbook(new XSSFWorkbook(
                this.getClass().getResourceAsStream("/SBAC-IAB-FIXED-G11M-Winter-2017-2018.xlsx")));
    }
}
