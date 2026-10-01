package builders;

import config.TestConfig;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RestApiBuilder {

    public static RequestSpecification auth() {
        return new RequestSpecBuilder()
                .setBaseUri(TestConfig.getApiBaseUrl())
                .setContentType(ContentType.JSON)
                .setAuth(RestAssured.preemptive().basic(
                        TestConfig.getAdminLogin(),
                        TestConfig.getAdminPassword()))
                .addFilter(new AllureRestAssured())
                .build();
    }

    public static RequestSpecification noAuth() {
        return new RequestSpecBuilder()
                .setBaseUri(TestConfig.getApiBaseUrl())
                .setContentType(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .build();
    }
}