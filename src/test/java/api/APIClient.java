package api;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class APIClient {
    private static final Logger logger = LogManager.getLogger(APIClient.class);
    private static String BASE_URL;

    static {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(input);
            BASE_URL = properties.getProperty("api.base.url");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Response getMovies() {
        logger.info("Sending request to the Star Wars API for movies");
        return given().when().get(BASE_URL + "/films").then().extract().response();
    }

    public Response getMovie(int movieNumber) {
        logger.info("Sending request to the Star Wars API for movie number {}", movieNumber);
        return given().when().get(BASE_URL + "/films/" + movieNumber).then().extract().response();
    }
}
