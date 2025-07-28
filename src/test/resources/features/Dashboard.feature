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

  Scenario Outline: Left navigation search validation
    When user enters "<text>" in the search box
    Then "<value>" option should be visible
    Examples:
      | text    | value       |
      | ad      | Admin       |
      | pi      | PIM         |
      | le      | Leave       |
      | ti      | Time        |
      | recruit | Recruitment |
      | my      | My Info     |
      | per     | Performance |
      | da      | Dashboard   |
      | di      | Directory   |
      | mai     | Maintenance |
      | cl      | Claim       |
      | bu      | Buzz        |

  Scenario: Verify the options present in Left navigation
    Then user should see correct navigation menu options

  Scenario: Verify the headers of each section in dashboard
    Then user gets all the headers of each section in dashboard

  Scenario: Verify the number of records found in Admin page by default
    When user clicks on Admin from left nav menu
    Then user verifies the number of records found by default in Admin