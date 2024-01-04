package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Cart_Page extends TestBase
{
	//Object repository
	@FindBy(xpath = "//span[text()='Your Cart']") private WebElement cartPageLable;
	@FindBy(xpath = "//button[@id='checkout']") private WebElement checkoutBtn;
	@FindBy(xpath = "//button[@id='continue-shopping']") private WebElement continueShoppingBtn;
	 public Cart_Page() // create a constructor
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyCartPageUrl()
	{
		return driver.getCurrentUrl();
	}
	public String verifyCartPageLable()
	{
		return cartPageLable.getText();
	}
	public String clickOnCheckoutBtn()
	{
		checkoutBtn.click();
		return driver.getCurrentUrl();
	}
	public String clickOnContinueShoppingBtn()
	{
		continueShoppingBtn.click();
		return driver.getCurrentUrl();
	}
}
