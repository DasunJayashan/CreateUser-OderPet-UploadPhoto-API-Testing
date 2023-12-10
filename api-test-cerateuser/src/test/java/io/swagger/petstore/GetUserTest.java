package io.swagger.petstore;

import org.testng.annotations.Test;
import utils.PropertyFileReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetUserTest {
    PropertyFileReader propertyFileReader=new PropertyFileReader();
    String BASE_ENDPOINT=propertyFileReader.getProperty("BaseEndpoint","base.endpoint");

    @Test
    public void testGetUser() {
        given()
                .header("accept","application/json")
                .when()
                .get(BASE_ENDPOINT+"/user/Dasun")
                .then().log().body()
                .statusCode(200)
                .body(
                        "id",equalTo(85469),
                        "username",equalTo("Dasun"),
                        "firstName",equalTo("Dasun"),
                        "lastName",equalTo("Jayshan"),
                        "email",equalTo("dasunjayashan123@gmail.com"),
                        "password",equalTo("Dasu@123"),
                        "phone",equalTo("0777777777")


                );
    }
}
