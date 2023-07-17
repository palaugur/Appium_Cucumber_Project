Feature: Drag Functionality
  Background:
    Given Open Application
    When Navigate to Drag Page

    @Smoke
    Scenario: Drag and Drop
      When User complete Drag and Drop Game
      Then Success Message Should Display