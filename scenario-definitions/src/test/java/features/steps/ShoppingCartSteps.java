package features.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.web.view.ShoppingCartView;

import java.util.List;

public class ShoppingCartSteps {
    public static ShoppingCartView shoppingCart;

    @Then("Title should be {string}")
    public void titleShouldBe(String name) {
        shoppingCart.getPageTitle().shouldHave(Condition.exactText(name));
    }

    @When("Shopping cart should have columns")
    public void shoppingCartShouldHaveColumns(List<String> columns) {
        shoppingCart.getShoppingList().getColumn("Product(s)").getCells();
        shoppingCart.getShoppingList().getColumnsCollection().shouldHave(CollectionCondition.exactTexts(columns));
    }
}
