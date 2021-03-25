Feature: Login

  Background: Go to login
    Given I go to login page

  Scenario: Login with valid credentials
    When I enter "marcos.x86@outlook.com" in username field
    And I click on Next button
    And I enter "" in password field
    And I click on Sign In
    Then I verify that username "marcosx86" is displayed on dashboard

  Scenario: Cannot login with invalid credentials
    When I enter "marcos.x86@outlook.com" in username field
    And I click on Next button
    And I enter "123412341234" in password field
    And I click on Sign In
    Then I verify that the error message is "Invalid username/password"

  Scenario: Cannot login with invalid username
    When I enter "" in username field
    And I click on Next button
    Then I verify that the error message is "Enter username or email to continue"

  Scenario: Cannot login with invalid password
    When I enter "marcos.x86@outlook.com" in username field
    And I click on Next button
    And I enter "" in password field
    And I click on Sign In
    Then I verify that the error message is "Invalid username/password"
