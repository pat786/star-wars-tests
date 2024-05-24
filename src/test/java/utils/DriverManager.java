package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


//Manages the WebDriver instance.
public class DriverManager {
    private static WebDriver driver;


    //Gets the WebDriver instance.
    public static WebDriver getDriver() {
        if (driver == null) {
            // Load properties file to get the ChromeDriver path
            Properties properties = new Properties();
            try (FileInputStream input = new FileInputStream("src/test/resources/config.properties")) {
                properties.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
            // Set the path to the ChromeDriver
            System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }


    //Quit the WebDriver instance
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
