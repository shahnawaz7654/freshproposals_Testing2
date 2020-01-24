package com.freshproposals.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddVariablesandVerify extends Common_Methods{
	
	WebDriver driver;
	 SoftAssert softAssertion= new SoftAssert();
String[] expected = new String[] {"Freshproposal","9189677456","Mrs.dont","Kalyaninagar Pune,411212","Pune","Maharashtra","India","Freshproposals.com","Fresh proposals.com","Natasha","Sharma","nikeeta@zenincloud.com","Kalyaninagar Pune,411212","SeleniumVariable","2212","","1","Nikeeta Shelar","nikeeta3011@gmail.com","Jan 27, 2029","1234567890"};
String[] expectedAfterUpdating = new String[] {"ICT Networks","6123455678","title","L10/ 153 Walker St North Sydney NSW, 2060","Walker","Sydney","Australia","www.ictnetworks.com.au","CALIBREONE","SAM","Cawthrown","megan@speakersinstitute.com","4-8 Angas Street Kent Town SA 5067","SeleniumVariable","2212","","1","NICK Vijucic","nikeeta3011@gmail.com","Jan 27, 2029","9876543210"};
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
		driver.findElement(By.xpath("//button[@class='btn btn-link']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Variables')]")).click();

		List<WebElement> variables=driver.findElements(By.xpath("//ul[@id='collapseVariable']//li"));
		int numofvariables=variables.size();
		System.out.println(numofvariables);
		for(int i=0;i<=21;i++) {
			variables.get(i).click();
			Thread.sleep(500);

		}
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
		
	}
	
	

}
