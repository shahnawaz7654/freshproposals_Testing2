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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Push_Proposal extends Common_Methods {
	WebDriver driver;
	String fname = "SEL";
	String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	
	String p_name;
	String ct_p_name;
	
	
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
  public void createproposal() throws InterruptedException {
	    Thread.sleep(3000);
		driver.findElement(By.xpath("app-home.ng-star-inserted:nth-child(2) div.wrapper div:nth-child(2) div.sidebar div.sidebar-scroll ul:nth-child(1) > li.proposals.is-active")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Start From Scratch")).click();
		driver.findElement(By.name("name")).sendKeys(fname+" CVProp "+timestamp);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//client
		Thread.sleep(3000);
	    //client btn
		driver.findElement(By.xpath("//*[@id=\"headingSelectClient\"]/h2/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='row client-content mt-3']//div[2]//div[2]//label[1]//span[1]")).click();
     	Thread.sleep(2000);
		
		//scroll window
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,1000)");
	    Thread.sleep(2000);
		
	    //calender
	    Thread.sleep(3000);
	  driver.findElement(By.xpath("//img[@src='../../../assets/calendar.svg']")).click();
	  Thread.sleep(2000);
	  Select select = new Select(driver.findElement(By.xpath("//body//select[2]")));
	  select.selectByValue("2021");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//div[contains(text(),'15')]")).click();
	  Thread.sleep(2000);
	  //driver.findElement(By.linkText("Next")).click();
	  driver.findElement(By.xpath("//button[@class='btn send-btn mt-3']")).click();
	
	}
  
  @Test(priority = 2)
  public void ProposalVersion() throws InterruptedException {
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
	p_name = driver.findElement(By.xpath("//div[@class='rename-section']//input[@name='sectionNametxt']")).getAttribute("value");
	System.out.println("P NAME = "+p_name);
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
	ct_p_name= driver.findElement(By.xpath("//input[@name='sectionNametxt']")).getAttribute("value");
	//abc.click();
	System.out.println("CT NAME "+ct_p_name);
    
  }
  
  @Test(priority = 3)
  public void Assert_Prop() throws InterruptedException {
	  Thread.sleep(2000);
	  Assert.assertEquals(p_name, ct_p_name);
	  
  }
  
  @AfterClass
  public void closeBrowser() throws InterruptedException {
  	  Thread.sleep(3000);
  	  driver.close();
  }
	

}
