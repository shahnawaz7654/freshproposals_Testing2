package com.freshproposals.selenium;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lost_Proposal_Verification extends Common_Methods {
	WebDriver driver;
	String fname = "SEL";
	String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	String Get_Lost;
	String Verify_Lost;
	
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
  public void Dashboard_Get_Lost_Value() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//span[contains(text(),'DASHBOARD')]")).click();
	  Get_Lost = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[5]/div[1]/app-dashboard[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/p[1]")).getText();
	  System.out.println("Before Lost "+Get_Lost);
  }
  
  @Test(priority = 2)
  public void createproposal() throws InterruptedException {
	Thread.sleep(2000);
	driver.findElement(By.linkText("PROPOSALS")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//img[@src='../../assets/add-section-icon.png']")).click();
	driver.findElement(By.name("name")).sendKeys(fname+" DashLostVal "+timestamp);
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	 Thread.sleep(3000);
	  //client btn
	  driver.findElement(By.xpath("//div[@class='row client-content mt-3 ng-star-inserted']//div[2]//div[2]//label[1]//span[1]")).click();
	  Thread.sleep(2000);
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
  
  @Test(priority = 4)
  public void Send_and_Copy() throws InterruptedException {
	  //next
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//button[@class='nav-link btn next-btn ng-star-inserted']")).click();
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
	  driver.findElement(By.xpath("//button[contains(text(),'Reject')]")).click();
	  //ok btn
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
	  //driver.findElement(By.xpath("/html[1]/body[1]/ngb-modal-window[1]/div[1]/div[1]/app-modal[1]/div[1]/div[2]/button[1]")).click();
	  //driver.findElement(By.cssSelector("body.modal-open:nth-child(2) ngb-modal-window.modal.fade.show.d-block.modal-holder:nth-child(15) div.modal-dialog div.modal-content app-modal:nth-child(1) div:nth-child(1) div.modal-footer > button.btn.save-btn:nth-child(1)")).click();
	  Thread.sleep(5000);
 
  }
  
  @Test(priority = 5)
  public void Dashboard_Verify_Lost_Value() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.get("http://beta1.freshproposals.com/home/dashboard");
	  Verify_Lost = driver.findElement(By.xpath("//div[@class='row']//div[1]//div[1]//div[1]//div[3]//div[2]//p[1]")).getText();
	  System.out.println("After Lost "+Verify_Lost);
	  
	  Assert.assertNotEquals(Get_Lost, Verify_Lost);
	  
	  
  }
	
@AfterClass
  public void closeBrowser() throws InterruptedException {
  Thread.sleep(3000);
  driver.quit();
}
}
