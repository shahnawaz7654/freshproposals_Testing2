package com.freshproposals.selenium;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Section_List extends Common_Methods {
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
//enabled = false
  public void createtemplate() throws InterruptedException {
		driver.findElement(By.linkText("TEMPLATES")).click();
		Thread.sleep(3000);
		//template name
		driver.findElement(By.linkText("Create your Template")).click();
		driver.findElement(By.name("name")).sendKeys(fname+" SLTemp "+timestamp);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
  }
  @Test(priority = 2)
  public void AddSection() throws InterruptedException {
	  Thread.sleep(2000);
	  //+
	  driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//button[@class='btn add-sect-btn']")).click();
	  //add new
	  Thread.sleep(2000);
	  driver.findElement(By.className("create-prop-temp-box")).click();
	  //name
	  Thread.sleep(1000);
	  driver.findElement(By.name("name")).sendKeys(fname+" SectionName "+timestamp);
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  Thread.sleep(1000);
	  //close
	  driver.findElement(By.xpath("//img[@src='../../../assets/cancel.svg']")).click();
	  //section name
	  driver.findElement(By.className("sectionlist-name")).click();
	  
  }
  
  @Test(priority = 3)
  public void EditSection() throws InterruptedException {
	  //driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/754");
	  Thread.sleep(1000);
	  //add page
	  driver.findElement(By.xpath("//img[@src='../../assets/add-icon.svg']")).click();
	  driver.findElement(By.xpath("//img[@src='../../assets/add-icon.svg']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(" //button[@id='dropdownBasic1'] //img[ 1 ]")).click();
	  Thread.sleep(2000);
	  //rename
	  driver.findElement(By.xpath("//li[1]//div[1]//div[1]//div[1]//button[1]")).click();
	  Thread.sleep(1000);
	  //name change
	  driver.findElement(By.xpath("//li[1]//input[1]")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
	  driver.findElement(By.xpath("//li[1]//input[1]")).sendKeys("I am from Script");
	  //save
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	  Thread.sleep(1000);
	  //back
	  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
	  //reopen
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//img[@src='../../assets/edit-pen-blue.svg']")).click();
	  //drag and drop
//	  WebElement from =  driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//li[1]"));
//	  WebElement to =  driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//li[2]"));
//	  action.dragAndDrop(from, to).build().perform();
	  //copy
	  driver.findElement(By.xpath("//img[@src='../../assets/add-icon.svg']")).click();
	  driver.findElement(By.xpath(" //button[@id='dropdownBasic1'] //img[ 1 ]")).click();
	  Thread.sleep(2000); 
	  driver.findElement(By.xpath("//li[1]//div[1]//div[1]//div[1]//button[2]")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//li[1]//div[1]//div[1]//div[1]//button[3]")).click();
	  //ok button
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
	  
	   }
  
  @AfterTest
  public void closeBrowser() throws InterruptedException {
  Thread.sleep(3000);
  driver.close();
}
 
  }
