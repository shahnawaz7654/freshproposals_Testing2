package com.freshproposals.selenium;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Won_Proposal_Verification extends Common_Methods {
	WebDriver driver;
	String fname = "SEL";
	String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	String Get_Won;
	String Verify_Won;
	
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
  public void Dashboard_Get_Won_Value() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.findElement(By.linkText("DASHBOARD")).click();
	  Get_Won = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[5]/div[1]/app-dashboard[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/p[1]")).getText();
	  System.out.println("Before Won "+Get_Won);
  }
  
  @Test(priority = 2)
  public void createproposal() throws InterruptedException {
	Thread.sleep(2000);
	driver.findElement(By.linkText("PROPOSALS")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Start From Scratch")).click();
	driver.findElement(By.name("name")).sendKeys(fname+" DashWonVal "+timestamp);
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	//client
	driver.findElement(By.xpath("//*[@id=\"headingSelectClient\"]/h2/button")).click();
	driver.findElement(By.xpath("//*[@id=\"collapseSelectClient\"]/div/div/app-clients/div[2]/div/div/div/div[2]/label/span")).click();
	Thread.sleep(5000);
	
	//scroll window
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,1000)");
    Thread.sleep(2000);
	
    //calender
	driver.findElement(By.xpath("//img[@src='../../../assets/calendar.svg']")).click();
	driver.findElement(By.xpath("//*[@id=\"content\"]/div/app-edit-proposal/div[1]/div/div/div/div[1]/div[5]/div[1]/div/ngb-datepicker/div[2]/div/ngb-datepicker-month-view/div[6]/div[1]/div")).click();
	//driver.findElement(By.linkText("Advance")).click();
	//Thread.sleep(5000);
	
	Thread.sleep(2000);
	driver.findElement(By.linkText("Next")).click();
	Thread.sleep(5000);
		
	}
  
  @Test(enabled = false)
  public void contentLibrary() throws InterruptedException {
  Thread.sleep(3000);
	//content library
    driver.findElement(By.xpath("//button[@class='btn add-sect-btn template-add-sec']")).click();
	//use this
    Thread.sleep(3000);
    driver.findElement(By.xpath("//img[@src='../../../assets/use-this.svg']")).click();
	//close content library
	Thread.sleep(1000);
	driver.findElement(By.xpath("//img[@src='../../../assets/cancel.svg']")).click();
  }
  
  @Test(priority = 4)
  public void Send_and_Copy() throws InterruptedException {
  Thread.sleep(2000);
  //driver.get("http://beta1.freshproposals.com/home/proposals/editProposal;proposalId=1208;editor=true");
  driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
  //link
  Thread.sleep(2000);
  driver.findElement(By.xpath("//img[@src='../../../assets/link-icon-blue.svg']")).click();
  //copy link
  Thread.sleep(2000);
  
  driver.findElement(By.id("basic-addon2")).click();
  Thread.sleep(2000);
  driver.findElement(By.xpath("//input[@class='form-control']")).click();
  driver.findElement(By.xpath("//input[@class='form-control']")).getText();
  ((JavascriptExecutor)driver).executeScript("window.open()");
  ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
  driver.switchTo().window(tabs.get(1));
  Thread.sleep(7000);
  driver.findElement(By.xpath("//div[@class='tool-list-button-group']//button[@class='btn tool-list-save'][contains(text(),'Accept')]")).click();
  Thread.sleep(1000);
  driver.findElement(By.xpath("/html[1]/body[1]/ngb-modal-window[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")).sendKeys("Vishal");
  Thread.sleep(1000);
  driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Manager");
  Thread.sleep(1000);
  driver.findElement(By.xpath("//input[@class='form-check-input']")).click();
  Thread.sleep(1000);
  driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
 
  }
  
  @Test(priority = 5)
  public void Dashboard_Verify_Won_Value() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.get("http://beta1.freshproposals.com/home/dashboard");
	  Verify_Won = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[5]/div[1]/app-dashboard[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/p[1]")).getText();
	  System.out.println("After Won "+Verify_Won);
	  //String Verify_Won_plus = Get_Won + 1;
	  
	  Assert.assertNotEquals(Get_Won, Verify_Won);
	  

	  
  }
	
@AfterTest
  public void closeBrowser() throws InterruptedException {
  Thread.sleep(3000);
  driver.close();
}
}


