package org.cucumber.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TransmittalMail {

	public TransmittalMail(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "SPEED_ADDRESS_TO")
	private WebElement recepientTextBox;

	@FindBy(how=How.XPATH, using="//input[@id='Distribution_emailFlag']/preceding-sibling::label")
	private WebElement selectedRecepientElement;
	
	@FindBy(how = How.ID, using = "Correspondence_subject")
	private WebElement mailSubjectTextBox;
	
	@FindBy(how=How.XPATH, using="//div[@id='multiselect0']")
	private WebElement atrribute1TextBox;
	
	@FindBy(how=How.XPATH, using="//div[@id='multiselect1']")
	private WebElement atrribute2TextBox;
	
	@FindBy(how=How.XPATH, using="//div[@id='attributeBidi_PRIMARY_ATTRIBUTE']/div[@class='uiBidi-left']//select")
	private WebElement availableAttribute1ListBox;
	
	
	@FindBy(how=How.XPATH, using="//div[@id='attributeBidi_PRIMARY_ATTRIBUTE']//div[contains(text(),'>>')]")
	private WebElement availableAttribute1AddButton;
	
	@FindBy(how=How.XPATH, using="//div[@id='attributeBidi_SECONDARY_ATTRIBUTE']/div[@class='uiBidi-left']//select")
	private WebElement availableAttribute2ListBox;
	
	@FindBy(how=How.XPATH, using="//div[@id='attributeBidi_SECONDARY_ATTRIBUTE']//div[contains(text(),'>>')]")
	private WebElement availableAttribute2AddButton;
	
	@FindBy(how=How.XPATH, using="//button[@id='attributePanel-commit']//div[contains(text(),'OK')]")
	private WebElement okButton;
	
	@FindBy(how=How.XPATH, using="//textarea[@id='details']/following-sibling::acx-rich-text-field//textarea")
	private WebElement messageBodyTextarea;
	
	@FindBy(how=How.XPATH, using="//div[contains(text(),'Send')]")
	private WebElement sendButton;

	public WebElement getRecepientTextBox() {
		return recepientTextBox;
	}

	public WebElement getSelectedRecepientElement() {
		return selectedRecepientElement;
	}

	public WebElement getMailSubjectTextBox() {
		return mailSubjectTextBox;
	}

	public WebElement getAtrribute1TextBox() {
		return atrribute1TextBox;
	}

	public WebElement getAtrribute2TextBox() {
		return atrribute2TextBox;
	}

	public WebElement getAvailableAttribute1ListBox() {
		return availableAttribute1ListBox;
	}

	public WebElement getAvailableAttribute1AddButton() {
		return availableAttribute1AddButton;
	}

	public WebElement getAvailableAttribute2ListBox() {
		return availableAttribute2ListBox;
	}

	public WebElement getAvailableAttribute2AddButton() {
		return availableAttribute2AddButton;
	}

	public WebElement getOkButton() {
		return okButton;
	}

	public WebElement getMessageBodyTextarea() {
		return messageBodyTextarea;
	}

	public WebElement getSendButton() {
		return sendButton;
	}
	

}
