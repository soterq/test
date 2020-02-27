package features.steps;

import io.cucumber.java.en.When;
import pom.enums.ViewType;
import pom.web.view.CategoriesView;
import pom.web.view.ProductCollectionView;

public class CategorySteps {

    public static CategoriesView categoriesView;

    @When("select category {string}")
    public void selectCategory(String name) {
        ProductCollectionSteps.productCollection = categoriesView.selectCategory(name, ViewType.PRODUCT_COLLECTION).castTo(ProductCollectionView.class);
    }
}