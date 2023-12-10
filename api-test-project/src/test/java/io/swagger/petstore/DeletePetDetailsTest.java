package io.swagger.petstore;

import org.testng.annotations.Test;
import utils.PropertyFileReader;

import static io.restassured.RestAssured.given;

public class DeletePetDetailsTest {
    PropertyFileReader prop=new PropertyFileReader();
    String BASE_ENDPOINT= prop.getProperty("BaseEndPoint","base.endpoint");

    @Test
    public void testDeletePetDetails() {
        given()
                .header("accept","application/json")
                .when()
                .delete(BASE_ENDPOINT+"/pet/895741")
                .then().log().body()
                .statusCode(200);
    }
}
