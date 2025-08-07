Feature: Login to Orange HRM application

  Scenario: Successful login
    Given url 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login'
    And request {"username": "Admin","password": "admin123"}
    When method POST
    Then status 405
    And match response.token == null
#Feature: Sample API test for GET request
#
# Scenario: Verify JSON placeholder returns valid response
#  Given url 'https://jsonplaceholder.typicode.com/posts/1'
#  When method GET
#  Then status 200
#  And match response.id == 1