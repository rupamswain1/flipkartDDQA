package com.flipkart.qa.siteOperations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.flipkart.qa.driver.Driver;

public class FindElements extends Click{

	public static List<WebElement> findElements(By locator)
	{
		List<WebElement> webElement=Driver.driver.findElements(locator);
		return webElement;
	}
}
