package vTiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import vTiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {

	// Declaration
	@FindBy(linkText = "Organizations")
	private WebElement OrgnizationsLnk;

	@FindBy(linkText = "Contacts")
	private WebElement ContactsLnk;

	@FindBy(linkText = "Products")
	private WebElement ProductsLnk;

	@FindBy(linkText = "Opportunities")
	private WebElement OpportunitiesLnk;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;

	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLink;

	// Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization

	public WebElement getOrgnizationsLnk() {
		return OrgnizationsLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getProductsLnk() {
		return ProductsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}

	public WebElement getSignOutLink() {
		return SignOutLink;
	}

	// Business Library
	/**
	 * This method will click on Organizations Link
	 */
	public void clickOrganizationLink()
	{
		OrgnizationsLnk.click();
	}
	/**
	 * This method will Click on Contacts
	 */
	public void clickToContactsLink() {
		ContactsLnk.click();
	}

	/**
	 * This method will Click on Oppertunities
	 */
	public void clickToOppertunitiesLink() {
		OpportunitiesLnk.click();
	}

	/**
	 * This Method will click on Products
	 */
	public void clickToProductsLink() {
		ProductsLnk.click();
	}

	/**
	 * This method will log out application
	 */
	public void logiutOfApp(WebDriver driver) {
		mouseHoverAction(driver, AdministratorImg);
		SignOutLink.click();
	}

}