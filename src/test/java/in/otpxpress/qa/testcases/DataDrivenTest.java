package in.otpxpress.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import in.otpxpress.qa.base.TestBase;
import in.otpxpress.qa.pages.HomePage;
import in.otpxpress.qa.pages.LocationPopUp;
import in.otpxpress.qa.pages.MyAccountInfoPage;
import in.otpxpress.qa.pages.SignOut;
import in.otpxpress.qa.pages.SignUpPage;
import in.otpxpress.qa.utility.TestUtil;

public class DataDrivenTest extends TestBase{
	
	String sheetName = "Sheet1";
	LocationPopUp location;
	SignUpPage signUp;
	HomePage homePage;
	MyAccountInfoPage myAccountInfo;
	SignOut signout;
	
	@BeforeClass
	public void openWebPage()
	{
		initialization();
		location = new LocationPopUp();
		signUp = location.enterZipCode();
		signUp.clickSignIn();
		
	}
	
	@Test(priority = 1,dataProvider="getTestData")
	public void ddt_Test(String emailId, String pwd)
	{
				
		homePage = signUp.enterEmailId(emailId, pwd);
		
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
