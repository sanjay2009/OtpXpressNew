package in.otpxpress.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import in.otpxpress.qa.base.TestBase;
import in.otpxpress.qa.pages.HomePage;
import in.otpxpress.qa.pages.LocationPopUp;
import in.otpxpress.qa.pages.MyAccountInfoPage;
import in.otpxpress.qa.pages.SignUpPage;

public class MyAccountInfoPageTest extends TestBase{
	
	LocationPopUp location;
	SignUpPage signUp;
	HomePage homePage;
	MyAccountInfoPage myAccountInfoPage;
	
	@BeforeClass
	public void openWebPage()
	{
		initialization();
		location = new LocationPopUp();
		signUp = location.enterZipCode();
		signUp.clickSignIn();
		homePage = signUp.enterEmailId(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void click_MyAccountPageInfo_Test()
	{
		
		myAccountInfoPage.clickAccountName();
		
	}
	
		
	@Test(priority = 2)
	public void click_MyAccountInfoPage_myAccount_Test()
	{
	
		myAccountInfoPage.clickAccount();
		
	}
	
	@Test(priority = 3)
	public void click_myAccountInfoPage_accountinfo_test()
	{
		myAccountInfoPage.accountInfoClick();
	}
	
	@Test(priority = 4)
	public void verify_MyAccountInfoPage_ProfileData_Test()
	{
		
		String fn = myAccountInfoPage.checkFirstName();
		System.out.println("FirstName is: "+fn);
		
		String ln = myAccountInfoPage.checkLastName();
		System.out.println("LatsName is: "+ln); 
		
		
		
	}
	
	@Test(priority = 5)
	public void click_myAccountPage_BackButton_Test()
	{
		myAccountInfoPage.clikBackButton();
	}
	
	
	@AfterClass
	
	public void tearDown()
	{
		driver.close();
	}

}
