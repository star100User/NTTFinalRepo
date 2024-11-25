package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.actions.AssertActions;
import com.automation.actions.ElementActions;
import com.automation.actions.FormActions;
import com.automation.actions.KeyboardActions;
import com.automation.actions.MouseActions;
import com.automation.actions.WaitActions;
import com.automation.baseClasses.DriverMethods;

public class HomePage {

	public WebDriver driver;
	public FormActions formActions;
	public ElementActions elementActions;
	public MouseActions mouseActions;
	public WaitActions waitActions;
	public AssertActions assertActions;
	public KeyboardActions keyboardActions;

	public HomePage(WebDriver driver) {
		driver = DriverMethods.INIT();
		formActions = new FormActions(driver);
		elementActions = new ElementActions(driver);
		mouseActions = new MouseActions(driver);
		waitActions = new WaitActions(driver);
		assertActions = new AssertActions(driver);
		keyboardActions = new KeyboardActions(driver);
	}

	// Locators
	private By headerWeddingSpecialCategory = By
			.xpath("//span[@class='text-black tracking-widest'][normalize-space()='Wedding Special']");
	private By headerOptionFloatingWindow = By.xpath("(//div[contains(@class,'megamenu absolute container')])[1]");
	private By searchBox = By.xpath("//input[@id='search']");
	private By beverageHeaderName = By.xpath("//span[contains(text(),'Beverages')]");

	// Actions
	public void hoverOverHeaderWeddingHeaderCat() {
		mouseActions.moveToElement(headerWeddingSpecialCategory);
	}

	public void waitForHeaderOptionFloatingWindow() {
		waitActions.waitForElementToBeVisible(headerOptionFloatingWindow, 5);
		assertActions.assertElementExists(headerOptionFloatingWindow);
	}

	public boolean isHeaderCategoryFloatingWindowDisplayed() {
		return elementActions.isVisible(headerOptionFloatingWindow);
	}

	public void searchProduct() {
		elementActions.type(searchBox, "nuts");
		keyboardActions.pressEnter(searchBox);

	}
	
	public void searchBeveragesByDragDrop()
	{
		mouseActions.dragAndDrop(beverageHeaderName, searchBox);
		String getBeverageLink = elementActions.getText(searchBox);
		System.out.println(getBeverageLink);
		elementActions.click(searchBox);
		keyboardActions.pressEnter();
	}
	
}
