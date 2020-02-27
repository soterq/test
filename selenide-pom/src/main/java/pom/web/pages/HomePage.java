package pom.web.pages;

import com.codeborne.selenide.SelenideElement;
import pom.enums.ViewType;
import pom.web.base.View;
import pom.web.components.NavigationMenu;
import pom.web.container.BasePageContainer;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePageContainer {

    public SelenideElement getLogout() {
        return $("div.header-links>ul>li>a.ico-logout");
    }

    public SelenideElement getShoppingCart() {
        return $("div.header-links>ul>li>a.ico-cart");
    }

    public View clickOnShoppingCart(ViewType viewType) {
        getShoppingCart().click();
        return viewType.build(getPageContainer());
    }

    public NavigationMenu getNavigationMenu() {
        return new NavigationMenu(getPageContainer());
    }


}
