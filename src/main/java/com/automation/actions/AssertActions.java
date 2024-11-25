package com.automation.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AssertActions {

    private WebDriver driver;

    public AssertActions(WebDriver driver) {
        this.driver = driver;
    }

    public void assertElementIsVisible(By locator) {
        WebElement element = driver.findElement(locator);
        Assert.assertTrue(element.isDisplayed(), "Element with locator " + locator + " is not visible.");
    }

    public void assertElementIsNotVisible(By locator) {
        WebElement element = driver.findElement(locator);
        Assert.assertFalse(element.isDisplayed(), "Element with locator " + locator + " is visible when it should not be.");
    }

    public void assertElementIsEnabled(By locator) {
        WebElement element = driver.findElement(locator);
        Assert.assertTrue(element.isEnabled(), "Element with locator " + locator + " is not enabled.");
    }

    public void assertElementIsNotEnabled(By locator) {
        WebElement element = driver.findElement(locator);
        Assert.assertFalse(element.isEnabled(), "Element with locator " + locator + " is enabled when it should not be.");
    }

    public void assertElementTextEquals(By locator, String expectedText) {
        WebElement element = driver.findElement(locator);
        String actualText = element.getText();
        Assert.assertEquals(actualText, expectedText, "Expected text: " + expectedText + " but got: " + actualText);
    }

    public void assertElementTextContains(By locator, String expectedText) {
        WebElement element = driver.findElement(locator);
        String actualText = element.getText();
        Assert.assertTrue(actualText.contains(expectedText), "Expected text to contain: " + expectedText + " but got: " + actualText);
    }

    public void assertElementIsSelected(By locator) {
        WebElement element = driver.findElement(locator);
        Assert.assertTrue(element.isSelected(), "Element with locator " + locator + " is not selected.");
    }

    public void assertElementIsNotSelected(By locator) {
        WebElement element = driver.findElement(locator);
        Assert.assertFalse(element.isSelected(), "Element with locator " + locator + " is selected when it should not be.");
    }

    public void assertPageTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Expected page title: " + expectedTitle + " but got: " + actualTitle);
    }

    public void assertPageUrl(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Expected page URL: " + expectedUrl + " but got: " + actualUrl);
    }

    public void assertElementExists(By locator) {
        WebElement element = driver.findElement(locator);
        Assert.assertNotNull(element, "Element with locator " + locator + " does not exist.");
    }

    public void assertElementDoesNotExist(By locator) {
        boolean elementPresent = driver.findElements(locator).isEmpty();
        Assert.assertTrue(elementPresent, "Element with locator " + locator + " exists when it should not.");
    }

    public void assertEquals(Object expected, Object actual) {
        if (!java.util.Objects.equals(expected, actual)) {
            throw new AssertionError("Expected: " + expected + ", but got: " + actual);
        }
    }

    public void assertNotEquals(Object unexpected, Object actual) {
        if (java.util.Objects.equals(unexpected, actual)) {
            throw new AssertionError("Unexpected value: " + unexpected + " is equal to actual value: " + actual);
        }
    }

    public void assertNull(Object obj) {
        if (obj != null) {
            throw new AssertionError("Expected null, but got: " + obj);
        }
    }

    public void assertNotNull(Object obj) {
        if (obj == null) {
            throw new AssertionError("Expected not null, but got null.");
        }
    }

    public void assertTrue(boolean condition) {
        if (!condition) {
            throw new AssertionError("Condition is false.");
        }
    }

    public void assertFalse(boolean condition) {
        if (condition) {
            throw new AssertionError("Condition is true.");
        }
    }

    public void assertGreaterThan(int expected, int actual) {
        if (actual <= expected) {
            throw new AssertionError("Expected greater than " + expected + ", but got: " + actual);
        }
    }

    public void assertLessThan(int expected, int actual) {
        if (actual >= expected) {
            throw new AssertionError("Expected less than " + expected + ", but got: " + actual);
        }
    }

    public void assertArrayEquals(Object[] expected, Object[] actual) {
        if (expected.length != actual.length) {
            throw new AssertionError("Array lengths differ. Expected: " + expected.length + ", but got: " + actual.length);
        }
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }
}
