package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.actions.ElementActions;
import com.automation.actions.FindElementActions;
import com.automation.actions.FormActions;
import com.automation.actions.FrameActions;
import com.automation.actions.KeyboardActions;
import com.automation.actions.WaitActions;
import com.automation.baseClasses.DriverMethods;

public class CareersPage {

	public WebDriver driver;
	public FormActions formActions;
	public ElementActions elementActions;
	public WebDriverWait wait;
	public WaitActions waitActions;
	public KeyboardActions keyboardActions;
	public FrameActions frameActions;
	public FindElementActions findElementActions;

	public CareersPage() {

		this.driver = DriverMethods.INIT();
		formActions = new FormActions(driver);
		elementActions = new ElementActions(driver);
		this.wait = DriverMethods.getWaitObject();
		waitActions = new WaitActions(driver);
		keyboardActions = new KeyboardActions(driver);
		frameActions = new FrameActions(driver);
		findElementActions = new FindElementActions(driver);
	}

	// Locators
	private By nameFieldLocator = By.xpath("//input[@id='loffield_c13']");
	private By emailFieldLocator = By.xpath("//input[@id='loffield_c33']");
	private By mobileFieldLocator = By.xpath("//input[@id='loffield_c43']");
	private By positionApplyingForFieldLocator = By.xpath("//input[@id='loffield_c53']");
	private By qualificationFieldLocator = By.xpath("//input[@id='loffield_c63']");
	private By messageFieldLocator = By.xpath("//textarea[@id='loffield_c103']");
	private By chooseFileButtonLocator = By.xpath("//input[@id='loffield_c83']");
	private By iAmNotARobotCheckboxLocator = By.xpath("//label[@id='recaptcha-anchor-label']");
	private By submitButtonLocator = By.xpath("//div[@class='recaptcha-checkbox-border']");
	private By resumeErrorMsg = By.xpath("");
	private By capchaFrame = By.xpath("");

	// Actions
	public void SetName(String name) {
		formActions.fillInputField(nameFieldLocator, name);
	}

	public void SetEmail(String email) {
		formActions.fillInputField(emailFieldLocator, email);
	}

	public void SetMobile(String mobile) {
		formActions.fillInputField(mobileFieldLocator, mobile);
	}

	public void SetPositionApplyingFor(String position) {
		formActions.fillInputField(positionApplyingForFieldLocator, position);
	}

	public void SetQualification(String qualification) {
		formActions.fillInputField(qualificationFieldLocator, qualification);
	}

	public void SetMessage(String message) {
		formActions.fillInputField(messageFieldLocator, message);
	}

	public void ChooseFile(String filePath) {
		formActions.fillInputField(chooseFileButtonLocator, filePath);
	}

	public void SetCaptcha() throws InterruptedException {
		elementActions.click(messageFieldLocator);
		elementActions.type(messageFieldLocator, "New Data");
		waitActions.waitForPageLoad(30);
		keyboardActions.pressTab();
		keyboardActions.pressTab();
		Actions act = new Actions(driver);
		act.pause(Duration.ofSeconds(30)).build().perform();
		keyboardActions.pressEnter();

	}

	public void SubmitForm() {

		formActions.submitForm(submitButtonLocator);
	}

	public void FillFullCareersForm(String name, String email, String mobileNumber, String position,
			String Qualification, String msg) {

		SetName(name);
		SetEmail(email);
		SetMobile(mobileNumber);
		SetPositionApplyingFor(position);
		SetQualification(Qualification);
		SetMessage(msg);

	}

	public String getCapchaMsg() {
		return elementActions.getText(resumeErrorMsg);
	}
}
