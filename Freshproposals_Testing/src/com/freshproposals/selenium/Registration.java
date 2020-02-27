package com.freshproposals.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Registration extends Common_Methods {
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
	  
	 @Test(priority = 1, enabled = false)
	  public void signUp() throws InterruptedException {
		 Thread.sleep(2000);
		 driver.findElement(By.linkText("Sign Up")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-register[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ejs-textbox[1]/div[1]/input[1]")).sendKeys("zeninclou.d@gmail.com");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//button[@class='button button-Animt float-right']")).click();
	 }
	 
	 
	 @Test(priority = 2)
	 public void Gmail_login() throws InterruptedException {
		 Thread.sleep(2000);
		 driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
         
		 driver.findElement(By.name("identifier")).sendKeys("zenincloud@gmail.com");
         String actual_name = driver.findElement(By.name("identifier")).getAttribute("value");
         String expected_name = "zenincloud@gmail.com";
         Assert.assertEquals(actual_name, expected_name);
         
		 driver.findElement(By.id("identifierNext")).click();
		 
		 driver.findElement(By.name("password")).sendKeys("ZenInCloud@123");
		 String actual_password = driver.findElement(By.name("password")).getAttribute("value");
		 String expected_password = "ZenInCloud@123";
		 Assert.assertEquals(actual_password, expected_password);
		 driver.findElement(By.id("passwordNext")).click();
	 }
	 
	 @Test(priority = 3)
	 public void Search() throws InterruptedException, AWTException {
		 Thread.sleep(2000);
		 driver.findElement(By.name("q")).sendKeys("Welcome to Fresh Proposals!" + Keys.ENTER);
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/html[1]/body[1]/div[7]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[4]/div[2]/div[1]/table[1]/tbody[1]/tr[1]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.linkText("Confirm your email")).click();
	 }
	 
	 @Test(priority = 4)
	 public void form() throws InterruptedException {
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-confirm-registration[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ejs-textbox[1]/div[1]/input[1]")).sendKeys("qwerty");
		 
	 }
	 
	 @AfterClass
	  public void closeBrowser() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.close();
	}
}
