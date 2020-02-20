package pom.web.pages;

import pom.web.components.NavigationMenu;

import static com.codeborne.selenide.Selenide.page;

public class HomePage {
    private NavigationMenu getNavigationMenu() {
        return page(NavigationMenu.class);
    }

}
