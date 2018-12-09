package org.cucumber.stepdefinitions;

import java.io.File;
import java.io.FileReader;

import org.cucumber.dataobjects.NewDocument;
import org.cucumber.handlers.ApplicationContext;
import org.cucumber.handlers.FileReaderHandler;
import org.cucumber.handlers.JSONDataReader;
import org.cucumber.pageobjects.UploadNewDocument;
import org.cucumber.utils.Application;

import cucumber.api.java.en.Then;

public class UploadNewDocumentSteps {
	private ApplicationContext context;
	private UploadNewDocument uploadNewDocument;
	private Application application;
	private static final String FRAME_CONTEXT = "Child";
	
	public UploadNewDocumentSteps(ApplicationContext context){
		this.context = context;
		uploadNewDocument = this.context.getPageObjectHandler().getUploadNewDocument();
		this.application = this.context.getApplication();
	}
	
	@Then("^Enter new document details from \"([^\"]*)\"$")
	public void enterDocNumber(String documentName){
		JSONDataReader jsonDataReader = this.context.getJSONDataReader();
		NewDocument obj = jsonDataReader.getNewDocumentDataFromJSON(documentName);
		String docNumber = this.application.enterUniqueText(uploadNewDocument.getDocumentNoTextBox(), obj.getDocNumber(), FRAME_CONTEXT);
		String revNumber = this.application.enterUniqueText(uploadNewDocument.getRevisionNumber(), obj.getRevision(), FRAME_CONTEXT);
		String title = this.application.enterUniqueText(uploadNewDocument.getTitleTextBox(), obj.getTitle(), FRAME_CONTEXT);
		this.application.selectByVisibleTextFromDropdown(uploadNewDocument.getTypeDropDown(), obj.getType(), FRAME_CONTEXT);
		this.application.selectByVisibleTextFromDropdown(uploadNewDocument.getStatusDropDown(), obj.getStatus(), FRAME_CONTEXT);
		this.application.click(uploadNewDocument.getAttribute1Element(), FRAME_CONTEXT);
		this.application.selectByVisibleTextFromDropdown(uploadNewDocument.getAvailableAttributeListBox(), obj.getAttribute1(), FRAME_CONTEXT);
		this.application.click(uploadNewDocument.getAddButton(), FRAME_CONTEXT);
		this.application.click(uploadNewDocument.getOkButton(), FRAME_CONTEXT);
		this.application.click(uploadNewDocument.getClickToUploadLink(), FRAME_CONTEXT);
		String filePath = FileReaderHandler.getInstance().getConfigFileReader().getuploadableFilesPath();
		filePath = filePath + "//" + obj.getUploadFileName();
		File fi = new File(filePath);
		filePath = fi.getAbsolutePath();
		this.application.uploadFileWithRobot(filePath);
		this.application.verifyText(uploadNewDocument.getSelectedFileNameDiv(), obj.getUploadFileName(), FRAME_CONTEXT);
		this.application.click(uploadNewDocument.getUploadButton(), FRAME_CONTEXT);
		this.application.verifyText(uploadNewDocument.getUploadSuccessfulMessage(),"Document Uploaded Successfully", FRAME_CONTEXT);
		this.application.click(uploadNewDocument.getUploadSuccessfulPopCancelButton(), FRAME_CONTEXT);
		this.application.waitForSomeTime(3000L);
		obj.setDocNumber(docNumber);
		obj.setRevision(revNumber);
		obj.setTitle(title);
	}
	
	

}
