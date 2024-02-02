package pageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landingpage {
	
	// landing page objects with page factory 
	
	WebDriver driver;
	public Landingpage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	} 
	
	// sign in button  link 
	@FindBy(xpath = "//*[text()=\"Sign in\"]") WebElement signup;
	
	// logo 
	@FindBy (xpath = "//*[@class=\"hmsprite logo\"]") WebElement logoElement;
	
	// sign up link 
	@FindBy (xpath = "//*[text()=\"Create Account\"]") WebElement CreataccountElement;
	
	public WebElement Signup () {
		return signup;
	}
	
	public WebElement homepagelogo () {
		return logoElement;
	}
   public WebElement CreatAccount() {
	   return CreataccountElement;
   }
}
