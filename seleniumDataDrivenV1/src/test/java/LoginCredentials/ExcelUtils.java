package LoginCredentials;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	static Workbook workbook;
	static Sheet sheet;

	public ExcelUtils(String excelPath, String sheetName) {

		try {
			FileInputStream file = new FileInputStream(excelPath);
			workbook = WorkbookFactory.create(file);
			sheet = workbook.getSheet(sheetName);

		} catch (Exception e) {
			System.out.println("ERROR: Excel file not found at the specified location.");
			e.printStackTrace();
		}

	}

	public String getCellData(int rowNum, int colNum) {

		Cell cell = sheet.getRow(rowNum).getCell(colNum);

		return cell.toString();
	}

	public int getRowCount() {

		return sheet.getPhysicalNumberOfRows();
	}

}
