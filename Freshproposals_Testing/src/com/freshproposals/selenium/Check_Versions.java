package com.freshproposals.selenium;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Check_Versions extends Common_Methods {
	WebDriver driver;
	String fname = "SEL";
	String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	
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
  public void createtemplate() throws InterruptedException {
		driver.findElement(By.linkText("TEMPLATES")).click();
		Thread.sleep(3000);
		//template name
		driver.findElement(By.linkText("Create your Template")).click();
		driver.findElement(By.name("name")).sendKeys(fname+" CVTemp "+timestamp);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
  }
	
  
  @Test(priority = 2)
  public void TemplateVersion() throws InterruptedException {
	//driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/776");
	Thread.sleep(2000);
	driver.findElement(By.className("sectionlist-name")).click();
	Thread.sleep(1000);
    driver.findElement(By.xpath("//img[@src='../../assets/add-icon.svg']")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath(" //button[@id='dropdownBasic1'] //img[ 1 ]")).click();
    Thread.sleep(2000);
    //rename
    driver.findElement(By.xpath("//li[1]//div[1]//div[1]//div[1]//button[1]")).click();
    Thread.sleep(1000);
    //name change
    driver.findElement(By.xpath("//li[1]//input[1]")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
    driver.findElement(By.xpath("//li[1]//input[1]")).sendKeys("I am Check versions from Template");
    Thread.sleep(1000);
    driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//button[contains(text(),'Check Versions')]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[contains(text(),'Push')]")).click();
    //back
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
    //content library
    Thread.sleep(2000);
    driver.findElement(By.linkText("CONTENT LIBRARY")).click();
    //open 
    Thread.sleep(2000);
    driver.findElement(By.xpath("//img[@src='../../assets/edit-temp.png']")).click();
    //back
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
    
  }
  
  @Test(priority = 3)
  public void createproposal() throws InterruptedException {
		driver.findElement(By.linkText("PROPOSALS")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Start From Scratch")).click();
		driver.findElement(By.name("name")).sendKeys(fname+" CVProp "+timestamp);
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
  
  @Test(priority = 4)
  public void ProposalVersion() throws InterruptedException {
	//driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/776");
	Thread.sleep(2000);
	driver.findElement(By.className("sectionlist-name")).click();
	Thread.sleep(1000);
    driver.findElement(By.xpath("//img[@src='../../assets/add-icon.svg']")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath(" //button[@id='dropdownBasic1'] //img[ 1 ]")).click();
    Thread.sleep(2000);
    //rename
    driver.findElement(By.xpath("//li[1]//div[1]//div[1]//div[1]//button[1]")).click();
    Thread.sleep(1000);
    //name change
    driver.findElement(By.xpath("//li[1]//input[1]")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
    driver.findElement(By.xpath("//li[1]//input[1]")).sendKeys("I am Check versions from Proposal");
    Thread.sleep(1000);
    driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//button[contains(text(),'Check Versions')]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[contains(text(),'Push')]")).click();
    //back
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
    //content library
    Thread.sleep(2000);
    driver.findElement(By.linkText("CONTENT LIBRARY")).click();
    //open 
    Thread.sleep(2000);
    driver.findElement(By.xpath("//img[@src='../../assets/edit-temp.png']")).click();
    //back
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
    
  }
  
  @AfterTest
  public void closeBrowser() throws InterruptedException {
  	  Thread.sleep(3000);
  	  driver.close();
  }
	

}
