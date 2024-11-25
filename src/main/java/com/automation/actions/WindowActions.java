package com.automation.actions;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowActions {

    private WebDriver driver;

    public WindowActions(WebDriver driver) {
        this.driver = driver;
    }

    // Switch to a window by its handle
    public void switchToWindow(String windowHandle) {
        if (windowHandle != null) {
            driver.switchTo().window(windowHandle);
        } else {
            System.out.println("Window handle is null, cannot switch.");
        }
    }

    // Switch to the parent window
    public void switchToParentWindow() {
        String parentWindowHandle = driver.getWindowHandle();
        if (parentWindowHandle != null) {
            driver.switchTo().window(parentWindowHandle);
        } else {
            System.out.println("No parent window found.");
        }
    }

    // Switch to the most recently opened window
    public void switchToLatestWindow() {
        Set<String> windowHandles = driver.getWindowHandles();
        if (windowHandles.size() > 1) {
            String latestWindowHandle = windowHandles.toArray(new String[0])[windowHandles.size() - 1];
            driver.switchTo().window(latestWindowHandle);
        } else {
            System.out.println("No additional windows to switch to.");
        }
    }

    // Close the current window
    public void closeCurrentWindow() {
        try {
            driver.close();
        } catch (Exception e) {
            System.out.println("Failed to close the window: " + e.getMessage());
        }
    }

    // Close all windows and quit the driver
    public void closeAllWindows() {
        try {
            driver.quit();
        } catch (Exception e) {
            System.out.println("Failed to quit the driver: " + e.getMessage());
        }
    }

    // Get the current window handle
    public String getCurrentWindowHandle() {
        return driver.getWindowHandle();
    }

    // Get all window handles
    public Set<String> getAllWindowHandles() {
        return driver.getWindowHandles();
    }

    // Maximize the current window
    public void maximizeWindow() {
        try {
            driver.manage().window().maximize();
        } catch (Exception e) {
            System.out.println("Failed to maximize the window: " + e.getMessage());
        }
    }

    // Minimize the current window (works on some browsers)
    public void minimizeWindow() {
        try {
            driver.manage().window().minimize();
        } catch (Exception e) {
            System.out.println("Failed to minimize the window: " + e.getMessage());
        }
    }

    // Resize the current window to specific width and height
    public void resizeWindow(int width, int height) {
        try {
            driver.manage().window().setSize(new org.openqa.selenium.Dimension(width, height));
        } catch (Exception e) {
            System.out.println("Failed to resize the window: " + e.getMessage());
        }
    }

    // Get the title of the current window
    public String getCurrentWindowTitle() {
        return driver.getTitle();
    }

    // Get the URL of the current window
    public String getCurrentWindowUrl() {
        return driver.getCurrentUrl();
    }
}
