package com.freshproposals.selenium;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ShapeRectangleProperties  extends Common_Methods {
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
	
	 @Test(dataProvider = "User2" , priority = 0)
	  
	  public void login(String unm, String pwd) {
		    driver.findElement(By.id("textbox_0")).sendKeys(unm);
			driver.findElement(By.id("textbox_1")).sendKeys(pwd);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		}
	 @Test(priority = 1)
	  public void ShapeRectangle() {
		  driver.get("http://beta1.freshproposals.com/home/sections/editSection/4793");
		String ele=  driver.findElement(By.xpath("//div[@id='page1-fpShape111201911361963mainDivTransformSafeStyle']")).getCssValue("z-index");
		System.out.println(ele);
		 WebElement ShapeDimension = driver.findElement(By.xpath("//div[9]//div[1]"));
	     //Get Width of the element.
	     int TBWIDTH = ShapeDimension.getSize().getWidth();
	     System.out.println("Width of the Rectangle is"+TBWIDTH);
	     
	     //Get height of element.
	     int TBHEIGHT = ShapeDimension.getSize().getHeight();        
	     System.out.println("Height of the Rectangle is "+TBHEIGHT);
		
	  }
	 @Test(priority=2)
	  public void shapeResize() {
		  driver.get("http://beta1.freshproposals.com/home/sections/editSection/4793");

		  Actions action = new Actions(driver);
			WebElement element= driver.findElement(By.xpath("//div[@id='page1-fpShape111201911361963']"));
			int WidthBefore = element.getSize().getWidth();
			System.out.println("Width of the Textbox is"+WidthBefore);
			int HeightAfter = element.getSize().getHeight();        
			System.out.println("Height of the textbox is "+HeightAfter);
			action.moveToElement(element).perform();
			element.click();

			WebElement  shapeResize = driver.findElement(By.xpath("//div[@id='page1-fpShape111201911361963']//div[@id='nwgrip']"));
			resize( shapeResize, 100, 100);
			int Width = element.getSize().getWidth();
			System.out.println("Width of the Textbox is"+Width);
			int Height = element.getSize().getHeight();        
			System.out.println("Height of the textbox is "+Height);

		  
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
	 @Test(priority=3)
		public void ChangeHeightWidth() {
			driver.get("http://beta1.freshproposals.com/home/sections/editSection/4810");
			WebElement element=driver.findElement(By.xpath("//div[@id='page1-fpShape111201915215974mainDivTransformSafeStyle']"));
			element.click();
			WebElement width= driver.findElement(By.xpath("//input[@name='textWidth11']"));
			width.clear();
			width.sendKeys("600");
			WebElement height =driver.findElement(By.xpath("//input[@name='height11']"));
			height.clear();
			height.sendKeys("600");
			int Width = element.getSize().getWidth();
			System.out.println("Width of the Textbox is"+Width);
			int Height = element.getSize().getHeight();        
			System.out.println("Height of the textbox is "+Height);
			
			
		}
		@Test(priority=4)
		public void ShapeCorner() {
			driver.get("http://beta1.freshproposals.com/home/sections/editSection/4810");
			WebElement element=driver.findElement(By.xpath("//div[@id='page1-fpShape111201915215974mainDivTransformSafeStyle']"));
			element.click();
			WebElement corner=driver.findElement(By.xpath("//input[@name='corners']"));
			corner.clear();
			corner.sendKeys("20");
			
		}

	 
}
