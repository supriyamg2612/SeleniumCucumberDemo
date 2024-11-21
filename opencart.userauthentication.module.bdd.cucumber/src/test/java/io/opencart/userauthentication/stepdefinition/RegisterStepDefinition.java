package io.opencart.userauthentication.stepdefinition;

import java.util.HashMap;
import java.util.Map;


import org.junit.Assert;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.opencart.userauthentication.base.BaseClass;
import io.opencart.userauthentication.pages.AccountSuccessPageOpenCart;
import io.opencart.userauthentication.pages.HomePageOpenCart;
import io.opencart.userauthentication.pages.RegisterPageOpenCart;

public class RegisterStepDefinition extends BaseClass {
	
	
	HomePageOpenCart homePage = null;
	RegisterPageOpenCart registerPage =null;
	AccountSuccessPageOpenCart accountsuccesspage =null;
	
	
	
	@Before
	public void setUp() throws Exception {
		 System.out.println("Initializing WebDriver...");
		    initialization();
		    System.out.println("WebDriver initialized");
	registerPage = new RegisterPageOpenCart(driver);
	homePage = new HomePageOpenCart(driver);
			
	}
		
	@After
	public void tearDown() {
		 System.out.println("Closing WebDriver...");
		if (driver != null) {
	        driver.quit(); 
	        driver = null;
	        System.out.println("WebDriver closed");
	        // Completely closes browser and ends session
	    }
	 }
	
	
	
	@Given("^the user is on the registration page$")
	public void the_user_is_on_the_registration_page() throws Throwable {
		registerPage=homePage.navigateToRegisterPage();
	}

	@When("^the user enters valid details:$")
	public void the_user_enters_valid_details(DataTable dataTable) throws Throwable {
		Map<String, String> userDetails = new HashMap<>(dataTable.asMap(String.class, String.class));  // Create a new mutable map

        // Generate a unique email address
        String uniqueEmail = "testuser" + System.currentTimeMillis() + "@example.com";
        
        
        System.out.println("Generated Email: " + uniqueEmail);        
        // Update the email in the user details
        userDetails.put("Email Address", uniqueEmail);

        // Now use this updated map to populate the registration form
        registerPage.getFirstNameField().sendKeys(userDetails.get("First Name"));
        registerPage.getLastNameField().sendKeys(userDetails.get("Last Name"));
        registerPage.getEmailField().sendKeys(userDetails.get("Email Address"));
        registerPage.getTelephoneField().sendKeys(userDetails.get("Telephone"));
        registerPage.getPasswordField().sendKeys(userDetails.get("Password"));
        registerPage.getPasswordConfirmField().sendKeys(userDetails.get("Confirm Password"));
	}

	@When("^the user agrees to the Privacy Policy$")
	public void the_user_agrees_to_the_Privacy_Policy() throws Throwable {
		registerPage.getPrivacyPolicyOption().click();
	}

	@When("^the user clicks the continue button$")
	public void the_user_clicks_the_continue_button() throws Throwable {
		registerPage.clickOnContinueButton();
	} 

	@Then("^User account should get created successfully$")
	public void user_account_should_get_created_successfully() throws Throwable {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue("User account creation failed!", currentUrl.contains("route=account/success"));
	}

	@When("^User selects Yes for Newsletter$")
	public void user_selects_Yes_for_Newsletter() throws Throwable {
		registerPage.selectYesNewsletterOption();
	}

	@When("^the user enters details with duplicate email$")
	public void the_user_enters_details_with_duplicate_email(DataTable dataTable) throws Throwable {
        Map<String, String> userDetails = new HashMap<>(dataTable.asMap(String.class, String.class));
        String duplicateEmail = "lester.redden@gmail.com";
        userDetails.put("Email Address", duplicateEmail);
        registerPage.getFirstNameField().sendKeys(userDetails.get("First Name"));
        registerPage.getLastNameField().sendKeys(userDetails.get("Last Name"));
        registerPage.getEmailField().sendKeys(userDetails.get("Email Address"));
        registerPage.getTelephoneField().sendKeys(userDetails.get("Telephone"));
        registerPage.getPasswordField().sendKeys(userDetails.get("Password"));
        registerPage.getPasswordConfirmField().sendKeys(userDetails.get("Confirm Password"));
	}

	@Then("^User should get a proper warning about duplicate email$")
	public void user_should_get_a_proper_warning_about_duplicate_email() throws Throwable {
	   WebElement WarningMessage = registerPage.getWarningMessageText();
	   String actualWarningMessage = WarningMessage.getText();
	   Assert.assertEquals(actualWarningMessage, "Warning: E-Mail Address is already registered!");
	}

	@When("^the user leaves all fields blank$")
	public void the_user_leaves_all_fields_blank() throws Throwable {
		registerPage.getFirstNameField().clear();
	    registerPage.getLastNameField().clear();
	    registerPage.getEmailField().clear();
	    registerPage.getTelephoneField().clear();
	    registerPage.getPasswordField().clear();
	    registerPage.getPasswordConfirmField().clear();
	}



	@Then("^the user should see error messages for all mandatory fields:$")
	public void the_user_should_see_error_messages_for_all_mandatory_fields(DataTable errorMessages) throws Throwable {
		 
		 Map<String, String> expectedErrorMessages = errorMessages.asMap(String.class, String.class);
		assertErrorMessage(expectedErrorMessages, "First Name", registerPage.getFirstNameWarningText());
		    assertErrorMessage(expectedErrorMessages, "Last Name", registerPage.getLastNameWarningText());
		    assertErrorMessage(expectedErrorMessages, "Email Address", registerPage.getEmailWarningText());
		    assertErrorMessage(expectedErrorMessages, "Telephone", registerPage.getTelephoneWarningText());
		    assertErrorMessage(expectedErrorMessages, "Password", registerPage.getPasswordWarningText());
		
	}
		// Helper method to compare actual and expected error messages
		private void assertErrorMessage(Map<String, String> expectedMessages, String fieldName, WebElement actualWarningElement) {
		    String expectedMessage = expectedMessages.get(fieldName);
		    String actualMessage = actualWarningElement.getText().trim();  // Get the text from the warning element and trim any extra spaces

		    // Use an assertion to compare the actual and expected messages
		    Assert.assertEquals("Error message for " + fieldName + " does not match!", expectedMessage, actualMessage);

		
	}

	@When("^the user enters \"([^\"]*)\" in the Password field$")
	public void the_user_enters_in_the_Password_field(String password) throws Throwable {
		registerPage.getPasswordField().sendKeys(password);
	}

	@When("^enters \"([^\"]*)\" in the Confirm Password field$")
	public void enters_in_the_Confirm_Password_field(String confirmPassword) throws Throwable {
		registerPage.getPasswordConfirmField().sendKeys(confirmPassword);
	}

	@Then("^the user should see an error message$")
	public void the_user_should_see_an_error_message() throws Throwable {
		WebElement errorMessageElement = registerPage.getConfirmPasswordWaringText(); 
		 String actualErrorMessage = errorMessageElement.getText().trim();
		 String expectedErrorMessage = "Password confirmation does not match password!"; 
		  
		 Assert.assertEquals("Error message does not match!", expectedErrorMessage, actualErrorMessage);

	}



}
