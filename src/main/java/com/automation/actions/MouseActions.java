package com.automation.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {

    private WebDriver driver;
    private FindElementActions findElementActions;

    public MouseActions(WebDriver driver) {
        this.driver = driver;
        findElementActions = new FindElementActions(driver);
    }

    public void click(By locator) {
        WebElement element = findElementActions.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public void doubleClick(By locator) {
        WebElement element = findElementActions.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).doubleClick().perform();
    }

    public void rightClick(By locator) {
        WebElement element = findElementActions.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).contextClick().perform();
    }

    public void moveToElement(By locator) {
        WebElement element = findElementActions.findElement(locator);
        Actions actions = new Actions(driver);
        if (element.isDisplayed()) {
            actions.moveToElement(element).perform();
        }
    }

    public void dragAndDrop(By sourceLocator, By targetLocator) {
        WebElement source = findElementActions.findElement(sourceLocator);
        WebElement target = findElementActions.findElement(targetLocator);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
    }

    public void dragAndDropByOffset(By sourceLocator, int xOffset, int yOffset) {
        WebElement source = findElementActions.findElement(sourceLocator);
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(source, xOffset, yOffset).perform();
    }

    public void clickAndHold(By locator) {
        WebElement element = findElementActions.findElement(locator);
        Actions actions = new Actions(driver);
        actions.clickAndHold(element).perform();
    }

    public void release(By locator) {
        WebElement element = findElementActions.findElement(locator);
        Actions actions = new Actions(driver);
        actions.release(element).perform();
    }

    public void moveByOffset(int xOffset, int yOffset) {
        Actions actions = new Actions(driver);
        actions.moveByOffset(xOffset, yOffset).perform();
    }
}
