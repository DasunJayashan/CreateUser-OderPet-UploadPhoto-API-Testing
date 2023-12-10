package io.swagger.petstore;

import io.restassured.specification.Argument;
import org.testng.annotations.Test;
import utils.JsonFileReader;
import utils.PropertyFileReader;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class OderPetTest {
    PropertyFileReader propertyFileReader=new PropertyFileReader();
    JsonFileReader jsonFileReader=new JsonFileReader();
    String BASE_ENDPOINT= propertyFileReader.getProperty("BaseEndpoint","base.endpoint");
    String PAY_LOAD= jsonFileReader.getJson("OderPetTest","oder.pet.test.pay.load");

    @Test(priority = 0)
    public void testOderPet() {
        given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body(PAY_LOAD)
                .when()
                .post(BASE_ENDPOINT+"/store/order")
                .then().log().body()
                .statusCode(200)
                .body(
                        "id",equalTo(1),
                        "petId",equalTo(1),
                        "quantity",equalTo(5)
                );


    }
    @Test(priority = 1)
    public void testGetOder() {
        given()
                .header("accept", "application/json")
                .when()
                .get(BASE_ENDPOINT + "/store/order/1")
                .then()
                .statusCode(200)
                .body(
                        "id",equalTo(1),
                        "petId",equalTo(1),
                        "quantity",equalTo(5)
                );

    }
}
