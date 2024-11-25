package com.automation.actions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindElementActions {

    private WebDriver driver;

    public FindElementActions(WebDriver driver) {
        this.driver = driver;
    }

    // Find a single element
    public WebElement findElement(By locator) {
        try {
            return driver.findElement(locator);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Element not found with locator: " + locator.toString());
        }
    }

    // Find an element and wait for it to be clickable
    public WebElement findElementAndWaitForClickable(By locator, Duration timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException e) {
            throw new TimeoutException("Element not clickable after waiting for " + timeoutInSeconds
                    + " seconds with locator: " + locator.toString());
        }
    }

    // Find an element and wait for its presence in the DOM
    public WebElement findElementAndWaitForPresence(By locator, Duration timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (TimeoutException e) {
            throw new TimeoutException("Element not present in the DOM after waiting for " + timeoutInSeconds
                    + " seconds with locator: " + locator.toString());
        }
    }

    // Find an element and wait for it to be visible
    public WebElement findElementAndWaitForVisible(By locator, Duration timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            throw new TimeoutException("Element not visible after waiting for " + timeoutInSeconds
                    + " seconds with locator: " + locator.toString());
        }
    }

    // Find all elements matching the locator
    public List<WebElement> findElements(By locator) {
        try {
            return driver.findElements(locator);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Elements not found with locator: " + locator.toString());
        }
    }

    // Find an element and get its text
    public String getElementText(By locator) {
        WebElement element = findElement(locator);
        return element.getText();
    }

    // Find an element and get its attribute value
    public String getElementAttribute(By locator, String attribute) {
        WebElement element = findElement(locator);
        return element.getAttribute(attribute);
    }

    // Find an element and check if it is displayed
    public boolean isElementDisplayed(By locator) {
        WebElement element = findElement(locator);
        return element.isDisplayed();
    }

    // Find an element and check if it is enabled
    public boolean isElementEnabled(By locator) {
        WebElement element = findElement(locator);
        return element.isEnabled();
    }

    // Find an element and check if it is selected (useful for checkboxes, radio buttons)
    public boolean isElementSelected(By locator) {
        WebElement element = findElement(locator);
        return element.isSelected();
    }
}
