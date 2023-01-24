package vTiger.Organizations.TestScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(vTiger.GenericUtilities.ListenerImplimentataionClass.class)
public class CreateOrganizationWithDDTTest {

	@Test
	public void CreateOrgWithDDTTest() throws IOException {

		Random ran = new Random();
		int random = ran.nextInt(1000);

		// step 1: Read All the Data
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj = new Properties();
		pobj.load(fisp);
		String Browser = pobj.getProperty("browser");
		String Url = pobj.getProperty("url");
		String Username = pobj.getProperty("username");
		String Password = pobj.getProperty("password");

		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		String OrgName = wb.getSheet("Organization").getRow(1).getCell(2).getStringCellValue() + random;

		// step 2: Launching the Browser
		WebDriver driver = null;

		if (Browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();

		else if (Browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else
			System.out.println("Invalid Browser Name");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(Url);

		// step 3: Login to Application
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();

		// step 4: click on Organization link
		driver.findElement(By.xpath("(//td[@class='tabUnSelected'])[3]")).click();

		// step 5: click on create organization lookup image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// step 6: create organization with mandatory fields
		driver.findElement(By.xpath("(//input[@class='detailedViewTextBox'])[1]")).sendKeys(OrgName);

		// step 7: save
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();

		// step 8: validate
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (OrgHeader.contains(OrgName)) {
			System.out.println(OrgHeader);
			System.out.println("PASS");
		} else
			System.out.println("FAIL");

		// Step 8: Logout of Application
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		// step 9: close the browser
		driver.close();
	}
}
