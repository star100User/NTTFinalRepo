package com.automation.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerificationActions {

    private WebDriver driver;
    private FindElementActions findElementActions;

    public VerificationActions(WebDriver driver) {
        this.driver = driver;
        this.findElementActions = new FindElementActions(driver); // Initialize FindElementActions
    }

    // Verifies if an element is displayed on the page using a locator
    public boolean isElementVisible(By locator) {
        try {
            WebElement element = findElementActions.findElement(locator); // Find element using locator
            return element != null && element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Verifies if an element is enabled on the page using a locator
    public boolean isElementEnabled(By locator) {
        try {
            WebElement element = findElementActions.findElement(locator); // Find element using locator
            return element != null && element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    // Verifies if an element is selected (useful for checkboxes, radio buttons) using a locator
    public boolean isElementSelected(By locator) {
        try {
            WebElement element = findElementActions.findElement(locator); // Find element using locator
            return element != null && element.isSelected();
        } catch (Exception e) {
            return false;
        }
    }

    // Verifies if an element exists on the page using a locator
    public boolean isElementPresent(By locator) {
        try {
            WebElement element = findElementActions.findElement(locator); // Find element using locator
            return element != null && element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Verifies if the element's text matches the expected value using a locator
    public boolean verifyElementText(By locator, String expectedText) {
        try {
            WebElement element = findElementActions.findElement(locator); // Find element using locator
            return element != null && element.getText().equals(expectedText);
        } catch (Exception e) {
            return false;
        }
    }

    // Verifies if the element's attribute matches the expected value using a locator
    public boolean verifyElementAttribute(By locator, String attribute, String expectedValue) {
        try {
            WebElement element = findElementActions.findElement(locator); // Find element using locator
            String actualValue = element.getAttribute(attribute);
            return actualValue != null && actualValue.equals(expectedValue);
        } catch (Exception e) {
            return false;
        }
    }

    // Verifies if the page title matches the expected title
    public boolean verifyPageTitle(String expectedTitle) {
        try {
            String actualTitle = driver.getTitle();
            return actualTitle.equals(expectedTitle);
        } catch (Exception e) {
            return false;
        }
    }

    // Verifies if the page URL matches the expected URL
    public boolean verifyPageUrl(String expectedUrl) {
        try {
            String actualUrl = driver.getCurrentUrl();
            return actualUrl.equals(expectedUrl);
        } catch (Exception e) {
            return false;
        }
    }

    // Verifies if an element's text contains the expected text (partial match) using a locator
    public boolean verifyElementTextContains(By locator, String expectedText) {
        try {
            WebElement element = findElementActions.findElement(locator); // Find element using locator
            return element != null && element.getText().contains(expectedText);
        } catch (Exception e) {
            return false;
        }
    }

    // Verifies if an element's CSS value matches the expected value using a locator
    public boolean verifyElementCssValue(By locator, String property, String expectedValue) {
        try {
            WebElement element = findElementActions.findElement(locator); // Find element using locator
            String actualValue = element.getCssValue(property);
            return actualValue != null && actualValue.equals(expectedValue);
        } catch (Exception e) {
            return false;
        }
    }

    // Verifies if an element is not displayed on the page using a locator
    public boolean isElementNotVisible(By locator) {
        try {
            WebElement element = findElementActions.findElement(locator); // Find element using locator
            return element == null || !element.isDisplayed();
        } catch (Exception e) {
            return true; // Element not found means it's not visible
        }
    }
}
