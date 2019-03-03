package com.flipkart.qa.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.flipkart.qa.ReadOperation.ReadPropertyFile;
import com.flipkart.qa.browserOperations.OpenWebsite;

public class Driver extends ReadPropertyFile
{
	public static WebDriver driver=null;
	
	private Driver()
	{
		System.out.println("launch");
		ReadPropertyFile read =new ReadPropertyFile();
		System.setProperty("webdriver.chrome.driver",read.readProperty("chromeDriverPath"));
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		new OpenWebsite().openUrl((read.readProperty("url")));
		
	}
	
	private Driver(String browser, String headless, String ImageDisable)
	{
		if(browser.equalsIgnoreCase("chrome")|| browser.toUpperCase().contains("CHROME"))
		{
			ReadPropertyFile read =new ReadPropertyFile();
			System.setProperty("webdriver.chrome.driver",read.readProperty("chromeDriverPath"));
			ChromeOptions options=new ChromeOptions();
			if(ImageDisable.equalsIgnoreCase("yes"))
			{
				new DisableImage().disableImg(options);
			}
			if(headless.equalsIgnoreCase("yes"))
			{
				new HeadlessMode().headless(options);
			}
			driver=new ChromeDriver(options);
			new OpenWebsite().openUrl((read.readProperty("url")));
		}
		else if (browser.equalsIgnoreCase("FF")|| browser.toUpperCase().contains("FIRE")) 
		{
			ReadPropertyFile read =new ReadPropertyFile();
			System.setProperty("webdriver.gecko.driver",read.readProperty("FirefoxDriverPath"));
			FirefoxOptions options=new FirefoxOptions();
			if(ImageDisable.equalsIgnoreCase("yes"))
			{
				new DisableImage().disableImg(options);
			}
			if(headless.equalsIgnoreCase("yes"))
			{
				new HeadlessMode().headless(options);
			}
			driver=new FirefoxDriver(options);
			new OpenWebsite().openUrl((read.readProperty("url")));
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
