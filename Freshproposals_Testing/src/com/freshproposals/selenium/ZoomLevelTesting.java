package com.freshproposals.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ZoomLevelTesting extends Common_Methods {
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
	 @Test(priority=1,dependsOnMethods = "login")
	 public void selectzoom() throws InterruptedException {
		 driver.get("http://beta1.freshproposals.com/home/sections/editSection/5020/true");
		 driver.findElement(By.xpath("//div[@class='collapse-preview-controls roatate']")).click();
		 Thread.sleep(2000);
		WebElement ele=	driver.findElement(By.xpath("//div[@class='page-wrapper']"));

		Select level=new Select(driver.findElement(By.xpath("//div[@class='editor-header-width-drop']//select")));
		 int[] ar = new int[]{ -115,83,281,360,440,519,598 }; 

		for(int i=0;i<7;i++) {
		level.selectByIndex(i);
		Thread.sleep(1000);
		Point point = ele.getLocation();
		 int xcord = point.getX();
		// System.out.println("Position of the webelement from left side is "+xcord +" pixels");
		
		 Assert.assertEquals(xcord,ar[i] );
		}
		

		}
	 	@AfterTest()
	 	public void teardown() {
	 		driver.quit();
	 	}
}
