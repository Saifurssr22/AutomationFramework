package vTiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ContactHeaderTxt;

	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactHeaderTxt() {
		return ContactHeaderTxt;
	}

	// Business library
	/**
	 * This method will capture the contact header and return the value.
	 * 
	 * @return
	 */
	public String getContactHeader() {
		return getContactHeaderTxt().getText();
	}
}