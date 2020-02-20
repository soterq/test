package pom.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.page;

public class HomePage {
    private NavigationMenu getNavigationMenu() {
        return page(NavigationMenu.class);
    }

}
