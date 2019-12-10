package com.freshproposals.selenium;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExistingVariable extends Common_Methods{
	WebDriver driver;
	 @BeforeTest
	  public void openBrowser() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			driver.get("http://beta1.freshproposals.com");
		}
	  
	  @Test(dataProvider = "User2" , priority = 0)
	  
	  public void login(String unm, String pwd) {
		    driver.findElement(By.id("textbox_0")).sendKeys(unm);
			driver.findElement(By.id("textbox_1")).sendKeys(pwd);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		}
	  @Test(priority=1)
	  public void verifyVeriable() {
		  String[] expected = new String[] {"Freshproposal","nikeeta3011@gmail.com","1234545","abcd","Fresh proposals.com","Nikeeta","Shelar","nikeeta@zenincloud.com","SeleniumVariableTesting"};

		  driver.get("http://beta1.freshproposals.com/home/viewproposal/1259/preview/proposals");
		  List<WebElement> var=driver.findElements(By.xpath("//div[@id='froalapage1-fpText1119201917471418']//p"));
		  int variables=var.size();
		  
		  System.out.println("There are total "+variables+" Elements");
		  for(int i=0;i<variables;i++) {
			  String actual=var.get(i).getText();
				// System.out.println( var.get(i).getText());
				Assert.assertEquals(actual, expected[i]);
			 
			  
		  }
		  driver.quit();
		  
		  
	  }
	
	
	
}
