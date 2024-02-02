package Loginpagetest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectRepo.Landingpage;
import resources.Base;




public class LandingPageTest extends Base{
	public WebDriver driver;
	 public static Logger log =LogManager.getLogger(LandingPageTest.class.getName());
	@BeforeTest 
	public void invokebrower () throws IOException {
		driver=intializeDriver();
		driver.get(url);
	}
	@Test
	public void Validationhomepagelogo () {
		//user assertion class for validation purpose 
		Landingpage l =new Landingpage(driver);
	boolean	logo=l.homepagelogo().isDisplayed();
	// assert class assert true method for validatation the presence of the logo  displayed on home page of it is true 
	//test case will be fass otherwise its fail.
	log.error("Validationhomepagelogo is  validation failed");
	log.info("Validationhomepagelogo is sucessfully validated");
		Assert.assertTrue(logo);
		
	}

	@Test
	public void ValidatetheHomapagetittle() {
		
		 String homepagetittle=driver.getTitle();
		 Assert.assertEquals(homepagetittle, "Rediff.com: News | Rediffmail | Stock Quotes | Shopping");
		 log.info("ValidatetheHomapagetittle is sucessfully validated");

	}
	
	@Test 
	public void validatethePresenceofCreateAccount() {
		
		Landingpage l =new Landingpage(driver);
		String CreateAccount=l.CreatAccount().getText();
		assertEquals(CreateAccount, "Create Account");
		 log.info("validatethePresenceofCreateAccount is sucessfully validated");

	}
	@AfterTest 
	public void Close() {
		driver.close();
	}
	
}
