package io.swagger.petstore;

import org.testng.annotations.Test;
import utils.JsonFileReader;
import utils.PropertyFileReader;

import static io.restassured.RestAssured.given;

public class CreateUserTest {
    PropertyFileReader propertyFileReader=new PropertyFileReader();
    JsonFileReader jsonFileReader=new JsonFileReader();
    String BASE_ENDPOINT= propertyFileReader.getProperty("BaseEndpoint","base.endpoint");
    String PAY_LOAD= jsonFileReader.getJson("CreateUserTest","create.user.test.pay.load");

    @Test
    public void testCreateUser() {
        given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body(PAY_LOAD)
                .when()
                .post(BASE_ENDPOINT+"/user")
                .then()
                .statusCode(200);
    }
}
