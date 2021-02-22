package in.otpxpress.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import in.otpxpress.qa.base.TestBase;
import in.otpxpress.qa.pages.HomePage;
import in.otpxpress.qa.pages.LocationPopUp;
import in.otpxpress.qa.pages.MyAccountInfoPage;
import in.otpxpress.qa.pages.ProductDetailsPage;
import in.otpxpress.qa.pages.SignOut;
import in.otpxpress.qa.pages.SignUpPage;

public class ProductDetailsPageTest extends TestBase{
	
	LocationPopUp location;
	SignUpPage signUp;
	HomePage homePage;
	ProductDetailsPage productDetails;
	MyAccountInfoPage myAccountInfoPage;
	SignOut signOut;
	
	@BeforeClass
	public void openWebPage()
	{
		initialization();
		location = new LocationPopUp();
		signUp = location.enterZipCode();
		signUp.clickSignIn();
		
		homePage = signUp.enterEmailId(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickSearch("Onion");
		productDetails = homePage.clickDisplayedProduct();
		
	}
	
	@Test(priority = 1)
	public void verifyProductName_Test()
	{
		System.out.println(productDetails.verifyProductName());
		String pNameActual = productDetails.verifyProductName();
		Assert.assertEquals(pNameActual, "ONION SAMBAR 1KG");
	}
	
	@Test(priority = 2)
	public void checkQtySelected_Test()
	{
		System.out.println(productDetails.checkQtySelected());
	}
	
	@Test(priority = 3)
	public void verifyProductSKUName_Test()
	{
		System.out.println(productDetails.checkSKUName());
		String skuNameActual = productDetails.checkSKUName();
		Assert.assertEquals(skuNameActual, "ONIS1000");
	}
	
	@Test(priority = 4)
	public void clickAddToCart_Test()
	{
		productDetails.clickAddToCart();
	}
	
	
	
	
	@Test(priority = 5)
	public void clickSignOut_Test()
	{
		signOut = myAccountInfoPage.clickAccountName();
		signOut.clickSignOut();
		
		System.out.println(signOut.signOutSuccessfullMessage());
		String signOut_Actual = signOut.signOutSuccessfullMessage();
		Assert.assertEquals(signOut_Actual, "You are signed out");
		
	}
	
	

}
