
package com.rest.Tests;

import com.rest.Configurations.AppConfig;
import com.rest.PostsRequests.AccountRegister;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserTests {
    @BeforeClass
    public void setup() {
        AppConfig.SetUp();

    }

    @Test
    public void testCreateUser() {
        AccountRegister user = new AccountRegister();
        user.setEmail("test@te.23");
        user.setUsername("test2");
        user.setKnownAs("TTM");
        user.setGender("Male");
        user.setDateOfBirth("2004-05-22T15:56:15.057Z");
        user.setCity("Durban");
        user.setCountry("South Africa");
        user.setPassword("444Serero#");

        Response response =
                given().
                        header("Content-Type", "application/json").
                        body(user).
                        when().
                        post("/users"). // Replace with your actual endpoint
                        then().
                        statusCode(201). // Replace with the expected status code
                        body("email", equalTo("test@te.23")). // Validate fields
                        body("username", equalTo("test2")).
                        body("knownAs", equalTo("TTM")).
                        body("gender", equalTo("Male")).
                        body("dateOfBirth", equalTo("2004-05-22T15:56:15.057Z")).
                        body("city", equalTo("Durban")).
                        body("country", equalTo("South Africa")).
                        body("password", equalTo("444Serero#")). // Note: Avoid validating passwords in real scenarios
                        extract().response();

        Assertions.assertEquals(response.getStatusCode(), 404);
    }
}
