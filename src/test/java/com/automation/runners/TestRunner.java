package com.automation.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\als22\\eclipse-workspace\\Automation_Code\\NTTData_AutomationProject\\src\\main\\java\\com\\BDD\\Features", glue = {
		"com.BDD.Bindings", "com.BASE" }, dryRun = false, monochrome = true,

		plugin = { "pretty", "html:target/cucumber-reports/cucumber.html" })

public class TestRunner {

}
