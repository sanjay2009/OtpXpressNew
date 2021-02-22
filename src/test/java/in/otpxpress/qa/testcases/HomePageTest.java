package in.otpxpress.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import in.otpxpress.qa.base.TestBase;
import in.otpxpress.qa.pages.HomePage;
import in.otpxpress.qa.pages.LocationPopUp;
import in.otpxpress.qa.pages.ProductDetailsPage;
import in.otpxpress.qa.pages.SignUpPage;

public class HomePageTest extends TestBase{
	
	LocationPopUp location;
	SignUpPage signUp;
	HomePage homePage;
	ProductDetailsPage productDetails;
	
	@BeforeClass
	public void openWebPage()
	{
		initialization();
		location = new LocationPopUp();
		signUp = location.enterZipCode();
		signUp.clickSignIn();
		homePage = signUp.enterEmailId(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test
	public void searchProduct()
	{
		homePage.clickSearch("Onion");
		//homePage.selectProduct();
		//homePage.clickDisplayedProduct();
		productDetails = homePage.clickDisplayedProduct();
		
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}

}
