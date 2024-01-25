@workday @smoke
Feature: Clarivate Workday login feature

  User Story:
  As a user, I should be able to login with correct credentials.And dashboard should be displayed.

  Background: For all scenarios user is on the login page of the Clarivate Workday Jobs application
    Given user is on the login page of the Workday Jobs application

  @failedlogin
  Scenario Outline: Login with invalid credential
    When the user login with "<username>","<password>"
    Then the user should not be able to log in

    Examples:
      | username        | password      |
      | wrongUserName   | UserUser123   |
      | salesmanager101 | wrongPassword |
      | wrongUserName   | wrongPassword |
      | wrongUserName   | empty         |
      | empty           | wrongPassword |
      | empty           | empty         |

  Scenario: Login as eva
    When user enters eva username
    And user enters eva password
    And user clicks Sign In button
    Then user should see the Welcome text
    # example of using List of Data (as a list of String)
    Then user should be able to see following modules
      | Search for Jobs |
      | Candidate Home  |
      | Job Alerts      |

