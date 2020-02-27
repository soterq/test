package pom.web.complex;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pom.web.base.ElementContainer;

public class Row extends ElementContainer {
    public Row(SelenideElement container) {
        super(container);
    }

    public SelenideElement self() {
        return getContainer();
    }

    public SelenideElement getCheckbox() {
        return self().$("");
    }

    public ElementsCollection getCells() {
        return self().$$("td>div");
    }

}