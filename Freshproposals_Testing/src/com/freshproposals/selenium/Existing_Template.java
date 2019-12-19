package com.freshproposals.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Existing_Template extends Common_Methods {
	WebDriver driver;
	String fname = "SEL";
	String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	String width = "650";
	String height = "600";
	String rotate = "5";
	String opacity ="64";
	String border_width = "10";
	String border_style = "inset";
	String padding_top = "30";
	String padding_left = "30";
	String padding_bottom = "30";
	String padding_right = "30";
	
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
  public void openExistTemplate() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/397");
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
	
  }
	  
	  @Test(priority = 2)
	  public void width() throws InterruptedException {
		
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"config-panel-one\"]/div/div/div/div[1]/div/ejs-numerictextbox/span/input[1]")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"config-panel-one\"]/div/div/div/div[1]/div/ejs-numerictextbox/span/input[1]")).sendKeys(width);
	  String actual_width =  driver.findElement(By.xpath("//*[@id=\"config-panel-one\"]/div/div/div/div[1]/div/ejs-numerictextbox/span/input[1]")).getAttribute("value");

	  Assert.assertEquals(actual_width,width);
	  }
	  
	  @Test(priority = 3)
      public void height() throws InterruptedException {
		
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"config-panel-one\"]/div/div/div/div[2]/div/ejs-numerictextbox/span/input[1]")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"config-panel-one\"]/div/div/div/div[2]/div/ejs-numerictextbox/span/input[1]")).sendKeys(height);
	  String actual_height = driver.findElement(By.xpath("//*[@id=\"config-panel-one\"]/div/div/div/div[2]/div/ejs-numerictextbox/span/input[1]")).getAttribute("value");

	  Assert.assertEquals(actual_height,height);
	  }
	  
	  @Test(priority = 4)
	  public void Save_height_width() throws InterruptedException {
		  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
		  Thread.sleep(3000);
		  driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/397");
		  
	 }
	  
	  @Test(priority = 5)
	  public void reflect_width() {
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
		  String actual_reflect_width = driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).getCssValue("width");
		  String expected_reflect_width = width+"px";
		  System.out.println("Rwidth "+actual_reflect_width);
		  System.out.println("reflect width "+expected_reflect_width);
		  Assert.assertEquals(actual_reflect_width, expected_reflect_width);
		  
	  }
	  
	  @Test(priority = 6)
	  public void reflect_height() {
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
		  String actual_reflect_height = driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).getCssValue("height");
		  System.out.println("Rheight "+actual_reflect_height);
		  String expected_reflect_height = height+"px";
		  System.out.println("reflect height "+expected_reflect_height);
		  Assert.assertEquals(actual_reflect_height, expected_reflect_height);
	  }
	  
	  
	  @Test(priority = 7)
	  public void Reset_height_width() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
	  driver.findElement(By.xpath("//*[@id=\"config-panel-one\"]/div/div/div/div[1]/div/ejs-numerictextbox/span/input[1]")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"config-panel-one\"]/div/div/div/div[1]/div/ejs-numerictextbox/span/input[1]")).sendKeys("100");
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"config-panel-one\"]/div/div/div/div[2]/div/ejs-numerictextbox/span/input[1]")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"config-panel-one\"]/div/div/div/div[2]/div/ejs-numerictextbox/span/input[1]")).sendKeys("70");
		  
	 }
	  
	  
	  @Test(priority = 8)
      public void rotate() throws InterruptedException {
	
	  Thread.sleep(1000);	  
	  driver.findElement(By.xpath("//*[@id=\"config-panel-one\"]/div/div/div/div[4]/div/ejs-numerictextbox/span/input[1]")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"config-panel-one\"]/div/div/div/div[4]/div/ejs-numerictextbox/span/input[1]")).sendKeys(rotate); 
	  String actual_rotate = driver.findElement(By.xpath("//*[@id=\"config-panel-one\"]/div/div/div/div[4]/div/ejs-numerictextbox/span/input[1]")).getAttribute("value"); 
	  
	  Assert.assertEquals(actual_rotate,rotate);
	  }
	  
	  @Test(priority = 9)
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
	  
	  @Test(priority = 10)
      public void opacity() throws InterruptedException {
	  
	  Thread.sleep(1000);
	  WebElement r = driver.findElement(By.name("opacity"));
 	  resize2(r,25,25);
 	  String actual_opacity = driver.findElement(By.name("opacity")).getAttribute("value");
 	  System.out.println(actual_opacity);
 	  Assert.assertEquals(actual_opacity, opacity);
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
	  
	  @Test(priority = 11)
      public void border_Width() throws InterruptedException {
	 
      driver.findElement(By.name("border")).click();
      Thread.sleep(1000);
	   //border width
	  driver.findElement(By.xpath("//div[@class='row']//div[@class='row']//input[@class='ng-untouched ng-pristine ng-valid e-control e-numerictextbox e-lib e-input']")).clear();
	  driver.findElement(By.xpath("//div[@class='row']//div[@class='row']//input[@class='ng-untouched ng-pristine ng-valid e-control e-numerictextbox e-lib e-input']")).sendKeys(border_width);
	  String actual_border_width =  driver.findElement(By.xpath("//div[@class='row']//div[@class='row']//input[@class='ng-untouched ng-pristine ng-valid e-control e-numerictextbox e-lib e-input']")).getAttribute("value"); 
	  Assert.assertEquals(actual_border_width, border_width);
	  Thread.sleep(1000);
	  }
	  
	  @Test(priority = 12)
      public void border_Style() throws InterruptedException {
	     	
		  Select select = new Select(driver.findElement(By.name("borderStyle")));
		  select.selectByIndex(6);
		  Thread.sleep(1000);
	  }
	  

	  @Test(priority = 13)
      public void padding() throws InterruptedException, AWTException {
	  
	  driver.findElement(By.name("padding")).click();
	  Thread.sleep(1000);
	  
	  Robot robot = new Robot();
	  robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	  driver.findElement(By.name("paddingTop")).clear();
	  driver.findElement(By.name("paddingTop")).sendKeys(padding_top);
	  Thread.sleep(1000);
	  driver.findElement(By.name("paddingLeft")).clear();
	  driver.findElement(By.name("paddingLeft")).sendKeys(padding_left);
	  Thread.sleep(1000);
	  driver.findElement(By.name("paddingBottom")).clear();
	  driver.findElement(By.name("paddingBottom")).sendKeys(padding_bottom);
	  Thread.sleep(1000);
	  driver.findElement(By.name("paddingRight")).clear();
	  driver.findElement(By.name("paddingRight")).sendKeys(padding_right);
	 }
	  
////	  @Test(priority = 10)
////      public void paragraphStyle() throws InterruptedException {
////	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
////	  Thread.sleep(2000);
////	  driver.findElement(By.xpath("//button[starts-with(@id,'paragraphStyle')]")).click();
////	  Thread.sleep(1000);
////	  driver.findElement(By.linkText("Heading 1")).click();
////	  String actual_heading =  driver.findElement(By.linkText("Heading 1")).getAttribute("title");
////	  String expected_heading = "Heading 1";
////	  Assert.assertEquals(actual_heading,expected_heading);
////	  
////	  }
//
////	  @Test(priority = 11)
////      public void setting() throws InterruptedException {
////	  driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/app-template-properties[1]/form[1]/div[1]/div[2]/img[1]")).click();
////	  driver.findElement(By.xpath("//img[@src='../../../../../assets/setting-icon.svg']")).click();
////	  Thread.sleep(2000);
////	  //driver.findElement(By.xpath("//span[contains(text(),'TEXT SETTING')]")).click();
////	  }
//
////	  @Test(priority = 12)
////      public void font_Size() throws InterruptedException {
////	  Thread.sleep(2000);
////	  Select select = new Select(driver.findElement(By.name("fontSize")));
////	  select.selectByIndex(15);
////	  Thread.sleep(2000);
////  }
////	  
////	  @Test(priority = 13)
////      public void BIU() throws InterruptedException {
////
////	  //underline
////	  driver.findElement(By.xpath("//i[@class='fa fa-underline pt-2']")).click();
////	  //bold
////	  driver.findElement(By.xpath("//i[@class='fa fa-bold']")).click();
////	  //italic
////	  driver.findElement(By.xpath("//i[@name='fontStyle']")).click();
////	  Thread.sleep(2000);
////	  }
////	  
////	  @Test(priority = 14)
////      public void align() throws InterruptedException {
////
////	  driver.findElement(By.xpath("//img[@src='../../../../../assets/align-table-left.svg']")).click();
////	  Thread.sleep(2000);
////	  driver.findElement(By.xpath("//img[@src='../../../../../assets/align-table-right.svg']")).click();
////	  Thread.sleep(2000);
////	  driver.findElement(By.xpath("//img[@src='../../../../../assets/align-table-center.svg']")).click();
////	  Thread.sleep(2000);
////	  driver.findElement(By.xpath("//img[@src='../../../../../assets/align-table-justify.svg']")).click();
////	  Thread.sleep(2000);
////	  }
////	  
////	  @Test(priority = 15)
////      public void write() throws InterruptedException {
////
////	 driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys(" I am from Selenium, How are you ???");
////	  }
////	  
	  @Test(priority = 16)
	  public void save() throws InterruptedException {
		  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
		  Thread.sleep(3000);
		  driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/397");
		  
	 }
	  
	  
//	  @Test(priority = 19)
//	  public void reflect_rotate() {
//		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
//		  String actual_reflect_rotate = driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).getCssValue("rotate");
//		  System.out.println("Rrotate "+actual_reflect_rotate);
//		  String expected_reflect_rotate = rotate+"px";
//		  System.out.println("reflect rotate "+expected_reflect_rotate);
//		  Assert.assertEquals(actual_reflect_rotate, expected_reflect_rotate);
//		  
//	  }
	  
//	  @Test(priority = 20)
//	  public void reflect_opacity() {
//		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
//		  String actual_reflect_opacity = driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).getCssValue("opacity");
//		  System.out.println(actual_reflect_opacity);
//		  String expected_reflect_opacity = opacity+"px";
//		  System.out.println("reflect opacity "+expected_reflect_opacity);
//		  Assert.assertEquals(actual_reflect_opacity, expected_reflect_opacity);
//		  
//	  }
//	
	  @Test(priority = 21)
	  public void reflect_border_width() throws InterruptedException {
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
		  String actual_reflect_border_width = driver.findElement(By.className("resizers")).getCssValue("border-width");
		  System.out.println("reflect_border_width = "+actual_reflect_border_width);
		  String expected_reflect_border_width = border_width+"px";
		  System.out.println("reflect border_width "+expected_reflect_border_width);
		  Assert.assertEquals(actual_reflect_border_width, expected_reflect_border_width);
		  Thread.sleep(5000);
		  
	  }
	  
	  @Test(priority = 22)
	  public void reflect_border_style() throws InterruptedException {
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
		  String actual_reflect_border_style = driver.findElement(By.className("resizers")).getCssValue("border-style");
		  System.out.println("reflect = "+actual_reflect_border_style);
		  String expected_reflect_border_style = border_style;
		  System.out.println("reflect border_style "+expected_reflect_border_style);
		  Assert.assertEquals(actual_reflect_border_style, expected_reflect_border_style);
		  Thread.sleep(5000);
		  
	  }
	  
	  @Test(priority = 23)
	  public void reflect_padding() throws InterruptedException {
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
		  String actual_reflect_padding_top = driver.findElement(By.id("froalapage1-fpText9302019191351")).getCssValue("padding-top");
		  String actual_reflect_padding_left = driver.findElement(By.id("froalapage1-fpText9302019191351")).getCssValue("padding-left");
		  String actual_reflect_padding_bottom = driver.findElement(By.id("froalapage1-fpText9302019191351")).getCssValue("padding-bottom");
		  String actual_reflect_padding_right = driver.findElement(By.id("froalapage1-fpText9302019191351")).getCssValue("padding-right");
		  System.out.println("reflect_top = "+actual_reflect_padding_top);
		  System.out.println("reflect_left = "+actual_reflect_padding_left);
		  System.out.println("reflect_bottom = "+actual_reflect_padding_bottom);
		  System.out.println("reflect_right = "+actual_reflect_padding_right);
		  String expected_reflect_padding_top = padding_top+"px";
		  String expected_reflect_padding_left = padding_left+"px";
		  String expected_reflect_padding_bottom = padding_bottom+"px";
		  String expected_reflect_padding_right = padding_right+"px";
		  
		  Assert.assertEquals(actual_reflect_padding_top, expected_reflect_padding_top);
		  Assert.assertEquals(actual_reflect_padding_left, expected_reflect_padding_left);
		  Assert.assertEquals(actual_reflect_padding_bottom, expected_reflect_padding_bottom);
		  Assert.assertEquals(actual_reflect_padding_right, expected_reflect_padding_right);
		  Thread.sleep(5000);
		  
	  }
	
	 
	  
	  
	  @Test(priority = 24)
	  public void Reset_All() throws InterruptedException, AWTException {
          Thread.sleep(1000);
		      driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
	
	     //rotate
		  Thread.sleep(1000);	  
		  driver.findElement(By.xpath("//*[@id=\"config-panel-one\"]/div/div/div/div[4]/div/ejs-numerictextbox/span/input[1]")).clear();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//*[@id=\"config-panel-one\"]/div/div/div/div[4]/div/ejs-numerictextbox/span/input[1]")).sendKeys("0"); 

		  Thread.sleep(5000);
		  //border width
		  driver.findElement(By.xpath("//div[@class='row']//div[@class='row']//input[@class='ng-untouched ng-pristine ng-valid e-control e-numerictextbox e-lib e-input']")).clear();
		  driver.findElement(By.xpath("//div[@class='row']//div[@class='row']//input[@class='ng-untouched ng-pristine ng-valid e-control e-numerictextbox e-lib e-input']")).sendKeys("0");
		  
		  Thread.sleep(3000);
		  Select select = new Select(driver.findElement(By.name("borderStyle")));
		  select.selectByIndex(2);
		  driver.findElement(By.name("border")).click();
		  
		  //color
//		  Thread.sleep(1000);	  
//		  driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/app-text-properties[1]/form[1]/div[1]/div[1]/div[1]/ngb-accordion[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/button[2]")).click();
//		  Thread.sleep(1000);
//		  WebElement r1 = driver.findElement(By.xpath("//div[@class='e-hue-slider e-control e-slider e-lib']//div[@class='e-handle e-handle-first']"));
//		  resize3(r1, 5,5);
//		  Thread.sleep(1000);
//		  driver.findElement(By.className("e-hsv-color")).click();
//		  Thread.sleep(1000);
//		  driver.findElement(By.xpath("//button[@title='Apply']")).click();
//		  
		  
			//opacity
			
			 Thread.sleep(1000);
			  WebElement r = driver.findElement(By.name("opacity"));
		 	  resize4(r,100,100);
		 	  
		 	  
		  Robot robot = new Robot();
		  robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		  
		 
		  driver.findElement(By.name("paddingTop")).clear();
		  driver.findElement(By.name("paddingTop")).sendKeys("0");
		  Thread.sleep(1000);
		  driver.findElement(By.name("paddingLeft")).clear();
		  driver.findElement(By.name("paddingLeft")).sendKeys("0");
		  Thread.sleep(1000);
		  driver.findElement(By.name("paddingBottom")).clear();
		  driver.findElement(By.name("paddingBottom")).sendKeys("0");
		  Thread.sleep(1000);
		  driver.findElement(By.name("paddingRight")).clear();
		  driver.findElement(By.name("paddingRight")).sendKeys("0");
		  
		  driver.findElement(By.name("padding")).click();
		  
         		  
		  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		  
	  }
			  
			  public void resize3(WebElement elementToResize, int xOffset, int yOffset) throws AWTException, InterruptedException {
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
					
					 public void resize4(WebElement elementToResize, int xOffset, int yOffset) {
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
	  
	  
  
  @AfterClass
  public void closeBrowser() throws InterruptedException {
  Thread.sleep(3000);
  driver.close();
}
  
  
}
