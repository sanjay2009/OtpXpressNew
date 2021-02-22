package in.otpxpress.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import in.otpxpress.qa.utility.TestUtil;
import in.otpxpress.qa.utility.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase()
	{
		
		
		try
		{
			prop = new Properties();
		FileInputStream fip = new FileInputStream("E:\\Sabji-OTPXpress\\SabjiOTPXpress\\src\\main\\java\\in\\"
				+ "otpxpress\\qa\\config\\config.properties");
		prop.load(fip);
		}
		catch(FileNotFoundException f)
		{
			f.printStackTrace();
		}
		
		catch(IOException io)
		{
			io.printStackTrace();
		}
		
				
	}
	
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
				{
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+
					"\\driver\\chromedriver.exe");
					driver = new ChromeDriver();
				}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+
			"\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+
			"\\driver\\chromedriver.exe");
			driver = new InternetExplorerDriver();
		}
		
		else
		{
			System.out.println("Select right browser");
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implict_TimeOut, TimeUnit.SECONDS);
		
			
		
		
		
		//Thread.sleep(10000);
	}
	
	public void postalCodeEntry()
	{
		
	}
	
	public void close()
	
	{
		driver.quit();
	}
	

}
