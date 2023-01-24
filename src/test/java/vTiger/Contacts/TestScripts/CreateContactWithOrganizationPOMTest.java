package vTiger.Contacts.TestScripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import vTiger.GenericUtilities.BaseClass;
import vTiger.ObjectRepositary.ContactInfoPage;
import vTiger.ObjectRepositary.ContactsPage;
import vTiger.ObjectRepositary.CreateNewContactsPage;
import vTiger.ObjectRepositary.CreateNewOrganizationsPage;
import vTiger.ObjectRepositary.HomePage;
import vTiger.ObjectRepositary.OrgInfoPage;
import vTiger.ObjectRepositary.OrganizationsPage;

@Listeners(vTiger.GenericUtilities.ListenerImplimentataionClass.class)
public class CreateContactWithOrganizationPOMTest extends BaseClass {

	@Test(groups = "SmokeSuite")
	public void CreateContactWithOrgTest() throws Exception {

		// Read the Data
		String CONTACTNAME = eUtil.readDataFromExcel("Contacts", 7, 2) + jUtil.getRandomNumber();
		String ORGNAME = eUtil.readDataFromExcel("Contacts", 7, 3) + jUtil.getRandomNumber();

		// step 5: Click on organization link
		HomePage hp = new HomePage(driver);
		hp.clickOrganizationLink();

		// step 6: click on create organization look up image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();

		// step 7: create organization with mandatory feilds and with industry and save
		CreateNewOrganizationsPage cop = new CreateNewOrganizationsPage(driver);
		cop.createNewOrganization(ORGNAME);

		// step 8; Validate
		OrgInfoPage oip = new OrgInfoPage(driver);
		String OrgHeader = oip.getOrganizationHeader();

		if (OrgHeader.contains(ORGNAME)) {
			System.out.println(OrgHeader);
			System.out.println("Organizatio Created");
		} else
			System.out.println("FAIL");

		// Step 5: Click to contacts link
		hp.clickToContactsLink();

		// step 6: Click on Create Contact LookUp img
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();

		// step 6: click on create contacts look up image
		CreateNewContactsPage ccp = new CreateNewContactsPage(driver);
		ccp.createNewContact(driver, CONTACTNAME, ORGNAME);

		// Step 7: Validate for Contact
		ContactInfoPage cip = new ContactInfoPage(driver);
		String ContactHeader = cip.getContactHeader();

		if (ContactHeader.contains(CONTACTNAME)) {
			System.out.println(ContactHeader);
			System.out.println("PASS");
		} else
			System.out.println("FAIL");

	}
}