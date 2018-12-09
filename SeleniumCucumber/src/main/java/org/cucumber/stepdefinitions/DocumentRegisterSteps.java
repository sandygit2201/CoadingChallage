package org.cucumber.stepdefinitions;

import java.util.List;

import org.cucumber.dataobjects.NewDocument;
import org.cucumber.handlers.ApplicationContext;
import org.cucumber.pageobjects.DocumentRegister;
import org.cucumber.pageobjects.DocumentTab;
import org.cucumber.utils.Application;
import org.junit.Assert;

import cucumber.api.java.en.And;

public class DocumentRegisterSteps {
	private ApplicationContext context;
	private DocumentRegister documentRegister;
	private Application application;
	private static final String FRAME_CONTEXT = "Child";
	
	public DocumentRegisterSteps(ApplicationContext context){
		this.context = context;
		this.documentRegister =  this.context.getPageObjectHandler().getDocumentRegister();
		this.application = this.context.getApplication();
	}
	
	@And("^Search new document in \"Document Register\" page$")
	public void searchNewDocument(){
		NewDocument newDocObj = this.context.getJSONDataReader().getNewDocumentDataFromJSON();
		this.application.enterText(documentRegister.getSearchTextBox(), newDocObj.getDocNumber(), FRAME_CONTEXT);
		this.application.click(documentRegister.getSearchButton(), FRAME_CONTEXT);
		List<String> tableData = this.application.getTableData(documentRegister.getResultTable(), FRAME_CONTEXT);
		verifyData(tableData, newDocObj.getDocNumber());
		verifyData(tableData, newDocObj.getRevision());
		verifyData(tableData, newDocObj.getTitle());
		verifyData(tableData, newDocObj.getType());
	}
	
	public void verifyData(List<String> tableData, String expectedData){
		boolean isDataMatching = tableData.stream().anyMatch(expectedData::equals);
		if(!isDataMatching)
			throw new RuntimeException("Data Mismatch");
	}

}
