package org.cucumber.stepdefinitions;

import org.cucumber.dataobjects.TransmittalMailDataObject;
import org.cucumber.handlers.ApplicationContext;
import org.cucumber.pageobjects.NewMail;
import org.cucumber.pageobjects.TransmittalMail;
import org.cucumber.pageobjects.ViewMail;
import org.cucumber.pageobjects.WorkFlowTab;
import org.cucumber.utils.Application;
import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ViewMailSteps {
	private ApplicationContext context;
	private ViewMail viewMail;
	private Application application;
	private static final String FRAME_CONTEXT = "Child";
	
	public ViewMailSteps(ApplicationContext context){
		this.context = context;
		viewMail = this.context.getPageObjectHandler().getViewMail();
		this.application = this.context.getApplication();
	}
	
	@And("^Verify sent mail content$")
	public void verifySentTransmittalMailContent(){
		TransmittalMailDataObject transMailObj = this.context.getJSONDataReader().getTransmittalMailDataObject();
		Assert.assertEquals(transMailObj.getSubject(), this.application.getElementText(viewMail.getMailHeader(), FRAME_CONTEXT));
		if(!this.application.getElementText(viewMail.getRecepientText(), FRAME_CONTEXT).toLowerCase().contains(transMailObj.getTo().toLowerCase()))
				throw new RuntimeException("Recipients are not matching");
	}
	
	
}
