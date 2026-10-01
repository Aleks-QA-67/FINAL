package asserts;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;

import java.util.function.Predicate;

public class ApiAssert {

    private final Response response;

    public ApiAssert(Response response) {
        this.response = response;
    }

    public static ApiAssert assertThat(Response response) {
        return new ApiAssert(response);
    }

    @Step("Проверить статус: {expected}")
    public ApiAssert statusCode(int expected) {
        Assertions.assertThat(response.getStatusCode())
                .as("HTTP status")
                .isEqualTo(expected);
        return this;
    }

    @Step("Проверить, что поле '{path}' = {expected}")
    public ApiAssert fieldEquals(String path, Object expected) {
        Assertions.assertThat((Predicate<Object>) response.jsonPath().get(path))
                .as("Поле " + path)
                .isEqualTo(expected);
        return this;
    }

    @Step("Проверить, что поле '{path}' не пустое")
    public ApiAssert fieldNotNull(String path) {
        Assertions.assertThat((Predicate<Object>) response.jsonPath().get(path))
                .as("Поле " + path)
                .isNotNull();
        return this;
    }
}