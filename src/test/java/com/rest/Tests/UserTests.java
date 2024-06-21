
package com.rest.Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.rest.Configurations.AppConfig;
import com.rest.Methods.Gender;
import com.rest.Methods.Randomer;
import com.rest.PostsRequests.AccountRegister;
import com.rest.PostsRequests.UserLogin;
import com.rest.TestReports.ExtentManager;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class UserTests {
    private ExtentReports extent;
    private ExtentTest test;
    AccountRegister accountRegister = new AccountRegister();
    @BeforeClass
    public void setup() {

        AppConfig.SetUp();
        extent = ExtentManager.getInstance();

    }

    @Test
    public void testCreateUser() {
        test = extent.createTest("CreateUsers", "Test to get all users");
        AccountRegister user = new AccountRegister();
        user.setEmail(Randomer.generateRandomChars()+"@test.com");
        user.setUsername(Randomer.generateRandomChars()+"@test.com");
        user.setKnownAs(Randomer.generateRandomName());
        user.setGender(Gender.getRandomGender());
        user.setDateOfBirth("2000-05-22T15:56:15.057Z");
        user.setCity("Durban");
        user.setCountry("South Africa");
        user.setPassword("444Pule");
        //user.setConfirmPassword("444Pul7");

        Response response =
                given().
                        header("Content-Type", "application/json").
                        body(user).
                        when().
                        post("api/Account/register"). // Replace with your actual endpoint
                        then().
                        statusCode(200). // Replace with the expected status code
                       // Note: Avoid validating passwords in real scenarios
                        extract().response();
System.out.println(response.getBody().asString());

    }

    @Test
    public void testUnauthorizedLogin(){
        UserLogin login = new UserLogin();
        login.username =("Inno2");
        login.password= ("1TestApp1");
        Response response =
                 given()
                        .header("Content-Type", "application/json")
                        .body(login)
                        .when().post("/api/Account/login")
                        .then()

                        .statusCode(401).extract().response();


    }
    @Test
    public void testemptyUsernameReg(){
         Response response =
         given().
                 header("Content-Type", "application/json").
                 body(accountRegister.emptyEmail()).
                 when().post("/api/Account/register").then().statusCode(400)
                 .extract().response();
        Assert.assertSame("Empty email", response.getBody().asString());
    }

    @Test
    public void testMissingPasswordReg(){

    }
    public void tearDown(){
        extent.flush();
    }
}
