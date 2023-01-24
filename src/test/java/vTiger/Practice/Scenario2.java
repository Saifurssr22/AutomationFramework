package vTiger.Practice;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Scenario2 {
	
	public static void main(String[] args) throws Exception {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:8888/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement element = driver.findElement(By.xpath("//input[@type='text']"));
		
		element.sendKeys("admin", Keys.TAB,"admin", Keys.ENTER);
		
		driver.findElement(By.xpath("(//td[@class='tabUnSelected'])[3]")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.xpath("(//input[@class='detailedViewTextBox'])[1]")).sendKeys("Qspideer");

		WebElement element1 = driver.findElement(By.xpath("//select[@name='industry']"));
		
		element1.click();
		
		Select s1 = new Select(element1);
		
		s1.selectByValue("Energy");
		
		WebElement element2 = driver.findElement(By.xpath("//select[@name='accounttype']"));
		
		element2.click();
		
		Select s2 = new Select(element2);
		
		s2.selectByValue("Customer");
		
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
		
		
		driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]")).click();

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}
