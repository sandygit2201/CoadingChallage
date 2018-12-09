package org.cucumber.stepdefinitions;

import org.cucumber.handlers.ApplicationContext;
import org.cucumber.pageobjects.AssignedToMyOrganization;
import org.cucumber.utils.Application;
import org.junit.Assert;

import cucumber.api.java.en.Then;

public class AssignedToMyOrganizationSteps {
	private ApplicationContext context;
	private AssignedToMyOrganization assignedToMyOrganization;
	private Application application;
	private static final String FRAME_CONTEXT = "Child";
	
	public AssignedToMyOrganizationSteps(ApplicationContext context){
		this.context = context;
		assignedToMyOrganization = this.context.getPageObjectHandler().getAssignedToMyOrganization();
		this.application = this.context.getApplication();
	}
	
	@Then("^Verify result count is not \"zero\"$")
	public void verifyResultCount(){
		this.application.switchFrameContext(FRAME_CONTEXT);
		String actualResult = assignedToMyOrganization.getNoOfresults().getText();
		Assert.assertNotEquals(0, Integer.parseInt(actualResult));
	}
}
