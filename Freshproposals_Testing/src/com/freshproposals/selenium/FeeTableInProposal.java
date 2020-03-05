package com.freshproposals.selenium;

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

public class FeeTableInProposal extends Common_Methods{
	
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
	 @Test(priority=1,enabled=false)
	 public void AddRowandRowDiscount() throws InterruptedException {
		 driver.get("http://beta1.freshproposals.com/home/proposals/editProposal/1868");
		 Thread.sleep(3000);
		 WebElement NextBtn = driver.findElement(By.xpath("//button[@class='btn send-btn mt-3']"));
		 NextBtn.click();
		 Thread.sleep(5000);
		 WebElement Cell = driver.findElement(By.xpath("//div[@id='content']//div[5]//div[2]"));
			Cell.click();
			WebElement addrow = driver.findElement(By.xpath("//div[6]//div[2]//div[2]//span[1]"));
			addrow.click();
			Thread.sleep(3000);
			WebElement SecondRow = driver.findElement(By.xpath("//div[@id='content']//div[5]//div[3]"));
			SecondRow.click();
			WebElement RowType =driver.findElement(By.xpath("//div[@class='fees-library-tab-content ng-star-inserted']//div[@class='col-lg-10']//select[@class='form-control ng-untouched ng-pristine ng-valid']"));		
			Select dropdown = new Select(RowType);
			Thread.sleep(1000);
		 	dropdown.selectByIndex(3);
		 Thread.sleep(5000);
			 Thread.sleep(3000);
			 	WebElement SecondRow2 = driver.findElement(By.xpath("//div[@id='content']//div[5]//div[3]"));
				SecondRow2.click();
			 WebElement Price = driver.findElement(By.xpath("//div[@class='rectangle selected']//div[@id='contentInside1']//input[@name='feePrice']"));
			 Price.clear();
			 Price.sendKeys("10000");
			 Thread.sleep(10000);
				SecondRow2.click();
			WebElement AddRowDiscount =driver.findElement(By.xpath("//div[@class='fees-library-tab-content ng-star-inserted']//img[@class='img-fluid']"));
		AddRowDiscount.click();
			WebElement DiscountName = driver.findElement(By.xpath("//div[@class='fees-library-tab-content ng-star-inserted']//input[@placeholder='Discount']"));
					DiscountName.clear();
					DiscountName.sendKeys("RowDisc");
					WebElement DiscAmount = driver.findElement(By.xpath("//div[@class='fees-library-tab-content ng-star-inserted']//input[@id='discount']"));
					DiscAmount.clear();
					DiscAmount.sendKeys("10");
				 	Thread.sleep(1000);
				 	AddRowDiscount.click();
				 	Thread.sleep(3000);
				 	WebElement DiscAmt = driver.findElement(By.xpath("//div[6]//div[3]//div[1]"));
				 	String DiscforQuantity1= DiscAmt.getText();
					System.out.println(DiscforQuantity1);
					WebElement ChangeQuantity = driver.findElement(By.xpath("//div[@class='rectangle selected']//div[@id='contentInside1']//input[@name='feequantity']"));
				 	ChangeQuantity.clear();
				 	ChangeQuantity.sendKeys("79");
				 	Thread.sleep(3000);

				 	WebElement SaveBtn3 = driver.findElement(By.xpath("//li[@class='nav-item']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
				 	SaveBtn3.click();
				 	Thread.sleep(2000);
				 	WebElement BackBtn = driver.findElement(By.xpath("//ul[@class='nav left-navbar']//button[@class='nav-link btn back-btn'][contains(text(),'Back')]"));
				 	BackBtn.click();
				 	Thread.sleep(3000);
				 
				 	 driver.get("http://beta1.freshproposals.com/home/proposals/editProposal/1868");
					 Thread.sleep(3000);
					 WebElement NextBtn2 = driver.findElement(By.xpath("//button[@class='btn send-btn mt-3']"));
					 NextBtn2.click();
					 Thread.sleep(5000);
			 		WebElement Row2text = driver.findElement(By.xpath("//div[@id='content']//div[5]//div[3]"));
				 	String RowT= Row2text.getText();
				 	System.out.println("Row Type is"+RowT);
					softAssertion.assertEquals(RowT, "Monthly");
					WebElement DiscAmt2 = driver.findElement(By.xpath("//div[6]//div[3]//div[1]"));
					String DiscforQuantity79= DiscAmt2.getText();
					softAssertion.assertNotEquals(DiscforQuantity1, DiscforQuantity79);
					System.out.println(DiscforQuantity1);
					System.out.println(DiscforQuantity79);
			 
					WebElement SecondRow3 = driver.findElement(By.xpath("//div[@id='content']//div[5]//div[3]"));
					SecondRow3.click();
					WebElement DeleteRow = driver.findElement(By.xpath("//div[6]//div[3]//div[2]//span[2]//img[1]"));
					 DeleteRow.click();
					 Thread.sleep(4000);
					 
					WebElement SaveBtn4 = driver.findElement(By.xpath("//li[@class='nav-item']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
					SaveBtn4.click();
					Thread.sleep(2000);
					softAssertion.assertAll();
	 }
	@Test(priority=2,enabled=false)
	public void ChangetheRowType() throws InterruptedException {
		driver.get("http://beta1.freshproposals.com/home/proposals/editProposal/1868");
		 Thread.sleep(3000);
		 WebElement NextBtn = driver.findElement(By.xpath("//button[@class='btn send-btn mt-3']"));
		 NextBtn.click();
		 Thread.sleep(5000);
		 WebElement SectionTable2 = driver.findElement(By.xpath("//a[contains(text(),'FeeTable2')]"));
		 SectionTable2.click();
		 Thread.sleep(3000);
		 WebElement Row1 = driver.findElement(By.xpath("//div[@id='content']//div[5]//div[2]"));
		 Row1.click();
		 Thread.sleep(1000);
		 WebElement RowType = driver.findElement(By.xpath("//div[@class='fees-library-tab-content ng-star-inserted']//div[@class='col-lg-10']//select[@class='form-control ng-untouched ng-pristine ng-valid']"));
		 Select dropdown = new Select(RowType);
		 Thread.sleep(1000);
		 dropdown.selectByIndex(0);
		 Thread.sleep(1000);
		 WebElement Row2 = driver.findElement(By.xpath("//div[@id='content']//div[5]//div[3]"));
		 Row2.click();
		 Thread.sleep(1000);
		WebElement RowType1 = driver.findElement(By.xpath("//div[@class='fees-library-tab-content ng-star-inserted']//div[@class='col-lg-10']//select[@class='form-control ng-untouched ng-pristine ng-valid']"));
			Select dropdown1 = new Select(RowType1);
	 dropdown1.selectByIndex(1);
		 Thread.sleep(1000);
	 WebElement Row3 = driver.findElement(By.xpath("//div[@id='content']//div[5]//div[4]"));
	 Row3.click();
		 Thread.sleep(1000);
		WebElement RowType2 = driver.findElement(By.xpath("//div[@class='fees-library-tab-content ng-star-inserted']//div[@class='col-lg-10']//select[@class='form-control ng-untouched ng-pristine ng-valid']"));
		Select dropdown2 = new Select(RowType2);
	 dropdown2.selectByIndex(2);
		 Thread.sleep(1000);
		 WebElement Row4 = driver.findElement(By.xpath("//div[@id='content']//div[5]//div[5]"));
		 Row4.click();
		 Thread.sleep(1000);
		WebElement RowType3 = driver.findElement(By.xpath("//div[@class='fees-library-tab-content ng-star-inserted']//div[@class='col-lg-10']//select[@class='form-control ng-untouched ng-pristine ng-valid']"));
			Select dropdown3 = new Select(RowType3);
		 dropdown3.selectByIndex(3);
		 Thread.sleep(1000);
		 WebElement Row5 = driver.findElement(By.xpath("//div[@id='content']//div[5]//div[6]"));
		 Row5.click();
		 Thread.sleep(1000);
			WebElement RowType4 = driver.findElement(By.xpath("//div[@class='fees-library-tab-content ng-star-inserted']//div[@class='col-lg-10']//select[@class='form-control ng-untouched ng-pristine ng-valid']"));
			Select dropdown4 = new Select(RowType4);
		 dropdown4.selectByIndex(4);
		 Thread.sleep(1000);
		 WebElement Row6 = driver.findElement(By.xpath("//div[@id='content']//div[5]//div[7]"));
		 Row6.click();
		Thread.sleep(1000);
		WebElement RowType5 = driver.findElement(By.xpath("//div[@class='fees-library-tab-content ng-star-inserted']//div[@class='col-lg-10']//select[@class='form-control ng-untouched ng-pristine ng-valid']"));
		Select dropdown5 = new Select(RowType5);
		 dropdown5.selectByIndex(5);
		 Thread.sleep(1000);
		 WebElement Table = driver.findElement(By.id("page1-fpFees1220201911525134"));
		 Table.click();
		 Thread.sleep(1000);
		 WebElement TableOption = driver.findElement(By.linkText("Total Options"));
		 TableOption.click();
		 WebElement SeprateRecurringFee = driver.findElement(By.xpath("//div[@class='switch-btn text-position']//label[@class='tgl-btn']"));
		 SeprateRecurringFee.click();
		 Thread.sleep(2000);

		 WebElement SaveBtn = driver.findElement(By.xpath("//li[@class='nav-item']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
		 SaveBtn.click();
		 Thread.sleep(3000);
		 //WebElement BackBtn = driver.findElement(By.xpath("//ul[@class='nav ng-star-inserted']//button[@class='nav-link btn back-btn'][contains(text(),'Back')]"));
		// BackBtn.click();
		// Thread.sleep(3000);
		 driver.get("http://beta1.freshproposals.com/home/proposals/editProposal/1868");
		 Thread.sleep(3000);
		 WebElement NextBtn1 = driver.findElement(By.xpath("//button[@class='btn send-btn mt-3']"));
		 NextBtn1.click();
		 Thread.sleep(5000);
		
	 WebElement SectionTable2Reset = driver.findElement(By.xpath("//a[contains(text(),'FeeTable2')]"));
		 SectionTable2Reset.click();
		 Thread.sleep(2000);
		 WebElement Row1Reset = driver.findElement(By.xpath("//div[@id='content']//div[5]//div[2]"));
		 WebElement Row2Reset = driver.findElement(By.xpath("//div[@id='content']//div[5]//div[3]"));
		 WebElement Row3Reset = driver.findElement(By.xpath("//div[@id='content']//div[5]//div[4]"));
		 WebElement Row4Reset = driver.findElement(By.xpath("//div[@id='content']//div[5]//div[5]"));
		 WebElement Row5Reset = driver.findElement(By.xpath("//div[@id='content']//div[5]//div[6]"));
		 WebElement Row6Reset = driver.findElement(By.xpath("//div[@id='content']//div[5]//div[7]"));
		 softAssertion.assertEquals(Row1Reset.getText(), "UnitQty");
		 softAssertion.assertEquals(Row2Reset.getText(), "Fixed");
		 softAssertion.assertEquals(Row3Reset.getText(), "Hourly");
		 softAssertion.assertEquals(Row4Reset.getText(), "Monthly");
		 softAssertion.assertEquals(Row5Reset.getText(), "Yearly");
		 softAssertion.assertEquals(Row6Reset.getText(), "");
	WebElement TableFooter =driver.findElement(By.xpath("//div[@id='page1-fpFees1220201911525134']//div[@class='fees-table-footer']"));
	String footertext = TableFooter.getText();
	System.out.println(footertext);
	if(footertext.contains("Sub Total per year 20.00")) {
		softAssertion.assertTrue(true);
	}
	if(footertext.contains("Sub Total per month 4,000.00")) {
		softAssertion.assertTrue(true);
	}
	if(footertext.contains("Sub Total per hour 500.00")) {
		softAssertion.assertTrue(true);
	}
		 WebElement TableReset = driver.findElement(By.id("page1-fpFees1220201911525134"));
		 TableReset.click();
		 Thread.sleep(1000);
		 WebElement TableOptionReset = driver.findElement(By.linkText("Total Options"));
		 TableOptionReset.click();
		 WebElement SeprateRecurringFeeReset = driver.findElement(By.xpath("//div[@class='switch-btn text-position']//label[@class='tgl-btn']"));
		 SeprateRecurringFeeReset.click();
		 Thread.sleep(2000);
		 Row1Reset.click();
		 Thread.sleep(1000);
		WebElement RowType1Reset = driver.findElement(By.xpath("//div[@class='fees-library-tab-content ng-star-inserted']//div[@class='col-lg-10']//select[@class='form-control ng-untouched ng-pristine ng-valid']"));
		 Select dropdown1Reset = new Select(RowType1Reset);
		 Thread.sleep(1000);
		 dropdown1Reset.selectByIndex(0);
		 Thread.sleep(1000);

		 Row2Reset.click();
		 Thread.sleep(1000);
		 WebElement RowType2Reset = driver.findElement(By.xpath("//div[@class='fees-library-tab-content ng-star-inserted']//div[@class='col-lg-10']//select[@class='form-control ng-untouched ng-pristine ng-valid']"));
		Select dropdown2Reset = new Select(RowType2Reset);
		dropdown2Reset.selectByIndex(0);
		Thread.sleep(1000);

		 Row3Reset.click();
	 Thread.sleep(1000);
			WebElement RowType3Reset = driver.findElement(By.xpath("//div[@class='fees-library-tab-content ng-star-inserted']//div[@class='col-lg-10']//select[@class='form-control ng-untouched ng-pristine ng-valid']"));
			Select dropdown3Reset = new Select(RowType3Reset);
		 dropdown3Reset.selectByIndex(0);
		 Thread.sleep(1000);
		 Row4Reset.click();
		 Thread.sleep(1000);

		WebElement RowType4Reset = driver.findElement(By.xpath("//div[@class='fees-library-tab-content ng-star-inserted']//div[@class='col-lg-10']//select[@class='form-control ng-untouched ng-pristine ng-valid']"));
		Select dropdown4Reset = new Select(RowType4Reset);
			dropdown4Reset.selectByIndex(0);
		 Thread.sleep(1000);
		 Row5Reset.click();
		 Thread.sleep(1000);
		WebElement RowType5Reset = driver.findElement(By.xpath("//div[@class='fees-library-tab-content ng-star-inserted']//div[@class='col-lg-10']//select[@class='form-control ng-untouched ng-pristine ng-valid']"));
			Select dropdown5Reset = new Select(RowType5Reset);
		 dropdown5Reset.selectByIndex(0);
		 Thread.sleep(1000);
		 Row6Reset.click();
		 Thread.sleep(1000);
			WebElement RowType6Reset = driver.findElement(By.xpath("//div[@class='fees-library-tab-content ng-star-inserted']//div[@class='col-lg-10']//select[@class='form-control ng-untouched ng-pristine ng-valid']"));
			Select dropdown6Reset = new Select(RowType6Reset);
			dropdown6Reset.selectByIndex(0);
			Thread.sleep(1000);
	 WebElement SaveBtn1 = driver.findElement(By.xpath("//li[@class='nav-item']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
		 SaveBtn1.click();
		 Thread.sleep(3000);
		 softAssertion.assertEquals(Row1Reset.getText(), "UnitQty");
		 softAssertion.assertEquals(Row2Reset.getText(), "UnitQty");
		 softAssertion.assertEquals(Row3Reset.getText(), "UnitQty");
		 softAssertion.assertEquals(Row4Reset.getText(), "UnitQty");
		 softAssertion.assertEquals(Row5Reset.getText(), "UnitQty");
		 softAssertion.assertEquals(Row6Reset.getText(), "UnitQty");

		 WebElement BackBtn1 = driver.findElement(By.xpath("//ul[@class='nav left-navbar']//button[@class='nav-link btn back-btn'][contains(text(),'Back')]"));
		 BackBtn1.click();
		 Thread.sleep(3000);		 
		 softAssertion.assertAll();
		
	}
	@Test(priority=3,enabled=false)
	public void TableDiscountAndTax() throws InterruptedException {
		driver.get("http://beta1.freshproposals.com/home/proposals/editProposal/1868");
		 Thread.sleep(3000);
		 WebElement NextBtn = driver.findElement(By.xpath("//button[@class='btn send-btn mt-3']"));
		 NextBtn.click();
		 Thread.sleep(5000);
		 WebElement feetable = driver.findElement(By.xpath("//div[contains(text(),'Price')]"));
		 feetable.click();
		 Thread.sleep(2000);
		 WebElement tableDisc = driver.findElement(By.xpath("//label[contains(text(),'Table Discount')]//img"));
		 tableDisc.click();
		 WebElement ShowDisc =driver.findElement(By.xpath("//input[@name='showTableDiscount']"));
		 ShowDisc.click();
		WebElement  DiscName  = driver.findElement(By.name("discountName"));
		DiscName.clear();
		DiscName.sendKeys("TableDisc");
		WebElement DiscAmount = driver.findElement(By.xpath("//input[@name='discount']"));
		DiscAmount.clear();
		DiscAmount.sendKeys("10");
		Thread.sleep(1000);
		tableDisc.click();
		Thread.sleep(2000);
		WebElement Discount = driver.findElement(By.xpath("//div[@class='fees-table-footer']//div[2]//p[1]"));
			String DiscountAmount=Discount.getText();
			softAssertion.assertEquals(DiscountAmount, "TableDisc ( 10 % )");
			System.out.println(DiscountAmount);
			WebElement tabletax1 = driver.findElement(By.xpath("//label[@class='fees-prop-header'][contains(text(),'Tax 1')]//img"));
			tabletax1.click();
			 driver.findElement(By.xpath("//input[@name='showTax1']")).click();
			 WebElement TaxName = driver.findElement(By.xpath("//input[@placeholder='Tax1 Name']"));
			 TaxName.clear();
			 TaxName.sendKeys("SGST");
			 WebElement tax1amount = driver.findElement(By.xpath("//input[@name='tax1Value']"));
			 tax1amount.clear();
			tax1amount.sendKeys("10");
				Thread.sleep(4000);
				 WebElement Tabletax2 = driver.findElement(By.xpath("//label[@class='fees-prop-header'][contains(text(),'Tax 2')]//img"));
				 Thread.sleep(2000);
					tabletax1.click();

				 Tabletax2.click();
				 WebElement ShowTax2 = driver.findElement(By.xpath("//input[@name='showTax2']"));
				 Thread.sleep(2000);
				 ShowTax2.click();
				 WebElement Tax2Name = driver.findElement(By.xpath("//input[@placeholder='Tax2 Name']"));
				 Tax2Name.clear();
				 Tax2Name.sendKeys("HGST");
			WebElement tax2amount = driver.findElement(By.xpath("//input[@name='tax2Value']"));	
			tax2amount.clear();
			tax2amount.sendKeys("10");
			Thread.sleep(5000);
			WebElement Row1 = driver.findElement(By.xpath("//div[@id='content']//div[5]//div[2]"));
			Actions action = new Actions(driver);
			Thread.sleep(3000);
			Row1.click();
			WebElement ExportFee = driver.findElement(By.xpath("//div[6]//div[2]//div[2]//span[4]//img[1]"));
			ExportFee.click();
			
			Thread.sleep(10000);
			WebElement FeeLibrary = driver.findElement(By.xpath("//div[@class='tabs-underlined fees-row-content']//ul[@class='nav nav-tabs nav-justified']//a //div[contains(text(),'Fees Library')]"));
			FeeLibrary.click();
			Thread.sleep(2000);
			action.doubleClick(Row1).perform();
			WebElement ImportFee = driver.findElement(By.xpath("//div[6]//div[2]//div[2]//span[3]//img[1]"));
			ImportFee.click();
			Thread.sleep(1000);
			WebElement Checkbox1 = driver.findElement(By.xpath("//div[@class=\"form-check\"]//input[@name=\"checkbox\"] "));
			Checkbox1.click();
			WebElement Addfee = driver.findElement(By.xpath("//button[@class='btn']"));
			Addfee.click();
			Thread.sleep(1000);

			WebElement Fee1 = driver.findElement(By.xpath("//div[@class='form-check']"));
			action.moveToElement(Fee1).perform();
			Thread.sleep(1000);
			WebElement DeleteFee = driver.findElement(By.xpath("//div[@class='fees-delete']//img"));
			DeleteFee.click();
			Thread.sleep(10000);
			WebElement Row2 = driver.findElement(By.xpath("//div[@id='content']//div[5]//div[3]"));
			action.doubleClick(Row2).perform();
			WebElement DeleteRow2 = driver.findElement(By.xpath("//div[6]//div[3]//div[2]//span[2]//img[1]"));
			DeleteRow2.click();

	
			 WebElement Table = driver.findElement(By.xpath("//div[contains(text(),'Quantity')]"));
			 Table.click();
			 Thread.sleep(2000);
			 WebElement TableOption = driver.findElement(By.linkText("Total Options"));
			 TableOption.click();
			 Thread.sleep(2000);
	
			 WebElement tablesubtotal =	 driver.findElement(By.xpath("//div[@class='col-lg-5 offset-lg-2 p-0']//label[@class='tgl-btn']"));
			 tablesubtotal.click();
			 Thread.sleep(2000);
	
			 WebElement tabletotal = driver.findElement(By.xpath("//label[@for='tableTotal']"));
			 tabletotal.click();
			 Thread.sleep(2000);
			 
			 WebElement tableDiscount = driver.findElement(By.xpath("//div[@class='col-lg-5 p-0']//label[@class='tgl-btn']"));
			 tableDiscount.click();
			 Thread.sleep(2000);
			 WebElement SaveBtn = driver.findElement(By.xpath("//li[@class='nav-item']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
			 SaveBtn.click();
			 Thread.sleep(3000);		 
		 WebElement BackBtn = driver.findElement(By.xpath("//ul[@class='nav left-navbar']//button[@class='nav-link btn back-btn'][contains(text(),'Back')]"));
		 BackBtn.click();
		 Thread.sleep(3000);
		// this.ResetTableDiscount();
			
	}
	@Test(priority=4,enabled=false)
	public void ResetTableDiscount() throws InterruptedException {
		driver.get("http://beta1.freshproposals.com/home/proposals/editProposal/1868");
		 Thread.sleep(5000);
		 WebElement NextBtn = driver.findElement(By.xpath("//button[@class='btn send-btn mt-3']"));
		 NextBtn.click();
		 Thread.sleep(5000);
		 WebElement SaveBtn = driver.findElement(By.xpath("//li[@class='nav-item']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));

		 WebElement feetable = driver.findElement(By.xpath("//div[contains(text(),'Price')]"));
		 feetable.click();
		Thread.sleep(4000);
	 
		 WebElement tax1amount = driver.findElement(By.xpath("//div[@class='total-fee-calculator']//div[1]//p[1]"));
		 String Tax1Amount = tax1amount.getText();
		 System.out.println(Tax1Amount);
		softAssertion.assertEquals(Tax1Amount, "SGST ( 10 % )");

		 WebElement tax2amount = driver.findElement(By.xpath("//div[@class='fees-table-footer']//div[2]//p[1]"));
		 String Tax2Amount = tax2amount.getText();
		 softAssertion.assertEquals(Tax2Amount, "HGST ( 10 % )");
		 System.out.println(Tax2Amount);
		 Thread.sleep(4000);
		 WebElement tableDisc = driver.findElement(By.xpath("//label[contains(text(),'Table Discount')]//img"));
		 tableDisc.click();
		WebElement  DiscName  = driver.findElement(By.name("discountName"));
		DiscName.clear();
		WebElement DiscAmount = driver.findElement(By.xpath("//input[@name='discount']"));
		DiscAmount.clear();
		 WebElement ShowDisc =driver.findElement(By.xpath("//input[@name='showTableDiscount']"));
		 ShowDisc.click();
		Thread.sleep(3000);
		 tableDisc.click();
		Thread.sleep(5000);
		WebElement tabletax1 = driver.findElement(By.xpath("//label[@class='fees-prop-header'][contains(text(),'Tax 1')]//img"));
		tabletax1.click();
		 driver.findElement(By.xpath("//input[@name='showTax1']")).click();
		 Thread.sleep(3000);
			 WebElement TaxName = driver.findElement(By.xpath("//input[@placeholder='Tax1 Name']"));
			 TaxName.clear();	
			 WebElement tax1Amount = driver.findElement(By.xpath("//input[@name='tax1Value']"));
				tax1Amount.clear();
				SaveBtn.click();
				Thread.sleep(4000);
				tabletax1.click();
				Thread.sleep(5000);
				 WebElement Tabletax2 = driver.findElement(By.xpath("//label[@class='fees-prop-header'][contains(text(),'Tax 2')]//img"));
				 Thread.sleep(2000);
				 Tabletax2.click();
				 WebElement Tax2Name = driver.findElement(By.xpath("//input[@placeholder='Tax2 Name']"));
				 Tax2Name.clear();
				 WebElement tax2Amount = driver.findElement(By.xpath("//input[@name='tax2Value']"));
				 tax2Amount.clear();
				 Thread.sleep(5000);
				 WebElement ShowTax2 = driver.findElement(By.xpath("//input[@name='showTax2']"));
				 ShowTax2.click();
				 Thread.sleep(4000);
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
			 
			 WebElement tableDiscount = driver.findElement(By.xpath("//div[@class='col-lg-5 p-0']//label[@class='tgl-btn']"));
			 Thread.sleep(5000);
			 tableDiscount.click();
			 Thread.sleep(2000);
			 SaveBtn.click();
			 Thread.sleep(3000);
			 SaveBtn.click();
			 Thread.sleep(3000);
			 WebElement BackBtn = driver.findElement(By.xpath("//ul[@class='nav left-navbar']//button[@class='nav-link btn back-btn'][contains(text(),'Back')]"));
			 BackBtn.click();
			 Thread.sleep(3000);
			 softAssertion.assertAll();
	}
	@Test(priority=5)
	public void FeeisoptionalandChangetheQoantity() throws InterruptedException {
		driver.get("http://beta1.freshproposals.com/home/proposals/editProposal/1868");
		 Thread.sleep(5000);
		 WebElement NextBtn = driver.findElement(By.xpath("//button[@class='btn send-btn mt-3']"));
		 NextBtn.click();
		 Thread.sleep(5000);
		 WebElement Row6 = driver.findElement(By.xpath("//div[@id='content']//div[5]//div[2]"));	
		 Thread.sleep(3000);
		 Row6.click();
			 WebElement FeeIsOptional = driver.findElement(By.xpath("//div[@class='form-group']/div[1]/input[1]"));
			 WebElement ClientCanEditQuantity= driver.findElement(By.xpath("//div[@class='form-group']/div[2]/input[1]"));
			 FeeIsOptional.click();
			 Thread.sleep(2000);
			 ClientCanEditQuantity.click();
			 Thread.sleep(2000);

			 WebElement SaveBtn = driver.findElement(By.xpath("//li[@class='nav-item']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
			 SaveBtn.click();
			 Thread.sleep(3000);
			 WebElement BackBtn = driver.findElement(By.xpath("//ul[@class='nav left-navbar']//button[@class='nav-link btn back-btn'][contains(text(),'Back')]"));
			 BackBtn.click();
			 Thread.sleep(3000);	 
			driver.get("http://beta1.freshproposals.com/home/viewproposal/1868/preview/proposals");
			 Thread.sleep(7000);
			 WebElement footer = driver.findElement(By.xpath("//div[@id='page1-fpFees12220191152473']//div[@class='fees-table-footer']"));
			 String footertextBefore = footer.getText();
			 Thread.sleep(2000);
//			 WebElement EditableQuantity = driver.findElement(By.xpath("//div[@id='page1-fpFees12220191152473']//input[@name='feequantity']"));
//			 EditableQuantity.click();
//			 EditableQuantity.clear();
//			 EditableQuantity.sendKeys("10");
//			 String FootertextAfterQuantityEdit = footer.getText();
//			 softAssertion.assertNotEquals(footertextBefore, FootertextAfterQuantityEdit);
//			 Thread.sleep(2000);
//			 WebElement CheckboxInPreview = driver.findElement(By.xpath("//span[@class='checkround']"));
//			 CheckboxInPreview.click();
//			 Thread.sleep(2000);
//			 String footertextAfter = footer.getText();
//			// System.out.println(footertextAfter);
//			 Thread.sleep(2000);
//			 softAssertion.assertNotEquals(footertextBefore, footertextAfter);
//			 Thread.sleep(2000);
				driver.get("http://beta1.freshproposals.com/home/proposals/editProposal/1868");
				 Thread.sleep(5000);
				 WebElement NextBtn1 = driver.findElement(By.xpath("//button[@class='btn send-btn mt-3']"));
				 NextBtn1.click();
				 Thread.sleep(5000);
			 WebElement Row6Reset = driver.findElement(By.xpath("//div[@id='content']//div[5]//div[2]"));
			 Row6Reset.click();
			 WebElement FeeIsOptionalReset = driver.findElement(By.xpath("//div[@class='form-group']/div[1]/input[1]"));
			 WebElement ClientCanEditQuantityReset= driver.findElement(By.xpath("//div[@class='form-group']/div[2]/input[1]"));
			 FeeIsOptionalReset.click();
			 ClientCanEditQuantityReset.click();
			 WebElement SaveBtn2 = driver.findElement(By.xpath("//li[@class='nav-item']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
			 SaveBtn2.click();
			 Thread.sleep(3000);

			 softAssertion.assertAll();
			 
	}
	 

	 @AfterClass
	 public void teardown() {
		 driver.quit();
	 }

	
	
	

}
