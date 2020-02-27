package features.steps;

import io.cucumber.java.en.When;
import pom.enums.ViewType;
import pom.web.view.ProductCollectionView;
import pom.web.view.ProductView;

public class ProductCollectionSteps {
    public static ProductCollectionView productCollection;

    @When("Select product {string}")
    public void navigateToGroup(String name) {
        ProductSteps.productView = productCollection.clickOnElement(name, ViewType.PRODUCT).castTo(ProductView.class);
    }
}
