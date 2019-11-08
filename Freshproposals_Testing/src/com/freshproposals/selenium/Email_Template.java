package com.freshproposals.selenium;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Email_Template extends Common_Methods {
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
		//driver.get(url);
	}
  
  @Test(priority = 1)
  public void createEmailTemplate() throws InterruptedException {
	  driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div/ul/li[6]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[contains(text(),'Email Template')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[contains(text(),'Add')]")).click();
		Thread.sleep(2000);
		Select select = new Select(driver.findElement(By.xpath("//*[@id=\"content\"]/div/app-email-template/div/div/div/form/div/div/div/div/div[1]/div[1]/div[2]/select")));
		select.selectByIndex(0);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("I am Initiating Email");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[starts-with(@id,'bold')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[starts-with(@id,'italic')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[starts-with(@id,'underline')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/app-email-template/div/div/div/form/div/div/div/div/div[1]/div[3]/div[2]/div/div[3]/div"))
		.sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
				+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,"
				+ " when an unknown printer took a galley of type and scrambled it to make a type specimen book."
				+ "Lorem Ipsum is simply dummy text of the printing and typesetting industry."
				+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s");
		Thread.sleep(2000);
		//pargraph heading 1
	    driver.findElement(By.xpath("//button[starts-with(@id,'paragraphFormat')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Heading 1")).click();
		Thread.sleep(1000);
		//heading 2
		driver.findElement(By.xpath("//button[starts-with(@id,'paragraphFormat')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Heading 2")).click();
		Thread.sleep(1000);
		//heading 3
		driver.findElement(By.xpath("//button[starts-with(@id,'paragraphFormat')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Heading 3")).click();
		Thread.sleep(1000);
		//heading 4
		driver.findElement(By.xpath("//button[starts-with(@id,'paragraphFormat')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Heading 4")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[starts-with(@id,'paragraphFormat')]")).click();
        Thread.sleep(1000);
		//code
		driver.findElement(By.linkText("Code")).click();
		Thread.sleep(1000);
		//align
		driver.findElement(By.xpath("//button[starts-with(@id,'align')]")).click();
		//align left
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@title='Align Left']")).click();
		Thread.sleep(1000);
		//align
		driver.findElement(By.xpath("//button[starts-with(@id,'align')]")).click();
		//align right
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@title='Align Right']")).click();
		Thread.sleep(1000);
		//align
		driver.findElement(By.xpath("//button[starts-with(@id,'align')]")).click();
		//align justify
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@title='Align Justify']")).click();
		Thread.sleep(1000);
		//align
		driver.findElement(By.xpath("//button[starts-with(@id,'align')]")).click();
		//align center
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@title='Align Center']")).click();
		Thread.sleep(1000);
		//line height
		driver.findElement(By.xpath("//button[starts-with(@id,'lineHeight')]")).click();
		Thread.sleep(1000);
		//default
		driver.findElement(By.xpath("//a[@title='Default']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[starts-with(@id,'lineHeight')]")).click();
		Thread.sleep(1000);
		//single
		driver.findElement(By.xpath("//a[@title='Single']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[starts-with(@id,'lineHeight')]")).click();
		Thread.sleep(1000);
		//1.15
		driver.findElement(By.xpath("//a[@title='1.15']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[starts-with(@id,'lineHeight')]")).click();
		Thread.sleep(1000);
		//1.5
		driver.findElement(By.xpath("//a[@title='1.5']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[starts-with(@id,'lineHeight')]")).click();
		Thread.sleep(1000);
		//Double
		driver.findElement(By.xpath("//a[@title='Double']")).click();
		Thread.sleep(1000);
		
		//order list
		driver.findElement(By.xpath("//button[starts-with(@id,'formatOL')]")).click();
		Thread.sleep(1000);
		//unorder list
		driver.findElement(By.xpath("//button[starts-with(@id,'formatUL')]")).click();
		//insert link
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[starts-with(@id,'insertLink')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[starts-with(@id,'fr-link-insert-layer-url')]")).sendKeys("https://www.google.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[starts-with(@id,'fr-link-insert-layer-text')]")).sendKeys("Google");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'Insert')]")).click();
   	    Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		
  }
  @AfterTest
  public void closeBrowser() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.close();
  }
  
  
}
