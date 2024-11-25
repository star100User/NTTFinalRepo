package com.automation.listner;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automation.baseClasses.DriverMethods;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerTest implements ITestListener {

    private static ExtentReports reports;  // Make sure this is static for thread-safe usage
    private ExtentTest test;
    private static ThreadLocal<ExtentTest> extentTextThread = new ThreadLocal<>();
    private static final String REPORTS_PATH = System.getProperty("user.dir") + "/TDDReports/";
    private static final String SCREENSHOTS_PATH = System.getProperty("user.dir") + "/screenshots/";
    public static WebDriver driver = DriverMethods.INIT();  // Assuming this is already correctly initialized elsewhere

    @Override
    public void onStart(ITestContext context) {
        clearDirectory(REPORTS_PATH);
        clearDirectory(SCREENSHOTS_PATH);

        String currentDateTime = getCurrentTimestamp();
        String reportFilePath = REPORTS_PATH + "ExtentReport_" + currentDateTime + ".html";

        // Initialize the ExtentHtmlReporter and set it up
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportFilePath);
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Test Execution Report");
        htmlReporter.config().setTheme(Theme.STANDARD);

        // Initialize the ExtentReports object and attach the HTML Reporter
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);
        reports.setSystemInfo("Environment", "QA");
        reports.setSystemInfo("Tester", "Arti Lohar");
        reports.setSystemInfo("DOE", "21-11-2024");
    }

    @Override
    public void onFinish(ITestContext context) {
        reports.flush();
        DriverMethods.QUIT();
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        test = reports.createTest(testName);
        
        extentTextThread.set(test);
        extentTextThread.get().log(Status.INFO, "Test Started => " + testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        extentTextThread.get().log(Status.PASS, "Test Passed => " + testName);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // logging in report
        String testName = result.getMethod().getMethodName();
        extentTextThread.get().log(Status.FAIL, "Test Failed => " + testName);
        extentTextThread.get().log(Status.FAIL, result.getThrowable());

        // Screenshot capture
        String screenshotPath = captureScreenshot(testName);
        if (screenshotPath != null) {
            try {
                extentTextThread.get().addScreenCaptureFromPath(screenshotPath);
            } catch (IOException e) {
                // Handle exception
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        extentTextThread.get().log(Status.SKIP, "Test Case Skipped: " + testName);
        extentTextThread.get().log(Status.SKIP, result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // No custom action needed
    }

    private String captureScreenshot(String testName) {
        String screenshotPath = SCREENSHOTS_PATH + testName + "_" + getCurrentTimestamp() + ".png";
        File screenshotDir = new File(SCREENSHOTS_PATH);

        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
        }

        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(screenshotPath));
            return screenshotPath;
        } catch (IOException e) {
            System.err.println("Error capturing screenshot: " + e.getMessage());
        }
        return null;
    }

    private String getCurrentTimestamp() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

    private void clearDirectory(String path) {
        try {
            FileUtils.cleanDirectory(new File(path));
        } catch (IOException e) {
            System.err.println("Error clearing directory " + path + ": " + e.getMessage());
        }
    }
}
