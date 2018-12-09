package org.cucumber.stepdefinitions;

import org.cucumber.handlers.ApplicationContext;
import org.cucumber.pageobjects.NewMail;
import org.cucumber.utils.Application;

import cucumber.api.java.en.Then;

public class NewMailSteps {
	private ApplicationContext context;
	private NewMail newMail;
	private Application application;
	private static final String FRAME_CONTEXT = "Child";
	
	public NewMailSteps(ApplicationContext context){
		this.context = context;
		newMail = this.context.getPageObjectHandler().getNewMail();
		this.application = this.context.getApplication();
	}
	
	@Then("^Select \"Type\" as \"([^\"]*)\"$")
	public void selectMailTypeFromDropdown(String mailType){
		this.application.selectByVisibleTextFromDropdown(newMail.getMailTypeDropdown(), mailType, FRAME_CONTEXT);
	}
	
}
