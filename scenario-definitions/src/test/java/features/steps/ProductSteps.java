package features.steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.web.view.ProductView;

public class ProductSteps {
    public static ProductView productView;

    @When("Name should have text equal to {string}")
    public void navigateToGroup(String name) {
        productView.getField(name).shouldHave(Condition.exactText(name));
    }

    @Then("Product name should have text equal to {string}")
    public void productNameShouldHaveTextEqualToCamcorder(String text) {
        productView.getProductName().shouldHave(Condition.exactText(text));
    }
}
