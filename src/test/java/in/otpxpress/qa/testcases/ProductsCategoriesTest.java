package in.otpxpress.qa.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import in.otpxpress.qa.base.TestBase;
import in.otpxpress.qa.pages.Category_Header;
import in.otpxpress.qa.pages.HomePage;
import in.otpxpress.qa.pages.LocationPopUp;
import in.otpxpress.qa.pages.SignUpPage;

public class ProductsCategoriesTest extends TestBase{
	
	LocationPopUp location;
	SignUpPage signUp;
	Category_Header cat;
	HomePage homePage;
	
	@BeforeClass
	public void openWebPage()
	{
		initialization();
		location = new LocationPopUp();
		signUp= location.enterZipCode();
		signUp.clickSignIn();
		homePage= signUp.enterEmailId(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void fruitsNVegetables_Test()
	{
		cat.mouseHoverFruitsNVegetables();
		cat.clickLeafy();
	}
	
//	@Test(priority = 2)
//	public void click_fruitsNVegatables_Leafy_Test()
//	{
//		cat.clickLeafy();
//	}
	
	

}
