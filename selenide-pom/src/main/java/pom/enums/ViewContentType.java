package pom.enums;

import com.codeborne.selenide.SelenideElement;
import pom.web.base.ViewContent;
import pom.web.view.content.CategoriesContent;
import pom.web.view.content.ProductCollection;
import pom.web.view.content.ProductContent;

public enum ViewContentType {
    CATEGORY,
    PRODUCT_COLLECTION,
    PRODUCT;

    public ViewContent build(SelenideElement container) {
        switch (this) {
            case PRODUCT_COLLECTION:
                return new ProductCollection(container);
            case CATEGORY:
                return new CategoriesContent(container);
            case PRODUCT:
                return new ProductContent(container);
            default:
                return null;
        }
    }

}
