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
      | adm     | Admin       |
      | pim     | PIM         |
      | lea     | Leave       |
      | tim     | Time        |
      | recruit | Recruitment |
      | my I    | My Info     |
      | perfo   | Performance |
      | dash    | Dashboard   |
      | direc   | Directory   |
      | main    | Maintenance |
      | clai    | Claim       |
      | buz     | Buzz        |

  Scenario: Verify the options present in Left navigation
    Then user should see correct navigation menu options

  Scenario: Verify the headers of each section in dashboard
    Then user gets all the headers of each section in dashboard

  Scenario: Verify the number of records found in Admin page by default
    When user clicks on 'Admin' from left nav menu
    Then user verifies the number of records found by default in Admin

  Scenario: Verify the dropdown is multiselect or not in Admin page
    When user clicks on 'Admin' from left nav menu
    Then user verifies the dropdown is multiselect or not in Admin page

  Scenario: Verify user is able to add in Admin > User Management page
    When user clicks on 'Admin' from left nav menu
    And user clicks on Add button in System users
    And user enters valid data to Add User page
    Then user clicks on Save button in Add User page
    And user redirects to System users page

  Scenario: Verify the delete functionality in User management page
    And user clicks on 'Admin' from left nav menu
    When user clicks on delete icon from existing records
    Then user deletes the record