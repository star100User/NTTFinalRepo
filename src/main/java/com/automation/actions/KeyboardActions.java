package com.automation.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

	private WebDriver driver;
	private FindElementActions findElementActions;

	public KeyboardActions(WebDriver driver) {
		this.driver = driver;
		findElementActions = new FindElementActions(driver);
	}

	public void type(By locator, String text) {
		WebElement element = findElementActions.findElement(locator);
		Actions actions = new Actions(driver);
		actions.sendKeys(element, text).perform();
	}

	public void type(String text) {
		Actions actions = new Actions(driver);
		actions.sendKeys(text).perform();
	}

	public void pressKey(By locator, Keys key) {
		WebElement element = findElementActions.findElement(locator);
		Actions actions = new Actions(driver);
		actions.sendKeys(element, key).perform();
	}

	public void pressKeyCombination(Keys key1, Keys key2) {
		Actions actions = new Actions(driver);
		actions.keyDown(key1).keyDown(key2).keyUp(key2).keyUp(key1).perform();
	}

	public void pressEnter(By locator) {
		WebElement element = findElementActions.findElement(locator);
		Actions actions = new Actions(driver);
		actions.sendKeys(element, Keys.ENTER).perform();
	}

	public void pressEnter() {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
	}

	public void pressTab(By locator) {
		WebElement element = findElementActions.findElement(locator);
		Actions actions = new Actions(driver);
		actions.sendKeys(element, Keys.TAB).perform();
	}

	public void pressTab() {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).perform();
	}

	public void clearField(By locator) {
		WebElement element = findElementActions.findElement(locator);
		Actions actions = new Actions(driver);
		actions.click(element).sendKeys(Keys.CONTROL + "a").sendKeys(Keys.DELETE).perform();
	}

	public void pressEscape(By locator) {
		WebElement element = findElementActions.findElement(locator);
		Actions actions = new Actions(driver);
		actions.sendKeys(element, Keys.ESCAPE).perform();
	}

	public void pressEscape() {

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ESCAPE).perform();
	}

	public void pressArrowKey(By locator, Keys arrowKey) {
		WebElement element = findElementActions.findElement(locator);
		Actions actions = new Actions(driver);
		actions.sendKeys(element, arrowKey).perform();
	}

	public void PressCtrlPlusClick(By locator) {
		WebElement hereLink = findElementActions.findElement(locator);
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).click(hereLink).keyUp(Keys.CONTROL).perform();
	}
}
