@wiki @smoke
Feature: Wiki search features

  @scenarioOutline
  Scenario Outline: Wikipedia Search Functionality with Scenario Outline
    Given User is on Wikipedia home page
    When User types "<searchValue>" in the wiki search box
    And User clicks wiki search button
    Then User sees "<expectedTitle>" is in the wiki title
    Then User sees "<expectedMainHeader>" is in the main header
    Then User sees "<expectedImageHeader>" is in the image header

    @ceos
    Examples: search values we are going to be using in this scenario outlines
      | searchValue     | expectedTitle   | expectedMainHeader | expectedImageHeader |
      | Steve Jobs      | Steve Jobs      | Steve Jobs         | Steve Jobs          |
      | Mary Barra      | Mary Barra      | Mary Barra         | Mary Barra          |
      | Rosalind Brewer | Rosalind Brewer | Rosalind Brewer    | Rosalind Brewer     |
      | Sundar Pichai   | Sundar Pichai   | Sundar Pichai      | Sundar Pichai       |

    @scientists
    Examples:
      | searchValue     | expectedTitle   | expectedMainHeader | expectedImageHeader    |
      | Marie Curie     | Marie Curie     | Marie Curie        | Marie Skłodowska-Curie |
      | Albert Einstein | Albert Einstein | Albert Einstein    | Albert Einstein        |