package com.freshproposals.selenium;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class F2B2_Multiple extends Common_Methods {
	WebDriver driver;
	String fname = "SEL";
	String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	
	
  @BeforeTest
  public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		driver.get("http://beta1.freshproposals.com");
	}
  
 @Test(dataProvider = "User1" , priority = 0)
  
  public void login(String unm, String pwd) {
	    driver.findElement(By.id("textbox_0")).sendKeys(unm);
		driver.findElement(By.id("textbox_1")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
 
 @Test(priority = 1)
 public void Backward() throws InterruptedException {
	 driver.get("http://beta1.freshproposals.com/home/sections/editSection/4780");
	 Thread.sleep(2000);
	 Actions action = new Actions(driver);
	 action.contextClick(driver.findElement(By.xpath("//div[@class='fr-element fr-view']"))).perform();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//button[contains(text(),'Position')]")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//li[contains(text(),'Send a step backward')]")).click();
	 //second page click
	 //driver.findElement(By.xpath("//div[@id='content']//li[2]//a[1]")).click();
	 }
 
 @Test(priority = 2)
 public void Back() throws InterruptedException {
	 Thread.sleep(1000);
	 Actions action = new Actions(driver);
	 action.contextClick(driver.findElement(By.xpath("//div[@class='resizers']//img"))).perform();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//button[contains(text(),'Position')]")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//li[contains(text(),'Send to back')]")).click();
	 }
 
 @Test(priority = 3)
 public void Forward() throws InterruptedException {
	 Thread.sleep(2000);
	//second page click
	 driver.findElement(By.xpath("//div[@id='content']//li[2]//a[1]")).click();
	 Thread.sleep(1000);
	 Actions action = new Actions(driver);
	 action.contextClick(driver.findElement(By.xpath("//div[@id='page2-fpSign103120191444833']"))).perform();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//button[contains(text(),'Position')]")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//li[contains(text(),'Bring a step forward')]")).click();
	 
	 }
 
 @Test(priority = 4)
 public void Front() throws InterruptedException {
	 Thread.sleep(1000);
	 Actions action = new Actions(driver);
	 action.contextClick(driver.findElement(By.xpath("//div[@id='page2-fpImage1031201914441969']//div[@class='resizers']"))).perform();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//button[contains(text(),'Position')]")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//li[contains(text(),'Bring to front')]")).click();
	 
	 }
 

@AfterTest
public void closeBrowser() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.close();
}
}
