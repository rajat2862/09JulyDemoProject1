package com.db.testBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.db.pageLayer.DashboardPage;
import com.db.pageLayer.Exchange;
import com.db.pageLayer.LoginPage;
import com.db.pageLayer.TransactionsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	static public LoginPage login;
	public DashboardPage dash;
	public Exchange exchange;
	public TransactionsPage transaction;
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		String browser = "Chrome";
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Please enter valid browser name");
		}
		
		driver.get("https://www.apps.dalalstreet.ai/login");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//---------- Object Creation -------------
		login = new LoginPage();
		dash= new DashboardPage();
		exchange = new Exchange();	
		transaction = new TransactionsPage();
		
		//------- Login Steps -------------------
		login.enterEmailID("amarwaghmare573@gmail.com");
		login.enterPassword("Test@1234");
		login.clickOnLoginButton();
		Thread.sleep(4000);
		
	}
	

	@AfterMethod
	public void tearDown()
	{
//		driver.quit();
	}
}
