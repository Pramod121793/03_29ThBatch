package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.ReadData;

public class LoginPage extends TestBase
{
	//object repository
	@FindBy(xpath = "//input[@id='user-name']") private WebElement userNameTxtBox;
	@FindBy(xpath = "//input[@id='password']") private WebElement passwordTxtBox;
	@FindBy(xpath = "//input[@id='login-button']") private WebElement logInBtn; 
	public LoginPage() throws InterruptedException  // constructor used here 
	{
		PageFactory.initElements(driver, this); 
	/*	PageFactory.initElements(driver, userNameTxtBox);*/// we can write individual webElements like passwordTxtBox...etc with separate pageFactory(Class) or use 'this' keyword for all webElements 
	}
	public String loginToApplication() throws IOException
	{
		userNameTxtBox.sendKeys(ReadData.readPropertyFile("Username"));// passing values called Dynamic coding/Soft coding
		passwordTxtBox.sendKeys(ReadData.readPropertyFile("Password"));
	/*	userNameTxtBox.sendKeys("standard_user"); // passing values called Static coding/Hard coding
		passwordTxtBox.sendKeys("secret_sauce"); */ 
		logInBtn.click();
		return driver.getCurrentUrl();
	}
	public String loginToApplicationMultiCreds(String un, String pass) // un=username, pass=passsword
	{
		userNameTxtBox.sendKeys(un);
		passwordTxtBox.sendKeys(pass);
		logInBtn.click();
		return driver.getCurrentUrl();
	}
	public String verifyTitleOfApplication()
	{
		return driver.getTitle(); 
	} 
	public String verifyURLofApplication()
	{
		return driver.getCurrentUrl();
	}
}
