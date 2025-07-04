package com.entrata.automation.testcomponents;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.entrata.automation.utils.CommonUtils;

public class Listeners implements ITestListener {

	private static final Logger logger = LogManager.getLogger(Listeners.class);
	ExtentReports extent = CommonUtils.getReportObject();
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		logger.info("Test started: " + result.getMethod().getMethodName());
		test = extent.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		logger.info("Test passed: " + result.getMethod().getMethodName());
		test.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		logger.error("Test FAILED: " + result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());

		// Take screenshot
		try {

			CommonUtils.captureScreenshot(BaseTest.getDriver(), result.getMethod().getMethodName());
			logger.info("Screenshot captured for failed test: " + result.getMethod().getMethodName());
		} catch (Exception e) {
			logger.error("Error capturing screenshot: " + e.getMessage());
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		logger.warn("Test skipped: " + result.getMethod().getMethodName());
		test.log(Status.SKIP, "Test Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
		logger.info("Starting Test Suite: " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		logger.info("Finished Test Suite: " + context.getName());
		extent.flush();
	}

}
