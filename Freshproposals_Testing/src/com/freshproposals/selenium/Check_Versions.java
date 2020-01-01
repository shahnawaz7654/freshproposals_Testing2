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

public class Check_Versions extends Common_Methods {
	WebDriver driver;
	String fname = "SEL";
	String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	
	String PropSecname;
	String TempSecname;
	
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
  
//  @Test(priority = 1)
//  public void createtemplate() throws InterruptedException {
//		driver.findElement(By.linkText("TEMPLATES")).click();
//		Thread.sleep(3000);
//		//template name
//		driver.findElement(By.linkText("Create your Template")).click();
//		driver.findElement(By.name("name")).sendKeys(fname+" CVTemp "+timestamp);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//  }
//	
//  
//  @Test(priority = 2)
//  public void TemplateVersion() throws InterruptedException {
//	//driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/776");
//	Thread.sleep(2000);
//	driver.findElement(By.className("sectionlist-name")).click();
//	Thread.sleep(1000);
//    driver.findElement(By.xpath("//img[@src='../../assets/add-icon.svg']")).click();
//    Thread.sleep(1000);
//    driver.findElement(By.xpath(" //button[@id='dropdownBasic1'] //img")).click();
//	Thread.sleep(2000);
//	//rename
//	driver.findElement(By.xpath("//button[contains(text(),'Rename')]")).click();
//	Thread.sleep(1000);
//	//name change
//	driver.findElement(By.xpath("//li[1]//input[1]")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
//    driver.findElement(By.xpath("//li[1]//input[1]")).sendKeys(fname+" CV_SECName "+timestamp);
//    driver.findElement(By.xpath("//div[@class='rename-section']//div//img[@class='img-fluid']")).click();
//    Thread.sleep(1000);
//    driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
//    Thread.sleep(1000);
//    //get name
//    driver.findElement(By.xpath("//div[@class='edit-sec']//img")).click();
//    driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/app-template-properties[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")).clear();
//    //TempSecname = driver.findElement(By.xpath("//div[@class='form-group']//input[@name='sectionNametxt']")).getText();
//    //System.out.println(TempSecname);
//    //System.out.println(driver.findElement(By.name("sectionNametxt")).getText());
//    driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
//    driver.findElement(By.xpath("//button[contains(text(),'Check Versions')]")).click();
//    Thread.sleep(2000);
//    driver.findElement(By.xpath("//button[contains(text(),'Push')]")).click();
//    //back
//    Thread.sleep(2000);
//    driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
//    //content library
//    Thread.sleep(2000);
//    driver.findElement(By.linkText("CONTENT LIBRARY")).click();
//    //open 
//    Thread.sleep(2000);
//    driver.findElement(By.xpath("//img[@src='../../assets/edit-temp.png']")).click();
//    //back
//    Thread.sleep(2000);
//    driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
//    
//  }
//  
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
		driver.findElement(By.xpath("//body//div[@class='col-lg-10 offset-lg-1']//div[@class='col-lg-10 offset-lg-1']//div[1]//div[2]//label[1]//span[1]")).click();
		Thread.sleep(5000);
		
		//scroll window
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,1000)");
	    Thread.sleep(2000);
		
	    //calender
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//img[@src='../../../assets/calendar.svg']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//div[@class='ngb-dp-arrow right']//button[@class='btn btn-link ngb-dp-arrow-btn']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//div[contains(text(),'31')]")).click();
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
    driver.findElement(By.xpath(" //button[@id='dropdownBasic1'] //img")).click();
   	Thread.sleep(2000);
   	//rename
   	driver.findElement(By.xpath("//button[contains(text(),'Rename')]")).click();
   	Thread.sleep(1000);
   	//name change
   	driver.findElement(By.xpath("//li[1]//input[1]")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
   	driver.findElement(By.xpath("//li[1]//input[1]")).sendKeys(fname+" CV_SECName "+timestamp);
    driver.findElement(By.xpath("//div[@class='rename-section']//div//img[@class='img-fluid']")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
    Thread.sleep(1000);
    
    //getname
    driver.findElement(By.xpath("//div[@class='edit-sec']//img")).click();
    String s = driver.findElement(By.xpath("//p[@class='hideControl']")).getText();
    System.out.println(s);
    driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
    

    
//    driver.findElement(By.xpath("//button[contains(text(),'Check Versions')]")).click();
//    Thread.sleep(2000);
//    driver.findElement(By.xpath("//button[contains(text(),'Push')]")).click();
//    //back
//    Thread.sleep(2000);
//    driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
//    //content library
//    Thread.sleep(2000);
//    driver.findElement(By.linkText("CONTENT LIBRARY")).click();
//    //open 
//    Thread.sleep(2000);
//    driver.findElement(By.xpath("//img[@src='../../assets/edit-temp.png']")).click();
//    //back
//    Thread.sleep(2000);
//    driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
    
  }
  
  @AfterClass
  public void closeBrowser() throws InterruptedException {
  	  Thread.sleep(3000);
  	  driver.close();
  }
	

}
