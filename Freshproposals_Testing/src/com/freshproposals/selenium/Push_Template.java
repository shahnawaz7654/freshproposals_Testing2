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
	String fname = "SEL";
	String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	
	String t_name;
	String ct_t_name;
	
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
  public void createTemplate() throws InterruptedException {
	    Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'TEMPLATES')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Create your Template")).click();
		driver.findElement(By.name("name")).sendKeys(fname+" CVTemp "+timestamp);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(5000);
	
	}
  
  @Test(priority = 2)
  public void TemplateVersion() throws InterruptedException {
	//Thread.sleep(3000);
	//driver.get("http://beta1.freshproposals.com/home/proposals/editProposal;proposalId=2374;editor=true");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//li[@class='nav-item example-box active']//a[@class='sectionlist-name'][contains(text(),'New Section')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//li[@class='nav-item example-box active']//button[@id='dropdownBasic1']//img")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//li[@class='nav-item example-box active']//button[@class='dropdown-item'][contains(text(),'Rename')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@class='rename-section']//input[@name='sectionNametxt']")).clear();
	driver.findElement(By.xpath("//div[@class='rename-section']//input[@name='sectionNametxt']")).sendKeys(fname+" CV_SECName "+timestamp);
	Thread.sleep(2000);
	t_name = driver.findElement(By.xpath("//div[@class='rename-section']//input[@name='sectionNametxt']")).getAttribute("value");
	System.out.println("P NAME = "+t_name);
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
	ct_t_name= driver.findElement(By.xpath("//input[@name='sectionNametxt']")).getAttribute("value");
	//abc.click();
	System.out.println("CT NAME "+ct_t_name);
    
  }
  
  @Test(priority = 3)
  public void Assert_Temp() throws InterruptedException {
	  Thread.sleep(2000);
	  Assert.assertEquals(t_name, ct_t_name);
	  
  }
  
  @AfterClass
  public void closeBrowser() throws InterruptedException {
  	  Thread.sleep(3000);
  	  driver.close();
  }
	

}
