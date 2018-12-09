package org.cucumber.stepdefinitions;

import org.cucumber.handlers.ApplicationContext;
import org.cucumber.pageobjects.WorkFlowTab;
import org.cucumber.utils.Application;

import cucumber.api.java.en.And;

public class WorkFlowTabSteps {
	private ApplicationContext context;
	private WorkFlowTab workFlowTab;
	private Application application;
	private static final String FRAME_CONTEXT = "Parent";
	
	public WorkFlowTabSteps(ApplicationContext context){
		this.context = context;
		workFlowTab = this.context.getPageObjectHandler().getWorkFlowTab();
		this.application = this.context.getApplication();
	}
	
	@And("^Click on \"Assigned to my organization\" link$")
	public void clickOnAssignedToMyOrganizationLink(){
		this.application.click(workFlowTab.getAssignedToMyOrgLink(), FRAME_CONTEXT);
	}
	

}
