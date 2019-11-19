package com.freshproposals.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TextBox_Top_Properties extends Common_Methods {
	WebDriver driver;

	
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
  public void top_Properties() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.get("http://beta1.freshproposals.com/home/proposals/editProposal;proposalId=1178;editor=true");
	  Thread.sleep(1000);
	  //textbox click
	  driver.findElement(By.xpath("//div[@class='fr-wrapper show-placeholder']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'bold')]")).click();
	  driver.findElement(By.xpath("//button[starts-with(@id,'underline')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p")).sendKeys("Freshproposals");
  }
  
  @Test(priority = 2)
  public void paragraph_Style() throws InterruptedException {
	  Thread.sleep(1000);
	  //paragraph button
	  driver.findElement(By.xpath("//button[starts-with(@id,'paragraphStyle')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("Heading 1")).click();
	  
	  Thread.sleep(1000);
	  //paragraph button
	  driver.findElement(By.xpath("//button[starts-with(@id,'paragraphStyle')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("Heading 2")).click();
	  
	  
	  Thread.sleep(1000);
	  //paragraph button
	  driver.findElement(By.xpath("//button[starts-with(@id,'paragraphStyle')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("Heading 3")).click();
	  
	  
	  Thread.sleep(1000);
	  //paragraph button
	  driver.findElement(By.xpath("//button[starts-with(@id,'paragraphStyle')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("Heading 4")).click();
	  
	  
	  Thread.sleep(1000);
	  //paragraph button
	  driver.findElement(By.xpath("//button[starts-with(@id,'paragraphStyle')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("Body")).click();
	  
	  
	  Thread.sleep(1000);
	  //paragraph button
	  driver.findElement(By.xpath("//button[starts-with(@id,'paragraphStyle')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("Quote")).click();
	  
	 }
  
  @Test(enabled = false)
  public void fonrSize() throws InterruptedException {
	  Thread.sleep(1000);
	  //paragraph button
	  driver.findElement(By.xpath("//button[starts-with(@id,'fontSize')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[contains(text(),'72')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p")).click();
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p")).sendKeys("\n I am 72");;
	  
//	  Thread.sleep(1000);
//	  //paragraph button
//	  driver.findElement(By.xpath("//button[starts-with(@id,'fontSize')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.linkText("18")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p")).sendKeys("\nI am 8");
	  
	  Thread.sleep(1000);
	  //paragraph button
	  driver.findElement(By.xpath("//button[starts-with(@id,'fontSize')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[contains(text(),'18')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p")).sendKeys("\nI am 18");
	  
  }
  
  @Test(enabled = false)
  public void textColor() throws InterruptedException {
	  Thread.sleep(1000);
	  //textcolor button
	  driver.findElement(By.xpath("//button[starts-with(@id,'textColor')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("14")).click();
	  Thread.sleep(1000);
	  //color
	  driver.findElement(By.xpath("")).clear();
	 
	  Thread.sleep(1000);
	  //ok
	  //driver.findElement(By.xpath("//button[@class='fr-command fr-submit']")).click();
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p")).sendKeys("\n FreshProposals");
	  
  }
  
  @Test(priority = 5)
  public void lineHeight() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
	  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
	  		+ "a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. "
	  		+ "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing"
	  		+ " software like Aldus PageMaker including versions of Lorem Ipsum");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'lineHeight')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("Default")).click();
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'lineHeight')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("Single")).click();
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'lineHeight')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("1.15")).click();
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'lineHeight')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("1.5")).click();
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'lineHeight')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("Double")).click();
	  
	}
  
  @Test(priority = 6)
  public void align() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'align')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[@title='Align Left']")).click();
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'align')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[@title='Align Center']")).click();
  
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'align')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[@title='Align Right']")).click();
  
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'align')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[@title='Align Justify']")).click();
	  
  }
  
  @Test(priority = 7)
  public void orderList() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'formatOLOptions')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//div[@id='dropdown-menu-formatOLOptions-1']//a[@class='fr-command'][contains(text(),'Default')]")).click();
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'formatOLOptions')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[contains(text(),'Lower Alpha')]")).click();
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'formatOLOptions')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[contains(text(),'Lower Greek')]")).click();
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'formatOLOptions')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[contains(text(),'Lower Roman')]")).click();
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'formatOLOptions')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[contains(text(),'Upper Alpha')]")).click();
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'formatOLOptions')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[contains(text(),'Upper Roman')]")).click();
  }
  
  @Test(priority = 8)
  public void unorderList() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'formatULOptions')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//div[@id='dropdown-menu-formatULOptions-1']//a[@class='fr-command'][contains(text(),'Default')]")).click();
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'formatULOptions')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[contains(text(),'Circle')]")).click();
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'formatULOptions')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[contains(text(),'Disc')]")).click();
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'formatULOptions')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[contains(text(),'Square')]")).click();
	
  }
  
  @Test(priority = 9)
  public void insertLink() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'insertLink')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.name("href")).sendKeys("www.google.com");
	  Thread.sleep(1000);
	  driver.findElement(By.name("text")).sendKeys("Google");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[contains(text(),'Insert')]")).click();
	  
  }
  
  @Test(enabled = false)
  public void setting() throws InterruptedException {
	 //paragraph button
	 driver.findElement(By.xpath("//button[starts-with(@id,'paragraphStyle')]")).click();
     Thread.sleep(1000);
     driver.findElement(By.linkText("Heading 1")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//img[@src='../../../../../assets/setting-icon.svg']")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//span[contains(text(),'TEXT SETTING')]")).click();
	 Thread.sleep(1000);
	 
	 Select select = new Select(driver.findElement(By.name("fontSettingName")));
	 select.selectByVisibleText("Heading 1");
	 
  }
  
  @Test(priority = 11)
  public void linkStyle() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'linkStyle')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("Green")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'linkStyle')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("Thick")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'linkEdit')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.name("text")).clear();
	  driver.findElement(By.name("text")).sendKeys("Google Update");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();
	  
  }
  
 @AfterTest
  public void closeBrowser() throws InterruptedException {
  Thread.sleep(3000);
  driver.close();
}
}
