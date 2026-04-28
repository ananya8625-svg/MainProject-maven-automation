package Agile_Project;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static String getData(String path, int row, int col) {
        String value = "";

        try {
            FileInputStream fis = new FileInputStream(path);
            Workbook wb = new XSSFWorkbook(fis);
            Sheet sheet = wb.getSheetAt(0);

            DataFormatter formatter = new DataFormatter();
            value = formatter.formatCellValue(sheet.getRow(row).getCell(col));

            wb.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }
}
