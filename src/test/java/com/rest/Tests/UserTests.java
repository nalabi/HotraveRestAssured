
package com.rest.Tests;

import com.rest.Configurations.AppConfig;
import com.rest.Methods.Randomer;
import com.rest.PostsRequests.AccountRegister;
import com.rest.PostsRequests.UserLogin;
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
        user.setEmail(Randomer.generateRandomChars()+"@test.com");
        user.setUsername(Randomer.generateRandomChars()+"@test.com");
        user.setKnownAs("TTM");
        user.setGender("female");
        user.setDateOfBirth("2004-05-22T15:56:15.057Z");
        user.setCity("Durban");
        user.setCountry("South Africa");
        user.setPassword("444Pule");

        Response response =
                given().
                        header("Content-Type", "application/json").
                        body(user).
                        when().
                        post("/users"). // Replace with your actual endpoint
                        then().
                        statusCode(200). // Replace with the expected status code
                       // Note: Avoid validating passwords in real scenarios
                        extract().response();


    }

    @Test
    public void testUnauthorizedLogin(){
        UserLogin login = new UserLogin();
        login.username =("admin");
        login.password= ("password");
        Response response =
                 given()
                        .header("Content-Type", "application/json")
                        .body(login)
                        .when().post("/api/Account/login")
                        .then()

                        .statusCode(401).extract().response();


    }
}
