Feature: Practice page functionality

@wip
  Scenario: Verify that each link is working properly
    Given User is on the home page
    When  User clicks "A/B Testing" link
    Then  User should be able to see "abtest" in url