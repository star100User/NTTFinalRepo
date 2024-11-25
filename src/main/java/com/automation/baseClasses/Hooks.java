package com.automation.baseClasses;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	public static WebDriver driver;

	@Before
	public static void start_Hooks() {
		System.out.println("Hook Start");
		driver = DriverMethods.INIT();
	}

	@After
	public static void End_Hooks() {
		System.out.println("Hook End");
		DriverMethods.QUIT();
	}

	@AfterStep
	public void addScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
			try {
				// Save screenshot to the designated folder
				String screenshotPath = "target/screenshots/" + scenario.getName() + ".png";
				FileUtils.copyFile(screenshotFile, new File(screenshotPath));

				// Attach the screenshot to the Cucumber report
				scenario.attach(FileUtils.readFileToByteArray(new File(screenshotPath)), "image/png",
						scenario.getName());

			} catch (IOException e) {

			}
		}
	}
}
