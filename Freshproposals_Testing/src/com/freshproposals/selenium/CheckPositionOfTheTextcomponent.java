package com.freshproposals.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckPositionOfTheTextcomponent extends Common_Methods {
	WebDriver driver;
	 SoftAssert Assert= new SoftAssert();

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
			Thread.sleep(5000);

		}
	
	
	@Test(priority=1)
	public void TextComponentPosition() throws InterruptedException {
		driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/1138");
		WebElement textbox = driver.findElement(By.xpath("//div[@id='page1-fpText1129201912312833mainDivTransformSafeStyle']"));
		Point point=textbox.getLocation();
		int xcord = point.getX();
		int ycord =point.getY();
		System.out.println(xcord);
		System.out.println(ycord);
		//Assert.assertEquals(xcord, 292);
		//Assert.assertEquals(ycord, 96);
		Actions act=new Actions(driver);	
        act.dragAndDropBy(textbox,100, 100).build().perform();		
        Thread.sleep(3000);
		Point point1=textbox.getLocation();
        int xcord1 = point1.getX();
		int ycord1 =point1.getY();
		System.out.println(xcord1);
		System.out.println(ycord1);
		//Assert.assertEquals(xcord1, 392);
		//Assert.assertEquals(ycord1, 196);
		Thread.sleep(3000);
		WebElement SaveBtn=driver.findElement(By.xpath("//ul[@class='nav']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
		SaveBtn.click();
		Thread.sleep(3000);
		driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/1138");
        Thread.sleep(3000);
		WebElement textbox2 = driver.findElement(By.xpath("//div[@id='page1-fpText1129201912312833mainDivTransformSafeStyle']"));
		act.dragAndDropBy(textbox2,-100, -100).build().perform();
		Thread.sleep(5000);
        Point point2=textbox2.getLocation();
         int xcord2 = point2.getX();
		int ycord2 =point2.getY();
		//System.out.println(xcord2);
		//System.out.println(ycord2);
		Assert.assertEquals(xcord2, 292);
		Assert.assertEquals(ycord2, 96);
		WebElement SaveBtn2=driver.findElement(By.xpath("//ul[@class='nav']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
		
		SaveBtn2.click();
		Thread.sleep(3000);
		driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/1138/true");
		int xcord3 = point2.getX();
		int ycord3 =point2.getY();
		//System.out.println(xcord3);
		//System.out.println(ycord3);
		
		Assert.assertEquals(xcord3, 292);
		Assert.assertEquals(ycord3, 96);
		//driver.quit();
		Assert.assertAll();
		
	}
	
	 @AfterClass
	  public void closeBrowser() throws InterruptedException {
		  Thread.sleep(3000);
		  driver.close();
	  }


}
