package org.cucumber.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewMail {

	public NewMail(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//select[@id='Correspondence_correspondenceTypeID']")
	private WebElement mailTypeDropdown;

	public WebElement getMailTypeDropdown() {
		return mailTypeDropdown;
	}

	

}
