package org.cucumber.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AssignedToMyOrganization {
	
	public AssignedToMyOrganization(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='numResults']/b[2]")
	private WebElement noOfresults;

	public WebElement getNoOfresults() {
		return noOfresults;
	}


}
