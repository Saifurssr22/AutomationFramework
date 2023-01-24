package vTiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

	@Test(dataProvider = "phone")
	public void addProductToCartTest(String phone, int price, String model)
	{
		System.out.println(phone+" "+price+" "+model);
	}
	
	@DataProvider(name = "phone")
	public Object[][] getData()
	{
		Object[][] data = new Object[2][3];
		
		data[0][0] = "Samsung";
		data[0][1] = 12000;
		data[0][2] = "A80";
		
		data[1][0] = "IQoo z3";
		data[1][1] = 15000;
		data[1][2] = "Z3 5G";
		
		return data;
	}
}
