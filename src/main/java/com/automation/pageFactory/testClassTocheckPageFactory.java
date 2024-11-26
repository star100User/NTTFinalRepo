package com.automation.pageFactory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.automation.baseClasses.DriverMethods;

public class testClassTocheckPageFactory {

	@Test
	public void M1() {
		WebDriver driver = DriverMethods.INIT();
		pageFactoryCode loginPage = new pageFactoryCode(driver); // Page object is created, but elements aren't found
																	// yet
		loginPage.enterUsername("user123"); // This triggers the first use of 'usernameField' and element is found

	}

}
