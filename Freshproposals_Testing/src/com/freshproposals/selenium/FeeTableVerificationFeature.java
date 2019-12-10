package com.freshproposals.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FeeTableVerificationFeature extends Common_Methods {
	WebDriver driver;
	
	 @BeforeClass
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
	 public void AddRow() {
		 driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/1143");
		 WebElement SectionName = driver.findElement(By.xpath("http://beta1.freshproposals.com/home/templates/editTemplate/1143"));
		 
	 }

}
