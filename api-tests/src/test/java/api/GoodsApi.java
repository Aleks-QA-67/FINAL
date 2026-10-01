package api;

import builders.RestApiBuilder;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.Map;

public class GoodsApi extends BasicApi {

    @Step("GET /goods/list (page={page}, size={size})")
    public Response list(int page, int size) {
        return get("/goods/list?page=" + page + "&size=" + size, RestApiBuilder.auth());
    }

    @Step("POST /goods/add (name={name}, price={price})")
    public Response add(String name, int price) {
        return post("/goods/add", Map.of("name", name, "price", price), RestApiBuilder.auth());
    }

    @Step("GET /goods/{id}")
    public Response getById(int id) {
        return get("/goods/" + id, RestApiBuilder.auth());
    }

    @Step("PATCH /goods/{id}")
    public Response patch(int id, Map<String, Object> body) {
        return patch("/goods/" + id, body, RestApiBuilder.auth());
    }

    @Step("DELETE /goods/{id}")
    public Response deleteById(int id) {
        return delete("/goods/" + id, RestApiBuilder.auth());
    }
}