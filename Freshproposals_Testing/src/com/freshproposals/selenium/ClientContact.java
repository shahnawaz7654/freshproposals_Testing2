package com.freshproposals.selenium;

import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class ClientContact extends Common_Methods {
	WebDriver driver;
	String unm;
	String pwd;
	 @BeforeClass
	  public void openBrowser() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			openURL(driver);
		}
	  
	 @Test(dataProvider = "User2", priority = 0)
	 	public void SetUnmPwd(String unm, String pwd) {
		 login(unm, pwd, driver);
}
	@Test(priority=1,dependsOnMethods = {"login"})
	  public void CreateNewClient() throws InterruptedException {
			Thread.sleep(5000);
			//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			WebElement Client =driver.findElement(By.xpath("//span[contains(text(),'CLIENTS')]"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", Client);

			//Client.click();
			Thread.sleep(5000);
			WebElement Button = driver.findElement(By.xpath("//div[@class='btn add-client-btn ng-star-inserted']"));
			Button.click();
			driver.findElement(By.xpath("//input[@formcontrolname='Name']")).sendKeys("Freshproposals");
			driver.findElement(By.xpath("//input[@formcontrolname='WebSiteUrl']")).sendKeys("www.freshproposals.com");
			driver.findElement(By.xpath("//input[@formcontrolname='AddressLine1']")).sendKeys("Kalyaninagr");
			driver.findElement(By.xpath("//input[@formcontrolname='AddressLine2']")).sendKeys("Pune,412216");
			driver.findElement(By.xpath("//input[@formcontrolname='City']")).sendKeys("Pune");
			driver.findElement(By.xpath("//input[@formcontrolname='State']")).sendKeys("Maharashtra");
			driver.findElement(By.xpath("//input[@formcontrolname='Country']")).sendKeys("INDIA");
			driver.findElement(By.xpath("//input[@formcontrolname='Zip']")).sendKeys("41216");
			driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
			System.out.println("New Client Created");
			}
	@Test(priority = 2,dependsOnMethods = {"login"})
	public void CreatenewContact() throws InterruptedException {
			WebElement ContactFNAME =driver.findElement(By.xpath("//input[@formcontrolname='FirstName']"));
			ContactFNAME.sendKeys("DHAN");
			WebElement LastName = driver.findElement(By.xpath("//input[@formcontrolname='LastName']"));
			LastName.sendKeys("W");
			WebElement Email =driver.findElement(By.xpath("//input[@formcontrolname='Email']"));
			Email.sendKeys("dhan@zenincloud.com");
			WebElement MobileNo=driver.findElement(By.xpath("//input[@formcontrolname='MobileNo']"));
			MobileNo.sendKeys("9900345695");
			driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
			System.out.println("New contact created");
		}
	@Test(priority = 3,dependsOnMethods = {"login"})	
	public void newContactaddedintoexistingClient() throws InterruptedException {
		Actions actions = new Actions(driver);
		WebElement addcontact = driver.findElement(By.xpath("//div[contains(text(),'Freshproposals')]"));
		actions.moveToElement(addcontact);
		Thread.sleep(3000);
			driver.findElement(By.xpath("//div[contains(text(),'Freshproposals')]//img[2]")).click();
			WebElement ContactFNAME1 =driver.findElement(By.xpath("//input[@formcontrolname='FirstName']"));
			ContactFNAME1.sendKeys("Chanbhau");
			WebElement LastName1 = driver.findElement(By.xpath("//input[@formcontrolname='LastName']"));
			LastName1.sendKeys("Shinde");
			WebElement Email1 =driver.findElement(By.xpath("//input[@formcontrolname='Email']"));
			Email1.sendKeys("dhan@zenincloud.com");
			WebElement MobileNo1=driver.findElement(By.xpath("//input[@formcontrolname='MobileNo']"));
			MobileNo1.sendKeys("9987345695");
			driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
			System.out.println("New contact added into the existing client");
	}
	@Test(priority=4,dependsOnMethods = {"login"})
	public void ClientUpdated() throws InterruptedException   {
			  WebElement updateContact =driver.findElement(By.xpath("//div[contains(text(),'Freshproposals')]//img[1]"));
			  Thread.sleep(3000);
			updateContact.click();
			WebElement Address =driver.findElement(By.xpath("//input[@formcontrolname='AddressLine1']"));
			Address.clear();
			Address.sendKeys("Kalyaninagar,opposite to Aagakhan palace");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@class='btn next-btn ml-3 float-right']")).click();
			System.out.println("Client updated");
			Thread.sleep(5000);
	}
	@Test(priority=5,dependsOnMethods = {"login"})
	public void ContactUpdated() throws InterruptedException {
		WebElement updateContact=driver.findElement(By.xpath("//div[3]//div[2]//div[1]//span[1]//img[1]"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", updateContact);
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@formcontrolname='emailAddress']")).clear();
			Thread.sleep(3000);

			driver.findElement(By.xpath("//input[@formcontrolname='emailAddress']")).sendKeys("Noneofyourbusiness@yahoo.com");
			driver.findElement(By.xpath("//input[@formcontrolname='contactNumber']")).clear();
			driver.findElement(By.xpath("//input[@formcontrolname='contactNumber']")).sendKeys("1234567892");
			Thread.sleep(3000);

			driver.findElement(By.xpath("//button[@id='btn-save']")).click();
			Thread.sleep(3000);
			System.out.println("Contact updated");
	}
	@Test(priority=6,dependsOnMethods = {"login"})
	public void ClientDeleted() throws InterruptedException {
		Actions actions = new Actions(driver);
		WebElement addcontact = driver.findElement(By.xpath("//div[contains(text(),'Freshproposals')]"));
		actions.moveToElement(addcontact);
		Thread.sleep(3000);
	
		 WebElement DeleteContact=driver.findElement(By.xpath("//div[contains(text(),'Freshproposals')]//img[3]"));
			 
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", DeleteContact);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='btn save-btn']")).click();
			Thread.sleep(5000);
			System.out.println("Client deleted");
			
			}
	
	 @AfterClass
	  public void closeBrowser() throws InterruptedException {
		  Thread.sleep(3000);
		  driver.close();
	  }
			
}

