package com.freshproposals.selenium;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Common_Methods {
	//WebDriver driver;
	String fname = "SEL";
	String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	
	
	
	@DataProvider
	  public Object[][] User1(){
		
		Object[][] credentials = {
				  { "shahnawaz@zenincloud.com",
				    "Shahnawaz@123"},
		  };
		
		return credentials;
	  }
	  
	  @DataProvider
	  public Object[][] User2(){
		
		
		Object[][] credentials = {
				  {"nikeeta3011@gmail.com",
				    "Nikeeta@123"},
		  };
		
		return credentials;
	  }
	  
	  
	  public void generateProposalButton(WebDriver driver) {
		  driver.findElement(By.xpath("//button[contains(text(), 'Generate Proposal' )]")).click();
	  }
	  
	 
	  public void proposalName(WebDriver driver) throws InterruptedException {
		  Thread.sleep(3000);
		  driver.findElement(By.name("name")).sendKeys(fname+" TempPropAnalytics "+timestamp);
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//button[@type='submit']")).click();
	   }
	  
	  
	  public void client(WebDriver driver) throws InterruptedException  {
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//div[@class='col-lg-10 offset-lg-1']//div[1]//div[2]//label[1]//span[1]")).click();
		  Thread.sleep(2000);
	  }
	 
	  
	  public void scrollWindow(WebDriver driver) throws InterruptedException  {
		  Thread.sleep(3000);
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,1000)");
	  }
	  
	  
	  public void calender(WebDriver driver) throws InterruptedException  {
	 	  Thread.sleep(3000);
		  driver.findElement(By.xpath("//img[@src='../../../assets/calendar.svg']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//div[@class='ngb-dp-arrow right']//button[@class='btn btn-link ngb-dp-arrow-btn']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//div[contains(text(),'15')]")).click();
		  Thread.sleep(2000);
		  //next btn
		  driver.findElement(By.xpath("//button[@class='btn send-btn mt-3']")).click();
	  }
	  
	  
	  
	  
}

