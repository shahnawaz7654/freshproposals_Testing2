package com.freshproposals.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SectionBodyProperties extends Common_Methods {
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
	
//    @Test(enabled=false)
//	  public void login() throws InterruptedException {
//			//driver.get("http://beta1.freshproposals.com/");
//			WebElement Email=driver.findElement(By.id("textbox_0"));
//			Email.sendKeys("nikeeta3011@gmail.com");
//			WebElement Password =driver.findElement(By.id("textbox_1"));
//			Password.sendKeys("Nikeeta@123");
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//button[@class='button float-right e-control e-progress-btn e-lib e-btn e-spin-right']")).click();	
//	}
	  @Test(priority=1)
	  public void ReadtextFontsize() {
			driver.get("http://beta1.freshproposals.com/home/sections/editSection/4675");
			String Actualfont =driver.findElement(By.xpath("//p[contains(text(),'Body')]")).getCssValue("font-size");
			//System.out.println("Font Size of the text is"+font);
			//  <test thread-count="5" name="Test" parallel="classes"> 
			String expected ="14px";
			Assert.assertEquals(Actualfont,expected);	
		}
	  @Test(priority=2)
	  public void ReadFontColor() {
			String color =driver.findElement(By.xpath("//p[contains(text(),'Body')]")).getCssValue("color");
			System.out.println(color);
			String expected ="#000000";
			String actual = Color.fromString(color).asHex();
			//System.out.println("Font color is ="+hex);
			Assert.assertEquals(actual,expected);
		  
	  }
	  @Test(priority=3)
	  public void FontStyle() {
		  String actualstyle =driver.findElement(By.xpath("//p[contains(text(),'Body')]")).getCssValue("font-style");
			// System.out.println("Font style is ="+style);
			 String expected ="normal";
				Assert.assertEquals(actualstyle,expected);

	  }
	  @Test(priority=4)
	  public void FontAlignment() {
		  String ActualAlign=driver.findElement(By.xpath("//p[contains(text(),'Body')]")).getCssValue("text-align");
			// System.out.println("Alignment of the text is="+Align);
			 String expected ="left";
				Assert.assertEquals(ActualAlign,expected);
	  }
	  @Test(priority=5)
	  public void Fontfamily() {
		  String ActualFontfamily=driver.findElement(By.xpath("//p[contains(text(),'Body')]")).getCssValue("font-family");
			// System.out.println("Font family is="+family);
		  String expected ="Roboto";
			Assert.assertEquals(ActualFontfamily,expected);
	  }
	  @Test(priority=6)
	  public void FontWeight() {
		  String ActualFontWeight =driver.findElement(By.xpath("//p[contains(text(),'Body')]")).getCssValue("font-weight");
			 //System.out.println("Weight of the font is="+Weight);
		  String expected ="400";
			Assert.assertEquals(ActualFontWeight,expected);
	  }
	  @AfterTest
	  public void closeBrowser() {
		  driver.close();
	  }
	 
//	  @BeforeTest
//	  public void setup() {
//			System.setProperty("webdriver.chrome.driver","D:\\Nikeeta\\chromedriver.exe");
//				driver= new ChromeDriver();
//				driver.manage().window().maximize();
//				driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
//		}
//	  

	  @BeforeSuite
	  public void beforeSuite() {
		  System.out.println("Before suite");
	  }

	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("After suite");
	  }

	}



