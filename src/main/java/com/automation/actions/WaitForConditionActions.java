package com.automation.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitForConditionActions {

    private WebDriver driver;

    public WaitForConditionActions(WebDriver driver) {
        this.driver = driver;
    }

    // Helper method to create WebDriverWait
    private WebDriverWait createWait(long timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }

    // Wait for an element to be visible on the page
    public boolean waitForElementToBeVisible(WebElement element, long timeoutInSeconds) {
        try {
            WebDriverWait wait = createWait(timeoutInSeconds);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Wait for an element to be clickable
    public boolean waitForElementToBeClickable(WebElement element, long timeoutInSeconds) {
        try {
            WebDriverWait wait = createWait(timeoutInSeconds);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Wait for an element to be present in the DOM
    public boolean waitForElementToBePresent(By locator, long timeoutInSeconds) {
        try {
            WebDriverWait wait = createWait(timeoutInSeconds);
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Wait for an element's text to match the expected value
    public boolean waitForElementTextToBe(WebElement element, String expectedText, long timeoutInSeconds) {
        try {
            WebDriverWait wait = createWait(timeoutInSeconds);
            wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Wait for an element's text to contain the expected value
    public boolean waitForElementTextToContain(WebElement element, String expectedText, long timeoutInSeconds) {
        try {
            WebDriverWait wait = createWait(timeoutInSeconds);
            wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Wait for an alert to be present
    public boolean waitForAlertToBePresent(long timeoutInSeconds) {
        try {
            WebDriverWait wait = createWait(timeoutInSeconds);
            wait.until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Wait for the page title to match the expected title
    public boolean waitForPageTitleToBe(String expectedTitle, long timeoutInSeconds) {
        try {
            WebDriverWait wait = createWait(timeoutInSeconds);
            wait.until(ExpectedConditions.titleIs(expectedTitle));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Wait for the page URL to match the expected URL
    public boolean waitForPageUrlToBe(String expectedUrl, long timeoutInSeconds) {
        try {
            WebDriverWait wait = createWait(timeoutInSeconds);
            wait.until(ExpectedConditions.urlToBe(expectedUrl));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Wait for an element to become invisible (not displayed)
    public boolean waitForElementToBeInvisible(WebElement element, long timeoutInSeconds) {
        try {
            WebDriverWait wait = createWait(timeoutInSeconds);
            wait.until(ExpectedConditions.invisibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Wait for the element's attribute value to be as expected
    public boolean waitForElementAttributeToBe(WebElement element, String attribute, String expectedValue,
                                               long timeoutInSeconds) {
        try {
            WebDriverWait wait = createWait(timeoutInSeconds);
            wait.until(ExpectedConditions.attributeToBe(element, attribute, expectedValue));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Wait for the element to contain a certain CSS value (Fixed issue)
    public boolean waitForElementCssValueToBe(WebElement element, String property, String expectedValue,
                                               long timeoutInSeconds) {
        try {
            WebDriverWait wait = createWait(timeoutInSeconds);
            wait.until(ExpectedConditions.attributeToBe(element, "style", expectedValue));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Wait for the URL to contain a specific string
    public boolean waitForUrlToContain(String urlSubstring, long timeoutInSeconds) {
        try {
            WebDriverWait wait = createWait(timeoutInSeconds);
            wait.until(ExpectedConditions.urlContains(urlSubstring));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Custom wait for a condition to be met (flexible)
    public boolean customWaitForCondition(long timeoutInSeconds, String condition, By locator) {
        try {
            WebDriverWait wait = createWait(timeoutInSeconds);
            switch (condition.toLowerCase()) {
                case "visibility":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                    break;
                case "alert":
                    wait.until(ExpectedConditions.alertIsPresent());
                    break;
                case "pageTitle":
                    wait.until(ExpectedConditions.titleIs("Expected Page Title"));
                    break;
                case "pageUrl":
                    wait.until(ExpectedConditions.urlToBe("https://example.com"));
                    break;
                default:
                    System.out.println("Unknown condition");
                    return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
