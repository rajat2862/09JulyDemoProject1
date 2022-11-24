package com.db.testLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.db.pageLayer.LoginPage;
import com.db.testBase.TestBase;

public class LoginPageTest extends TestBase {
	
	@Test
	public void verifyLoginFunctionalitywithValidCred() throws InterruptedException
	{
		String expected_url = "https://www.apps.dalalstreet.ai/dashboard";
		Thread.sleep(2000);
		String actual_url = login.getCUrl();
		System.out.println(actual_url);
		Assert.assertEquals(actual_url, expected_url);
	}
	
	@Test(enabled=false)
	public void verifyLoginFunctionalitywithInvalidCred() throws InterruptedException
	{
		String expected_url = "https://www.apps.dalalstreet.ai/login";
		LoginPage login = new LoginPage();
		login.enterEmailID("amarwaghmare573@gmail.com");
		login.enterPassword("Test@12");
		login.clickOnLoginButton();
		Thread.sleep(2000);
		String actual_url = login.getCUrl();
		System.out.println(actual_url);
		Assert.assertEquals(actual_url, expected_url);
	}
}
