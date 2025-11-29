
Feature: Candidate section in Recruitement module



Scenario:Add a new candidate
Given the user navigates to the candidate section in Recruitement module
When user click on Add
And user enter candidate details
And user click on save
Then user navigates to home page

@rec
Scenario: Add a new inv candidate
Given the user navigates to the candidate section in Recruitement module for inv

When user click on Add for inv
And user enter invalid candidate details
And user click on save for inv
Then system shows an error message


Scenario Outline:Search candidate by Job Title
Given the user navigates to the candidate section in Recruitement module for search using jobtitle
When user select job title "<jobTitle>"
And user click on Search using jobTitle
Then user should see candidates with job title "<jobTitle>"
Examples:
    | jobTitle          |
    | Software Engineer |
    | Account Assistant |
    | Payroll Administrator  |
    | Automaton Tester  |



Scenario: Search candidate by Vacancy
Given the user navigates to the candidate section in Recruitement module for search using vacancy
When user select vacancy "<vacancy>"
And user click on Search using vacancy
Then user should see candidates under vacancy "<vacancy>"
Examples:
  |   vacancy          |
  |  Payroll Administrator   |
  |    test   |
  |Software Engineer   |
  |Senior QA Lead   |

Scenario: Reset candidate search form
Given the user navigates to the candidate section in Recruitement module for resetting
When user click on Reset
Then all search filters should be cleared


