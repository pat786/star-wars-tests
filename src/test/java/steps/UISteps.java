package steps;

import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.MovieDetailsPage;
import pages.StarWarsMoviesPage;
import utils.DriverManager;

public class UISteps {
    private static final Logger logger = LogManager.getLogger(UISteps.class);
    private WebDriver driver = DriverManager.getDriver();
    private StarWarsMoviesPage starWarsMoviesPage = new StarWarsMoviesPage(driver);
    private MovieDetailsPage movieDetailsPage = new MovieDetailsPage(driver);

    @Given("I am on the Star Wars movies page")
    public void iAmOnTheStarWarsMoviesPage() {
        starWarsMoviesPage.navigateTo();
        starWarsMoviesPage.waitForPageToLoad();
        logger.info("Navigated to Star Wars movies page");
    }

    @When("I sort the movies by title")
    public void iSortTheMoviesByTitle() {
        starWarsMoviesPage.sortByTitle();
        logger.info("Sorted movies by title");
    }

    @Then("the last movie in the list should be 'The Phantom Menace'")
    public void theLastMovieInTheListShouldBe() {
        String lastMovie = starWarsMoviesPage.getLastMovieTitle();
        Assert.assertTrue(lastMovie.contains("The Phantom Menace"));
        logger.info("Verified that the last movie is 'The Phantom Menace'");
    }

    @When("I select the movie 'The Empire Strikes Back'")
    public void iSelectTheMovieTheEmpireStrikesBack() {
        starWarsMoviesPage.clickOnMovie("The Empire Strikes Back");
        movieDetailsPage.waitForDetailsPageToLoad();
        logger.info("Selected the movie 'The Empire Strikes Back'");
    }

    @Then("I should see 'Wookie' in the species list")
    public void iShouldSeeWookieInTheSpeciesList() {
        boolean wookieFound = movieDetailsPage.isSpeciesPresent("Wookie");
        Assert.assertTrue(wookieFound);
        logger.info("Verified that 'Wookie' is in the species list");
        movieDetailsPage.clickBackButton();
        starWarsMoviesPage.waitForPageToLoad();
    }

    @When("I select the movie 'The Phantom Menace'")
    public void iSelectTheMovieThePhantomMenace() {
        starWarsMoviesPage.clickOnMovie("The Phantom Menace");
        movieDetailsPage.waitForDetailsPageToLoad();
        logger.info("Selected the movie 'The Phantom Menace'");
    }

    @Then("I should not see 'Kamino' in the planets list")
    public void iShouldNotSeeKaminoInThePlanetsList() {
        boolean kaminoFound = movieDetailsPage.isPlanetPresent("Kamino");
        Assert.assertFalse(kaminoFound, "'Kamino' should not be in the planets list");
        logger.info("Verified that 'Kamino' is not in the planets list");
        movieDetailsPage.clickBackButton();
        starWarsMoviesPage.waitForPageToLoad();
    }
}
