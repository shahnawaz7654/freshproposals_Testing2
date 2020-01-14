package com.freshproposals.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Page_Up_Properties extends Common_Methods {
	WebDriver driver;
	String fname = "SEL";
	
  @BeforeClass
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
  public void Properties() throws InterruptedException, AWTException {
	  driver.get("http://beta1.freshproposals.com/home/proposals/editProposal;proposalId=1283;editor=true");
	  Thread.sleep(2000);
	  //driver.findElement(By.xpath("//div[@id='collapseExample']//div[2]//a[1]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.className("default-rectangle")).click();
	  Robot robot = new Robot();
	  robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	  robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	  
	  robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	  robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	  Thread.sleep(3000);
	  
	  //move up
	  driver.findElement(By.xpath("//a[@name='page2']//div[@class='deletIconpage']//div[2]")).click();
	  Thread.sleep(1000);
	  robot.keyPress(KeyEvent.VK_PAGE_UP);
	  robot.keyRelease(KeyEvent.VK_PAGE_UP);
	  Thread.sleep(1000);
	  
	  robot.keyPress(KeyEvent.VK_PAGE_UP);
	  robot.keyRelease(KeyEvent.VK_PAGE_UP);
	  Thread.sleep(1000);
	  
	  robot.keyPress(KeyEvent.VK_PAGE_UP);
	  robot.keyRelease(KeyEvent.VK_PAGE_UP);
	  Thread.sleep(1000);
	  
	  robot.keyPress(KeyEvent.VK_PAGE_UP);
	  robot.keyRelease(KeyEvent.VK_PAGE_UP);
	  Thread.sleep(1000);
	  
	  robot.keyPress(KeyEvent.VK_PAGE_UP);
	  robot.keyRelease(KeyEvent.VK_PAGE_UP);
	  
	  //move down
	  driver.findElement(By.xpath("//a[@name='page1']//div[@class='deletIconpage']//div[2]")).click();
	  Thread.sleep(2000);
	  
	  robot.keyPress(KeyEvent.VK_PAGE_UP);
	  robot.keyRelease(KeyEvent.VK_PAGE_UP);
	  Thread.sleep(1000);
	  
	  robot.keyPress(KeyEvent.VK_PAGE_UP);
	  robot.keyRelease(KeyEvent.VK_PAGE_UP);
	  Thread.sleep(1000);
	  
	  robot.keyPress(KeyEvent.VK_PAGE_UP);
	  robot.keyRelease(KeyEvent.VK_PAGE_UP);
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
	  Thread.sleep(2000);
	  driver.get("http://beta1.freshproposals.com/home/proposals/editProposal;proposalId=1283;editor=true");
	  Thread.sleep(3000);
	  //add page
	  driver.findElement(By.xpath("//img[@src='../../assets/add-icon.svg']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.className("default-rectangle")).click();
	  Thread.sleep(2000);
	  
	  robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	  robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	  Thread.sleep(1000);
	  
	  robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	  robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	  Thread.sleep(1000);
	  
	  robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	  robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	  Thread.sleep(1000);
	  
	  robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	  robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	  Thread.sleep(1000);
	  
	  robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	  robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	  Thread.sleep(1000);
	  
	  //delete
	  driver.findElement(By.xpath("//a[@name='page4']//div[5]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
	  
	  
	  
	  
	 }
  
  @AfterClass
  public void closeBrowser() throws InterruptedException {
  Thread.sleep(3000);
  driver.close();
}
  
}
