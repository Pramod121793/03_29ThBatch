package pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.ReadData;

public class CheckOutPage_1 extends TestBase
{
	@FindBy(xpath = "//input[@id='first-name']") private WebElement firstNameTxtBox;
	@FindBy(xpath = "//input[@id='last-name']") private WebElement lastNameTxtBox;
	@FindBy(xpath = "//input[@id='postal-code']") private WebElement zipCodeTxtBox;
	@FindBy(xpath = "//input[@id='continue']") private WebElement continueBtn;
	@FindBy(xpath = "//span[text()='Checkout: Your Information']") private WebElement checkOutPage_1_lable;
	@FindBy(xpath = "//button[@id='cancel']") private WebElement cancelBtn;
	public CheckOutPage_1 ()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyURL()
	{
		return driver.getCurrentUrl();
	}
	public String verifyCheckOutPage_1_Lable()
	{
		return checkOutPage_1_lable.getText();
	}
	public String inputInfo() throws EncryptedDocumentException, IOException
	{
		firstNameTxtBox.sendKeys(ReadData.readExcel(0,9)); // Pramod(0,9)
		lastNameTxtBox.sendKeys(ReadData.readExcel(0,10)); // Alande(0,10)
		zipCodeTxtBox.sendKeys(ReadData.readExcel(0,11)); //413302(0,11)
		continueBtn.click();
		return driver.getCurrentUrl();
	}
	public String clickOnCancelBtn()
	{
		cancelBtn.click();
		return driver.getCurrentUrl() ;
	}
}
