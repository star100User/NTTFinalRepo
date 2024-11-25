package com.automation.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropActions {
    
    private WebDriver driver;
    private FindElementActions findElementActions;

    public DragAndDropActions(WebDriver driver) {
        this.driver = driver;
        findElementActions = new FindElementActions(driver);
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

    public void clickAndHold(By sourceLocator) {
        WebElement source = findElementActions.findElement(sourceLocator);
        Actions actions = new Actions(driver);
        actions.clickAndHold(source).perform();
    }

    public void release(By targetLocator) {
        WebElement target = findElementActions.findElement(targetLocator);
        Actions actions = new Actions(driver);
        actions.release(target).perform();
    }
}
