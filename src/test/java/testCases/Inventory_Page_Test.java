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
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class Inventory_Page_Test extends TestBase
{
	LoginPage login; // @BeforeMethod mentioned as classname_objectname i.e LoginPage login to access it in setUp() method for Object creation 
	Inventory_Page invent;
	@BeforeMethod(alwaysRun = true) // // use always run to beforemethod while using Groups 
	public void setUp() throws IOException, InterruptedException
	{
		initialization();
		login =new LoginPage();
		invent=new Inventory_Page();
		login.loginToApplication();
	}
	@Test (enabled = true, priority = 3, groups = {"Retesting"})
	public void verifyProductLableTest() throws EncryptedDocumentException, IOException
	{
		String expLable=ReadData.readExcel(0,3);//Products(0,3)---taken value from excel sheet called soft coding, instead of passing directly as Products as hard coding
		String actLable=invent.verifyProductLable();
		Assert.assertEquals(expLable, actLable);
		Reporter.log("Presence of ProductLable = " + actLable);
	}
	@Test (enabled= true, priority = 4, groups = {"Retesting"})
	public void verifyTwitterLogoTest()
	{
		boolean result=invent.verifyTwitterLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of TwitterLogo = " + result);
	}
	@Test (enabled = true, priority = 5, groups = {"Retesting"})
	public void verifyFacebookLogoTest()
	{
		boolean result=invent.verifyFacebookLogo();
		Assert.assertEquals(result,true);
		Reporter.log("Visibility of FacebookLogo = " + result);
	}
	@Test (enabled = true, priority = 6, groups = {"Retesting"})
	public void verifyLinkedInLogoTest()
	{
		boolean result=invent.verifyLinkedInLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of LinkedInLogo = " + result);
	}
	@Test(enabled = true, priority = 1, groups = {"Sanity", "Regression"}, invocationCount = 3)
	public void add6ProductTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcel(0,4); //6(0,4)---follow same comment like line no 32
		String actCount=invent.add6Product();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Products added Count = " + actCount);
	}
	@Test (enabled = true, priority = 2, groups = {"Sanity", "Regression"} ) //dependsOnMethods = "add6ProductTest") // when using 'groups' don't use 'dependsOnMethods'
	public void remove2ProductTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcel(0,5); //4(0,5)---follow same comment like line no 32
		String actCount=invent.remove2Product();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Number of Products after removing = " + actCount);
	}
	@AfterMethod(alwaysRun = true) // use always run to aftermethod while using Groups 
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus()) // if need to capture screenshot of failed method. So,for practice purpose fail one of the above method then closeBrowser() method will execute 
		{
		Screenshot.screenshot(it.getName());	
		}
		driver.close();
	}
}
