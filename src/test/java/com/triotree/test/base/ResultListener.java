package com.triotree.test.base;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.triotree.driver.website.TTWebsiteDriver;



public class ResultListener extends TTBaseTest implements ITestListener {

	private static final Logger logger = LogManager.getLogger(ResultListener.class.getName());
	@Override
	public void onStart(ITestContext context) 
	{
		//DOMConfigurator.configure("log4j.xml");			
	}

	@Override
	public void onTestStart(ITestResult result) 
	{
		getTestMethodName(result);	
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		//logger.endTestCase(getTestMethodName(result));
		test.log(Status.PASS, MarkupHelper.createLabel(getTestMethodName(result)+": Test Case Passed: ", ExtentColor.GREEN));
		test.pass("Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		logger.info(getTestMethodName(result)+ " Test failed");
		logger.error("Test failed due to : ", result.getThrowable());
		test.log(Status.FAIL, MarkupHelper.createLabel(getTestMethodName(result)+": Test Case Failed due to below issues: ", ExtentColor.RED));
		test.fail(result.getThrowable());
		String screenShotPath = "";
		try {
			screenShotPath = TTWebsiteDriver.takeSnapShotAndRetPath(getTestMethodName(result));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			test.addScreenCaptureFromPath(screenShotPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getTestMethodName(ITestResult result) 
	{
		return result.getMethod().getConstructorOrMethod().getName();
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		logger.info(getTestMethodName(result)+ " test case skipped");
		test.log(Status.SKIP, MarkupHelper.createLabel(getTestMethodName(result)+": Test Case Skipped: ", ExtentColor.ORANGE));
		test.skip(result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		// TODO Auto-generated method stub		
	}	

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
