package in.otpxpress.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.otpxpress.qa.base.TestBase;

public class MyAccountInfoPage extends TestBase{
	
	@FindBy(xpath="//span[@class='text-underlink']")
	WebElement accountNameText;
	
//	@FindBy(xpath="//span[contains(text(),'Your account')]")
//	WebElement accountNameText;
	
	
	
	@FindBy(xpath="//a[@class='account']")
	WebElement myAccount;
	
	@FindBy(xpath= "//*[@id=\"account-nav\"]/ul/li[6]/a")
	WebElement accountInfo;
	
	@FindBy(xpath = "//input[@value='sanjay']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@value='ramesh']")
	WebElement lastName;
	
	@FindBy(xpath="//a[@class='action back']/span")
	WebElement goBackButton;
	
	
	
	public MyAccountInfoPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public SignOut clickAccountName()
	{
		accountNameText.click();
		return new SignOut();
	}
	
	public void clickAccount()
	{
		myAccount.click();
	}
	
	public void accountInfoClick()
	{
		accountInfo.click();
		
	}
	
	public String checkFirstName()
	{
		return firstName.getText();
		//System.out.println(fn);
	}
	
	public String checkLastName()
	{
		return lastName.getText();
		//System.out.println(ln);
		
	}
	
	public void clikBackButton()
	{
		goBackButton.click();
		
	}


}
