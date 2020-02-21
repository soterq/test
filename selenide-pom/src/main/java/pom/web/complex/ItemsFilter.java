package pom.web.complex;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pom.web.base.ElementContainer;

public class ItemsFilter extends ElementContainer {
    public ItemsFilter(SelenideElement container) {
        super(container);
    }

    public SelenideElement self() {
        if (getContainer().lastChild().exists())
            return getContainer().lastChild();
        return null;
    }

    public ElementsCollection getFilters() {
        return getContainer().$$("div.product-selectors>div");
    }

    public SelenideElement getFilter(String name) {
        ElementsCollection elements = getFilters();
        for (SelenideElement element : elements) {
            if (element.$("span").has(Condition.exactText(name))) {
                return element;
            }
        }
        return null;
    }



}
