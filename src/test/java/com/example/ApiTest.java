package com.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class ApiTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Test
    public void testGetUsers() {
        Response response =
                given()
                    .log().all()
                .when()
                   .get("/users?page=2")
                .then()
                    .log().body()
                    .statusCode(200)
                    .body("data[0].id", equalTo(7))
                    .body("data[0].first_name", equalTo("Michael"))
                    .body("data[0].email", containsString("@"))
                    .body("data[0].email",startsWith("michael"))
                    .body("data[0].email",endsWith(".in"))
                    .body("data.size()",greaterThan(0))
                    .body("data[0].avatar", notNullValue())
                    .body("data[0].id", instanceOf(Integer.class))
                    .extract().response();
        String email = response.path("data[0].email");
        System.out.println("Extracted email:" + email);
        Assert.assertTrue(email.endsWith(".in"));
    }

    @Test
    public void testCreateUser(){
        String requestBody ="{ \"name\": \"morpheus\", \"job\": \"leader\" }";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
        .when()
                .post("/users")
                .then()
                .statusCode(201)
                .body("name",equalTo("morphus"))
                .body("job",equalTo("leader"));
    }

    @Test
    public void testUpdateUser() {
        String requestBody = "{ \"name\": \"neo\", \"job\": \"chosen one\" }";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("/users/2")
                .then()
                .statusCode(200)
                .body("job", equalTo("chosen one"));
    }

    @Test
    public void testDeleteUser() {
        when()
                .delete("/users/2")
                .then()
                .statusCode(204);
    }
}
