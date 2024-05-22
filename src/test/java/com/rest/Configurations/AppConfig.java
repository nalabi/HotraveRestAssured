package com.rest.Configurations;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class AppConfig {

    @BeforeClass
    public static void SetUp(){
        RestAssured.baseURI = "https://hotrave.herokuapp.com";
    }
}
