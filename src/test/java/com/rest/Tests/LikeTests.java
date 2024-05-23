package com.rest.Tests;

import com.rest.Authentication.TokenClass;
import com.rest.Configurations.AppConfig;
import io.restassured.response.Response;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class LikeTests {

    @BeforeClass
    public static void setUp(){
        AppConfig.SetUp();
    }

    @Test
    public void testGetLikesByUserId (){
        TokenClass tokenClass = new TokenClass();
        Response response =
                (Response) given()
                        .header("Authorization", "Bearer " + tokenClass.accessToken)
                        .param("predicate", "Liked")
                        .get("/api/Likes")
                        .then()
                        .statusCode(200)
                        .extract().response();


    }
    @AfterClass
    public static void tearDown(){

    }
}
