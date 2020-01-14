package com.freshproposals.selenium;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FeetableAll extends Common_Methods{
	WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
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
  @Test(priority = 1,dependsOnMethods = {"login"})
	  
  public void readtable() throws InterruptedException {
		
		driver.get("http://beta1.freshproposals.com/home/sections/editSection/4328");
		
		Thread.sleep(5000);
			List<WebElement> rows =	driver.findElements(By.xpath("//tbody//tr"));
			int rowcount = rows.size();
			System.out.println("Total number of rows present into the table:"+rowcount);
			Actions actions = new Actions(driver);
			
			WebElement elementLocator = driver.findElement(By.xpath("//tr[1]//td[6]"));
			actions.contextClick(elementLocator).perform();
			Thread.sleep(5000);
			
			try
			{
			WebElement addrow =	driver.findElement(By.xpath("//tr[@class='selected active']//span[1]//img[1]"));
			Thread.sleep(1000);
			addrow.click();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			List<WebElement> rows1 =	driver.findElements(By.xpath("//tbody//tr"));
			int rowcount2 = rows1.size();
			System.out.println("Total number of rows after adding new row :"+rowcount2);
			driver.findElement(By.xpath("//button[@class='nav-link btn send-btn']")).click();
			driver.findElement(By.xpath("//button[@class='nav-link btn back-btn']")).click();
			driver.get("http://beta1.freshproposals.com/home/sections/editSection/4328");
			Thread.sleep(3000);
			List<WebElement> rows2 =	driver.findElements(By.xpath("//tbody//tr"));
			int rowcount3 = rows2.size();
			System.out.println("Total Number of rows after saving and again opening that section:"+rowcount3);
			Thread.sleep(5000);
			WebElement ele=	driver.findElement(By.xpath("//tr[1]//td[6]"));
			Thread.sleep(1000);
			actions.contextClick(ele).perform();
			WebElement deleterow =	driver.findElement(By.xpath("//tr[@class='selected active']//span[2]//img[1]"));
			Thread.sleep(3000);
			deleterow.click();
			Thread.sleep(4000);
			List<WebElement> delete =	driver.findElements(By.xpath("//tbody//tr"));
			int rowcount4 = delete.size();
			System.out.println("Total number of rows after deleting one row from table :"+rowcount4);
			driver.findElement(By.xpath("//button[@class='nav-link btn send-btn']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='nav-link btn back-btn']")).click();
			Thread.sleep(1000);
			driver.get("http://beta1.freshproposals.com/home/sections/editSection/4328");
			Thread.sleep(3000);

			List<WebElement> delete1 =	driver.findElements(By.xpath("//tbody//tr"));
			int rowcount5 = delete1.size();
			System.out.println("Total number of rows after deleting one row from table and saving the section :"+rowcount5);
		
	}
  @Test(priority=2,dependsOnMethods = {"login"})
  public void RowTypeSelected() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("http://beta1.freshproposals.com/home/sections/editSection/4336");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr[1]//td[5]")).click();
		Thread.sleep(1000);
		WebElement box =driver.findElement(By.xpath("//div[@class='fees-library-tab-content']//div[@class='col-lg-10']//select[@class='form-control ng-untouched ng-pristine ng-valid']"));
		Thread.sleep(3000);

		for(int i=0;i<=4;i++) {
			Select RowType = new Select(box);
			RowType.selectByIndex(i);
			Thread.sleep(2000);
			WebElement RowT=	driver.findElement(By.xpath("//tr[1]//td[5]"));
			System.out.println("Selected row type in the table is :"+RowT.getText());

			
				
			}	

  }
  @Test(priority=3,dependsOnMethods = {"login"})
  public void RowDiscount() throws InterruptedException {
		driver.get("http://beta1.freshproposals.com/home/sections/editSection/4336");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//tr[1]//td[5]")).click();
		driver.findElement(By.id("chkDisc1")).click();
		WebElement DiscountName = driver.findElement(By.xpath("//div[@class='fees-library-tab-content']//input[@placeholder='Discount']"));
		DiscountName.clear();
		DiscountName.sendKeys("RowDiscount");
		Thread.sleep(5000);
		WebElement Disc =driver.findElement(By.xpath("//div[@class='fees-library-tab-content']//div[@class='col-lg-12']//div[@class='row']//input[@class='form-control ng-untouched ng-pristine ng-valid']"));
		Disc.clear();
		Disc.sendKeys("5");
		Thread.sleep(3000);
		String  IsDiscountApplied=	driver.findElement(By.xpath("//tr[1]//td[6]")).getText();
		//System.out.println(IsDiscountApplied.getText());
		if(IsDiscountApplied.contains("RowDiscount")) {
			System.out.println("You applied row discount Successfully");
		}else {
			System.out.println("Row discount not applied successfully");
		}
	}
  @Test(priority=4,dependsOnMethods = {"login"})
  public void TableDiscount() throws InterruptedException {
		driver.get("http://beta1.freshproposals.com/home/sections/editSection/4336");
		Thread.sleep(2000);
		WebElement TableDiscount = driver.findElement(By.xpath("//body//th[4]"));
		TableDiscount.click();
		Thread.sleep(5000);
		if ( !driver.findElement(By.name("showTableDiscount")).isSelected() )
		{
		     driver.findElement(By.name("showTableDiscount")).click();
		}
		Thread.sleep(2000);
		WebElement discountname =	driver.findElement(By.name("discountName"));
		discountname.sendKeys("TableDiscount");
		WebElement discount = driver.findElement(By.name("discount"));
		discount.clear();
		discount.sendKeys("10");
		Thread.sleep(5000);
		String TotalFee =	driver.findElement(By.xpath("//div[@class='total-fee-calculator']")).getText();
		//System.out.println(TotalFee.getText());
		if(TotalFee.contains("TableDiscount")){
			System.out.println("Table Discount applied successfully");		
		}else {
			System.out.println("You are not able to applied table discount");
		}
		}
  @Test(priority=5,dependsOnMethods = {"login"})
  public void AddTax1() throws InterruptedException {
		driver.get("http://beta1.freshproposals.com/home/sections/editSection/4336");
		Thread.sleep(2000);
		WebElement TableTax = driver.findElement(By.xpath("//body//th[4]"));
		TableTax.click();
		driver.findElement(By.xpath("//label[@class='fees-prop-header'][contains(text(),'Tax 1')]//img")).click();
		if ( !driver.findElement(By.name("showTax1")).isSelected() )
		{
		     driver.findElement(By.name("showTax1")).click();
		}
		WebElement Tax1Name = driver.findElement(By.name("tax1Name"));
		
		Tax1Name.sendKeys("HGST");
		WebElement tax1Value =driver.findElement(By.name("tax1Value"));
		tax1Value.sendKeys("10");
		String Tax1 =	driver.findElement(By.xpath("//div[@class='total-fee-calculator']")).getText();
		//System.out.println(Tax1.getText());
		if(Tax1.contains("HGST")) {
			System.out.println("You add the first tax successfully");
			
		}else {
			System.out.println("You are not able to apply the tax successfully");
			
		}
		}
  @Test(priority = 6,dependsOnMethods = {"login"})
  public void AddTax2() throws InterruptedException {
		driver.get("http://beta1.freshproposals.com/home/sections/editSection/4336");
		Thread.sleep(2000);
		WebElement TableHeader = driver.findElement(By.xpath("//body//th[4]"));
		TableHeader.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[contains(text(),'Table Discount')]//img")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[@class='fees-prop-header'][contains(text(),'Tax 2')]//img")).click();
		if ( !driver.findElement(By.name("showTax2")).isSelected() )
		{
		     driver.findElement(By.name("showTax2")).click();
		}
		WebElement Tax1Name = driver.findElement(By.name("tax2Name"));
		Tax1Name.sendKeys("SGST");
		Actions act = new Actions(driver);
		WebElement win =	driver.findElement(By.xpath("//body/app-root/app-home/div[@class='wrapper']/div/div[@class='fixed-sidebar col-lg-2 offset-lg-10 p-0 right-zero']/div[@class='sidebar-editor-right']/div/div[2]/div[1]"));
		act.moveToElement(win).perform();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)");
		WebElement tax1Value =driver.findElement(By.name("tax2Value"));
		tax1Value.sendKeys("8");
		String Tax2 =	driver.findElement(By.xpath("//div[@class='total-fee-calculator']")).getText();
		//System.out.println(Tax2);
		if(Tax2.contains("SGST")) {
			System.out.println("You applied Tax 2 successfully");
		}else{
			System.out.println("You are not able to apply tax 2");
		}
		Thread.sleep(5000);
		
  }	
  @Test (priority=7,dependsOnMethods = {"login"})
	public void FeesLibraryExport() throws InterruptedException {
		driver.get("http://beta1.freshproposals.com/home/sections/editSection/4509");
		WebElement Row1Click=driver.findElement(By.xpath("//tr[1]//td[5]"));
		Row1Click.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='2']")).click();
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//tr[1]//td[6]"));
		actions.contextClick(elementLocator).perform();
		driver.findElement(By.xpath("//body//span[4]")).click();
		driver.findElement(By.xpath("//a[@id='2']")).click();
		if(driver.findElement(By.xpath("//label[contains(text(),'25000')]"))!= null){

			System.out.println("Fee imported successfully");

			}else{

			System.out.println("Fee is not imported");

			}
			Thread.sleep(5000);
		driver.findElement(By.xpath("//label[contains(text(),'25000')]")).click();

		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//div[@class=\"fees-delete\"]//img")).click();
		System.out.println("Fees Deleted successfully");
	}
  
  @AfterClass
  public void closeBrowser() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.close();
  }
  
  
  
}



