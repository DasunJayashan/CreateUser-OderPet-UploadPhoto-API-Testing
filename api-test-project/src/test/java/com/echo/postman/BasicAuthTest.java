package com.echo.postman;

import org.testng.annotations.Test;
import utils.PropertyFileReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class BasicAuthTest {
    PropertyFileReader prop=new PropertyFileReader();
    String END_POINT= prop.getProperty("BasicAuthTest","end.point");
    String userName= prop.getProperty("BasicAuthTest","userName.element");
    String password= prop.getProperty("BasicAuthTest","password.element");

    @Test
    public void testBasicAuthValidation() {
        given()
                .auth().basic(userName,password)
                .when()
                .get(END_POINT)
                .then().log().body()
                .statusCode(200)
                .body(
                        "authenticated",equalTo(true)
                );

    }
}
