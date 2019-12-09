package com.freshproposals.selenium;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Signature extends Common_Methods {
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
  public void open_Proposal() throws InterruptedException {
	  driver.get("http://beta1.freshproposals.com/home/proposals/editProposal;proposalId=1109;editor=true");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//div[@class='signature-sec ui-resizable ui-resizable-autohide']")).click();
	  
  }
  
  @Test(priority = 2)
  public void width() throws InterruptedException {
	//width
	  Thread.sleep(1000);
	  driver.findElement(By.name("textWidth11")).clear();
	  driver.findElement(By.name("textWidth11")).sendKeys("300");
	  String actual_width = driver.findElement(By.name("textWidth11")).getAttribute("value");
	  String expected_width = "300";
	  Assert.assertEquals(actual_width, expected_width);
  }
  
  @Test(priority = 3)
  public void height() throws InterruptedException {
	//height
	  Thread.sleep(1000);
	  driver.findElement(By.name("height11")).clear();
	  driver.findElement(By.name("height11")).sendKeys("70");
	  String actual_height = driver.findElement(By.name("height11")).getAttribute("value");
	  String expected_height = "70";
	  Assert.assertEquals(actual_height, expected_height);
  }
  
  @Test(priority = 4)
  public void corner() throws InterruptedException {
	  //corner
	  Thread.sleep(1000);
	  driver.findElement(By.name("corners")).clear();
	  driver.findElement(By.name("corners")).sendKeys("30");
	  String actual_corner = driver.findElement(By.name("corners")).getAttribute("value");
	  String expected_corner = "30";
	  Assert.assertEquals(actual_corner, expected_corner);
  }
  
  @Test(priority = 5)
  public void color() throws InterruptedException {
	  //color   
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/app-signature-properties[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/button[2]\n")).click();
	  Thread.sleep(1000);
	  WebElement r1 = driver.findElement(By.xpath("//div[@class='e-handle e-handle-first']"));
	  resize(r1, 75,75);
	  Thread.sleep(1000);
	  driver.findElement(By.className("e-hsv-color")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[@title='Apply']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.name("border")).click();
	  Thread.sleep(1000);
      //border width
  }
  
  @Test(priority = 6)
  public void border_width() throws InterruptedException {
	  
	  //border width
	  driver.findElement(By.name("borderWidth")).clear();
	  driver.findElement(By.name("borderWidth")).sendKeys("10");
	  String actual_border_width = driver.findElement(By.name("borderWidth")).getAttribute("value");
	  String expected_border_width = "10";
	  Assert.assertEquals(actual_border_width, expected_border_width);
	  Thread.sleep(1000);
  }
  
  @Test(priority = 7)
  public void border_style() throws InterruptedException {
	//border style
	  Select select = new Select(driver.findElement(By.name("borderStyle")));
	  select.selectByIndex(6);
	  String actual_border_style = select.getFirstSelectedOption().getText();
	  String expected_border_style = "inset";
	  Assert.assertEquals(actual_border_style, expected_border_style);
	  Thread.sleep(1000);
  }
  
  @Test(priority = 8)
  public void padding_top() throws InterruptedException {
	  //padding
	  driver.findElement(By.name("padding")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.name("paddingTop")).clear();
	  driver.findElement(By.name("paddingTop")).sendKeys("10");
	  String actual_padding_top = driver.findElement(By.name("paddingTop")).getAttribute("value");
	  String expected_padding_top = "10";
	  Assert.assertEquals(actual_padding_top, expected_padding_top);
  }
  
  @Test(priority = 9)
  public void padding_left() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.findElement(By.name("paddingLeft")).clear();
	  driver.findElement(By.name("paddingLeft")).sendKeys("10");
	  String actual_padding_left = driver.findElement(By.name("paddingLeft")).getAttribute("value");
	  String expected_padding_left = "10";
	  Assert.assertEquals(actual_padding_left, expected_padding_left);
  }
  
  @Test(priority = 10)
  public void pading_bottom() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.findElement(By.name("paddingBottom")).clear();
	  driver.findElement(By.name("paddingBottom")).sendKeys("70");
	  String actual_padding_bottom = driver.findElement(By.name("paddingBottom")).getAttribute("value");
	  String expected_padding_bottom = "70";
	  Assert.assertEquals(actual_padding_bottom, expected_padding_bottom);
  }
  
  @Test(priority = 11)
  public void padding_right() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.findElement(By.name("paddingRight")).clear();
	  driver.findElement(By.name("paddingRight")).sendKeys("10");
	  String actual_padding_right = driver.findElement(By.name("paddingRight")).getAttribute("value");
	  String expected_padding_right = "10";
	  Assert.assertEquals(actual_padding_right,expected_padding_right);
  }
  
  @Test(priority = 12)
  public void signee() throws InterruptedException {
	  //signee
	  Select select1 = new Select(driver.findElement(By.name("signee")));
	  select1.selectByValue("0: Object");
	  String actual_signee = select1.getFirstSelectedOption().getText();
	  String expeted_signee = "Rahul Sharma";
	  Assert.assertEquals(actual_signee, expeted_signee);
	  //check
	  Thread.sleep(1000);
  }
  
  public void resize(WebElement elementToResize, int xOffset, int yOffset) {
		try {
			if (elementToResize.isDisplayed()) {
				Actions action = new Actions(driver);
				action.clickAndHold(elementToResize).moveByOffset(xOffset, yOffset).release().build().perform();
			} else {
				System.out.println("Element was not displayed to drag");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element with " + elementToResize + "is not attached to the page document "	+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + elementToResize + " was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to resize" + elementToResize + " - "	+ e.getStackTrace());
		}
		
	}
  
  @AfterTest
  public void closeBrowser() throws InterruptedException {
  Thread.sleep(3000);
  driver.close();
}
  
}
