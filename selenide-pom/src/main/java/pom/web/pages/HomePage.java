package pom.web.pages;

import com.codeborne.selenide.SelenideElement;
import pom.web.components.NavigationMenu;
import pom.web.container.BasePageContainer;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class HomePage extends BasePageContainer {
//    private NavigationMenu getNavigationMenu() {
//        return page(NavigationMenu.class);
//    }

    public SelenideElement getLogout() {
        return $("div.header-links>ul>li>a.ico-logout");
    }

    public NavigationMenu getNavigationMenu() {
        return new NavigationMenu(getPageContainer());
    }
}
