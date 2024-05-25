package com.rest.Authentication;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TokenClass {
private String accessToken;

    public TokenClass() {
        Response tokenResponse = RestAssured
                .given()
                .formParam("username", "Inno2")
                .formParam("password", "1TestApp")
                //.formParam("grant_type", "client_credentials")
                .post("https://hotrave.herokuapp.com/api/Account/login")
                .then().extract().response();


    }
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

}
