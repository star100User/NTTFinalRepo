package com.automation.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TextInputActions {

    private WebDriver driver;
    private FindElementActions findElementActions;

    public TextInputActions(WebDriver driver) {
        this.driver = driver;
        this.findElementActions = new FindElementActions(driver);  // Initialize FindElementActions class
    }

    public void typeText(By locator, String text) {
        WebElement element = findElementActions.findElement(locator);  // Find the element using the locator
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().sendKeys(text).perform();
    }

    public void clearText(By locator) {
        WebElement element = findElementActions.findElement(locator);  // Find the element using the locator
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().sendKeys(Keys.CONTROL + "a").sendKeys(Keys.DELETE).perform();
    }

    public void typeTextAndSubmit(By locator, String text) {
        WebElement element = findElementActions.findElement(locator);  // Find the element using the locator
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().sendKeys(text).sendKeys(Keys.ENTER).perform();
    }

    public void pressEnter(By locator) {
        WebElement element = findElementActions.findElement(locator);  // Find the element using the locator
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().sendKeys(Keys.ENTER).perform();
    }

    public void pressTab(By locator) {
        WebElement element = findElementActions.findElement(locator);  // Find the element using the locator
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().sendKeys(Keys.TAB).perform();
    }

    public void pressBackspace(By locator) {
        WebElement element = findElementActions.findElement(locator);  // Find the element using the locator
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().sendKeys(Keys.BACK_SPACE).perform();
    }

    public void typeSpecialKeys(By locator, Keys key) {
        WebElement element = findElementActions.findElement(locator);  // Find the element using the locator
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().sendKeys(key).perform();
    }

    public void typeWithDelay(By locator, String text, int delayInMillis) throws InterruptedException {
        WebElement element = findElementActions.findElement(locator);  // Find the element using the locator
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click();
        for (char character : text.toCharArray()) {
            actions.sendKeys(String.valueOf(character)).perform();
            Thread.sleep(delayInMillis); // Adding delay between keystrokes
        }
    }
}
