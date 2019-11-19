package com.freshproposals.selenium;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Analytics_Tabchange extends Common_Methods {
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
   
  
//  @Test(priority = 1)
//  public void createTemplate() throws InterruptedException {
//		driver.findElement(By.linkText("TEMPLATES")).click();
//		Thread.sleep(3000);
//		//template name
//		driver.findElement(By.linkText("Create your Template")).click();
//		driver.findElement(By.name("name")).sendKeys(fname+" CLTemp "+timestamp);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//  }
//  
//  @Test(priority = 2)
//  public void contentLibrary() throws InterruptedException {
//	  Thread.sleep(3000);
//		//content library
//	    driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//button[@class='btn add-sect-btn']")).click();
//		//use this
//	    Thread.sleep(3000);
//	    driver.findElement(By.xpath("//img[@src='../../../assets/use-this.svg']")).click();
//		//close content library
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//img[@src='../../../assets/cancel.svg']")).click();
//  }
//  
//  @Test(priority = 3)
//  public void generateProposal() throws InterruptedException {
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//button[contains(text(), 'Generate Proposal' )]")).click();
//		driver.findElement(By.name("name")).sendKeys(fname+" CLProp "+timestamp);
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//	  }
//  
//  @Test(priority = 4)
//  public void client() throws InterruptedException  {
//	  Thread.sleep(3000);
//	  driver.findElement(By.xpath("//*[@id=\"headingSelectClient\"]/h2/button")).click();
//	  driver.findElement(By.xpath("//*[@id=\"collapseSelectClient\"]/div/div/app-clients/div[2]/div/div/div/div[2]/label/span")).click();
//  }
//  
//  @Test(priority = 5)
//  public void scrollWindow() throws InterruptedException  {
//	  Thread.sleep(3000);
//	  JavascriptExecutor js = (JavascriptExecutor) driver;
//	  js.executeScript("window.scrollBy(0,1000)");
//  }
//  
//  @Test(priority = 6)
//  public void calender() throws InterruptedException  {
//	  Thread.sleep(3000);
//	  driver.findElement(By.xpath("//img[@src='../../../assets/calendar.svg']")).click();
//	  driver.findElement(By.xpath("//*[@id=\"content\"]/div/app-edit-proposal/div[1]/div/div/div/div[1]/div[5]/div[1]/div/ngb-datepicker/div[2]/div/ngb-datepicker-month-view/div[6]/div[1]/div")).click();
//	  driver.findElement(By.linkText("Next")).click();
//  }
//  
  @Test(priority = 7)
  public void copyLink() throws InterruptedException {
	  driver.get("http://beta1.freshproposals.com/home/proposals/editProposal;proposalId=1169;editor=true");
	  //next
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
	  //link
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//img[@src='../../../assets/link-icon-blue.svg']")).click();
	  //copy link
	  Thread.sleep(2000);
	  driver.findElement(By.id("basic-addon2")).click();
	  Thread.sleep(2000);
	  ((JavascriptExecutor)driver).executeScript("window.open()");
   	  ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
 	  driver.switchTo().window(tabs.get(1));
 	  driver.get("https://beta.freshproposals.com/home/viewproposal/352/2c36943b-43bf-43cf-9fa1-a3f92dc9b1dc");
	  Thread.sleep(60000);
	  driver.findElement(By.xpath("//a[contains(text(),'Analytics Section 2')]")).click();
	  Thread.sleep(60000);
	  driver.findElement(By.xpath("//a[contains(text(),'Analytics Section 3')]")).click();
	  Thread.sleep(70000);
	//shift main tab
	  driver.switchTo().window(tabs.get(0));
	//shift temporary tab
   	Thread.sleep(6000);
	driver.switchTo().window(tabs.get(1));
	//open analytics tab
	Thread.sleep(60000);
//	//open analytics tab
	driver.get("http://beta1.freshproposals.com/home/proposals/summary/1169");
	Thread.sleep(1000);
    driver.findElement(By.id("ngb-tab-2")).click();
    //get time
    Thread.sleep(5000);
    String time =  driver.findElement(By.className("proposal-analytics-timespent-value")).getText();
	System.out.println("TOTAL TIME SPENT VIEWING " +  time);
	//times viewed
	String view = driver.findElement(By.cssSelector("div.wrapper div.main:nth-child(5) div.apply-hidden.styling-mode-effect div.proposal-summary div.container:nth-child(3) div.tabs-underlined.proposal-summary-tab div.tab-content div.tab-pane.active div.proposal-analytics div.row.proposal-analytics-box:nth-child(2) div.proposal-analytics-box-timespent div.proposal-analytics-timespent div:nth-child(2) > div.proposal-analytics-timespent-value")).getText();
	System.out.println("TIMES VIEWED " + view);
	//average time
	String average = driver.findElement(By.xpath("//*[@id=\"ngb-tab-2-panel\"]/app-proposal-analytics/div/div[2]/div[2]/div/div[3]/div[2]")).getText();
	System.out.println("AVERAGE TIME VIEWING " + average);				
	//time since last view
	String lastview = driver.findElement(By.xpath("//*[@id=\"ngb-tab-2-panel\"]/app-proposal-analytics/div/div[2]/div[2]/div/div[4]/div[2]")).getText();
	System.out.println("TIME SINCE LAST VIEWED " + lastview);
	//compare time
	String expected = "7 m 8 s";
	String actual = time;
	
	if (expected .equals (actual)) {
		System.out.println("PASS");
	}
	else {
		System.out.println("FAIL");
		}

  }
  
  @AfterTest
  public void closeBrowser() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.close();
  }
  
  
}

