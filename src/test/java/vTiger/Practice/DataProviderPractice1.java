package vTiger.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepositary.CreateNewOrganizationsPage;
import vTiger.ObjectRepositary.HomePage;
import vTiger.ObjectRepositary.LoginPage;
import vTiger.ObjectRepositary.OrgInfoPage;
import vTiger.ObjectRepositary.OrganizationsPage;

public class DataProviderPractice1 {

	@Test(dataProvider = "input")
	public void createOrgWithIndustry(String OrgName, String IndustryName) throws Exception {
		// Step 1: Create Object Of all the required libraries
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();

		// Step 2: Read all the required Data
		String URL = pUtil.readDataFromPropertyFile("url");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");

		// Step 3: Launch the browser
		WebDriver driver = null;

		if (BROWSER.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (BROWSER.equalsIgnoreCase("Firefox"))
			driver = new FirefoxDriver();
		else
			System.out.println("invalid browser name");

		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);

		// Step 4: Login to App
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplicatio(USERNAME, PASSWORD);

		// step 5: Click on organization link
		HomePage hp = new HomePage(driver);
		hp.clickOrganizationLink();

		// step 6: click on create organization look up image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();

		// step 7: create organization with mandatory feilds and with industry and save
		CreateNewOrganizationsPage cop = new CreateNewOrganizationsPage(driver);
		cop.createNewOrganization(OrgName, IndustryName);

		// step 8; Validate
		OrgInfoPage oip = new OrgInfoPage(driver);
		String OrgHeader = oip.getOrganizationHeader();

		if (OrgHeader.contains(OrgName)) {
			System.out.println(OrgHeader);
			System.out.println("PASS");
		} else
			System.out.println("FAIL");

		// step 9: logout of application
		hp.logiutOfApp(driver);

		// step 10: Close the browser
		driver.close();

	}

	@DataProvider(name = "input")
	public Object[][] getData() {
		Object[][] data = new Object[5][2];

		data[0][0] = "Wipro111";
		data[0][1] = "Chemicals";

		data[1][0] = "TCS111";
		data[1][1] = "Banking";

		data[2][0] = "TechMahindra111";
		data[2][1] = "Education";

		data[3][0] = "Genpact111";
		data[3][1] = "Healthcare";

		data[4][0] = "CapGemini111";
		data[4][1] = "Insurance";

		return data;
	}
}
