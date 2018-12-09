package org.cucumber.handlers;

import java.util.Properties;

import org.cucumber.utils.DriverSetUp;
import org.openqa.selenium.WebDriver;

public class WebDriverHandler {
	private WebDriver driver;
	private String browserType;
	private String driverPath;
	
	public WebDriverHandler(){
		Properties configProp = FileReaderHandler.getInstance().getConfigFileReader().getProjectConfigProperty();
		this.browserType = configProp.getProperty("browsertype");
		this.driverPath = configProp.getProperty("driverpath");
		this.driver=DriverSetUp.setupDriver(browserType, driverPath);
	}

	public WebDriver getDriver() {
		return this.driver;
	}
	
	public void closeDriver(){
		this.driver.close();
	}
	
	public void quitDriver(){
		this.driver.quit();
	}


}
