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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class Won_Proposal_Verification extends Common_Methods {
	WebDriver driver;
	NgWebDriver ngDriver;
	String fname = "SEL";
	String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	String Get_Won;
	String Verify_Won;
	
  @BeforeClass 
  public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		driver.get("http://beta1.freshproposals.com");
		
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		ngDriver.waitForAngularRequestsToFinish();
	}
  
  @Test(dataProvider = "User1" , priority = 0)
  
  public void login(String unm, String pwd) {
	    driver.findElement(By.id("textbox_0")).sendKeys(unm);
		driver.findElement(By.id("textbox_1")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	
	}
  
  @Test(priority = 1)
  public void Dashboard_Get_Won_Value() throws InterruptedException {
	  Thread.sleep(9000);
	  driver.findElement(By.id("linkDashboard")).click();
	  Get_Won = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[5]/div[1]/app-dashboard[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/p[1]")).getText();
	  System.out.println("Before Won "+Get_Won);
  }
  
  @Test(priority = 2)
  public void generateProposal() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(By.linkText("PROPOSALS")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='../../assets/add-section-icon.png']")).click();
		driver.findElement(By.name("name")).sendKeys(fname+" DashWonVal "+timestamp);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	 
	  Thread.sleep(3000);
	  //client btn
	  driver.findElement(By.xpath("//div[@class='row client-content mt-3 ng-star-inserted']//div[2]//div[2]//label[1]//span[1]")).click();
      Thread.sleep(3000);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,1000)");

	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//img[@src='../../../assets/calendar.svg']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//div[@class='ngb-dp-arrow right']//button[@class='btn btn-link ngb-dp-arrow-btn']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//div[contains(text(),'15')]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//button[@class='btn send-btn mt-3']")).click();
  }
		
  
  @Test(enabled = false)
  public void contentLibrary() throws InterruptedException {
	  Thread.sleep(3000);
	  //plus btn
	  driver.findElement(By.xpath("//button[@class='btn add-sect-btn template-add-sec']")).click(); 
	  Thread.sleep(5000);
	  //use this
	  driver.findElement(By.xpath("//img[@class='img=fluid']")).click();      
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//img[@class='img-fluid close-section-library']")).click();
  }
      
  @Test(priority = 4)
  public void Send_and_Copy() throws InterruptedException {										
	  //next
	  Thread.sleep(10000);
	  //driver.findElement(By.xpath("//button[starts-with(@class,'nav-link btn next-btn')]")).click();
	  driver.findElement(By.id("btnSendMail")).click();
	  //link
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//img[@src='../../../assets/link-icon-blue.svg']")).click();
	  Thread.sleep(2000);
	  
	  String copy_text = driver.findElement(By.xpath("//div[@class='card-body ng-star-inserted']//input")).getAttribute("value");
	  System.out.println(copy_text);
	  Thread.sleep(2000);
	  
	  ((JavascriptExecutor)driver).executeScript("window.open()");
   	  ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
 	  driver.switchTo().window(tabs.get(1));
 	  driver.get(copy_text);

	  Thread.sleep(7000);
	  driver.findElement(By.xpath("//div[@class='tool-list-button-group ng-star-inserted']//button[@class='btn tool-list-save'][contains(text(),'Accept')]")).click();
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
	
@AfterClass
  public void closeBrowser() throws InterruptedException {
  Thread.sleep(3000);
  driver.quit();
  
}
}


