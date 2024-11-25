package com.automation.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FormActions {

    private WebDriver driver;
    private FindElementActions findElementActions;

    public FormActions(WebDriver driver) {
        this.driver = driver;
        findElementActions = new FindElementActions(driver);
    }

    public void fillInputField(By locator, String value) {
        WebElement inputField = findElementActions.findElement(locator);
        if (inputField.isDisplayed() && inputField.isEnabled()) {
            inputField.clear();
            inputField.sendKeys(value);
        }
    }

    public void selectRadioButton(By locator) {
        WebElement radioButton = findElementActions.findElement(locator);
        if (radioButton.isDisplayed() && radioButton.isEnabled() && !radioButton.isSelected()) {
            radioButton.click();
        }
    }

    public void selectCheckBox(By locator) {
        WebElement checkBox = findElementActions.findElement(locator);
        if (checkBox.isDisplayed() && checkBox.isEnabled() && !checkBox.isSelected()) {
            checkBox.click();
        }
    }

    public void unselectCheckBox(By locator) {
        WebElement checkBox = findElementActions.findElement(locator);
        if (checkBox.isDisplayed() && checkBox.isEnabled() && checkBox.isSelected()) {
            checkBox.click();
        }
    }

    public void submitForm(By locator) {
        WebElement form = findElementActions.findElement(locator);
        if (form.isDisplayed() && form.isEnabled()) {
            form.submit();
        }
    }

    public String getInputFieldValue(By locator) {
        WebElement inputField = findElementActions.findElement(locator);
        if (inputField.isDisplayed()) {
            return inputField.getAttribute("value");
        }
        return null;
    }

    // Select options from dropdowns using different methods
    public void selectByText(By locator, String optionName) {
        WebElement dropdown = findElementActions.findElement(locator);
        if (dropdown.isDisplayed() && dropdown.isEnabled()) {
            Select select = new Select(dropdown);
            select.selectByVisibleText(optionName);
        }
    }

    public void selectByValue(By locator, String value) {
        WebElement dropdown = findElementActions.findElement(locator);
        if (dropdown.isDisplayed() && dropdown.isEnabled()) {
            Select select = new Select(dropdown);
            select.selectByValue(value);
        }
    }

    public void selectByIndex(By locator, int index) {
        WebElement dropdown = findElementActions.findElement(locator);
        if (dropdown.isDisplayed() && dropdown.isEnabled()) {
            Select select = new Select(dropdown);
            select.selectByIndex(index);
        }
    }
}
