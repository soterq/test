package pom.web.view;

import com.codeborne.selenide.SelenideElement;
import pom.web.base.ElementContainer;
import pom.web.base.View;

public class ListView extends ElementContainer implements View {

    public ListView(SelenideElement container) {
        super(container);
    }

    @Override
    public <T extends View> T castTo(Class<T> viewType) {
        return viewType.cast(this);
    }
}
