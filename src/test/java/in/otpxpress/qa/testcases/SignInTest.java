package in.otpxpress.qa.testcases;


import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import in.otpxpress.qa.base.TestBase;
import in.otpxpress.qa.pages.LocationPopUp;
import in.otpxpress.qa.pages.MyAccountInfoPage;
import in.otpxpress.qa.pages.MyAccountPage;
import in.otpxpress.qa.pages.SignUpPage;

public class SignInTest extends TestBase {
	
	LocationPopUp locationPopUpTest;
	SignUpPage signUpTest;
	MyAccountPage MyAccountPageTest;
	MyAccountInfoPage myAccountInfoTest;
	
	public SignInTest()
	{
		super();
	}
	
//	@Test
//	public void LoginTest()
//	{
//		
//		locationPopUpTest = new LocationPopUp();
//		locationPopUpTest.enterZipCode();
//		System.out.println("Pincode displayed is: "+locationPopUpTest.postalCodeVerify());
//		
//		
//	}
//	
//	@Test
//	public void signIn()
//	{
//		locationPopUpTest = new LocationPopUp();
//		locationPopUpTest.enterZipCode();
//		signUpTest = new SignUpPage();
//		signUpTest.clickSignIn();
//		signUpTest.enterEmailId("sanjay.r@otpxpress.in", "Test@1234");
//		//signUpTest.clickSignIn();
//		System.out.println("Page title is :"+signUpTest.getPageTitle());
//	}

	
	@Test
	public void AccountInfoCheckTest()
	{	
	    locationPopUpTest = new LocationPopUp();	
	    locationPopUpTest.enterZipCode();
	    //System.out.println("Pincode displayed is: "+locationPopUpTest.postalCodeVerify());
	    String pincode = locationPopUpTest.postalCodeVerify();
	    System.out.println("Pincode entered is: "+pincode);
	   // assert.assertEquals(pincode, "560043");
	    
	    signUpTest = new SignUpPage();
		signUpTest.clickSignIn();
		signUpTest.enterEmailId(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("Page title is :"+signUpTest.getPageTitle());
		
//		MyAccountPageTest = new MyAccountPage();
//		MyAccountPageTest.clickAccountName();
//		System.out.println(MyAccountPageTest.AccountNameLink());
//		
//		//System.out.println(MyAccountPageTest.clickAccountName());
//		
//		//WebDriverWait wait = new WebDriverWait(driver, 20);
//		
//		
//		MyAccountPageTest.clickAccountNameLink();
//		System.out.println("First Name is: " +MyAccountPageTest.CheckFirstName());
//		MyAccountPageTest.checkLastName();
//		System.out.println("Last Name is: "+ MyAccountPageTest.checkLastName());
//		MyAccountPageTest.clikBackButton();
		
		myAccountInfoTest = new MyAccountInfoPage();
		myAccountInfoTest.clickAccountName();
		myAccountInfoTest.clickAccount();
		myAccountInfoTest.accountInfoClick();
		System.out.println("First Name is: "+myAccountInfoTest.checkFirstName());
		System.out.println("Last Name is: "+myAccountInfoTest.checkLastName());
		myAccountInfoTest.clikBackButton();
		
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		locationPopUpTest = new LocationPopUp();
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		close();
	}

}
