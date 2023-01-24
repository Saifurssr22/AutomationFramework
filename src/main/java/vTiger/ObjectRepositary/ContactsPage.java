package vTiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement CreateContactLookUpImg;

	@FindBy(name = "search_text")
	private WebElement SearchContactEdt;

	@FindBy(name = "submit")
	private WebElement SearchContactBtn;

	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateContactLookUpImg() {
		return CreateContactLookUpImg;
	}

	public WebElement getSearchContactEdt() {
		return SearchContactEdt;
	}

	public WebElement getSearchContactBtn() {
		return SearchContactBtn;
	}

	// Business Library
	/**
	 * This method will click on create contact look up image
	 */
	public void clickOnCreateContactLookUpImg() {
		CreateContactLookUpImg.click();
	}
}
