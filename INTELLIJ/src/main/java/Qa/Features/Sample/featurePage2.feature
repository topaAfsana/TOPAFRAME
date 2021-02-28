Feature: Test Selenium Cucumber2


  @SmokeTest
  Scenario: FB TEST 2
    Given User Navigate to Facebook
    When User Log In
    Then User logged in Home page
    And User Verify the profile name
    When User Log out
    Then User verify User Logged out