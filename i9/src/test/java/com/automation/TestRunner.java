package com.automation;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\resources\\features\\HRM.feature" , tags = "@Regression" ,plugin = "html:ExecutionReports.html")
public class TestRunner extends AbstractTestNGCucumberTests {

}
