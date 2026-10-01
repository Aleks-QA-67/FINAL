package pages.asserts;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.$;

public class LoginPageAssert {

    private final LoginPage loginPage;

    public LoginPageAssert(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @Step("Проверить, что поле логина видно")
    public LoginPageAssert usernameFieldIsVisible() {
        loginPage.getUsernameField().shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверить, что поле пароля видно")
    public LoginPageAssert passwordFieldIsVisible() {
        loginPage.getPasswordField().shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверить, что кнопка 'Войти' видна")
    public LoginPageAssert submitButtonIsVisible() {
        loginPage.getSubmitButton().shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверить, что показана ошибка: {expected}")
    public LoginPageAssert errorMessageIs(String expected) {
        $(".alert.alert-danger").shouldBe(Condition.visible).shouldHave(Condition.text(expected));
        return this;
    }
}