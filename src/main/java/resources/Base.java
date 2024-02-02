package resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	//base class consist the code for browser invoke for diff browser 
	// its work depends on data.properties file 
       public WebDriver driver; 
       public Properties prop;
       public String url;
       public static Logger log =LogManager.getLogger(Base.class.getName());
	public WebDriver intializeDriver () throws IOException {
		// to read the properties of data.pro perties class 
		//create object of filestreaminput and pass the path of properties file 
		FileInputStream fs =new FileInputStream("C:\\Users\\AAkash Satpute\\eclipse-workspace\\Rediffmail2\\src\\main\\java\\resources\\data.properties");
	//  create object of properties class to use load method to load the properties file 
			 prop =new Properties();
			prop.load(fs);
			
    // get the properties from data.property file  use getproperty method 
      String browsername=prop.getProperty("browser");
           url =prop.getProperty("url");
			if (browsername.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "E:\\JAVA TOOLS\\new102\\chromedriver.exe");
                  driver=new ChromeDriver();
			}
			 else if (browsername.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", "E:\\JAVA TOOLS\\geckodriver-v0.31.0-win64\\geckodriver.exe"); 
			    driver=new FirefoxDriver();
			 }
			// give global wait which is applicable for each elements 
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return driver;
	}
	public String Screenshot(String testcasename,WebDriver driver) {
		TakesScreenshot ss=(TakesScreenshot)driver;
		File source =ss.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		return destination ;
	}
	
}
