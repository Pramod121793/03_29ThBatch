package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOutPage_2 extends TestBase
{
	@FindBy(xpath = "//div[text()='Swag Labs']") private WebElement checkOutPage_2_Logo;
	@FindBy(xpath = "//span[text()='Checkout: Overview']") private WebElement checkOutPage_2_Lable;
	@FindBy(xpath = "//div[@class='summary_info']//div[1]") private WebElement paymentInfomationTxt;
	@FindBy(xpath = "//div[@class='summary_info']//div[2]") private WebElement sauceCardTxt;;
	@FindBy(xpath = "//div[@class='summary_info']//div[3]") private WebElement shippingInformationTxt;
	@FindBy(xpath = "//div[@class='summary_info']//div[4]") private WebElement freePonyExpressTxt;
	@FindBy(xpath = "//div[@class='summary_info']//div[5]") private WebElement priceTotaltxt;
	@FindBy(xpath = "//div[@class='summary_info']//div[6]") private WebElement itemTotalTxt;
	@FindBy(xpath = "//div[@class='summary_info']//div[7]") private WebElement taxTxt;
	@FindBy(xpath = "//div[@class='summary_info']//div[8]") private WebElement totalTxt;
	@FindBy(xpath = "//button[@id='finish']") private WebElement finishBtn;
	@FindBy(xpath = "//button[@id='cancel']") private WebElement cancelBtn;
	public CheckOutPage_2()
	{
		PageFactory.initElements(driver,this);
	}
	public boolean verifyCheckOutPage_2_Logo()
	{
		return checkOutPage_2_Logo.isDisplayed();
	}
	public String verifyCheckOutPage_2_Lable()
	{
		return checkOutPage_2_Lable.getText();
	}
	public String verifyPaymentInformationText()
	{
		return paymentInfomationTxt.getText();
	}
	public String verifySauceCardText()
	{
		return sauceCardTxt.getText();
	}
	public String verifyShippingInformationText()
	{
		return shippingInformationTxt.getText();	
	}
	public String verifyFreePonyExpressText()
	{
		return freePonyExpressTxt.getText();	
	}
	public String verifyPriceTotalText()
	{
		return priceTotaltxt.getText();
	}
	public String verifyItemTotalText()
	{
		return itemTotalTxt.getText();
	}
	public String verifyTaxText()
	{
		return taxTxt.getText();
	}
	public String verifyTotalText()
	{
		return totalTxt.getText();
	}
	public String clickOnFinishBtn()
	{
		return driver.getCurrentUrl();
	//	return finishBtn.getText(); // after click on Finish button via getText() method getting 'Finish' as text for verification, So choose 'Finish'(1,10) text from excel sheet
	}
	public String clickOnCancelBtn()
	{
		return driver.getCurrentUrl();
	}
}
