package pom.web.complex;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pom.web.base.ElementContainer;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList extends ElementContainer {
    public ShoppingList(SelenideElement container) {
        super(container);
    }

    private SelenideElement getHeaderContainer() {
        return getContainer().$("table.cart>thead>tr.cart-header-row");
    }

    private SelenideElement getBodyContainer() {
        return getContainer().$("table.cart>tbody");
    }

    public ElementsCollection getColumnsCollection() {
        if (getHeaderContainer().is(Condition.visible)) {
            return getHeaderContainer().$$("th");
        }
        return null;
    }

    public ElementsCollection getRowsCollection() {
        if (getHeaderContainer().is(Condition.visible)) {
            return getBodyContainer().$$("tr");
        }
        return null;
    }

    public List<Column> getColumns() {
        List<Column> allColumns = new ArrayList<>();
        ElementsCollection columns = getColumnsCollection().shouldHave(CollectionCondition.sizeGreaterThan(0));
//        for (SelenideElement element : columns) {
//            String columnClass = element.attr("class");
//            allColumns.add(new Column(element, columnClass));
//        }
        for (SelenideElement element : columns) {
            String name = element.getText();
            switch (name) {
                case ("Remove"):
                    allColumns.add(new Column(element, "remove-from-cart"));
                    break;
                case ("Product(s)"):
                    allColumns.add(new Column(element, "product"));
                    break;
                case ("Price"):
                    allColumns.add(new Column(element, "unit-price nobr"));
                    break;
                case ("Qty."):
                    allColumns.add(new Column(element, "qty nobr"));
                    break;
                case ("Total"):
                    allColumns.add(new Column(element, "subtotal nobr end"));
                    break;

            }
        }
        return allColumns;
    }

    public Column getColumn(String name) {
        List<Column> columns = getColumns();
        return columns.stream().filter(col -> col.self().getText().equals(name)).findFirst().orElse(null);
    }

}