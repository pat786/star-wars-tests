Feature: Star Wars Movies API

  Scenario: Get the list of movies and check if the movies count is 6
    Given I send a request to the Star Wars API for movies
    When the request is processed
    Then I should receive a list of 6 movies

  Scenario: Get the 3rd movie and check if the director of the movie is 'Richard Marquand'
    Given I send a request to the Star Wars API for the movie number 3
    When the request is processed
    Then the director should be 'Richard Marquand'

  Scenario: Get the 5th movie and assert that producers are not 'Gary Kurtz, George Lucas'
    Given I send a request to the Star Wars API for the movie number 5
    When the request is processed
    Then the producers should not be 'Gary Kurtz, George Lucas'
