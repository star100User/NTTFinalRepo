package com.automation.baseClasses;

import java.time.Duration;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverMethods {

	private static WebDriver driver; // WebDriver instance
	private static final String BASE_URL = "https://www.haldirams.com/"; // Base URL
	private static Actions act;
	private static WebDriverWait wait;

	private DriverMethods() {
	}

	public static WebDriver INIT() {

		if (driver == null) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(BASE_URL);

		}
		return driver;
	}

	public static Actions getActionsObj() {
		if (act == null) {
			act = new Actions(driver);
		}
		return act;
	}

	public static WebDriverWait getWaitObject() {
		if (wait == null) {
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		}
		return wait;
	}

	public static void QUIT() {

		if (driver != null)
			driver.quit();
	}
}
