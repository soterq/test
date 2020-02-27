package features.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pom.enums.ViewType;
import pom.web.pages.HomePage;
import pom.web.view.CategoriesView;
import pom.web.view.ProductCollectionView;

public class NavigationSteps {


    @And("Navigate to category {string} under group {string}")
    public void navigateToCategory(String name, String category) {
        switch (name) {
            case "Electronics":
            case "Computers":
                ProductCollectionSteps.productCollection = HomePageSteps.homePage.getNavigationMenu().goTo(category, name, ViewType.PRODUCT_COLLECTION).castTo(ProductCollectionView.class);
                break;
        }
    }

    @When("Navigate to group {string}")
    public void navigateToGroup(String category) {
        switch (category) {
            case "ELECTRONICS":
            case "COMPUTERS":
                CategorySteps.categoriesView = HomePageSteps.homePage.getNavigationMenu().navigateTo(category, ViewType.CATEGORY).castTo(CategoriesView.class);
                break;
            default:
                ProductCollectionSteps.productCollection = HomePageSteps.homePage.getNavigationMenu().navigateTo(category, ViewType.PRODUCT_COLLECTION).castTo(ProductCollectionView.class);
        }
    }

    @When("Navigate to option {string} under group {string}")
    public void navigateToGroup(String category, String subCategory) {
        ProductCollectionSteps.productCollection = HomePageSteps.homePage.getNavigationMenu().navigateTo(category, subCategory, ViewType.PRODUCT_COLLECTION).castTo(ProductCollectionView.class);
    }

}
