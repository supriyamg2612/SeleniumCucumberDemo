package io.opencart.userauthentication.stepdefinition;
	


import org.junit.Assert;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.opencart.userauthentication.base.BaseClass;
import io.opencart.userauthentication.pages.HomePageOpenCart;
import io.opencart.userauthentication.pages.LoginPageOpenCart;

public class LoginStepDefinition extends BaseClass {
		
		
LoginPageOpenCart lp = null;
HomePageOpenCart homePage = null;
		
		
	@Before
	public void setUp() throws Exception {
	initialization();
			
	lp = new LoginPageOpenCart(driver);
	homePage = new HomePageOpenCart(driver);
			
	}
		
	@After
	public void tearDown() {
		 driver.close();
	 }
	
		
		
	@Given("^user should be on login page$")
	public void user_should_be_on_login_page() throws Throwable {
			
	lp=homePage.navigateTologinPage();
			
	}
	
	@Then("^user verify title of login page$")
	public void user_verify_title_of_login_page() throws Throwable {
		String  actualTitleOfLoginPage = "Account Login";
		String  expectedTitleOfLoginPage = driver.getTitle();
	   Assert.assertEquals(actualTitleOfLoginPage, expectedTitleOfLoginPage);
		}
	
		
		
	@When("^user enters valid login data and clicks the login button$")
	public void user_enters_valid_login_data_and_clicks_the_login_button() throws Throwable {
		lp.validLogin();
	}

	@Then("^user should be redirected to the dashboard page$")
	public void user_should_be_redirected_to_the_dashboard_page() throws Throwable {
		String currentUrl = driver.getCurrentUrl();
	   Assert.assertTrue("User is not redirected to the account page", currentUrl.contains("route=account/account"));
	}
	
	@Then("^the user should see the logout link$")
	public void the_user_should_see_the_logout_link() throws Throwable {
	Assert.assertTrue(lp.isUserOnDashboard());
		}
	
	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String email, String password) throws Throwable {
	lp.loginToApplication(email, password);
		}
	
	@Then("^user verify the \"([^\"]*)\"$")
	public void user_verify_the(String message) throws Throwable {
	Assert.assertTrue(lp.isErrorMessageDisplayedForInvalidCredentials());
		    
		}
	
	
	
	}
