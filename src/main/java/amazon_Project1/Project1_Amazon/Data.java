package amazon_Project1.Project1_Amazon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Data {
	private static Sheet sheet = null;

	public static String getExcelDataX(int row, int cell) {
		if (cell == 1) {
			return "pixie doll";
		} else if (cell == 2) {
			return "B0CR998DRQ";
		}
		return "VELOCIOUS® Magic Flying Fairy Princess Doll, Flying Fairy Doll Toys for Girls, Sky Dancers Flying Pixie Dolls Induction Control Toy, Mini Drone Toys for Kids (1 Pack) and Design";
	}

	public static String getExcelData(int rowNo, int cellNo) {
		if (sheet == null) {
			initSheet();
		}
		// we will get the row.if we print row directly getting an error like print r1
		Row row = sheet.getRow(rowNo - 1);
		// here we get exact cell like row plus column
		Cell cell = row.getCell(cellNo - 1);
		// getting String value in the cell
		String cellValue = cell.getStringCellValue();
		System.out.println("Data from File @[row,cell]=[" + rowNo + ", " + cellNo + "] is : " + cellValue);
		return cellValue;
	}

	private static void initSheet() {
		FileInputStream fileIS = null;
		try {
			// java needs to know the location of the file
			fileIS = new FileInputStream("C:\\Users\\amolb\\eclipse-workspace\\Selenium\\EXCEL\\Data.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Workbook workbook = null;
		try {
			// open the excel/workbook sheet .workfactory is a classm
			workbook = WorkbookFactory.create(fileIS);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// exact sheet we needs to open
		sheet = workbook.getSheet("logindetails");
	}
}
