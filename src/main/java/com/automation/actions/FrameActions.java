package com.automation.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameActions {

    private WebDriver driver;

    public FrameActions(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToFrameByIndex(int index) {
        driver.switchTo().frame(index);
    }

    public void switchToFrameByNameOrId(String nameOrId) {
        driver.switchTo().frame(nameOrId);
    }

    public void switchToFrameByWebElement(WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void switchToNestedFrame(By outerFrameLocator, By innerFrameLocator) {
        driver.switchTo().frame(driver.findElement(outerFrameLocator));
        driver.switchTo().frame(driver.findElement(innerFrameLocator));
    }

    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }
}
