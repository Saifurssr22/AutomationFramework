package vTiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement CreateOrgLookUpImg;

	@FindBy(name = "search_text")
	private WebElement SearchOrgEdt;

	@FindBy(name = "submit")
	private WebElement SearchOrgBtn;

	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrgLookUpImg() {
		return CreateOrgLookUpImg;
	}

	public WebElement getSearchOrgEdt() {
		return SearchOrgEdt;
	}

	public WebElement getSearchOrgBtn() {
		return SearchOrgBtn;
	}

	/**
	 * This mwthod will click on organization look up image
	 */
	public void clickOnCreateOrgLookUpImg() {
		CreateOrgLookUpImg.click();
	}

}
