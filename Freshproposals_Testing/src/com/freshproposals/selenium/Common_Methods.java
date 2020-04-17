package com.freshproposals.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Common_Methods {
	
	String fname = "SEL";
	String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	
	//analytics var
	String time;
	String view;
	String average;
	String lastview;
	
	//signature var
	String signature_width = "300";
	String signature_height = "70";
	String signature_border_width = "10";
	String signature_border_style = "inset";
	String signature_corner = "30";
	String signature_rotate = "5";
	String signature_padding_top = "10";
	String signature_padding_left = "10";
	String signature_padding_bottom = "70";
	String signature_padding_right = "10";
	
	
	
	@DataProvider
	  public Object[][] User1(){
		
		Object[][] credentials = {
				  { "shahnawaz@zenincloud.com",
				    "Shahnawaz@123"},
		  };
		
		return credentials;
	  }
	  
	  @DataProvider
	  public Object[][] User2(){
		
		
		Object[][] credentials = {
				  {"nikeeta3011@gmail.com",
				    "Nikeeta@123"},
		  };
		
		return credentials;
	  }
	  
public void login(String unm, String pwd, WebDriver driver) {
    driver.findElement(By.id("email")).sendKeys(unm);
	driver.findElement(By.id("passwordTXT")).sendKeys(pwd);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
}

	  
public void openURL(WebDriver driver) {
	driver.get("http://beta1.freshproposals.com");
}


public void quitBrowser(WebDriver driver) throws InterruptedException {
	Thread.sleep(3000);
	driver.quit();
}

public void createProposal(WebDriver driver) throws InterruptedException {
	Thread.sleep(10000);
	driver.findElement(By.id("linkProposals")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//img[@src='../../assets/add-section-icon.png']")).click();
}
	  
	  
public void generateProposalButton(WebDriver driver) {
	//driver.findElement(By.xpath("//button[contains(text(), 'Generate Proposal' )]")).click();
	  driver.findElement(By.id("onboardingGenProposal")).click();
}
	  
	 
public void proposalName(WebDriver driver) throws InterruptedException {
	Thread.sleep(3000);
	driver.findElement(By.name("name")).sendKeys(fname+" Proposal "+timestamp);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
}
	  
	  
public void client(WebDriver driver) throws InterruptedException  {
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@class='col-lg-10 offset-lg-1']//div[1]//div[2]//label[1]//span[1]")).click();
	Thread.sleep(2000);
}
	 
	  
public void scrollWindow(WebDriver driver) throws InterruptedException  {
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1000)");
}


public void calender(WebDriver driver) throws InterruptedException  {
	Thread.sleep(3000);
	driver.findElement(By.xpath("//img[@src='../../../assets/calendar.svg']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@class='ngb-dp-arrow right']//button[@class='btn btn-link ngb-dp-arrow-btn']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[contains(text(),'15')]")).click();
	Thread.sleep(2000);
	//next btn
	driver.findElement(By.xpath("//button[@class='btn send-btn mt-3']")).click();
}


public void sendNextButton(WebDriver driver) throws InterruptedException {
	Thread.sleep(5000);
	driver.findElement(By.id("btnSendMail")).click();
}


public void createTemplate(WebDriver driver) throws InterruptedException {
	Thread.sleep(5000);
	driver.findElement(By.xpath("//img[@src='../../assets/add-section-icon.png']")).click();
	driver.findElement(By.name("name")).sendKeys(fname+" Template "+timestamp);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
}

//template
public void contentLibrary(WebDriver driver) throws InterruptedException {
	Thread.sleep(3000);
	//plus btn
	//driver.findElement(By.xpath("//button[@class='btn add-sect-btn template-add-sec ng-star-inserted']")).click();
	driver.findElement(By.id("onboardingAddSection")).click();
	Thread.sleep(5000);
	//search
	driver.findElement(By.xpath("//input[@placeholder='search section']")).sendKeys("Design");
	Thread.sleep(3000);
	//use this
	driver.findElement(By.xpath("//img[@class='img=fluid']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//img[@class='img-fluid close-section-library']")).click();
} 

public void PcontentLibrary(WebDriver driver) throws InterruptedException {
	Thread.sleep(3000);
	//plus btn
	driver.findElement(By.xpath("//button[@class='btn add-sect-btn proposal-add-sec']")).click();
	Thread.sleep(5000);
	//search
	driver.findElement(By.xpath("//input[@placeholder='search section']")).sendKeys("Design");
	Thread.sleep(3000);
	//use this
	driver.findElement(By.xpath("//img[@class='img=fluid']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//img[@class='img-fluid close-section-library']")).click();
} 

public void sendEmail(WebDriver driver) throws InterruptedException {
	Thread.sleep(5000);
    driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("Selenium Subject");
	  driver.findElement(By.xpath("//div[@class='fr-box fr-basic fr-top']//div[@class='fr-element fr-view']"))
	  .sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
				+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,"
				+ " when an unknown printer took a galley of type and scrambled it to make a type specimen book."
				+ "Lorem Ipsum is simply dummy text of the printing and typesetting industry."
				+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s");
	  Thread.sleep(2000);
	  //send btn
	  driver.findElement(By.linkText("Send")).click();
	  Thread.sleep(5000);
}


public void analyticsCopyLink(WebDriver driver) throws InterruptedException {
	//link
	Thread.sleep(7000);
    driver.findElement(By.xpath("//img[@src='../../../assets/link-icon-blue.svg']")).click();
    Thread.sleep(3000);
    //get coy text
    String copy_text = driver.findElement(By.xpath("//div[@class='card-body ng-star-inserted']//input")).getAttribute("value");
    System.out.println(copy_text);
    Thread.sleep(2000);
    //new window
    ((JavascriptExecutor)driver).executeScript("window.open()");
    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));
    driver.get(copy_text);
    //section
    Thread.sleep(60000);
	driver.findElement(By.xpath("//a[contains(text(),'Second Page')]")).click();
    Thread.sleep(60000);
    driver.findElement(By.xpath("//a[contains(text(),'Third Page')]")).click();
    Thread.sleep(70000);
    driver.close();
	driver.switchTo().window(tabs.get(0));
}


public void getSummaryData(WebDriver driver) throws InterruptedException {
	Thread.sleep(5000);
	time =  driver.findElement(By.className("proposal-analytics-timespent-value")).getText();
	System.out.println("A TOTAL TIME SPENT VIEWING " +  time);
	//times viewed
	view = driver.findElement(By.cssSelector("div.wrapper div.main:nth-child(5) div.apply-hidden.styling-mode-effect div.proposal-summary div.container:nth-child(3) div.tabs-underlined.proposal-summary-tab div.tab-content div.tab-pane.active div.proposal-analytics div.row.proposal-analytics-box:nth-child(2) div.proposal-analytics-box-timespent div.proposal-analytics-timespent div:nth-child(2) > div.proposal-analytics-timespent-value")).getText();
	System.out.println("A TIMES VIEWED " + view);
	//average time
	average = driver.findElement(By.xpath("//*[@id=\"ngb-tab-2-panel\"]/app-proposal-analytics/div/div[2]/div[2]/div/div[3]/div[2]")).getText();
	System.out.println("A AVERAGE TIME VIEWING " + average);				
	//time since last view
	lastview = driver.findElement(By.xpath("//*[@id=\"ngb-tab-2-panel\"]/app-proposal-analytics/div/div[2]/div[2]/div/div[4]/div[2]")).getText();
	System.out.println("A TIME SINCE LAST VIEWED " + lastview);

}

public void save(WebDriver driver) throws InterruptedException {
	driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	Thread.sleep(3000);
}

public void back(WebDriver driver) throws InterruptedException {
	driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
    Thread.sleep(3000);
}

//Signature Properties

public void signatureWidth(WebDriver driver) throws InterruptedException {
	Thread.sleep(1000);
	driver.findElement(By.name("textWidth11")).clear();
    driver.findElement(By.name("textWidth11")).sendKeys(signature_width);
    String actual_width = driver.findElement(By.name("textWidth11")).getAttribute("value");
    Assert.assertEquals(actual_width, signature_width);
}

public void signatureHeight(WebDriver driver) throws InterruptedException {
    Thread.sleep(1000);
    driver.findElement(By.name("height11")).clear();
    driver.findElement(By.name("height11")).sendKeys(signature_height);
    String actual_height = driver.findElement(By.name("height11")).getAttribute("value");
    Assert.assertEquals(actual_height, signature_height);
}

public void signatureReflectWidth(WebDriver driver) {
	 driver.findElement(By.id("page1-fpSign115201911423648")).click();
	  String actual_reflect_width = driver.findElement(By.id("page1-fpSign115201911423648")).getCssValue("width");
	  String expected_reflect_width = signature_width+"px";
	  System.out.println("Awidth "+actual_reflect_width);
	  System.out.println("Ereflect width "+expected_reflect_width);
	  Assert.assertEquals(actual_reflect_width, expected_reflect_width);
}

public void signatureReflectHeight(WebDriver driver) throws InterruptedException {
driver.findElement(By.id("page1-fpSign115201911423648")).click();
  String actual_reflect_height = driver.findElement(By.id("page1-fpSign115201911423648")).getCssValue("height");
  System.out.println("Aheight "+actual_reflect_height);
  String expected_reflect_height = signature_height+"px";
  System.out.println("Ereflect height "+expected_reflect_height);
	  Assert.assertEquals(actual_reflect_height, expected_reflect_height);
}

public void signatureResetHeightWidth(WebDriver driver) throws InterruptedException {
	Thread.sleep(1000);
	  driver.findElement(By.id("page1-fpSign115201911423648")).click();
  driver.findElement(By.name("textWidth11")).clear();
  driver.findElement(By.name("textWidth11")).sendKeys("250");
  
  Thread.sleep(1000);
  driver.findElement(By.name("height11")).clear();
  driver.findElement(By.name("height11")).sendKeys("75");
}

public void signatureCorner(WebDriver driver) throws InterruptedException {
	//corner
	  Thread.sleep(1000);
	  driver.findElement(By.name("corners")).clear();
	  driver.findElement(By.name("corners")).sendKeys(signature_corner);
	  String actual_corner = driver.findElement(By.name("corners")).getAttribute("value");
	  Assert.assertEquals(actual_corner, signature_corner);
}

public void signatureRotate(WebDriver driver) throws InterruptedException {
	 Thread.sleep(1000);
	  driver.findElement(By.name("rotate")).clear();
	  driver.findElement(By.name("rotate")).sendKeys(signature_rotate);
	  String actual_rotate = driver.findElement(By.name("rotate")).getAttribute("value");
	  System.out.println(actual_rotate);
	  Assert.assertEquals(actual_rotate, signature_rotate); 
}

public void signatureColor(WebDriver driver) throws InterruptedException {
	 //color   
	  Thread.sleep(1000);
	  //driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/app-signature-properties[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/button[2]\n")).click();
	  driver.findElement(By.xpath("//span[@class='e-btn-icon e-icons e-caret']")).click();
	  Thread.sleep(1000);
	  //WebElement r1 = driver.findElement(By.xpath("//div[@class='e-handle e-handle-first']"));
	  //resize(r1, 75,75);
	  driver.findElement(By.xpath("//input[@class='e-hex']")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@class='e-hex']")).sendKeys("#000000");
	  Thread.sleep(2000);
	  //driver.findElement(By.className("e-hsv-color")).click();
	  driver.findElement(By.xpath("//span[@class='e-handler']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[@class='e-btn e-css e-flat e-primary e-small e-apply']")).click();
	  Thread.sleep(1000);
	  //System.out.println(driver.findElement(By.className("e-hsv-color")).getText());
}

public void signatureBorderWidth(WebDriver driver) throws InterruptedException {
	Thread.sleep(2000);
	  //border width
	  driver.findElement(By.name("border")).click();
	  Thread.sleep(1000);

	  driver.findElement(By.name("borderWidth")).clear();
	  driver.findElement(By.name("borderWidth")).sendKeys(signature_border_width);
	  String actual_border_width = driver.findElement(By.name("borderWidth")).getAttribute("value");
	  Assert.assertEquals(actual_border_width, signature_border_width);
	  Thread.sleep(1000);
}

public void signatureBorderStyle(WebDriver driver) throws InterruptedException {
	//border style
	  Select select = new Select(driver.findElement(By.name("borderStyle")));
	  select.selectByIndex(6);
	  String actual_border_style = select.getFirstSelectedOption().getText();
	  System.out.println(actual_border_style);
	  Assert.assertEquals(actual_border_style, signature_border_style);
	  Thread.sleep(1000);
}

public void signaturePaddingTtop(WebDriver driver) throws InterruptedException, AWTException {
	  //padding
	  driver.findElement(By.name("padding")).click();
	  Thread.sleep(1000);
	  Robot robot = new Robot();
	  robot.keyPress(KeyEvent.VK_PAGE_DOWN);

	  driver.findElement(By.name("paddingTop")).clear();
	  driver.findElement(By.name("paddingTop")).sendKeys(signature_padding_top);
	  String actual_padding_top = driver.findElement(By.name("paddingTop")).getAttribute("value");
	  Assert.assertEquals(actual_padding_top, signature_padding_top);
}

public void signaturePaddingLleft(WebDriver driver) throws InterruptedException {
	  Thread.sleep(1000);
	  driver.findElement(By.name("paddingLeft")).clear();
	  driver.findElement(By.name("paddingLeft")).sendKeys(signature_padding_left);
	  String actual_padding_left = driver.findElement(By.name("paddingLeft")).getAttribute("value");
	  Assert.assertEquals(actual_padding_left, signature_padding_left);
}

public void signaturePadingBottom(WebDriver driver) throws InterruptedException {
	  Thread.sleep(1000);
	  driver.findElement(By.name("paddingBottom")).clear();
	  driver.findElement(By.name("paddingBottom")).sendKeys(signature_padding_bottom);
	  String actual_padding_bottom = driver.findElement(By.name("paddingBottom")).getAttribute("value");
	  Assert.assertEquals(actual_padding_bottom, signature_padding_bottom);
}

public void signaturePaddingRight(WebDriver driver) throws InterruptedException {
	  Thread.sleep(1000);
	  driver.findElement(By.name("paddingRight")).clear();
	  driver.findElement(By.name("paddingRight")).sendKeys(signature_padding_right);
	  String actual_padding_right = driver.findElement(By.name("paddingRight")).getAttribute("value");
	  Assert.assertEquals(actual_padding_right, signature_padding_right);
}

public void signatureSignee(WebDriver driver) throws InterruptedException {
	  //signee
	  Select select1 = new Select(driver.findElement(By.name("signee")));
	  select1.selectByValue("0: Object");
	  String actual_signee = select1.getFirstSelectedOption().getText();
	  String expeted_signee = "Rahul Sharma";
	  Assert.assertEquals(actual_signee, expeted_signee);
	  //check
	  Thread.sleep(1000);
}

public void signatureResize(WebDriver driver, WebElement elementToResize, int xOffset, int yOffset) {
		try {
			if (elementToResize.isDisplayed()) {
				Actions action = new Actions(driver);
				action.clickAndHold(elementToResize).moveByOffset(xOffset, yOffset).release().build().perform();
			} else {
				System.out.println("Element was not displayed to drag");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element with " + elementToResize + "is not attached to the page document "	+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + elementToResize + " was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to resize" + elementToResize + " - "	+ e.getStackTrace());
		}
		
	}

public void signatureReflectCorner(WebDriver driver) {
	  driver.findElement(By.id("page1-fpSign115201911423648")).click();
	  String actual_reflect_corner = driver.findElement(By.id("page1-fpSign115201911423648")).getCssValue("border-radius");
	  String expected_reflect_corner = signature_corner+"px";
	  System.out.println("Acorner "+actual_reflect_corner);
	  System.out.println("Ereflect corner "+expected_reflect_corner);
	  Assert.assertEquals(actual_reflect_corner, expected_reflect_corner);
	  
}

//@Test(priority = 20)
//public void reflect_roate() {
//	  driver.findElement(By.id("page1-fpSign115201911423648")).click();
//	  String actual_reflect_rotate = driver.findElement(By.id("page1-fpSign115201911423648")).getCssValue("transform");
//	  String expected_reflect_rotate = rotate+"px";
//	  System.out.println("Arotate "+actual_reflect_rotate);
//	  System.out.println("Ereflect rotate "+expected_reflect_rotate);
//	  Assert.assertEquals(actual_reflect_rotate, expected_reflect_rotate);
//	  
//}

public void signatureReflectBorderWidth(WebDriver driver) throws InterruptedException {
	  driver.findElement(By.id("page1-fpSign115201911423648")).click();
	  String actual_reflect_border_width = driver.findElement(By.id("page1-fpSign115201911423648")).getCssValue("border-width");
	  System.out.println("A = "+actual_reflect_border_width);
	  String expected_reflect_border_width = signature_border_width+"px";
	  System.out.println("E "+expected_reflect_border_width);
	  Assert.assertEquals(actual_reflect_border_width, expected_reflect_border_width);
	  Thread.sleep(5000);
	  
}

public void signatureReflectBorderStyle(WebDriver driver) throws InterruptedException {
	  driver.findElement(By.id("page1-fpSign115201911423648")).click();
	  String actual_reflect_border_style = driver.findElement(By.id("page1-fpSign115201911423648")).getCssValue("border-style");
	  System.out.println("A = "+actual_reflect_border_style);
	  String expected_reflect_border_style = signature_border_style;
	  System.out.println("E "+expected_reflect_border_style);
	  Assert.assertEquals(actual_reflect_border_style, expected_reflect_border_style);
	  Thread.sleep(5000);
	  
}

public void signatureReflectPadding(WebDriver driver) throws InterruptedException {
	  driver.findElement(By.id("page1-fpSign115201911423648")).click();
	  String actual_reflect_padding_top = driver.findElement(By.id("page1-fpSign115201911423648")).getCssValue("padding-top");
	  String actual_reflect_padding_left = driver.findElement(By.id("page1-fpSign115201911423648")).getCssValue("padding-left");
	  String actual_reflect_padding_bottom = driver.findElement(By.id("page1-fpSign115201911423648")).getCssValue("padding-bottom");
	  String actual_reflect_padding_right = driver.findElement(By.id("page1-fpSign115201911423648")).getCssValue("padding-right");
	  System.out.println("reflect_top = "+actual_reflect_padding_top);
	  System.out.println("reflect_left = "+actual_reflect_padding_left);
	  System.out.println("reflect_bottom = "+actual_reflect_padding_bottom);
	  System.out.println("reflect_right = "+actual_reflect_padding_right);
	  String expected_reflect_padding_top = signature_padding_top+"px";
	  String expected_reflect_padding_left = signature_padding_left+"px";
	  String expected_reflect_padding_bottom = signature_padding_bottom+"px";
	  String expected_reflect_padding_right = signature_padding_right+"px";
	  
	  Assert.assertEquals(actual_reflect_padding_top, expected_reflect_padding_top);
	  Assert.assertEquals(actual_reflect_padding_left, expected_reflect_padding_left);
	  Assert.assertEquals(actual_reflect_padding_bottom, expected_reflect_padding_bottom);
	  Assert.assertEquals(actual_reflect_padding_right, expected_reflect_padding_right);
	  Thread.sleep(5000);
	  
}

public void signatureResetAll(WebDriver driver) throws InterruptedException, AWTException {
       Thread.sleep(1000);
	   driver.findElement(By.id("page1-fpSign115201911423648")).click();
	   
	  Thread.sleep(1000);
	  driver.findElement(By.name("corners")).clear();
	  driver.findElement(By.name("corners")).sendKeys("0");
	  
	  Thread.sleep(1000);
	  driver.findElement(By.name("rotate")).clear();
	  driver.findElement(By.name("rotate")).sendKeys("0");
	  
	  //color
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//span[@class='e-btn-icon e-icons e-caret']")).click();
	  Thread.sleep(1000);
	  //WebElement r1 = driver.findElement(By.xpath("//div[@class='e-handle e-handle-first']"));
	  //resize(r1, 75,75);
	  driver.findElement(By.xpath("//input[@class='e-hex']")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@class='e-hex']")).sendKeys("#ffffff");
	  Thread.sleep(2000);
	  //driver.findElement(By.className("e-hsv-color")).click();
	  driver.findElement(By.xpath("//span[@class='e-handler']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[@class='e-btn e-css e-flat e-primary e-small e-apply']")).click();
	  Thread.sleep(1000);

	  Thread.sleep(1000);
	  driver.findElement(By.name("borderWidth")).clear();
	  driver.findElement(By.name("borderWidth")).sendKeys("0");
	  
	  Thread.sleep(1000);
	  Select select = new Select(driver.findElement(By.name("borderStyle")));
	  select.selectByIndex(2);
	  Thread.sleep(3000);
	  driver.findElement(By.name("border")).click();

      Robot robot = new Robot();
	  robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	  
	  Thread.sleep(1000);
	  driver.findElement(By.name("paddingTop")).clear();
	  driver.findElement(By.name("paddingTop")).sendKeys("0");
	  Thread.sleep(1000);
	  driver.findElement(By.name("paddingLeft")).clear();
	  driver.findElement(By.name("paddingLeft")).sendKeys("0");
	  Thread.sleep(1000);
	  driver.findElement(By.name("paddingBottom")).clear();
	  driver.findElement(By.name("paddingBottom")).sendKeys("0");
	  Thread.sleep(1000);
	  driver.findElement(By.name("paddingRight")).clear();
	  driver.findElement(By.name("paddingRight")).sendKeys("0");
	  
	  driver.findElement(By.name("padding")).click();
	  
	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/app-signature-properties[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/button[2]\n")).click();
//	  Thread.sleep(1000);
//	  WebElement r1 = driver.findElement(By.xpath("//div[@class='e-hue-slider e-control e-slider e-lib']//div[@class='e-slider-track']"));
//	  resize(r1, 75,75);
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//span[@class='e-handler']")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[@title='Apply']")).click();
//	  Thread.sleep(1000);
	  
	 
	  
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	  
}








	  
	  
	  
	  
}

