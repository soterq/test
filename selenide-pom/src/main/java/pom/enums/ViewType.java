package pom.enums;

import com.codeborne.selenide.SelenideElement;
import pom.web.base.View;
import pom.web.view.content.SubCategoryView;

public enum ViewType {
    CATEGORY;


    public View build(SelenideElement container) {
        switch (this) {
            case CATEGORY:
                return new SubCategoryView(container);
            default:
                return null;
        }
    }
}
