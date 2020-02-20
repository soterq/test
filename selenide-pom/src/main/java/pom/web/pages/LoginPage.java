package pom.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
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

    public HomePage loginAsRegistered(String username, String password) {
        getUsernameInput().shouldBe(Condition.visible).setValue(username).shouldHave(Condition.value(username));
        getPasswordInput().shouldBe(Condition.visible).setValue(password).shouldHave(Condition.value(password));
        getLoginButton().shouldBe(Condition.visible, Condition.enabled).click();
        //TODO: add delay to avoid warnings after login
        Selenide.sleep(2000);
        return Selenide.page(HomePage.class);
    }

    public void loginAsUnregistered(String username, String password) {
        getUsernameInput().shouldBe(Condition.visible).setValue(username).shouldHave(Condition.value(username));
        getPasswordInput().shouldBe(Condition.visible).setValue(password).shouldHave(Condition.value(password));
        getLoginButton().shouldBe(Condition.visible, Condition.enabled).click();
    }

    public HomePage getHomePage() {
        return Selenide.page(HomePage.class);
    }

}
