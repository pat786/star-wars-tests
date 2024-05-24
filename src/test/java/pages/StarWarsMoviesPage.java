package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import utils.UIUtils;

public class StarWarsMoviesPage {
    private WebDriver driver;

    private By table = By.cssSelector("table.text-gray-500");
    private By movieRows = By.cssSelector("tbody tr.border");
    private By titleHeader = By.xpath("//th[contains(text(), 'Title')]");
    private By dropUpIcon = By.cssSelector("svg[data-testid='ArrowDropUpIcon']");
    private By dropDownIcon = By.cssSelector("svg[data-testid='ArrowDropDownIcon']");
    private By lastMovieLink = By.cssSelector("td > a.underline");

    public StarWarsMoviesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("http://localhost:3000");
    }

    public void waitForPageToLoad() {
        UIUtils.waitForElementToBeVisible(driver, table);
        UIUtils.waitForElementToBeVisible(driver, movieRows);
    }

    public void sortByTitle() {
        WebElement titleHeaderElement = UIUtils.waitForElementToBeVisible(driver, titleHeader);
        UIUtils.scrollToElement(driver, titleHeaderElement);
        titleHeaderElement.click();

        boolean isDropUpIconDisplayed = !driver.findElements(dropUpIcon).isEmpty();

        if (!isDropUpIconDisplayed) {
            WebElement dropDownIconElement = UIUtils.waitForElementToBeVisible(driver, dropDownIcon);
            UIUtils.scrollToElement(driver, dropDownIconElement);
            dropDownIconElement.click();
        }
    }

    public List<WebElement> getMovieRows() {
        return driver.findElements(movieRows);
    }

    public String getLastMovieTitle() {
        List<WebElement> movies = getMovieRows();
        WebElement lastMovieElement = movies.get(movies.size() - 1).findElement(lastMovieLink);
        UIUtils.scrollToElement(driver, lastMovieElement);
        return lastMovieElement.getText();
    }

    public void clickOnMovie(String movieTitle) {
        WebElement movieLink = UIUtils.waitForElementToBeVisible(driver, By.xpath("//a[contains(text(), '" + movieTitle + "')]"));
        UIUtils.scrollToElement(driver, movieLink);
        movieLink.click();
    }
}
