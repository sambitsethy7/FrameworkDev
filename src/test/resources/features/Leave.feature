Feature: Page which displays after clicking on Leave from left nav

  Background: Common steps to navigate to Leave page
    Given user is on the OrangeHRM login page
    And user enters username and password
    And user clicks the login button
    And user should see the OrangeHRM dashboard
    When user clicks on 'Leave' from left nav menu

  Scenario: Verify the landing page when user clicks Leave from left nav
    Then user verifies the landing page of Leave

  Scenario: Verify the options present in Entitlements dropdown
    When user clicks on Entitlements dropdown
    Then user verifies the value present in Entitlements dropdown

  Scenario: Verify the options present in Reports dropdown
    When user clicks on Reports dropdown
    Then user verifies the value present in Reports dropdown


  Scenario: Verify the options present in Configure dropdown
    When user clicks on Configure dropdown
    Then user verifies the value present in Configure dropdown


  Scenario: Verify the table's header values in Leave page
    Then user verifies the values of table header