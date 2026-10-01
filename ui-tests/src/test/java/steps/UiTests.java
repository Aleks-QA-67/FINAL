package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.TestConfig;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import pages.MainPage;
import steps.BusinessSteps;

import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("UI")
@Feature("SmartShop")
public class UiTests {

    private final BusinessSteps steps = new BusinessSteps();

    @BeforeAll
    static void setUpAllure() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(true));
        TestConfig.printConfig();
    }

    @BeforeEach
    void setUp() {
        Configuration.timeout = TestConfig.getTimeout();
        Configuration.baseUrl = TestConfig.getBaseUrl();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }

    @AfterEach
    void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

    @Test
    @Tag("smokeUi")
    @DisplayName("2.1. Добавить товар в корзину и проверить")
    void addProductToCartAndCheck() {
        new MainPage().openPage().clickAddToCart1().clickOpenCart();
        $x("//*[@id='container']").shouldHave(Condition.text("Помидорка"));
    }

    @Test
    @DisplayName("2.2. Неверные данные — сообщение об ошибке")
    void loginWithInvalidCredentials() {
        steps.loginAsAdmin("wrong", "wrong");
        $x("//*[contains(@class,'alert-danger')]")
                .shouldHave(Condition.text("Неверные учетные данные пользователя"));
    }

    @Test
    @DisplayName("2.3. Сумма > 300 ₽ → JS Alert")
    void orderWithSumMoreThan300_shouldShowAlert() {
        new MainPage().openPage();
        steps.addProductToCart("card-1", 4);
        steps.openCart();
        steps.makeOrder();

        String alertText = com.codeborne.selenide.Selenide.confirm();
        assertThat(alertText)
                .contains("Денег не хватает")
                .contains("превышает лимит 300 ₽");
    }
}