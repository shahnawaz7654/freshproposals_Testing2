package com.freshproposals.selenium;

import java.security.cert.PKIXRevocationChecker.Option;
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

public class Existing_Template extends Common_Methods {
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
	  driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/397");
	}
  
  @Test(priority = 2)
  public void verify_name() throws InterruptedException {
	  
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
	  String actual_textvalue = driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).getText();
	  String expected_textvalue ="Shahnawaz";
	  Assert.assertEquals(actual_textvalue, expected_textvalue);
  }
	  
	  @Test(priority = 3)
	  public void width() throws InterruptedException {
		
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"config-panel-one\"]/div/div/div/div[1]/div/ejs-numerictextbox/span/input[1]")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"config-panel-one\"]/div/div/div/div[1]/div/ejs-numerictextbox/span/input[1]")).sendKeys("650");
	  String actual_width =  driver.findElement(By.xpath("//*[@id=\"config-panel-one\"]/div/div/div/div[1]/div/ejs-numerictextbox/span/input[1]")).getAttribute("value");
	  String expected_width = "650";
	  Assert.assertEquals(actual_width,expected_width);
	  }
	  
	  @Test(priority = 4)
      public void height() throws InterruptedException {
		
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"config-panel-one\"]/div/div/div/div[2]/div/ejs-numerictextbox/span/input[1]")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"config-panel-one\"]/div/div/div/div[2]/div/ejs-numerictextbox/span/input[1]")).sendKeys("600");
	  String actual_height = driver.findElement(By.xpath("//*[@id=\"config-panel-one\"]/div/div/div/div[2]/div/ejs-numerictextbox/span/input[1]")).getAttribute("value");
	  String expected_height = "600";
	  Assert.assertEquals(actual_height,expected_height);
	  }
	  
	  @Test(priority = 5)
      public void rotate() throws InterruptedException {
	
	  Thread.sleep(1000);	  
	  driver.findElement(By.xpath("//*[@id=\"config-panel-one\"]/div/div/div/div[4]/div/ejs-numerictextbox/span/input[1]")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"config-panel-one\"]/div/div/div/div[4]/div/ejs-numerictextbox/span/input[1]")).sendKeys("5"); 
	  String actual_rotate = driver.findElement(By.xpath("//*[@id=\"config-panel-one\"]/div/div/div/div[4]/div/ejs-numerictextbox/span/input[1]")).getAttribute("value"); 
	  String expected_rotate = "5";
	  Assert.assertEquals(actual_rotate,expected_rotate);
	  }
	  
	  @Test(priority = 6)
      public void color() throws InterruptedException {
		
	  Thread.sleep(1000);	  
	  driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/app-text-properties[1]/form[1]/div[1]/div[1]/div[1]/ngb-accordion[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/button[2]")).click();
	  Thread.sleep(1000);
	  WebElement r1 = driver.findElement(By.xpath("//div[@class='e-hue-slider e-control e-slider e-lib']//div[@class='e-handle e-handle-first']"));
	  resize(r1, 75,75);
	  Thread.sleep(1000);
	  driver.findElement(By.className("e-hsv-color")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[@title='Apply']")).click();
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
	  
	  @Test(priority = 7)
      public void opacity() throws InterruptedException {
	  
	  Thread.sleep(1000);
	  WebElement r = driver.findElement(By.name("opacity"));
 	  resize2(r,25,25);
 	  String actual_opacity = driver.findElement(By.name("opacity")).getAttribute("value");
 	  String expected_opacity = "64";
 	  Assert.assertEquals(actual_opacity, expected_opacity);
 	  Thread.sleep(1000);
 	  
	  }
	  public void resize2(WebElement elementToResize, int xOffset, int yOffset) {
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
	  
	  @Test(priority = 8)
      public void border_Width() throws InterruptedException {
	 
      driver.findElement(By.name("border")).click();
      Thread.sleep(1000);
	   //border width
	  driver.findElement(By.xpath("//div[@class='row']//div[@class='row']//input[@class='ng-untouched ng-pristine ng-valid e-control e-numerictextbox e-lib e-input']")).clear();
	  driver.findElement(By.xpath("//div[@class='row']//div[@class='row']//input[@class='ng-untouched ng-pristine ng-valid e-control e-numerictextbox e-lib e-input']")).sendKeys("10");
	  String actual_border_width =  driver.findElement(By.xpath("//div[@class='row']//div[@class='row']//input[@class='ng-untouched ng-pristine ng-valid e-control e-numerictextbox e-lib e-input']")).getAttribute("value");
	  String expected_border_width = "10"; 
	  Assert.assertEquals(actual_border_width, expected_border_width);
	  Thread.sleep(1000);
	  }
	  
	  @Test(priority = 9)
      public void border_Style() throws InterruptedException {
	  
		  Select select = new Select(driver.findElement(By.name("borderStyle")));
		  select.selectByIndex(6);
		  Thread.sleep(1000);
	  }

	  @Test(priority = 10)
      public void padding() throws InterruptedException {
	  
	  driver.findElement(By.name("padding")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.name("paddingTop")).clear();
	  driver.findElement(By.name("paddingTop")).sendKeys("30");
	  Thread.sleep(1000);
	  driver.findElement(By.name("paddingLeft")).clear();
	  driver.findElement(By.name("paddingLeft")).sendKeys("30");
	  Thread.sleep(1000);
	  driver.findElement(By.name("paddingBottom")).clear();
	  driver.findElement(By.name("paddingBottom")).sendKeys("30");
	  Thread.sleep(1000);
	  driver.findElement(By.name("paddingRight")).click();
	  driver.findElement(By.name("paddingRight")).sendKeys("30");
	 }
	  
	  @Test(priority = 11)
      public void paragraphStyle() throws InterruptedException {
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'paragraphStyle')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("Heading 1")).click();
	  String actual_heading =  driver.findElement(By.linkText("Heading 1")).getAttribute("title");
	  String expected_heading = "Heading 1";
	  Assert.assertEquals(actual_heading,expected_heading);
	  
	  }

	  @Test(priority = 12)
      public void setting() throws InterruptedException {
	  driver.findElement(By.xpath("//img[@src='../../../../../assets/setting-icon.svg']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//span[contains(text(),'TEXT SETTING')]")).click();
	  }

	  @Test(priority = 13)
      public void font_Size() throws InterruptedException {
	  Thread.sleep(2000);
	  Select select = new Select(driver.findElement(By.name("fontSize")));
	  select.selectByIndex(15);
	  Thread.sleep(2000);
  }
	  
	  @Test(priority = 14)
      public void BIU() throws InterruptedException {

	  //underline
	  driver.findElement(By.xpath("//i[@class='fa fa-underline pt-2']")).click();
	  //bold
	  driver.findElement(By.xpath("//i[@class='fa fa-bold']")).click();
	  //italic
	  driver.findElement(By.xpath("//i[@name='fontStyle']")).click();
	  Thread.sleep(2000);
	  }
	  
	  @Test(priority = 15)
      public void align() throws InterruptedException {

	  driver.findElement(By.xpath("//img[@src='../../../../../assets/align-table-left.svg']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//img[@src='../../../../../assets/align-table-right.svg']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//img[@src='../../../../../assets/align-table-center.svg']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//img[@src='../../../../../assets/align-table-justify.svg']")).click();
	  Thread.sleep(2000);
	  }
	  
	  @Test(priority = 16)
      public void write() throws InterruptedException {

	 driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys(" I am from Selenium, How are you ???");
	  }
	  
  
  @AfterTest
  public void closeBrowser() throws InterruptedException {
  Thread.sleep(3000);
  driver.close();
}
  
  
}
