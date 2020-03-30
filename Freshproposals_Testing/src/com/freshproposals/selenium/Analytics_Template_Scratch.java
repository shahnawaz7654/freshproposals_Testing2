package com.freshproposals.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Analytics_Template_Scratch extends Common_Methods {
	
	WebDriver driver;
	
	//variables
	
	String e_time = "2 m 10 s";
	String e_view = "1";
	
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
  public void createTemplate() throws InterruptedException {
	  Thread.sleep(10000);
	  driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/1574");
	  Thread.sleep(5000);
	  
	}
  
  @Test(priority = 2)
  public void extendsMethods() throws InterruptedException {
	   generateProposalButton(driver);
	   proposalName(driver);
	   client(driver);
	   scrollWindow(driver);
	   calender(driver);
	   sendNextButton(driver);
	   analyticsCopyLink(driver);
  }
  
  
  @Test(priority = 4)
  public void Summary() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//img[@src='../../../assets/cancel-round.svg']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//a[@class='email-template-back']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//ul[@class='nav left-navbar']//button[@class='nav-link btn back-btn'][contains(text(),'Back')]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//img[@src='../../assets/proposal-summary-icon.png']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//a[@id='ngb-tab-2']")).click();
  }
  
  @Test(priority = 5)
  public void extendsMethods2() throws InterruptedException {
	 getSummaryData(driver);

  }
  
  @Test(priority = 6)
  public void Assert_time() throws InterruptedException {
	  Thread.sleep(2000);
	  Assert.assertEquals(time, e_time);
	  
  }
  
  @Test(priority = 7)
  public void Assert_view() throws InterruptedException {
	  Thread.sleep(2000);
	  Assert.assertEquals(view, e_view);
	  
  }
  
 
  @AfterClass
  public void closeBrowser() throws InterruptedException {
	  quitBrowser(driver);
  }
  
  
}
