package pages.asserts;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pages.MainPage;

public class MainPageAssert {

    private final MainPage mainPage;

    public MainPageAssert(MainPage mainPage) {
        this.mainPage = mainPage;
    }

    @Step("Проверить заголовок: {expected}")
    public MainPageAssert titleIs(String expected) {
        mainPage.getTitle().shouldHave(Condition.text(expected));
        return this;
    }

    @Step("Проверить, что карточка 1 видна")
    public MainPageAssert card1IsVisible() {
        mainPage.getCard1().shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверить, что товар в карточке 1 имеет имя: {name}")
    public MainPageAssert card1HasName(String name) {
        mainPage.getCard1().$x(".//h4").shouldHave(Condition.text(name));
        return this;
    }

    @Step("Проверить, что кнопка корзины видна")
    public MainPageAssert cartButtonIsVisible() {
        mainPage.getCartButton().shouldBe(Condition.visible);
        return this;
    }
}