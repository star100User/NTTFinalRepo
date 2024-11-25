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

public class SearchResultPage {
	
	public WebDriver driver;
	public FormActions formActions;
	public ElementActions elementActions;
	public MouseActions mouseActions;
	public WaitActions waitActions;
	public AssertActions assertActions;
	public KeyboardActions keyboardActions;

	public SearchResultPage(WebDriver driver) {
		driver = DriverMethods.INIT();
		formActions = new FormActions(driver);
		elementActions = new ElementActions(driver);
		mouseActions = new MouseActions(driver);
		waitActions = new WaitActions(driver);
		assertActions = new AssertActions(driver);
		keyboardActions = new KeyboardActions(driver);
	}
	
	//locator
	private By firstProductOfSearchedProduct = By.xpath("(//div[contains(@class,'products-grid')]//a)[1]");
	private By searchResultTextMsg = By.xpath("//span[@class='base']");
	//Actions
	
	public void AddFirstProduct()
	{
		elementActions.click(firstProductOfSearchedProduct);
	}
	
	public String getSearchResultMsg()
	{
		return elementActions.getText(searchResultTextMsg);
	}

}
