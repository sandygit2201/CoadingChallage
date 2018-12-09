package org.cucumber.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WorkFlowTab {
	
	public WorkFlowTab(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='nav-bar-WORKFLOW-SavedSearches']//div[contains(text(), 'Assigned to my organization')]")
	private WebElement assignedToMyOrgLink;

	public WebElement getAssignedToMyOrgLink() {
		return assignedToMyOrgLink;
	}
	
	

	/*public void clickOnAssignedToMyOrgLink(){
		assignedToMyOrgLink.click();
		log.info("Clicked on 'Assigned to My Organization' link");
	}*/


}
