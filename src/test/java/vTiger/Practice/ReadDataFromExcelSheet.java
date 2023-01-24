package vTiger.Practice;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Organization");
		
		Row rw = sh.getRow(4);
		
		Cell ce = rw.getCell(3);
		Cell ce1 = rw.getCell(2);
		
		System.out.println(ce.getStringCellValue());
		System.out.println(ce1.getStringCellValue());
	}
}