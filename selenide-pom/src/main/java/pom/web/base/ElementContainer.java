package pom.web.base;

import com.codeborne.selenide.SelenideElement;

public abstract class ElementContainer {
    private final SelenideElement container;

    public ElementContainer(SelenideElement container) {
        this.container = container;
    }

    public SelenideElement getContainer() {
        return container;
    }
}
