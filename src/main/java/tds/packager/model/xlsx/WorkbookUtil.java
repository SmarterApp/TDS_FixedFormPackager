package tds.packager.model.xlsx;

import java.util.Optional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellReference;

public class WorkbookUtil {
    public static final DataFormatter FORMATTER = new DataFormatter();        

    public static Optional<CellReference> getCellTypeString(final Sheet sheet, final String value) {
        for (final Row row : sheet) {
            for (final Cell cell : row) {
                if (FORMATTER.formatCellValue(cell).equals(value)) {
                    return Optional.of(new CellReference(row.getRowNum(), cell.getColumnIndex()));
                }                
            }
        }
        return Optional.empty();
    }

    public static void dump(final Sheet sheet) {
        for (Row row : sheet) {
            for (Cell cell : row) {
                CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                
                System.out.print(cellRef.formatAsString());
                System.out.print(" - ");
    
                // get the text that appears in the cell by getting the cell value and applying any data formats (Date, 0.00, 1.23e9, $1.23, etc)
                String text = FORMATTER.formatCellValue(cell);
                System.out.println(text);
    
                // Alternatively, get the value and format it yourself
                switch (cell.getCellTypeEnum()) {
                    case STRING:
                        System.out.println(cell.getRichStringCellValue().getString());
                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            System.out.println(cell.getDateCellValue());
                        } else {
                            System.out.println(cell.getNumericCellValue());
                        }
                        break;
                    case BOOLEAN:
                        System.out.println(cell.getBooleanCellValue());
                        break;
                    case FORMULA:
                        System.out.println(cell.getCellFormula());
                        break;
                    case BLANK:
                        System.out.println();
                        break;
                    default:
                        System.out.println();
                }
            }
        }        
    }
}