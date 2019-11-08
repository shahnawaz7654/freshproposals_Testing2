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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Existing_Template {
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
  
  @Test(priority = 0)
  public void login() {
		driver.findElement(By.id("textbox_0")).sendKeys("shahnawaz@zenincloud.com");
		driver.findElement(By.id("textbox_1")).sendKeys("Shahnawaz@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
  @Test(priority = 1)
  public void openExistTemplate() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/397");
	}
  
  @Test(priority = 2)
  public void properties() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
	  System.out.println( driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).getCssValue("z-index"));	 
	  //width
	  driver.findElement(By.xpath("//*[@id=\"config-panel-one\"]/div/div/div/div[1]/div/ejs-numerictextbox/span/input[1]")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"config-panel-one\"]/div/div/div/div[1]/div/ejs-numerictextbox/span/input[1]")).sendKeys("650");
	  //height
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"config-panel-one\"]/div/div/div/div[2]/div/ejs-numerictextbox/span/input[1]")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"config-panel-one\"]/div/div/div/div[2]/div/ejs-numerictextbox/span/input[1]")).sendKeys("600");
	  //rotate
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"config-panel-one\"]/div/div/div/div[4]/div/ejs-numerictextbox/span/input[1]")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"config-panel-one\"]/div/div/div/div[4]/div/ejs-numerictextbox/span/input[1]")).sendKeys("5");
	  //color
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/app-text-properties[1]/form[1]/div[1]/div[1]/div[1]/ngb-accordion[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/button[2]")).click();
	  Thread.sleep(1000);
	  WebElement r1 = driver.findElement(By.xpath("//div[@class='e-handle e-handle-first e-handle-start']"));
	  resize(r1, 75,75);
	  Thread.sleep(1000);
	  driver.findElement(By.className("e-hsv-color")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[@title='Apply']")).click();
	  Thread.sleep(1000);
	  //opacity
	  WebElement r = driver.findElement(By.name("opacity"));
	  resize(r,25,25);
	  Thread.sleep(2000);
	  //border
	  driver.findElement(By.name("border")).click();
	  Thread.sleep(1000);
      //driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/app-image-properties[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[8]/div[2]/div[1]/div[1]/div[1]/div[1]/button[2]")).click();
      //border width
	  driver.findElement(By.xpath("//div[@class='row']//div[@class='row']//input[@class='ng-untouched ng-pristine ng-valid e-control e-numerictextbox e-lib e-input']")).clear();
	  driver.findElement(By.xpath("//div[@class='row']//div[@class='row']//input[@class='ng-untouched ng-pristine ng-valid e-control e-numerictextbox e-lib e-input']")).sendKeys("10");
	  Thread.sleep(1000);
	  //border style
	  Select select = new Select(driver.findElement(By.name("borderStyle")));
	  select.selectByIndex(6);
	  Thread.sleep(1000);
	  //padding
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
	 
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
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
		
  
  @Test(priority = 3)
  public void paragraphStyle() throws InterruptedException {
	  Thread.sleep(2000);
	  //paragraph button
	  driver.findElement(By.id("paragraphStyle-1")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("Heading 1")).click();
  }
  
  @Test(priority = 4)
  public void setting() throws InterruptedException {
	  driver.findElement(By.xpath("//img[@src='../../../../../assets/setting-icon.svg']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//span[contains(text(),'TEXT SETTING')]")).click();
	  //font size
	  Thread.sleep(2000);
	  Select select = new Select(driver.findElement(By.name("fontSize")));
	  select.selectByIndex(15);
	  Thread.sleep(2000);
	  //underline
	  driver.findElement(By.xpath("//i[@class='fa fa-underline pt-2']")).click();
	  //bold
	  driver.findElement(By.xpath("//i[@class='fa fa-bold']")).click();
	  //italic
	  driver.findElement(By.xpath("//i[@name='fontStyle']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//img[@src='../../../../../assets/align-table-left.svg']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//img[@src='../../../../../assets/align-table-right.svg']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//img[@src='../../../../../assets/align-table-center.svg']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//img[@src='../../../../../assets/align-table-justify.svg']")).click();
	  Thread.sleep(2000);
	  //write on text box
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys(" I am from Selenium, How are you ???");
      Thread.sleep(3000);
  }
  
  @AfterTest
  public void closeBrowser() throws InterruptedException {
  Thread.sleep(3000);
  driver.close();
}
  
  
}
