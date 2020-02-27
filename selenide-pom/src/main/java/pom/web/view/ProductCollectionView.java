package pom.web.view;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.CollectionElement;
import pom.enums.ViewContentType;
import pom.enums.ViewType;
import pom.web.base.ElementContainer;
import pom.web.base.View;
import pom.web.base.ViewContent;

public class ProductCollectionView extends ElementContainer implements View {

    public ProductCollectionView(SelenideElement container) {
        super(container);
    }

    @Override
    public <T extends View> T castTo(Class<T> viewType) {
        return viewType.cast(this);
    }

    public ElementsCollection getProducts() {
        return getContainer().$$("div.product-grid>div.item-box>div.product-item");
    }

    public SelenideElement getProduct(String name) {
        ElementsCollection elements = getProducts();
        for (SelenideElement element : elements) {
            if (element.$("div.details>h2.product-title>a").has(Condition.exactText(name))) {
                return element.$("div.details>h2.product-title>a");
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

    public View clickOnElement(String name, ViewType viewType) {
        getProduct(name).scrollIntoView(true).click();
        return viewType.build(getContainer());
    }

}
