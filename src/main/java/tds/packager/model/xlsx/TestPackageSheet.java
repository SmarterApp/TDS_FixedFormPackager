package tds.packager.model.xlsx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellReference;

public class TestPackageSheet {
    private static final int HEADER_ROW = 1;
    private static final String INPUT_HEADER = "Input Variable";
    private final TestPackageWorkbook workbook;
    private final Sheet sheet;
    private final DataFormatter formatter;

    public TestPackageSheet(final TestPackageWorkbook workbook, final Sheet sheet) {
        this.workbook = workbook;
        this.sheet = sheet;
        this.formatter = new DataFormatter();
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

    public String[] getStrings(final String inputVariable) {
        final int inputVariableIndex = getInputVariableColumnIndex();
        final List<String> values = new ArrayList<>();

        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (formatter.formatCellValue(row.getCell(inputVariableIndex)).equals(inputVariable)) {

                for (int j = inputVariableIndex + 1; j < row.getLastCellNum(); j++) {
                    values.add(formatter.formatCellValue(row.getCell(j)));
                }

                break;
            }
        }

        return values.toArray(new String[values.size()]);
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
        return sheet.getRow(0).getLastCellNum() - getInputVariableColumnIndex() - 1;
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

        for (int i = HEADER_ROW + 1; i <= sheet.getLastRowNum() && sheet.getRow(i) != null ; i++) {
            final Row row = sheet.getRow(i);
            final int absoluteCol = inputVariableCol + columnIndex + 1;
            inputValuesMap.put(formatter.formatCellValue(row.getCell(inputVariableCol)), formatter.formatCellValue(row.getCell(absoluteCol)));
        }

        return inputValuesMap;
    }

    private List<String> getColumn(final int rowIndex, final int columnIndex) {
        final int lastRowNum = sheet.getLastRowNum()-1;
        final Stream<Cell> cells = IntStream.range(rowIndex, lastRowNum).mapToObj(i -> {
            final Row row = sheet.getRow(i);
            if (row != null) {
                return row.getCell(columnIndex);
            }
            return null;
        });

        List<String> column = cells.map(cell -> WorkbookUtil.FORMATTER.formatCellValue(cell)).collect(Collectors.toList());
        return column;
    }

    private List<List<String>> getColumns(final int rowIndex, final int startColumnIndex) {
        final Row row = sheet.getRow(rowIndex);
        final short lastColumIndex = row.getLastCellNum();
        final Stream<List<String>> columns = IntStream.range(startColumnIndex, lastColumIndex-1).mapToObj(i -> getColumn(rowIndex, i));
        return columns.collect(Collectors.toList());
    }

    public List<List<String>> getColumns() {
        final Optional<CellReference> cellRefOption = WorkbookUtil.getCellTypeString(sheet, "Input Variable");
        final CellReference cellRef = cellRefOption.orElseThrow(
            () -> new IllegalArgumentException("Fixed Form Packager requires each sheet to have 'Input Variable'"));
        return getColumns(cellRef.getRow()+1, cellRef.getCol());
    }

    private List<Pair<String, String>> zipColumn(final List<String> names, final List<String> values) {
        final List<Pair<String, String>> zipped = new ArrayList<>();
        IntStream.range(0, names.size()).forEach(i -> {
            final String value = values.get(i);
            if (StringUtils.isNoneBlank(value)) {
                zipped.add(Pair.of(names.get(i), values.get(i)));
            }
        });
        return zipped;
    }

    public List<List<Pair<String, String>>> getColumnPairs() {
        final List<List<String>> columns = getColumns();
        final List<String> names = columns.get(0);
        columns.remove(0);
        return columns.stream().map(col -> zipColumn(names, col)).collect(Collectors.toList());
    }

    public void dump() {
        WorkbookUtil.dump(sheet);
    }

    public Sheet getSheet() {
        return sheet;
    }
}