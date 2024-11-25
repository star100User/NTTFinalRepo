package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.actions.ElementActions;
import com.automation.actions.FormActions;
import com.automation.actions.MouseActions;
import com.automation.baseClasses.DriverMethods;

public class CartPage {

    public WebDriver driver;
    public FormActions formActions;
    public ElementActions elementActions;
    public MouseActions mouseActions;

    public CartPage() {
        this.driver = DriverMethods.INIT();
        formActions = new FormActions(driver);
        elementActions = new ElementActions(driver);
        mouseActions = new MouseActions(driver);
    }

    // Locators
    private By countryDDLLocator = By.xpath("//select[@name='country_id']");
    private By stateDDLLocator = By.xpath("//select[@id='region_id']");
    private By pinCodeLocator = By.xpath("//input[@name='postcode']");
    private By proceedToCheckoutLocator = By.xpath("//a[@id='checkout-link-button']");
    private By firstItemTrashIconLocator = By.xpath("//a[@title='Remove item']");
    private By estimateShippingAndTaxexpander = By.xpath("//div[@id='block-shipping']"); 

    // Actions
    public void selectCountry(String countryName) {
        formActions.selectByText(countryDDLLocator, countryName);
    }

    public void selectState(String stateName) {
        formActions.selectByText(stateDDLLocator, stateName);
    }

    public void enterZipCode(String pincode) {
        formActions.fillInputField(pinCodeLocator, pincode);
    }

    public void clickOnProceedToCheckout() {
        elementActions.click(proceedToCheckoutLocator);
    }

    public void hoverOverTrashIcon() {
        mouseActions.moveToElement(firstItemTrashIconLocator);
    }


    public void expandEstimateShippingAndTax()
    {
    	elementActions.click(estimateShippingAndTaxexpander);
    }
}
