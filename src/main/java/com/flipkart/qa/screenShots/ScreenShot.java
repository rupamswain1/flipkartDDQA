package com.flipkart.qa.screenShots;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.flipkart.qa.driver.Driver;

public class ScreenShot 
{
	public static String getScreenshot()
	{
		 String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		 TakesScreenshot ts = (TakesScreenshot) Driver.driver;
		 File source = ts.getScreenshotAs(OutputType.FILE);
		 
		 String destination = System.getProperty("user.dir") + "/ExtentReports/failedScreenShot"+dateName+".png";
		 File finalDestination = new File(destination);
		 try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		                //Returns the captured file path
		 return destination;
	}
}