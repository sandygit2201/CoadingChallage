package org.cucumber.stepdefinitions;

import org.cucumber.handlers.ApplicationContext;
import org.cucumber.pageobjects.HomePage;
import org.cucumber.utils.Application;

import cucumber.api.java.en.Then;

public class HomePageSteps {
	private HomePage homePage;
	private ApplicationContext context;
	private Application application;
	private static final String FRAME_CONTEXT = "parent";
	
	public HomePageSteps(ApplicationContext context){
		this.context = context;
		this.homePage = this.context.getPageObjectHandler().getHomePage();
		this.application = this.context.getApplication();
	}
	
	@Then("^Select \"([^\"]*)\" from project menu$")
	public void selectProject(String projectName){
		this.application.click(homePage.getProjectMenuDropdown(), FRAME_CONTEXT);
		this.application.clickElementFromList(homePage.getProjectList(), projectName, FRAME_CONTEXT);
	}
	
	@Then("^Click on \"Documents\" tab$")
	public void clickDocumentsTab(){
		this.application.click(homePage.getDocumentTab(),FRAME_CONTEXT);
	}
	
	
	@Then("^Click on \"Workflows\" tab$")
	public void clickWorkflowTab(){
		this.application.click(homePage.getWorkflowTab(),FRAME_CONTEXT);
	}
	
	@Then("^Click on \"Mail\" tab$")
	public void clickMailTab(){
		this.application.click(homePage.getMailTab(),FRAME_CONTEXT);
	}
	
	
}
