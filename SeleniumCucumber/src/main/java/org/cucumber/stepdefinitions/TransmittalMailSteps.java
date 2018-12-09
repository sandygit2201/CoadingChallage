package org.cucumber.stepdefinitions;

import org.cucumber.dataobjects.TransmittalMailDataObject;
import org.cucumber.handlers.ApplicationContext;
import org.cucumber.handlers.JSONDataReader;
import org.cucumber.pageobjects.TransmittalMail;
import org.cucumber.utils.Application;

import cucumber.api.java.en.Then;

public class TransmittalMailSteps {
	private ApplicationContext context;
	private TransmittalMail transmittalMail;
	private Application application;
	private static final String FRAME_CONTEXT = "Child";
	
	public TransmittalMailSteps(ApplicationContext context){
		this.context = context;
		transmittalMail = this.context.getPageObjectHandler().getTransmittalMail();
		this.application = this.context.getApplication();
	}
	@Then("^Enter transmittal mail details from \"([^\"]*)\" and send$")
	public void enterTransmittalMailDetails(String fileName){
		JSONDataReader jsonDataReader = this.context.getJSONDataReader();
		TransmittalMailDataObject transmittalMailDataObject = jsonDataReader.getTransmittalMailDataObject(fileName);
		this.application.enterText(transmittalMail.getRecepientTextBox(), transmittalMailDataObject.getTo(), FRAME_CONTEXT);
		this.application.sendKeysEnter(transmittalMail.getRecepientTextBox(), FRAME_CONTEXT);
		this.application.waitForSomeTime(2000);
		this.application.enterText(transmittalMail.getMailSubjectTextBox(), transmittalMailDataObject.getSubject(), FRAME_CONTEXT);
		this.application.click(transmittalMail.getAtrribute1TextBox(), FRAME_CONTEXT);
		this.application.selectByVisibleTextFromDropdown(transmittalMail.getAvailableAttribute1ListBox(), transmittalMailDataObject.getAttribute1(), FRAME_CONTEXT);
		this.application.click(transmittalMail.getAvailableAttribute1AddButton(), FRAME_CONTEXT);
		this.application.selectByVisibleTextFromDropdown(transmittalMail.getAvailableAttribute2ListBox(), transmittalMailDataObject.getAttribute2(), FRAME_CONTEXT);
		this.application.click(transmittalMail.getAvailableAttribute2AddButton(), FRAME_CONTEXT);
		this.application.click(transmittalMail.getOkButton(), FRAME_CONTEXT);
		this.application.enterText(transmittalMail.getMessageBodyTextarea(), transmittalMailDataObject.getMessagebody(), FRAME_CONTEXT);
		this.application.click(transmittalMail.getSendButton(), FRAME_CONTEXT);
	}
}
