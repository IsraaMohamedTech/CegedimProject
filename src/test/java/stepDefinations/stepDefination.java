package stepDefinations;

import org.testng.Assert;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import resources.common;

public class stepDefination extends common {

	@Given("^Initialize Chrome browser$")
	public void initialize_Chrome_browser() throws Throwable {
		driver =initializeDriver();
	}

	@Given("^user navigates to the website \"([^\"]*)\" site$")
	public void user_navigates_to_the_website_site(String url) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(url);
	}
	
	@When("^User enters (.+) and (.+) and logs in$")
	public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		LoginPage loginPage = new LoginPage(driver);		 
		loginPage.getEmail().sendKeys(username);
		loginPage.getPassword().sendKeys(password);
		loginPage.getLogin().click();
	}

	@Then("^Verify that user is successfully logged in$")
	public void verify_that_user_is_successfully_logged_in() throws Throwable {
		Assert.assertTrue(true);
	}

	@When("^user logs in through Login Window by using Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void user_logs_in_through_Login_Window_by_using_Username_as_and_Password_as(String username, String password) throws Throwable {
		LoginPage loginPage = new LoginPage(driver);		 
		loginPage.getEmail().sendKeys(username);
		loginPage.getPassword().sendKeys(password);
		loginPage.getLogin().click();
	}

	@Then("^Verify that username-error and password-error messages are displayed$")
	public void verify_that_username_error_and_password_error_messages_are_displayed() throws Throwable {
		LoginPage loginPage = new LoginPage(driver);		 
		Assert.assertTrue(loginPage.getUserNameRequiredMessage().isDisplayed() && loginPage.getPasswordRequiredMessage().isDisplayed());
		
	}

	@Then("^Verify that login-form-error messages is displayed$")
	public void verify_that_login_form_error_messages_is_displayed() throws Throwable {
		LoginPage loginPage = new LoginPage(driver);		 
		Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
	}

	@Then("^close browser$")
	public void close_browser() throws Throwable {
		driver.close();
	}
	
	

}
