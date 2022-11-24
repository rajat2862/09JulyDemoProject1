package com.db.pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.db.testBase.TestBase;



public class TransactionsPage extends TestBase {
	
	public TransactionsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//------Obj Repo--------
	private By data = By.xpath("//table[@class='table table align-middle table-nowrap']/tbody/tr[1]/td[2]");
	
	
	
	//----- Action method ----------------
	public void getTransactionDetails()
	{
		for(int i=1;i<=10;i++)
		{
			for(int j=1;j<=9;j++)
			{
				String d = driver.findElement(By.xpath("//table[@class='table table align-middle table-nowrap']/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.print(d+" ");
			}
			System.out.println();
		}
	}
}
