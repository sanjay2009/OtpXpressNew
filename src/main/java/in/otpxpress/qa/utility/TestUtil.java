package in.otpxpress.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.compress.compressors.FileNameUtil;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import in.otpxpress.qa.base.TestBase;

public class TestUtil extends TestBase{
	
		
	public static long page_load = 60;
	public static long implict_TimeOut = 60;
	public static String testDataSheetPath = "E:\\Sabji-OTPXpress\\SabjiOTPXpress\\src\\main\\java\\in\\otpxpress\\qa\\testdata\\ddt_login.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	
	public static Object[][] getTestData(String sheetName)
	{
		FileInputStream fis = null;
		try{
			
			fis = new FileInputStream(testDataSheetPath);
		}
		catch(FileNotFoundException fn)
		{
			fn.printStackTrace();
		}
		
		try{
			
			book = WorkbookFactory.create(fis);
		}catch(InvalidFormatException ie)
		{
			ie.printStackTrace();
		}catch(IOException ie)
		{
			ie.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i = 0; i < sheet.getLastRowNum(); i++) {
			for(int k = 0; k < sheet.getRow(0).getLastCellNum(); k++)
			{
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
				//System.out.println(data[i][k]);
			}
		}
		return data;
				
	}
	
	public static void takeScreenShotAtEndofTest()
	{
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		try {
		FileUtils.copyFile(srcFile, new File(currentDir+"\\screenshots\\"+System.currentTimeMillis()+".png"));
		}catch(IOException io)
		{
			io.printStackTrace();
		}
		
	}
	

}
