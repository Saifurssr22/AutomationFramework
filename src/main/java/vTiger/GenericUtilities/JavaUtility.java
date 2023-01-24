package vTiger.GenericUtilities;

import java.util.Date;
import java.util.Random;

/** Description
 * 
 * This class consists of Generic Methods related to Java
 * 
 * @author SAIF
 *
 */
public class JavaUtility {

	/**
	 * This Method will generate a Random Number for every run
	 * @author SAIF
	 */
	public int getRandomNumber()
	{
		Random r = new Random(); 
		int value = r.nextInt(1000);
		return value;
	}

	/**
	 * This method will provide the system date
	 * @author SAIF
	 */

	public String getSystemDate()
	{
	Date d = new Date();
	String value = d.toString();
	return value;
	}
	
	/**
	 * This method will provide the system date in required format
	 * @author SAIF
	 */
	public String getSystemDateInFormat()
	{
		Date d = new Date();
		String[] darf = d.toString().split(" ");
		String date = darf[2];
		String month = darf[1];
		String year = darf[5];
		String time = darf[3].replace(":", "-");
		String dateInFormat = date+"-"+month+"-"+year+"-"+time;
		return dateInFormat;
	}	
}