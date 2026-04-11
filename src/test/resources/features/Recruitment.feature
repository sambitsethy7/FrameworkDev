Feature: Page which displays after clicking recruitment from left nav

  Background: Common steps to navigate to Leave page
    Given user is on the OrangeHRM login page
    And user enters username and password
    And user clicks the login button
    And user should see the OrangeHRM dashboard
    When user clicks on 'Recruitment' from left nav menu

    @new
  Scenario: Verify the labels present in Recruitment page
    Then user verifies the components present in Recruitment page
      And verify the options present in user dropdown
      And user clicks on logout option