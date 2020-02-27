package features.steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.When;
import pom.enums.ViewType;
import pom.web.pages.HomePage;
import pom.web.view.ShoppingCartView;

public class HomePageSteps {
    public static HomePage homePage;

    @When("Click on logout")
    public void enterUsername() {
        homePage.getLogout().shouldBe(Condition.visible).click();
    }

    @When("In Home Page click on button {string}")
    public void inHomePageClickOnButton(String option) {
        if (option.equalsIgnoreCase("shopping cart")) {
            ShoppingCartSteps.shoppingCart = homePage.clickOnShoppingCart(ViewType.SHOPPING_CART).castTo(ShoppingCartView.class);
        }
    }

}
