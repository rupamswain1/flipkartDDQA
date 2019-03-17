package com.test.flipkart;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.flipkart.qa.Assert.Assert;
import com.flipkart.qa.ObjectManager.ObjectManager;
import com.flipkart.qa.Reports.ExtentReport;
import com.flipkart.qa.browserOperations.OpenWebsite;
import com.flipkart.qa.driver.Driver;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.rules.AllTestRule;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class BrokenLinkTest implements AllTestRule{
	
 HomePage homePage=null;	
 static By errorText=By.xpath("//div[contains(text(),'Unfortunately the page you are looking')]") ;
  @Parameters({"browser","headless","imageDisable"})
  @BeforeTest
  @Override
  
  //Initialise browser and extent report, also start report recording
  public void InitializeBrowserAndReport(String browser, String headless, String imageDisable) {
  	ExtentReport.initialize();
  	ExtentReport.logger=ExtentReport.report.startTest("Broken Link Test");
  	Driver.initialize(browser, headless, imageDisable);
  	homePage=new HomePage();
  }
  
  @DataProvider
  //Provides list of links for test 
  public Iterator<String> dp() {
    List<String> links=homePage.findLinks();
    return links.iterator();
  }
  
  //in case HttpURLConnection class is unable to find link, we will check manually
  /*public static void CheckMaunally(String links) throws Exception
  {
	  new OpenWebsite().openUrl(links);
	  ObjectManager operation=new ObjectManager();
	  boolean resp=false;
	  if(Driver.driver.findElement(errorText).isDisplayed())
	  {
	  resp=(operation.getText(errorText).contains("Unfortunately the page you are looking"));
	  }
	  Assert.assertEquals(resp, false, links);
  }*/
  
  @Test(dataProvider = "dp")
  public void f(String links) throws Exception {	
	  /*HttpsURLConnection connection=(HttpsURLConnection)new URL(links).openConnection();
	  connection.connect();
	  try {
	  //if response is 200 then all is fine.
	  int response=connection.getResponseCode();
	  Assert.assertEquals(response, 200, links);
	  }*/
	  new OpenWebsite().openUrl(links);
	  ObjectManager operation=new ObjectManager();
	  boolean resp=false;
	  if(Driver.driver.findElements(errorText).size()>0)
	  {
	  resp=(operation.getText(errorText).contains("Unfortunately the page you are looking"));
	  }
	  System.out.println(links+"contains error?---->"+resp);
	  Assert.assertEquals(resp, false, links);
  }

  @AfterTest
  @Override
  //Close browser and End report
  public void closeBrowserandReport() {
  	// TODO Auto-generated method stub
  	ExtentReport.report.flush();
  	ExtentReport.report.endTest(ExtentReport.logger);
  	ExtentReport.report.close();
  	Driver.driver.quit();
  }
  
 


  




}
