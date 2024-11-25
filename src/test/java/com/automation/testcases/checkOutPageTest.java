package com.automation.testcases;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.actions.AssertActions;
import com.automation.actions.ElementActions;
import com.automation.actions.KeyboardActions;
import com.automation.actions.PropertyFileActions;
import com.automation.actions.WindowActions;
import com.automation.baseClasses.DriverMethods;
import com.automation.pages.CheckOutPage;
import com.automation.pages.HomePage;
import com.automation.pages.ProductDetailsPage;
import com.automation.pages.SearchResultPage;

@Listeners(com.automation.listner.ListenerTest.class)
public class checkOutPageTest {

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

	public checkOutPageTest() {

		if (driver == null) {
			this.driver = DriverMethods.INIT();
			driver.get("https://www.haldirams.com/checkout/#shipping");
		}
		// Initialize page objects, passing the driver to their constructors
		checkOutPage = new CheckOutPage();
		assertActions = new AssertActions(driver);
		windowActions = new WindowActions(driver);
		homePage = new HomePage(driver);
		elementActions = new ElementActions(driver);
		searchResultPage = new SearchResultPage(driver);
		productDetailsPage = new ProductDetailsPage();

	}

	@Test(groups = { "TableReader", "Assertions", "Collections", "windowHandling" })
	public void VerifyTableRelatedData() {
		checkOutPage.clickOnHereLinkToContinueShoppingOnNewTab();
		windowActions.switchToLatestWindow();
		homePage.searchProduct();
		searchResultPage.AddFirstProduct();
		productDetailsPage.clickOnAddToCart();
		productDetailsPage.clickOnShoppingCartLink();
		checkOutPage.closeOfferPopup();
		productDetailsPage.clickOnProceedToCheckOut();

		// Uncomment and modify these assertions as necessary
		 List<String> expectedHeaderNames = Arrays.asList("Select Method", "Price",
		 "Method Title", "Carrier Title");
		 
		 assertActions.assertEquals(checkOutPage.getShippingTableRowsCount(), 2);
		 assertActions.assertEquals(checkOutPage.getShippingTableHeaderNames(),
		 expectedHeaderNames);
		 assertActions.assertEquals(checkOutPage.getShippingTableHeadersCount(), 4);
	}
}
