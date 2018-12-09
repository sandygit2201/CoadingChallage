package org.cucumber.handlers;

import org.cucumber.pageobjects.AssignedToMyOrganization;
import org.cucumber.pageobjects.CommonPageObjects;
import org.cucumber.pageobjects.DocumentRegister;
import org.cucumber.pageobjects.DocumentTab;
import org.cucumber.pageobjects.HomePage;
import org.cucumber.pageobjects.LoginPage;
import org.cucumber.pageobjects.MailTab;
import org.cucumber.pageobjects.NewMail;
import org.cucumber.pageobjects.TransmittalMail;
import org.cucumber.pageobjects.UploadNewDocument;
import org.cucumber.pageobjects.ViewMail;
import org.cucumber.pageobjects.WorkFlowTab;
import org.openqa.selenium.WebDriver;

public class PageObjectHandler {
	
	private WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;
	private CommonPageObjects commonPageObjects;
	private DocumentTab documentTab;
	private MailTab mailTab;
	private WorkFlowTab workFlowTab; 
	private UploadNewDocument uploadNewDocument;
	private DocumentRegister documentRegister;
	private AssignedToMyOrganization assignedToMyOrganization;
	private NewMail newMail;
	private TransmittalMail transmittalMail;
	private ViewMail viewMail;
	
	
	public PageObjectHandler(WebDriver driver){
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public LoginPage getLoginPage() {
		return loginPage==null?loginPage=new LoginPage(driver):loginPage;
	}
	
	public HomePage getHomePage() {
		return homePage==null?homePage=new HomePage(driver):homePage;
	}

	public DocumentTab getDocumentTab() {
		return documentTab==null?documentTab=new DocumentTab(driver):documentTab;
	}

	public MailTab getMailTab() {
		return mailTab==null?mailTab=new MailTab(driver):mailTab;
	}

	public WorkFlowTab getWorkFlowTab() {
		return workFlowTab==null?workFlowTab=new WorkFlowTab(driver):workFlowTab;
	}

	public CommonPageObjects getCommonPageObjects() {
		return commonPageObjects==null?commonPageObjects=new CommonPageObjects(driver):commonPageObjects;
	}

	public UploadNewDocument getUploadNewDocument() {
		return uploadNewDocument==null?uploadNewDocument=new UploadNewDocument(driver):uploadNewDocument;
	}

	public DocumentRegister getDocumentRegister() {
		return documentRegister==null?documentRegister=new DocumentRegister(driver):documentRegister;
	}

	public AssignedToMyOrganization getAssignedToMyOrganization() {
		return assignedToMyOrganization==null?assignedToMyOrganization=new AssignedToMyOrganization(driver):assignedToMyOrganization;
	}

	public NewMail getNewMail() {
		return newMail==null?newMail=new NewMail(driver):newMail;
	}

	public TransmittalMail getTransmittalMail() {
		return transmittalMail==null?transmittalMail=new TransmittalMail(driver):transmittalMail;
	}

	public ViewMail getViewMail() {
		return viewMail==null?viewMail=new ViewMail(driver):viewMail;
	}
	
	

}
