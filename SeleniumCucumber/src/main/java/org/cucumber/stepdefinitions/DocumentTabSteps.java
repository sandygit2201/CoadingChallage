package org.cucumber.stepdefinitions;

import org.cucumber.handlers.ApplicationContext;
import org.cucumber.pageobjects.DocumentTab;
import org.cucumber.utils.Application;

import cucumber.api.java.en.And;

public class DocumentTabSteps {
	private ApplicationContext context;
	private DocumentTab documentTab;
	private Application application;
	private static final String FRAME_CONTEXT = "parent";
	
	public DocumentTabSteps(ApplicationContext context){
		this.context = context;
		this.documentTab =  this.context.getPageObjectHandler().getDocumentTab();
		this.application = this.context.getApplication();
	}
	
	@And("^Click on \"Upload a New Document\" link$")
	public void clickOnUploadNewDocLink(){
		this.application.click(documentTab.getUploadNewDocLink(), FRAME_CONTEXT);
	}
	
	@And("^Click on \"Document Register\" link$")
	public void clickDocumentsTab(){
		this.application.click(documentTab.getDocumentRegisterLink(),FRAME_CONTEXT);
	}

}
