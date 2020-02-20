package features.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.web.pages.HomePage;

public class LoginSteps {
    public static HomePage homePage;

    @And("Enter credentials to log in")
    public void enterUserCredentials() {
        String username = System.getProperty("username");
        String password = System.getProperty("password");
        if (username == null || password == null) {
            throw new IllegalStateException("Invalid user credentials [" + username + ":" + password + "]");
        }
        homePage = BaseSteps.loginPage.loginAsRegistered(username, password);
    }

    @Then("Input {string} should be visible")
    public void inputUsernameShouldBeVisible(String name) {
        SelenideElement input;
        switch (name) {
            case "Username":
                input = BaseSteps.loginPage.getUsernameInput();
                break;
            case "Password":
                input = BaseSteps.loginPage.getPasswordInput();
                break;
            default:
                throw new IllegalStateException(String.format("Unknown input name: '%s'", name));
        }
    }

    @When("Enter username {string}")
    public void enterUsername(String username) {
        BaseSteps.loginPage.getUsernameInput().setValue(username).shouldHave(Condition.value(username));
    }

    @When("Enter password {string}")
    public void enterPassword(String password) {
        BaseSteps.loginPage.getPasswordInput().setValue(password).shouldHave(Condition.value(password));
    }

    @When("Click on button {string}")
    public void clickOnButton(String name) {
        if (!"Login".equals(name)) {
            throw new IllegalStateException(String.format("Unknown button name: '%s'", name));
        }

        BaseSteps.loginPage.getLoginButton().shouldBe(Condition.visible, Condition.enabled).click();
        homePage = BaseSteps.loginPage.getHomePage();
    }

    @Then("Input {string} should be {word}")
    public void inputShouldBe(String name, String state) {
        SelenideElement input;
        switch (name) {
            case "Username":
                input = BaseSteps.loginPage.getUsernameInput();
                break;
            case "Password":
                input = BaseSteps.loginPage.getPasswordInput();
                break;
            default:
                throw new IllegalStateException(String.format("Unknown input name: '%s'", name));
        }

        switch (state) {
            case "visible":
                input.shouldBe(Condition.visible);
                break;
            case "readonly":
                input.shouldBe(Condition.readonly);
                break;
            default:
                throw new IllegalStateException(String.format("Undefined input state: '%s'", state));
        }
    }

    @Then("Button {string} should be {word}")
    public void buttonShouldBe(String name, String state) {
        if (!"Login".equals(name)) {
            throw new IllegalStateException(String.format("Unknown button name: '%s'", name));
        }

        SelenideElement button = BaseSteps.loginPage.getLoginButton();
        switch (state) {
            case "visible":
                button.shouldBe(Condition.visible);
                break;
            case "enabled":
                button.shouldBe(Condition.enabled);
                break;
            case "disabled":
                button.shouldBe(Condition.disabled);
                break;
            default:
                throw new IllegalStateException(String.format("Undefined button state: '%s'", state));
        }
    }
}
