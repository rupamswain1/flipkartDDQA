package com.flipkart.qa.browserOperations;

import com.flipkart.qa.ReadOperation.ReadPropertyFile;
import com.flipkart.qa.Reports.LogStatus;
import com.flipkart.qa.driver.Driver;

public class OpenWebsite
{
	public void openUrl(String url)
	{
		try
		{
			Driver.driver.get(url);
			LogStatus.pass(new ReadPropertyFile().readProperty("url")+ " website opened");
		}
		catch (Exception e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
}
