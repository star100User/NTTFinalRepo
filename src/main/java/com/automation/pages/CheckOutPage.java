package com.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.actions.ElementActions;
import com.automation.actions.FormActions;
import com.automation.actions.KeyboardActions;
import com.automation.actions.MouseActions;
import com.automation.actions.MouseHoverActions;
import com.automation.actions.TableActions;
import com.automation.baseClasses.DriverMethods;

public class CheckOutPage {

	public WebDriver driver;
	public FormActions formActions;
	public ElementActions elementActions;
	public TableActions tableActions;
	public MouseActions mouseActions;
	public MouseHoverActions mouseHoverActions;
	public KeyboardActions keyboardActions;

	public CheckOutPage() {
		this.driver = DriverMethods.INIT();
		formActions = new FormActions(driver);
		this.elementActions = new ElementActions(driver);
		tableActions = new TableActions(driver);
		mouseActions = new MouseActions(driver);
		mouseHoverActions = new MouseHoverActions(driver);
		keyboardActions = new KeyboardActions(driver);
	}

	// Locators
	private By emailAddressLocator = By.xpath("//input[@id='customer-email']");
	private By firstNameLocator = By.xpath("//input[@id='SWXA6RO']");
	private By lastNameLocator = By.xpath("//input[@id='K2KYS5G']");
	private By phoneNumberLocator = By.xpath("//input[@id='O89XC5C']");
	private By streetAddressLine1Locator = By.xpath("//input[@id='U060PMI']");
	private By zipCodeLocator = By.xpath("//input[@id='UT3UNGE']");
	private By countryDDLocator = By.xpath("//select[@id='VD8M646']");
	private By stateDDLocator = By.xpath("//select[@id='IFDJXDJ']");
	private By shippingMethodsTableLocator = By.xpath("//table[@class='table-checkout-shipping-method']");
	private By closePopupCrossMark = By.xpath("//img[@alt='Close']");
	private By hereLinkForContShopping = By.linkText("here");

	// Actions
	public void enterEmail(String emailData) {
		formActions.fillInputField(emailAddressLocator, emailData);
	}

	public void enterFirstName(String firstNameData) {
		formActions.fillInputField(firstNameLocator, firstNameData);
	}

	public void enterLastName(String lastNameData) {
		formActions.fillInputField(lastNameLocator, lastNameData);
	}

	public void enterPhoneNumber(String phoneNumberData) {
		formActions.fillInputField(phoneNumberLocator, phoneNumberData);
	}

	public void enterStreetAddressLine1(String streetAddressData) {
		formActions.fillInputField(streetAddressLine1Locator, streetAddressData);
	}

	public void enterZipCode(String zipCodeData) {
		formActions.fillInputField(zipCodeLocator, zipCodeData);
	}

	public void selectCountry(String countryData) {
		formActions.selectByText(countryDDLocator, countryData);
	}

	public void selectState(String stateData) {
		formActions.selectByText(stateDDLocator, stateData);
	}

	public int getShippingTableHeadersCount() {
		return tableActions.getColumnCount(shippingMethodsTableLocator);
	}

	public List<String> getShippingTableHeaderNames() {
		return tableActions.getTableHeaders(shippingMethodsTableLocator);
	}

	public int getShippingTableRowsCount() {
		return tableActions.getRowCount(shippingMethodsTableLocator);
	}

	public void clickOnHereLinkToContinueShoppingOnNewTab() {

		elementActions.click(closePopupCrossMark);
		mouseHoverActions.hoverOverElement(hereLinkForContShopping);
		keyboardActions.PressCtrlPlusClick(hereLinkForContShopping);

	}
	
	public void closeOfferPopup()
	{
		elementActions.click(closePopupCrossMark);
	}
}
