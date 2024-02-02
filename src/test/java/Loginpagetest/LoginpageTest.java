package Loginpagetest;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectRepo.*;
import resources.Base;

public class LoginpageTest extends Base {
	// extends with base class to get browser invoke code in it 
		public WebDriver driver;
		
		@BeforeTest 
		public void revokebrowser() throws IOException {
			 driver =intializeDriver();
			 driver.get(url);
		}
		
		@Test 
		public void navigatetoLoginpage() {
			
			
		   driver.manage().window().maximize();
		   Landingpage l =new Landingpage(driver);
		   l.Signup().click();
		   log.info("navigatetoLoginpage sucssesfully done");
		}
		
		@Test (dataProvider = "getData",dependsOnMethods = "navigatetoLoginpage")
		public void Loginpageworking(String username ,String password) {
			 
			   Loginpage l2=new Loginpage(driver);
			   l2.loginid().sendKeys(username);
			   l2.Pass().sendKeys(password);
			   l2.loginbutton().click();
			//  String errormsg=l2.Loginerror().getText();
			   l2.loginid().clear();
			   log.info (" validation of Loginpage with restricted user sucssesfully");
			  
		}
	@DataProvider
	public Object [][] getData(){
		Object [][] data=new Object [1][2];
		data[0][0]="Akash";
		data[0][1]="Akash@12345";
		
//		data[1][0]="Akashsatpute";
//		data[1][1]="Akash123456";
//		
//		data[2][0]="Avinsah";
//		data[2][1]="Avinash@12345";

		return data;
		
		
	}
	@AfterTest 
	public void close () {
		driver.close();
	}
}
