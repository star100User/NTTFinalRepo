package com.automation.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenshotActions {

    private WebDriver driver;
    private FindElementActions findElementActions;

    public ScreenshotActions(WebDriver driver) {
        this.driver = driver;
        this.findElementActions = new FindElementActions(driver);  // Initialize the FindElementActions class
    }

    // Take a screenshot of the entire page
    public void takeScreenshot(String filePath) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(filePath);
        try {
            FileHandler.copy(srcFile, destFile);
        } catch (IOException e) {
            System.out.println("Error while saving screenshot: " + e.getMessage());
        }
    }

    // Take a screenshot of a specific element located by a By locator
    public void takeElementScreenshot(By locator, String filePath) {
        WebElement element = findElementActions.findElement(locator);  // Find the element by locator
        File srcFile = element.getScreenshotAs(OutputType.FILE);
        File destFile = new File(filePath);
        try {
            FileHandler.copy(srcFile, destFile);
        } catch (IOException e) {
            System.out.println("Error while saving element screenshot: " + e.getMessage());
        }
    }

    // Capture screenshot as a byte array (useful for attaching to reports, etc.)
    public byte[] captureScreenshotAsByteArray() {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        return screenshot.getScreenshotAs(OutputType.BYTES);
    }

    // Capture screenshot as a File (useful for saving as files directly)
    public File captureScreenshotAsFile() {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        return screenshot.getScreenshotAs(OutputType.FILE);
    }

    // Capture a screenshot of a specific element by locator and save it as a file
    public void captureElementScreenshotAsFile(By locator, String filePath) {
        WebElement element = findElementActions.findElement(locator);  // Find the element by locator
        File srcFile = element.getScreenshotAs(OutputType.FILE);
        File destFile = new File(filePath);
        try {
            FileHandler.copy(srcFile, destFile);
        } catch (IOException e) {
            System.out.println("Error while saving element screenshot: " + e.getMessage());
        }
    }
}
