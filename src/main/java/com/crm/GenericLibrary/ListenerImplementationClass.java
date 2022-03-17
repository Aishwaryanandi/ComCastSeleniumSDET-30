package com.crm.GenericLibrary;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.jsoup.Connection.Base;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListenerImplementationClass implements ITestListener
{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result)
	{
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"Test started+");
		
	}

	
	public void onTestSuccess(ITestResult result)
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"=====>passed");
	}

	public void onTestFailure(ITestResult result) 
	{
		String path=null;
		
		String MethodName=result.getMethod().getMethodName()+"-";
		//step 1:- Configure screenshot name
		String screenshotName = MethodName+new JavaUtility().getSystemDateInFormat();
		System.out.println(screenshotName);
		
		//step 2:-using screenshot method from webDriver Utility
		try {
			
			path=new WebdriverUtility().getscreenshot(BaseclassUtility.sdriver,screenshotName);
			//EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseclassUtility.sdriver);
			//File src=eDriver.getScreenshotAs(OutputType.FILE);
			//String pa =System.getProperty("user.dir")+"/ScreenshotName/"+screenshotName);
			//path="./Screenshot/"+screenshotName+".png";
			//File dst=new File (path);
			//FileUtils.copyFile(src, dst);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.FAIL, MethodName+"====>failed");
		//it will capture the exception and log it in the report
		test.log(Status.FAIL,result.getThrowable());
		test.addScreenCaptureFromPath(path);
		
	}

	public void onTestSkipped(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		// TODO Auto-generated method stub
		test.log(Status.SKIP, MethodName+"====>skipped");
		//it will capture the exception and log it into the report
		test.log(Status.SKIP, result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context)
	{
		//Execution will start here
		/*Configure the report*/
		 
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReports/Report"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlreport.config().setDocumentTitle("SDET-30 Execution reports");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("Selenium Execution report");
		
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base-Browser", "firefox");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("base-url", "http://localhost:8888");
		report.setSystemInfo("Reprt Name", "owner");
		
	}

	public void onFinish(ITestContext context) {
		
	}

	
	}

