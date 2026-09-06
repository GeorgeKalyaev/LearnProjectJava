package org.example.api.specs;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.openqa.selenium.devtools.latest.network.model.Request;

import java.util.regex.Matcher;

public class ApiSpecs {
    public static final String BASE_URL = "https://reqres.in";
    public static final String BASE_PATH = "/api";

    public static RequestSpecification requestSpec(){
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setBasePath(BASE_PATH)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification responseSpec(){

        return  new ResponseSpecBuilder()
                .expectResponseTime(Matchers.lessThan(5000L))
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification successResponseSpec(){
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectResponseTime(Matchers.lessThan(5000L))
                .log(LogDetail.ALL)
                .build();

    }

    public static void setup(){
        RestAssured.requestSpecification = requestSpec();
        RestAssured.responseSpecification = responseSpec();
    }


}
