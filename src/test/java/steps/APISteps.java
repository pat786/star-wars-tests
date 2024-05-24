package steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import api.APIClient;
import org.testng.Assert;

public class APISteps {
    private static final Logger logger = LogManager.getLogger(APISteps.class);
    private APIClient apiClient = new APIClient();
    private Response response;

    @Given("I send a request to the Star Wars API for movies")
    public void iSendARequestToTheStarWarsAPIForMovies() {
        response = apiClient.getMovies();
        logger.info("Response: {}", response.asString());
    }

    @Given("I send a request to the Star Wars API for the movie number {int}")
    public void iSendARequestToTheStarWarsAPIForTheMovieNumber(int movieNumber) {
        response = apiClient.getMovie(movieNumber);
        logger.info("Response: {}", response.asString());
    }

    @When("the request is processed")
    public void theRequestIsProcessed() {
        Assert.assertNotNull(response);
        logger.info("Request has been processed");
    }

    @Then("I should receive a list of {int} movies")
    public void iShouldReceiveAListOfMovies(int expectedCount) {
        int actualCount = response.jsonPath().getList("results").size();
        Assert.assertEquals(actualCount, expectedCount);
        logger.info("Verified that the list contains {} movies", expectedCount);
    }

    @Then("the director should be {string}")
    public void theDirectorShouldBe(String expectedDirector) {
        String actualDirector = response.jsonPath().getString("director");
        Assert.assertEquals(actualDirector, expectedDirector);
        logger.info("Verified that the director is '{}'", expectedDirector);
    }

    @Then("the producers should not be {string}")
    public void theProducersShouldNotBe(String unexpectedProducers) {
        String actualProducers = response.jsonPath().getString("producer");
        Assert.assertFalse(actualProducers.contains(unexpectedProducers));
        logger.info("Verified that the producers are not '{}'", unexpectedProducers);
    }
}
