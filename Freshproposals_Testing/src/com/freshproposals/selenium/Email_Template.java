package com.freshproposals.selenium;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Email_Template extends Common_Methods {
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
		//driver.get(url);
	}
  
  @Test(priority = 1)
  public void createEmailTemplate() throws InterruptedException {
	  driver.findElement(By.linkText("SETTINGS")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[contains(text(),'Email Template')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='../../../assets/add-plus-button.svg']")).click();
		//driver.findElement(By.xpath("//p[contains(text(),'Add')]")).click();
		Thread.sleep(2000);
		Select select = new Select(driver.findElement(By.xpath("//*[@id=\"content\"]/div/app-email-template/div/div/div/form/div/div/div/div/div[1]/div[1]/div[2]/select")));
		select.selectByIndex(0);
		String actual_type =  select.getFirstSelectedOption().getText();
		String expected_type = "Initiating Email";
		Assert.assertEquals(actual_type, expected_type);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("I am Initiating Email");
      
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[starts-with(@id,'bold')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[starts-with(@id,'italic')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[starts-with(@id,'underline')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/app-email-template/div/div/div/form/div/div/div/div/div[1]/div[3]/div[2]/div/div[3]/div"))
		.sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
				+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,"
				+ " when an unknown printer took a galley of type and scrambled it to make a type specimen book."
				+ "Lorem Ipsum is simply dummy text of the printing and typesetting industry."
				+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s");
		Thread.sleep(2000);
		
  }
  
//  @Test(priority = 2)
//  public void paragraph_Style() throws InterruptedException {
//		//pargraph heading 1
//	    driver.findElement(By.xpath("//button[starts-with(@id,'paragraphFormat')]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.linkText("Heading 1")).click();
//		String actual_heading1 = driver.findElement(By.linkText("Heading 1")).getAttribute("title");
//		String expected_heading1 = "Heading 1";
//		Assert.assertEquals(actual_heading1, expected_heading1);
//        Thread.sleep(1000);
//		//heading 2
//		driver.findElement(By.xpath("//button[starts-with(@id,'paragraphFormat')]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.linkText("Heading 2")).click();
//		String actual_heading2 = driver.findElement(By.linkText("Heading 2")).getAttribute("title");
//		String expected_heading2 = "Heading 2";
//		Assert.assertEquals(actual_heading2, expected_heading2);
//		Thread.sleep(1000);
//		//heading 3
//		driver.findElement(By.xpath("//button[starts-with(@id,'paragraphFormat')]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.linkText("Heading 3")).click();
//		String actual_heading3 = driver.findElement(By.linkText("Heading 3")).getAttribute("title");
//		String expected_heading3 = "Heading 3";
//		Assert.assertEquals(actual_heading3, expected_heading3);
//		Thread.sleep(1000);
//		//heading 4
//		driver.findElement(By.xpath("//button[starts-with(@id,'paragraphFormat')]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.linkText("Heading 4")).click();
//        String actual_heading4 = driver.findElement(By.linkText("Heading 4")).getAttribute("title");
//        String expected_heading4 = "Heading 4";
//        Assert.assertEquals(actual_heading4, expected_heading4);
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//button[starts-with(@id,'paragraphFormat')]")).click();
//        Thread.sleep(1000);
//		//code
//		driver.findElement(By.linkText("Code")).click();
//		String actual_code = driver.findElement(By.linkText("Code")).getAttribute("title");
//		String expected_code = "Code";
//		Assert.assertEquals(actual_code, expected_code);
//		Thread.sleep(1000);
//  }
//  
//  @Test(priority = 3)
//  public void align() throws InterruptedException {
//		//align
//		driver.findElement(By.xpath("//button[starts-with(@id,'align')]")).click();
//		//align left
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//a[@title='Align Left']")).click();
//		Thread.sleep(1000);
//		//align
//		driver.findElement(By.xpath("//button[starts-with(@id,'align')]")).click();
//		//align right
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//a[@title='Align Right']")).click();
//		Thread.sleep(1000);
//		//align
//		driver.findElement(By.xpath("//button[starts-with(@id,'align')]")).click();
//		//align justify
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//a[@title='Align Justify']")).click();
//		Thread.sleep(1000);
//		//align
//		driver.findElement(By.xpath("//button[starts-with(@id,'align')]")).click();
//		//align center
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//a[@title='Align Center']")).click();
//		Thread.sleep(1000);
//  }
//  
//  @Test(priority = 4)
//  public void line_Height() throws InterruptedException {
//		//line height
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'lineHeight')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.linkText("Default")).click();
//	  String actual_default = driver.findElement(By.linkText("Default")).getAttribute("title");
//	  String expected_default = "Default";
//	  Assert.assertEquals(actual_default, expected_default);
//	  
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'lineHeight')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.linkText("Single")).click();
//	  String actual_single = driver.findElement(By.linkText("Single")).getAttribute("title");
//	  String expected_single = "Single";
//	  Assert.assertEquals(actual_single, expected_single);
//	  
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'lineHeight')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.linkText("1.15")).click();
//	  String actual_digit1 = driver.findElement(By.linkText("1.15")).getAttribute("title");
//	  String expected_digit1 = "1.15";
//	  Assert.assertEquals(actual_digit1, expected_digit1);
//	  
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'lineHeight')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.linkText("1.5")).click();
//	  String actual_digit2 = driver.findElement(By.linkText("1.5")).getAttribute("title");
//	  String expected_digit2 = "1.5";
//	  Assert.assertEquals(actual_digit2, expected_digit2);
//	  
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'lineHeight')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.linkText("Double")).click();
//	  String actual_double = driver.findElement(By.linkText("Double")).getAttribute("title");
//	  String expected_double = "Double";
//	  Assert.assertEquals(actual_double, expected_double);
//	  
//  }
//  
//  @Test(priority = 5 )
//  public void order_List() throws InterruptedException {
//		
//		//order list
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'formatOLOptions')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.linkText("Default")).click();
//	  String actual_default = driver.findElement(By.linkText("Default")).getAttribute("title");
//	  String expected_default = "Default";
//	  Assert.assertEquals(actual_default, expected_default);
//	  
//	  
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'formatOLOptions')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//a[contains(text(),'Lower Alpha')]")).click();
//	  String actual_loweralpha = driver.findElement(By.xpath("//a[contains(text(),'Lower Alpha')]")).getAttribute("title");
//	  String expected_loweralpha = "Lower Alpha";
//	  Assert.assertEquals(actual_loweralpha, expected_loweralpha);
//	  
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'formatOLOptions')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//a[contains(text(),'Lower Greek')]")).click();
//	  String actual_lowergreek = driver.findElement(By.xpath("//a[contains(text(),'Lower Greek')]")).getAttribute("title");
//	  String expected_lowergreek = "Lower Greek";
//	  Assert.assertEquals(actual_lowergreek, expected_lowergreek);
//	  
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'formatOLOptions')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//a[contains(text(),'Lower Roman')]")).click();
//	  String actual_lowerroman = driver.findElement(By.xpath("//a[contains(text(),'Lower Roman')]")).getAttribute("title");
//	  String expected_lowerroman = "Lower Roman";
//	  Assert.assertEquals(actual_lowerroman, expected_lowerroman);
//	  
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'formatOLOptions')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//a[contains(text(),'Upper Alpha')]")).click();
//	  String actual_upperalpha = driver.findElement(By.xpath("//a[contains(text(),'Upper Alpha')]")).getAttribute("title");
//	  String expected_upperalpha = "Upper Alpha";
//	  Assert.assertEquals(actual_upperalpha, expected_upperalpha);
//	  
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'formatOLOptions')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//a[contains(text(),'Upper Roman')]")).click();
//	  String actual_upperroman = driver.findElement(By.xpath("//a[contains(text(),'Upper Roman')]")).getAttribute("title");
//	  String expected_upperroman = "Upper Roman";
//	  Assert.assertEquals(actual_upperroman, expected_upperroman);
//  
//  }
  
  @Test(priority = 6)
  public void unorderList() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'formatULOptions')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("Default")).click();
	  String actual_default = driver.findElement(By.linkText("Default")).getAttribute("title");
	  String expected_default = "Default";
	  Assert.assertEquals(actual_default, expected_default);
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'formatULOptions')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[contains(text(),'Circle')]")).click();
	  String actual_circle = driver.findElement(By.xpath("//a[contains(text(),'Circle')]")).getAttribute("title");
	  String expected_circle = "Circle";
	  Assert.assertEquals(actual_circle, expected_circle);
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'formatULOptions')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[contains(text(),'Disc')]")).click();
	  String actual_disc = driver.findElement(By.xpath("//a[contains(text(),'Disc')]")).getAttribute("title");
	  String expected_disc = "Disc";
	  Assert.assertEquals(actual_disc, expected_disc);
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'formatULOptions')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[contains(text(),'Square')]")).click();
	  String actual_square = driver.findElement(By.xpath("//a[contains(text(),'Square')]")).getAttribute("title");
	  String expected_square = "Square";
	  Assert.assertEquals(actual_square, expected_square);
	
  }

  @AfterTest
  public void closeBrowser() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.close();
  }
  
  
}
