package steps;

import io.qameta.allure.Step;
import pages.LoginPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.$x;

public class BusinessSteps {

    @Step("Авторизоваться как администратор: {login}")
    public void loginAsAdmin(String login, String password) {
        new LoginPage().openPage().login(login, password);
    }

    @Step("Добавить товар '{cardId}' в корзину {times} раз(а)")
    public void addProductToCart(String cardId, int times) {
        for (int i = 0; i < times; i++) {
            $x("//*[@id='" + cardId + "']/button").click();
        }
    }

    @Step("Открыть корзину")
    public void openCart() {
        $x("//*[@id='open-cart-btn']").click();
    }

    @Step("Оформить заказ")
    public void makeOrder() {
        $x("//*[@id='makeOrder']").click();
    }

    @Step("Добавить товар через админку: {name} / {price}")
    public void addProductViaAdmin(String name, String price) {
        $x("//*[@id='nm-1']").setValue(name);
        $x("//*[@id='pr-1']").setValue(price);
        $x("//*[@id='tbody']/tr/td[4]/button[1]").click();
    }
}