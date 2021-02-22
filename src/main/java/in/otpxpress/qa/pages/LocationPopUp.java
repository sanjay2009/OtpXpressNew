package in.otpxpress.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.otpxpress.qa.base.TestBase;

public class LocationPopUp extends TestBase{
	
	@FindBy(css = "#zipcode")
	WebElement postCodePopUp;
	
	@FindBy(xpath="//*[@id=\"zipcode-popup-modal\"]/button")
	WebElement submitButton;
	
	@FindBy(xpath="//*[@id=\"modal-content-38\"]/div/div/ul/li/a/span")
	WebElement PostalAddress;
	
	@FindBy(xpath="//span[@class='pincode']")
	WebElement postalCodeIsDisplayed;
	
	public LocationPopUp()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public SignUpPage enterZipCode()
	{
		postCodePopUp.sendKeys("560043");
		submitButton.click();
		PostalAddress.click();
				
		return new SignUpPage();
	}
	
	public String postalCodeVerify()
	{
		return postalCodeIsDisplayed.getText();
		
	}
	
	

}
