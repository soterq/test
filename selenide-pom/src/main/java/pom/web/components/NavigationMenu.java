package pom.web.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pom.enums.ViewType;
import pom.web.base.ElementContainer;
import pom.web.base.View;

public class NavigationMenu extends ElementContainer {

    public NavigationMenu(SelenideElement container) {
        super(container);
    }

    public ElementsCollection getNavigationGroups() {
        return getContainer().$$("div.leftside-3>div");
    }

    public SelenideElement getNavigationGroup(String name) {
        ElementsCollection elements = getNavigationGroups();
        for (SelenideElement element : elements) {
            if (element.$("div.title").has(Condition.exactText(name))) {
                return element;
            }
        }
        return null;
    }


    public ElementsCollection getGroupElements(String name) {
        return getNavigationGroup(name).$$("div.listbox>ul>li");
    }

    public SelenideElement getGroupElement(String group, String name) {
        ElementsCollection elements = getGroupElements(group);
        for (SelenideElement element : elements) {
            if (element.$("a").has(Condition.exactText(name))) {
                return element;
            }
        }
        return null;
    }

    public View goTo(String group, String name, ViewType viewType) {
        getGroupElement(group, name).click();
        return viewType.build(getContainer());
    }


}
