package org.cucumber.stepdefinitions;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.cucumber.handlers.ApplicationContext;
import org.cucumber.handlers.FileReaderHandler;
import org.cucumber.pageobjects.CommonPageObjects;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CucumberHooks {
	private static final Logger log = Logger.getLogger(CucumberHooks.class);
	
	static{
		String propFilePath = FileReaderHandler.getInstance().getConfigFileReader().getProjectConfigProperty().getProperty("propertiespath");
		String log4jConfigFile = propFilePath + "//log4j.properties";
		PropertyConfigurator.configure(log4jConfigFile);
	}
	
	private ApplicationContext context;
		
	public CucumberHooks(ApplicationContext context){
		this.context = context;
		log.info("Application Context set");
	}
	
	@Before
	public void setUp(Scenario scenario){
		log.info("***** Execution started for scenario: '" + scenario.getName() + "' *****");
	}
	
	@After
	public void tearDown(Scenario scenario){
		if(scenario.isFailed()){
			byte[] srcShot = ((TakesScreenshot)this.context.getWedDriverHandler().getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(srcShot, "image/png");
			try{
				CommonPageObjects commonObjects = this.context.getPageObjectHandler().getCommonPageObjects();
				this.context.getApplication().logOut(commonObjects.getLogOutSpan(), commonObjects.getLogoutLink(),"parent");
			}catch(Exception e){
				log.error("Error while logging out");
			}
		}
		this.context.getWedDriverHandler().getDriver().close();
		this.context.getWedDriverHandler().getDriver().quit();
		log.info("Browser closed and driver is quit");
		log.info("***** Execution completed for scenario: '" + scenario.getName() + "' Status: '" + scenario.getStatus() + "' *****");
	}

}
