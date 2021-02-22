import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class RoughWork {
	
	static Workbook book;
	static Sheet sheet;
	public static String testDataSheetPath = "E:\\Sabji-OTPXpress\\SabjiOTPXpress\\src\\main\\java\\in\\otpxpress\\qa\\testdata\\ddt_login.xlsx";

	public static void main(String[] args) {
		
		
		
		getTestData("Sheet1");
			
			
					
		}
	
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
				System.out.print(data[i][k]);
			}
			System.out.println();
		}
		return data;
	}
	

}
