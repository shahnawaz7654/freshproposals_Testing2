package com.freshproposals.selenium;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.asm.Advice.Enter;

public class Gmail_Testing extends Common_Methods{
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
			driver.findElement(By.linkText("TEMPLATES")).click();
			Thread.sleep(3000);
			//template name
			driver.findElement(By.linkText("Create your Template")).click();
			driver.findElement(By.name("name")).sendKeys(fname+" GmailTestingTemp "+timestamp);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
	  }
	  
	  @Test(priority = 2)
	  public void contentLibrary() throws InterruptedException {
		  Thread.sleep(3000);
		  //plus btn
		  driver.findElement(By.xpath("//button[@class='btn add-sect-btn template-add-sec']")).click();
		  Thread.sleep(5000);
		  //search
		  driver.findElement(By.xpath("//input[@placeholder='search section']")).sendKeys("content library automation");
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
			driver.findElement(By.name("name")).sendKeys(fname+" GmailTestingProp "+timestamp);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		  }
	  
	  @Test(priority = 4)
	  public void client() throws InterruptedException  {
		  Thread.sleep(3000);
		  //client btn
		  driver.findElement(By.xpath("//*[@id=\"headingSelectClient\"]/h2/button")).click();
		  Thread.sleep(1000);
		  //search
		  driver.findElement(By.xpath("//div[@class='client-search']//input[@placeholder=' ']")).sendKeys("Gmail Testing");
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='card client-det']//span[@class='checkround']")).click();
		  //driver.findElement(By.xpath("//*[@id=\"collapseSelectClient\"]/div/div/app-clients/div[2]/div/div/div/div[2]/label/span")).click();
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
		  driver.findElement(By.xpath("//div[contains(text(),'31')]")).click();
		  Thread.sleep(2000);
		  //driver.findElement(By.linkText("Next")).click();
		  driver.findElement(By.xpath("//button[@class='btn send-btn mt-3']")).click();
	  }
	  
	  @Test(priority = 7)
	  public void sendEmail() throws InterruptedException {
		  //next
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
	      driver.findElement(By.xpath("//div[@class='card']//input")).sendKeys("Selenium Subject");
	      System.out.println(driver.findElement(By.xpath("//div[@class='card']//input")).getText());
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
	  

	 
	 @Test(priority = 8)
	 public void Gmail_login() {
		 driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
         
		 driver.findElement(By.name("identifier")).sendKeys("zenincloud@gmail.com");
         String actual_name = driver.findElement(By.name("identifier")).getAttribute("value");
         String expected_name = "zenincloud@gmail.com";
         Assert.assertEquals(actual_name, expected_name);
         
		 driver.findElement(By.id("identifierNext")).click();
		 
		 driver.findElement(By.name("password")).sendKeys("ZenInCloud@123");
		 String actual_password = driver.findElement(By.name("password")).getAttribute("value");
		 String expected_password = "ZenInCloud@123";
		 Assert.assertEquals(actual_password, expected_password);
		 driver.findElement(By.id("passwordNext")).click();
	 }
	 
	 @Test(priority = 9)
	 public void Search() throws InterruptedException {
		 Thread.sleep(2000);
		 driver.findElement(By.name("q")).sendKeys("Selenium Subject" + Keys.ENTER);
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/html[1]/body[1]/div[7]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[4]/div[2]/div[1]/table[1]/tbody[1]/tr[1]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.linkText("View Our Business Proposal")).click();
	 }
	 
	 @AfterClass
	  public void closeBrowser() throws InterruptedException {
		  Thread.sleep(3000);
		  driver.quit();
	  }
}
