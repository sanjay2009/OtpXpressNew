package in.otpxpress.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import in.otpxpress.qa.base.TestBase;
import in.otpxpress.qa.pages.LocationPopUp;
import in.otpxpress.qa.pages.SignUpPage;

public class LocationPopUpTest extends TestBase{
	
	LocationPopUp location;
	SignUpPage signUp;
	
	@BeforeClass
	public void openWebPage()
	{
		initialization();
		location = new LocationPopUp();
	}
	
	@Test
	public void popUpEnterTest()
	{
		signUp = location.enterZipCode();
		
	}
	
	@Test
	public void verifyPincode()
	{
		String pincode = location.postalCodeVerify();
		System.out.println("Entered pincode is: "+pincode);
		Assert.assertEquals(pincode, "560043");
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}

}
