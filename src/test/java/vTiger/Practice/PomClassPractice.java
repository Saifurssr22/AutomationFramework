package vTiger.Practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import vTiger.ObjectRepositary.CreateNewOrganizationsPage;
import vTiger.ObjectRepositary.HomePage;
import vTiger.ObjectRepositary.LoginPage;
import vTiger.ObjectRepositary.OrgInfoPage;
import vTiger.ObjectRepositary.OrganizationsPage;

public class PomClassPractice {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:8888");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		LoginPage lp = new LoginPage(driver);
		
	//	lp.getUserNameEdt().sendKeys("admin");
	//	lp.getPassWordEdt().sendKeys("admin");
	//	lp.getSubmitBtn().click();
		
		lp.loginToApplicatio("admin", "admin");
	
		HomePage hp = new HomePage(driver);
		
		hp.getOrgnizationsLnk().click();
		
		OrganizationsPage op = new OrganizationsPage(driver);
		
		op.getCreateOrgLookUpImg().click(); 
		
		CreateNewOrganizationsPage cop = new CreateNewOrganizationsPage(driver);
		
		cop.getOrgNameEdt().sendKeys("Saifur");
		cop.getSaveBtn();
		
		OrgInfoPage oip = new OrgInfoPage(driver);
		String OrgName = oip.getConformationTxt().getText();
		
		if(OrgName.equalsIgnoreCase("saifur"))
		{
			System.out.println(OrgName);
		System.out.println("Pass");
		}
		else
			System.out.println("Fail");
		
		driver.close();
		  
	}
}
