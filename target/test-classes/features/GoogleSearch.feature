@google @smoke
Feature: Workday - Job search functionality
  Agile story: As a user, when I am logged in to Workday Jobs
  I should be able to search jobs and see relevant results

  Scenario: Search page default title verification
    When user is on the Google search page
    Then user should see title is Google

  Scenario: Search result title verification
    Given user is on the Google search page
    When user searches for apple
    Then user should see apple in the title
    # And user sees 3 apples




