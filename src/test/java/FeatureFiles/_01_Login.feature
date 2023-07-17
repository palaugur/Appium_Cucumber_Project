Feature: Login Functionality

  @Smoke
  Scenario: Login with valid credentials
    Given Open Application
    When Navigate to Login Page
    And Enter Valid Credentials and Click Login Button
    Then User Should Login Successfully