package pom.enums;

import com.codeborne.selenide.SelenideElement;
import pom.web.base.ViewContent;
import pom.web.view.content.ProductContent;

public enum ViewContentType {
    PRODUCT;

    public ViewContent build(SelenideElement container) {
        switch (this) {
            case PRODUCT:
                return new ProductContent(container);
            default:
                return null;
        }
    }

}
