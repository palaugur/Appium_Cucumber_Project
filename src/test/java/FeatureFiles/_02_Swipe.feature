Feature: Swipe Functionality

  Background:
    Given Open Application
    When Navigate To Swipe Page

  @Smoke
  Scenario: Scroll Down Function
    And Scroll Down
    Then Logo Should Be Visible

  @Smoke
  Scenario: Scroll Right Function
    And Scroll Right
    Then Last Element Should Be Visible