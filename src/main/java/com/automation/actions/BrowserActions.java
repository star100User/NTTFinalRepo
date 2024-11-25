package com.automation.actions;

import org.openqa.selenium.WebDriver;

public class BrowserActions {

	public WebDriver driver;

	public BrowserActions(WebDriver driver) {
		this.driver = driver;
	}

	public void getURL(String url) {
		driver.get(url);
	}

}
