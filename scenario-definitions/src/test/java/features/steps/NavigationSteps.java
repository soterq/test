package features.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pom.enums.ViewType;
import pom.web.pages.HomePage;
import pom.web.view.SectionView;

public class NavigationSteps {

    public static SectionView sectionView;

    @And("Navigate to category {string} under group {string}")
    public void navigateToCategory(String name, String category) {
        switch (name) {
            case "Electronics":
            case "Computers":
                sectionView = HomePageSteps.homePage.getNavigationMenu().goTo(category, name, ViewType.CATEGORY).castTo(SectionView.class);
                break;
        }
    }

    @When("Navigate to group {string}")
    public void navigateToGroup(String category) {
        sectionView = HomePageSteps.homePage.getNavigationMenu().navigateTo(category, ViewType.CATEGORY).castTo(SectionView.class);
    }

    @When("Navigate to option {string} under group {string}")
    public void navigateToGroup(String category, String subCategory) {
        HomePageSteps.homePage = new HomePage();
        sectionView = HomePageSteps.homePage.getNavigationMenu().navigateTo(category, subCategory, ViewType.CATEGORY).castTo(SectionView.class);
    }


}
