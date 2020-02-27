package pom.web.view;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pom.web.base.ElementContainer;
import pom.web.base.View;
import pom.web.base.ViewContent;

public class ProductView extends ElementContainer implements View {

    public ProductView(SelenideElement container) {
        super(container);
    }

    @Override
    public <T extends View> T castTo(Class<T> viewType) {
        return viewType.cast(this);
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
