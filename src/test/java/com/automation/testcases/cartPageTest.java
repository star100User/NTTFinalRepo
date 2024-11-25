package com.automation.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.actions.AssertActions;
import com.automation.actions.ElementActions;
import com.automation.actions.KeyboardActions;
import com.automation.actions.PropertyFileActions;
import com.automation.actions.WindowActions;
import com.automation.baseClasses.DriverMethods;
import com.automation.pages.CartPage;
import com.automation.pages.CheckOutPage;
import com.automation.pages.HomePage;
import com.automation.pages.ProductDetailsPage;
import com.automation.pages.SearchResultPage;

@Listeners(com.automation.listner.ListenerTest.class)
public class cartPageTest {

	// Objects

	// Objects
	public WebDriver driver;
	public ProductDetailsPage productDetailsPage;
	public PropertyFileActions propertyFileActions;
	public CheckOutPage checkOutPage;
	public AssertActions assertActions;
	public WindowActions windowActions;
	public HomePage homePage;
	public ElementActions elementActions;
	public SearchResultPage searchResultPage;
	public KeyboardActions keyboardActions;
	public CartPage cartPage;

	public cartPageTest() {

		if (driver == null) {
			this.driver = DriverMethods.INIT();
			//driver.get("https://www.haldirams.com/checkout/#shipping");
		}
		// Initialize page objects, passing the driver to their constructors
		checkOutPage = new CheckOutPage();
		assertActions = new AssertActions(driver);
		windowActions = new WindowActions(driver);
		homePage = new HomePage(driver);
		elementActions = new ElementActions(driver);
		searchResultPage = new SearchResultPage(driver);
		productDetailsPage = new ProductDetailsPage();
		cartPage = new CartPage();

	}

	@BeforeMethod
	public void addProductToCart() {
		homePage.searchProduct();
		searchResultPage.AddFirstProduct();
		productDetailsPage.clickOnAddToCart();
		productDetailsPage.clickOnShoppingCartLink();
		checkOutPage.closeOfferPopup();
		
	}

	@Test(groups = "SelectClassDropdown")
	public void verifySelectCountryAndState() {
		cartPage.expandEstimateShippingAndTax();
		cartPage.selectCountry("India");
		cartPage.selectState("Maharashtra");
		cartPage.clickOnProceedToCheckout();

	}
}
