package com.freshproposals.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SectionHeading4Properties extends Common_Methods {
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
	  @Test(priority=1)
	  public void ReadtextFontsize() {
			driver.get("http://beta1.freshproposals.com/home/sections/editSection/4675");
			String Actualfont =driver.findElement(By.xpath("//p[contains(text(),'Heading4')]")).getCssValue("font-size");
			//System.out.println("Font Size of the text is"+font);
			//  <test thread-count="5" name="Test" parallel="classes"> 
			String expected ="16px";
			Assert.assertEquals(Actualfont,expected);	
		}
	  @Test(priority=2)
	  public void ReadFontColor() {
			String color =driver.findElement(By.xpath("//p[contains(text(),'Heading4')]")).getCssValue("color");
			System.out.println(color);
			String expected ="#c93c62";
			String actual = Color.fromString(color).asHex();
			//System.out.println("Font color is ="+hex);
			Assert.assertEquals(actual,expected);
		  
	  }
	  @Test(priority=3)
	  public void FontStyle() {
		  String actualstyle =driver.findElement(By.xpath("//p[contains(text(),'Heading4')]")).getCssValue("font-style");
			// System.out.println("Font style is ="+style);
			 String expected ="normal";
				Assert.assertEquals(actualstyle,expected);

	  }
	  @Test(priority=4)
	  public void FontAlignment() {
		  String ActualAlign=driver.findElement(By.xpath("//p[contains(text(),'Heading4')]")).getCssValue("text-align");
			// System.out.println("Alignment of the text is="+Align);
			 String expected ="left";
				Assert.assertEquals(ActualAlign,expected);
	  }
	  @Test(priority=5)
	  public void Fontfamily() {
		  String ActualFontfamily=driver.findElement(By.xpath("//p[contains(text(),'Heading4')]")).getCssValue("font-family");
			// System.out.println("Font family is="+family);
		  String expected ="Poppins";
			Assert.assertEquals(ActualFontfamily,expected);
	  }
	  @Test(priority=6)
	  public void FontWeight() {
		  String ActualFontWeight =driver.findElement(By.xpath("//p[contains(text(),'Heading4')]")).getCssValue("font-weight");
			 //System.out.println("Weight of the font is="+Weight);
		  String expected ="400";
			Assert.assertEquals(ActualFontWeight,expected);
	  }
	  @AfterTest
	  public void closeBrowser() {
		  driver.quit();
	  }
	 
	  @BeforeSuite
	  public void beforeSuite() {
		  System.out.println("Before suite");
	  }

	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("After suite");
	  }

	}





 
