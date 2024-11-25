package com.automation.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.actions.PropertyFileActions;
import com.automation.baseClasses.DriverMethods;
import com.automation.pages.ProductDetailsPage;

@Listeners(com.automation.listner.ListenerTest.class)
public class productDetailsTest {

	// Objects

	public WebDriver driver;
	public ProductDetailsPage productDetailsPage;
	public PropertyFileActions propertyFileActions;

	public productDetailsTest() {

		if (driver == null) {
			this.driver = DriverMethods.INIT();
			driver.get("https://www.haldirams.com/fusion-sweets-collection-14.html");
		}
		productDetailsPage = new ProductDetailsPage();
		propertyFileActions = new PropertyFileActions();

	}

	@Test(groups = {"propertyFileReader", "scrollActions"})
	public void VerifyReviewPageUsingPropertyFile() {
		String filePath = "C:\\Users\\als22\\eclipse-workspace\\Automation_Code\\NTTFinalDemoForStudents"
				+ "\\src\\test\\resources\\testData\\testData4.properties";

		String name = propertyFileActions.getPropertyValue(filePath, "name");
		String sub = propertyFileActions.getPropertyValue(filePath, "subject");
		String review = propertyFileActions.getPropertyValue(filePath, "review");
		productDetailsPage.fillTheReviewForm(name, sub, review);
	}

}
