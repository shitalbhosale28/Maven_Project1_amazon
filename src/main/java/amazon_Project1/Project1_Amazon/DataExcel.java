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
import org.testng.annotations.DataProvider;

public class DataExcel {
	public static String readExcel(int rowno, int cellno) {

		FileInputStream f1 = null;
		try {
			f1 = new FileInputStream("C:\\Users\\amolb\\eclipse-workspace\\Selenium\\EXCEL\\Data.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // java needs to know the location of the file
		Workbook w1 = null;
		try {
			w1 = WorkbookFactory.create(f1);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // open the excel/workbook sheet .workfactory is a classm
		Sheet s1 = w1.getSheet("logindetails");// exact sheet we needs to open
		Row r1 = s1.getRow(rowno);// we will get the row.if we print row directly getting an error likr print r1
		// System.out.println(r1);
		Cell c1 = r1.getCell(cellno);// here we get exact cell like row plus column
		String username = c1.getStringCellValue();// getting values in the cell
		System.out.println(username);

		return username;
	}

	public static String readusername() {
		return readExcel(0, 0);
	}

	public static String password() {
		return readExcel(0, 1);
	}

	@DataProvider(name = "usernamepass")
	public Object[][] userpassfromexcel() {

		Object[][] d = new Object[3][2];
		// username1and passsword
		d[0][0] = readExcel(0, 0);
		d[0][1] = readExcel(0, 1);
		// username2and passsword
		d[1][0] = readExcel(1, 0);
		d[1][1] = readExcel(1, 1);
		// usernamepassword3
		d[2][0] = readExcel(2, 0);
		d[2][1] = readExcel(2, 1);
		return d;
	}

}
