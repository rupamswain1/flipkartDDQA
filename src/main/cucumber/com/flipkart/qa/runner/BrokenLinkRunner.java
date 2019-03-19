package com.flipkart.qa.runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


@CucumberOptions(
		features="F:\\workspace\\flipkartQA\\src\\main\\cucumber\\com\\flipkart\\qa\\feature\\brokenLink.feature",
		glue= {"com.flipkart.qa.stepDefination"},
		plugin=
			{"pretty",
			"html:test-output",
			"json:test-output/CucumberTestReport.json",
			"rerun:test-output/re-run.txt"}
		
		)
public class BrokenLinkRunner {
	
	TestNGCucumberRunner testRunner;
	
	@BeforeClass
	public void initialize()
	{
		testRunner=new TestNGCucumberRunner(BrokenLinkRunner.class);
	}
	
	@Test(dataProvider="features",description="broken link test")
	public void bLTest(CucumberFeatureWrapper cFeature)
	{
		testRunner.runCucumber(cFeature.getCucumberFeature());
	}

	@DataProvider
	public Object[][] features()
	{
		return testRunner.provideFeatures();
	}
	
	@AfterClass
	public void done()
	{
		System.out.println("complete");
	}
}
