package pom.web.view;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.CollectionElement;
import pom.enums.ViewContentType;
import pom.web.base.ElementContainer;
import pom.web.base.View;
import pom.web.base.ViewContent;

public class SectionView extends ElementContainer implements View {
    public SectionView(SelenideElement container) {
        super(container);
    }

    @Override
    public <T extends View> T castTo(Class<T> viewType) {
        return viewType.cast(this);
    }

    public ElementsCollection getProducts() {
        return getContainer().$$("div.product-grid>div.item-box>div");
    }

    public SelenideElement getProduct(String name) {
        ElementsCollection elements = getProducts();
        for (SelenideElement element : elements) {
            if (element.$("div.details a").has(Condition.exactText(name))) {
                return element.$("h2.product-title");
            }
        }
        return null;
    }

    public CollectionElement getPath() {
        return null;
    }

    public SelenideElement getSectionName() {
        return null;
    }

    public ViewContent clickOnElement(String name, ViewContentType viewContentType) {
        getProduct(name).scrollIntoView(true).click();
        return viewContentType.build(getContainer());
    }
}
