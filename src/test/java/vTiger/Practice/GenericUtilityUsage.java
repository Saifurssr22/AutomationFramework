package vTiger.Practice;

import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityUsage {

	public static void main(String[] args) throws Exception {
		
		JavaUtility ju = new JavaUtility();
		int data = ju.getRandomNumber();
		System.out.println(data);
		
		String date = ju.getSystemDate();
		System.out.println(date);
		
		String Date = ju.getSystemDateInFormat();
		System.out.println(Date);
		
		PropertyFileUtility pfu = new PropertyFileUtility();
		System.out.println(pfu.readDataFromPropertyFile("url"));
		System.out.println(pfu.readDataFromPropertyFile("browser"));
		System.out.println(pfu.readDataFromPropertyFile("username"));
		System.out.println(pfu.readDataFromPropertyFile("password")); 
		
		ExcelFileUtility efu = new ExcelFileUtility();
		System.out.println(efu.readDataFromExcel("Contacts", 1, 2));
		System.out.println(efu.readDataFromExcel("Organization", 1, 2));
		
		System.out.println(efu.getRowCount("Organization"));
		System.out.println(efu.getRowCount("Contacts"));
		
		efu.writeDataIntoExcel("Organization", 1, 3, "SAIF");
		efu.writeDataIntoExcel("Contacts", 1, 3, "SAIFUR");  
		
	}   
}
