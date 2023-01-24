package vTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row; 
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook; 
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of Generic Methods related to EXcel sheet
 * @author LENOVO
 *
 */
public class ExcelFileUtility {
	
	/**
	 * This method will read data from excel sheet and return the value
	 * @param Sheet
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Exception
	 */
	public String readDataFromExcel(String Sheet, int rowNo, int cellNo) throws Exception
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheet); 
		Row rw = sh.getRow(rowNo);
		Cell ce = rw.getCell(cellNo);
		String value = ce.getStringCellValue();
		return value;
	}
	
	/**
	 * This method will provide the row count when the specific sheet is provided
	 * @param Sheet
	 * @return
	 * @throws Exception
	 */
	public int getRowCount(String Sheet) throws Exception
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheet); 
		int rowcount = sh.getLastRowNum(); 
		return rowcount;
	}
	
	/**
	 * This Method will write data into Excel Sheet
	 * @param Sheet
	 * @param rowNo
	 * @param cellNo
	 * @throws Exception
	 */
	public void writeDataIntoExcel(String Sheet, int rowNo, int cellNo, String Value) throws Exception
	{
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheet);
		Row rw = sh.getRow(rowNo);
		Cell ce = rw.createCell(cellNo);
		ce.setCellValue(Value);
		
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		wb.write(fos);
		wb.close();  
	}
	
	/**
	 * This method will read multiple data from the excel sheet
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleData(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		int lastCel = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCel];
		
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCel;j++)
			{
				data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();	
			}
		}
		return data;
	}
} 
