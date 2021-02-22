package in.otpxpress.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.otpxpress.qa.base.TestBase;

public class MyAccountPage extends TestBase{
	
	//@FindBy(xpath= "/html/body/div[3]/header/div/div[1]/div/div/div[3]/ul/li[3]/div/a/span[1]")
	@FindBy(xpath="//span[@class='text-underlink']")
	WebElement accountNameText;
	
	@FindBy(linkText ="//*[@id=\"utilities-main\"]/div[1]/div[2]/div/p[1]/a/text()[2]")
	WebElement accountNameLink;
	
	@FindBy(id = "firstname")
	WebElement firstName;
	
	@FindBy(id = "lastname")
	WebElement lastName;
	
	@FindBy(xpath="//*[@id=\"form-validate\"]/div/div[2]/a/span")
	WebElement goBackButton;
	
	public MyAccountPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void  clickAccountName()
	{
		accountNameText.click();
		
	}
	
	public String AccountNameLink()
	{
		
		return accountNameLink.getText();
				
	}
	
	public void clickAccountNameLink()
	{
		accountNameLink.click();
	}
	
	public String CheckFirstName()
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
