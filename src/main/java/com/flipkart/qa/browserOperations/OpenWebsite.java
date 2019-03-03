package com.flipkart.qa.browserOperations;

import com.flipkart.qa.driver.Driver;

public class OpenWebsite
{
	public void openUrl(String url)
	{
		Driver.driver.get(url);
	}
}
