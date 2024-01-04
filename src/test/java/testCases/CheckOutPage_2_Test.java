package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_Page;
import pages.CheckOutPage_1;
import pages.CheckOutPage_2;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class CheckOutPage_2_Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	Cart_Page cart;
	CheckOutPage_1 check1;
	CheckOutPage_2 check2;
	@BeforeMethod(alwaysRun = true)// use always run to beforemethod while using Groups 
	public void setUp() throws IOException, InterruptedException
	{
		initialization();
		login=new LoginPage();
		login.loginToApplication();
		invent=new Inventory_Page();
		invent.add6Product();
		invent.clickcartIcon();
		cart=new Cart_Page();
		cart.clickOnCheckoutBtn();
		check1=new CheckOutPage_1();
		check1.inputInfo();
		check2=new CheckOutPage_2();
	}
	@Test (enabled = true, priority = 8, groups = {"Retesting"})
	public void verifyCheckOutPage_2_LogoTest()
	{
		boolean result=check2.verifyCheckOutPage_2_Logo();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of CheckOut_2_Page Logo =  " + result);
	}	
	@Test (enabled = true, priority = 7, groups = {"Retesting"})
	public void verifyCheckOutPage_2_LableTest() throws EncryptedDocumentException, IOException
	{
		String expLable=ReadData.readExcel(1,0); // Checkout: Overview(1,0)
		String actLable=check2.verifyCheckOutPage_2_Lable();
		Assert.assertEquals(expLable, actLable);
		Reporter.log("Presence CheckOut_2_Page Lable = " + actLable);
	}
	@Test (enabled = true, priority = 1, groups = {"Retesting"})
	public void verifyPaymentInformationTest() throws EncryptedDocumentException, IOException
	{
		String expText=ReadData.readExcel(1,1); // Payment Information(1,1)
		String actText=check2.verifyPaymentInformationText();
		Assert.assertEquals(expText, actText);
		Reporter.log("Presence of Payment Information Text = " + actText);		
	}
	@Test (enabled = true, priority = 2, groups = {"Retesting"})//dependsOnMethods = "verifyPaymentInformationTest")// when using 'groups' don't use 'dependsOnMethods'
	public void verifySauceCardTextTest() throws EncryptedDocumentException, IOException
	{
		String expText=ReadData.readExcel(1,2); // SauceCard #31337(1,2)
		String actText=check2.verifySauceCardText();
		Assert.assertEquals(expText, actText);
		Reporter.log("Presence of Sauce Card Text = " + actText);		
	}
	@Test (enabled = true, priority = 3, groups = {"Retesting"})//dependsOnMethods = "verifyPaymentInformationTest")// when using 'groups' don't use 'dependsOnMethods'
	public void verifyShippingInformationTextTest() throws EncryptedDocumentException, IOException
	{
		String expText=ReadData.readExcel(1,3); // Shipping Information(1,3)
		String actText=check2.verifyShippingInformationText();
		Assert.assertEquals(expText, actText);
		Reporter.log("Presence of Shipping Infornmation Text = " + actText);
	}
	@Test (enabled = true, priority = 4, groups = {"Retesting"})//dependsOnMethods = "verifyPaymentInformationTest")// when using 'groups' don't use 'dependsOnMethods'
	public void verifyFreePonyExpressTextTest() throws EncryptedDocumentException, IOException
	{
		String expText=ReadData.readExcel(1,4); // Free Pony Express Delivery!(1,4)
		String actText=check2.verifyFreePonyExpressText();
		Assert.assertEquals(expText, actText);
		Reporter.log("Presence of Free Pony Express Text = " + actText);		
	}
	@Test (enabled = true, priority = 5, groups = {"Retesting"})//dependsOnMethods = "verifyPaymentInformationTest")// when using 'groups' don't use 'dependsOnMethods'
	public void verifyPriceTotalTextTest() throws EncryptedDocumentException, IOException
	{
		String expText=ReadData.readExcel(1,5); // Price Total(1,5)
		String actText=check2.verifyPriceTotalText();
		Assert.assertEquals(expText, actText);
		Reporter.log("Presence of Price Total Text = " + actText);
	}
	@Test (enabled = true, priority = 6, groups = {"Retesting"})//dependsOnMethods = "verifyPaymentInformationTest")// when using 'groups' don't use 'dependsOnMethods'
	public void verifyItemTotalTextTest() throws EncryptedDocumentException, IOException
	{
		String expText=ReadData.readExcel(1,6); // Item total: $129.94(1,6)
		String actText=check2.verifyItemTotalText();
		Assert.assertEquals(expText, actText);
		Reporter.log("Presence of Item Total Text = " + actText);
	}
	@Test (enabled = true, priority = 9,groups = {"Retesting"})//dependsOnMethods = "verifyPaymentInformationTest")// when using 'groups' don't use 'dependsOnMethods'
	public void verifyTaxTextTest() throws EncryptedDocumentException, IOException
	{
		String expText=ReadData.readExcel(1,7); // Tax: $10.40(1,7)
		String actText=check2.verifyTaxText();
		Assert.assertEquals(expText, actText);
		Reporter.log("Presence of Tax Text = " + actText);
	}
	@Test (enabled = true, priority = 10, groups = {"Retesting"})//dependsOnMethods = "verifyPaymentInformationTest")// when using 'groups' don't use 'dependsOnMethods'
	public void verifyTotalTextTest() throws EncryptedDocumentException, IOException
	{
		String expText=ReadData.readExcel(1,8); // Total: $140.34(1,8)
		String actText=check2.verifyTotalText();
		Assert.assertEquals(expText, actText);
		Reporter.log("Presence of Total Text = " + actText);
	}
	@Test (enabled = true, priority = 11, groups = {"Regression"})//dependsOnMethods = "verifyPaymentInformationTest")// when using 'groups' don't use 'dependsOnMethods'
	public void clickOnFinishBtnTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0,14); //(1,9) Getting in manual Testing = https://www.saucedemo.com/checkout-complete.html(1,9)
		String actURL=check2.clickOnFinishBtn();// (0,14) Getting in automation Testing = https://www.saucedemo.com/checkout-step-two.html(0,14)
		Assert.assertEquals(expURL, actURL); 
		Reporter.log("After Click on Finish Button getting URL = " + actURL); 
	}
	@Test (enabled = true, priority = 12, groups = {"Regression"})
	public void clickOnCancelBtnTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0,14); //(0,2) Getting in manual Testing = https://www.saucedemo.com/inventory.html(0,2)
		String actURL=check2.clickOnCancelBtn(); //(0,14) Getting in automation Testing = // https://www.saucedemo.com/checkout-step-two.html(0,14)
		Assert.assertEquals(expURL, actURL);
		Reporter.log("After click on Cancel Button getting URL = " + actURL);
	}
	@AfterMethod(alwaysRun = true)// use always run to beforemethod while using Groups 
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			Screenshot.screenshot(it.getName());
		}
		driver.close();
	}
}
