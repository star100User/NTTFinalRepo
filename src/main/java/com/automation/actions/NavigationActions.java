package com.automation.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class NavigationActions {

    private WebDriver driver;

    public NavigationActions(WebDriver driver) {
        this.driver = driver;
    }

    // Navigate to a given URL
    public void navigateTo(String url) {
        driver.get(url);
    }

    // Get the current URL of the page
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // Get the title of the current page
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Navigate backward in browser history
    public void navigateBack() {
        driver.navigate().back();
    }

    // Navigate forward in browser history
    public void navigateForward() {
        driver.navigate().forward();
    }

    // Refresh the current page
    public void refreshPage() {
        driver.navigate().refresh();
    }

    // Navigate to a given URL using JavaScript
    public void navigateToUrlWithJavaScript(String url) {
        String script = "window.location = '" + url + "';";
        ((JavascriptExecutor) driver).executeScript(script);
    }

    // Open a new tab and navigate to the given URL using JavaScript
    public void openNewTab(String url) {
        String script = "window.open('" + url + "', '_blank');";
        ((JavascriptExecutor) driver).executeScript(script);
    }
}
