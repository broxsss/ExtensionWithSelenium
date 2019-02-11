package whatfix.wikipedia;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import whatfix.wikipedia.Pages.WikipediaPage;
import whatfix.wikipedia.component.property;
import whatfix.wikipedia.component.start_Exit_browser;



public class ChromeBrowser_TC001 {
	WebDriver driver;
	static property prop = new property();
	start_Exit_browser se = new start_Exit_browser();
	ExtentReports report;
	ExtentTest logger; 
	String Testcasename = "ChromeBrowser_TC001";

	@Test
	public void AutomateSeelive() throws InterruptedException, IOException
	{
		//instantiation for extent report
		report=new ExtentReports(System.getProperty("user.dir")+"\\Reports\\"+Testcasename+".html");
		logger=report.startTest("check Whatfix project started in chrome");
		

		//starting the browser with url
		driver = se.chromebrowser(driver);
		WikipediaPage shp = new WikipediaPage(driver);
		driver.get(prop.getData("URL"));
		logger.log(LogStatus.PASS, "Able to open Chrome Browser");
		se.isElementPresent(driver,shp.seelivebtn ,5);
		
		
		//Implicit wait for page loading
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 se.VisibleExplicit(driver,shp.seelivebtn);
		 shp.clkseelivebtn();
		 logger.log(LogStatus.PASS, "Clicked on see live button");

		//Clicked self help button
		  Set handles = driver.getWindowHandles();
		  for (String handle1 : driver.getWindowHandles()) {

		      System.out.println(handle1);

		      driver.switchTo().window(handle1);

		}
		  logger.log(LogStatus.PASS, "Switched to second window");
		  se.VisibleExplicit(driver,shp.tooltip_uText);
		  String tooltip1p1 = shp.gettooltipUTEXT();
		  System.out.println(tooltip1p1);
		  Assert.assertEquals(tooltip1p1, prop.getData("tooltip1upper"));
		  
		  
		  String color1 =shp.getBGcolor();
		  String att1 =shp.getstyleatt_value();
		  System.out.println("Background color :"+color1);
		  System.out.println("Style Attribute :"+att1);
		  
		  
		  String tooltip1p2 = shp.gettooltipLTEXT();
		  System.out.println(tooltip1p2);
		  Assert.assertEquals(tooltip1p2, prop.getData("tooltip1lower"));
		  logger.log(LogStatus.PASS, "Checked the tooltip1");
		  
		  shp.clkEnglishbtn();
		  logger.log(LogStatus.PASS, "clicked on english button");
		  
		  se.VisibleExplicit(driver,shp.tooltip_uText);
		  String tooltip2p1 = shp.gettooltipUTEXT();
		  System.out.println(tooltip2p1);
		  Assert.assertEquals(tooltip2p1, prop.getData("tooltip2upper"));
		  
		  String color2 =shp.getBGcolor();
		  String att2 =shp.getstyleatt_value();
		  System.out.println("Background color :"+color2);
		  System.out.println("Style Attribute :"+att2);
		  
		  
		  String tooltip2p2 =  shp.gettooltipLTEXT();
		  System.out.println(tooltip2p2);
		  Assert.assertEquals(tooltip2p2, prop.getData("tooltip2lower"));
		  logger.log(LogStatus.PASS, "Checked the tooltip2");
		  
		  //se.isElementPresent(driver,shp.strsearchbox ,6);
		  shp.givesearchinput("test");
		  logger.log(LogStatus.PASS, "given input into search box");
		  se.inVisibleExplicit(driver,shp.tooltip_uText);
          
		  se.isElementPresent(driver,shp.strsearchbox ,6);
		  Actions action = new Actions(driver);
		  action.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
		  logger.log(LogStatus.PASS, "Selected test moved to next page");
		  
		  se.VisibleExplicit(driver,shp.tooltip_uText);
		  String tooltip3p1 = shp.gettooltipUTEXT();
		  System.out.println(tooltip3p1);
		  Assert.assertEquals(tooltip3p1, prop.getData("tooltip3upper"));
		  
		  String color3 =shp.getBGcolor();
		  String att3 =shp.getstyleatt_value();
		  System.out.println("Background color :"+color3);
		  System.out.println("Style Attribute :"+att3);
		  
		  
		  String tooltip3p2 = shp.gettooltipLTEXT();
		  System.out.println(tooltip3p2);
		  Assert.assertEquals(tooltip3p2, prop.getData("tooltip3lower"));
		  logger.log(LogStatus.PASS, "Checked the tooltip3");
		  
		  se.VisibleExplicit(driver,shp.clknxtbtn);
		  logger.log(LogStatus.PASS, "clicked on the next button");
		  shp.clknxtbtn();
		  
		  
		 
		  se.isElementPresent(driver,shp.iframecloseprmpt ,6);
		  driver.switchTo().frame(shp.getiframe_closeprmpt());
		  logger.log(LogStatus.PASS, "Switched to close iframe prompt");
		  //System.out.println("reached here");
		  System.out.println(shp.strCloseprmpt());
          Assert.assertEquals(shp.strCloseprmpt(), prop.getData("closeprmpt"));
          se.isElementPresent(driver,shp.closebtn ,4);
          shp.clkclosebtn();
		  logger.log(LogStatus.PASS, "clicked the close button");
		  driver.quit();
		  logger.log(LogStatus.PASS, "Successully closed browser:");
	}

	@AfterMethod
	public void teardown(ITestResult result)
	{

		try{
			
			if(result.getStatus()==ITestResult.FAILURE)
			{
				String screenshot_path =prop.getscreenshot(driver,result.getName());
				String image = logger.addScreenCapture(screenshot_path);
				logger.log(LogStatus.FAIL, "Test case got failed check screenshot "+result.getName(), image);
				System.out.println("Test case got failed check screenshot..."+result.getName());
			} 
			report.endTest(logger);
			report.flush();
			driver.quit();
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
