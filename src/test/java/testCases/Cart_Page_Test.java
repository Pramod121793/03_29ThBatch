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
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class Cart_Page_Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	Cart_Page cart;
	@BeforeMethod(alwaysRun = true)// use always run to beforemethod while using Groups 
	public void setUp() throws IOException, InterruptedException
	{
		initialization(); // initialize and launch browser
		login=new LoginPage(); // object created of LoginPage
		login.loginToApplication(); // called method for log in to be logged in
		invent=new Inventory_Page();// object created of Inventory Page
		invent.add6Product();// six products added in cart
		invent.clickcartIcon();// clicked on cart icon to navigate to Cart Page
		cart=new Cart_Page(); // object created of Cart Page and followed line no 20 to 26 flow to reach on Cart Page
	}
	@Test (enabled = true, priority = 3, groups = {"Sanity"})
	public void verifyCartPageUrlTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0,6);//https://www.saucedemo.com/cart.html(0,6)
		String actURL=cart.verifyCartPageUrl();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Current Page URL of Cart Page = " + actURL);
	}
	@Test (enabled = true, priority = 4, groups = {"Retesting"})//dependsOnMethods = "verifyCartPageUrlTest")// when using 'groups' don't use 'dependsOnMethods'
	public void verifyCartPageLableTest() throws EncryptedDocumentException, IOException
	{
		String expText=ReadData.readExcel(0,7); //Your Cart(0,7)
		String actText=cart.verifyCartPageLable();
		Assert.assertEquals(expText, actText);
		Reporter.log("Currrent Page Lable of Cart Page = " + actText);
	}
	@Test (enabled = true, priority = 1, groups = {"Regression"} )//dependsOnMethods = "verifyCartPageUrlTest")// when using 'groups' don't use 'dependsOnMethods'
	public void clickOnCheckoutBtnTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0,8); //https://www.saucedemo.com/checkout-step-one.html(0,8)
		String actURL=cart.clickOnCheckoutBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("After Click on Checkout Button getting URL = " + actURL);
	}
	@Test (enabled = true, priority = 2, groups = {"Sanity", "Regression"})//dependsOnMethods = "verifyCartPageUrlTest")
	public void clickOnContinueShoppingBtnTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0,2); //https://www.saucedemo.com/inventory.html(0,2)
		String actURL=cart.clickOnContinueShoppingBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("After Click on Continuous Shopping Button getting URL = " + actURL);
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










