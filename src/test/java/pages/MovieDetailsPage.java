package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.UIUtils;

import java.util.List;

public class MovieDetailsPage {
    private WebDriver driver;

    private By detailsSection = By.cssSelector("div.border-2.border-white.rounded");
    private By speciesList = By.cssSelector("div.border-2.border-white.rounded ul li");
    private By planetsList = By.cssSelector("div.border-2.border-white.rounded ul li");
    private By backButton = By.cssSelector("a.layout_link__RDXtV"); // Update with the actual selector for the back button

    public MovieDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForDetailsPageToLoad() {
        UIUtils.waitForElementToBeVisible(driver, detailsSection);
        UIUtils.waitForElementToBeVisible(driver, speciesList);
    }

    public boolean isSpeciesPresent(String speciesName) {
        List<WebElement> species = driver.findElements(speciesList);
        species.forEach(e -> UIUtils.scrollToElement(driver, e));
        return species.stream().anyMatch(e -> e.getText().contains(speciesName));
    }

    public boolean isPlanetPresent(String planetName) {
        List<WebElement> planets = driver.findElements(planetsList);
        planets.forEach(e -> UIUtils.scrollToElement(driver, e));
        return planets.stream().anyMatch(e -> e.getText().contains(planetName));
    }

    public void clickBackButton() {
        WebElement backButtonElement = UIUtils.waitForElementToBeVisible(driver, backButton);
        UIUtils.scrollToElement(driver, backButtonElement);
        backButtonElement.click();
    }
}
