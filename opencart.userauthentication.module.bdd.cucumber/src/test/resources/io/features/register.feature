Feature: OpenCart User Authentication (Register) Test
The purpose of this feature is to verify the functionality of user registration on the application.

Background:
Given the user is on the registration page


Scenario: User successfully registers a new account only with mandatory fields
When the user enters valid details:
  	| Field            | Value                  	|
    | First Name       | Lester                 	|
    | Last Name        | Redden                 	|
    | Email Address    | lesterredden123@gmail.com  |
    | Telephone        | 1234567811            	|
    | Password         | tutorialsninja@1234       |
    | Confirm Password | tutorialsninja@1234       |
And the user agrees to the Privacy Policy
And the user clicks the continue button
Then User account should get created successfully


Scenario: User creates an account with all fields
When the user enters valid details:
 | Field            | Value                  	|
    | First Name       | Lester                 	|
    | Last Name        | Redden                 	|
    | Email Address    | lester.redden@gmail.com  |
    | Telephone        | 9988998899             	|
    | Password         | tutorialsninja@123       |
    | Confirm Password | tutorialsninja@123       |
And User selects Yes for Newsletter
And the user agrees to the Privacy Policy
And the user clicks the continue button
Then User account should get created successfully


Scenario: User creates a duplicate account
When the user enters details with duplicate email
		| Field            | Value                  	|
    | First Name       | Lester                 	|
    | Last Name        | Redden                 	|
    | Email Address    | lester.redden@gmail.com  |
    | Telephone        | 9988998899             	|
    | Password         | tutorialsninja@123       |
    | Confirm Password | tutorialsninja@123       |
And User selects Yes for Newsletter
And the user agrees to the Privacy Policy
And the user clicks the continue button
Then User should get a proper warning about duplicate email


Scenario: User attempts to register with all fields blank
 When the user leaves all fields blank
 And the user clicks the continue button
 Then the user should see error messages for all mandatory fields:
    | Field            | Error Message                  												 |
    | First Name       | First Name must be between 1 and 32 characters!		     |
    | Last Name        | Last Name must be between 1 and 32 characters!        	 |
    | Email Address    | E-Mail Address does not appear to be valid!   			 		 |
    | Telephone        | Telephone must be between 3 and 32 characters!       	 |
    | Password         | Password must be between 4 and 20 characters!      		 |
   

Scenario: User enters mismatched passwords during registration
 Given the user is on the registration page
 When the user enters "Password123" in the Password field
 And enters "Password321" in the Confirm Password field
 And the user clicks the continue button
 Then the user should see an error message 