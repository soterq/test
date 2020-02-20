package pom.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public SelenideElement getUsernameInput() {
        return $("input[name='Email']");
    }

    public SelenideElement getPasswordInput() {
        return $("input[name='Password']");
    }

    public SelenideElement getLoginButton() {
        return $("div.form-fields div.buttons>input");
    }

    public SelenideElement getErrorText() {
        return $("div.validation-summary-errors");
    }

}
