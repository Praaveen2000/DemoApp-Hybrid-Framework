package com.demoapp.qa.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.demoapp.qa.baseClass.BaseClass;
import com.demoapp.qa.utils.ExtentReporter;
import com.demoapp.qa.utils.Utilities;

public class TestListeners implements ITestListener{

	ExtentReports extentReport;
	
	ThreadLocal<ExtentTest> parentTest;
	
	ExtentTest extentTest;
	
	public void onStart(ITestContext context) {
		
		extentReport = ExtentReporter.getInstance();
		
		parentTest = new ThreadLocal<>();
	}
	
	public void onTestStart(ITestResult result) {
		
		extentTest = extentReport.createTest(result.getMethod().getMethodName());
		
		parentTest.set(extentTest);
	}

	public void onTestSuccess(ITestResult result) {
		
		parentTest.get().pass("Test passed", MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.takeScreenShotInBase64(BaseClass.getBrowserInstance())).build());
	}

	public void onTestFailure(ITestResult result) {
	
		parentTest.get().fail("Test Failed: "+ result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.takeScreenShotInBase64(BaseClass.getBrowserInstance())).build());
	}

	public void onTestSkipped(ITestResult result) {
		
		parentTest.get().skip("Test Skipped: "+ result.getThrowable());
	}
	
	public void onFinish(ITestContext context) {
		
		extentReport.flush();
	}
	
	

}
