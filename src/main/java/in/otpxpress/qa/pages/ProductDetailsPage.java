package in.otpxpress.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.otpxpress.qa.base.TestBase;

public class ProductDetailsPage extends TestBase{
	
	@FindBy(xpath="//button[@id='product-addtocart-button' and @title='Add to Cart']")
	WebElement addToCartButton;
	
	@FindBy(xpath="//span[contains(text(),'ONION SAMBAR 1kg')]")
	WebElement productNameLabel;
	
	@FindBy(xpath="//div[contains(text(),'ONIS1000')]")
	WebElement productSKUName;
	
	@FindBy(xpath="//input[@id='qty' and @class='qty']")
	WebElement qtySelected;
	
	public ProductDetailsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickAddToCart()
	{
		addToCartButton.click();
	}
	
	public String verifyProductName()
	{
		return productNameLabel.getText();
	}
	
	public String checkSKUName()
	{
		return productSKUName.getText();
	}
	
	public String checkQtySelected()
	{
		return qtySelected.getText();
	}
	

}
