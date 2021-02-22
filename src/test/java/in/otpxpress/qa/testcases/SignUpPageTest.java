package in.otpxpress.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import in.otpxpress.qa.base.TestBase;
import in.otpxpress.qa.pages.HomePage;
import in.otpxpress.qa.pages.LocationPopUp;
import in.otpxpress.qa.pages.SignUpPage;
import in.otpxpress.qa.utility.TestUtil;

public class SignUpPageTest extends TestBase{
	String sheetName = "Sheet1";
	
	LocationPopUp location;
	SignUpPage signUp;
	HomePage homePage;
	
	@BeforeClass
	public void openWebPage()
	{
		initialization();
		location = new LocationPopUp();
		signUp = location.enterZipCode();
	}
	
	@Test(priority = 2)
	public void signUpPageTitleTest()
	{
		String signUpPageTitle = signUp.getPageTitle();
		System.out.println("SingUp Page title is: "+signUpPageTitle);
		Assert.assertEquals(signUpPageTitle, "otpxpress");
	}
	
	@Test(priority = 1)
	public void signInLinkTest()
	{
		signUp.clickSignIn();
	}
	
	@Test(priority = 3, dataProvider="getTestData")
	public void enterCredentialsTest(String eid, String pwd)
	{
		homePage = signUp.enterEmailId(eid, pwd);
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	

}
