package com.freshproposals.selenium;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Send_Proposal_Temp extends Common_Methods{
	WebDriver driver;
	
  @BeforeClass
  public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		driver.get("http://beta1.freshproposals.com");
	  //startBrowser(driver);
	 
	}
  
 @Test(dataProvider = "User1" , priority = 0)
  
  public void login(String unm, String pwd) {
	    driver.findElement(By.id("textbox_0")).sendKeys(unm);
		driver.findElement(By.id("textbox_1")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
  
  @Test(priority = 1)
  public void extendsMethods() throws InterruptedException {
	   createTemlate(driver);
	   contentLibrary(driver);
	   generateProposalButton(driver);
	   proposalName(driver);
	   client(driver);
	   scrollWindow(driver);
	   calender(driver);
	   sendNextButton(driver);
	   
  }
  
  @Test(priority = 2)
  public void sendEmail() throws InterruptedException {
	  Thread.sleep(5000);
      driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("Selenium Subject");
	  driver.findElement(By.xpath("//div[@class='fr-box fr-basic fr-top']//div[@class='fr-element fr-view']"))
	  .sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
				+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,"
				+ " when an unknown printer took a galley of type and scrambled it to make a type specimen book."
				+ "Lorem Ipsum is simply dummy text of the printing and typesetting industry."
				+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s");
	  Thread.sleep(2000);
	  //send btn
	  driver.findElement(By.linkText("Send")).click();
 
  }
  
  @AfterClass
  public void closeBrowser() throws InterruptedException {
	 quitBrowser(driver);
  }
  
  
}
