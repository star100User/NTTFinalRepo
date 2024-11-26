package com.automation.testcases;

import java.io.IOException;

import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.actions.DBConnectionActions;
import com.automation.actions.ExcelActions;
import com.automation.baseClasses.DriverMethods;
import com.automation.pages.CareersPage;

@Listeners(com.automation.listner.ListenerTest.class)
public class careersTest {

	// Objects
	public CareersPage careersPage;
	public WebDriver driver;
	public ExcelActions excelActions;
	public DBConnectionActions dBConnectionActions;

	public careersTest() {
		careersPage = new CareersPage();
		excelActions = new ExcelActions();
		dBConnectionActions = new DBConnectionActions();

		if (driver == null) {
			this.driver = DriverMethods.INIT();
			driver.get("https://www.haldirams.com/careers");
		}

	}

	@Test(groups = "ExcelSheetReader")
	public void verifyCareersPageFunctionalityWithExcelSheet() throws IOException {
		String excelSheetPath = "src/test/resources/testData/testData3.xlsx";
		String sheetName = "CareerSheet";
		String name = excelActions.readData(excelSheetPath, sheetName, 0, 1);
		String email = excelActions.readData(excelSheetPath, sheetName, 0, 2);
		String mobile = excelActions.readData(excelSheetPath, sheetName, 0, 3);
		String position = excelActions.readData(excelSheetPath, sheetName, 0, 4);
		String qualification = excelActions.readData(excelSheetPath, sheetName, 0, 5);
		String msg = excelActions.readData(excelSheetPath, sheetName, 0, 6);

		careersPage.FillFullCareersForm(name, email, mobile, position, qualification, msg);

	}

	@Test(groups = "DatabaseReader")
	public void verifyCareersPageFunctionalityFromDataBase() throws IOException {

		String query ="select * from careersTable";
		String name = dBConnectionActions.executeQueryAndReturnResult(query, "name").get(0);
		String email = dBConnectionActions.executeQueryAndReturnResult(query, "email").get(0);
		String mobile = dBConnectionActions.executeQueryAndReturnResult(query, "mobile").get(0);
		String position = dBConnectionActions.executeQueryAndReturnResult(query, "position").get(0);
		String qualification = dBConnectionActions.executeQueryAndReturnResult(query, "qualification").get(0);
		String msg = dBConnectionActions.executeQueryAndReturnResult(query, "msg").get(0);

		careersPage.FillFullCareersForm(name, email, mobile, position, qualification, msg);

	}

	
	@DataProvider(name = "userData")
	public Object[][] createUserData() {
		return new Object[][] { { "John", "john@gmail.com", "1234567890", "Head", "BE", "MyMsg" }, };
	}


	@Test(dataProvider = "userData", groups = "dataproviderTestNGCode")
	public void testCareersPageUSingDataProvider(String name, String email, String mobile, String position,
			String qualification, String msg) {

		careersPage.FillFullCareersForm(name, email, mobile, position, qualification, msg);
	}

}
