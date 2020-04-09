package com.freshproposals.selenium;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.asm.Advice.Enter;

public class Gmail_Testing extends Common_Methods{
	WebDriver driver;
	String unm;
	String pwd;
	
	 @BeforeClass
	  public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		openURL(driver);
	
	}
	 
	 @Test(dataProvider = "User1", priority = 0)
	 public void SetUnmPwd(String unm, String pwd) {
         login(unm, pwd, driver);
	 }
	  
	  @Test(priority = 1)
	  public void ExtendsMethods() throws InterruptedException {
		  createTemplate(driver);
		  contentLibrary(driver);
		  generateProposalButton(driver);
		  proposalName(driver);
		  //Automation Client
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//div[@id='content']//div[5]//div[2]//label[1]//span[1]")).click();
		  scrollWindow(driver);
		  calender(driver);
		  sendNextButton(driver);
		  sendEmail(driver);
		  
	  }
	 
	 @Test(priority = 2)
	 public void Gmail_login() {
		 driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
         
		 driver.findElement(By.name("identifier")).sendKeys("zenincloud@gmail.com");
         String actual_name = driver.findElement(By.name("identifier")).getAttribute("value");
         String expected_name = "zenincloud@gmail.com";
         Assert.assertEquals(actual_name, expected_name);
         
		 driver.findElement(By.id("identifierNext")).click();
		 
		 driver.findElement(By.name("password")).sendKeys("ZenInCloud@123");
		 String actual_password = driver.findElement(By.name("password")).getAttribute("value");
		 String expected_password = "ZenInCloud@123";
		 Assert.assertEquals(actual_password, expected_password);
		 driver.findElement(By.id("passwordNext")).click();
	 }
	 
	 @Test(priority = 3)
	 public void Search() throws InterruptedException {
		 Thread.sleep(2000);
		 //driver.findElement(By.name("q")).sendKeys("Selenium Subject" + Keys.ENTER);
		 Thread.sleep(2000);
		 //driver.findElement(By.xpath("/html[1]/body[1]/div[7]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[4]/div[2]/div[1]/table[1]/tbody[1]/tr[1]")).click();
		 driver.findElement(By.xpath("/html[1]/body[1]/div[10]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.linkText("View Our Business Proposal")).click();
		 Thread.sleep(2000);
	 }
	 
	 @AfterClass
	  public void closeBrowser() throws InterruptedException {
		 quitBrowser(driver);
	  }
	  
}
