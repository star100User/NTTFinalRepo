package com.automation.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollActions {

    private WebDriver driver;
    private FindElementActions findElementActions;

    public ScrollActions(WebDriver driver) {
        this.driver = driver;
        this.findElementActions = new FindElementActions(driver);  // Initialize the FindElementActions class
    }

    // Scroll to the top of the page
    public void scrollToTop() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 0);");
    }

    // Scroll to the bottom of the page
    public void scrollToBottom() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    // Scroll by specified x and y values
    public void scrollBy(int x, int y) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }

    // Scroll to a specific element using its locator (By locator)
    public void scrollToElement(By locator) {
        WebElement element = findElementActions.findElement(locator);  // Find the element by locator
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Scroll to a specific element and center it on the screen using its locator (By locator)
    public void scrollIntoView(By locator) {
        WebElement element = findElementActions.findElement(locator);  // Find the element by locator
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
    }

    // Scroll to a specific position on the page (x, y)
    public void scrollToPosition(int x, int y) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(arguments[0], arguments[1]);", x, y);
    }
}
