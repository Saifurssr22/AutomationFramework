package vTiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage // Rule 1: Create a pom class for every web page
// Rule 2: Class na should be the title of page and ending with page

{

	// Rule 3: Identify the WebElements using @FindBy, @FindBys, @FindAll
	// annotations
	@FindBy(name = "user_name")
	private WebElement UserNameEdt;

	@FindBy(name = "user_password")
	private WebElement PassWordEdt;

	@FindBy(id = "submitButton")
	private WebElement SubmitBtn;

	// Rule 4: Create a Constructor to Initialise the variable/web element
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Rule 5: Provide getters to access the web element
	public WebElement getUserNameEdt() {
		return UserNameEdt;
	}

	public WebElement getPassWordEdt() {
		return PassWordEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

	// Business Library - Generic Methods - for this application
	/**
	 * This method will login to the application
	 * 
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApplicatio(String USERNAME, String PASSWORD) {
		UserNameEdt.sendKeys(USERNAME);
		PassWordEdt.sendKeys(PASSWORD);
		SubmitBtn.click();
	}
}
