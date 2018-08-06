package tds.packager.model.xlsx;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestPackageWorkbook {
    private final XSSFWorkbook workbook;
    public TestPackageWorkbook(final XSSFWorkbook workbook) {
        this.workbook = workbook;
    }

    public XSSFWorkbook getWorkbook() {
        return workbook;
    }
    
    public TestPackageSheet getSheet(final String name) {
        return new TestPackageSheet(this, workbook.getSheet(name));
    }
    
    public void dump() {        
        final Iterator<Sheet> itr = workbook.sheetIterator();
        while( itr.hasNext()) {
            Sheet sheet = itr.next();
            WorkbookUtil.dump(sheet);
        }
    }
}