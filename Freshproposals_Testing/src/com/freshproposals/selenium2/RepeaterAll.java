package com.freshproposals.selenium2;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.freshproposals.selenium.Common_Methods;

public class RepeaterAll extends Common_Methods {
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
	 	public void Repeater() throws InterruptedException {
	 		driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/1242");
	 		Thread.sleep(3000);
	     
	 		WebElement RHSMenuArrow = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/app-template-properties[1]/form[1]/div[1]/div[2]"));
	         RHSMenuArrow.click();
	 		Thread.sleep(2000);
	 		WebElement RepeterMenu = driver.findElement(By.xpath("//p[contains(text(),'Repeater')]"));
	 		RepeterMenu.click();
	 		WebElement TextFontSize = driver.findElement(By.xpath("//div[@id='froalapage1-fpText121220199585999']//p[@class='fpHeading2'][contains(text(),'Freshproposals')]"));
	 		
	 		String fontsize1 =TextFontSize.getCssValue("font-size");
	 		//System.out.println(str);
	 		Assert.assertEquals(fontsize1, "28px");
	 		TextFontSize.click();
	 		Thread.sleep(2000);
	 		WebElement P4 = driver.findElement(By.xpath("//button[starts-with(@id,'paragraphStyle')]"));
	 		
	 		P4.click();
	 		Thread.sleep(2000);
	 		WebElement heading1 = driver.findElement(By.xpath("//a[@class='fr-command fpHeading1']"));
	 		heading1.click();
	 		 Thread.sleep(2000);
	 		WebElement TextFontSize2 = driver.findElement(By.xpath("//div[@id='froalapage1-fpText121220199585999']//p[@class='fpHeading1'][contains(text(),'Freshproposals')]"));
	 		 String fontsize2 =TextFontSize2.getCssValue("font-size");
	 		 Assert.assertEquals(fontsize2, "36px");
	 		// WebElement RepeterShape =driver.findElement(By.id("page1-fpShape121220191011694"));
	 		//RepeterShape.click();
	 		
	 		
	 	}
	 	@Test(priority =2,dependsOnMethods = {"login"})
	 	public void RepeaterShape() throws InterruptedException {
	 		 WebElement RepeterShape =driver.findElement(By.id("page1-fpShape121220191011694"));
		 		RepeterShape.click();
 				Thread.sleep(5000);
 				  Actions builder = new Actions(driver);
 			        builder.moveToElement(RepeterShape).build().perform();
		 		WebElement  shapeResize = driver.findElement(By.xpath("//div[@id='page1-fpShape121220191011694']//div[@id='segrip']"));
 				resize( shapeResize, 150, 75);
 				int Width = RepeterShape.getSize().getWidth();
 				int Height = RepeterShape.getSize().getHeight();  
 				//System.out.println(Width);
 				//System.out.println(Height);
 				Assert.assertEquals(Width, 270);     
 				Assert.assertEquals(Height, 186);
 				Thread.sleep(5000);
	 		
	 	}
	 	@Test(priority =3,dependsOnMethods = {"login"},enabled=false)
	 	public void ImageResize() throws InterruptedException {
	 		WebElement RepeaterImage = driver.findElement(By.id("page1-fpImage121220191005127"));
	 		RepeaterImage.click();
	 		WebElement  shapeResize = driver.findElement(By.xpath("//div[@id='page1-fpImage121220191005127']//div[@id='nwgrip']"));
	 		resize( shapeResize, 150, 75);
				int Width = RepeaterImage.getSize().getWidth();
				int Height = RepeaterImage.getSize().getHeight();  
				//System.out.println("Image Width"+Width);
				//System.out.println("Image Height"+Height);
				Assert.assertEquals(Width, 127);     
				Assert.assertEquals(Height, 110);
	 		Thread.sleep(5000);
	 	}
	 	@Test(priority=4,dependsOnMethods = {"login"})
	 	public void LineInRepeater() throws InterruptedException {
	 		WebElement ShapeLine =	driver.findElement(By.xpath("//div[@id='page1-fpShape121220191042817']"));
	 		ShapeLine.click();
	 		WebElement Linelength = driver.findElement(By.xpath("//input[@name='textWidth11']"));
	 		Linelength.clear();
	 		Linelength.sendKeys("175");
	 		int Width = ShapeLine.getSize().getWidth();
			//System.out.println(Width);
			
			Assert.assertEquals(Width, 175);     
			Thread.sleep(3000);
			
	 		
	 	}
	 	@Test(priority=5,dependsOnMethods = {"login"})
	 	public void SignatureProperties() throws InterruptedException {
	 		
	 	WebElement Sign =driver.findElement(By.xpath("//div[@id='page1-fpSign1212201913154755']"));
	 	Sign.click();
	 	WebElement ApplyBorderCheckbox = driver.findElement(By.xpath("//div[7]//div[1]//input[1]"));
	 	ApplyBorderCheckbox.click();
	 	WebElement BorderWidth = driver.findElement(By.xpath("//input[@name='borderWidth']"));
	 	BorderWidth.clear();
	 	BorderWidth.sendKeys("5");
	 	String borderwidth = 	Sign.getCssValue("border-width");	
	 	Assert.assertEquals(borderwidth, "5px");     

	 	Thread.sleep(5000);
	 	}
	 	@Test(priority=6,dependsOnMethods = {"login"})
	 	public void TextFontVerification() throws InterruptedException {
	 		
	 		
	 		WebElement SaveBtn= driver.findElement(By.xpath("//ul[@class='nav']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
	 		SaveBtn.click();
	 		Thread.sleep(5000);
	 		WebElement ExitRepeterModeBtn = driver.findElement(By.xpath("//div[@class='exit-styling-mode btn next-btn']"));
	 		ExitRepeterModeBtn.click();
	 		Thread.sleep(5000);

	 		WebElement Section2 = driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//li[2]"));
	 		Section2.click();
	 		Thread.sleep(5000);
	 		WebElement TextFontSize = driver.findElement(By.xpath("//div[@id='froalapage1-fpText1212201915294951']//p[@class='fpHeading1'][contains(text(),'Freshproposals')]"));
	 		
	 		String fontsize1 =TextFontSize.getCssValue("font-size");
	 		//System.out.println(str);
	 		Assert.assertEquals(fontsize1, "36px");
	 		TextFontSize.click();
	 		Thread.sleep(2000);
	 		
			
			 
	 	}
	 	@Test(priority =7,dependsOnMethods = {"login"},enabled=false)
	 	public void ImageVerification() throws InterruptedException {
	 		WebElement RepeaterImage = driver.findElement(By.id("page1-fpImage121220191005127"));
	 		int Width3 = RepeaterImage.getSize().getWidth();
			int Height3 = RepeaterImage.getSize().getHeight();  
			//System.out.println("Image Width"+Width);
			//System.out.println("Image Height"+Height);
			Assert.assertEquals(Width3, 127);     
			Assert.assertEquals(Height3, 110);
			Thread.sleep(3000);
	 	}	 
	 	@Test(priority =8,dependsOnMethods = {"login"})
	 	public void RectangleVerification() throws InterruptedException {
	 		 WebElement RepeterShape =driver.findElement(By.id("page1-fpShape1212201915294986"));
		 		int Width = RepeterShape.getSize().getWidth();
					int Height = RepeterShape.getSize().getHeight();  
					//System.out.println("RepetershapeActual change width"+Width);
					//System.out.println("RepetershapeActual change width"+Height);
					Assert.assertEquals(Width, 270);     
					Assert.assertEquals(Height, 186);
					Thread.sleep(5000);
	 	}
	 	@Test(priority =9,dependsOnMethods = {"login"})
	 	public void LineVerification() throws InterruptedException {
	 		WebElement ShapeLine =	driver.findElement(By.xpath("//div[@id='page1-fpShape1212201915294915']"));
	 		
	 		
	 		int Width2 = ShapeLine.getSize().getWidth();
			//System.out.println(Width2);
			
			Assert.assertEquals(Width2, 175);     
			Thread.sleep(3000);
	 	
	 	}
	 	@Test(priority =10,dependsOnMethods = {"login"})
	 	public void SignatureVerification() throws InterruptedException {
	 		WebElement Sign =driver.findElement(By.xpath("//div[@id='page1-fpSign1212201913154755']"));
		 	String borderwidth = 	Sign.getCssValue("border-width");	
		 	Assert.assertEquals(borderwidth, "5px");     

		 	Thread.sleep(5000);

	 	}
	 	
	 	@Test(priority=11)
	 	public void AddNewSectionandVerifyRepeater() throws InterruptedException {
			SoftAssert softAssertion= new SoftAssert();

	 	WebElement AddSectionButton = driver.findElement(By.xpath("//button[@class='btn add-sect-btn template-add-sec']//i[@class='fa fa-plus-circle']"));
	 	AddSectionButton.click();
	 	Thread.sleep(4000);
	 	WebElement AddSection =driver.findElement(By.xpath("//div[@class='create-prop-temp-box']//img"));
	 	AddSection.click();
	 	Thread.sleep(2000);

	 	WebElement SectionName = driver.findElement(By.name("name"));
	 	SectionName.sendKeys("SectionAddedIntoTheRepeter");
	 	Thread.sleep(2000);
	 	WebElement SaveBtn = driver.findElement(By.xpath("//button[@class='btn save-btn']"));
	 	SaveBtn.click();
	 	Thread.sleep(4000);
	 	WebElement ClosedSectionLibraryWindow = driver.findElement(By.xpath("//img[@class='img-fluid close-section-library']"));
	 	ClosedSectionLibraryWindow.click(); 
	 	Thread.sleep(4000);

	 	WebElement ThridSection = driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//li[3]"));
	 	ThridSection.click();
	 	Thread.sleep(4000);

		WebElement TextFontSize = driver.findElement(By.xpath("//p[@class='fpHeading1'][contains(text(),'Freshproposals')]"));
		//div[starts-with(@id,"page1-fpSign")]
 		String fontsize1 =TextFontSize.getCssValue("font-size");
 		//System.out.println(str);
 		softAssertion.assertEquals(fontsize1, "36px");
 		TextFontSize.click();
 		Thread.sleep(2000);
 		List <WebElement> RepeterSign =driver.findElements(By.xpath("//div[starts-with(@id,\"page1-fpSign\")]"));
 		int size = RepeterSign.size();
 		System.out.println("Size of the webelement"+size);
 		for(int i=0;i<size-1;i--) {
 			if(i==0) {
 		
	 	int Width = ((WebElement) RepeterSign.get(i)).getSize().getWidth();
		int Height = ((WebElement) RepeterSign.get(i)).getSize().getHeight();  
		//System.out.println("Width of the signature"+Width);
		//System.out.println("Height of the signature"+Height);
	 	softAssertion.assertEquals(Width,240);
	 	softAssertion.assertEquals(Height, 75);
	 	//div[starts-with(@id,"page1-fpShape1212201910")]
	 	
	 	List <WebElement> RepeterShapeRect =driver.findElements(By.xpath("//div[starts-with(@id,\"page1-fpShape\")]//div[@oncontextmenu]"));
 		int size1 = RepeterShapeRect.size();
 		System.out.println("Size of the webelement"+size1);
 		for(int j=0;j<size1-1;j--) {
 			if(j==0) {
 		
	 	int Width1 = ((WebElement) RepeterShapeRect.get(j)).getSize().getWidth();
		int Height1 = ((WebElement) RepeterShapeRect.get(j)).getSize().getHeight();  
		//System.out.println("Width of the Rectangle"+Width1);
		//System.out.println("Height of the Rectangle"+Height1);
	 	softAssertion.assertEquals(Width1,270);
	 	softAssertion.assertEquals(Height1,186);
 			}
 		}
 		//div[@id='content']//li[3] expath of section3
 		Actions actions = new Actions(driver);
 		WebElement target = driver.findElement(By.xpath("//div[@id='content']//li[3]"));
 		actions.moveToElement(target).perform();
 		Thread.sleep(5000);
 		WebElement dotMenu = driver.findElement(By.xpath("//div[@class='d-inline-block show dropdown']//button[@id='dropdownBasic1']//img"));
 		//dotMenu.click();
 		actions.moveToElement(dotMenu).perform();
 		Thread.sleep(2000);
 		dotMenu.click();
 		Thread.sleep(4000);
 		WebElement DeleteBtn = driver.findElement(By.xpath("//div[@class='dropdown-menu show']//button[@class='dropdown-item'][contains(text(),'Delete')]"));
 		DeleteBtn.click();
 		Thread.sleep(4000); 		
		softAssertion.assertAll();
	 	}
 		}
	 	}
	 	@Test(priority=11,dependsOnMethods = {"login"},enabled=false)
	 	public void GenerateAProposal() throws InterruptedException {
			 WebElement generateProposalBtn = driver.findElement(By.xpath("//button[@class='btn add-sect-btn']"));
			 generateProposalBtn.click();
			 Thread.sleep(3000);
			 
			 driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("seleniumProposals");
			 Thread.sleep(3000);
			 WebElement SubmitBtn = driver.findElement(By.xpath("//button[@class='btn save-btn']"));
			 SubmitBtn.click();
			 Thread.sleep(3000);
			 WebElement ClientBtn = driver.findElement(By.xpath("//button[@class='btn btn-link pl-2']"));
			 ClientBtn.click();
			 WebElement checkbox = driver.findElement(By.xpath("//body//div[@class='col-lg-10 offset-lg-1']//div[@class='col-lg-10 offset-lg-1']//div[1]//div[2]//label[1]//span[1]"));
			 checkbox.click();
			 Thread.sleep(3000);
			 Actions actions = new Actions(driver);
			 actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
			 Thread.sleep(3000);
			 WebElement calender = driver.findElement(By.xpath("//div[@class='wizard-details-primary']//div[1]//div[1]//div[1]//button[1]//img[1]"));
			 JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", calender);
			 Thread.sleep(3000);
			 WebElement date = driver.findElement(By.xpath("//div[contains(text(),'21')]"));
			 	date.click();
			 WebElement nextBtn = driver.findElement(By.xpath("//a[@class='btn save-btn-wizard mt-3']"));
			 nextBtn.click();
			 Thread.sleep(5000);
	 		
	 	}
	 	@Test(priority=12,dependsOnMethods = {"login"})
	 	public void RectangleReResize() throws InterruptedException {
	 		//driver.get("http://beta1.freshproposals.com/home/templates/editTemplate/1242");
	 		Thread.sleep(3000);
	 		WebElement RHSMenuArrow = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/app-template-properties[1]/form[1]/div[1]/div[2]"));
	         RHSMenuArrow.click();
	 		Thread.sleep(2000);
	 		WebElement RepeterMenu = driver.findElement(By.xpath("//p[contains(text(),'Repeater')]"));
	 		RepeterMenu.click();
	 		 WebElement RepeterShape =driver.findElement(By.id("page1-fpShape121220191011694"));
		 		RepeterShape.click();
				Thread.sleep(5000);
				Actions builder = new Actions(driver);
			    builder.moveToElement(RepeterShape).build().perform();
		 		WebElement  shapeResize = driver.findElement(By.xpath("//div[@id='page1-fpShape121220191011694']//div[@id='segrip']"));
				resize( shapeResize, -150, -75);
				int Width = RepeterShape.getSize().getWidth();
				int Height = RepeterShape.getSize().getHeight();  
				//System.out.println("Shape Width"+Width);
				//System.out.println("Shape Width"+Height);
				Assert.assertEquals(Width, 120);     
				Assert.assertEquals(Height, 111);
				Thread.sleep(5000);	
	 	}
	 	@Test(priority=13,dependsOnMethods = {"login"})
	 	public void TextPropertiesReReset() throws InterruptedException {
	 		WebElement TextFontSize = driver.findElement(By.xpath("//div[@id='froalapage1-fpText121220199585999']//p[@class='fpHeading1'][contains(text(),'Freshproposals')]"));
	 		String fontsize1 =TextFontSize.getCssValue("font-size");
	 		//System.out.println(str);
	 		Assert.assertEquals(fontsize1, "36px");
	 		TextFontSize.click();
	 		Thread.sleep(2000);
	 		WebElement P4 = driver.findElement(By.xpath("//button[starts-with(@id,'paragraphStyle')]"));
	 		P4.click();
	 		Thread.sleep(2000);
	 		WebElement heading1 = driver.findElement(By.xpath("//a[@class='fr-command fpHeading2']"));
	 		heading1.click();
	 		 Thread.sleep(2000);
	 		WebElement TextFontSize2 = driver.findElement(By.xpath("//div[@id='froalapage1-fpText121220199585999']//p[@class='fpHeading2'][contains(text(),'Freshproposals')]"));
	 		 String fontsize2 =TextFontSize2.getCssValue("font-size");
	 		 Assert.assertEquals(fontsize2, "28px"); 
	 	}
	 	@Test(priority =14,dependsOnMethods = {"login"},enabled=false)

	 	public void ImageReResize() throws InterruptedException {
	 		
	 		WebElement RepeaterImage = driver.findElement(By.id("page1-fpImage121220191005127"));
	 		RepeaterImage.click();
	 		WebElement  ImageResize = driver.findElement(By.xpath("//div[@id='page1-fpImage121220191005127']//div[@id='nwgrip']"));
	 		resize( ImageResize, -150, -75);
				int Width1 = RepeaterImage.getSize().getWidth();
				int Height1 = RepeaterImage.getSize().getHeight();  
				//System.out.println("ImageAfterREResize "+Width1);
				//System.out.println("ImageAfterREREsize"+Height1);
				Assert.assertEquals(Width1, 279);     
				Assert.assertEquals(Height1, 187);
	 		Thread.sleep(5000);
	 	}
	 	@Test(priority =15,dependsOnMethods = {"login"})
	 	public void LineReresize() throws InterruptedException {
	 		WebElement ShapeLine =	driver.findElement(By.xpath("//div[@id='page1-fpShape121220191042817']"));
	 		ShapeLine.click();
	 		WebElement Linelength = driver.findElement(By.xpath("//input[@name='textWidth11']"));
	 		Linelength.clear();
	 		Linelength.sendKeys("200");
	 		int Widthline = ShapeLine.getSize().getWidth();
			//System.out.println(Widthline);
			
			Assert.assertEquals(Widthline, 200);     
			Thread.sleep(5000);

	 	}
	 	@Test(priority =16,dependsOnMethods = {"login"})
	 	public void SignatureReReset() throws InterruptedException {
	 		WebElement Sign =driver.findElement(By.xpath("//div[@id='page1-fpSign1212201913154755']"));
		 	Sign.click();
		 	Thread.sleep(2000);
		 	WebElement ApplyBorderCheckbox = driver.findElement(By.xpath("//div[@class='card text-box-prop']/div[@class='card-body properties-box']/div[@class='row']/div[7]/div[1]/input[1]"));
		 	ApplyBorderCheckbox.click();
		 	Thread.sleep(3000);
		 	ApplyBorderCheckbox.click();
	 	}
	 	@Test(priority =17,dependsOnMethods = {"login"})

	 	public void SaveChangesAfterReReset() throws InterruptedException {
	 		WebElement SaveBtn= driver.findElement(By.xpath("//ul[@class='nav']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
	 		SaveBtn.click();
	 		Thread.sleep(3000);
	 		WebElement ExitRepeterModeBtn = driver.findElement(By.xpath("//div[@class='exit-styling-mode btn next-btn']"));
	 		ExitRepeterModeBtn.click();
	 		Thread.sleep(3000);
		 	
	 	}
	 	public void resize(WebElement shapeResize, int xOffset, int yOffset) {
			try {
				if (shapeResize.isDisplayed()) {
					Actions action = new Actions(driver);
					action.clickAndHold(shapeResize).moveByOffset(xOffset, yOffset).release().build().perform();
				} else {
					System.out.println("Element was not displayed to drag");
				}
			} catch (StaleElementReferenceException e) {
				System.out.println("Element with " + shapeResize + "is not attached to the page document "	+ e.getStackTrace());
			} catch (NoSuchElementException e) {
				System.out.println("Element " + shapeResize + " was not found in DOM " + e.getStackTrace());
			} catch (Exception e) {
				System.out.println("Unable to resize" + shapeResize+ " - "	+ e.getStackTrace());
			}
		}
	 	@AfterClass
	 	public void teardown() {
	 		driver.quit();
	 	}
}
