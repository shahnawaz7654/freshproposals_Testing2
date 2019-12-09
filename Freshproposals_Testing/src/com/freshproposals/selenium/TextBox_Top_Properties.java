package com.freshproposals.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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
	  String actual_heading1 = driver.findElement(By.linkText("Heading 1")).getAttribute("title");
	  String expected_heading1 = "Heading 1";
	  Assert.assertEquals(actual_heading1, expected_heading1);
	  
	  
	  Thread.sleep(1000);
	  //paragraph button
	  driver.findElement(By.xpath("//button[starts-with(@id,'paragraphStyle')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("Heading 2")).click();
	  String actual_heading2 = driver.findElement(By.linkText("Heading 2")).getAttribute("title");
	  String expected_heading2 = "Heading 2";
	  Assert.assertEquals(actual_heading2, expected_heading2);
	  
	  
	  Thread.sleep(1000);
	  //paragraph button
	  driver.findElement(By.xpath("//button[starts-with(@id,'paragraphStyle')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("Heading 3")).click();
	  String actual_heading3 = driver.findElement(By.linkText("Heading 3")).getAttribute("title");
	  String expected_heading3 = "Heading 3";
	  Assert.assertEquals(actual_heading3, expected_heading3);
	  
	  
	  Thread.sleep(1000);
	  //paragraph button
	  driver.findElement(By.xpath("//button[starts-with(@id,'paragraphStyle')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("Heading 4")).click();
	  String actual_heading4 = driver.findElement(By.linkText("Heading 4")).getAttribute("title");
	  String expected_heading4 = "Heading 4";
	  Assert.assertEquals(actual_heading4, expected_heading4);
	  
	  
	  Thread.sleep(1000);
	  //paragraph button
	  driver.findElement(By.xpath("//button[starts-with(@id,'paragraphStyle')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("Body")).click();
	  String actual_body = driver.findElement(By.linkText("Body")).getAttribute("title");
	  String expected_body = "Body";
	  Assert.assertEquals(actual_body, expected_body);
	  
	  
	  Thread.sleep(1000);
	  //paragraph button
	  driver.findElement(By.xpath("//button[starts-with(@id,'paragraphStyle')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("Quote")).click();
	  String actual_quote = driver.findElement(By.linkText("Quote")).getAttribute("title");
	  String expected_quote = "Quote";
	  Assert.assertEquals(actual_quote, expected_quote);
	  
	 }
  
  @Test(enabled = false)
  public void fontSize() throws InterruptedException {
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
	  String actual_default = driver.findElement(By.linkText("Default")).getAttribute("title");
	  String expected_default = "Default";
	  Assert.assertEquals(actual_default, expected_default);
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'lineHeight')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("Single")).click();
	  String actual_single = driver.findElement(By.linkText("Single")).getAttribute("title");
	  String expected_single = "Single";
	  Assert.assertEquals(actual_single, expected_single);
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'lineHeight')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("1.15")).click();
	  String actual_digit1 = driver.findElement(By.linkText("1.15")).getAttribute("title");
	  String expected_digit1 = "1.15";
	  Assert.assertEquals(actual_digit1, expected_digit1);
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'lineHeight')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("1.5")).click();
	  String actual_digit2 = driver.findElement(By.linkText("1.5")).getAttribute("title");
	  String expected_digit2 = "1.5";
	  Assert.assertEquals(actual_digit2, expected_digit2);
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'lineHeight')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("Double")).click();
	  String actual_double = driver.findElement(By.linkText("Double")).getAttribute("title");
	  String expected_double = "Double";
	  Assert.assertEquals(actual_double, expected_double);
	  
	}
  
  @Test(priority = 6)
  public void align() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'align')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[@title='Align Left']")).click();
	  //System.out.println(driver.findElement(By.xpath("//a[@title='Align Left']")).getCssValue("text-align"));
	  
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
	  String actual_default = driver.findElement(By.xpath("//div[@id='dropdown-menu-formatOLOptions-1']//a[@class='fr-command'][contains(text(),'Default')]")).getAttribute("title");
	  String expected_default = "Default";
	  Assert.assertEquals(actual_default, expected_default);
	  
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'formatOLOptions')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[contains(text(),'Lower Alpha')]")).click();
	  String actual_loweralpha = driver.findElement(By.xpath("//a[contains(text(),'Lower Alpha')]")).getAttribute("title");
	  String expected_loweralpha = "Lower Alpha";
	  Assert.assertEquals(actual_loweralpha, expected_loweralpha);
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'formatOLOptions')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[contains(text(),'Lower Greek')]")).click();
	  String actual_lowergreek = driver.findElement(By.xpath("//a[contains(text(),'Lower Greek')]")).getAttribute("title");
	  String expected_lowergreek = "Lower Greek";
	  Assert.assertEquals(actual_lowergreek, expected_lowergreek);
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'formatOLOptions')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[contains(text(),'Lower Roman')]")).click();
	  String actual_lowerroman = driver.findElement(By.xpath("//a[contains(text(),'Lower Roman')]")).getAttribute("title");
	  String expected_lowerroman = "Lower Roman";
	  Assert.assertEquals(actual_lowerroman, expected_lowerroman);
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'formatOLOptions')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[contains(text(),'Upper Alpha')]")).click();
	  String actual_upperalpha = driver.findElement(By.xpath("//a[contains(text(),'Upper Alpha')]")).getAttribute("title");
	  String expected_upperalpha = "Upper Alpha";
	  Assert.assertEquals(actual_upperalpha, expected_upperalpha);
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'formatOLOptions')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[contains(text(),'Upper Roman')]")).click();
	  String actual_upperroman = driver.findElement(By.xpath("//a[contains(text(),'Upper Roman')]")).getAttribute("title");
	  String expected_upperroman = "Upper Roman";
	  Assert.assertEquals(actual_upperroman, expected_upperroman);
  }
  
  @Test(priority = 8)
  public void unorderList() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'formatULOptions')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//div[@id='dropdown-menu-formatULOptions-1']//a[@class='fr-command'][contains(text(),'Default')]")).click();
	  String actual_default = driver.findElement(By.xpath("//div[@id='dropdown-menu-formatULOptions-1']//a[@class='fr-command'][contains(text(),'Default')]")).getAttribute("title");
	  String expected_default = "Default";
	  Assert.assertEquals(actual_default, expected_default);
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'formatULOptions')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[contains(text(),'Circle')]")).click();
	  String actual_circle = driver.findElement(By.xpath("//a[contains(text(),'Circle')]")).getAttribute("title");
	  String expected_circle = "Circle";
	  Assert.assertEquals(actual_circle, expected_circle);
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'formatULOptions')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[contains(text(),'Disc')]")).click();
	  String actual_disc = driver.findElement(By.xpath("//a[contains(text(),'Disc')]")).getAttribute("title");
	  String expected_disc = "Disc";
	  Assert.assertEquals(actual_disc, expected_disc);
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'formatULOptions')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[contains(text(),'Square')]")).click();
	  String actual_square = driver.findElement(By.xpath("//a[contains(text(),'Square')]")).getAttribute("title");
	  String expected_square = "Square";
	  Assert.assertEquals(actual_square, expected_square);
	
  }
  
  @Test(priority = 9)
  public void insertLink() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'insertLink')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.name("href")).sendKeys("www.google.com");
//	  String actual_link = driver.findElement(By.name("href")).getText();
//	  String expected_link = "www.google.com";
//	  Assert.assertEquals(actual_link, expected_link);
//	  Thread.sleep(1000);
	  driver.findElement(By.name("text")).sendKeys("Google");
//	  System.out.println(driver.findElement(By.name("text")).getText());
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
