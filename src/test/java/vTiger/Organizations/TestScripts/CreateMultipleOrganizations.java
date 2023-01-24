package vTiger.Organizations.TestScripts;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import vTiger.GenericUtilities.BaseClass;
import vTiger.ObjectRepositary.CreateNewOrganizationsPage;
import vTiger.ObjectRepositary.HomePage;
import vTiger.ObjectRepositary.OrgInfoPage;
import vTiger.ObjectRepositary.OrganizationsPage;

@Listeners(vTiger.GenericUtilities.ListenerImplimentataionClass.class)
public class CreateMultipleOrganizations extends BaseClass {
	@Test(dataProvider = "orgName")
	public void createMultipleOrgTest(String ORG, String Industry) throws Exception {
		String ORGNAME = ORG + jUtil.getRandomNumber();

		// step 5: Click on organization link
		HomePage hp = new HomePage(driver);
		hp.clickOrganizationLink();

		// step 6: click on create organization look up image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();

		// step 7: create organization with mandatory feilds and with industry and save
		CreateNewOrganizationsPage cop = new CreateNewOrganizationsPage(driver);
		cop.createNewOrganization(ORGNAME, Industry);

		// step 8; Validate
		OrgInfoPage oip = new OrgInfoPage(driver);
		String OrgHeader = oip.getOrganizationHeader();

		if (OrgHeader.contains(ORGNAME)) {
			System.out.println(OrgHeader);
			System.out.println("PASS");
		} else
			System.out.println("FAIL");
	}

	@DataProvider(name = "orgName")
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		Object[][] data = eUtil.readMultipleData("MultiOrg");
		return data;
	}
}