package in.otpxpress.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.otpxpress.qa.base.TestBase;

public class SignOut extends TestBase{
	
	@FindBy(xpath="//a[@class='md-raised md-primary' and contains(text(),'Sign Out')]")
	WebElement signOutLink;
	
	@FindBy(xpath="//span[contains(text(),'You are signed out')]")
	WebElement singOutSucessfull;
	
	public SignOut()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void clickSignOut()
	{
		signOutLink.click();
		
		
	}
	
	public String signOutSuccessfullMessage()
	{
		return singOutSucessfull.getText();
	}

}
