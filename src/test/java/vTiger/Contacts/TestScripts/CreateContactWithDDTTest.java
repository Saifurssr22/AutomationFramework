package vTiger.Contacts.TestScripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
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

@Listeners(vTiger.GenericUtilities.ListenerImplimentataionClass.class)
public class CreateContactWithDDTTest {

	@Test
	public void CreateContactWithTest() throws IOException {

		Random ran = new Random();
		int random = ran.nextInt(1000);

		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj = new Properties();
		pobj.load(fisp);
		String Browser = pobj.getProperty("browser");
		String Url = pobj.getProperty("url");
		String Username = pobj.getProperty("username");
		String Password = pobj.getProperty("password");

		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		String ContactName = wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue() + random;

		WebDriver driver = null;

		if (Browser.equalsIgnoreCase("Chrome"))
			driver = new ChromeDriver();
		else if (Browser.equalsIgnoreCase("Firefox"))
			driver = new FirefoxDriver();
		else
			System.out.println("Invalid Browser name");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(Url);

		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(ContactName);
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (ContactHeader.contains(ContactName)) {
			System.out.println(ContactHeader);
			System.out.println("PASS");
		} else
			System.out.println("FAIL");

		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		driver.close();

	}
}
