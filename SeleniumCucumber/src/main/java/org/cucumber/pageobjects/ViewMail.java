package org.cucumber.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ViewMail {

	public ViewMail(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//h2[@data-automation-id='mailHeader-subject']/span")
	private WebElement mailHeader;
	
	@FindBy(how = How.XPATH, using = "//mail-recipients[@recipients='mail.toRecipients']/descendant::span[last()]")
	private WebElement recepientText;

	public WebElement getMailHeader() {
		return mailHeader;
	}

	public WebElement getRecepientText() {
		return recepientText;
	}


}
