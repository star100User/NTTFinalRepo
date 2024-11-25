package com.automation.stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.actions.AssertActions;
import com.automation.actions.BrowserActions;
import com.automation.actions.FindElementActions;
import com.automation.actions.FrameActions;
import com.automation.actions.NavigationActions;
import com.automation.baseClasses.DriverMethods;
import com.automation.pages.CareersPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class careersSD {

	public WebDriver driver;
	public BrowserActions browserActions;
	public NavigationActions navigationActions;
	public CareersPage careersPage;
	public AssertActions assertActions;
	public WebDriverWait wait;
	public FrameActions frameActions;
	public FindElementActions findElementActions;

	public careersSD() {
		this.driver = DriverMethods.INIT();
		this.wait = DriverMethods.getWaitObject();
		navigationActions = new NavigationActions(driver);
		browserActions = new BrowserActions(driver);
		careersPage = new CareersPage();
		assertActions = new AssertActions(driver);
		frameActions = new FrameActions(driver);
		findElementActions = new FindElementActions(driver);
	}

	@Given("I launched the the career page")
	public void iLaunchedTheCareersPage() {
		// Navigate to careers page
		browserActions.getURL("https://www.haldirams.com/careers");
	}

	@Given("I am on a careers page verified title {string}")
	public void i_am_on_a_careers_page_verified_title(String expectedTitle) {
		// Navigate to careers page
		browserActions.getURL("https://www.haldirams.com/careers");
		String actualTitle = navigationActions.getPageTitle();
		assertActions.assertTrue(actualTitle.contains(expectedTitle.substring(21)));
	}

	@When("I entered all the details in form")
	public void i_entered_all_the_details_in_form(DataTable dataTable) {

		String name = dataTable.cell(1, 0);
		String email = dataTable.cell(1, 1);
		String mobileNumber = dataTable.cell(1, 2);
		String position = dataTable.cell(1, 3);
		String qualification = dataTable.cell(1, 4);
		String message = dataTable.cell(1, 5);

		careersPage.FillFullCareersForm(name, email, mobileNumber, position, qualification, message);
	}

	@And("I checked the checkbox for I am not a robot")
	public void i_checked_the_checkbox_for_i_am_not_a_robot() throws InterruptedException {
		careersPage.SetCaptcha();
	}

	@And("I clicked on submit")
	public void i_clicked_on_submit() {

		careersPage.SubmitForm();
	}

	@Then("I verified it shows capcha window to user with below message")
	public void verifyErrorMessageForResumeField(DataTable dataTable) {
		By capchaFrame = By.xpath("");
		WebElement capchaFrameEle = findElementActions.findElement(capchaFrame);
		frameActions.switchToFrameByWebElement(capchaFrameEle);
		List<Map<String, String>> capchaMsg = dataTable.asMaps(String.class, String.class);
		String expCapchaMessage = capchaMsg.get(0).get("capchaMsg");	
		String actCapchaMessage = careersPage.getCapchaMsg();

		assertEquals(expCapchaMessage, actCapchaMessage);
	}
}
