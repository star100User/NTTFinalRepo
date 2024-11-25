package com.automation.testcases;

import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.actions.AssertActions;
import com.automation.baseClasses.DriverMethods;
import com.automation.pages.HomePage;
import com.automation.pages.SearchResultPage;

@Listeners(com.automation.listner.ListenerTest.class)
public class HomeTest {
	// Objects
	public HomePage homePage;
	public WebDriver driver;
	public AssertActions assertActions;
	public SearchResultPage searchResultPage;

	public HomeTest() {

		if (driver == null) {
			this.driver = DriverMethods.INIT();
		}
		homePage = new HomePage(driver);
		assertActions = new AssertActions(driver);
		searchResultPage = new SearchResultPage(driver);
	}

	@Ignore
	@Test(groups = "MouseHover")
	public void VerifyPresenceOfWeddingSpecilHeaderCat() {
		homePage.hoverOverHeaderWeddingHeaderCat();
		homePage.waitForHeaderOptionFloatingWindow();

	}

	@Test(groups = { "StringOperations", "DragAndDrop" })
	public void verifySearchBeveragesByDragAndDrop() {
		homePage.searchBeveragesByDragDrop();
		String expectedSearchedMsg = "Search results for: 'https://www.haldirams.com/beverages.html'";
		assertActions.assertEquals(expectedSearchedMsg, searchResultPage.getSearchResultMsg());
	}

}
