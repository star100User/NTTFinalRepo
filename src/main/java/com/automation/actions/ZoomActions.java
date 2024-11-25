package com.automation.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class ZoomActions {

    private WebDriver driver;

    public ZoomActions(WebDriver driver) {
        this.driver = driver;
    }

    // Zoom in the browser window by simulating pressing 'Ctrl' + '+'
    public void zoomIn() {
        try {
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD)).perform();
        } catch (Exception e) {
            System.out.println("Zoom In failed: " + e.getMessage());
        }
    }

    // Zoom out the browser window by simulating pressing 'Ctrl' + '-'
    public void zoomOut() {
        try {
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT)).perform();
        } catch (Exception e) {
            System.out.println("Zoom Out failed: " + e.getMessage());
        }
    }

    // Reset the zoom level by simulating pressing 'Ctrl' + '0' (default zoom)
    public void resetZoom() {
        try {
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.chord(Keys.CONTROL, "0")).perform();
        } catch (Exception e) {
            System.out.println("Reset Zoom failed: " + e.getMessage());
        }
    }

    // Set a custom zoom level using JavaScript (e.g., 120% for zoom in)
    public void setZoomLevel(int zoomPercentage) {
        try {
            String script = "document.body.style.zoom = '" + zoomPercentage + "%';";
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript(script);
        } catch (Exception e) {
            System.out.println("Set Zoom Level failed: " + e.getMessage());
        }
    }

    // Get the current zoom level using JavaScript (works in some browsers)
    public String getZoomLevel() {
        try {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            String zoom = (String) jsExecutor.executeScript("return document.body.style.zoom;");
            return zoom != null ? zoom : "default";  // If zoom is not set, return "default"
        } catch (Exception e) {
            System.out.println("Get Zoom Level failed: " + e.getMessage());
            return "default";
        }
    }

    // Reset zoom using JavaScript (resets to default zoom)
    public void resetZoomUsingJS() {
        try {
            String script = "document.body.style.zoom = '100%';";
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript(script);
        } catch (Exception e) {
            System.out.println("Reset Zoom using JS failed: " + e.getMessage());
        }
    }
}
