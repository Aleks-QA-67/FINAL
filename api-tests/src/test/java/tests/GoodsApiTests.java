package tests;

import api.GoodsApi;
import asserts.ApiAssert;
import config.TestConfig;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import java.util.Map;

import static asserts.ApiAssert.assertThat;

@Epic("API")
@Feature("Goods")
public class GoodsApiTests {

    private final GoodsApi goodsApi = new GoodsApi();

    @BeforeAll
    static void printConfig() {
        TestConfig.printConfig();
    }

    @Test
    @Tag("smokeApi")
    @DisplayName("GET /goods/list — 200 и поле goods")
    void listGoods() {
        assertThat(goodsApi.list(0, 10))
                .statusCode(200)
                .fieldNotNull("goods");
    }

    @Test
    @Tag("smokeApi")
    @DisplayName("POST /goods/add — создание товара")
    void addGoods() {
        String name = "API-Test " + System.currentTimeMillis();
        Response response = goodsApi.add(name, 999);
        assertThat(response)
                .statusCode(200)
                .fieldEquals("name", name)
                .fieldEquals("price", 999);
    }

    @Test
    @DisplayName("GET /goods/{id} — 404 для несуществующего")
    void getByIdNotFound() {
        assertThat(goodsApi.getById(999999)).statusCode(404);
    }

    @Test
    @DisplayName("PATCH /goods/{id} — обновление")
    void patchGoods() {
        Response created = goodsApi.add("Patch " + System.currentTimeMillis(), 100);
        int id = created.jsonPath().getInt("id");

        Response updated = goodsApi.patch(id, Map.of("name", "Updated", "price", 200));
        assertThat(updated)
                .statusCode(200)
                .fieldEquals("name", "Updated")
                .fieldEquals("price", 200);
    }

    @Test
    @DisplayName("DELETE /goods/{id} — удаление")
    void deleteGoods() {
        Response created = goodsApi.add("Delete " + System.currentTimeMillis(), 100);
        int id = created.jsonPath().getInt("id");

        assertThat(goodsApi.deleteById(id)).statusCode(200);
        assertThat(goodsApi.getById(id)).statusCode(404);
    }
}