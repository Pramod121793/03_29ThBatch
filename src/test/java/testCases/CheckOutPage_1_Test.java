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
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class CheckOutPage_1_Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	Cart_Page cart;
	CheckOutPage_1 check1;
	@BeforeMethod(alwaysRun = true) // use always run to beforemethod while using Groups 
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
	}
	@Test(enabled = true, priority = 1, groups = {"Sanity"})
	public void verifyURLTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0,12); //https://www.saucedemo.com/checkout-step-one.html(0,12)
		String actURL=check1.verifyURL();		
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Current Page URL of CheckOut_1_Page = " + actURL);
	}
	@Test (enabled = true, priority = 4, groups = {"Retesting","Sanity"})//dependsOnMethods = "verifyURLTest")// when using 'groups' don't use 'dependsOnMethods'
	public void verifyCheckOutPage_1_LableTest() throws EncryptedDocumentException, IOException
	{
		String expLable=ReadData.readExcel(0,13); // Checkout: Your Information(0,13)
		String actLable=check1.verifyCheckOutPage_1_Lable();
		Assert.assertEquals(expLable, actLable);
		Reporter.log("Presence CheckOut_1_Page Lable = " + actLable);
	}
	@Test (enabled = true, priority = 2, groups = {"Retesting", "Regression"})//dependsOnMethods = "verifyURLTest")// when using 'groups' don't use 'dependsOnMethods'
	public void inputInfoTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0,14); // https://www.saucedemo.com/checkout-step-two.html(0,14)
		String actURL=check1.inputInfo();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("After InputInfo CheckOut_1_Page should be come  =  " + actURL);
	}
	@Test (enabled = true, priority = 3, groups = {"Regression"})//dependsOnMethods = "verifyURLTest")// when using 'groups' don't use 'dependsOnMethods'
	public void clickOnCancelBtn() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0,6); // https://www.saucedemo.com/cart.html(0,6)
		String actURl=check1.clickOnCancelBtn();
		Assert.assertEquals(actURl, expURL);
		Reporter.log("After Click on Cancel Button getting URL = " + actURl);
	}
	@AfterMethod(alwaysRun = true)// use always run to aftermethod while using Groups 
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			Screenshot.screenshot(it.getName());
		}
		driver.close();
	}
}









