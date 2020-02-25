package features.steps;

import io.cucumber.java.en.When;
import pom.enums.ViewContentType;
import pom.web.view.content.ProductContent;

public class ProductCollectionSteps {

    @When("Select product {string}")
    public void navigateToGroup(String name) {
        ProductSteps.productContent = NavigationSteps.sectionView.clickOnElement(name, ViewContentType.PRODUCT).castTo(ProductContent.class);
    }
}
