package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.actions.ElementActions;
import com.automation.actions.FormActions;
import com.automation.actions.KeyboardActions;
import com.automation.actions.MouseActions;
import com.automation.actions.ScrollActions;
import com.automation.baseClasses.DriverMethods;

public class ProductDetailsPage {

    public WebDriver driver;
    public FormActions formActions;
    public ElementActions elementActions;
    public MouseActions mouseActions;
    public KeyboardActions keyboardActions;
    public ScrollActions scrollActions;

    public ProductDetailsPage() {
        this.driver = DriverMethods.INIT();
        formActions = new FormActions(driver);
        elementActions = new ElementActions(driver);
        mouseActions = new MouseActions(driver);
        keyboardActions = new KeyboardActions(driver);
        scrollActions = new ScrollActions(driver);
    }

    // Locators
    private By reviewsLocator = By.id("Reviews");
    private By reviewNameLocator = By.xpath("//input[@id='nickname_field']");
    private By recapchaCheckboxLocator = By.xpath("//input[@id='nickname_field']");
    private By addToCartBtn = By.xpath("//button[@id='product-addtocart-button']");
    private By shoppingCartLinkInGreen = By.xpath("//a[normalize-space()='shopping cart']");
    private By proceedToCheckOut = By.xpath("//a[@id='checkout-link-button']");

    // Actions
    public void clickOnReviews() {
    	scrollActions.scrollIntoView(reviewsLocator);
        elementActions.click(reviewsLocator);
    }

    public void fillTheReviewForm(String name, String subject, String review) {
    	clickOnReviews();
        elementActions.type(reviewNameLocator, name);
        keyboardActions.pressTab(reviewNameLocator);
        keyboardActions.type(subject);
        keyboardActions.pressTab();
        keyboardActions.type(review);
        keyboardActions.pressTab();
        keyboardActions.pressEnter();
        elementActions.click(recapchaCheckboxLocator);
    }
    
    public void clickOnAddToCart()
    {
    	elementActions.click(addToCartBtn);
    }
    public void clickOnShoppingCartLink()
    {
    	elementActions.click(shoppingCartLinkInGreen);
    }
    public void clickOnProceedToCheckOut()
    {
    	elementActions.click(proceedToCheckOut);
    }
}
