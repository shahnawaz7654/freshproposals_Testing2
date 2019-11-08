package com.freshproposals.selenium;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Collapse_Controls extends Common_Methods {
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
  
  @Test(dataProvider = "User1" , priority = 0)
  
  public void login(String unm, String pwd) {
	    driver.findElement(By.id("textbox_0")).sendKeys(unm);
		driver.findElement(By.id("textbox_1")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
  
  @Test(enabled = false)
  public void createtemplate() throws InterruptedException {
		driver.findElement(By.linkText("TEMPLATES")).click();
		Thread.sleep(3000);
		//template name
		driver.findElement(By.linkText("Create your Template")).click();
		driver.findElement(By.name("name")).sendKeys(fname+" SLTemp "+timestamp);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
  }
  
  @Test(priority = 1)
  public void grid() throws InterruptedException {
	  driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/759");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//img[@src='../../assets/right-arrow-blue.svg']")).click();
	  //grid
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//ejs-switch[@id='grid']//span[@class='e-switch-handle']")).click();
      //full screen
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//ejs-switch[@id='fullscreen']//span[@class='e-switch-handle']")).click();
	  //preview
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//ejs-switch[@id='preview']//span[@class='e-switch-handle']")).click();
	  //percentages
	  Thread.sleep(2000);
	  Select select = new Select(driver.findElement(By.xpath("//div[@class='editor-header-width-drop']//select")));
	  select.selectByValue("2");
	  Thread.sleep(1000);
	  select.selectByValue("1.5");
	  Thread.sleep(1000); 
	  select.selectByValue(".8");
	  Thread.sleep(1000);
	  select.selectByValue(".6");
	  Thread.sleep(1000);
	  select.selectByValue(".4");
	  Thread.sleep(1000);
	  select.selectByValue(".2");
	  Thread.sleep(1000);
	  select.selectByValue("1");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//ejs-switch[@id='fullscreen']//span[@class='e-switch-handle e-switch-active']")).click();
	  }
  
  @AfterTest
  public void closeBrowser() throws InterruptedException {
  Thread.sleep(3000);
  driver.close();
}
	
  }

