package org.cucumber.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin={"html:target/cucumber-reports"}, features={"D:/WorkSpaceUpdated/SeleniumCucumber/Features"},
				glue={"org.cucumber.stepdefinitions"}, monochrome=true,
				tags={"@demo"})
public class Runner {

}
