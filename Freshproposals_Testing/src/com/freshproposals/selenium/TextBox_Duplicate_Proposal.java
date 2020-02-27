package com.freshproposals.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TextBox_Duplicate_Proposal extends Common_Methods {
  
	WebDriver driver;
	String original_text;
	String duplicate_text;
	
	
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
	 public void open_Proposal() throws InterruptedException{
		 Thread.sleep(5000);
		 driver.get("http://beta1.freshproposals.com/home/proposals/editProposal;proposalId=1824;editor=true");
	 
	 }
	 
	 @Test(priority = 2)
	 public void write() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("froalapage1-fpText12242019155138100")).click();
		driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p")).sendKeys("Testing on Duplicate");
		Thread.sleep(1000);
		original_text = driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p")).getText();
		System.out.println("Original Text "+original_text);
		driver.findElement(By.xpath("//button[starts-with(@id,'paragraphStyle')]")).click();
	    Thread.sleep(1000);
		driver.findElement(By.linkText("Heading 1")).click();
		
	 }
	 @Test(priority = 3)
	 public void duplicate() throws InterruptedException{
		 Thread.sleep(1000);
		 Actions action = new Actions(driver);
		 action.contextClick(driver.findElement(By.id("froalapage1-fpText12242019155138100"))).perform();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//li[contains(text(),'Duplicate')]")).click();
	 
	 }
	 
	 @Test(priority = 4)
	 public void DragDrop() throws InterruptedException{
		 Thread.sleep(3000);
		 Actions action = new Actions(driver);
		 WebElement source = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[5]/div[1]/app-edit-proposal[1]/div[1]/div[2]/div[2]/div[1]/table[1]/tr[1]/td[1]/div[1]/app-edit-section[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/app-sections-page[1]/a[1]/div[1]/div[1]/div[1]/app-fptext[2]/div[1]/div[1]/div[1]/div[9]/div[1]"));
		 WebElement des = driver.findElement(By.xpath("//div[@id='sectionPage_6715page1']"));
		 action.clickAndHold(source).moveToElement(des, 100, 100).release().build().perform();
		 	 
	 }
	 
	 @Test(priority = 5)
	  public void Save() throws InterruptedException {
		  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
		  Thread.sleep(3000);
		  driver.get("http://beta1.freshproposals.com/home/proposals/editProposal;proposalId=1824;editor=true");
		  
	 }
	 
	 @Test(priority = 6)
	  public void clear() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[5]/div[1]/app-edit-proposal[1]/div[1]/div[2]/div[2]/div[1]/table[1]/tr[1]/td[1]/div[1]/app-edit-section[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/app-sections-page[1]/a[1]/div[1]/div[1]/div[1]/app-fptext[2]/div[1]/div[1]/div[1]/div[9]/div[1]")).click();
		duplicate_text = driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p")).getText();
		System.out.println("Duplicate Text "+duplicate_text);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@class='img-fluid delete-section-control']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("froalapage1-fpText12242019155138100")).click();		
		driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).clear();
		Thread.sleep(2000);
		
	 }
	 
	 @Test(priority = 7)
	  public void Save2() throws InterruptedException {
		  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
		  Thread.sleep(3000);
		  driver.get("http://beta1.freshproposals.com/home/proposals/editProposal;proposalId=1824;editor=true");
		  
	 }
	 
	 @Test(priority = 8)
	   public void final_Result() throws InterruptedException {
		 Thread.sleep(1000);
		 Assert.assertEquals(original_text, duplicate_text);
	 }
	 
	 @AfterClass
	 public void closeBrowser() throws InterruptedException {
	 	  Thread.sleep(3000);
	 	  driver.close();
	 }
}
