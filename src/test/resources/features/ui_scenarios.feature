@ui
Feature: Star Wars Movies UI

  @ui
  Scenario: Sort movies by 'Title' and assert the last movie in the list is 'The Phantom Menace'
    Given I am on the Star Wars movies page
    When I sort the movies by title
    Then the last movie in the list should be 'The Phantom Menace'

  @ui
  Scenario: Select the movie 'The Empire Strikes Back' and verify species
    Given I am on the Star Wars movies page
    When I select the movie 'The Empire Strikes Back'
    Then I should see 'Wookie' in the species list

  @ui
  Scenario: Select the movie 'The Phantom Menace' and verify planets
    Given I am on the Star Wars movies page
    When I select the movie 'The Phantom Menace'
    Then I should not see 'Kamino' in the planets list
