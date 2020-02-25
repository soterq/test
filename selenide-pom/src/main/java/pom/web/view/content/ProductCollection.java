package pom.web.view.content;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pom.enums.ViewContentType;
import pom.web.base.ElementContainer;
import pom.web.base.ViewContent;

public class ProductCollection extends ElementContainer implements ViewContent {

    public ProductCollection(SelenideElement container) {
        super(container);
    }

    public <T extends ViewContent> T castTo(Class<T> contentType) {
        return contentType.cast(this);
    }

    private ElementsCollection getPaths() {
        return getContainer().$$("div.breadcrumb>ul>li");
    }

    public SelenideElement getTitle() {
        return getContainer().$("div.page-title");
    }

    public ElementsCollection getProducts() {
        return getContainer().$$("div.product-grid>div.item-box");
    }

    public SelenideElement getProduct(String name) {
        ElementsCollection elements = getProducts();
        for (SelenideElement element : elements) {
            if (element.$("div.product-item h2.product-title").has(Condition.exactText(name))) {
                return element;
            }
        }
        return null;
    }

}
