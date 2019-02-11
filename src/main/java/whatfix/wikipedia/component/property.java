package whatfix.wikipedia.component;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;

public class property {

	Properties  prop ;
	public void loaddata() throws IOException
	{
		prop = new Properties();
		File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\whatfix\\wikipedia\\resources\\resources.properties");
		FileReader fr = new FileReader(file);
		prop.load(fr);			
	}
	
	public String getData(String Data) throws IOException
	{
		loaddata();
		String data = prop.getProperty(Data);
		return data;
		
	}
	
	 public String getscreenshot(WebDriver driver,String Testcasename) 
     {
             File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
          
             try {
            	   
            	 FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\screenshots\\"+Testcasename+"_"+System.currentTimeMillis()+".png"));
            	       }
            	 
            	catch (IOException e)
            	 
            	{
            	 
            	System.out.println(e.getMessage());
            	 
            	    }
             
         return  System.getProperty("user.dir")+"\\screenshots\\"+Testcasename+"_"+System.currentTimeMillis()+".png";   
     }

	
	
}
