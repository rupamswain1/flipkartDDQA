package com.flipkart.qa.Listner;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.flipkart.qa.Reports.ExtentReport;
import com.relevantcodes.extentreports.LogStatus;

public class Listner implements ITestListener
{

	@Override
	public void onFinish(ITestContext arg0) 
	{
		
		ExtentReport.report.endTest(ExtentReport.logger);
		ExtentReport.report.flush();
		ExtentReport.report.close();
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		ExtentReport.initialize();
		ExtentReport.logger= ExtentReport.report.startTest(arg0.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		com.flipkart.qa.Reports.LogStatus.fail("Test case failed");
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		
		
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		/*System.out.println("listner prin**********************************************");
		System.out.println(arg0.getStatus());
		System.out.println(arg0.getInstance());
		System.out.println(arg0.getTestName());
		System.out.println(arg0.getTestContext());
		System.out.println(arg0.SUCCESS);*/
		
	}

}
