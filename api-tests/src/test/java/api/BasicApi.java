package api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public abstract class BasicApi {

    protected Response get(String path, RequestSpecification spec) {
        return given().spec(spec).when().get(path);
    }

    protected Response post(String path, Object body, RequestSpecification spec) {
        return given().spec(spec).body(body).when().post(path);
    }

    protected Response patch(String path, Object body, RequestSpecification spec) {
        return given().spec(spec).body(body).when().patch(path);
    }

    protected Response delete(String path, RequestSpecification spec) {
        return given().spec(spec).when().delete(path);
    }
}