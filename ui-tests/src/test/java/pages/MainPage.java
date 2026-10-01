package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.asserts.MainPageAssert;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement title = $("#main-title");
    private final SelenideElement card1 = $("#card-1");
    private final SelenideElement card2 = $("#card-2");
    private final SelenideElement card3 = $("#card-3");
    private final SelenideElement cartButton = $("#open-cart-btn");
    private final SelenideElement cartCount = $("#cart-count");

    @Step("Открыть главную страницу")
    public MainPage openPage() {
        open("/");
        return this;
    }

    @Step("Кликнуть 'В корзину' на карточке 1")
    public MainPage clickAddToCart1() { card1.$("button").click(); return this; }

    @Step("Кликнуть 'В корзину' на карточке 2")
    public MainPage clickAddToCart2() { card2.$("button").click(); return this; }

    @Step("Кликнуть 'В корзину' на карточке 3")
    public MainPage clickAddToCart3() { card3.$("button").click(); return this; }

    @Step("Открыть корзину")
    public MainPage clickOpenCart() { cartButton.click(); return this; }

    public MainPageAssert assertThat() { return new MainPageAssert(this); }

    public SelenideElement getTitle() { return title; }
    public SelenideElement getCard1() { return card1; }
    public SelenideElement getCard2() { return card2; }
    public SelenideElement getCard3() { return card3; }
    public SelenideElement getCartButton() { return cartButton; }
    public SelenideElement getCartCount() { return cartCount; }
}