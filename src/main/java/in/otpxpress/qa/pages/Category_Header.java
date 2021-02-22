package in.otpxpress.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.otpxpress.qa.base.TestBase;

public class Category_Header extends TestBase{
	
	
//	@FindBy(xpath="//body[1]/div[3]/header[1]/div[1]/div[2]/nav[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/span[1]")
//	WebElement fruitsNVegetables;
//	
	@FindBy(xpath="//ul[@class='groupmenu']/li/a/i[1]")
	WebElement fruitsNVegetables;
	
	
	@FindBy(xpath="//body[1]/div[3]/header[1]/div[1]/div[2]/nav[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]")
	WebElement grocery;
	
	@FindBy(xpath="//body[1]/div[3]/header[1]/div[1]/div[2]/nav[1]/div[1]/div[1]/ul[1]/li[3]/a[1]/span[1]")
	WebElement fNv;
	
	@FindBy(xpath="//body[1]/div[3]/header[1]/div[1]/div[2]/nav[1]/div[1]/div[1]/ul[1]/li[4]/a[1]/span[1]")
	WebElement bakery;
	
	@FindBy(xpath="//body[1]/div[3]/header[1]/div[1]/div[2]/nav[1]/div[1]/div[1]/ul[1]/li[5]/a[1]/span[1]")
	WebElement contactUs;
	
	@FindBy(css = "div.col-sm-4:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")
	WebElement leafy;
	
	public Category_Header()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void mouseHoverFruitsNVegetables()
	{
		Actions fruitsnVeg = new Actions(driver);
		fruitsnVeg.moveToElement(fruitsNVegetables).build().perform();;
		
		
	}
	
	public void clickGrocery()
	{
		Actions groc = new Actions(driver);
		groc.moveToElement(grocery).build().perform();
	}
	
	public void clickFnV()
	{
		Actions fnv = new Actions(driver);
		fnv.moveToElement(fNv).build().perform();
	}
	
	public LeafyProductsPage clickLeafy()
	{
		leafy.click();
		return new LeafyProductsPage();
	}
	

}
