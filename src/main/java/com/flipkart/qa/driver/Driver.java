package com.flipkart.qa.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.flipkart.qa.ReadOperation.ReadPropertyFile;
import com.flipkart.qa.Reports.ExtentReport;
import com.flipkart.qa.Reports.LogStatus;
import com.flipkart.qa.browserOperations.OpenWebsite;

public class Driver extends ReadPropertyFile
{
	public static WebDriver driver=null;
	
	private Driver()
	{
		
		try
		{
			ReadPropertyFile read =new ReadPropertyFile();
			System.setProperty("webdriver.chrome.driver",read.readProperty("chromeDriverPath"));
			driver=new ChromeDriver();
			LogStatus.pass("Chrome driver launched");
			driver.manage().window().maximize();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			new OpenWebsite().openUrl((read.readProperty("url")));
			
		}
		catch(Exception e)
		{
			LogStatus.fail(e);;
		}
		
	}
	
	private Driver(String browser, String headless, String imageDisable)
	{
		if(browser.equalsIgnoreCase("chrome")|| browser.toUpperCase().contains("CHROME"))
		{
			try{
				ReadPropertyFile read =new ReadPropertyFile();
				System.setProperty("webdriver.chrome.driver",read.readProperty("chromeDriverPath"));
				ChromeOptions options=new ChromeOptions();
				if(imageDisable.equalsIgnoreCase("yes"))
				{
					new DisableImage().disableImg(options);
				}
				if(headless.equalsIgnoreCase("yes"))
				{
					new HeadlessMode().headless(options);
				}
				driver=new ChromeDriver(options);
				LogStatus.pass("Chrome drive launched with headless mode = "+headless.toUpperCase()+", Image Disable mode = "+imageDisable.toUpperCase());
				driver.manage().window().maximize();
				new OpenWebsite().openUrl((read.readProperty("url")));
				
			}
			catch (Exception e)
			{
				LogStatus.fail(e);
			}
		}
		else if (browser.equalsIgnoreCase("FF")|| browser.toUpperCase().contains("FIRE")) 
		{
			try
			{
				ReadPropertyFile read =new ReadPropertyFile();
				//System.out.println(read.readProperty("FirefoxDriverPath"));
				System.setProperty("webdriver.gecko.driver",read.readProperty("FirefoxDriverPath"));
				FirefoxOptions FFoptions=new FirefoxOptions();
				if(imageDisable.equalsIgnoreCase("yes"))
				{
					new DisableImage().disableImg(FFoptions);
				}
				if(headless.equalsIgnoreCase("yes"))
				{
					new HeadlessMode().headless(FFoptions);
				}
				driver=new FirefoxDriver(FFoptions);
				driver.manage().window().maximize();
				LogStatus.pass("FF drive launched with headless mode = "+headless.toUpperCase()+", Image Disable mode = "+imageDisable.toUpperCase());
				new OpenWebsite().openUrl((read.readProperty("url")));
				
			}
			catch(Exception e)
			{
				LogStatus.fail(e);
			}
		}
	}
	
	
	public static void initialize()
	{
		Driver d=new Driver();
	}
	
	public static void initialize(String browser, String headless, String ImageDisable)
	{
		Driver d= new Driver(browser, headless, ImageDisable);
	}
}
