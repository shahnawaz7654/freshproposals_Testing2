package com.freshproposals.selenium;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import bsh.commands.dir;

public class F2B2 extends Common_Methods {
	WebDriver driver;
	String fname = "SEL";
	String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	
	
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
 public void Backward() throws InterruptedException {
	 driver.get("http://beta1.freshproposals.com/home/sections/editSection/4775");
	 Thread.sleep(2000);
	 Actions action = new Actions(driver);
	 
	 System.out.println("1");
	 String B_Backward_img = driver.findElement(By.xpath("//div[@id='page1-fpImage1031201911175112mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("Before Backward Img "+B_Backward_img);
	 String B_Backward_text = driver.findElement(By.xpath("//div[@id='page1-fpText103120191116468mainDivTransformSafeStyle']")).getCssValue("z-index");
     System.out.println("Before Backward Img, Text "+B_Backward_text);
     
	 //image - backward
	 driver.findElement(By.xpath("//div[@class='resizers']//img")).click();
     action.contextClick(driver.findElement(By.xpath("//div[@class='resizers']//img"))).perform();
     Thread.sleep(3000);
	 //driver.findElement(By.xpath("//button[@class='dropdown-item']")).click();
	 driver.findElement(By.xpath("//li[contains(text(),'Send a step backward')]")).click();
	 Thread.sleep(3000);
	 String A_Backward_img = driver.findElement(By.xpath("//div[@id='page1-fpImage1031201911175112mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("After Backward Img "+A_Backward_img);
	 String A_Backward_text = driver.findElement(By.xpath("//div[@id='page1-fpText103120191116468mainDivTransformSafeStyle']")).getCssValue("z-index");
     System.out.println("After Backward Img, Text "+A_Backward_text);
     
     int img = Integer.parseInt(A_Backward_img);
     int text = Integer.parseInt(A_Backward_text);
     
     Assert.assertTrue(text>img);
     }
 

 @Test(priority = 2)
 public void Back() throws InterruptedException {
	 Thread.sleep(1000);
	 Actions action = new Actions(driver);
	 
	 System.out.println("2");
	 String B_Back_sign = driver.findElement(By.xpath("//div[@id='page1-fpSign1031201911163941mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("Before Back Signature "+B_Back_sign);
	 String B_Back_shape = driver.findElement(By.xpath("//div[@id='page1-fpShape1031201911162297mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("Before Back Signature, Shape "+B_Back_shape);
	 
	 //signature - back
	 //action.contextClick(driver.findElement(By.xpath("//div[@id='page1-fpSign1031201911163941']"))).perform();
	 action.contextClick(driver.findElement(By.id("page1-fpSign1031201911163941"))).perform();
	 Thread.sleep(1000);
	 //driver.findElement(By.xpath("//button[contains(text(),'Position')]")).click();
	 //driver.findElement(By.cssSelector("div.wrapper div.main-no-sidebar:nth-child(5) div.apply-hidden.styling-mode-effect div.section-editor-box div.editor-top-margin.col-lg-8.offset-lg-2:nth-child(2) div.page-scalemargin- div.editor-card-box div.page-wrapper div.page.effect8 div.card div.context-menu:nth-child(6) ul.context-menu li.dropdown-submenu ul.dropdown-menu > li.dropdown-item:nth-child(4)")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//li[contains(text(),'Send to back')]")).click();
	 
	 String A_Back_sign = driver.findElement(By.xpath("//div[@id='page1-fpSign1031201911163941mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("After Back Signature "+A_Back_sign);
	 String A_Back_shape = driver.findElement(By.xpath("//div[@id='page1-fpShape1031201911162297mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("After Back Shape "+A_Back_shape);
	 
	 String A_Back_img = driver.findElement(By.xpath("//div[@id='page1-fpImage1031201911175112mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("After Back Signature,Img "+A_Back_img);
	 String A_Back_text = driver.findElement(By.xpath("//div[@id='page1-fpText103120191116468mainDivTransformSafeStyle']")).getCssValue("z-index");
     System.out.println("After Back Signature,Text "+A_Back_text);
     
     int sign = Integer.parseInt(A_Back_sign);
     int shape = Integer.parseInt(A_Back_shape);
     
     Assert.assertTrue(shape>sign);
     
	  }


 @Test(priority = 3)
 public void Front() throws InterruptedException {
	 Thread.sleep(1000);
	 Actions action = new Actions(driver);
	 
	 System.out.println("3");
	 String B_Front_img = driver.findElement(By.xpath("//div[@id='page1-fpImage1031201911175112mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("Before Front Img "+B_Front_img);
	 String B_Front_text = driver.findElement(By.xpath("//div[@id='page1-fpText103120191116468mainDivTransformSafeStyle']")).getCssValue("z-index");
     System.out.println("Before Front Img, Text "+B_Front_text);
     
	 //img - front
	 action.contextClick(driver.findElement(By.xpath("//div[@class='resizers']//img"))).perform();
	 Thread.sleep(1000);
	 //driver.findElement(By.xpath("//button[contains(text(),'Position')]")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//li[contains(text(),'Bring to front')]")).click();
	 
	 String A_Front_img = driver.findElement(By.xpath("//div[@id='page1-fpImage1031201911175112mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("After Front Img "+A_Front_img);
	 String A_Front_text = driver.findElement(By.xpath("//div[@id='page1-fpText103120191116468mainDivTransformSafeStyle']")).getCssValue("z-index");
     System.out.println("After Front Img, Text "+A_Front_text);
     
     String A_Front_sign = driver.findElement(By.xpath("//div[@id='page1-fpSign1031201911163941mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("After front Img, Signature "+A_Front_sign);
	 String A_Back_shape = driver.findElement(By.xpath("//div[@id='page1-fpShape1031201911162297mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("After Front Img, Shape "+A_Back_shape);
     
     int img = Integer.parseInt(A_Front_img);
     int text = Integer.parseInt(A_Front_text);
     
     Assert.assertTrue(img>text);
	 
	  }


 @Test(priority = 4)
 public void Forward() throws InterruptedException {
	 Thread.sleep(1000);
	 Actions action = new Actions(driver);
	 
	 System.out.println("4");
	 String B_Forward_text = driver.findElement(By.xpath("//div[@id='page1-fpText103120191116468mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("Before Forward Text "+B_Forward_text);
	 String B_Forward_img = driver.findElement(By.xpath("//div[@id='page1-fpImage1031201911175112mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("Before Forward Text, Img "+B_Forward_img);
	 
	 //textbox - forward
	 action.contextClick(driver.findElement(By.xpath("//div[@class='fr-element fr-view']"))).perform();
	 Thread.sleep(1000);
	 //driver.findElement(By.xpath("//button[contains(text(),'Position')]")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//li[contains(text(),'Bring a step forward')]")).click();
	 
	 String A_Forward_text = driver.findElement(By.xpath("//div[@id='page1-fpText103120191116468mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("After Forward Text "+A_Forward_text);
	 String A_Forward_img = driver.findElement(By.xpath("//div[@id='page1-fpImage1031201911175112mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("After Forward Text, Img "+A_Forward_img);
	 
	 int img = Integer.parseInt(A_Forward_img);
     int text = Integer.parseInt(A_Forward_text);
     
     Assert.assertTrue(text>img);
	  }

@AfterClass
public void closeBrowser() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.quit();
}
}
