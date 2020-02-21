package features.steps;

import io.cucumber.java.en.And;
import pom.enums.ViewType;
import pom.web.view.content.SubCategoryView;

public class NavigationSteps {
    public static SubCategoryView categoryView;

    @And("Navigate to category {string} under group {string}")
    public void navigateToCategory(String name, String category) {
        switch (name) {
            case "Electronics":
            case "Computers":
                categoryView = LoginSteps.homePage.getNavigationMenu().goTo(category, name, ViewType.CATEGORY).castTo(SubCategoryView.class);
                break;
        }
    }
}
