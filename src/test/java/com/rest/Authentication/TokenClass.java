package com.rest.Authentication;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TokenClass {
    Response tokenResponse = RestAssured
            .given()
            .formParam("username", "Eee")
            .formParam("password", "TestApp1")
            .formParam("grant_type", "client_credentials")
            .post("https://hotrave.herokuapp.com/api/Account/login");

   public  String accessToken = tokenResponse.jsonPath().getString("access_token");


}
