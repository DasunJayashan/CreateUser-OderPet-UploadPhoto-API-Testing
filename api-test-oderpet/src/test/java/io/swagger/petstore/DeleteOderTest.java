package io.swagger.petstore;

import org.testng.annotations.Test;
import utils.PropertyFileReader;

import static io.restassured.RestAssured.given;

public class DeleteOderTest {
    PropertyFileReader propertyFileReader=new PropertyFileReader();
    String BASE_ENDPOINT= propertyFileReader.getProperty("BaseEndpoint","base.endpoint");

    @Test
    public void testDeleteOder() {
        given()
                .header("accept","application/json")
                .when()
                .delete(BASE_ENDPOINT+"/store/order/1")
                .then()
                .statusCode(200);
    }
}
