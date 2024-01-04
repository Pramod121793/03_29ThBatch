package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import utility.HandleDropDown;

public class Inventory_Page extends TestBase
{
	//Object Repository
	// add products xpath
	@FindBy(xpath = "//span[text()='Products']") private WebElement productLable;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backpackProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement bikeLightProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement boltTShirtProduct;
	@FindBy(xpath= "//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement jacketProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement onesieProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement TShirtRedProduct;
	//remove xpath (consider line no 24 to 29)
	@FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']") private WebElement backpackRemoveProduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']") private WebElement bikeLightRemoveProduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bolt-t-shirt']") private WebElement boltTShirtRemoveProduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-fleece-jacket']") private WebElement jacketRemoveProduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-onesie']") private WebElement onesieRemoveProduct;
	@FindBy(xpath = "//button[@id='remove-test.allthethings()-t-shirt-(red)']") private WebElement TShirtRedRemoveProduct;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']") private WebElement cartCount;
	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement cartIcon;
	@FindBy(xpath = "//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath = "//a[text()='Facebook']") private WebElement facebookLogo;
	@FindBy(xpath = "//a[text()='LinkedIn']") private WebElement linkedInLogo;
	@FindBy(xpath = "//select[@class='product_sort_container']") private WebElement productDropDown;
	public Inventory_Page()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyProductLable()
	{
		return productLable.getText(); // to verify Text, String datatype used and used in method definition 
	}
	public boolean verifyTwitterLogo()
	{
		return twitterLogo.isDisplayed();
	}
	public boolean verifyFacebookLogo()
	{
		return facebookLogo.isDisplayed();
	}
	public boolean verifyLinkedInLogo() // to verify Logo/image, boolean datatype used and used in method definition also
	{
		return linkedInLogo.isDisplayed();
	}
	public String add6Product() throws InterruptedException
	{
		HandleDropDown.handleSelectClass(productDropDown, "Price (low to high)");// used to access xpath(productdropdown) & value(Price (low to high)) in utility.HandleDropDown.handleSelectClass
	/*	Select s=new Select(productDropDown); // used line no 60 & 61, for add6Product() method only, if want to explore/use xpath of productdropdown & option value in other class/package, refer line no 59 for that
		s.selectByVisibleText("Price (low to high)"); */
		Thread.sleep(2000);
		backpackProduct.click();
		bikeLightProduct.click();
		boltTShirtProduct.click();
		jacketProduct.click();
		onesieProduct.click();
		TShirtRedProduct.click(); 
		return cartCount.getText();
	}
	public String remove2Product() throws InterruptedException
	{
		add6Product();
		backpackRemoveProduct.click();
		bikeLightRemoveProduct.click();
		return cartCount.getText();
	}
	public void clickcartIcon() // this method written because when want to navigate to Cart page, need to click on cartIcon present on inventory page
	{
		cartIcon.click(); // this method reference taken in Cart_Page_Test(refer comment of line no 78)
	}
	
	
	
	
	
	
}