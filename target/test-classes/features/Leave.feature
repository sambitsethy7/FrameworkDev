Feature: Page which displays after clicking on Leave from left nav

  Background: Common steps to navigate to Leave page
    Given user is on the OrangeHRM login page
    And user enters username and password
    And user clicks the login button
    And user should see the OrangeHRM dashboard
    When user clicks on 'Leave' from left nav menu

    @new
  Scenario: Verify the landing page when user clicks Leave from left nav
    Then user verifies the landing page of Leave