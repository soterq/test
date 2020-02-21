package pom.web.view.content;

import com.codeborne.selenide.SelenideElement;
import pom.web.base.ElementContainer;
import pom.web.base.ViewContent;

public class ElementContent extends ElementContainer implements ViewContent {

    public ElementContent(SelenideElement container) {
        super(container);
    }

    @Override
    public <T extends ViewContent> T castTo(Class<T> contentType) {
        return contentType.cast(this);
    }

}
