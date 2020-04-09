package com.freshproposals.selenium;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Push_Template extends Common_Methods {
	WebDriver driver;
	String unm;
	String pwd;
	
	String Proposal_SectionName;
	String Content_SectionName;
	
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
  
 
  @Test(priority = 1)
  public void createTemplate() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@src='../../assets/add-section-icon.png']")).click();
		driver.findElement(By.name("name")).sendKeys(fname+" CVTemp "+timestamp);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(5000);
	
	}
  
  @Test(priority = 2)
  public void TemplateVersion() throws InterruptedException {
//	Thread.sleep(10000);
//	//driver.get("http://beta1.freshproposals.com/home/proposals/editProposal;proposalId=2374;editor=true");
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("//li[@class='nav-item example-box active']//a[@class='sectionlist-name'][contains(text(),'New Section')]")).click();
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("//li[@class='nav-item example-box active']//button[@id='dropdownBasic1']//img")).click();
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("//li[@class='nav-item example-box active']//button[@class='dropdown-item'][contains(text(),'Rename')]")).click();
//	Thread.sleep(10000);
//	driver.findElement(By.xpath("//input[@id='renameSection1']")).click();
//	driver.findElement(By.id("renameSection1")).sendKeys(fname+" CV_SECName "+timestamp);
//	Thread.sleep(2000);
//	t_name = driver.findElement(By.xpath("//div[@class='rename-section']//input[@name='sectionNametxt']")).getAttribute("value");
//	System.out.println("P NAME = "+t_name);
//	driver.findElement(By.xpath("//div[@class='rename-section']//div//img[@class='img-fluid']")).click();
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("//button[contains(text(),'Push')]")).click();
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("//span[contains(text(),'CONTENT LIBRARY')]")).click();
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("//img[@src='../../assets/edit-section-icon.png']")).click();
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("//img[@src='../../../../../assets/edit-tool-list.png']")).click();
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("//input[@name='sectionNametxt']")).click();
//	ct_t_name= driver.findElement(By.xpath("//input[@name='sectionNametxt']")).getAttribute("value");
//	//abc.click();
//	System.out.println("CT NAME "+ct_t_name);
	  Thread.sleep(5000);
		driver.findElement(By.xpath("//li[@class='nav-item example-box active']//a[@class='sectionlist-name'][contains(text(),'New Section')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li[@class='nav-item example-box active']//button[@id='dropdownBasic1']//img")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li[@class='nav-item example-box active']//button[@class='dropdown-item'][contains(text(),'Rename')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("sectionNametxt")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
	    driver.findElement(By.id("renameSection1")).sendKeys(fname+" SECName "+timestamp);
	    Proposal_SectionName = driver.findElement(By.id("renameSection1")).getAttribute("value");
	    System.out.println("Proposal Section Name = " +Proposal_SectionName);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='rename-section']//div//img[@class='img-fluid']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Push')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'CONTENT LIBRARY')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='../../assets/edit-section-icon.png']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='../../../../../assets/edit-tool-list.png']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='sectionNametxt']")).click();
		Content_SectionName= driver.findElement(By.xpath("//input[@name='sectionNametxt']")).getAttribute("value");
		//abc.click();
		System.out.println("Content Section Name = " +Proposal_SectionName);
  }
  
  @Test(priority = 3)
  public void Assert_Temp() throws InterruptedException {
	  Thread.sleep(2000);
	  Assert.assertEquals(Proposal_SectionName,Content_SectionName);
  }
  
  @AfterClass
  public void closeBrowser() throws InterruptedException {
  	  Thread.sleep(3000);
  	  driver.close();
  }
	

}
