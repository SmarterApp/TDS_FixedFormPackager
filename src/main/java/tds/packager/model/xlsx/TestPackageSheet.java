package tds.packager.model.xlsx;

import java.util.Iterator;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestPackageSheet {
    private final TestPackageWorkbook workbook;
    private final Sheet sheet;

    public TestPackageSheet(final TestPackageWorkbook workbook, final Sheet sheet) {
        this.workbook = workbook;
        this.sheet = sheet;
    }

    public TestPackageWorkbook getWorkbook() {
        return workbook;
    }

    private Cell getInputVariableCell(final String inputVariable) {
        final Optional<CellReference> cellOption = WorkbookUtil.getCellTypeString(sheet, inputVariable);
        final CellReference cellReference = cellOption.orElseThrow(
            () -> new RuntimeException(
                String.format("Input Variable: '%s' Does not exist in Sheet: '%s'", inputVariable, sheet.getSheetName())));        

        final Row row = sheet.getRow(cellReference.getRow());
        return row.getCell(cellReference.getCol() + 1);
    }

    public String getString(final String inputVariable) {
        final Cell cell = getInputVariableCell(inputVariable);
        // get the text that appears in the cell by getting the cell value and applying any data formats (Date, 0.00, 1.23e9, $1.23, etc)
        return WorkbookUtil.FORMATTER.formatCellValue(cell);
    }

    public double getNumeric(final String inputVariable) {
        final Cell cell = getInputVariableCell(inputVariable);
        return cell.getNumericCellValue();
    }
        
    public void dump() {
        WorkbookUtil.dump(sheet);
    }
}