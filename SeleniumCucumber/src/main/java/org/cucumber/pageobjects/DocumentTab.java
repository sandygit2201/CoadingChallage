package org.cucumber.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DocumentTab {
	
	public DocumentTab(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how = How.ID, using = "nav-bar-DOC-DOC-NEW")
	private WebElement uploadNewDocLink;
	
	
	@FindBy(how = How.ID, using = "nav-bar-DOC-DOC-SEARCH")
	private WebElement documentRegisterLink;
	

	public WebElement getUploadNewDocLink() {
		return uploadNewDocLink;
	}


	public WebElement getDocumentRegisterLink() {
		return documentRegisterLink;
	}
	
	
/*
	public void clickOnUploadNewDocLink(){
		uploadNewDocLink.click();
		log.info("Clicked on Upload New Documnet Link");
	}*/
}
