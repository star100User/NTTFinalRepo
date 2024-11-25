package com.automation.actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitActions {

    private WebDriver driver;

    public WaitActions(WebDriver driver) {
        this.driver = driver;
    }

    // Implicit wait for a specified amount of time
    public void implicitWait(long timeInSeconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
    }

    // Explicit wait for an element to be visible
    public void waitForElementToBeVisible(By locator, long timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Explicit wait for an element to be clickable
    public void waitForElementToBeClickable(By locator, long timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Explicit wait for an element to be present in the DOM
    public void waitForElementToBePresent(By locator, long timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Wait for a specific text to appear within an element
    public void waitForTextToBePresentInElement(By locator, String text, long timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    // Wait for the title of the page to be a specific string
    public void waitForTitleToBe(String title, long timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.titleIs(title));
    }

    // Wait for the page URL to be a specific string
    public void waitForUrlToBe(String url, long timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    // Wait for the element to disappear (not visible)
    public void waitForElementToDisappear(By locator, long timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    // Wait for an element to contain a specific text
    public void waitForElementToContainText(By locator, String text, long timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    // Wait for an alert to be present
    public void waitForAlertToBePresent(long timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    
    public void waitForFrameToBePresent(WebElement frame,long timeInSeconds) {
    	
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
    }
    
    public void waitForPageLoad(long timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }
    

    // Custom wait for a specific condition (useful for complex conditions)
    public void customWait(long timeInSeconds, String condition) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        switch (condition) {
            case "alert":
                wait.until(ExpectedConditions.alertIsPresent());
                break;
            case "url":
                wait.until(ExpectedConditions.urlContains("specific-url-part"));
                break;
            case "element":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId")));
                break;
            // Add more conditions as needed
            default:
                System.out.println("No matching condition found!");
        }
    }
}
