package org.cucumber.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.cucumber.stepdefinitions.CucumberHooks;

public class ConfigFileReader {
	private Properties projectConfigProperty = new Properties();
	private static final String PROJECT_CONFIG_PROPERTY_FILEPATH = "src/main/resources/properties/projectconfig.properties";
	private static final Logger log = Logger.getLogger(CucumberHooks.class);
	
	public ConfigFileReader(){
		try {
			FileReader fileReader = new FileReader(PROJECT_CONFIG_PROPERTY_FILEPATH);
			BufferedReader bufReader = new BufferedReader(fileReader);
			projectConfigProperty.load(bufReader);
		} catch (IOException e) {
			System.out.println("Project specific property file 'projectconfig.properties' is missing. Please configure and proceed");
			System.exit(0);
		}
	}

	public Properties getProjectConfigProperty() {
		return projectConfigProperty;
	}
	
	public String getJSONTestDataPath(){
		return projectConfigProperty.getProperty("jsonpath");
	}
	
	public String getExcelTestDataPath(){
		return projectConfigProperty.getProperty("excelpath");
	}
	
	public String getuploadableFilesPath(){
		return projectConfigProperty.getProperty("uploadablefilespath");
	}

}
