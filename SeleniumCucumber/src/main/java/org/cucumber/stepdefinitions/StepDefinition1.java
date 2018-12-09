package org.cucumber.stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition1{
	
	
	@Given("^Run before each scenario$")
	public void runBeforeEachScenario(){
		System.out.println("Background");
	}

	@Given("^The price of (\\w+) is 40c$")
	public void method1(String fruit){
		System.out.println("method1" + fruit);
	}
	
	@When("^I checkout 1 banana$")
	public void method2(){
		System.out.println("method2");
	}
	
	@Then("^The total price should be 40c$")
	public void method3(){
		System.out.println("method3");
	}
	
	
	
}
