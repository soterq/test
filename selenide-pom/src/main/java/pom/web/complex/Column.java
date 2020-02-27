package pom.web.complex;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pom.web.base.ElementContainer;

import static com.codeborne.selenide.Selenide.$$;

public class Column extends ElementContainer {
    private final String columnClass;

    public Column(SelenideElement container, String columnClass) {
        super(container);
        this.columnClass = columnClass;
    }

    public SelenideElement self() {
        return getContainer();
    }

    public ElementsCollection getCells() {
        ElementsCollection allCells = $$("table.cart tr>td");
        return allCells.filterBy(Condition.attribute("class", columnClass));
    }
}
