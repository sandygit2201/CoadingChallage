package org.cucumber.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}


	@FindBy(how = How.XPATH, using = "//span[@id='projectChanger-name']")
	private WebElement projectMenuDropdown;

	@FindBy(how = How.XPATH, using = "//div[contains(@id, 'projectChanger')]")
	private List<WebElement> projectList;

	@FindBy(how = How.ID, using = "nav-bar-DOC")
	private WebElement documentTab;

	@FindBy(how = How.ID, using = "nav-bar-WORKFLOW")
	private WebElement workflowTab;

	@FindBy(how = How.ID, using = "nav-bar-CORRESPONDENCE")
	private WebElement mailTab;

	public WebElement getProjectMenuDropdown() {
		return projectMenuDropdown;
	}

	public List<WebElement> getProjectList() {
		return projectList;
	}

	public WebElement getDocumentTab() {
		return documentTab;
	}

	public WebElement getWorkflowTab() {
		return workflowTab;
	}

	public WebElement getMailTab() {
		return mailTab;
	}
	
	/*
	public void selectProjectFormProjectMenu(String projectName) {
		clickOnProjectMenu();
		clickOnGivenProject(projectName);
	}

	public void clickOnProjectMenu() {
		projectMenuDropdown.click();
		log.info("Clicked on project menu dropdown link");
	}

	public void clickOnGivenProject(String projectName) {
		if (projectList.size() == 0)
			throw new NoSuchElementException();
		for (WebElement project : projectList) {
			if (projectName.equalsIgnoreCase(project.getText())) {
				project.click();
				log.info("Clicked on '" + projectName + "' from project menu dropdown");
				break;
			}
		}
	}

	public void clickOnDocumentTab() {
		documentTab.click();
		log.info("Clicked on 'Document' tab");
	}

	public void clickOnWorkflowTab() {
		workflowTab.click();
		log.info("Clicked on 'Workflow' tab");
	}

	public void clickOnMailTab() {
		mailTab.click();
		log.info("Clicked on 'Mail' tab");
	}
	
	public void selectProject(String projectName){
		clickOnProjectMenu();
		clickOnGivenProject(projectName);
	}
	*/
	
}
