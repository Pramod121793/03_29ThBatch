package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class LoginPageTest extends TestBase
{
	LoginPage login;
	@BeforeMethod(alwaysRun = true) // use always run to beforemethod while using Groups 
	public void setUp() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
	}
	@Test (enabled = true, priority = 1, groups = {"Retesting"})// dependsOnMethods = "verifyURLofApplicationTest")// when using 'groups' don't use 'dependsOnMethods'
	public void verifyTitleOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expTitle= ReadData.readExcel(0,0);  //Swag Labs(0,0)---taken value from excel sheet called soft coding, instead of passing directly as Swag Labs as hard coding
		String actTitle=login.verifyTitleOfApplication();
		Assert.assertEquals(expTitle, actTitle);
	}
	@Test (enabled = true, priority = 3, groups = {"Sanity"} )
	public void verifyURLofApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0,1); //https://www.saucedemo.com/(0,1)---follow same comment like line no 28
		String actURL=login.verifyURLofApplication();
		Assert.assertEquals(expURL, actURL);
	}
	@Test (enabled = true, priority = 2, groups = {"Regression","Sanity"})// dependsOnMethods = "verifyURLofApplicationTest")
	public void loginToApplicationTest() throws IOException
	{
		String expURL=ReadData.readExcel(0,2);//https://www.saucedemo.com/inventory.html(0,2)------follow same comment like line no 28
		String actURL=login.loginToApplication();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("After Login inventory Page should be come = " + actURL);
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
