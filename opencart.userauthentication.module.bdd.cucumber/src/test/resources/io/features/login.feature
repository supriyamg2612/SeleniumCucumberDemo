Feature: OpenCart User Authentication (Login) Test

Background:
Given user should be on login page


Scenario: Title Test
Then user verify title of login page



 Scenario: Login Test for valid credentials
    
When user enters valid login data and clicks the login button
Then user should be redirected to the dashboard page 
And the user should see the logout link



 Scenario Outline: Login Test with invalid credentials
When user enters "<email>" and "<password>"
Then user verify the "<message>"

Examples:
    | email                             | password              | message                                                        |
    | celina@gmail.com                  | tutorialsninja@123    | Warning: No match for E-Mail Address and/or Password.         |
    | celina.redden26@gmail.com          | passord@123           | Warning: No match for E-Mail Address and/or Password.         |
    | celina@gmail.com                   | passord@123           | Warning: No match for E-Mail Address and/or Password.         |
    |                                  |                        | Warning: No match for E-Mail Address and/or Password.         |