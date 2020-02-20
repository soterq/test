package pom.enums;

import com.codeborne.selenide.SelenideElement;
import pom.web.base.View;
import pom.web.view.CategoryView;
import pom.web.view.ListView;

public enum ViewType {
    CATEGORY,
    LIST;

    public View build(SelenideElement container) {
        switch (this) {
            case CATEGORY:
                return new CategoryView(container);
            case LIST:
                return new ListView(container);
            default:
                return null;
        }
    }
}
