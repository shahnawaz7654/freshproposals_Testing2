package com.freshproposals.selenium;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class Won_Proposal_Verification extends Common_Methods {
	WebDriver driver;
	String unm;
	String pwd;
	String Get_Won;
	String Verify_Won;
	
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
	 public void SetUnmPwd(String unm, String pwd){
      login(unm, pwd, driver);
	 }
  
  @Test(priority = 1)
  public void Dashboard_Get_Won_Value() throws InterruptedException {
	  Thread.sleep(10000);
	  driver.findElement(By.id("linkDashboard")).click();
	  Get_Won = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[5]/div[1]/app-dashboard[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/p[1]")).getText();
	  System.out.println("Before Won "+Get_Won);
  }
  
  @Test(priority = 2)
  public void proposalMethods() throws InterruptedException {
	 createProposal(driver);
	 proposalName(driver);
	 client(driver);
	 scrollWindow(driver);
	 calender(driver);
	 PcontentLibrary(driver);
	 sendNextButton(driver);
  }
		
      
  @Test(priority = 4)
  public void Send_and_Copy() throws InterruptedException {										
	  //link
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//img[@src='../../../assets/link-icon-blue.svg']")).click();
	  Thread.sleep(2000);
	  
	  String copy_text = driver.findElement(By.xpath("//div[@class='card-body ng-star-inserted']//input")).getAttribute("value");
	  System.out.println(copy_text);
	  Thread.sleep(2000);
	  
	  ((JavascriptExecutor)driver).executeScript("window.open()");
   	  ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
 	  driver.switchTo().window(tabs.get(1));
 	  driver.get(copy_text);

	  Thread.sleep(7000);
	  driver.findElement(By.xpath("//div[@class='tool-list-button-group ng-star-inserted']//button[@class='btn tool-list-save'][contains(text(),'Accept')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("/html[1]/body[1]/ngb-modal-window[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")).sendKeys("Vishal");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Manager");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@class='form-check-input']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
 
  }
  
  @Test(priority = 5)
  public void Dashboard_Verify_Won_Value() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.get("http://beta1.freshproposals.com/home/dashboard");
	  Verify_Won = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[5]/div[1]/app-dashboard[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/p[1]")).getText();
	  System.out.println("After Won "+Verify_Won);
	  //String Verify_Won_plus = Get_Won + 1;
	  
	  Assert.assertNotEquals(Get_Won, Verify_Won);
	  
  }
	
@AfterClass
  public void closeBrowser() throws InterruptedException {
  Thread.sleep(3000);
  driver.quit();
  
}
}


