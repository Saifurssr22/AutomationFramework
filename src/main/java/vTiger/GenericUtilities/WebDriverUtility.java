package vTiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions; 
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of Generic Methods related to Web driver Actions
 * @author LENOVO
 *
 */
public class WebDriverUtility {

	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will wait for 20 seconds for all the elements to get loaded
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	/**
	 * This method will wait until a particular element becomes visible
	 * @param driver
	 */
	public void waitForElementToBeVisisble(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This element will wait until a particular element becomes click able
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	 
	/**
	 * This Method will handleDropDown by using index
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This method will handle the drop down using value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value)
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This method will handle the drop down using text
	 * @param element
	 * @param text
	 */
	public void handleDropDown(String text, WebElement element)
	{
		Select s = new Select(element);
		s.selectByVisibleText(text);;
	}
	
	/** 
	 * This method will move to element where ever you want
	 * @param driver
	 * @param elementTarget
	 */
	public void mouseHoverAction(WebDriver driver, WebElement elementTarget)
	{
		Actions act = new Actions(driver);
		act.moveToElement(elementTarget).perform();;
	}
	
	/**
	 * This method will perform double click anywhere on page
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This Method will perform double click on a specific element
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver, WebElement element)
	{

		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will perform drag from source to target
	 * @param driver
	 * @param elementSource
	 * @param elementTarget
	 */
	public void dragAndDropAction(WebDriver driver, WebElement elementSource, WebElement elementTarget)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(elementSource, elementTarget).perform();;
	}
	
	/**
	 * This method will perfrom drag from source to particular place
	 * @param driver
	 * @param elementSource
	 * @param xOffSet
	 * @param yOffSet
	 */
	public void dragAndDropByOffUsingOffSets(WebDriver driver, WebElement elementSource, int xOffSet, int yOffSet)
	{ 
		Actions act = new Actions(driver);
		act.dragAndDropBy(elementSource, xOffSet, yOffSet).perform();;
	} 
	
	/**
	 * This method will Right click operation in web page
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();;
	}
	 
	/**
	 * This method will Right click operation in particular element
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();;
	}
	 
	/**
	 * This method will switch to frame based on the index
	 * @param driver
	 * @param frameIndex
	 */
	public void switchToFrame(WebDriver driver, int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
	}
	
	/**
	 * This method will switch to frame based on the frame name or frame Id
	 * @param driver
	 * @param frameIDorName
	 */
	public void switchToFrame(WebDriver driver, String frameIDorName)
	{
		driver.switchTo().frame(frameIDorName);
	}
	
	/**
	 * This method will switch to frame based on web element
	 * @param driver
	 * @param frameElement
	 */
	public void switchToFrame(WebDriver driver, WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	 
	/**
	 * This method will switch back to immidiate parent frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch back to default frame
	 * @param driver
	 */
	public void switchTODefaultContent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method will accept the alert pop up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will dismiss the alert pop up 
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will get the text of alert pop up and return it to caller
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This Method will switch to the window based on partial window title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWindowTitle)
	{
		//step 1: capture all the window IDs
		Set<String> winIds = driver.getWindowHandles();
		
		//step 2: Extract individual window Id
		for(String winID : winIds)
		{
			//step 3: Capture the current Window Title
			String currentTitle = driver.switchTo().window(winID).getTitle();
		
			//step 4: Compare the current window title with required Title
		if(currentTitle.contains(partialWindowTitle))
			break;
		
		}
	}
	
	/**
	 * This method will take Screen shots and store it in a folder
	 * @param driver
	 * @param ScreenShotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver driver, String ScreenShotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShots\\"+ScreenShotName+".png");
		FileUtils.copyFile(src, dst);
		
		return dst.getAbsolutePath();
	}
	
	/**
	 * This method will scroll downwords randomly
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	
	/**
	 * This method will scroll downwords until the specific element
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
} 
