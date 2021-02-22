package in.otpxpress.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.otpxpress.qa.base.TestBase;

public class SignUpPage extends TestBase{
	
	
	@FindBy(xpath="//span[@class='text-underlink']")
	WebElement signInLink;
	
	@FindBy(id = "email")
	WebElement emailId;
	
	@FindBy(id = "pass")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"send2\"]")
	WebElement signButton;
	
	public SignUpPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickSignIn()
	{
		signInLink.click();
	}
	
	public HomePage enterEmailId(String email, String passw)
	{
		emailId.sendKeys(email);
		password.sendKeys(passw);
		signButton.click();
		return new HomePage();
		
		
	}
	
	public  String getPageTitle()
	{
		return driver.getTitle();
	}
	
	
	
		
}
