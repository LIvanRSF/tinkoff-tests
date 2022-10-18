package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import cloud.autotests.helpers.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.driver;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class TinkoffTests extends TestBase {

    TestData testData = new TestData();

    @Test
    @DisplayName("Login form should appear on main page")
    void loginFormVisibilityTest() {
        step("Open https://www.tinkoff.ru/", () -> {
            open("");
        });

        step("Click on login button", () -> {
            $("a[href='/login/']").click();
        });

        step("Login form should be visible", () -> {
            $(".body_in-frame").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Switch language to English on main page")
    void switchToEngLanguageTest() {
        step("Open https://www.tinkoff.ru/", () -> {
            open("");
        });

        step("Click on English language button", () -> {
            $("[data-qa-file='lang']").click();
        });

        step("Switch to new opened window", () -> {
            driver().switchTo().window(1);
        });

        step("Page title should have text 'Tinkoff — a digital financial ecosystem built around customer needs'",
            () -> {
                String expectedTitle = "Tinkoff — a digital financial ecosystem built around customer needs";
                String actualTitle = title();

                assertThat(actualTitle).isEqualTo(expectedTitle);
            });
    }

    @Test
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://www.tinkoff.ru/'", () ->
            open(""));

        step(
            "Page title should have text 'Тинькофф — Кредитные и дебетовые карты, кредиты для бизнеса и физических лиц'",
            () -> {
                String expectedTitle = "Тинькофф — Кредитные и дебетовые карты, кредиты для бизнеса и физических лиц";
                String actualTitle = title();

                assertThat(actualTitle).isEqualTo(expectedTitle);
            });
    }

    @Test
    @DisplayName("Check insert english character error message on invest page")
    void investPageNameFormErrorMessageTest() {
        step("Open url 'https://www.tinkoff.ru/invest'", () ->
            open("/invest"));

        step("Input full name in English. Get error message", () -> {
            $("[data-qa-type='uikit/inputFio.value.input']").sendKeys(testData.fullName);
            $("[name='login']").click();
            $("[data-qa-type='uikit/formRow.errorBlock']")
                .shouldHave(text("Используйте только русские буквы и дефис"));
        });
    }

    @Test
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://www.tinkoff.ru/'", () ->
            open(""));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}