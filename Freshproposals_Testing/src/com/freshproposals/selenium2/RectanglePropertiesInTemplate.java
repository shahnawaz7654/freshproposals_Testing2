package com.freshproposals.selenium2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.freshproposals.selenium.Common_Methods;

public class RectanglePropertiesInTemplate extends Common_Methods{
	WebDriver driver;

	String width ="491";
	String height ="567";

	
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
	  
	  public void login(String unm, String pwd) throws InterruptedException {
		    driver.findElement(By.id("textbox_0")).sendKeys(unm);
			driver.findElement(By.id("textbox_1")).sendKeys(pwd);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(4000);
		}
	 @Test(priority =1)
	 public void ChangeRectangleWidthandHeight() throws InterruptedException {
		driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/1250");
		Thread.sleep(3000);
		WebElement Shape = driver.findElement(By.id("page1-fpShape1213201912522970"));
		Thread.sleep(2000);
		Shape.click();
		WebElement RectangleShapeWidth = driver.findElement(By.xpath("//input[@name='textWidth11']"));
		RectangleShapeWidth.clear();
		Thread.sleep(2000);
		RectangleShapeWidth.sendKeys(width);
		WebElement RectangleShapeHeight = driver.findElement(By.xpath("//input[@name='height11']"));
		RectangleShapeHeight.clear();
		Thread.sleep(2000);
		RectangleShapeHeight.sendKeys(height);
		Actions dragger = new Actions(driver);
		WebElement draggablePartOfScrollbar = driver.findElement(By.name("opacity"));
		int numberOfPixelsToDragTheScrollbarDown = -45;
		
		dragger.moveToElement(draggablePartOfScrollbar).clickAndHold().moveByOffset(0,numberOfPixelsToDragTheScrollbarDown).release().perform();
		Thread.sleep(5000);
		
		WebElement SaveBtn = driver.findElement(By.xpath("//ul[@class='nav']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
		 SaveBtn.click();
			Thread.sleep(3000);

		
	 }
	 @Test(priority=2)
	 public void VerifyHeightandWidth() throws InterruptedException {
		 driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/1250");
			Thread.sleep(3000);
			WebElement Shape = driver.findElement(By.id("page1-fpShape1213201912522970"));
			Thread.sleep(2000);
			Shape.click();
			int  width1=Shape.getSize().getWidth();
			int height1=Shape.getSize().getHeight();
			Assert.assertEquals(width1,491);
			Assert.assertEquals(height1,567);	 
		 
	 }
	 @Test(priority=3)
	 public void ResetHeightandWidth() throws InterruptedException {
			Thread.sleep(3000);
			WebElement Shape = driver.findElement(By.id("page1-fpShape1213201912522970"));
			Thread.sleep(2000);
			Shape.click();
			WebElement RectangleShapeWidth = driver.findElement(By.xpath("//input[@name='textWidth11']"));
			RectangleShapeWidth.clear();
			Thread.sleep(2000);
			RectangleShapeWidth.sendKeys("250");
			WebElement RectangleShapeHeight = driver.findElement(By.xpath("//input[@name='height11']"));
			RectangleShapeHeight.clear();
			Thread.sleep(1000);
			RectangleShapeHeight.sendKeys("400");
			Thread.sleep(1000);
			Actions dragger = new Actions(driver);
			WebElement draggablePartOfScrollbar = driver.findElement(By.xpath("//input[@name='opacity']"));
			int numberOfPixelsToDragTheScrollbarDown = 100;
			dragger.moveToElement(draggablePartOfScrollbar).clickAndHold().moveByOffset(numberOfPixelsToDragTheScrollbarDown,0).release().perform();
			Thread.sleep(5000);
			WebElement SaveBtn = driver.findElement(By.xpath("//ul[@class='nav']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
			SaveBtn.click();
			Thread.sleep(3000);
			
			driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/1250");
			Thread.sleep(3000);
			WebElement RectangleShape = driver.findElement(By.id("page1-fpShape1213201912522970"));
			Thread.sleep(2000);
		  int width=RectangleShape.getSize().getWidth();
		  int height=RectangleShape.getSize().getHeight();
		  Assert.assertEquals(width, 250);
		  Assert.assertEquals(height, 400);
		 
	 }
	 @Test(priority=4)
	 	public void ApplyCornerandRotation() throws InterruptedException {
		 WebElement Rectangle = driver.findElement(By.id("page1-fpShape1213201912522970"));
			Thread.sleep(2000);
			Rectangle.click();
		 WebElement Shape = driver.findElement(By.xpath("//div[9]//div[1]"));
		 WebElement RectangleShapeCorner = driver.findElement(By.xpath("//input[@name='corners']"));
		RectangleShapeCorner.clear();
		Thread.sleep(2000);

		RectangleShapeCorner.sendKeys("50");
		Thread.sleep(2000);
		String str = Shape.getCssValue("border-radius");
		Assert.assertEquals(str, "50px");
	//	WebElement Shape1 = driver.findElement(By.xpath("//div[@id='page1-fpShape1213201912522970']"));
		WebElement Rectanglerotate=driver.findElement(By.xpath("//input[@name='rotate']"));
		Rectanglerotate.clear();
		Thread.sleep(2000);
		Rectanglerotate.sendKeys("90");
		Thread.sleep(5000);
		
		WebElement BorderCheckBox = driver.findElement(By.xpath("//div[@class='form-group form-check']//input"));
		BorderCheckBox.click();
		Thread.sleep(2000);
		BorderCheckBox.click();
		Thread.sleep(2000);
		WebElement BorderWidth = driver.findElement(By.xpath("//input[@name='borderWidth']"));
		BorderWidth.clear();
		Thread.sleep(2000);
		BorderWidth.sendKeys("10");
		Thread.sleep(1000);
		Select dropdown = new Select(driver.findElement(By.name("borderStyle")));
		dropdown.selectByIndex(3);
		Thread.sleep(1000);

		WebElement SaveBtn = driver.findElement(By.xpath("//ul[@class='nav']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
		SaveBtn.click();
		Thread.sleep(3000);
	 }
	 @Test(priority=5)
	 public void verifyApplyCornerandRotation() throws InterruptedException {
		 driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/1250");
			Thread.sleep(3000);
			WebElement Shape1 = driver.findElement(By.xpath("//div[@id='page1-fpShape1213201912522970']"));
					
			String str1 =Shape1.getCssValue("transform");
			//System.out.println(str1);
			Assert.assertEquals(str1, "matrix(6.12323e-17, 1, -1, 6.12323e-17, 0, 0)");
			WebElement BorderRadious = driver.findElement(By.xpath("//div[@id='section_section6468']//div[9]//div[1]"));
			String str2 =BorderRadious.getCssValue("border-width");
			//System.out.println("Border width"+str2);
			Assert.assertEquals(str2, "10px");
			WebElement GetShapeBorder=driver.findElement(By.xpath("//div[@id='section_section6468']//div[9]//div[1]"));

		String borderstyle =GetShapeBorder.getCssValue("border-style");
		//System.out.println("BorderStyle"+borderstyle);
		Assert.assertEquals(borderstyle, "double");
	 }
	 @Test(priority=6)
		public void ResetApplyCornerandRotation() throws InterruptedException {
		 WebElement Shape = driver.findElement(By.xpath("//div[9]//div[1]"));
		 Shape.click();
		 Thread.sleep(3000);
		 WebElement RectangleShapeCorner = driver.findElement(By.xpath("//input[@name='corners']"));
		RectangleShapeCorner.clear();
		Thread.sleep(2000);
		RectangleShapeCorner.sendKeys("0");
		Thread.sleep(2000);
		String str = Shape.getCssValue("border-radius");
		Assert.assertEquals(str, "0px");
		
		WebElement Rectanglerotate=driver.findElement(By.xpath("//input[@name='rotate']"));
		Rectanglerotate.clear();
		Thread.sleep(2000);
		Rectanglerotate.sendKeys("0");
		Thread.sleep(2000);
		
		//WebElement BorderCheckBox = driver.findElement(By.xpath("//div[@class='form-group form-check']//input"));
		//BorderCheckBox.click();
		Thread.sleep(2000);
		WebElement BorderWidth = driver.findElement(By.xpath("//input[@name='borderWidth']"));
		BorderWidth.clear();
		Thread.sleep(2000);
		BorderWidth.sendKeys("0");
		Select dropdown = new Select(driver.findElement(By.name("borderStyle")));
		dropdown.selectByIndex(2);
		Thread.sleep(1000);
		WebElement GetShapeBorder=driver.findElement(By.xpath("//div[@id='section_section6468']//div[9]//div[1]"));
		String borderstyle =GetShapeBorder.getCssValue("border-style");
		Assert.assertEquals(borderstyle, "solid");
		Thread.sleep(1000);
		WebElement SaveBtn = driver.findElement(By.xpath("//ul[@class='nav']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
		SaveBtn.click();
		Thread.sleep(3000);

		driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/1250");
		Thread.sleep(3000);
		WebElement Shape1 = driver.findElement(By.xpath("//div[@id='page1-fpShape1213201912522970']"));
		  WebElement BorderRadious = driver.findElement(By.xpath("//div[@id='section_section6468']//div[9]//div[1]"));
		  String str1 =Shape1.getCssValue("transform"); System.out.println("transform is"+str1);
		  Assert.assertEquals(str1, "matrix(1, 0, 0, 1, 0, 0)");
		  String str2 =BorderRadious.getCssValue("border-width");

		//System.out.println("Border width"+str2);
		Assert.assertEquals(str2, "0px");
		 
	 }
	 
	 @Test(priority=7)
	 public void LineProperties() throws InterruptedException {
		WebElement Section2 = driver.findElement(By.xpath("//a[contains(text(),'Section2Line')]"));
		Section2.click();
		Thread.sleep(2000);
		WebElement Line = driver.findElement(By.xpath("//div[@id='page1-fpShape1214201914374145']"));
		Line.click();
		Thread.sleep(2000);
		WebElement Length = driver.findElement(By.xpath("//input[@name='textWidth11']"));
		Length.clear();
		Thread.sleep(2000);
		Length.sendKeys("367");
		Thread.sleep(2000);

		int width=Line.getSize().getWidth();
		System.out.println(width);
		WebElement RotateBox = driver.findElement(By.xpath("//input[@name='rotate']"));
		RotateBox.clear();
		Thread.sleep(2000);
		RotateBox.sendKeys("321");
		Thread.sleep(2000);
		WebElement LineBorderWidth = driver.findElement(By.xpath("//input[@name='borderWidth']"));
		LineBorderWidth.clear();
		Thread.sleep(2000);
		LineBorderWidth.sendKeys("20");
		Thread.sleep(2000);
		Select dropdown = new Select(driver.findElement(By.name("borderStyle")));
		dropdown.selectByIndex(4);
		Thread.sleep(1000);
		WebElement LineBorder = driver.findElement(By.xpath("//div[@id='section_section6499']//div[9]//div[1]"));
			//String LineBorderStyle=LineBorder.getCssValue("border-top");
			//System.out.println("LineBorderStyle"+LineBorderStyle);
			//WebElement LineBorder = driver.findElement(By.xpath("//div[@id='section_section6499']//div[9]//div[1]"));
			
		WebElement SaveBtn = driver.findElement(By.xpath("//ul[@class='nav']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
		SaveBtn.click();
		Thread.sleep(3000);
	 }
	 @Test(priority=8)
	 public void verifyLineProperties() throws InterruptedException {
		 driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/1250");
			Thread.sleep(3000);
		 WebElement Section2 = driver.findElement(By.xpath("//a[contains(text(),'Section2Line')]"));
			Section2.click();
			Thread.sleep(2000);
			WebElement Line = driver.findElement(By.xpath("//div[@id='page1-fpShape1214201914374145']"));
			Line.click();
			Thread.sleep(2000);
			//WebElement Length = driver.findElement(By.xpath("//input[@name='textWidth11']"));
			int width=Line.getSize().getWidth();
			Assert.assertEquals(width, 367);
			String Rotation = Line.getCssValue("transform");
			Assert.assertEquals(Rotation,"matrix(0.777146, -0.62932, 0.62932, 0.777146, 0, 0)");
			//System.out.println(Rotation);
			int Height=Line.getSize().getHeight();
			Assert.assertEquals(Height, 20);
			WebElement LineBorder = driver.findElement(By.xpath("//div[@id='section_section6499']//div[9]//div[1]"));
			String LineBorderStyle=LineBorder.getCssValue("border-style");
			//System.out.println("LineBorderStyle"+LineBorderStyle);
			if(LineBorderStyle.contains("groove")) {
				Assert.assertTrue(true);
			}else {
				Assert.assertFalse(false);
			}
		 
	 }
	 @Test(priority=9)
	 public void ResetLineProperties() throws InterruptedException {
			WebElement Line = driver.findElement(By.xpath("//div[@id='page1-fpShape1214201914374145']"));
			Line.click();
			Thread.sleep(2000);
			WebElement Length = driver.findElement(By.xpath("//input[@name='textWidth11']"));
			Length.clear();
			Thread.sleep(2000);
			Length.sendKeys("200");
			Thread.sleep(2000);

			int width=Line.getSize().getWidth();
			//System.out.println(width);
			Assert.assertEquals(width, 200);
			WebElement RotateBox = driver.findElement(By.xpath("//input[@name='rotate']"));
			RotateBox.clear();
			Thread.sleep(2000);
			RotateBox.sendKeys("0");
			Thread.sleep(2000);

			String Rotation = Line.getCssValue("transform");
			Assert.assertEquals(Rotation,"matrix(1, 0, 0, 1, 0, 0)");
			//System.out.println(Rotation);
		
			WebElement LineBorderWidth = driver.findElement(By.xpath("//input[@name='borderWidth']"));
			LineBorderWidth.clear();
			Thread.sleep(2000);
			LineBorderWidth.sendKeys("1");
			Thread.sleep(2000);
			Select dropdown = new Select(driver.findElement(By.name("borderStyle")));
			dropdown.selectByIndex(2);
			Thread.sleep(1000);
			WebElement LineBorder = driver.findElement(By.xpath("//div[@id='section_section6499']//div[9]//div[1]"));
			String LineBorderStyle=LineBorder.getCssValue("border-style");
			//System.out.println("LineBorderStyle"+LineBorderStyle);
			if(LineBorderStyle.contains("solid")) {
				Assert.assertTrue(true);
			}else {
				Assert.assertFalse(false);
			}
		 
			
			
		String str=	LineBorderWidth.getCssValue("border-width");
		//System.out.println(str);
		Assert.assertEquals(str, "1px");	
		WebElement SaveBtn = driver.findElement(By.xpath("//ul[@class='nav']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
		SaveBtn.click();
		Thread.sleep(3000);
	 }
	 @AfterClass
	 public void teardown() {
		 driver.quit();
	 }
	 

}
