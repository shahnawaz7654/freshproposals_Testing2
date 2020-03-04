package com.freshproposals.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ellipse_Duplicate_Section extends Common_Methods {
  
	WebDriver driver;
	String width = "300";
	String height = "200";
	
	
	
	@BeforeClass
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
	 public void open_Template() throws InterruptedException{
		 Thread.sleep(5000);
		 driver.get("http://beta1.freshproposals.com/home/sections/editSection/15711");
	 
	 }
	 
	 @Test(priority = 2)
	 public void height_width() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='resizers']")).click();
		driver.findElement(By.name("textWidth11")).clear();
		driver.findElement(By.name("textWidth11")).sendKeys(width);
	    driver.findElement(By.name("height11")).clear();
	    driver.findElement(By.name("height11")).sendKeys(height);
		
		
	 }
	 
	 @Test(priority = 3)
	  public void assert_width_1() throws InterruptedException {
		 driver.findElement(By.xpath("//div[@class='resizers']")).click();
		  String actual_reflect_width = driver.findElement(By.xpath("//div[@class='resizers']")).getCssValue("width");
		  String expected_reflect_width = width+"px";
		  System.out.println("Awidth "+actual_reflect_width);
		  System.out.println("Ereflect width "+expected_reflect_width);
		  Assert.assertEquals(actual_reflect_width, expected_reflect_width);
	 }
	 
	 @Test(priority = 4)
	  public void assert_height_1() throws InterruptedException {
		 driver.findElement(By.xpath("//div[@class='resizers']")).click();
		  String actual_reflect_height = driver.findElement(By.xpath("//div[@class='resizers']")).getCssValue("height");
		  System.out.println("Aheight "+actual_reflect_height);
		  String expected_reflect_height = height+"px";
		  System.out.println("Ereflect height "+expected_reflect_height);
		  Assert.assertEquals(actual_reflect_height, expected_reflect_height);
	 }
	 
	 @Test(priority = 5)
	 public void duplicate() throws InterruptedException{
		 Thread.sleep(1000);
		 Actions action = new Actions(driver);
		 action.contextClick(driver.findElement(By.xpath("//div[@class='resizers']"))).perform();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//li[contains(text(),'Duplicate')]")).click();
	 
	 }
	 
	 @Test(priority = 6)
	 public void DragDrop() throws InterruptedException{
		 Thread.sleep(3000);
		 Actions action = new Actions(driver);
		 WebElement source = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[5]/div[1]/app-edit-section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/app-sections-page[1]/a[1]/div[1]/div[1]/div[1]/app-fpellipse[2]/div[1]/div[1]/div[1]/div[9]/div[1]"));
		 WebElement des = driver.findElement(By.xpath("//div[@id='sectionPage_15711page1']"));
		 action.clickAndHold(source).moveToElement(des, 100, 100).release().build().perform();
	 
	 }
	 
	 @Test(priority = 7)
	  public void assert_width_2() throws InterruptedException {
		 driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[5]/div[1]/app-edit-section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/app-sections-page[1]/a[1]/div[1]/div[1]/div[1]/app-fpellipse[2]/div[1]/div[1]/div[1]/div[9]/div[1]")).click();
		  String actual_reflect_width = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[5]/div[1]/app-edit-section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/app-sections-page[1]/a[1]/div[1]/div[1]/div[1]/app-fpellipse[2]/div[1]/div[1]/div[1]/div[9]/div[1]")).getCssValue("width");
		  String expected_reflect_width = width+"px";
		  System.out.println("Awidth2 "+actual_reflect_width);
		  System.out.println("Ereflect width2 "+expected_reflect_width);
		  Assert.assertEquals(actual_reflect_width, expected_reflect_width);
	 }
	 
	 @Test(priority = 8)
	  public void assert_height_2() throws InterruptedException {
		 driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[5]/div[1]/app-edit-section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/app-sections-page[1]/a[1]/div[1]/div[1]/div[1]/app-fpellipse[2]/div[1]/div[1]/div[1]/div[9]/div[1]")).click();
		  String actual_reflect_height = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[5]/div[1]/app-edit-section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/app-sections-page[1]/a[1]/div[1]/div[1]/div[1]/app-fpellipse[2]/div[1]/div[1]/div[1]/div[9]/div[1]")).getCssValue("height");
		  System.out.println("Aheight2 "+actual_reflect_height);
		  String expected_reflect_height = height+"px";
		  System.out.println("Ereflect height2 "+expected_reflect_height);
		  Assert.assertEquals(actual_reflect_height, expected_reflect_height);
	 }
	 
	 
	 
	 @Test(priority = 9)
	  public void Save() throws InterruptedException {
		  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
		  Thread.sleep(3000);
		  driver.get("http://beta1.freshproposals.com/home/sections/editSection/15711");
		  
	 }
	 
	 
	 @Test(priority = 10)
	  public void clear() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[5]/div[1]/app-edit-section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/app-sections-page[1]/a[1]/div[1]/div[1]/div[1]/app-fpellipse[2]/div[1]/div[1]/div[1]/div[9]/div[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@class='img-fluid delete-section-control']")).click();
		
	 }
	 
	 @Test(priority = 10)
	  public void reset_sign_1() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='resizers']")).click();
		driver.findElement(By.name("textWidth11")).clear();
		driver.findElement(By.name("textWidth11")).sendKeys("400");
	    driver.findElement(By.name("height11")).clear();
	    driver.findElement(By.name("height11")).sendKeys("300");
		 
	 }
	 
	 @Test(priority = 11)
	  public void Save2() throws InterruptedException {
		  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
		  Thread.sleep(3000);
		  driver.get("http://beta1.freshproposals.com/home/sections/editSection/15711");
		  
	 }
	 
	 
	 @AfterClass
	 public void closeBrowser() throws InterruptedException {
	 	  Thread.sleep(3000);
	 	  driver.close();
	 }
}
