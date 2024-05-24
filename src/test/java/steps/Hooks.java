package steps;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import utils.DriverManager;

//Manage setup and teardown for UI tests
public class Hooks {

    @Before("@ui")
    public void setUp() {
        DriverManager.getDriver();
    }

    @After("@ui")
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
