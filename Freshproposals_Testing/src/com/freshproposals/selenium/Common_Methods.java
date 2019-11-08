package com.freshproposals.selenium;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class Common_Methods {
	WebDriver driver;
	
	
	
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
	  
}

