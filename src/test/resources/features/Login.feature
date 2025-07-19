Feature: OrangeHRM Login

  Scenario: Successful login with valid credentials
    Given user is on the OrangeHRM login page
    When user enters username and password
    And user clicks the login button
    Then user should see the OrangeHRM dashboard


  Scenario: Verify login page components
    Given user is on the OrangeHRM login page
    Then verify all components present in login page


  Scenario Outline: Login with invalid credentials
    Given user is on the OrangeHRM login page
    When user enters invalid "<username>" and "<password>"
    And user clicks the login button
    Then verify the error message displayed
    Examples:
      | username  | password |
      | not admin | 272562   |

    
  Scenario: Verify the functionality when user clicks on forget password link
    Given user is on the OrangeHRM login page
    When user clicks on Forget your password button
    Then user redirects to reset password page