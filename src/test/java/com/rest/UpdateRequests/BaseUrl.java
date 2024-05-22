package com.rest.UpdateRequests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseUrl {

    @BeforeAll
    public static void SetUp()  {
        RestAssured.baseURI = "https://hotrave.herokuapp.com";
    }

}
