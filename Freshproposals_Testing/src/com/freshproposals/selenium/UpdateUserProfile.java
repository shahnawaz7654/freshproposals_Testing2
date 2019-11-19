package com.freshproposals.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UpdateUserProfile extends Common_Methods {
	WebDriver driver;
	
	 @BeforeTest
	  public void openBrowser() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			driver.get("http://beta1.freshproposals.com");
		}
	
	 @Test(dataProvider = "User2" , priority = 0)
	  
	  public void login(String unm, String pwd) {
		    driver.findElement(By.id("textbox_0")).sendKeys(unm);
			driver.findElement(By.id("textbox_1")).sendKeys(pwd);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		}
	 @Test(priority=1)
	 public void uploadProfile() throws AWTException, InterruptedException {
		 driver.findElement(By.xpath("//a[@class='nav-link user-dp']//img")).click();
		 driver.findElement(By.xpath("//a[contains(text(),'User Profile')]")).click();
		 WebElement butn =driver.findElement(By.xpath("//i[@class='fa fa-camera upload-button']"));
		 StringSelection sel = new StringSelection("C:\\Users\\User\\Desktop\\images.jpg");
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
		 butn.click();
		 Robot robot = new Robot();
		 //press enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyPress(KeyEvent.VK_ENTER);
		 Thread.sleep(3000);
		 // paste fully qualified file path
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_V);

		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.keyRelease(KeyEvent.VK_V);
		 //press enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 Thread.sleep(10000);
		 String expected="";
		String actual= driver.findElement(By.xpath("//div[@id='toast']//div")).getText();
		 Thread.sleep(10000);
		 System.out.println(actual);
		 Assert.assertEquals(actual, expected);
	 }
	 @Test(priority=2)
	 public void updateUserProfile() throws InterruptedException {
		 driver.findElement(By.xpath("//a[@class='nav-link user-dp']//img")).click();
		 driver.findElement(By.xpath("//a[contains(text(),'User Profile')]")).click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//button[@class='btn send-btn float-right ml-2']")).click();
		 Thread.sleep(5000);
		 WebElement FirstName=driver.findElement(By.xpath("//input[@formcontrolname='firstName']"));
		 
		 FirstName.sendKeys("Nikeeta123");
		 WebElement LastName= driver.findElement(By.xpath("//input[@formcontrolname='LastName']"));
		 LastName.sendKeys("Shelar");
		 WebElement MobileNo=driver.findElement(By.xpath("//input[@formcontrolname='ContactNumber']"));
		 MobileNo.clear();
		 MobileNo.sendKeys("8888812345");
		 WebElement Title = driver.findElement(By.xpath("//input[@formcontrolname='Title']"));
		 Title.clear();
		 Title.sendKeys("This is the title which is not editable");
		 WebElement btn = driver.findElement(By.xpath("//button[@class='btn next-btn float-right ml-2']"));
		 btn.click();
	 //btn.click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//div[@class=\"back-profile\"]//button")).click();
		 Thread.sleep(5000);
		 
	 }
	 @Test(priority=3)
	 public void logout() throws InterruptedException {
		 String expected="http://beta1.freshproposals.com/";
		 driver.findElement(By.xpath("//a[@class='nav-link user-dp']//img")).click();
		 driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
		 Thread.sleep(5000);
		String actual= driver.getCurrentUrl();
		System.out.println(expected);
		System.out.println(actual);
		//Assert.assertNotEquals(unexpected, expected);
		Assert.assertEquals(actual,expected);
		driver.quit();
	 }
	
	

}
