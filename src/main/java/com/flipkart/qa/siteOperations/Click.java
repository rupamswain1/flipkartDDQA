package com.flipkart.qa.siteOperations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.qa.Reports.LogStatus;
import com.flipkart.qa.driver.Driver;

public class Click 
{
	public void click(By elementLocator, String LocatorName)
	{
		WebElement clickable=Driver.driver.findElement(elementLocator);
		WebDriverWait wait=new WebDriverWait(Driver.driver, 50);
		wait.until(ExpectedConditions.visibilityOf(clickable));
		wait.until(ExpectedConditions.elementToBeClickable(clickable));
		try
		{
			clickable.click();
			LogStatus.pass("Clicked on "+LocatorName);
		}
		catch(Exception e)
		{
			LogStatus.fail("Could Not Click on "+LocatorName);
			LogStatus.fail(e);
		}
	}
}
