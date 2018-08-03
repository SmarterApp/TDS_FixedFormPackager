package tds.packager.model.xlsx;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellReference;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TestPackageSheet {
    private static final int HEADER_ROW = 1;
    private static final String INPUT_HEADER = "Input Variable";
    private final TestPackageWorkbook workbook;
    private final Sheet sheet;

    public TestPackageSheet(final TestPackageWorkbook workbook, final Sheet sheet) {
        this.workbook = workbook;
        this.sheet = sheet;
    }

    public TestPackageWorkbook getWorkbook() {
        return workbook;
    }

    private Cell getInputVariableCell(final String inputVariable, final int index) {
        final Optional<CellReference> cellOption = WorkbookUtil.getCellTypeString(sheet, inputVariable);
        final CellReference cellReference = cellOption.orElseThrow(
                () -> new RuntimeException(
                        String.format("Input Variable: '%s' Does not exist in Sheet: '%s'", inputVariable, sheet.getSheetName())));

        final Row row = sheet.getRow(cellReference.getRow());
        return row.getCell(cellReference.getCol() + index + 1);
    }

    public String getString(final String inputVariable) {
        return getString(inputVariable, 0);
    }

    public String getString(final String inputVariable, final int index) {
        final Cell cell = getInputVariableCell(inputVariable, index);
        // get the text that appears in the cell by getting the cell value and applying any data formats (Date, 0.00, 1.23e9, $1.23, etc)
        return WorkbookUtil.FORMATTER.formatCellValue(cell);
    }

    public double getNumeric(final String inputVariable, final int index) {
        final Cell cell = getInputVariableCell(inputVariable, index);
        return cell.getNumericCellValue();
    }

    public double getNumeric(final String inputVariable) {
        return getNumeric(inputVariable, 0);
    }

    public int getInputVariableColumnIndex() {
        int inputVariableCol = -1;
        final Row header = sheet.getRow(HEADER_ROW);

        // First identify the column of the input variables (this is our "y" headers)
        for (Cell cell : header) {
            if (cell.getStringCellValue().equals(INPUT_HEADER)) {
                inputVariableCol = cell.getColumnIndex();
                break;
            }
        }

        if (inputVariableCol == -1) {
            throw new IllegalArgumentException("No 'Input Variable' header cell found in the worksheet");
        }

        return inputVariableCol;
    }

    public int getTotalNumberOfInputColumns() {
        return sheet.getRow(0).getLastCellNum() - getInputVariableColumnIndex();
    }

    /**
     * Gets a map of input fields to the values at the specified column index. The column index is zero-based and
     * relative to the Input Variable column. For example, a column index of 0 corresponds to the column index of the
     * input variable column + 1.
     *
     * @param columnIndex The zero-based column index value
     * @return A map of input variable keys and values
     */
    public Map<String, String> getInputVariableValuesMap(final int columnIndex) {
        final Map<String, String> inputValuesMap = new HashMap<>();
        int inputVariableCol = getInputVariableColumnIndex();

        for (int i = HEADER_ROW + 1; i <= sheet.getLastRowNum(); i++) {
            final Row row = sheet.getRow(i);
            final int absoluteCol = inputVariableCol + columnIndex + 1;
            inputValuesMap.put(row.getCell(inputVariableCol).getStringCellValue(), row.getCell(absoluteCol).getStringCellValue());
        }

        return inputValuesMap;
    }

    public void dump() {
        WorkbookUtil.dump(sheet);
    }

    public Sheet getSheet() {
        return sheet;
    }
}