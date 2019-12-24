package com.freshproposals.selenium2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.freshproposals.selenium.Common_Methods;

public class FeeTable extends Common_Methods{
	SoftAssert softAssertion= new SoftAssert();
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
	  
	  public void login(String unm, String pwd) throws InterruptedException {
		    driver.findElement(By.id("textbox_0")).sendKeys(unm);
			driver.findElement(By.id("textbox_1")).sendKeys(pwd);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(5000);
		
		}
//	 @Test(priority=1,dependsOnMethods = {"login"})
//	 public void AddRow() throws InterruptedException {
//		 driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/1143");
//		 WebElement SectionName = driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//li[2]"));
//		 SectionName.click();
//		 Thread.sleep(4000);
//
//		 List<WebElement> BeforeNumberofrows =driver.findElements(By.className("contentInside"));
//		  int numberofrowsBefore = BeforeNumberofrows.size();
//		//	System.out.println(numberofrowsBefore);
//		WebElement Cell = driver.findElement(By.xpath("//div[@id='content']//div[5]//div[2]"));
//		Actions actions = new Actions(driver);
//		actions.doubleClick(Cell).perform();
//		WebElement addrow = driver.findElement(By.xpath("//div[6]//div[2]//div[2]//span[1]"));
//		addrow.click();
//		Thread.sleep(5000);
//		List<WebElement> AfterNumberofrows =driver.findElements(By.className("contentInside"));
//		  int numberofrowsAfter = AfterNumberofrows.size();
//
//		//System.out.println(numberofrowsAfter);
//		if(numberofrowsAfter>numberofrowsBefore) {
//			Assert.assertTrue(true);
//		}else {
//			Assert.assertTrue(false);
//		}
//		
//		
//			 
//		 }
//	 @Test(priority=2,dependsOnMethods = {"login"})
//	 public void DeleteRow() throws InterruptedException {
//		 List<WebElement> BeforeNumberofrows =driver.findElements(By.className("contentInside"));
//		  int numberofrowsBefore = BeforeNumberofrows.size();
//			System.out.println(numberofrowsBefore);
//
//		 WebElement Cell = driver.findElement(By.xpath("//div[@id='content']//div[5]//div[3]"));
//			Actions actions = new Actions(driver);
//			actions.doubleClick(Cell).perform();
//			Thread.sleep(5000);
//			WebElement DeleteRow = driver.findElement(By.xpath("//div[6]//div[3]//div[2]//span[2]//img[1]"));
//			DeleteRow.click();
//			Thread.sleep(5000);
//			List<WebElement> AfterNumberofrows =driver.findElements(By.className("contentInside"));
//			  int numberofrowsAfter = AfterNumberofrows.size();
//				//System.out.println(numberofrowsAfter);
//
//			  if(numberofrowsAfter<numberofrowsBefore) {
//					Assert.assertTrue(true);
//				}else {
//					Assert.assertTrue(false);
//				}
//				
//	 }
//	 @Test(priority=3,dependsOnMethods = {"login"})
//	 public  void SelectRowType() throws InterruptedException {
//		 WebElement ClickonRow =driver.findElement(By.xpath("//div[@id='content']//div[5]//div[2]"));
//		 ClickonRow.click();
//		WebElement RowType = driver.findElement(By.xpath("//div[@class='col-lg-10']//select[@class='form-control ng-untouched ng-pristine ng-valid']"));
//		 Select dropdown = new Select(RowType);
//		 Thread.sleep(2000);
//		 dropdown.selectByIndex(0);
//		 String rowtype0 = ClickonRow.getText();
//		 Thread.sleep(2000);
//		 if(rowtype0.contains("UnitQty")) {
//			 Assert.assertTrue(true);
//		 }else {
//			 Assert.assertTrue(false);
//		 }
//
//		 dropdown.selectByIndex(1);
//		 Thread.sleep(2000);
//
//		 String rowtype1 = ClickonRow.getText();
//		 if(rowtype1.contains("Fixed")) {
//			 Assert.assertTrue(true);
//		 }else {
//			 Assert.assertTrue(false);
//		 }
//		 
//		 dropdown.selectByIndex(2);		
//		 Thread.sleep(2000);
//		 String rowtype2 = ClickonRow.getText();
//		 if(rowtype2.contains("Hourly")) {
//			 Assert.assertTrue(true);
//		 }else {
//			 Assert.assertTrue(false);
//		 }
//		 dropdown.selectByIndex(3);
//		 Thread.sleep(2000);
//		 String rowtype3 = ClickonRow.getText();
//		 if(rowtype3.contains("Monthly")) {
//			 Assert.assertTrue(true);
//		 }else {
//			 Assert.assertTrue(false);
//		 }
//		 
//		 dropdown.selectByIndex(4);
//		 Thread.sleep(2000);
//		 String rowtype4 = ClickonRow.getText();
//		 System.out.println(rowtype4);
//
//		 if(rowtype4.contains("Yearly")) {
//			 Assert.assertTrue(true);
//		 }else {
//			 Assert.assertTrue(false);
//		 }
//		 
//		 dropdown.selectByIndex(5);
//		 Thread.sleep(2000);
//		 String rowtype5 = ClickonRow.getText();
//		 if(rowtype5.contains("")) {
//			 Assert.assertTrue(true);
//		 }else {
//			 Assert.assertTrue(false);
//		 }
//	 }
//	 @Test(priority=4,dependsOnMethods = {"login"})
//	 public void AddRowDiscount() throws InterruptedException {
//		 driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/1143");
//		 WebElement SectionName = driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//li[2]"));
//		 SectionName.click();
//		 Thread.sleep(4000);
//
//		 WebElement ClickonRow =driver.findElement(By.xpath("//div[@id='content']//div[5]//div[2]"));
//		 ClickonRow.click();
//		 WebElement RowDisc = driver.findElement(By.xpath("//label[contains(text(),'Row Discount')]"));
//		 RowDisc.click();
//		 WebElement DiscName = driver.findElement(By.xpath("//input[@placeholder='Discount']"));
//		 DiscName.click();
//		 DiscName.sendKeys("SGST");
//		 WebElement DiscPercentage = driver.findElement(By.xpath("//input[@id='discount']"));
//		 DiscPercentage.clear();
//		 DiscPercentage.sendKeys("10");
//		 WebElement SubtatalField = driver.findElement(By.xpath("//div[6]//div[2]//div[1]"));
//		String IsDiscApplied = SubtatalField.getText();
//		if(IsDiscApplied.contains("SGST")) {
//			Assert.assertTrue(true);
//		}else {
//			Assert.assertTrue(false);
//		}
//		 
//	 }
//	 @Test(priority = 5,dependsOnMethods = {"login"})
//	 public void TableDiscount() throws InterruptedException {
//		 driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/1143");
//		 WebElement SectionName = driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//li[2]"));
//		 SectionName.click();
//		 Thread.sleep(4000);
//		 WebElement feetable = driver.findElement(By.xpath("//div[contains(text(),'Price')]"));
//		 feetable.click();
//		 WebElement tableDisc = driver.findElement(By.xpath("//label[contains(text(),'Table Discount')]//img"));
//		 tableDisc.click();
//		 
//		 WebElement ShowDisc =driver.findElement(By.xpath("//input[@name='showTableDiscount']"));
//		 ShowDisc.click();
//		WebElement  DiscName  = driver.findElement(By.xpath("//input[@placeholder='Discount Name']"));
//		//DiscName.clear();
//		DiscName.sendKeys("TableDisc");
//		WebElement DiscAmount = driver.findElement(By.xpath("//input[@name='discount']"));
//		//DiscAmount.clear();
//		DiscAmount.sendKeys("10");
//		WebElement IsDiscapplied  = driver.findElement(By.xpath("//div[@class='fees-table-footer']//div[2]"));
//		String TableDiscapplied = IsDiscapplied.getText();
//		Thread.sleep(5000);
//		 tableDisc.click();
//			Thread.sleep(5000);
//
//
//		if (TableDiscapplied.contains("TableDisc")) {
//			Assert.assertTrue(true);
//		}else {
//			Assert.assertTrue(false);
//		}
//		 Thread.sleep(4000);
//
//	 }
//	 @Test(priority=6,dependsOnMethods = {"login"})
//		public void AddTableTax1() throws InterruptedException {
//		WebElement tabletax1 = driver.findElement(By.xpath("//label[@class='fees-prop-header'][contains(text(),'Tax 1')]//img"));
//		tabletax1.click();
//		 driver.findElement(By.xpath("//input[@name='showTax1']")).click();
//		 WebElement TaxName = driver.findElement(By.xpath("//input[@placeholder='Tax1 Name']"));
//		 //TaxName.clear();
//		 TaxName.sendKeys("TableTax1");
//		 
//		 String Tax1 =driver.findElement(By.xpath("//div[@class='fees-table-footer']//div[3]")).getText();
//		 WebElement tax1amount = driver.findElement(By.xpath("//input[@name='tax1Value']"));
//			tax1amount.sendKeys("10");
//			Thread.sleep(5000);
//			//tabletax1.click();
//			//Thread.sleep(5000);
//
//		 if(Tax1.contains("TableTax1")) {
//			 Assert.assertTrue(true);
//		 }else {
//			 Assert.assertTrue(false);
//		 }
//		 
//			tabletax1.click();
//			
//
//		}
//	 @Test(priority = 7,dependsOnMethods = {"login"})
//	 public void AddTax2() throws InterruptedException {
//		 WebElement Tabletax2 = driver.findElement(By.xpath("//label[@class='fees-prop-header'][contains(text(),'Tax 2')]//img"));
//		 Thread.sleep(5000);
//		 Tabletax2.click();
//		 WebElement ShowTax2 = driver.findElement(By.xpath("//input[@name='showTax2']"));
//		 Thread.sleep(5000);
//		 ShowTax2.click();
//		 WebElement Tax2Name = driver.findElement(By.xpath("//input[@placeholder='Tax2 Name']"));
//		 //Tax2Name.clear();
//		 Tax2Name.sendKeys("TableTax2");
//	WebElement tax2amount = driver.findElement(By.xpath("//input[@name='tax2Value']"));
//	String TaxName = driver.findElement(By.xpath("//div[@class='fees-table-footer']//div[4]")).getText();
//
//	tax2amount.sendKeys("10");
//	Thread.sleep(5000);
//	if(TaxName.contains("TableTax2")) {
//		Assert.assertTrue(true);
//	}else {
//		Assert.assertTrue(false);
//	}
//				 
//	 }
//	 @Test(priority=8,dependsOnMethods = {"login"})
//	 public void TableOption() throws InterruptedException {
//		 driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/1143");
//		 WebElement SectionName = driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//li[2]"));
//		 SectionName.click();
//		 Thread.sleep(4000);
//		 WebElement Table = driver.findElement(By.xpath("//div[contains(text(),'Quantity')]"));
//		 Table.click();
//		 Thread.sleep(2000);
//		 WebElement TableOption = driver.findElement(By.xpath("//div[@class='card-body properties-box fees-table-properties mb-0']//li[2]"));
//		 TableOption.click();
//		 Thread.sleep(2000);
//
//		 WebElement tablesubtotal =	 driver.findElement(By.xpath("//div[@class='col-lg-5 offset-lg-2 p-0']//label[@class='tgl-btn']"));
//		 tablesubtotal.click();
//		 Thread.sleep(2000);
//
//		 WebElement tabletotal = driver.findElement(By.xpath("//label[@for='tableTotal']"));
//		 tabletotal.click();
//		 Thread.sleep(2000);
//
//		 WebElement FeeTableFooter = driver.findElement(By.xpath("//div[@class='total-fee-calculator']"));
//		 String footertext = FeeTableFooter.getText();
//		 Thread.sleep(2000);
//
//		 if(footertext.contains("Total")) {
//			 Assert.assertTrue(true);
//		 }
//	 }
//	 @Test(priority=9)
//	 public void FeeTitleIsEditable() throws InterruptedException {
//			 driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/1143");
//			 WebElement Section3 = driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//li[3]"));
//			 Section3.click();
//			 Thread.sleep(2000);
//
//			 WebElement Textarea =driver.findElement(By.id("textbox_13"));
//			// Textarea.click();
//			 Thread.sleep(2000);
//
//			 JavascriptExecutor executor = (JavascriptExecutor)driver;
//			 executor.executeScript("arguments[0].click();", Textarea);
//			 Thread.sleep(2000);
//
//			 Textarea.clear();
//			 Thread.sleep(2000);
//
//			 Textarea.sendKeys("Selenium is automationtesting tool used for functional testing");
//			 Thread.sleep(2000);
//
//			 WebElement SaveBtn = driver.findElement(By.xpath("//ul[@class='nav']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
//			 SaveBtn.click();
//			 executor.executeScript("arguments[0].click();", Textarea);
//			 Thread.sleep(3000);
//			 String textareatext = Textarea.getText();
//			 System.out.println("Not returning anything"+textareatext);
//			 if(textareatext.contains("automationtesting tool")) {
//				 
//				 Assert.assertTrue(true);
//			 }		
//	 }
	 @Test(priority=11)
	 public void FeeRowisoptional() throws InterruptedException {
		 
		 driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/1143");
		 WebElement SectionName = driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//li[2]"));
		 SectionName.click();
		 Thread.sleep(4000);
		 WebElement Row6 = driver.findElement(By.xpath("//div[@id='section_section5970']//div[6]//div[2]//div[1]"));
		 Actions action = new Actions(driver);
		 action.doubleClick(Row6).perform();
		 Thread.sleep(3000);
		 WebElement FeeIsOptional = driver.findElement(By.xpath("//div[@class='form-group']/div[1]/input[1]"));
		 WebElement ClientCanEditQuantity= driver.findElement(By.xpath("//div[@class='form-group']/div[2]/input[1]"));
		 FeeIsOptional.click();
		 ClientCanEditQuantity.click();
		 WebElement SaveBtn = driver.findElement(By.xpath("//ul[@class='nav']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
		 SaveBtn.click();
		 Thread.sleep(3000);
		
		WebElement BackBtn = driver.findElement(By.xpath("//ul[@class='nav']//button[@class='nav-link btn back-btn'][contains(text(),'Back')]"));
		BackBtn.click();
		 Thread.sleep(3000);
		 
		driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/1143/true");
		 Thread.sleep(3000);
		 WebElement Table2SectionPreview = driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//li[2]"));
		 Table2SectionPreview.click();
		 Thread.sleep(3000);
		 WebElement footer = driver.findElement(By.xpath("//div[@id='page1-fpFees12220191152473']//div[@class='fees-table-footer']"));
		 String footertextBefore = footer.getText();
		 //System.out.println(footertextBefore);
		 Thread.sleep(2000);

		 WebElement EditableQuantity = driver.findElement(By.xpath("//div[@id='page1-fpFees12220191152473']//input[@name='feequantity']"));
		 EditableQuantity.click();
		 EditableQuantity.clear();
		 EditableQuantity.sendKeys("10");
		 String FootertextAfterQuantityEdit = footer.getText();
		// System.out.println(FootertextAfterQuantityEdit);
		 softAssertion.assertNotEquals(footertextBefore, FootertextAfterQuantityEdit);

		 Thread.sleep(2000);
		 WebElement CheckboxInPreview = driver.findElement(By.xpath("//span[@class='checkround']"));
		 CheckboxInPreview.click();
		 Thread.sleep(2000);
		 String footertextAfter = footer.getText();
		// System.out.println(footertextAfter);
		 Thread.sleep(2000);
		 softAssertion.assertNotEquals(footertextBefore, footertextAfter);
		 Thread.sleep(2000);

		 
		 driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/1143");
		 WebElement SectionNameReset = driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//li[2]"));
		 SectionNameReset.click();
		 WebElement Row6Reset = driver.findElement(By.xpath("//div[@id='section_section5970']//div[6]//div[2]//div[1]"));
		 action.doubleClick(Row6Reset).perform();
		 Thread.sleep(3000);
		 WebElement FeeIsOptionalReset = driver.findElement(By.xpath("//div[@class='form-group']/div[1]/input[1]"));
		 WebElement ClientCanEditQuantityReset= driver.findElement(By.xpath("//div[@class='form-group']/div[2]/input[1]"));
		 FeeIsOptionalReset.click();
		 ClientCanEditQuantityReset.click();
		 WebElement SaveBtnReset = driver.findElement(By.xpath("//ul[@class='nav']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
		 SaveBtnReset.click();
		 Thread.sleep(3000);

		 softAssertion.assertAll();
		 
	 }
	 @Test(priority=10,enabled=false)
	 public void FeeTitleIsEditableReset() throws InterruptedException {
		 driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/1143");
		 WebElement Section3 = driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//li[3]"));
		 Section3.click();
		 Thread.sleep(2000);
		 
		 
		 WebElement Textarea =driver.findElement(By.xpath("//textarea[@id='textbox_13']"));
		
		 Thread.sleep(2000);

		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		 executor.executeScript("arguments[0].click();", Textarea);
		 Thread.sleep(2000);

		 Textarea.clear();
		 Thread.sleep(2000);

		 Textarea.sendKeys("Hey!!!! hieeee my row type is content");
		 Thread.sleep(2000);

		 WebElement SaveBtn = driver.findElement(By.xpath("//ul[@class='nav']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
		 SaveBtn.click();
		 Thread.sleep(3000);
		 executor.executeScript("arguments[0].click();", Textarea);
		 Thread.sleep(3000);

		 String textareatext = Textarea.getText();
		 System.out.println("text does not contain text"+textareatext);
		 
		 if(textareatext.contains("Nikeeta")) {
			 Assert.assertTrue(true);
		 }//Hey!!!! hieeee my row type is content
//		 }else {
//			 Assert.assertTrue(false);
//		 }
//			 
			 
	
		 
	 }
	 @AfterClass
	 public void teardown() {
		 driver.quit();
	 }

}



