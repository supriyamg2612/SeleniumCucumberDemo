package io.opencart.userauthentication.runner;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;


@RunWith(Cucumber.class)

@CucumberOptions(
		
		features = "src/test/resources/io/features",
		glue     = "io.opencart.userauthentication.stepdefinition",
				plugin = { "pretty", "html:target/cucumber-reports/cucumber-pretty",
						"json:target/cucumber-reports/CucumberTestReport.json", "rerun:target/cucumber-reports/rerun.txt" },
		monochrome = true,
		dryRun     = false
		
		
		
		//
		
		)


//
public class TestRunner {
	
	
	
	

}
