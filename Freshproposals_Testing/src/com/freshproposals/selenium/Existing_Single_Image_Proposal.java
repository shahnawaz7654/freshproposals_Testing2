package com.freshproposals.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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

public class Existing_Single_Image_Proposal extends Common_Methods {
	WebDriver driver;
	String unm;
	String pwd;
	
	String width = "420";
	String rotate = "5";
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
		openURL(driver);
	}
  
  @Test(dataProvider = "User1", priority = 0)
 	public void SetUnmPwd(String unm, String pwd) {
     login(unm, pwd, driver);
 }
	
  @Test(priority = 1)
  public void openExistTemplate() throws InterruptedException {
	  Thread.sleep(7000);
	  driver.get("http://beta1.freshproposals.com/home/proposals/editProposal;proposalId=1058;editor=true");
	}
  
  @Test(priority = 2)
  public void width() throws InterruptedException {
	  
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//div[@class='resizers']//img")).click();
	  driver.findElement(By.name("width11")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.name("width11")).sendKeys(width);
	  String actual_width = driver.findElement(By.name("width11")).getAttribute("value");
	  String expected_width = "420";
	  Assert.assertEquals(actual_width, expected_width);
  }
  
  @Test(priority = 3)
  public void Save_width() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
	  Thread.sleep(3000);
	  driver.get("http://beta1.freshproposals.com/home/proposals/editProposal;proposalId=1058;editor=true");
	  Thread.sleep(3000);
	  
 }
  
  @Test(priority = 4)
  public void reflect_width() {
	  driver.findElement(By.xpath("//div[@class='resizers']//img")).click();
	  String actual_reflect_width = driver.findElement(By.xpath("//div[@class='resizers']//img")).getCssValue("width");
	  String expected_reflect_width = width+"px";
	  System.out.println("Rwidth "+actual_reflect_width);
	  System.out.println("reflect width "+expected_reflect_width);
	  Assert.assertEquals(actual_reflect_width, expected_reflect_width);
	  
  }
  
  @Test(priority = 5)
  public void Reset_width() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//div[@class='resizers']//img")).click();
	  driver.findElement(By.name("width11")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.name("width11")).sendKeys("250");
	  
 }
  
  
  @Test(priority = 6)
  public void rotate() throws InterruptedException, AWTException {
	  
	  Thread.sleep(1000);
	  driver.findElement(By.name("rotate")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.name("rotate")).sendKeys(rotate);
	  String actual_rotate = driver.findElement(By.name("rotate")).getAttribute("value");
	  Assert.assertEquals(actual_rotate,rotate);
	  Thread.sleep(1000);
	  
  }
  
//  @Test(priority = 7)
//  public void corner() throws InterruptedException {
//	  //corner
//	  WebElement r = driver.findElement(By.name("cornersApply"));
//	  resize(r, 50, 50);
//	  Thread.sleep(1000);
//  }
  
  @Test(priority = 8)
  public void color() throws InterruptedException {
	 
  Thread.sleep(1000);
  driver.findElement(By.xpath("//span[@class='e-btn-icon e-icons e-caret']")).click();
  Thread.sleep(1000);
  driver.findElement(By.xpath("//input[@class='e-hex']")).clear();
  driver.findElement(By.xpath("//input[@class='e-hex']")).sendKeys("#000000");
  Thread.sleep(2000);
  driver.findElement(By.xpath("//button[@class='e-btn e-css e-flat e-primary e-small e-apply']")).click();
  //driver.findElement(By.xpath("//div[@class='e-hue-slider e-control e-slider e-lib']//div[@class='e-handle e-handle-first']")).click();
//  WebElement r1 = driver.findElement(By.xpath("//div[@class='e-handle e-handle-first']"));
//  resize(r1, 75,75);
//  Thread.sleep(1000);
//  //driver.findElement(By.className("e-hsv-color")).click();
//  driver.findElement(By.xpath("//input[@class='e-hex']")).clear();
//  Thread.sleep(1000);
//  driver.findElement(By.xpath("//input[@class='e-hex']")).sendKeys("#000000");
//  Thread.sleep(2000);
//  driver.findElement(By.xpath("//button[@title='Apply']")).click();
//  Thread.sleep(1000);
  }
  
  
  
  
//  @Test(priority = 9)
//  public void opacity() throws InterruptedException {
//	  
//	  //opacity
//	  Thread.sleep(2000);
//	  WebElement r = driver.findElement(By.name("opacity"));
//	  resize(r,50,50);
//	  //String actual_opacity = driver.findElement(By.name("opacity")).getAttribute("value");
//	  //String expected_opacity = "64";
//	  //Assert.assertEquals(actual_opacity, expected_opacity);
//	 }
  
  @Test(priority = 10)
  public void border_width() throws InterruptedException, AWTException {
	 
	  Robot robot = new Robot();
	  robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	  
	  //border
	  Thread.sleep(1000);
	  driver.findElement(By.name("border")).click();
	  Thread.sleep(1000);
      //border width
	  driver.findElement(By.name("borderWidth")).clear();
	  driver.findElement(By.name("borderWidth")).sendKeys(border_width);
	  String actual_border_width = driver.findElement(By.name("borderWidth")).getAttribute("value");
	  Assert.assertEquals(actual_border_width, border_width);
	  Thread.sleep(1000);
  }
  
  @Test(priority = 11)
  public void border_style() throws InterruptedException {
     
	  //border style
	  Select select = new Select(driver.findElement(By.name("borderStyle")));
	  select.selectByIndex(6);
	  String actual_border_style = select.getFirstSelectedOption().getText();
	  Assert.assertEquals(actual_border_style, border_style);
	  Thread.sleep(1000);
  }
  
  @Test(priority = 12)
  public void padding_top() throws InterruptedException, AWTException {
	  //padding
	  driver.findElement(By.name("padding")).click();
	  Thread.sleep(1000);
	  Robot robot = new Robot();
	  robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	  
	  driver.findElement(By.name("paddingTop")).clear();
	  driver.findElement(By.name("paddingTop")).sendKeys(padding_top);
	  String actual_padding_top = driver.findElement(By.name("paddingTop")).getAttribute("value");
	  Assert.assertEquals(actual_padding_top, padding_top);
	  Thread.sleep(1000);
  }
  
  @Test(priority = 13)
  public void padding_left() throws InterruptedException {
	  
	  driver.findElement(By.name("paddingLeft")).clear();
	  driver.findElement(By.name("paddingLeft")).sendKeys(padding_left);
	  String actual_padding_left = driver.findElement(By.name("paddingLeft")).getAttribute("value");
	  Assert.assertEquals(actual_padding_left, padding_left);
	  Thread.sleep(1000);
  }
  
  @Test(priority = 14)
  public void padding_bottom() throws InterruptedException {
	  
	  driver.findElement(By.name("paddingBottom")).clear();
	  driver.findElement(By.name("paddingBottom")).sendKeys(padding_bottom);
	  String actual_padding_bottom = driver.findElement(By.name("paddingBottom")).getAttribute("value");
	  Assert.assertEquals(actual_padding_bottom, padding_bottom);
	  Thread.sleep(1000);
  }   
//  
  @Test(priority = 15)
  public void padding_right() throws InterruptedException {
	  
	  driver.findElement(By.name("paddingRight")).clear();
	  driver.findElement(By.name("paddingRight")).sendKeys(padding_right);
	  String actual_padding_right = driver.findElement(By.name("paddingRight")).getAttribute("value");
	  Assert.assertEquals(actual_padding_right, padding_right);
  }
  
  @Test(priority = 16)
  public void greyscale() throws InterruptedException, AWTException {
	  //grayscale
	  Robot robot = new Robot();
	  robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	  Thread.sleep(2000);
	  WebElement rgreyscale = driver.findElement(By.name("grayscale"));
	  resize(rgreyscale,50,50);
	  Thread.sleep(1000);
	  //driver.findElement(By.name("flip1")).click();
	  
}

	 @Test(priority = 17)
	  public void save() throws InterruptedException {
		  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
		  Thread.sleep(3000);
		  driver.get("http://beta1.freshproposals.com/home/proposals/editProposal;proposalId=1058;editor=true");
		  
	 }
	         
//	  @Test(priority = 19)
//	  public void reflect_rotate() {
//		  driver.findElement(By.xpath("//div[@class='resizers']//img")).click();
//		  String actual_reflect_rotate = driver.findElement(By.xpath("//div[@class='resizers']//img")).getCssValue("transform: rotate");
//		  System.out.println("Rrotate "+actual_reflect_rotate);
//		  String expected_reflect_rotate = rotate+"px";
//		  System.out.println("reflect rotate "+expected_reflect_rotate);
//		  Assert.assertEquals(actual_reflect_rotate, expected_reflect_rotate);
//		  
//		  
//	  }
	  
//	  @Test(priority = 20)
//	  public void reflect_corner() {
//		  driver.findElement(By.xpath("//div[@class='resizers']//img")).click();
//		  String actual_reflect_corner = driver.findElement(By.xpath("//div[@class='resizers']//img")).getCssValue("border-radius");
//		  System.out.println("Rcorner"+actual_reflect_corner);
//		  String expected_reflect_corner = "76%";
//		  Assert.assertEquals(actual_reflect_corner, expected_reflect_corner);
//		  
//	  }
	
	  @Test(priority = 21)
	  public void reflect_border_width() throws InterruptedException {
		  driver.findElement(By.xpath("//div[@class='resizers']//img")).click();
		  String actual_reflect_border_width = driver.findElement(By.xpath("//div[@class='resizers']//img")).getCssValue("border-width");
		  System.out.println("A = "+actual_reflect_border_width);
		  String expected_reflect_border_width = border_width+"px";
		  System.out.println("E "+expected_reflect_border_width);
		  Assert.assertEquals(actual_reflect_border_width, expected_reflect_border_width);
		  Thread.sleep(5000);
		  
	  }
	  
	  @Test(priority = 22)
	  public void reflect_border_style() throws InterruptedException {
		  driver.findElement(By.xpath("//div[@class='resizers']//img")).click();
		  String actual_reflect_border_style = driver.findElement(By.xpath("//div[@class='resizers']//img")).getCssValue("border-style");
		  System.out.println("A = "+actual_reflect_border_style);
		  String expected_reflect_border_style = border_style;
		  System.out.println("E "+expected_reflect_border_style);
		  Assert.assertEquals(actual_reflect_border_style, expected_reflect_border_style);
		  Thread.sleep(5000);
	  }
		  
	  
	  @Test(priority = 23)
	  public void reflect_padding() throws InterruptedException {
		  driver.findElement(By.xpath("//div[@class='resizers']//img")).click();
		  String actual_reflect_padding_top = driver.findElement(By.xpath("//div[@class='resizers']//img")).getCssValue("padding-top");
		  String actual_reflect_padding_left = driver.findElement(By.xpath("//div[@class='resizers']//img")).getCssValue("padding-left");
		  String actual_reflect_padding_bottom = driver.findElement(By.xpath("//div[@class='resizers']//img")).getCssValue("padding-bottom");
		  String actual_reflect_padding_right = driver.findElement(By.xpath("//div[@class='resizers']//img")).getCssValue("padding-right");
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
		      driver.findElement(By.xpath("//div[@class='resizers']//img")).click();
	
	     //rotate
		      driver.findElement(By.name("rotate")).clear();
			  Thread.sleep(1000);
			  driver.findElement(By.name("rotate")).sendKeys("0"); 
			  Thread.sleep(3000);
			  
			  //color
			  Thread.sleep(1000);
			  driver.findElement(By.xpath("//span[@class='e-btn-icon e-icons e-caret']")).click();
			  Thread.sleep(1000);
			  driver.findElement(By.xpath("//input[@class='e-hex']")).clear();
			  driver.findElement(By.xpath("//input[@class='e-hex']")).sendKeys("#ffffff");
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//button[@class='e-btn e-css e-flat e-primary e-small e-apply']")).click();
			  Thread.sleep(2000);

			  
//		  WebElement corner = driver.findElement(By.name("corners"));
//		  resize(corner, 100, 100);
//		  Thread.sleep(1000);
		  
//		  WebElement opacity = driver.findElement(By.name("opacity"));
//		  resize(opacity, 0, 0);
//		  Thread.sleep(1000);

		  Robot robot = new Robot();
		  robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		  Thread.sleep(5000);
		  //border width
		  driver.findElement(By.name("borderWidth")).clear();
		  driver.findElement(By.name("borderWidth")).sendKeys("0");
		  Thread.sleep(3000);
		  Select select = new Select(driver.findElement(By.name("borderStyle")));
		  select.selectByIndex(2);
		  driver.findElement(By.name("border")).click();
		  
		 
		  Robot robot1 = new Robot();
		  robot1.keyPress(KeyEvent.VK_PAGE_DOWN);
		  
		 
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
		  
		  //opacity
		  //WebElement r1 = driver.findElement(By.name("opacity"));
		  //resize1(r1,100,100);
		  
		  //greyscale		
		  WebElement rgreyscale = driver.findElement(By.name("grayscale"));
		  resize(rgreyscale,-100,-100);
		  
        		  
		  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		  
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
			  
			 
  @AfterClass
  public void closeBrowser() throws InterruptedException {
  Thread.sleep(3000);
  driver.close();
}
  
  
}
