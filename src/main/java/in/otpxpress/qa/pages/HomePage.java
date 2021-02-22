package in.otpxpress.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.otpxpress.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//input[@id='search' and @name='q']")
	WebElement search;
	
	@FindBy(xpath="//img[@class='product-image-photo hovered-img' and @alt='/SambarOnion.jpg']")
	WebElement mouseOverProduct;
	
	@FindBy(xpath="//*[@id=\"product-list-container\"]/div/div[2]/ol/li[3]/div/div[1]/a[1]/span/span/img[2]")
	WebElement clickProductImage;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickSearch(String product)
	{
		search.sendKeys(product);
		search.sendKeys(Keys.ENTER);
		
		
	}
	
	public void selectProduct()
	{
		Actions prod = new Actions(driver);
		prod.moveToElement(mouseOverProduct);
	}
	
	public ProductDetailsPage clickDisplayedProduct()
	{
		clickProductImage.click();
		return new ProductDetailsPage();
	}
	
}
