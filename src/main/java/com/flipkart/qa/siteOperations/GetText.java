package com.flipkart.qa.siteOperations;

import org.openqa.selenium.By;

import com.flipkart.qa.driver.Driver;

public class GetText extends FindElements{
	public String getText(By locator)
	{
		String text=Driver.driver.findElement(locator).getText();
		return text;
	}
}
