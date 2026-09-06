package org.example.api.clients;

import org.example.api.models.UserResponse;
import org.example.api.specs.ApiSpecs;

import static io.restassured.RestAssured.given;

public class ReqressClient {
    private static final String USERS_ENDPOINT = "/users";

    public static UserResponse getUser(int userId){
        return given()
                .spec(ApiSpecs.requestSpec())
                .pathParam("id", userId)
                .when()
                .get(USERS_ENDPOINT + "/{id}")
                .then()
                .spec(ApiSpecs.successResponseSpec())
                .extract()
                .as(UserResponse.class);
    }
}
