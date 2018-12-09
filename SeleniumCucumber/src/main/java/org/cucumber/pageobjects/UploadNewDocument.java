package org.cucumber.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class UploadNewDocument {
	
	public UploadNewDocument(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//div[@id='docno']/input")
	private WebElement documentNoTextBox;
	
	@FindBy(how=How.XPATH, using="//div[@id='revision_0']/input")
	private WebElement revisionNumber;
	
	@FindBy(how=How.XPATH, using="//div[@id='title_0']/input")
	private WebElement titleTextBox;

	@FindBy(how=How.XPATH, using="//select[@id='doctype_0']")
	private WebElement typeDropDown;
	
	@FindBy(how=How.XPATH, using="//select[@id='docstatus_0']")
	private WebElement statusDropDown;
	
	@FindBy(how=How.XPATH, using="//div[@id='attribute1_0']")
	private WebElement attribute1Element;
	
	@FindBy(how=How.XPATH, using="//div[@id='attribute1_0_bidi']/div[@class='uiBidi-left']//select")
	private WebElement availableAttributeListBox;
	
	@FindBy(how=How.XPATH, using="//div[@id='attribute1_0_bidi']/div[@class='uiBidi-right']//select")
	private WebElement selectedAttributeListBox;
	
	@FindBy(how=How.XPATH, using="//div[@id='attribute1_0_bidi']//div[contains(text(),'>>')]")
	private WebElement addButton;
	
	@FindBy(how=How.XPATH, using="//button[@id='attribute1_0_panel-commit']//div[contains(text(),'OK')]")
	private WebElement okButton;
	
	@FindBy(how=How.XPATH, using="//input[@id='associatedfile_0']")
	private WebElement uploadFile;
	
	@FindBy(how=How.XPATH, using="//button[@id='btnUploadDocument']")
	private WebElement uploadButton;
	
	@FindBy(how=How.XPATH, using="//span[@id='clickToUpload']")
	private WebElement clickToUploadLink;
	
	@FindBy(how=How.XPATH, using="//div[@id='selected_file_name']")
	private WebElement selectedFileNameDiv;
	
	@FindBy(how=How.XPATH, using="//button[@id='regSuccessPanel-cancel']")
	private WebElement uploadSuccessfulPopCancelButton;
	
	@FindBy(how=How.XPATH, using="//div[@id='regSuccessPanel']//span")
	private WebElement uploadSuccessfulMessage;
	
	
	
	
	public WebElement getDocumentNoTextBox() {
		return documentNoTextBox;
	}


	public WebElement getRevisionNumber() {
		return revisionNumber;
	}


	public WebElement getTitleTextBox() {
		return titleTextBox;
	}


	public WebElement getStatusDropDown() {
		return statusDropDown;
	}


	public WebElement getAttribute1Element() {
		return attribute1Element;
	}


	public WebElement getAvailableAttributeListBox() {
		return availableAttributeListBox;
	}


	public WebElement getSelectedAttributeListBox() {
		return selectedAttributeListBox;
	}


	public WebElement getAddButton() {
		return addButton;
	}


	public WebElement getOkButton() {
		return okButton;
	}


	public WebElement getTypeDropDown() {
		return typeDropDown;
	}


	public WebElement getUploadFile() {
		return uploadFile;
	}


	public WebElement getUploadButton() {
		return uploadButton;
	}


	public WebElement getClickToUploadLink() {
		return clickToUploadLink;
	}


	public WebElement getSelectedFileNameDiv() {
		return selectedFileNameDiv;
	}


	public WebElement getUploadSuccessfulPopCancelButton() {
		return uploadSuccessfulPopCancelButton;
	}


	public WebElement getUploadSuccessfulMessage() {
		return uploadSuccessfulMessage;
	}
	
	//private WebElement docNumberTextBox;
	

}
