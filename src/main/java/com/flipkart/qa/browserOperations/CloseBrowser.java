package com.flipkart.qa.browserOperations;

import com.flipkart.qa.Reports.LogStatus;
import com.flipkart.qa.driver.Driver;

public class CloseBrowser extends OpenWebsite
{
	public void CloseBrowser()
	{
		Driver.driver.close();
		LogStatus.info("Browser closed");
	}
	public void QuitBrowser()
	{
		Driver.driver.quit();	
		LogStatus.info("Browser driver quit");
	}
}
