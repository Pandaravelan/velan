package mytest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Program {
	WebDriver driver;
	
	
	@BeforeMethod
	public void setup()
	{
	System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("https://amazon.in");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
	
	@Test
	public void verifyGoogleTitle()
	{
	driver.get("https://www.amazon.in");	
	String pageTitle=driver.getTitle();	
	Assert.assertEquals(pageTitle,"amazon");
	}
	
	
	@Test
	public void verifyLogo()
	{
	boolean flag=driver.findElement(By.xpath("//a[@id= 'nav-logo-sprites']")).isDisplayed();
	
	Assert.assertTrue(flag);
	}
	
	@AfterMethod
	public void tearDown()
	{
	driver.quit();
	}

}
