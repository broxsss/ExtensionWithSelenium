package whatfix.wikipedia.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikipediaPage {

	WebDriver driver;
	
	public By seelivebtn=By.id("wfx-dashboard-see-live");
	public By tooltip_uText=By.id("wfx-tooltip-title");
	public By tooltipcolor=By.xpath("//table[@class='WFPLFU']");
	public By tooltip_lText =By.xpath("//div[@class='WFPLDU']/table/tbody/tr[2]/td/div");
	public By clkEnglish =By.xpath("//a[@id='js-link-box-en']/strong");
	public By strsearchbox=By.xpath("//div[@id='simpleSearch']/input");
	public By clknxtbtn= By.xpath("//a[@class='WFPLOT']");
	public By iframecloseprmpt = By.xpath("//iframe[@class='WFPLKS WFPLAT']");
	
	public By strcloseprmpt = By.xpath("//div[@class='WFENIS']/div");
	public By closebtn = By.xpath("//button[@class='WFENHM WFENNS']");
	
	WebElement switchtoiframe;
	
	public WikipediaPage(WebDriver driver)
	{
	this.driver=driver;
	}
	 
	public void clkseelivebtn()
	{
		driver.findElement(seelivebtn).click();
	}

	
	
	public String gettooltipUTEXT()
	{
		return driver.findElement(tooltip_uText).getText();
	}
	

	
	public String gettooltipLTEXT()
	{
		return driver.findElement(tooltip_lText).getText();
		}
	
	public void clkEnglishbtn()
	{
		driver.findElement(clkEnglish).click();
		}

	
	public void givesearchinput(String Input)
	{
		driver.findElement(strsearchbox).sendKeys(Input);
		}
	
	public String getBGcolor()
	{
		return driver.findElement(tooltipcolor).getCssValue("background-color");
		}
	
	public String getstyleatt_value()
	{
		return driver.findElement(tooltipcolor).getAttribute("style");
		}
	
	
	public void clknxtbtn()
	{
		driver.findElement(clknxtbtn).click();
		}
	
	public void clkclosebtn()
	{
		driver.findElement(closebtn).click();
		}
	
	
	
	public WebElement getiframe_closeprmpt()
	{
		switchtoiframe = driver.findElement(iframecloseprmpt);
		return switchtoiframe;
		}
	

	
	public String strCloseprmpt()
	{
		return driver.findElement(strcloseprmpt).getText();
		}
	
	public void clkclosebtnprmpt()
	{
		driver.findElement(closebtn).click();
		}
	
}