package com.freshproposals.selenium2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.freshproposals.selenium.Common_Methods;

public class FeeTable extends Common_Methods{
	
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
	 @Test(dataProvider = "User2" , priority = 0)
	  
	  public void login(String unm, String pwd) {
		    driver.findElement(By.id("textbox_0")).sendKeys(unm);
			driver.findElement(By.id("textbox_1")).sendKeys(pwd);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		}
	 @Test(priority=1,dependsOnMethods = {"login"})
	 public void AddRow() {
		 driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/1143");
		 WebElement SectionName = driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//li[2]"));
		 SectionName.click();
		 List<WebElement> BeforeNumberofrows =driver.findElements(By.className("contentInside"));
		  int numberofrowsBefore = BeforeNumberofrows.size();
		//	System.out.println(numberofrowsBefore);
		WebElement Cell = driver.findElement(By.xpath("//div[@id='content']//div[5]//div[2]"));
		Actions actions = new Actions(driver);
		actions.doubleClick(Cell).perform();
		WebElement addrow = driver.findElement(By.xpath("//div[6]//div[2]//div[2]//span[1]"));
		addrow.click();
		List<WebElement> AfterNumberofrows =driver.findElements(By.className("contentInside"));
		  int numberofrowsAfter = AfterNumberofrows.size();

		//System.out.println(numberofrowsAfter);
		if(numberofrowsAfter>numberofrowsBefore) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		
			 
		 }
	 @Test(priority=2,dependsOnMethods = {"login"})
	 public void DeleteRow() throws InterruptedException {
		 List<WebElement> BeforeNumberofrows =driver.findElements(By.className("contentInside"));
		  int numberofrowsBefore = BeforeNumberofrows.size();
			System.out.println(numberofrowsBefore);

		 WebElement Cell = driver.findElement(By.xpath("//div[@id='content']//div[5]//div[3]"));
			Actions actions = new Actions(driver);
			actions.doubleClick(Cell).perform();
			WebElement DeleteRow = driver.findElement(By.xpath("//div[6]//div[3]//div[2]//span[2]//img[1]"));
			DeleteRow.click();
			Thread.sleep(5000);
			List<WebElement> AfterNumberofrows =driver.findElements(By.className("contentInside"));
			  int numberofrowsAfter = AfterNumberofrows.size();
				//System.out.println(numberofrowsAfter);

			  if(numberofrowsAfter<numberofrowsBefore) {
					Assert.assertTrue(true);
				}else {
					Assert.assertTrue(false);
				}
				
	 }
	 @Test(priority=3,dependsOnMethods = {"login"})
	 public  void SelectRowType() throws InterruptedException {
		 WebElement ClickonRow =driver.findElement(By.xpath("//div[@id='content']//div[5]//div[2]"));
		 ClickonRow.click();
		WebElement RowType = driver.findElement(By.xpath("//div[@class='col-lg-10']//select[@class='form-control ng-untouched ng-pristine ng-valid']"));
		 Select dropdown = new Select(RowType);
		 Thread.sleep(2000);
		 dropdown.selectByIndex(0);
		 String rowtype0 = ClickonRow.getText();
		 Thread.sleep(2000);
		 if(rowtype0.contains("UnitQty")) {
			 Assert.assertTrue(true);
		 }else {
			 Assert.assertTrue(false);
		 }

		 dropdown.selectByIndex(1);
		 Thread.sleep(2000);

		 String rowtype1 = ClickonRow.getText();
		 if(rowtype1.contains("Fixed")) {
			 Assert.assertTrue(true);
		 }else {
			 Assert.assertTrue(false);
		 }
		 
		 dropdown.selectByIndex(2);		
		 Thread.sleep(2000);
		 String rowtype2 = ClickonRow.getText();
		 if(rowtype2.contains("Hourly")) {
			 Assert.assertTrue(true);
		 }else {
			 Assert.assertTrue(false);
		 }
		 dropdown.selectByIndex(3);
		 Thread.sleep(2000);
		 String rowtype3 = ClickonRow.getText();
		 if(rowtype3.contains("Monthly")) {
			 Assert.assertTrue(true);
		 }else {
			 Assert.assertTrue(false);
		 }
		 
		 dropdown.selectByIndex(4);
		 Thread.sleep(2000);
		 String rowtype4 = ClickonRow.getText();
		 if(rowtype4.contains("Yearly")) {
			 Assert.assertTrue(true);
		 }else {
			 Assert.assertTrue(false);
		 }
		 
		 dropdown.selectByIndex(5);
		 Thread.sleep(2000);
		 String rowtype5 = ClickonRow.getText();
		 if(rowtype5.contains("Content")) {
			 Assert.assertTrue(true);
		 }else {
			 Assert.assertTrue(false);
		 }
	 }
	 @Test(priority=4,dependsOnMethods = {"login"})
	 public void AddRowDiscount() {
		 driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/1143");
		 WebElement SectionName = driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//li[2]"));
		 SectionName.click();
		 WebElement ClickonRow =driver.findElement(By.xpath("//div[@id='content']//div[5]//div[2]"));
		 ClickonRow.click();
		 WebElement RowDisc = driver.findElement(By.xpath("//label[contains(text(),'Row Discount')]"));
		 RowDisc.click();
		 WebElement DiscName = driver.findElement(By.xpath("//input[@placeholder='Discount']"));
		 DiscName.click();
		 DiscName.sendKeys("SGST");
		 WebElement DiscPercentage = driver.findElement(By.xpath("//input[@id='discount']"));
		 DiscPercentage.clear();
		 DiscPercentage.sendKeys("10");
		 WebElement SubtatalField = driver.findElement(By.xpath("//div[6]//div[2]//div[1]"));
		String IsDiscApplied = SubtatalField.getText();
		if(IsDiscApplied.contains("SGST")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		 
	 }
	 @Test(priority = 5,dependsOnMethods = {"login"})
	 public void TableDiscount() throws InterruptedException {
		 driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/1143");
		 WebElement SectionName = driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//li[2]"));
		 SectionName.click();
		 Thread.sleep(4000);
		 WebElement feetable = driver.findElement(By.xpath("//div[contains(text(),'Price')]"));
		 feetable.click();
		 WebElement tableDisc = driver.findElement(By.xpath("//label[contains(text(),'Table Discount')]//img"));
		 tableDisc.click();
		 
		 WebElement ShowDisc =driver.findElement(By.xpath("//input[@name='showTableDiscount']"));
		 ShowDisc.click();
		WebElement  DiscName  = driver.findElement(By.xpath("//input[@placeholder='Discount Name']"));
		//DiscName.clear();
		DiscName.sendKeys("TableDisc");
		WebElement DiscAmount = driver.findElement(By.xpath("//input[@name='discount']"));
		//DiscAmount.clear();
		DiscAmount.sendKeys("10");
		WebElement IsDiscapplied  = driver.findElement(By.xpath("//div[@class='fees-table-footer']//div[2]"));
		String TableDiscapplied = IsDiscapplied.getText();
		Thread.sleep(5000);
		 tableDisc.click();
			Thread.sleep(5000);


		if (TableDiscapplied.contains("TableDisc")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}

	 }
	 @Test(priority=6,dependsOnMethods = {"login"})
		public void AddTableTax1() throws InterruptedException {
		WebElement tabletax1 = driver.findElement(By.xpath("//label[@class='fees-prop-header'][contains(text(),'Tax 1')]//img"));
		tabletax1.click();
		 driver.findElement(By.xpath("//input[@name='showTax1']")).click();
		 WebElement TaxName = driver.findElement(By.xpath("//input[@placeholder='Tax1 Name']"));
		 //TaxName.clear();
		 TaxName.sendKeys("TableTax1");
		 
		 String Tax1 =driver.findElement(By.xpath("//div[@class='fees-table-footer']//div[3]")).getText();
		 WebElement tax1amount = driver.findElement(By.xpath("//input[@name='tax1Value']"));
			tax1amount.sendKeys("10");
			Thread.sleep(5000);
			//tabletax1.click();
			Thread.sleep(5000);

		 if(Tax1.contains("TableTax1")) {
			 Assert.assertTrue(true);
		 }else {
			 Assert.assertTrue(false);
		 }
		 
			tabletax1.click();

		}
	 @Test(priority = 7,dependsOnMethods = {"login"})
	 public void AddTax2() throws InterruptedException {
		 WebElement Tabletax2 = driver.findElement(By.xpath("//label[@class='fees-prop-header'][contains(text(),'Tax 2')]//img"));
		 Thread.sleep(5000);
		 Tabletax2.click();
		 WebElement ShowTax2 = driver.findElement(By.xpath("//input[@name='showTax2']"));
		 Thread.sleep(5000);
		 ShowTax2.click();
		 WebElement Tax2Name = driver.findElement(By.xpath("//input[@placeholder='Tax2 Name']"));
		 //Tax2Name.clear();
		 Tax2Name.sendKeys("TableTax2");
	WebElement tax2amount = driver.findElement(By.xpath("//input[@name='tax2Value']"));
	String TaxName = driver.findElement(By.xpath("//div[@class='fees-table-footer']//div[4]")).getText();

	tax2amount.sendKeys("10");
	Thread.sleep(5000);
	if(TaxName.contains("TableTax2")) {
		Assert.assertTrue(true);
	}else {
		Assert.assertTrue(false);
	}
				 
	 }
	 @Test(priority=8,dependsOnMethods = {"login"})
	 public void TableOption() throws InterruptedException {
		 driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/1143");
		 WebElement SectionName = driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//li[2]"));
		 SectionName.click();
		 WebElement Table = driver.findElement(By.xpath("//div[contains(text(),'Quantity')]"));
		 Table.click();
		 Thread.sleep(2000);
		 WebElement TableOption = driver.findElement(By.xpath("//div[@class='card-body properties-box fees-table-properties mb-0']//li[2]"));
		 TableOption.click();
		 Thread.sleep(2000);

		 WebElement tablesubtotal =	 driver.findElement(By.xpath("//div[@class='col-lg-5 offset-lg-2 p-0']//label[@class='tgl-btn']"));
		 tablesubtotal.click();
		 Thread.sleep(2000);

		 WebElement tabletotal = driver.findElement(By.xpath("//label[@for='tableTotal']"));
		 tabletotal.click();
		 Thread.sleep(2000);

		 WebElement FeeTableFooter = driver.findElement(By.xpath("//div[@class='total-fee-calculator']"));
		 String footertext = FeeTableFooter.getText();
		 Thread.sleep(2000);

		 if(footertext.contains("Total")) {
			 Assert.assertFalse(true);
		 }else {
			 Assert.assertFalse(false);
		 }
		 
	 }
	 @AfterClass
	 public void teardown() {
		 driver.quit();
	 }

}



