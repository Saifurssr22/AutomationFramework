package vTiger.Product.TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import vTiger.GenericUtilities.BaseClass;

public class CreateProductSTest extends BaseClass {

	@Test
	public void CreateProductTest() throws Exception {

		// Read the Data
		String PRODUCTNAME = eUtil.readDataFromExcel("Products", 1, 2) + jUtil.getRandomNumber();
		String VENDORNAME = eUtil.readDataFromExcel("Products", 4, 3) + jUtil.getRandomNumber();

		// step 5; Naviagte to Vendors
		WebElement element = driver.findElement(By.linkText("More"));
		wUtil.mouseHoverAction(driver, element);
		driver.findElement(By.xpath("//a[@name='Vendors']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Vendor...']")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(VENDORNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		String VendorHeader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if (VendorHeader.contains(VENDORNAME)) {
			System.out.println(VendorHeader);
			System.out.println("Vendor Successfully Created");
		} else
			System.out.println("Vendor not Created");

		// step 5: Navigate Products Link
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt=\'Create Product...\']")).click();
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(PRODUCTNAME);

		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		wUtil.switchToWindow(driver, "Vendors");

		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(VENDORNAME);
		driver.findElement(By.xpath("//input[@type='button']")).click();
		driver.findElement(By.xpath("//a[text()='" + VENDORNAME + "']")).click();

		wUtil.switchToWindow(driver, "Product");

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Step 9: Validate for Contact
		String ProductHeader = driver.findElement(By.xpath("//span[@class='//span[@class='lvtHeaderText']']"))
				.getText();
		if (ProductHeader.contains(PRODUCTNAME)) {
			System.out.println(ProductHeader);
			System.out.println("PASS");
		} else
			System.out.println("FAIL");
	}
}