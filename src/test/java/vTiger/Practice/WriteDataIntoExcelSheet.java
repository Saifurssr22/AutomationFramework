package vTiger.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelSheet {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = new FileInputStream("D:\\Selenium folder\\TestData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Organization");
		
		Row rw = sh.getRow(4);
		
		Cell ce = rw.createCell(7);
		
		ce.setCellValue("Qspiders");
		
		FileOutputStream fos = new FileOutputStream("D:\\Selenium folder\\TestData.xlsx");
		
		wb.write(fos);
		
		System.out.println("Data is added");
	}
}
