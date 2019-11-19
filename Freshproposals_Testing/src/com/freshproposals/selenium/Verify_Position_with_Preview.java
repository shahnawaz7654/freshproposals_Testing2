package com.freshproposals.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Verify_Position_with_Preview extends Common_Methods {
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
  
 @Test(dataProvider = "User1" , priority = 0)
  
  public void login(String unm, String pwd) {
	    driver.findElement(By.id("textbox_0")).sendKeys(unm);
		driver.findElement(By.id("textbox_1")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
 
  @Test(priority = 1)
  public void openProposal() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.get("http://beta1.freshproposals.com/home/proposals/editProposal;proposalId=1151;editor=true");
	  Point img_location = driver.findElement(By.xpath("//div[@id='page1-fpImage1111201915423534']//div[@class='resizers']")).getLocation();
	  System.out.println(img_location.getX());
	  System.out.println(img_location.getY());
	  String img_zindex = driver.findElement(By.xpath("//div[@id='page1-fpImage1111201915423534mainDivTransformSafeStyle']")).getCssValue("z-index");
	  
	  System.out.println(img_location);
	  System.out.println(img_zindex);
	  Thread.sleep(2000);
	  driver.get("http://beta1.freshproposals.com/home/viewproposal/1151/preview/proposals");
	  Point img_locationP = driver.findElement(By.xpath("//div[@id='page1-fpImage1111201915423534']//div[@class='resizers']")).getLocation();
	  String img_zindexP = driver.findElement(By.xpath("//div[@id='page1-fpImage1111201915423534mainDivTransformSafeStyle']")).getCssValue("z-index");
	  System.out.println(img_locationP);
	  System.out.println(img_zindexP);
  }
  }