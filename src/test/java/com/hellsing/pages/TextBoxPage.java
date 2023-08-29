package com.hellsing.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {
    SelenideElement
            userName = $("#userName"),
            userEmail = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress"),
            submit = $("#submit"),
            outputName = $("#output #name"),
            outputEmail = $("#output #email"),
            outputCurrentAddress = $("#output #currentAddress"),
            outputPermanentAddress = $("#output #permanentAddress");

    public TextBoxPage openPage() {
        open("/text-box");
        removeBanner();

        return this;
    }

    public TextBoxPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setUserName(String value) {
        userName.setValue(value);

        return this;
    }

    public TextBoxPage setUserEmail(String value) {
        userEmail.setValue(value);

        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddress.setValue(value);

        return this;
    }

    public TextBoxPage submit() {
        submit.click();

        return this;
    }

    public TextBoxPage checkName(String value) {
        outputName.shouldHave(text(value));

        return this;
    }

    public TextBoxPage checkEmail(String value) {
        outputEmail.shouldHave(text(value));

        return this;
    }

    public TextBoxPage checkCurrentAddress(String value) {
        outputCurrentAddress.shouldHave(text(value));

        return this;
    }

    public TextBoxPage checkPermanentAddress(String value) {
        outputPermanentAddress.shouldHave(text(value));

        return this;
    }

    public TextBoxPage checkResult(String name, String email, String currentAddress, String permanentAddress) {
        checkName(name);
        checkEmail(email);
        checkCurrentAddress(currentAddress);
        checkPermanentAddress(permanentAddress);

        return this;
    }

}
