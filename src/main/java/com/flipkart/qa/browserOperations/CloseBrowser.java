package com.flipkart.qa.browserOperations;

import com.flipkart.qa.driver.Driver;

public class CloseBrowser extends OpenWebsite
{
	public void CloseBrowser()
	{
		Driver.driver.close();
	}
	public void QuitBrowser()
	{
		Driver.driver.quit();	}
}
