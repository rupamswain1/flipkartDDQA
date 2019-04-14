package com.test.flipkart;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.flipkart.qa.Listner.Listner;
import com.flipkart.qa.Reports.ExtentReport;
import com.flipkart.qa.driver.Driver;
@Listeners(com.flipkart.qa.Listner.Listner.class)
public class test {
	
	static Logger log=Logger.getLogger("test");
	
	@BeforeSuite
	public void init()
	{
		log=Logger.getLogger("test");
		log.info("abcs");
		ExtentReport.initialize();
		ExtentReport.logger= ExtentReport.report.startTest("abc");
		Driver.initialize("chrome","yes","yes");
		
	}
	
	@Test(priority=1)
	public void pqr()
	{
		Assert.assertEquals(true, true);
		Assert.assertEquals("A", "A");
		System.out.println("true");
	}
	
	@Test(testName="Demo Test")
	public void abc() throws InterruptedException {
		// TODO Auto-generated method stub
	/*	System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://flipkart.com/");*/
		Assert.assertEquals(true, true);
		Assert.assertEquals("A", "A");
		System.out.println("true");
		/*Driver.driver.manage().window().maximize();
		Driver.driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);*/
		Driver.driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		Driver.driver.findElement(By.xpath("//input[@class='LM6RPg']")).clear();
		Driver.driver.findElement(By.xpath("//input[@class='LM6RPg']")).sendKeys("boat bluetooth speakers");
		Assert.assertEquals(true, true);
		Driver.driver.findElement(By.xpath("//button[@class='vh79eN']")).click();
		Driver.driver.findElement(By.xpath("//div[@class='_2yccxO D0YrLF' and text()='Brand']")).click();
		Driver.driver.findElement(By.xpath("//div[@title='boAt']//div[@class='_1p7h2j']")).click();
		Driver.driver.findElement(By.xpath("//div[@class='_1xHtJz' and text()='Price -- Low to High']")).click();
		/*List<WebElement> cols=driver.findElements(By.xpath("//div[@class='bhgxx2 col-12-12']//div[@class='_3O0U0u']"));
		for(int i=0;i<cols.size();i++)
		{
			List<WebElement> item=cols.get(i).findElements(By.tagName("img"));
			System.out.println(item.size());
		}*/
		Driver.driver.findElement(By.xpath("(//div[@class='_3liAhj _1R0K0g'])[4]")).click();
		Thread.sleep(1000);
		ArrayList<String> tabs = new ArrayList<String>(Driver.driver.getWindowHandles());
		Driver.driver.switchTo().window(tabs.get(1));
		System.out.println(Driver.driver.getTitle());
		System.out.println(Driver.driver.findElement(By.xpath("//span[@class='_35KyD6']")).getText());
		System.out.println(Driver.driver.findElement(By.xpath("//div[@class='_1vC4OE _3qQ9m1']")).getText());
		Driver.driver.findElement(By.xpath("//input[@class='_3X4tVa']")).sendKeys("411057");
		Driver.driver.findElement(By.xpath("//span[@class='_2aK_gu']")).click();
		Thread.sleep(5000);
		System.out.println(Driver.driver.findElement(By.xpath("//div[@class='_29Zp1s']")).getText());
		System.out.println(Driver.driver.findElement(By.xpath("//span[@class='_3nCwDW']")).getText());
		
		
		
	}

	@AfterSuite
	public void end()
	{
		/*ExtentReport.report.endTest(ExtentReport.logger);
		ExtentReport.report.flush();
		ExtentReport.report.close();*/
	}
}
