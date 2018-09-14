import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;

public class ExcelReader {

    public static final String SAMPLE_XLSX_FILE_PATH = "stores.xlsx";

    public static void main(String[] args) throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));
        Sheet sheet1 = workbook.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        String storeList = "(";
        for (Row row: sheet1) {
            for(Cell cell: row) {
                String cellValue = dataFormatter.formatCellValue(cell);
                storeList = storeList + "\"" +cellValue + "\",";
            }
        }
        storeList = storeList + ")";
        System.out.println(storeList);
        workbook.close();
    }
}