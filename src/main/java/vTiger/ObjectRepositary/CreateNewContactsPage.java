package vTiger.ObjectRepositary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactsPage extends WebDriverUtility {

	@FindBy(name = "lastname")
	private WebElement LastNameEdt;

	@FindBy(name = "leadsource")
	private WebElement LeadSourceDropDown;

	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement OrganizationImg;

	@FindBy(name = "search_text")
	private WebElement searchEdt;

	@FindBy(name = "search")
	private WebElement searchBtn;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	public CreateNewContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getLeadSourceDropDown() {
		return LeadSourceDropDown;
	}

	public WebElement getOrganizationImg() {
		return OrganizationImg;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	// Business Library
	/**
	 * This method will create contact with mandatory fields
	 * 
	 * @param lastname
	 */
	public void createNewContact(String lastName) {
		LastNameEdt.sendKeys(lastName);
		SaveBtn.click();
	}

	/**
	 * This method will create contact with organization
	 * 
	 * @param driver
	 * @param LastName
	 * @param OrgName
	 */
	public void createNewContact(WebDriver driver, String lastName, String OrgName) {
		LastNameEdt.sendKeys(lastName);
		OrganizationImg.click();
		switchToWindow(driver, "Accounts");
		searchEdt.sendKeys(OrgName);
		searchBtn.click();
		driver.findElement(By.xpath("// a[text()='" + OrgName + "']")).click();
		switchToWindow(driver, "Contacts");
		SaveBtn.click();
	}
}
