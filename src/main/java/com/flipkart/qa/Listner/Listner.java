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
		
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		ExtentReport.logger.log(LogStatus.FAIL,arg0.getName());
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		ExtentReport.logger.log(LogStatus.SKIP,arg0.getName());
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		
		
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		ExtentReport.logger.log(LogStatus.PASS,arg0.getName());
		
	}

}
