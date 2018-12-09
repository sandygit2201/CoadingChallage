package org.cucumber.stepdefinitions;

import org.cucumber.handlers.ApplicationContext;
import org.cucumber.pageobjects.LoginPage;
import org.cucumber.utils.Application;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class LoginPageSteps {
	private LoginPage loginPage;
	private ApplicationContext context;
	private Application application;
	private static final String FRAME_CONTEXT = "parent";

	public LoginPageSteps(ApplicationContext context) {
		this.context = context;
		this.loginPage = this.context.getPageObjectHandler().getLoginPage();
		this.application = this.context.getApplication();
	}

	@Given("^Open Aconex application$")
	public void launchApplication() {
		application.launchApplication();
	}

	@When("^Login to application with (.*) and ([^\"]*)$")
	public void loginToApplication(String usn, String pwd) {
		application.enterText(loginPage.getUserName(), usn, FRAME_CONTEXT);
		application.enterText(loginPage.getPassword(), pwd, FRAME_CONTEXT);
		application.click(loginPage.getLoginBtn(), FRAME_CONTEXT);
	}


}
