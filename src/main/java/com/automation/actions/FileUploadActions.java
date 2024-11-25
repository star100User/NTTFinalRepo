package com.automation.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadActions {

    private WebDriver driver;
    private FindElementActions findElementActions;

    public FileUploadActions(WebDriver driver) {
        this.driver = driver;
        findElementActions = new FindElementActions(driver);
    }

    public void uploadFile(By fileInputLocator, String filePath) {
        WebElement fileInput = findElementActions.findElement(fileInputLocator);
        if (fileInput.isDisplayed() && fileInput.isEnabled()) {
            fileInput.sendKeys(filePath);
        }
    }

    public void clearFileInput(By fileInputLocator) {
        WebElement fileInput = findElementActions.findElement(fileInputLocator);
        if (fileInput.isDisplayed() && fileInput.isEnabled()) {
            fileInput.clear();
        }
    }

    public boolean isFileUploaded(By fileInputLocator) {
        WebElement fileInput = findElementActions.findElement(fileInputLocator);
        return fileInput.getAttribute("value").length() > 0;
    }
}
