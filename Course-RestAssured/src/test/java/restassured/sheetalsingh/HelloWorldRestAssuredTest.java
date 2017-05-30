package restassured.sheetalsingh;

import io.javabrains.springbootstarter.entities.Topics;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static com.jayway.restassured.path.json.JsonPath.from;
import static io.restassured.RestAssured.*;
import static org.apache.http.client.utils.URLEncodedUtils.CONTENT_TYPE;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;


/**
 * Created by Sandeep Chunduru on 5/27/2017.
 */

public class HelloWorldRestAssuredTest {
    public static final Logger log = LoggerFactory.getLogger(HelloWorldRestAssuredTest.class);

    @Test
    public void makeSureThatGoogleIsUpTest() {
        given().when().get("http://www.google.com").then().statusCode(200).log().all();
    }

    /**
     * check if the url works.
     */
    @Test
    public void getAllCoursesTest() {
        given().when().get("http://localhost:8081/topics/getAllTopics").then().statusCode(200).log().all();
    }

    /**
     * check if the response returns contains a word
     */
    @Test
    public void getSpecificKeyWordTest() {
        given().when().get("http://localhost:8081/topics/getAllTopics").then().body(containsString("angular")).log().all();
    }

    /**
     *  checks if the json parameter contains the expected value
     */

    @Test
    public void verifyNameStructuredTest() {
        given().when().get("http://localhost:8081/topics/getTopic/gwtp").then()
                .body("name",equalTo("gwtp framework")).log().all();
    }

    /**
     *  checks if the json parameter contains the expected values and status code 200
     */

    @Test
    public void verifyNameIdStructuredTest() {
        given().when().get("http://localhost:8081/topics/getTopic/gwtp").then()
                .body("name",equalTo("gwtp framework")).body("id",equalTo("gwtp")).statusCode(200).log().all();
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

        given().contentType("application/json").body(course).when().post("http://localhost:8081/topics/addNewTopic").then().statusCode(200).log().all();
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
        given().contentType("application/json").body(topics).when().post("http://localhost:8081/topics/deleteTopic/cucumber").then().statusCode(200).log().all();
    }

    /**
     * verify delete functionality for json
     */
    @Test
    public void verifyDeleteJsonTest() {
        given().contentType("application/json").when().delete("http://localhost:8081/topics/deleteTopic/cucumber").then().statusCode(200).log().all();
    }

    /**
     * use json root settings
     */
   // @Test
    public void useJsonPostRequestTest() {

        given().contentType("application/json").
                headers("sandeep","password").
                param("id", "cucumber1").
                param("name", "cucumber1 framework").
                param("description", "cucumber1 framework description").
                when().
                post("http://localhost:8081/topics/addNewTopic").
                then().log().all();
    }

    /**
     * getJsonDetails from RESTAssured
     */
    @Test
    public void getJsonDetailsStringTest() {
        String jsonString = given().get("http://localhost:8081/topics/getAllTopics").asString();
        log.info("Json String is here: " + jsonString);
    }

    @Test
    public void getJsonDetailsInputStreamTest() throws IOException{
        InputStream stream = given().get("http://localhost:8081/topics/getAllTopics").asInputStream();
        log.info("Json InputStream is here: " + stream.toString().length());
        stream.close();
    }


    @Test
    public void getJsonDetailsUsingPathTest(){
        String href = given().get("http://localhost:8081/topics/getTopic/gwtp").andReturn().jsonPath().getString("description");
        log.info("Json path: " + href);
    }


    @Test
    public void getJsonResponseTest(){
        Response response =  when().get("http://localhost:8081/topics/getAllTopics").then().extract().response();
        log.info("Json response : " + response.asString());
    }

    @Test
    public void getJsonResponseListTest(){
        List list = new ArrayList<Topics>();
        list = given().contentType(CONTENT_TYPE).when().get("http://localhost:8081/topics/getAllTopics").then().
                extract().body().as(list.getClass());

        log.info("Json list : " + list.size());

    }









}
