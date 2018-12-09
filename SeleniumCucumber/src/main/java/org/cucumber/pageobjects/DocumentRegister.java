package org.cucumber.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DocumentRegister {
	
	public DocumentRegister(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "searchQuery")
	private WebElement searchTextBox;
	
	@FindBy(how = How.ID, using = "btnSearch_page")
	private WebElement searchButton;
	
	@FindBy(how = How.ID, using = "resultTable")
	private WebElement resultTable;
	

	public WebElement getSearchTextBox() {
		return searchTextBox;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getResultTable() {
		return resultTable;
	}
	
}
