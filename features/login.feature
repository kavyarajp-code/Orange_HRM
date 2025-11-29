
Feature: logging  in

Scenario: Log in with valid credentials
Given the user in the login page for logging in with valid credentials
When he enteres valid details and submits
Then the system navigates to home page

Scenario: Log in with invalid credentials
Given the user in the login page for logging in with invalid credentials
When he enteres invalid details and submits
Then the system displays the error message