package com.freshproposals.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Select_Search_Tab extends Common_Methods {
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
  
  @Test(dataProvider = "User1" , priority = 0)
  
  public void login(String unm, String pwd) {
	    driver.findElement(By.id("textbox_0")).sendKeys(unm);
		driver.findElement(By.id("textbox_1")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	
	}

  @Test(priority = 1)
  public void Select() throws InterruptedException {
	 driver.findElement(By.linkText("PROPOSALS")).click();
	 Thread.sleep(10000);
	 Select select = new Select(driver.findElement(By.xpath("//div[@id='content']//div[2]//div[1]//select[1]")));
	 Thread.sleep(2000);
	 select.selectByVisibleText("Completed");
	 Thread.sleep(3000);
	 select.selectByVisibleText("Pending");
	 Thread.sleep(1000);
	 select.selectByVisibleText("All");
	  
  }
  
  @Test(priority = 2)
  public void Search() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[@placeholder=' ']")).sendKeys("Software Proposal");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//img[@src='../../assets/edit-pen-blue.svg']")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
  }
  
  @Test(priority = 3)
  public void Tab() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.findElement(By.linkText("Design")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.linkText("Software")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.linkText("Real State")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.linkText("All")).click();
	  
  }
  
  @Test(priority = 4)
  public void Tab_change() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//input[@placeholder=' ']")).sendKeys("All in One");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//img[@src='../../assets/edit-pen-blue.svg']")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//img[@src='../../../../../assets/edit-tool-list.svg']")).click();
	  Thread.sleep(2000);
	  Select select = new Select(driver.findElement(By.name("category")));
	  select.selectByVisibleText("Marketing");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
	  Thread.sleep(10000);
	  driver.findElement(By.linkText("Marketing")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//img[@src='../../assets/edit-pen-blue.svg']")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//img[@src='../../../../../assets/edit-tool-list.svg']")).click();
	  Thread.sleep(2000);
	  Select select2 = new Select(driver.findElement(By.name("category")));
	  select2.selectByVisibleText("Software");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
  }
  
  @AfterTest
  public void closeBrowser() throws InterruptedException {
  Thread.sleep(3000);
  driver.close();
}
  

}
