package com.dex.tests;

import com.dex.TestBase;
import com.dex.pages.AuthorizationPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.actions;
import static io.qameta.allure.Allure.step;

@DisplayName("Авторизация")
class AuthorizationTest extends TestBase {
    AuthorizationPage authorizationPage = new AuthorizationPage();
    String phone = "77777777777";
    String pass = "Passw0rd%";

    @Test
    @Tag("smoke")
    @Feature("Авторизация")
    @Story("Авторизация")
    @DisplayName("Авторизация с валидными данными")
    @Severity(SeverityLevel.BLOCKER)
    void authorizationPositiveTest() {
        step("Открываем сайт", () ->
                authorizationPage.openPage());
        step("Нажать кнопку Вход", () ->
                authorizationPage.clickAuthButton());
        step("Заполнить номер телефона", () ->
                authorizationPage.typePhone(phone));
        step("Заполнить пароль", () ->
                authorizationPage.typePassword(pass));
        step("Нажать на кнопку Войти", () ->
                authorizationPage.clickSubmit());
        step("Проверить переход в админ-панель", () ->
                authorizationPage.checkNewsLink());
    }

    @Test
    @Tag("smoke")
    @Feature("Авторизация")
    @Story("Авторизация")
    @DisplayName("Проверка отображения модального окна")
    @Severity(SeverityLevel.BLOCKER)
    void modalTest() {
        step("Открываем сайт", () ->
                authorizationPage.openPage());
        step("Нажать кнопку Вход", () ->
                authorizationPage.clickAuthButton());
        step("Кликнуть в любом месте экрана", () ->
                actions().moveByOffset(400, 400).click().perform());
        step("Проверить отображение модального окна", () ->
                authorizationPage.checkModalTitle("Вы действительно хотите закрыть окно?"));
    }

    @Test
    @Tag("smoke")
    @Feature("Авторизация")
    @Story("Авторизация")
    @DisplayName("Проверка закрытия модального окна")
    @Severity(SeverityLevel.BLOCKER)
    void modalCloseTest() {
        step("Открываем сайт", () ->
                authorizationPage.openPage());
        step("Нажать кнопку Вход", () ->
                authorizationPage.clickAuthButton());
        step("Кликнуть в любом месте экрана", () ->
                actions().moveByOffset(400, 400).click().perform());
        step("Нажать кнопку Подтвердить", () ->
                authorizationPage.clickModalSubmitButton());
        step("Проверить закрытие модального окна", () ->
                authorizationPage.checkUnvisibleModal());
    }

    @Test
    @Tag("smoke")
    @Feature("Авторизация")
    @Story("Авторизация")
    @DisplayName("Проверка кнопки отмена модального окна")
    @Severity(SeverityLevel.BLOCKER)
    void modalCancelTest() {
        step("Открываем сайт", () ->
                authorizationPage.openPage());
        step("Нажать кнопку Вход", () ->
                authorizationPage.clickAuthButton());
        step("Кликнуть в любом месте экрана", () ->
                actions().moveByOffset(400, 400).click().perform());
        step("Нажать кнопку Отмена", () ->
                authorizationPage.clickModalCancelButton());
        step("Проверка отображения формы авторизации", () ->
                authorizationPage.checkAuthForm());
    }

    // Негативные сценарии

    @Feature("Авторизация")
    @Story("Авторизация")
    @DisplayName("Проверка поля номер телефона")
    @Tag("regress")
    @Severity(SeverityLevel.NORMAL)
    @CsvSource(value = {
            "!!!, Длина номера должна быть 11 символов",
            ", Заполните обязательное поле",
            "152, Длина номера должна быть 11 символов",
            ".dsf, Длина номера должна быть 11 символов",
            "@@@, Длина номера должна быть 11 символов",
            "###, Длина номера должна быть 11 символов",
            "$$$, Длина номера должна быть 11 символов",
            "%%%, Длина номера должна быть 11 символов",
            "^^^, Длина номера должна быть 11 символов",
            "&&&, Длина номера должна быть 11 символов",
            "***, Длина номера должна быть 11 символов",
            "(((, Длина номера должна быть 11 символов",
            "))), Длина номера должна быть 11 символов",
            "___, Длина номера должна быть 11 символов",
            "+++, Длина номера должна быть 11 символов",
            "///, Длина номера должна быть 11 символов",
            "****, Длина номера должна быть 11 символов",
            "---, Длина номера должна быть 11 символов",
            "++++, Длина номера должна быть 11 символов",
            "№№№, Длина номера должна быть 11 символов",
            ";;;, Длина номера должна быть 11 символов",
            ":::, Длина номера должна быть 11 символов",
            "???, Длина номера должна быть 11 символов",
            "[[[, Длина номера должна быть 11 символов",
            "}}}, Длина номера должна быть 11 символов",
            "]]], Длина номера должна быть 11 символов",
            "{{{, Длина номера должна быть 11 символов",
            "$$%^, Длина номера должна быть 11 символов",
            "00000000000, Номер должен начинаться с цифры 7",
            "11111111111, Номер должен начинаться с цифры 7",
            "22222222222, Номер должен начинаться с цифры 7",
            "33333333333, Номер должен начинаться с цифры 7",
            "44444444444, Номер должен начинаться с цифры 7",
            "55555555555, Номер должен начинаться с цифры 7",
            "66666666666, Номер должен начинаться с цифры 7",
            "88888888888, Номер должен начинаться с цифры 7",
            "99999999999, Номер должен начинаться с цифры 7",
            "58456454, Длина номера должна быть 11 символов",
            "$$%^, Длина номера должна быть 11 символов",
            "$$%^, Длина номера должна быть 11 символов",
            "$$%^, Длина номера должна быть 11 символов",
            "$&%^#$%^, Длина номера должна быть 11 символов",
            "%$$^%^%$^, Длина номера должна быть 11 символов"})
    @ParameterizedTest(name = "Проверка поля номер телефона с тестовыми данными: {0}")
    void phoneNumberAuthTest(String testData, String expectedResult) {
        step("Открываем сайт", () ->
                authorizationPage.openPage());
        step("Нажать кнопку Вход", () ->
                authorizationPage.clickAuthButton());
        step("Заполнить номер телефона", () ->
                authorizationPage.typePhone(testData));
        step("Заполнить пароль", () ->
                authorizationPage.typePassword("Passw0rd%"));
        step("Нажать на кнопку Войти", () ->
                authorizationPage.clickSubmit());
        step("Проверить отображение ошибки валидации", () ->
                authorizationPage.checkInputError(expectedResult));
    }

    @Feature("Авторизация")
    @Story("Авторизация")
    @DisplayName("Проверка поля пароль")
    @Tag("regress")
    @Severity(SeverityLevel.NORMAL)
    @CsvSource(value = {
            "!!!, Длина пароля должна быть больше 8 символов",
            ", Заполните обязательное поле",
            "152, Длина пароля должна быть больше 8 символов",
            ".dsf, Длина пароля должна быть больше 8 символов",
            "@@@, Длина пароля должна быть больше 8 символов",
            "###, Длина пароля должна быть больше 8 символов",
            "$$$, Длина пароля должна быть больше 8 символов",
            "%%%, Длина пароля должна быть больше 8 символов",
            "^^^, Длина пароля должна быть больше 8 символов",
            "&&&, Длина пароля должна быть больше 8 символов",
            "***, Длина пароля должна быть больше 8 символов",
            "(((, Длина пароля должна быть больше 8 символов",
            "))), Длина пароля должна быть больше 8 символов",
            "___, Длина пароля должна быть больше 8 символов",
            "+++, Длина пароля должна быть больше 8 символов",
            "///, Длина пароля должна быть больше 8 символов",
            "****, Длина пароля должна быть больше 8 символов",
            "---, Длина пароля должна быть больше 8 символов",
            "++++, Длина пароля должна быть больше 8 символов",
            "№№№, Длина пароля должна быть больше 8 символов",
            ";;;, Длина пароля должна быть больше 8 символов",
            ":::, Длина пароля должна быть больше 8 символов",
            "???, Длина пароля должна быть больше 8 символов",
            "[[[, Длина пароля должна быть больше 8 символов",
            "}}}, Длина пароля должна быть больше 8 символов",
            "]]], Длина пароля должна быть больше 8 символов",
            "{{{, Длина пароля должна быть больше 8 символов",
            "$$%^, Длина пароля должна быть больше 8 символов",
            "00000000000, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "11111111111, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "22222222222, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "33333333333, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "44444444444, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "55555555555, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "66666666666, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "88888888888, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "99999999999, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "58456454, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "$$%^, Длина пароля должна быть больше 8 символов",
            "$$%^, Длина пароля должна быть больше 8 символов",
            "$$%^, Длина пароля должна быть больше 8 символов",
            "$&%^#$%^, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "vdsdsfdsf, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "vdsdfdsf, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "%$$^%^%$^, Пароль должен содержать заглавную букву, цифру и спецсимвол"})
    @ParameterizedTest(name = "Проверка поля номер телефона с тестовыми данными: {0}")
    void passwordAuthTest(String testData, String expectedResult) {
        step("Открываем сайт", () ->
                authorizationPage.openPage());
        step("Нажать кнопку Вход", () ->
                authorizationPage.clickAuthButton());
        step("Заполнить номер телефона", () ->
                authorizationPage.typePhone("784895484848"));
        step("Заполнить пароль", () ->
                authorizationPage.typePassword(testData));
        step("Нажать на кнопку Войти", () ->
                authorizationPage.clickSubmit());
        step("Проверить отображение ошибки валидации", () ->
                authorizationPage.checkInputError(expectedResult));
    }

    @Test
    @Tag("regress")
    @Feature("Авторизация")
    @Story("Авторизация")
    @DisplayName("Авторизация с пустыми данными")
    @Severity(SeverityLevel.BLOCKER)
    void authorizationNegativeTest() {
        step("Открываем сайт", () ->
                authorizationPage.openPage());
        step("Нажать кнопку Вход", () ->
                authorizationPage.clickAuthButton());
        step("Нажать на кнопку Войти", () ->
                authorizationPage.clickSubmit());
        step("Проверить всплывающую ошибку", () ->
                authorizationPage.checkInputError("Заполните обязательное поле"));
    }

    @Test
    @Tag("smoke")
    @Feature("Авторизация")
    @Story("Авторизация")
    @DisplayName("Авторизация с незарегистрированным номером")
    @Severity(SeverityLevel.BLOCKER)
    void authorizationNegativePhoneTest() {
        step("Открываем сайт", () ->
                authorizationPage.openPage());
        step("Нажать кнопку Вход", () ->
                authorizationPage.clickAuthButton());
        step("Заполнить номер телефона", () ->
                authorizationPage.typePhone("700000000001"));
        step("Заполнить пароль", () ->
                authorizationPage.typePassword("Passw0rd%"));
        step("Нажать на кнопку Войти", () ->
                authorizationPage.clickSubmit());
        step("Проверить всплывающую ошибку", () ->
                authorizationPage.checkInputError("Учетная запись не найдена"));
    }


}
