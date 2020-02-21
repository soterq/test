package pom.web.view.content;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pom.web.base.ElementContainer;
import pom.web.base.ViewContent;

public class ProductContent extends ElementContainer implements ViewContent {

    public ProductContent(SelenideElement container) {
        super(container);
    }

    @Override
    public <T extends ViewContent> T castTo(Class<T> contentType) {
        return contentType.cast(this);
    }

    private ElementsCollection getPaths() {
        return getContainer().$$("div.breadcrumb>ul>li");
    }

    public SelenideElement getProductName() {
        return getContainer().$("div.product-name");
    }

    public SelenideElement getDescription() {
        return getContainer().$("div.product-name");
    }

    public ElementsCollection getDeliveryInfo() {
        return getContainer().$$("div.delivery-date>span");
    }

    public ElementsCollection getFields() {
        return getContainer().$$("div>label");
    }

    public SelenideElement getField(String name) {
        ElementsCollection fields = getFields();
        for (SelenideElement element : fields) {
            if (element.has(Condition.exactText(name))) {
                return element.parent().$("input");
            }
        }
        return null;
    }

}
