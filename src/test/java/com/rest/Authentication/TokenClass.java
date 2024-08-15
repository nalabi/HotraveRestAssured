package com.rest.Authentication;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TokenClass {
private String accessToken;

    public TokenClass() {

        Response tokenResponse = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body("{\"username\":\"Inno2\", \"password\":\"1TestApp\"}")
                //.formParam("grant_type", "client_credentials")
                .post("https://hotrave.herokuapp.com/api/Account/login")
                .then().extract().response();
        System.out.println("Response Status Code: " + tokenResponse.getStatusCode());
        System.out.println("Response Body: " + tokenResponse.getBody().asString());

        // Extract the access token from the response body
        this.accessToken = tokenResponse.jsonPath().getString("token");


    }
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

}
