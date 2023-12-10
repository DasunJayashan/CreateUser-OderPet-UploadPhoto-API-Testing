package io.swagger.petstore;

import org.testng.annotations.Test;
import utils.PropertyFileReader;

import java.io.File;

import static io.restassured.RestAssured.given;

public class UploadImageTest {
    PropertyFileReader propertyFileReader=new PropertyFileReader();
    File file=new File("C:/Users/dasun/Downloads/download.jpg");
    String BASE_ENDPOINT= propertyFileReader.getProperty("UploadImageTest","base.endpoint.upload.image.test");

    @Test
    public void testUploadImage() {

        given()
                .header("accept","application/json")
                .header("Content-Type","multipart/form-data")
                .multiPart("file",file,"image/jpeg")
                .when()
                .post(BASE_ENDPOINT+"/pet/7985/uploadImage")
                .then().log().body()
                .statusCode(200);

    }
}
