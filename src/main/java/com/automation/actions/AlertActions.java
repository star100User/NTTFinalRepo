package com.automation.actions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertActions {
    
    private WebDriver driver;

    public AlertActions(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public Alert waitForAlert(int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert() {
        if (isAlertPresent()) {
            driver.switchTo().alert().accept();
        }
    }

    public void dismissAlert() {
        if (isAlertPresent()) {
            driver.switchTo().alert().dismiss();
        }
    }

    public String getAlertText() {
        if (isAlertPresent()) {
            return driver.switchTo().alert().getText();
        }
        return null;
    }

    public void sendKeysToAlert(String text) {
        if (isAlertPresent()) {
            driver.switchTo().alert().sendKeys(text);
        }
    }
}
