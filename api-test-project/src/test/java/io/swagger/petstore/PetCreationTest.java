package io.swagger.petstore;

import org.testng.annotations.Test;
import utils.JsonFileReader;
import utils.PropertyFileReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PetCreationTest {
    PropertyFileReader prop=new PropertyFileReader();
    JsonFileReader json=new JsonFileReader();
    String BASE_ENDPOINT=prop.getProperty("BaseEndPoint","base.endpoint");
    String PAY_LOAD= json.getJson("PetCreationTest","pet.creation.pay.load");
    @Test(priority = 0)
    public void testAddNewPetToTheStore() {
        given()
                .header("accept"," application/json")
                .header("Content-Type","application/json")
                .body(PAY_LOAD)
                .when()
                .post(BASE_ENDPOINT+"/pet")
                .then().log().body()
                .statusCode(200)
                .body(
                        "id",equalTo(895741),
                        "name",equalTo("zeeba"),
                        "category.id",equalTo(1),
                        "category.name",equalTo("sheperd")
                );
    }

    @Test(priority = 1)
    public void testGetPetDetails() {
        given()
                .header("accept"," application/json")
                .when()
                .get(BASE_ENDPOINT+"/pet/895741")
                .then()
                .statusCode(200)
                .body(
                        "id",equalTo(895741),
                        "name",equalTo("zeeba"),
                        "category.id",equalTo(1),
                        "category.name",equalTo("sheperd")
                );
    }
}
