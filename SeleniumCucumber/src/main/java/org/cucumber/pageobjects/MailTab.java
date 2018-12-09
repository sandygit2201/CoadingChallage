package org.cucumber.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MailTab {

	@FindBy(how = How.XPATH, using = "//div[@id='nav-bar-CORRESPONDENCE-CORRESPONDENCE-CREATEMAIL']")
	private WebElement blankMailLink;
	
	public MailTab(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getBlankMailLink() {
		return blankMailLink;
	}

}
