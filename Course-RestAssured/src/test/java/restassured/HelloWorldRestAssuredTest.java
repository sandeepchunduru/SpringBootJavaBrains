package restassured;

import io.javabrains.springbootstarter.entities.Topics;
import org.junit.jupiter.api.Test;
import java.util.*;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;


/**
 * Created by sandeep on 5/27/2017.
 */

public class HelloWorldRestAssuredTest {

    @Test
    public void makeSureThatGoogleIsUpTest() {
        given().when().get("http://www.google.com").then().statusCode(200);
    }

    /**
     * check if the url works.
     */
    @Test
    public void getAllCoursesTest() {
        given().when().get("http://localhost:8081/topics/getAllTopics").then().statusCode(200);
    }

    /**
     * check if the response returns contains a word
     */
    @Test
    public void getSpecificKeyWordTest() {
        given().when().get("http://localhost:8081/topics/getAllTopics").then().body(containsString("angular"));
    }

    /**
     *  checks if the json parameter contains the expected value
     */

    @Test
    public void verifyNameStructuredTest() {
        given().when().get("http://localhost:8081/topics/getTopic/gwtp").then()
                .body("name",equalTo("gwtp framework"));
    }

    /**
     *  checks if the json parameter contains the expected values and status code 200
     */

    @Test
    public void verifyNameIdStructuredTest() {
        given().when().get("http://localhost:8081/topics/getTopic/gwtp").then()
                .body("name",equalTo("gwtp framework")).body("id",equalTo("gwtp")).statusCode(200);
    }

    /**
     * test to send test data and understand if it is inserted using Maps
     */

//    @Test
    public void verifyInsertJsonMapsTest() {

        Map<String,String> course = new HashMap<String, String>();
        course.put("id", "cucumber");
        course.put("name", "cucumberFramework");
        course.put("description", "Cucumber Framework Description");

        given().contentType("application/json").body(course).when().post("http://localhost:8081/topics/addNewTopic").then().statusCode(200);
    }


    /**
     * test to send test data and understand if it is inserted using Maps
     */

   // @Test
    public void verifyInsertJsonTest() {

        Topics topics = new Topics();
        topics.setId("gradle");
        topics.setName("gradle framework");
        topics.setDescription("Gradle Framework Description");
        given().contentType("application/json").body(topics).when().post("http://localhost:8081/topics/deleteTopic/cucumber").then().statusCode(200);
    }

    /**
     * verify delete functionality for json
     */

    @Test
    public void verifyDeleteJsonTest() {
        given().contentType("application/json").when().delete("http://localhost:8081/topics/deleteTopic/cucumber").then().statusCode(200);
    }

}
