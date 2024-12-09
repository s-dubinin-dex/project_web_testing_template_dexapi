package com.dex.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationPage {

    SelenideElement
            authButton = $(byText("Вход")),
            phoneInput = $("[name=phone]"),
            rootElement = $("#root"),
            passwordInput = $("[name=password]"),
            submitButton = $("[type=submit]"),
            newsLink = $(byText("новости")),
            modalTitle = $(byText("Вы действительно хотите закрыть окно?")),
            modalSubmitButton = $(byText("Подтвердить")),
            modalCancelButton = $(byText("Отмена")),
            authForm = $(byText("Вход на портал"));


    public void clickAuthButton() {
        authButton.click();
    }

    public void clickModalSubmitButton() {
        modalSubmitButton.click();
    }

    public void clickModalCancelButton() {
        modalCancelButton.click();
    }

    public void openPage() {
        open("/");
    }

    public void typePhone(String value) {
        phoneInput.setValue(value);
    }

    public void typePassword(String value) {
        passwordInput.setValue(value);
    }

    public void checkNewsLink() {
        newsLink.shouldBe(visible);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public void checkModalTitle(String value) {
        modalTitle.shouldHave(text(value));
    }

    public void checkInputError(String value) {
        rootElement.shouldHave(text(value));
    }

    public void checkUnvisibleModal() {
        modalTitle.shouldNotBe(visible);
    }

    public void checkAuthForm() {
        authForm.shouldBe(visible);
    }

}
