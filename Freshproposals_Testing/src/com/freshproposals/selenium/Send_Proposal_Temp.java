package com.freshproposals.selenium;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Send_Proposal_Temp extends Common_Methods{
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
  public void createTemplate() throws InterruptedException {
	    Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@src='../../assets/add-section-icon.png']")).click();
		driver.findElement(By.name("name")).sendKeys(fname+" CLTempSend "+timestamp);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
  }
  
  @Test(priority = 2)
  public void contentLibrary() throws InterruptedException {
	  Thread.sleep(3000);
	  //plus btn
	  driver.findElement(By.xpath("//button[@class='btn add-sect-btn template-add-sec ng-star-inserted']")).click();
	  Thread.sleep(5000);
	  //search
	  driver.findElement(By.xpath("//input[@placeholder='search section']")).sendKeys("Design");
	  Thread.sleep(3000);
	  //use this
	  driver.findElement(By.xpath("//img[@class='img=fluid']")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//img[@class='img-fluid close-section-library']")).click();
  }
  
  @Test(priority = 3)
  public void generateProposal() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(), 'Generate Proposal' )]")).click();
		driver.findElement(By.name("name")).sendKeys(fname+" TempPropSend "+timestamp);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	  }
  
  @Test(priority = 4)
  public void client() throws InterruptedException  {
	  Thread.sleep(3000);
	  //client btn
	  driver.findElement(By.xpath("//div[@class='row client-content mt-3 ng-star-inserted']//div[2]//div[2]//label[1]//span[1]")).click();
	  Thread.sleep(2000);
	 
  }
  
  @Test(priority = 5)
  public void scrollWindow() throws InterruptedException  {
	  Thread.sleep(3000);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,1000)");
  }
  
  @Test(priority = 6)
  public void calender() throws InterruptedException  {
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//img[@src='../../../assets/calendar.svg']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//div[@class='ngb-dp-arrow right']//button[@class='btn btn-link ngb-dp-arrow-btn']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//div[contains(text(),'15')]")).click();
	  Thread.sleep(2000);
	  //driver.findElement(By.linkText("Next")).click();
	  driver.findElement(By.xpath("//button[@class='btn send-btn mt-3']")).click();
  }
  
  @Test(priority = 7)
  public void sendEmail() throws InterruptedException {
	  //next
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//button[@class='nav-link btn next-btn ng-star-inserted']")).click();
	  Thread.sleep(5000);
      driver.findElement(By.xpath("//div[@class='card']//input")).sendKeys("Selenium Subject");
	  driver.findElement(By.xpath("//div[@class='fr-box fr-basic fr-top']//div[@class='fr-element fr-view']"))
	  .sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
				+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,"
				+ " when an unknown printer took a galley of type and scrambled it to make a type specimen book."
				+ "Lorem Ipsum is simply dummy text of the printing and typesetting industry."
				+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s");
	  Thread.sleep(2000);
	  //send btn
	  driver.findElement(By.linkText("Send")).click();
	 
  }
  
  @AfterClass
  public void closeBrowser() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.close();
  }
  
  
}
