package com.freshproposals.selenium;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ResizeTextBox extends Common_Methods{
	WebDriver driver;
	 SoftAssert Assert= new SoftAssert();

	
	 @BeforeTest
	  public void openBrowser() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			driver.get("http://beta1.freshproposals.com");
		}
	 @Test(dataProvider = "User2" , priority = 0)  
	  public void login(String unm, String pwd) {
		    driver.findElement(By.id("textbox_0")).sendKeys(unm);
			driver.findElement(By.id("textbox_1")).sendKeys(pwd);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		}
	 @Test(priority=1)
	 public void ResizeTextBoxandVerify() throws InterruptedException {
		 driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/1143");
		 WebElement textblock =driver.findElement(By.xpath("//div[@id='froalapage1-fpText122201910103246']"));
		  Actions action = new Actions(driver);
			int WidthBefore = textblock.getSize().getWidth();
			Assert.assertEquals(WidthBefore, 48);
			int HeightBefore = textblock.getSize().getHeight();     
			Assert.assertEquals(HeightBefore, 48);
			action.moveToElement(textblock).perform();
			textblock.click();

			WebElement  shapeResize = driver.findElement(By.xpath("//div[@id='segrip']"));
			resize( shapeResize, 400, 400);
			int Width = textblock.getSize().getWidth();
			int Height = textblock.getSize().getHeight();  
			Assert.assertEquals(Width, 448);      
			Assert.assertEquals(Height, 448);
			WebElement savebtn =  driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
			savebtn.click();
			Thread.sleep(5000);
	  		}
	
		 
		 
	 
	 		@Test(priority=2)
	 		public void Resizeback() throws InterruptedException {
	 			 driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/1143");
	 			 WebElement textblock =driver.findElement(By.xpath("//div[@id='froalapage1-fpText122201910103246']"));
	 			  Actions action = new Actions(driver);
	 				int WidthBefore = textblock.getSize().getWidth();
	 				int HeightBefore = textblock.getSize().getHeight();        

	 				Assert.assertEquals(WidthBefore, 448);
	 				Assert.assertEquals(HeightBefore, 448);
	 				action.moveToElement(textblock).perform();
	 				textblock.click();

	 				WebElement  shapeResize = driver.findElement(By.xpath("//div[@id='segrip']"));
	 				resize( shapeResize, -400, -400);
	 				int Width = textblock.getSize().getWidth();
	 				int Height = textblock.getSize().getHeight();   
	 				Assert.assertEquals(Width, 48);     
	 				Assert.assertEquals(Height, 48);
	 				
	 				WebElement savebtn =  driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
	 				savebtn.click();
	 			  Thread.sleep(5000);
	 			
	 		}
	 
		public void resize(WebElement shapeResize, int xOffset, int yOffset) {
			try {
				if (shapeResize.isDisplayed()) {
					Actions action = new Actions(driver);
					action.clickAndHold(shapeResize).moveByOffset(xOffset, yOffset).release().build().perform();
				} else {
					System.out.println("Element was not displayed to drag");
				}
			} catch (StaleElementReferenceException e) {
				System.out.println("Element with " + shapeResize + "is not attached to the page document "	+ e.getStackTrace());
			} catch (NoSuchElementException e) {
				System.out.println("Element " + shapeResize + " was not found in DOM " + e.getStackTrace());
			} catch (Exception e) {
				System.out.println("Unable to resize" + shapeResize+ " - "	+ e.getStackTrace());
			}
		}
		 
		@AfterClass
		public void teardown() {
			driver.close();
		}
	 }


