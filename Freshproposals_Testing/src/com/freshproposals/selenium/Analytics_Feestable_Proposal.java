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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Analytics_Feestable_Proposal extends Common_Methods {
	WebDriver driver;
	String unm;
	String pwd;
	
	//variables
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
		openURL(driver);
	}
  
  @Test(dataProvider = "User1", priority = 0)
	 public void SetUnmPwd(String unm, String pwd) {
      login(unm, pwd, driver);
}
   
  @Test(priority = 7)
  public void getData() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.get("http://beta1.freshproposals.com/home/proposals/summary/1673");
		Thread.sleep(1000);
	    driver.findElement(By.id("ngb-tab-2")).click();
	    //get time
	    Thread.sleep(5000);
	    g_time =  driver.findElement(By.className("proposal-analytics-timespent-value")).getText();
		System.out.println("B TOTAL TIME SPENT VIEWING " +  g_time);
		//times viewed
		g_view = driver.findElement(By.cssSelector("div.wrapper div.main:nth-child(5) div.apply-hidden.styling-mode-effect div.proposal-summary div.container:nth-child(3) div.tabs-underlined.proposal-summary-tab div.tab-content div.tab-pane.active div.proposal-analytics div.row.proposal-analytics-box:nth-child(2) div.proposal-analytics-box-timespent div.proposal-analytics-timespent div:nth-child(2) > div.proposal-analytics-timespent-value")).getText();
		System.out.println("B TIMES VIEWED " + g_view);
		//average time
		g_average = driver.findElement(By.xpath("//*[@id=\"ngb-tab-2-panel\"]/app-proposal-analytics/div/div[2]/div[2]/div/div[3]/div[2]")).getText();
		System.out.println("B AVERAGE TIME VIEWING " + g_average);				
		//time since last view
		g_lastview = driver.findElement(By.xpath("//*[@id=\"ngb-tab-2-panel\"]/app-proposal-analytics/div/div[2]/div[2]/div/div[4]/div[2]")).getText();
		System.out.println("B TIME SINCE LAST VIEWED " + g_lastview);
  }
  
  
  @Test(priority = 8)
  public void copyLink() throws InterruptedException {
	  driver.get("http://beta1.freshproposals.com/home/proposals/editProposal;proposalId=1673;editor=true");
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
 	  driver.get("http://beta1.freshproposals.com/home/viewproposal/1673/a414397b-e592-429d-8ce7-a26794596b10");
 	  Thread.sleep(10000);
 	//change quantity
	  driver.findElement(By.name("feequantity")).clear();
	  driver.findElement(By.name("feequantity")).sendKeys("5");
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//a[contains(text(),'Second Page')]")).click();
	  Thread.sleep(5000);
//		//open analytics tab
	driver.get("http://beta1.freshproposals.com/home/proposals/summary/1673");
	Thread.sleep(1000);
    driver.findElement(By.id("ngb-tab-2")).click();
    //get time
    Thread.sleep(5000);
    time =  driver.findElement(By.className("proposal-analytics-timespent-value")).getText();
	System.out.println("TOTAL TIME SPENT VIEWING " +  time);
	//times viewed
	view = driver.findElement(By.cssSelector("div.wrapper div.main:nth-child(5) div.apply-hidden.styling-mode-effect div.proposal-summary div.container:nth-child(3) div.tabs-underlined.proposal-summary-tab div.tab-content div.tab-pane.active div.proposal-analytics div.row.proposal-analytics-box:nth-child(2) div.proposal-analytics-box-timespent div.proposal-analytics-timespent div:nth-child(2) > div.proposal-analytics-timespent-value")).getText();
	System.out.println("TIMES VIEWED " + view);
	//average time
	average = driver.findElement(By.xpath("//*[@id=\"ngb-tab-2-panel\"]/app-proposal-analytics/div/div[2]/div[2]/div/div[3]/div[2]")).getText();
	System.out.println("AVERAGE TIME VIEWING " + average);				
	//time since last view
	lastview = driver.findElement(By.xpath("//*[@id=\"ngb-tab-2-panel\"]/app-proposal-analytics/div/div[2]/div[2]/div/div[4]/div[2]")).getText();
	System.out.println("TIME SINCE LAST VIEWED " + lastview);
	 //compare g_time
    char[]	g_tempArr = g_time.toCharArray();
	int g_totalChars = g_tempArr.length;
	//System.out.println("TotalChars "+g_totalChars);
	
	int g_hrsIndex = g_time.lastIndexOf("h");
	int g_minIndex = g_time.lastIndexOf("m");
	int g_secsIndex = g_time.lastIndexOf("s");

	//System.out.println("HrsIndex"+g_hrsIndex+" MinIndex"+g_minIndex+" SecsIndex : "+g_secsIndex);

	int g_secs=0;
	int g_mins=0;
	int g_hrs=0;

	if(g_hrsIndex < 0){
		{
			if(g_minIndex < 0) {
				if(g_secsIndex < 0) {
					g_secs=0;
				}else {
					g_secs=  Integer.parseInt(g_time.substring(g_minIndex+2, g_secsIndex-1));
					//System.out.println("Secs String:"+g_time.substring(g_minIndex+2, g_secsIndex-1));
					//System.out.println(" Secs: "+g_secs);
				}
			}else {
				
				if(g_secsIndex < 0) {
					g_secs=0;
				}else {
					g_secs=  Integer.parseInt(g_time.substring(g_minIndex+2, g_secsIndex-1));
					//System.out.println("Secs String:"+g_time.substring(g_minIndex+2, g_secsIndex-1));
					//System.out.println(" Secs: "+g_secs);
				}

				g_mins=  Integer.parseInt(g_time.substring(0, g_minIndex-1));
				//System.out.println(" Mins: "+g_mins);			
			}
		}
	}else {
		
		g_hrs=  Integer.parseInt(g_time.substring(0, g_hrsIndex-1));
		//System.out.println(" Hrs: "+g_hrs);
	}
		
	System.out.println("G_H:"+g_hrs+" G_M:"+g_mins+" G_S: "+g_secs);

	
	 //compare _time
    char[]	tempArr = g_time.toCharArray();
	int totalChars = tempArr.length;
	//System.out.println("TotalChars "+totalChars);
	
	int hrsIndex = time.lastIndexOf("h");
	int minIndex = time.lastIndexOf("m");
	int secsIndex = time.lastIndexOf("s");

	//System.out.println("HrsIndex"+hrsIndex+" MinIndex"+minIndex+" SecsIndex : "+secsIndex);

	int secs=0;
	int mins=0;
	int hrs=0;

	if(hrsIndex < 0){
		{
			if(minIndex < 0) {
				if(secsIndex < 0) {
					secs=0;
				}else {
					secs=  Integer.parseInt(time.substring(minIndex+2, secsIndex-1));
					//System.out.println("Secs String:"+time.substring(minIndex+2, secsIndex-1));
					//System.out.println(" Secs: "+secs);
				}
			}else {
				
				if(secsIndex < 0) {
					secs=0;
				}else {
					secs=  Integer.parseInt(time.substring(minIndex+2, secsIndex-1));
					//System.out.println("Secs String:"+time.substring(minIndex+2, secsIndex-1));
					//System.out.println(" Secs: "+secs);
				}

				mins=  Integer.parseInt(time.substring(0, minIndex-1));
				//System.out.println(" Mins: "+mins);			
			}
		}
	}else {
		
		hrs=  Integer.parseInt(time.substring(0, hrsIndex-1));
		//System.out.println(" Hrs: "+hrs);
	}
		
	System.out.println("H:"+hrs+" M:"+mins+" Secs: "+secs);
	//get
	g_conversion_time = g_mins * 60 + g_secs;
	System.out.println("G Time = "+g_conversion_time);
	//normal 
	conversion_time = mins * 60 + secs;
	System.out.println("Time = "+conversion_time);
	
	total_time = conversion_time - g_conversion_time;
	System.out.println("Total Time = "+total_time);
	
	expected_total_time = 20;
	Assert.assertEquals(total_time, expected_total_time);
	
	
	
	}
  
  @Test(priority = 9)
  public void Times_View() {
	  System.out.println("G View= "+g_view);
	  System.out.println("View= "+view);
	  
	  g_view_int = Integer.parseInt(g_view);
	  view_int = Integer.parseInt(view);
	  
	  
	  total_view = view_int - g_view_int;
	  System.out.println("Total View= "+total_view);
	  
	  //int expected_total_view = 1;
	  Assert.assertTrue(total_view==1);
	  
	  
  }
  
  @Test(priority = 10)
  public void Average_Time() {
	  System.out.println(g_average);
	  System.out.println(average);
	  
	  total_average_time = g_conversion_time / view_int;
	  System.out.println(total_average_time);
	  
	  expected_total_average_time = total_average_time;
	  Assert.assertEquals(total_average_time, expected_total_average_time);
	  
	  
 }
  
  @AfterClass
  public void closeBrowser() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.quit();
  }
  
  
}

