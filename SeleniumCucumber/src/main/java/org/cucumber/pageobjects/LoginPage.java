package org.cucumber.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(how=How.ID, using="userName")
	private WebElement userName;
	
	@FindBy(how=How.ID, using="password")
	private WebElement password;
	
	@FindBy(how=How.ID, using="login")
	private WebElement loginBtn;
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	
	/*
	public void launchApplication(){
		String url = FileReaderHandler.getInstance().getConfigFileReader().getProjectConfigProperty().getProperty("url");
		this.driver.get(url);
		new Application(this.driver).waitForPageToLoad();
		log.info("Successfully launched application: '" + url + "'");
	}
	
	public void enterUserName(String usn){
		userName.clear();
		userName.sendKeys(usn);
		log.info("Entered username: '" + usn + "' in username field");
	}
	
	public void enterPassword(String pwd){
		password.clear();
		password.sendKeys(pwd);
		log.info("Entered password: '" + pwd + "' in password field");
	}
	
	public void clickOnLoginButton(){
		loginBtn.click();
		new Application(this.driver).waitForPageToLoad();
		log.info("Clicked on login button");
	}
	
	public void loginToApplication(String usn, String pwd){
		enterUserName(usn);
		enterPassword(pwd);
		clickOnLoginButton();
	}*/

}
