package com.freshproposals.selenium;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class F2B2 extends Common_Methods {
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
	 driver.get("http://beta1.freshproposals.com/home/sections/editSection/4775");
	 Thread.sleep(2000);
	 Actions action = new Actions(driver);
	 //image - backward
	 action.contextClick(driver.findElement(By.xpath("//div[@class='resizers']//img"))).perform();
	 String Bimg_z = driver.findElement(By.xpath("//div[@id='page1-fpImage1031201911175112mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("Before backward img, z index = "+Bimg_z);
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//button[contains(text(),'Position')]")).click();
	 driver.findElement(By.xpath("//button[contains(text(),'Position')]")).getCssValue("z-index");
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//li[contains(text(),'Send a step backward')]")).click();
	 String Aimg_z = driver.findElement(By.xpath("//div[@id='page1-fpImage1031201911175112mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("After backward img, z index = "+Aimg_z);

	 }
 
 @Test(priority = 2)
 public void Back() throws InterruptedException {
	 Thread.sleep(1000);
	 Actions action = new Actions(driver);
	 //signature - back
	 action.contextClick(driver.findElement(By.xpath("//div[@id='page1-fpSign1031201911163941']"))).perform();
	 String Bsign_z = driver.findElement(By.xpath("//div[@id='page1-fpSign1031201911163941mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("Before back signature, z index = "+Bsign_z);
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//button[contains(text(),'Position')]")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//li[contains(text(),'Send to back')]")).click();
	 String Asign_z = driver.findElement(By.xpath("//div[@id='page1-fpSign1031201911163941mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("After back signature, z index = "+Asign_z);
	
	 
	  }


@Test(priority = 3)
public void Front() throws InterruptedException {
	 Thread.sleep(1000);
	 Actions action = new Actions(driver);
	 //img - front
	 action.contextClick(driver.findElement(By.xpath("//div[@class='resizers']//img"))).perform();
	 String Bimg2_z = driver.findElement(By.xpath("//div[@id='page1-fpImage1031201911175112mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("Before Front img, z index = "+Bimg2_z);
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//button[contains(text(),'Position')]")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//li[contains(text(),'Bring to front')]")).click();
	 String Aimg2_z = driver.findElement(By.xpath("//div[@id='page1-fpImage1031201911175112mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("After front img, z index = "+Aimg2_z);
	 
	  }


@Test(priority = 4)
public void Forward() throws InterruptedException {
	 Thread.sleep(1000);
	 Actions action = new Actions(driver);
	 //textbox - forward
	 action.contextClick(driver.findElement(By.xpath("//div[@class='fr-element fr-view']"))).perform();
	 String Btextbox_z = driver.findElement(By.xpath("//div[@id='page1-fpText103120191116468mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("Before Front textbox, z index = "+Btextbox_z);
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//button[contains(text(),'Position')]")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//li[contains(text(),'Bring a step forward')]")).click();
	 String Atextbox_z = driver.findElement(By.xpath("//div[@id='page1-fpText103120191116468mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("Before Front textbox, z index = "+Atextbox_z);
	  }

@AfterTest
public void closeBrowser() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.close();
}
}
