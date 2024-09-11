package com.wavekart.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExtentReportManager implements ITestListener {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    String repName;

    public void onStart(ITestContext testContext)
    {
        //String currentdatetimestamp = SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        Date date = new Date();
        String timestamp = dateFormat.format(date);//time stamp

        repName ="TestReport-"+ timestamp+".html";//report name

        sparkReporter = new ExtentSparkReporter("C:\\Users\\saidharanis_500370\\IdeaProjects\\Wavekart\\reports" + repName);//specifying the location
        sparkReporter.config().setDocumentTitle("WaveKart Automation Report");// title of the report
        sparkReporter.config().setReportName("WaveKart Functional Testing");//name of the report

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application","WaveKart");
        extent.setSystemInfo("Module","Admin");
        extent.setSystemInfo("Sub Module","Customers");
        extent.setSystemInfo("User Name",System.getProperty("user.name"));
        extent.setSystemInfo("Environment","QA");

        String os = testContext.getCurrentXmlTest().getParameter("os");
        extent.setSystemInfo("Operating System",os);

        String browser = testContext.getCurrentXmlTest().getParameter("browser");
        extent.setSystemInfo("Browser",browser);

        List<String> includedGroups =  testContext.getCurrentXmlTest().getIncludedGroups();
        if(!includedGroups.isEmpty())
        {
            extent.setSystemInfo("Groups",includedGroups.toString());
        }
    }


    public void onTestSuccess(ITestResult testResult)
    {
        test = extent.createTest(testResult.getTestClass().getName());
        test.assignCategory(testResult.getMethod().getGroups());
        test.log(Status.PASS,testResult.getName()+" got successfully executed");
    }

    public void onTestFailure(ITestResult testResult)
    {
        test = extent.createTest(testResult.getTestClass().getName());
        test.assignCategory(testResult.getMethod().getGroups());
        test.log(Status.FAIL,testResult.getName()+" got failed");
        test.log(Status.INFO, testResult.getThrowable().getMessage());
    }

    public void onTestSkipped(ITestResult testResult)
    {
        test = extent.createTest(testResult.getTestClass().getName());
        test.assignCategory(testResult.getMethod().getGroups());
        test.log(Status.SKIP, testResult.getName()+" got Skipped");
        test.log(Status.INFO, testResult.getThrowable().getMessage());
    }

    public void onTestFinish(ITestContext testContext)
    {
        extent.flush();
    }
}
