Feature: Dashboard which displays after login


  Scenario: Verify the user is navigated to dashboard after entering valid credentials
    Given user is on the OrangeHRM login page
    And user enters username and password
    When user clicks the login button
    Then user should see the OrangeHRM dashboard


  Scenario: Verify the options present in user dropdown
    Given user is on the OrangeHRM login page
    And user enters username and password
    When user clicks the login button
    And user should see the OrangeHRM dashboard
    Then verify the options present in user dropdown

  Scenario: User logouts from application
    Given user is on the OrangeHRM login page
    And user enters username and password
    And user clicks the login button
    And user should see the OrangeHRM dashboard
    When verify the options present in user dropdown
    Then user clicks on logout option
    And user is on the OrangeHRM login page