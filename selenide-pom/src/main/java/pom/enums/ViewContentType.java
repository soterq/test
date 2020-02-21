package pom.enums;

import com.codeborne.selenide.SelenideElement;
import pom.web.base.ViewContent;
import pom.web.view.NavigationGroup;
import pom.web.view.content.ListContent;

public enum ViewContentType {
    CATEGORY,
    LIST;

    public ViewContent build(SelenideElement container) {
        switch (this) {
            case LIST:
                return new ListContent(container);
            case CATEGORY:
                return new NavigationGroup(container);
            default:
                return null;
        }
    }

}
