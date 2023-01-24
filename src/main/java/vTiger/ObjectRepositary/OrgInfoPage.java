package vTiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrgHeaderTxt;

	public OrgInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getConformationTxt() {
		return OrgHeaderTxt;
	}

	public String getOrganizationHeader() {
		return OrgHeaderTxt.getText();
	}
}