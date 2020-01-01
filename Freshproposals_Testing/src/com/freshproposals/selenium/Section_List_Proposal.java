package com.freshproposals.selenium;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Section_List_Proposal extends Common_Methods {
	WebDriver driver;
	String fname = "SEL";
	String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	
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
  public void nameProposal() throws InterruptedException {
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("PROPOSALS")).click();
	    Thread.sleep(2000);
		driver.findElement(By.linkText("Start From Scratch")).click();
		Thread.sleep(1000);
	    driver.findElement(By.name("name")).sendKeys(fname+" SLProp "+timestamp);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
  }
  
  @Test(priority = 2)
  public void client() throws InterruptedException  {
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@id=\"headingSelectClient\"]/h2/button")).click();
	  //driver.findElement(By.xpath("//*[@id=\"collapseSelectClient\"]/div/div/app-clients/div[2]/div/div/div/div[2]/label/span")).click();
	  driver.findElement(By.xpath("//body//div[@class='col-lg-10 offset-lg-1']//div[@class='col-lg-10 offset-lg-1']//div[1]//div[2]//label[1]//span[1]")).click();
  }
  
  @Test(priority = 3)
  public void scrollWindow() throws InterruptedException  {
	  Thread.sleep(3000);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,1000)");
  }
  
  @Test(priority = 4)
  public void calender() throws InterruptedException  {
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//img[@src='../../../assets/calendar.svg']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//div[@class='ngb-dp-arrow right']//button[@class='btn btn-link ngb-dp-arrow-btn']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//div[contains(text(),'31')]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.linkText("Next")).click();
  }
  
  @Test(priority = 5)
  public void rename() throws InterruptedException {
	  //driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/754");
	  Thread.sleep(5000);
	  //add page
	  driver.findElement(By.xpath("//img[@src='../../assets/add-icon.svg']")).click();
	  driver.findElement(By.xpath("//img[@src='../../assets/add-icon.svg']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(" //button[@id='dropdownBasic1'] //img")).click();
	  Thread.sleep(2000);
	  //rename
	  driver.findElement(By.xpath("//button[contains(text(),'Rename')]")).click();
	  Thread.sleep(1000);
	  //name change
	  driver.findElement(By.xpath("//li[1]//input[1]")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
	  driver.findElement(By.xpath("//li[1]//input[1]")).sendKeys(fname+" SECName "+timestamp);
	  driver.findElement(By.xpath("//div[@class='rename-section']//div//img[@class='img-fluid']")).click();
	  Thread.sleep(5000);
	  //save
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	  Thread.sleep(1000);
	  //back
	  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
	  //reopen
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//img[@src='../../assets/edit-pen-blue.svg']")).click();
	
	 
	 
   }
  
  @Test(priority = 6)
  public void copy() throws InterruptedException {
	  driver.findElement(By.xpath("//img[@src='../../assets/add-icon.svg']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(" //button[@id='dropdownBasic1'] //img")).click();
	  driver.findElement(By.xpath(" //button[contains(text(),'Make a Copy')]")).click();
	  Thread.sleep(2000); 
	  //save
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	  Thread.sleep(1000);
	  //back
	  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
	  //reopen
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//img[@src='../../assets/edit-pen-blue.svg']")).click();
	  
  }
  
  @Test(priority = 7)
  public void delete() throws InterruptedException {
	  driver.findElement(By.xpath("//img[@src='../../assets/add-icon.svg']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(" //button[@id='dropdownBasic1'] //img")).click();
	  Thread.sleep(1000);
	 
      driver.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();
	  //ok button
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
	  Thread.sleep(2000);
	//save
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	  Thread.sleep(1000);
	  //back
	  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
	  //reopen
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//img[@src='../../assets/edit-pen-blue.svg']")).click();
	  
  }

  
  @AfterClass
  public void closeBrowser() throws InterruptedException {
  Thread.sleep(3000);
  driver.close();
}

  
}
