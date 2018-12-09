package org.cucumber.handlers;

import java.util.HashMap;
import java.util.Map;

import org.cucumber.utils.Application;

public class ApplicationContext {
	private PageObjectHandler pageObjectHandler;
	private WebDriverHandler wedDriverHandler;
	private Map<String, String> scnearioMap = new HashMap<>();
	private Application application;
	private JSONDataReader jsonDataReader;
	
	public ApplicationContext(){
		this.wedDriverHandler = new WebDriverHandler();
		this.pageObjectHandler = new PageObjectHandler(this.wedDriverHandler.getDriver());
		this.application = new Application(this.wedDriverHandler.getDriver());
		this.jsonDataReader = new JSONDataReader();
	}

	public PageObjectHandler getPageObjectHandler() {
		return pageObjectHandler;
	}

	public WebDriverHandler getWedDriverHandler() {
		return wedDriverHandler;
	}

	public Map<String, String> getScnearioMap() {
		return scnearioMap;
	}

	public Application getApplication() {
		return application;
	}
	
	public JSONDataReader getJSONDataReader(){
		return jsonDataReader;
	}



}
