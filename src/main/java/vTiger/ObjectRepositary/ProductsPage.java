package vTiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement CreateProductBtn;

	@FindBy(name = "search_text")
	private WebElement SearchProductEdt;

	@FindBy(name = "submit")
	private WebElement SearchProductBtn;

	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateProductBtn() {
		return CreateProductBtn;
	}

	public WebElement getSearchProductEdt() {
		return SearchProductEdt;
	}

	public WebElement getSearchProductBtn() {
		return SearchProductBtn;
	}

}
