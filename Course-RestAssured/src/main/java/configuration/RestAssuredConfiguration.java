package configuration;

import common.RestAssuredConstants;
import io.restassured.RestAssured;
import org.junit.Before;

/**
 * Created by Sandeep Chunduru on 5/28/2017.
 */
public class RestAssuredConfiguration {

    @Before
    public void configure(){
        RestAssured.baseURI = RestAssuredConstants.BASE_URI;
        RestAssured.port=RestAssuredConstants.BASE_PORT;
        RestAssured.basePath = "/topics";
    }


}
