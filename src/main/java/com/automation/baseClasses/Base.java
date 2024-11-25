package com.automation.baseClasses;

import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.automation.actions.BrowserActions;

public class Base {

	public DriverMethods driverManager;
	public WebDriver driver;
	public String baseURL = "https://www.haldirams.com/";
	public BrowserActions browserActions;

	@BeforeSuite(alwaysRun = true)
	public void onStart() {
		System.out.println("Executing Before Suite");
		driver = DriverMethods.INIT();
	}

	@AfterSuite(alwaysRun = true)
	public void onFinish() {
		System.out.println("Executing After Suite");
		DriverMethods.INIT();
	}

}
