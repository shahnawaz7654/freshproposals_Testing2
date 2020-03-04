package com.freshproposals.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddVariablesandVerify extends Common_Methods{
	
WebDriver driver;
SoftAssert softAssertion= new SoftAssert();
JavascriptExecutor executor = (JavascriptExecutor)driver;

String[] expectedonpage1 = new String[] {"","Freshproposal","nikeeta3011@gmail.com","9189677456","Mrs.dont","Kalyaninagar Pune,411212","Pune","Maharashtra","India","Freshproposals.com","Fresh proposals.com","Natasha","Sharma","nikeeta@zenincloud.com","Kalyaninagar Pune,411212","9999999999","1234567890","Selenium","2289","Jan 25, 2029","","1","Nikeeta Shelar"};	

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
	public void Addvariables() throws InterruptedException, AWTException {
		driver.get("http://beta1.freshproposals.com/home/proposals/editProposal/2289");
		Thread.sleep(1000);
		WebElement nextBtn = driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
		nextBtn.click();
		driver.findElement(By.id("page1-fpText12320201625678mainDivTransformSafeStyle")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-link ng-star-inserted']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-link collapsed ng-star-inserted']")).click();
		List<WebElement> variables=driver.findElements(By.xpath("//ul[@id='collapseVariable']//li"));
		int numofvariables=variables.size();
		System.out.println(numofvariables);
		for(int i=0;i<=21;i++) {
			variables.get(i).click();
			Thread.sleep(500);
			
			
		}
		
		WebElement SaveBtn = driver.findElement(By.xpath("//li[@class='nav-item']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
		SaveBtn.click();
		Thread.sleep(3000);
//		WebElement CopyPage= driver.findElement(By.xpath("//div[@id='section_section8453']//div[3]//img[1]"));
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("arguments[0].click();", CopyPage);
//	//	CopyPage.click();
//		Thread.sleep(3000);
//		SaveBtn.click();
//		Thread.sleep(3000);

		}
	@Test(priority=2)
	public void VerifyUpdatedVariables() throws InterruptedException {
		driver.get("http://beta1.freshproposals.com/home/viewproposal/2289/preview/proposals");
		Thread.sleep(5000);
		 List<WebElement> variables = driver.findElements(By.xpath("//div[@id='page1-fpText12320201625678mainDivTransformSafeStyle']//p"));
		int var= variables.size();
		for(int j=0;j<var;j++) {
			System.out.println(variables.get(j).getText());
			String Actual =variables.get(j).getText();
			softAssertion.assertEquals(Actual, expectedonpage1[j]);
		}
		
		softAssertion.assertAll();
		
	}
	@Test(priority=3)
	public void DeleteAllVariableFromBox() throws AWTException, InterruptedException {
		driver.get("http://beta1.freshproposals.com/home/proposals/editProposal/2289");
		Thread.sleep(3000);
		WebElement nextBtn = driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", nextBtn);
		Thread.sleep(2000);
		driver.findElement(By.id("page1-fpText12320201625678mainDivTransformSafeStyle")).click();
		Thread.sleep(1000);
		 WebElement textbox=driver.findElement(By.id("page1-fpText12320201625678mainDivTransformSafeStyle"));
		 textbox.click();
		Robot   rbt= new Robot();
		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_A);
		rbt.keyRelease(KeyEvent.VK_CONTROL);
		rbt.keyRelease(KeyEvent.VK_A);
		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_DELETE);
		rbt.keyRelease(KeyEvent.VK_CONTROL);
		rbt.keyRelease(KeyEvent.VK_DELETE);
		Thread.sleep(3000);
		WebElement SaveBtn = driver.findElement(By.xpath("//li[@class='nav-item']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
		SaveBtn.click();
		Thread.sleep(3000);
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
