package io.swagger.petstore;

import org.testng.annotations.Test;
import utils.PropertyFileReader;

import static io.restassured.RestAssured.given;

public class LogOutUserTest {
    PropertyFileReader propertyFileReader=new PropertyFileReader();
    String BASE_ENDPOINT= propertyFileReader.getProperty("BaseEndpoint","base.endpoint");

    @Test
    public void testLogOutUser() {
        given()
                .header("accept","application/json")
                .when()
                .get(BASE_ENDPOINT+"/user/logout")
                .then()
                .statusCode(200);
    }
}
