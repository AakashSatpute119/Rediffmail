package Loginpagetest;


import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReportsclass;
    
public class Listener extends Base implements ITestListener {
	ExtentReports extent = ExtentReportsclass.getExReports();
	ExtentTest test;
	
	
	@Override
	public void onStart(ITestContext arg0) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		 WebDriver driver=null;
		 String Failedmethodname =arg0.getMethod().getMethodName();
		try {
			driver=(WebDriver)arg0.getTestClass().getRealClass().getDeclaredField("driver").get(arg0.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		Screenshot(Failedmethodname, driver);
		test.log(Status.FAIL, "Failed");
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// give report life to each test start 
		 test=extent.createTest(arg0.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// on each test pass log
		test.log(Status.PASS, "Passed");
		// this status will be update in report 
		
	}
	@Override
	public void onFinish(ITestContext arg0) {
		// flush the extent capacity after test folder is completed 
		extent.flush();
	}


}
