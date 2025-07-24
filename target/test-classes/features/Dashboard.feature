Feature: Dashboard which displays after login

  Background: Common steps to navigate Dashboard page
    Given user is on the OrangeHRM login page
    And user enters username and password
    When user clicks the login button
    Then user should see the OrangeHRM dashboard

  Scenario: Verify the options present in user dropdown
    Then verify the options present in user dropdown

  Scenario: User logouts from application
    When verify the options present in user dropdown
    Then user clicks on logout option
    And user is on the OrangeHRM login page

  Scenario: Verify the images present in dashboard page
    Then i verify all images present in dashboard page

  Scenario: Verify the links present in dashboard page
    Then i verify all links present in dashboard page