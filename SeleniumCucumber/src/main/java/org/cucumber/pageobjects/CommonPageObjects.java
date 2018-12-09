package org.cucumber.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CommonPageObjects {
	
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Mrs coding challenge')]")
	private WebElement logOutSpan;
	
	@FindBy(how=How.ID, using="logoff")
	private WebElement logoutLink;
	
	
	public CommonPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}


	public WebElement getLogOutSpan() {
		return logOutSpan;
	}


	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
	
	/*
	public void verifyPageTitle(String pageTitle){
		String actPageTitle = this.driver.getTitle();
		Assert.assertEquals(pageTitle, actPageTitle);
		log.info("Expected page Title: '" + pageTitle + "' Actual page tile '" + actPageTitle + "'");
	}

	public void logOut(){
		logOutSpan.click();
		new Application(this.driver).waitForPageToLoad();
		logoutLink.click();
		new Application(this.driver).waitForPageToLoad();
		log.info("Clicked on log off link");
	}*/
	
}
