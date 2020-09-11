package com.streams.reports;

import com.streams.Base.BaseClass;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;

public class ExtentReportNG extends BaseClass {
    /**
     * Generate Extent Report
     * @name extentReportGenerator
     * @return ExtentReports
     */
    public static ExtentReports extentReportGenerator(){
        String resultPath = System.getProperty("user.dir")+"/reports/report.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(resultPath);
        reporter.config().setReportName("Java Streams in Selenium");
        reporter.config().setDocumentTitle("Test Results");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Raman");
        extent.setSystemInfo("Environment","Local");
        return extent;
    }
}
