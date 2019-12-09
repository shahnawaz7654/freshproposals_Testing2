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

public class Existing_Single_Image extends Common_Methods {
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
  public void openExistTemplate() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.get("http://beta1.freshproposals.com/home/proposals/editProposal;proposalId=1058;editor=true");
	}
  
  @Test(priority = 2)
  public void width() throws InterruptedException {
	  
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//div[@class='resizers']//img")).click();
	  driver.findElement(By.name("width11")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.name("width11")).sendKeys("420");
	  String actual_width = driver.findElement(By.name("width11")).getAttribute("value");
	  String expected_width = "420";
	  Assert.assertEquals(actual_width, expected_width);
  }
  
  @Test(priority = 3)
  public void rotate() throws InterruptedException {
	  
	  Thread.sleep(1000);
	  driver.findElement(By.name("rotate")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.name("rotate")).sendKeys("5");
	  String actual_rotate = driver.findElement(By.name("rotate")).getAttribute("value");
	  String expected_rotate = "5";
	  Assert.assertEquals(actual_rotate, expected_rotate);
	  Thread.sleep(1000);
  }
  
  @Test(priority = 4)
  public void color() throws InterruptedException {
	 
	  driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/app-image-properties[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/button[2]")).click();
	  System.out.println(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/app-image-properties[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/button[2]")).getCssValue("color"));
	  Thread.sleep(1000);
	  WebElement r1 = driver.findElement(By.xpath("//div[@class='e-handle e-handle-first e-handle-start']"));
	  System.out.println(driver.findElement(By.xpath("//div[@class='e-handle e-handle-first e-handle-start']")).getCssValue("color"));
	  resize(r1, 75,75);
	  Thread.sleep(1000);
	  driver.findElement(By.className("e-hsv-color")).click();
	  driver.findElement(By.className("e-hsv-color")).getCssValue("color");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[@title='Apply']")).click();
  }
  
  @Test(priority = 5)
  public void corner() throws InterruptedException {
	  //corner
	  driver.findElement(By.name("corners")).clear();
	  driver.findElement(By.name("corners")).sendKeys("100");
	  String actual_corner = driver.findElement(By.name("corners")).getAttribute("value");
	  String expeted_corner = "100";
	  Assert.assertEquals(actual_corner, expeted_corner);
	  Thread.sleep(1000);
  }
  
  @Test(priority = 6)
  public void opacity() {
	  
	  //opacity
	  WebElement r = driver.findElement(By.name("opacity"));
	  resize(r,25,25);
	  String actual_opacity = driver.findElement(By.name("opacity")).getAttribute("value");
	  String expected_opacity = "64";
	  Assert.assertEquals(actual_opacity, expected_opacity);
	 }
  
  @Test(priority = 7)
  public void border_width() throws InterruptedException {
	 
	  //border
	  driver.findElement(By.name("border")).click();
	  Thread.sleep(1000);
      //border width
	  driver.findElement(By.name("borderWidth")).clear();
	  driver.findElement(By.name("borderWidth")).sendKeys("10");
	  String actual_border_width = driver.findElement(By.name("borderWidth")).getAttribute("value");
	  String expected_border_width = "10";
	  Assert.assertEquals(actual_border_width, expected_border_width);
	  Thread.sleep(1000);
  }
  
  @Test(priority = 8)
  public void border_style() throws InterruptedException {
     
	  //border style
	  Select select = new Select(driver.findElement(By.name("borderStyle")));
	  select.selectByIndex(6);
	  String actual_border_style = select.getFirstSelectedOption().getText();
	  String expected_border_style = "inset";
	  Assert.assertEquals(actual_border_style, expected_border_style);
	  Thread.sleep(1000);
  }
  
  @Test(priority = 9)
  public void padding_top() throws InterruptedException {
	  //padding
	  driver.findElement(By.name("padding")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.name("paddingTop")).clear();
	  driver.findElement(By.name("paddingTop")).sendKeys("30");
	  String actual_padding_top = driver.findElement(By.name("paddingTop")).getAttribute("value");
	  String expected_padding_top = "30";
	  Assert.assertEquals(actual_padding_top, expected_padding_top);
	  Thread.sleep(1000);
  }
  
  @Test(priority = 10)
  public void padding_left() throws InterruptedException {
	  
	  driver.findElement(By.name("paddingLeft")).clear();
	  driver.findElement(By.name("paddingLeft")).sendKeys("30");
	  String actual_padding_left = driver.findElement(By.name("paddingLeft")).getAttribute("value");
	  String expected_padding_left = "30";
	  Assert.assertEquals(actual_padding_left, expected_padding_left);
	  Thread.sleep(1000);
  }
  
  @Test(priority = 11)
  public void padding_bottom() throws InterruptedException {
	  
	  driver.findElement(By.name("paddingBottom")).clear();
	  driver.findElement(By.name("paddingBottom")).sendKeys("30");
	  String actual_padding_bottom = driver.findElement(By.name("paddingBottom")).getAttribute("value");
	  String expected_padding_bottom = "30";
	  Assert.assertEquals(actual_padding_bottom, expected_padding_bottom);
	  Thread.sleep(1000);
  }
  
  @Test(priority = 12)
  public void padding_right() throws InterruptedException {
	  
	  driver.findElement(By.name("paddingRight")).clear();
	  driver.findElement(By.name("paddingRight")).sendKeys("30");
	  String actual_padding_right = driver.findElement(By.name("paddingRight")).getAttribute("value");
	  String expected_padding_right = "30";
	  Assert.assertEquals(actual_padding_right, expected_padding_right);
  }
  
  @Test(priority = 13)
  public void greyscale() throws InterruptedException {
	  //grayscale
	  Thread.sleep(2000);
	  WebElement rgreyscale = driver.findElement(By.name("grayscale"));
	  resize(rgreyscale,100,100);
	  Thread.sleep(1000);
	  driver.findElement(By.name("flip1")).click();
	  
}

	  //opacity method
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
