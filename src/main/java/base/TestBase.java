package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReadData;

public class TestBase
{
	public static WebDriver driver;  //use ChromeDriver driver; when want to use Chrome
	public void initialization() throws IOException, InterruptedException
	{
	/*	WebDriverManager.chromedriver().setup(); // use line no 10,13,14 at a time to launch Chrome browser only
	    driver=new ChromeDriver(); 
    	driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/"); */ // static code/hard code passing url directly
		String browser=ReadData.readPropertyFile("Browser"); //dynamic code/soft coding passing browser name thorough config.Properties file
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(ReadData.readPropertyFile("URL")); //dynamic code/soft coding not passing url directly, passing through config.Proerties file
		driver.manage().deleteAllCookies();
		Thread.sleep(4000);
    }
}
