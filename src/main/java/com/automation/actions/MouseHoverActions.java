package com.automation.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverActions {

    private WebDriver driver;
    private FindElementActions findElementActions;

    public MouseHoverActions(WebDriver driver) {
        this.driver = driver;
        findElementActions = new FindElementActions(driver);
    }

    public void hoverOverElement(By locator) {
        WebElement element = findElementActions.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void hoverAndClick(By locator) {
        WebElement element = findElementActions.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public void hoverAndDoubleClick(By locator) {
        WebElement element = findElementActions.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).doubleClick().perform();
    }

    public void hoverAndRightClick(By locator) {
        WebElement element = findElementActions.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).contextClick().perform();
    }

    public void hoverAndSendKeys(By locator, String keys) {
        WebElement element = findElementActions.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).sendKeys(keys).perform();
    }

    public void hoverAndRelease(By locator) {
        WebElement element = findElementActions.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).release().perform();
    }

    public void hoverAndDragAndDrop(By sourceLocator, By targetLocator) {
        WebElement source = findElementActions.findElement(sourceLocator);
        WebElement target = findElementActions.findElement(targetLocator);
        Actions actions = new Actions(driver);
        actions.moveToElement(source).clickAndHold().moveToElement(target).release().perform();
    }
}
