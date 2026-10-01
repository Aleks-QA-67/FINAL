package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.asserts.LoginPageAssert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private final SelenideElement usernameField = $("#username");
    private final SelenideElement passwordField = $("#password");
    private final SelenideElement submitButton = $("button[type='submit']");

    @Step("Открыть страницу логина")
    public LoginPage openPage() { open("/login"); return this; }

    @Step("Ввести логин: {username}")
    public LoginPage setUsername(String username) { usernameField.setValue(username); return this; }

    @Step("Ввести пароль")
    public LoginPage setPassword(String password) { passwordField.setValue(password); return this; }

    @Step("Нажать 'Войти'")
    public LoginPage clickLogin() { submitButton.click(); return this; }

    @Step("Авторизоваться: {username}")
    public LoginPage login(String username, String password) {
        return setUsername(username).setPassword(password).clickLogin();
    }

    public LoginPageAssert assertThat() { return new LoginPageAssert(this); }

    public SelenideElement getUsernameField() { return usernameField; }
    public SelenideElement getPasswordField() { return passwordField; }
    public SelenideElement getSubmitButton() { return submitButton; }
}