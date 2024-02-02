package pageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	// login page objects with page factory 
	public WebDriver driver;
	
	public Loginpage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//*[@id=\"login1\"]") WebElement username;
	
	@FindBy (xpath = "//*[@id=\"password\"]") WebElement password;
	
	@FindBy (xpath = "//*[@class=\"signinbtn\"]") WebElement submit;
	
	@FindBy (xpath = "//*[@id=\"div_login_error\"]") WebElement loginerrorElement;
	public WebElement loginid() {
		return username;
		
	}
	public WebElement Pass() {
		return password;
	}
	public  WebElement loginbutton() {
		return submit;
	}
	public WebElement Loginerror() {
		return loginerrorElement;
	}

}
