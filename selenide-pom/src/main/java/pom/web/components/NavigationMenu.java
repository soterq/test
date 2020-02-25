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

    public ElementsCollection getNavigationOptions() {
        return getContainer().$$("ul.top-menu>li");
    }

    public SelenideElement getNavigationOption(String name) {
//        ElementsCollection elements = getNavigationOptions().filterBy(Condition.exactText(name));
//        elements.shouldHaveSize(1);
//        return elements.get(0);
        ElementsCollection elements = getNavigationOptions();
        for (SelenideElement element : elements) {
            if (element.$("a").has(Condition.exactText(name))) {
                return element;
            }
        }
        return null;
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

    public ElementsCollection getSubGroups(String group) {
        return getNavigationOption(group).hover().$$("ul>li");
    }

    public SelenideElement getSubGroup(String group, String name) {
        ElementsCollection elements = getSubGroups(group).filterBy(Condition.exactText(name));
        elements.shouldHaveSize(1);
        return elements.get(0);
    }

    public ElementsCollection getGroupElements(String name) {
        return getNavigationGroup(name).hover().$$("div.listbox>ul>li");
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

    public View navigateTo(String name, ViewType viewType) {
        getNavigationOption(name).click();
        return viewType.build(getContainer());
    }

    public View navigateTo(String group, String name, ViewType viewType) {
        getSubGroup(group, name).click();
        return viewType.build(getContainer());
    }

}
