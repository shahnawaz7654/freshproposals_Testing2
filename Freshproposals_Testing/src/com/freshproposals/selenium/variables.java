package com.freshproposals.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class variables  extends Common_Methods {
	
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
		public void variables() throws InterruptedException {
			driver.get("http://beta1.freshproposals.com/home/proposals/editProposal;proposalId=1105;editor=true");
			WebElement ele1=driver.findElement(By.xpath("//div[@id='froalapage1-fpText11420191584045']"));
			ele1.click();
			driver.findElement(By.xpath("//button[contains(text(),'Variables')]")).click();
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//li[contains(text(),'My Company Name')]")).click();
			Thread.sleep(2000);
			//driver.findElement(By.xpath("//li[contains(text(),'My Email')]")).click();
			driver.findElement(By.xpath("//ul[@class='nav']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]")).click();
			Thread.sleep(2000);
			driver.get("http://beta1.freshproposals.com/home/viewproposal/1105/preview/proposals");
			List<WebElement> element=driver.findElements(By.xpath("//span[contains(text(),'Freshproposal')]"));
			System.out.println(element.size());
			driver.quit();
			
			
		}
	 
	 @AfterClass
	  public void closeBrowser() throws InterruptedException {
		  Thread.sleep(3000);
		  driver.close();
	  }

	
	

}
