package pom.web.view;

import com.codeborne.selenide.SelenideElement;
import pom.web.base.ElementContainer;
import pom.web.base.View;
import pom.web.complex.ShoppingList;

public class ShoppingCartView extends ElementContainer implements View {
    public ShoppingCartView(SelenideElement container) {
        super(container);
    }

    private SelenideElement getViewContainer() {
        return getContainer().$("div.center-1");
    }

    @Override
    public <T extends View> T castTo(Class<T> viewType) {
        return viewType.cast(this);
    }

    public SelenideElement getPageTitle() {
        return getContainer().$("div.page-title>h1");
    }


    public ShoppingList getShoppingList() {
        return new ShoppingList(getViewContainer().$("div.page-body"));
    }

}
