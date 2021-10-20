Feature: Login into Application

Scenario Outline: Positive test validating login
Given Initialize Chrome browser 
And user navigates to the website "https://app.codility.com/accounts/login/" site
When User enters <username> and <password> and logs in
Then Verify that user is successfully logged in 
And close browser

Examples:
|username			|password	|
|success@codility.com	|123456		|
|success2@codility.com	|987654     |


Scenario: Unsuccessful Login with Invalid entries
Given Initialize Chrome browser 
And user navigates to the website "https://app.codility.com/accounts/login/" site
When user logs in through Login Window by using Username as "faild@codility.com" and Password as "123456"
Then Verify that login-form-error messages is displayed
And close browser

Scenario: Unsuccessful Login with empty entries
Given Initialize Chrome browser 
And user navigates to the website "https://app.codility.com/accounts/login/" site
When user logs in through Login Window by using Username as "" and Password as ""
Then Verify that username-error and password-error messages are displayed
And close browser
