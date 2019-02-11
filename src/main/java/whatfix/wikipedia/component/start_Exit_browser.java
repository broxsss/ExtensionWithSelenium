package whatfix.wikipedia.component;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class start_Exit_browser {
   
	static property prop = new property();
	
	public WebDriver chromebrowser(WebDriver driver)
	{
		System.setProperty("webdriver.chrome.driver","/Users/akshaykumarsaini/Desktop/chromedriver");
		 Map<String, Object> prefs = new HashMap<String, Object>();
		 prefs.put("profile.default_content_setting_values.notifications", 2); 
		 ChromeOptions options = new ChromeOptions();
		 options.addExtensions(new File(System.getProperty("user.dir")+"//driver//4.1_0.crx"));
		 options.addArguments("--disable-infobars");
		 options.setExperimentalOption("prefs",prefs);
		 DesiredCapabilities capabilities = new DesiredCapabilities();
		 capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		 driver = new ChromeDriver(capabilities);
		 driver.manage().window().maximize();
		
		return driver;
		
	}
	
	public WebDriver firefoxbrowser(WebDriver driver)
	{
		System.setProperty("webdriver.gecko.driver","/Users/akshaykumarsaini/Desktop/geckodriver");
         String firebugFilePath = System.getProperty("user.dir")+"//driver//jid1-RMaoH9zYsFXFcg@jetpack.xpi";
         FirefoxProfile profile = new FirefoxProfile();
         profile.addExtension(new File(firebugFilePath));
         driver = new FirefoxDriver(profile);
         driver.manage().window().maximize();
	return driver;
		
	}
	
	
	public void closebrowser(WebDriver driver)
	{
		driver.quit();
	}
	
	public void VisibleExplicit(WebDriver driver,By selfhelpbtn) throws IOException
	{
		 String explicttime = prop.getData("TimeinSec");
		 long extime = Long.parseLong(explicttime);
		 WebDriverWait wait = new WebDriverWait(driver, extime);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wfx-tooltip-title")));
	}
	
	public void inVisibleExplicit(WebDriver driver,By selfhelpbtn) throws IOException
	{
		 String explicttime = prop.getData("TimeinSec");
		 long extime = Long.parseLong(explicttime);
		 WebDriverWait wait = new WebDriverWait(driver, extime);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wfx-tooltip-title")));
	}
	
	public void isElementPresent(WebDriver driver,By xpath ,int time)
	{
		WebElement ele = null;
		for(int i=0;i<time;i++)
		{
			try{
				Thread.sleep(1000);
				ele = driver.findElement(xpath);
				break;
			}
			catch(Exception e)
			{
				try{
					Thread.sleep(1000);
				}
				catch(InterruptedException e1)
				{
					System.out.println("waiting for element to appear DOM");
				}
			}
		}
		
	}
	
}
