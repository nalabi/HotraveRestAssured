package com.rest.UpdateRequests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.*;

public class Test extends BaseUrl {
@org.testng.annotations.Test
    public void testPostRegister() {

    Response response =
             given().when().get("/api/messages").
                    then().extract().response();
    Assertions.assertEquals(response.getStatusCode(), 404);
   }
}
