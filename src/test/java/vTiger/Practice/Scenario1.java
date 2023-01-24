package vTiger.Practice;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario1 {
	
	public static void main(String[] args) throws Exception {
		
		//Step 1: Launch the browser
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Step 2: Login to Application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3: Click on contacts link
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 4: Click on create contact look up image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//Step 5: create Contact with mandatory fields
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Rahaman");
		
		//Step 6: save
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		//Step 7: Validate
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(contactHeader.contains("Rahaman"))
		{
		System.out.println(contactHeader);
		System.out.println("PASS");
		}
		else
			System.out.println("FAIL");
		
		//Step 8: Logout of Application
		WebElement	element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}
