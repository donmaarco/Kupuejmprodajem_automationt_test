Feature: Assessment Kupujem prodajem

  Background:
    Given Open home page
    And User will click on SignIn button
    And User will enter valid email and password and click on Login button

  Scenario: 01.TC Login form - Submit valid data
    When User will add new announcement
    Then User will successfully add new announcement

