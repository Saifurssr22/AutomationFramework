package vTiger.GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * this class consists of Generic Methods Related to Property File
 * @author SAIF
 *
 */
public class PropertyFileUtility {

	/**
	 * this method will read data from property File and return the value
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public String readDataFromPropertyFile(String key) throws Exception
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value; 
	}
}
