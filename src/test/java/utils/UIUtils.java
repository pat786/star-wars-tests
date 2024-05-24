package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class UIUtils {
    private static final int TIMEOUT = 15;

    /**
     * Waits for an element to be visible.
     * @param driver the WebDriver instance.
     * @param locator the locator of the element to wait for.
     * @return the WebElement once it is visible.
     */
    public static WebElement waitForElementToBeVisible(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Scrolls an element into view.
     * @param driver the WebDriver instance.
     * @param element the WebElement to scroll into view.
     */
    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
