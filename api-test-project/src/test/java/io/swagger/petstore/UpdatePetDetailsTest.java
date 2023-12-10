package io.swagger.petstore;

import org.testng.annotations.Test;
import utils.JsonFileReader;
import utils.PropertyFileReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class UpdatePetDetailsTest {
    PropertyFileReader prop=new PropertyFileReader();
    JsonFileReader json=new JsonFileReader();
    String BASE_ENDPOINT= prop.getProperty("BaseEndPoint","base.endpoint");
    String PAY_LOAD= json.getJson("UpdatePetDetailsTest","update.pet.pay.load");
    @Test
    public void testUpdatePetDetails() {
        given()
                .header("accept"," application/json")
                .header("Content-Type","application/json")
                .body(PAY_LOAD)
                .when()
                .put(BASE_ENDPOINT+"/pet")
                .then().log().body()
                .statusCode(200)
                .body(
                        "id",equalTo(895741),
                        "name",equalTo("tommy"),
                        "category.id",equalTo(2),
                        "category.name",equalTo("bulldog")
                );
    }
}
