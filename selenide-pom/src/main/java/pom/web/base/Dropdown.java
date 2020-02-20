package pom.web.base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public abstract class Dropdown extends ElementContainer {
    public Dropdown(SelenideElement container) {
        super(container);
    }

    public abstract SelenideElement self();

    public abstract ElementsCollection getOptions();

    public Dropdown open() {
        self().shouldBe(Condition.visible).click();
        return this;
    }

    public Dropdown select(String option) {
        getOption(option).shouldBe(Condition.visible).click();
        return this;
    }

    public SelenideElement getOption(String name) {
        ElementsCollection elements = getOptions().filterBy(Condition.exactText(name));
        elements.shouldHaveSize(1);
        return elements.get(0);
    }
}
