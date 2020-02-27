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
	String fname = "SEL";
	String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	
	//variables
	String time;
	String view;
	String average;
	String lastview;
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
	  Thread.sleep(3000);
	  driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/1574");
	  
	  
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
	  //client btn
	  //driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[5]/div[1]/app-edit-proposal[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/h2[1]/button[1]")).click();
	  //Thread.sleep(1000);
	  //driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[5]/div[1]/app-edit-proposal[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/app-clients[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/label[1]/span[1]")).click();
	  driver.findElement(By.xpath("//div[@class='row client-content mt-3 ng-star-inserted']//div[2]//div[2]//label[1]//span[1]")).click();
	  Thread.sleep(2000);
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
	  driver.findElement(By.xpath("//div[contains(text(),'15')]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//button[@class='btn send-btn mt-3']")).click();
  }
  
  @Test(priority = 6)
  public void copyLink() throws InterruptedException, AWTException {
	  //next
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//button[@class='nav-link btn next-btn ng-star-inserted']")).click();
	  //link
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//img[@src='../../../assets/link-icon-blue.svg']")).click();
	  Thread.sleep(2000);
	  
	  String copy_text = driver.findElement(By.xpath("//div[@class='card-body']//input")).getAttribute("value");
	  System.out.println(copy_text);
	  Thread.sleep(2000);
	  
	  ((JavascriptExecutor)driver).executeScript("window.open()");
   	  ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
 	  driver.switchTo().window(tabs.get(1));
 	  driver.get(copy_text);
	  
	  Thread.sleep(60000);
	  
	  driver.findElement(By.xpath("//a[contains(text(),'Second Page')]")).click();
	  
	  
	  Thread.sleep(60000);
	  
	  driver.findElement(By.xpath("//a[contains(text(),'Third Page')]")).click();
	  
	  Thread.sleep(10000);
	  
	  driver.close();
	  driver.switchTo().window(tabs.get(0));

  }
  
  @Test(priority = 7)
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
  
  @Test(priority = 8)
  public void getSummaryData() throws InterruptedException {
	  Thread.sleep(5000);
	  time =  driver.findElement(By.className("proposal-analytics-timespent-value")).getText();
	  System.out.println("A TOTAL TIME SPENT VIEWING " +  time);
	  //times viewed
	  view = driver.findElement(By.cssSelector("div.wrapper div.main:nth-child(5) div.apply-hidden.styling-mode-effect div.proposal-summary div.container:nth-child(3) div.tabs-underlined.proposal-summary-tab div.tab-content div.tab-pane.active div.proposal-analytics div.row.proposal-analytics-box:nth-child(2) div.proposal-analytics-box-timespent div.proposal-analytics-timespent div:nth-child(2) > div.proposal-analytics-timespent-value")).getText();
	  System.out.println("A TIMES VIEWED " + view);
	  //average time
	  average = driver.findElement(By.xpath("//*[@id=\"ngb-tab-2-panel\"]/app-proposal-analytics/div/div[2]/div[2]/div/div[3]/div[2]")).getText();
	  System.out.println("A AVERAGE TIME VIEWING " + average);				
	  //time since last view
	  lastview = driver.findElement(By.xpath("//*[@id=\"ngb-tab-2-panel\"]/app-proposal-analytics/div/div[2]/div[2]/div/div[4]/div[2]")).getText();
	  System.out.println("A TIME SINCE LAST VIEWED " + lastview);

  }
  
  @Test(priority = 9)
  public void Assert_time() throws InterruptedException {
	  Thread.sleep(2000);
	  Assert.assertEquals(time, e_time);
	  
  }
  
  @Test(priority = 10)
  public void Assert_view() throws InterruptedException {
	  Thread.sleep(2000);
	  Assert.assertEquals(view, e_view);
	  
  }
  
 
   @AfterClass
  public void closeBrowser() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.quit();
  }
  
  
}
