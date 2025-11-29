Feature: MyInfo section in OrangeHRM

 

  Scenario Outline: Saving valid personal details
      Given the user is logged into OrangeHRM and navigates to the My Info module
    When the user opens the Personal Details section for valid
    And the user enters "<firstName>" "<middleName>" "<lastName>"
    Then the user clicks save button for personal details
    Examples:
     | firstName | middleName | lastName | 
      | John      |  G      | Doe      |
      | Alice     | varghese   | Smith    |
      | Raj       | Kumar      | S  |
      | Maria     | C          | L   |
  


  Scenario Outline: Update invalid contact details
      Given the user is logged into OrangeHRM and navigates to the My Info module for inv phone
    When the user navigates to the Contact Details section for inv
    And the user updates their "<address>","<invalid phone number>" and "<email>"
    And the user clicks Save button for contact details for invalid
    Then system shows error message for invalid phone
    Examples:
        |address  |invalid phone number|email|
        |street 1 |123|kavya@gmail.com|
        |street 2 |126|kavya1@gmail.com|


    