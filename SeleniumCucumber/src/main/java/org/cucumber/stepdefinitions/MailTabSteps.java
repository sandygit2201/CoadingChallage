package org.cucumber.stepdefinitions;

import org.cucumber.handlers.ApplicationContext;
import org.cucumber.pageobjects.MailTab;
import org.cucumber.pageobjects.WorkFlowTab;
import org.cucumber.utils.Application;

import cucumber.api.java.en.And;

public class MailTabSteps {
	private ApplicationContext context;
	private MailTab mailTab;
	private Application application;
	private static final String FRAME_CONTEXT = "Parent";
	
	public MailTabSteps(ApplicationContext context){
		this.context = context;
		mailTab = this.context.getPageObjectHandler().getMailTab();
		this.application = this.context.getApplication();
	}
	
	@And("^Click on \"Blank Mail\" link$")
	public void clickOnBlankMailLink(){
		this.application.click(mailTab.getBlankMailLink(), FRAME_CONTEXT);
	}
	

}
