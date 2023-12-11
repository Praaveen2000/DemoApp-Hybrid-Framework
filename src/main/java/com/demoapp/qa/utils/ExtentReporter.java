package com.demoapp.qa.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.demoapp.qa.baseClass.BaseClass;

public class ExtentReporter extends BaseClass {
	
	static ExtentReports extentReport;
	
	public static ExtentReports getInstance()
	{
		if(extentReport == null)
			extentReport = generateExtentReport();
		
		return extentReport;
	}
	
	public static ExtentReports generateExtentReport()
	{
		extentReport = new ExtentReports();
		
		ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/report_"+Utilities.TimeStamp()+".html");
		
		spark.config().setTheme(Theme.DARK);
		
		spark.config().setReportName("DemoApp Test Automation Report");
		
		spark.config().setDocumentTitle("DemoApp Framework Report");
		
		spark.config().setTimeStampFormat(Utilities.TimeStamp());
		
		extentReport.attachReporter(spark);
		
		extentReport.setSystemInfo("Application URL", readFromProperties("url"));
		
		extentReport.setSystemInfo("Browser", readFromProperties("browserName"));
		
		extentReport.setSystemInfo("OS", System.getProperty("os.name"));
		
		extentReport.setSystemInfo("Author", System.getProperty("user.name"));
		
		extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
		
		return extentReport;
	}	

}
