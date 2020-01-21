package com.freshproposals.selenium;

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

public class Analytics_Template extends Common_Methods {
	WebDriver driver;
	String fname = "SEL";
	String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	
	//variables
	String time;
	String view;
	String average;
	String lastview;
	String g_time;
	String g_view;
	String g_average;
	String g_lastview;
	int g_conversion_time;
	int conversion_time;
	int total_time;
	int expected_total_time;
	int g_view_int;
	int view_int; 
	int total_view;
	int total_average_time;
	int expected_total_average_time;
	
	
	
	
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
  public void openTemplate() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/1151");
	  
  }
  
  @Test(priority = 2)
  public void generateProposal() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(), 'Generate Proposal' )]")).click();
		driver.findElement(By.name("name")).sendKeys(fname+" TempPropAnalytics "+timestamp);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	  }
  
  @Test(priority = 3)
  public void client() throws InterruptedException  {
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@id=\"headingSelectClient\"]/h2/button")).click();
	  //driver.findElement(By.xpath("//*[@id=\"collapseSelectClient\"]/div/div/app-clients/div[2]/div/div/div/div[2]/label/span")).click();
	  driver.findElement(By.xpath("//body//div[@class='col-lg-10 offset-lg-1']//div[@class='col-lg-10 offset-lg-1']//div[1]//div[2]//label[1]//span[1]")).click();
  }
  
  @Test(priority = 4)
  public void scrollWindow() throws InterruptedException  {
	  Thread.sleep(3000);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,1000)");
  }
  
  @Test(priority = 5)
  public void calender() throws InterruptedException  {
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//img[@src='../../../assets/calendar.svg']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//div[@class='ngb-dp-arrow right']//button[@class='btn btn-link ngb-dp-arrow-btn']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//div[contains(text(),'31')]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.linkText("Next")).click();
  }
  
  @Test(priority = 6)
  public void copyLink() throws InterruptedException {
	  //next
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
	  //link
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//img[@src='../../../assets/link-icon-blue.svg']")).click();
	  //copy link
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[@class='form-control']")).click();
	  String copy_text = driver.findElement(By.xpath("//input[@class='form-control']")).getText();
	  System.out.println(copy_text);
	  Thread.sleep(2000);
	  driver.findElement(By.id("basic-addon2")).click();
	  Thread.sleep(2000);
	  ((JavascriptExecutor)driver).executeScript("window.open()");
   	  ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
 	  driver.switchTo().window(tabs.get(1));
// 	  
// 	//Switch to new window opened
// 	  for(String winHandle : driver.getWindowHandles()){ driver.switchTo().window(winHandle); }
//
// 	
// 	  Actions actions = new Actions(driver);
//      actions.sendKeys(Keys.chord(Keys.LEFT_CONTROL, "v")).build().perform(); 
//      
// 	  
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//a[contains(text(),'Cover Letter')]")).click();
	  Thread.sleep(5000);
	  
  }
   
  
    
  @AfterClass
  public void closeBrowser() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.quit();
  }
  
  
}
