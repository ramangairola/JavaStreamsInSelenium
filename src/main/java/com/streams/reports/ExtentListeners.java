package com.streams.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.streams.Base.BaseClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.streams.Utils.Utilts.captureAsBase64;

public class ExtentListeners extends BaseClass implements ITestListener {
    ExtentReports extent = ExtentReportNG.extentReportGenerator();
    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test case failed is : "+result.getName());
        test.log(Status.FAIL, "Test case failed info : "+result.getThrowable());
        test.addScreenCaptureFromBase64String(captureAsBase64());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test case passed is : "+result.getName());
        test.addScreenCaptureFromBase64String(captureAsBase64());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test case  : "+result.getName()+" is skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
