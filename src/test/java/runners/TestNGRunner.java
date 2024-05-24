package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
    private static final Logger logger = LogManager.getLogger(TestNGRunner.class);

    public static void main(String[] args) {
        logger.info("Starting TestNG Runner");
    }
}
