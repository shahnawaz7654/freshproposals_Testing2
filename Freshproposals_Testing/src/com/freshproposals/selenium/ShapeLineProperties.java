package com.freshproposals.selenium;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ShapeLineProperties extends Common_Methods {
	WebDriver driver;
	
	 @BeforeClass
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
	 public void LineProperties() throws InterruptedException {
		 driver.get("http://beta1.freshproposals.com/home/sections/editSection/4875");
		 
	        WebElement TB = driver.findElement(By.xpath("//div[@id='page1-fpShape11520191373511mainDivTransformSafeStyle']"));
	        //Get Width of the element.
	        int TBWIDTH = TB.getSize().getWidth();
	        System.out.println("Width of the Line is"+TBWIDTH);
	        
	        //Get height of element.
	        int TBHEIGHT = TB.getSize().getHeight();        
	        System.out.println("Height of the Line is "+TBHEIGHT);
		
		 driver.findElement(By.xpath("//div[@class='text-element']")).click();
		WebElement length= driver.findElement(By.xpath("//input[@name='textWidth11']"));
		length.clear();
		length.sendKeys("300");
		WebElement rotation= driver.findElement(By.xpath("//input[@name='rotate']"));
		rotation.clear();
		rotation.sendKeys("90");
		
		WebElement width= driver.findElement(By.xpath("//input[@name='borderWidth']"));
		width.clear();
		width.sendKeys("50");
		//Color of the line
		WebElement element =driver.findElement(By.xpath("//span[@class='e-btn-icon e-icons e-caret']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='e-icons e-btn e-flat e-icon-btn e-mode-switch-btn']")).click();
		driver.findElement(By.xpath("//div[10]//span[10]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@title='Apply']")).click();
		
		//CHANGE THE STYLE OF THE LINE
		
		Select LineStyle = new Select(driver.findElement(By.xpath("//select[@name='borderStyle']")));
			for(int i=0;i<=6;i++) {
		
			LineStyle.selectByIndex(i);
			Thread.sleep(3000);

			}
			String index =driver.findElement(By.xpath("//div[@id='page1-fpShape11520191373511mainDivTransformSafeStyle']")).getCssValue("z-index");
			System.out.println(index);
	        WebElement TB1 = driver.findElement(By.xpath("//div[@id='page1-fpShape11520191373511mainDivTransformSafeStyle']"));

			 int TBWIDTH1 = TB1.getSize().getWidth();
		        System.out.println("Width of the Line is"+TBWIDTH1);
		        
		        //Get height of element.
		        int TBHEIGHT1 = TB1.getSize().getHeight();        
		        System.out.println("Height of the Line is "+TBHEIGHT1);
			
		Thread.sleep(10000);
		//driver.quit();
	 }
	 @Test(priority=2)
	 public void shapeResize() {
		  driver.get("http://beta1.freshproposals.com/home/sections/editSection/4875");

		  Actions action = new Actions(driver);
			WebElement element= driver.findElement(By.xpath("//div[@id='page1-fpShape11520191373511mainDivTransformSafeStyle']"));
			int WidthBefore = element.getSize().getWidth();
			System.out.println("Width of the Textbox is"+WidthBefore);
			int HeightBefore = element.getSize().getHeight();        
			System.out.println("Height of the textbox is "+HeightBefore);
			action.moveToElement(element).perform();
			element.click();

			WebElement  shapeResize = driver.findElement(By.xpath("//div[@id='segrip']"));
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
	 @AfterClass
	  public void closeBrowser() throws InterruptedException {
		  Thread.sleep(3000);
		  driver.close();
	  }
	 
	 
}
