package com.automation.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.baseClasses.DriverMethods;

public class ElementActions {

	public WebDriver driver;
	public FindElementActions findElementActions;

	public ElementActions(WebDriver driver) {
		this.driver = DriverMethods.INIT();
		findElementActions = new FindElementActions(driver);
	}

	public void click(By locator) {
		WebElement element = findElementActions.findElement(locator);
		if (element.isDisplayed() && element.isEnabled()) {
			element.click();
		}
	}

	public void type(By locator, String text) {
		WebElement element = findElementActions.findElement(locator);
		if (element.isDisplayed() && element.isEnabled()) {
			element.clear();
			element.sendKeys(text);
		}
	}

	public void clear(By locator) {
		WebElement element = findElementActions.findElement(locator);
		if (element.isDisplayed() && element.isEnabled()) {
			element.clear();
		}
	}

	public boolean isVisible(By locator) {
		WebElement element = findElementActions.findElement(locator);
		return element.isDisplayed();
	}

	public boolean isEnabled(By locator) {
		WebElement element = findElementActions.findElement(locator);
		return element.isEnabled();
	}

	public String getText(By locator) {
		WebElement element = findElementActions.findElement(locator);
		if (element.isDisplayed()) {
			return element.getText();
		}
		return null;
	}

	public void submit(By locator) {
		WebElement element = findElementActions.findElement(locator);
		if (element.isDisplayed() && element.isEnabled()) {
			element.submit();
		}
	}
}
