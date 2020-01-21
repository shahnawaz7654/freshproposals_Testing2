package com.freshproposals.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UpdatedVariables extends Common_Methods{
	WebDriver driver;
	 SoftAssert Assert= new SoftAssert();

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
	  
	  public void login(String unm, String pwd) throws InterruptedException {
		    driver.findElement(By.id("textbox_0")).sendKeys(unm);
			driver.findElement(By.id("textbox_1")).sendKeys(pwd);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		}
	
	 @Test(priority=1)
	 public void Variable() throws InterruptedException {
		 driver.get("http://beta1.freshproposals.com/home/viewproposal/2212/preview/proposals");
	List<WebElement> variable = driver.findElements(By.xpath("//div[@id='page1-fpText1212020118598']//p"));
	System.out.println(variable.size());
	int var=variable.size();
	for(int i=0;i<var;i++) {
		System.out.println(variable.get(i).getText());
	}
	WebElement backbtn = driver.findElement(By.xpath("//button[contains(text(),'Back')]"));
	backbtn.click();
	Thread.sleep(5000);
	 }
		@Test(priority=2)
		public void updatedVariables() throws InterruptedException {
			WebElement userprofile = driver.findElement(By.xpath("//a[@class='nav-link user-dp']//img"));
			userprofile.click();
			WebElement userinfo = driver.findElement(By.xpath("//h6[contains(text(),'User Profile')]"));
			userinfo.click();
			Thread.sleep(5000);

		}
	 
	@AfterClass
	public void Teardown() {
		driver.quit();
	}
	

}
