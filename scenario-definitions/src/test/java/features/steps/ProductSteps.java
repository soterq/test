package features.steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.web.view.content.ProductContent;

public class ProductSteps {
    public static ProductContent productContent;

    @When("Name should have text equal to {string}")
    public void navigateToGroup(String name) {
        productContent.getField(name).shouldHave(Condition.exactText(name));
    }

    @Then("Product name should have text equal to {string}")
    public void productNameShouldHaveTextEqualToCamcorder(String text) {
        productContent.getProductName().shouldHave(Condition.exactText(text));
    }
}
