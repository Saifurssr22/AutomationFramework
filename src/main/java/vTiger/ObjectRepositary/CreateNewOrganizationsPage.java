package vTiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import vTiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationsPage extends WebDriverUtility {

	@FindBy(name = "accountname")
	private WebElement OrgNameEdt;

	@FindBy(xpath = "//select[@name='industry']")
	private WebElement IndustryDropDown;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	public CreateNewOrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getIndustryDropDown() {
		return IndustryDropDown;
	}

	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	/**
	 * This method will create new organization and save
	 * 
	 * @param OrgName
	 */
	public void createNewOrganization(String OrgName) {
		OrgNameEdt.sendKeys(OrgName);
		SaveBtn.click();
	}

	/**
	 * This method will create new organization with industry
	 * 
	 * @param OrgName
	 * @param industry
	 */
	public void createNewOrganization(String OrgName, String industry) {
		OrgNameEdt.sendKeys(OrgName);
		handleDropDown(IndustryDropDown, industry);
		SaveBtn.click();
	}
}