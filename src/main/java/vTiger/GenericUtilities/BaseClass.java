package vTiger.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepositary.HomePage;
import vTiger.ObjectRepositary.LoginPage;

/**
 * This class contains all the basic configaration annotations
 * 
 * @author LENOVO
 *
 */
public class BaseClass {

	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver;	//this is used for tacking screenshot in listeners
	
	@BeforeSuite(groups = {"RegressionSuite" , "SmokeSuite"})
	public void bsConfig() {
		System.out.println("=== DataBase connection successful ===");
	}

	@BeforeTest
	//@BeforeClass(groups = {"RegressionSuite" , "SmokeSuite"})
	public void bcConfig() throws Exception {
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");

		if (BROWSER.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			sdriver=driver;
			System.out.println("=== " + BROWSER + " Launch successful===");
		} else if (BROWSER.equalsIgnoreCase("Firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			sdriver=driver;
			System.out.println("====" + BROWSER + " Launch successful=====");

		} else {
			System.out.println("invalid browser name");
		}
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
	}
	
	@BeforeMethod(groups = {"RegressionSuite" , "SmokeSuite"})
	public void bmConfig() throws Exception
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplicatio(USERNAME, PASSWORD);
		System.out.println("==== login successful =====");
	}
	
	@AfterMethod(groups = {"RegressionSuite" , "SmokeSuite"})
	public void amConfig()
	{
		HomePage hp = new HomePage(driver);
		hp.logiutOfApp(driver);
		System.out.println("==== logout successful ====");
	}
	
	@AfterTest
	//@AfterClass(groups = {"RegressionSuite" , "SmokeSuite"})
	public void acConfig()
	{
		driver.quit();
		System.out.println("==== browswer Closed =====");
	}
	
	@AfterSuite(groups = {"RegressionSuite" , "SmokeSuite"})
	public void asConfig()
	{
		System.out.println("==== Database Connection closed ====");
	}
}