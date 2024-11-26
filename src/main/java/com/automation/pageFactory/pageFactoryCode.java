package com.automation.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pageFactoryCode {
    
    WebDriver driver;

    // Web elements with @FindBy annotations
    @FindBy(id = "username")
    WebElement usernameField;
    
    @FindBy(id = "password")
    WebElement passwordField;
    
    @FindBy(id = "loginButton")
    WebElement loginButton;

    // Constructor that initializes elements
    public pageFactoryCode(WebDriver driver) {
        this.driver = driver;
        // Initialize elements using PageFactory
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }
}
