package restassured.fluientwait;

import beans.TopicsBean;
import common.RestAssuredConstants;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Sandeep Chunduru on 5/28/2017.
 */
public class TopicsRestAssuredTest {
    public static final Logger log = LoggerFactory.getLogger(TopicsRestAssuredTest.class);
    @Test
    public void validateTpoics(){
        given().get(RestAssuredConstants.GET_ALL_TOPICS).then().statusCode(200).log().all();
    }

//    @Test()
//    public void validateTpoicsBaseDetails(){
//        given().get("/getAllTopics").then().statusCode(200).log().all();
//    }


    @Test
    public void validateTpoicsJsonResponse(){
        Response response = given().get(RestAssuredConstants.GET_TOPIC).thenReturn();
        response.then().body("id", equalTo("gwtp"), "name", equalTo("gwtp framework"));
        log.info("JSon Response= " + response.asString());

    }

    @Test
    public void validateTpoicsJsonResponsePath(){
        Response response = given().get(RestAssuredConstants.GET_TOPIC).thenReturn();
        Assert.assertEquals(response.path("name"), "gwtp framework");
        log.info("JSon Response= " + response.asString());

    }

    @Test
    public void validateTpoicsJsonResponseToBean(){
        Response response = given().get(RestAssuredConstants.GET_TOPIC).thenReturn();
        TopicsBean topicsBean = response.as(TopicsBean.class);

        Assert.assertEquals(topicsBean.getName(), "gwtp framework");
        log.info("JSon Response topicsBean = " + topicsBean.toString());

    }

}
