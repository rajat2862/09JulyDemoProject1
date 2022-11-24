package com.db.pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.db.testBase.TestBase;



public class Exchange extends TestBase {

	public Exchange()
	{
		PageFactory.initElements(driver, this);
	}
	
	//-------------Obj --------------------
	private By buy_btn1 = By.xpath("//a[contains(text(),'Buy')]");
	private By quantity_txt = By.xpath("//input[@name='input-Qunatity']");
	private By buy_btn2 = By.xpath("//button[contains(text(),'Buy')]");
	private By status_text = By.xpath("//div[contains(text(),'Order Created successfully')]");
	
	//----------Action method -------------
	public void clickOnBuyButton1()
	{
		driver.findElement(buy_btn1).click();
	}
	
	public void enterQuantityOfShare(String count)
	{
		driver.findElement(quantity_txt).click();
		driver.findElement(quantity_txt).sendKeys(count);
	}
	
	public void clickOnBuyButton2()
	{
		driver.findElement(buy_btn2).click();
	}
	
	public String getStatus()
	{
		String sta = driver.findElement(status_text).getText();
		return sta;
	}
		
}
