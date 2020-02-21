package pom.web.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pom.web.base.ElementContainer;

public class NavigationGroups extends ElementContainer {
    public NavigationGroups(SelenideElement container) {
        super(container);
    }

    public ElementsCollection getGroups() {
        return getContainer().$$("div.side-2.div");
    }

    public SelenideElement getGroup(String name) {
        ElementsCollection group = getGroups().filterBy(Condition.exactText(name));
        return group.shouldHaveSize(1).get(0);
    }

}
