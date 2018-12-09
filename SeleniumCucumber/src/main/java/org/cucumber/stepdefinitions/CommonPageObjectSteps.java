package org.cucumber.stepdefinitions;

import org.cucumber.handlers.ApplicationContext;
import org.cucumber.pageobjects.CommonPageObjects;
import org.cucumber.utils.Application;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CommonPageObjectSteps {
	private ApplicationContext context;
	private CommonPageObjects commonPageObjects;
	private Application application;
	private static final String FRAME_CONTEXT = "parent";
	
	public CommonPageObjectSteps(ApplicationContext context){
		this.context = context;
		commonPageObjects = this.context.getPageObjectHandler().getCommonPageObjects();
		this.application = this.context.getApplication();
		//FrameSpecificPageObjectClasses.getParentFrameObjectsList().add(commonPageObjects.getClass().getSimpleName());
		//this.application.setClassName(commonPageObjects.getClass().getSimpleName());
	}
	
	@Then("^Page with title \"([^\"]*)\" should be displayed$")
	public void verifyPageTitle(String pageTitle){
		this.application.verifyPageTitle(pageTitle);
	}
	
	@When("^Logout from application$")
	public void logoutFromApplication(){
		this.application.logOut(commonPageObjects.getLogOutSpan(), commonPageObjects.getLogoutLink(), FRAME_CONTEXT);
	}

}
