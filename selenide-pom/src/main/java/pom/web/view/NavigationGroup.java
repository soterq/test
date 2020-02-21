package pom.web.view;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pom.enums.ViewType;
import pom.web.base.ElementContainer;
import pom.web.base.View;
import pom.web.base.ViewContent;

public class NavigationGroup extends ElementContainer implements ViewContent {
    //subcategoria Category
    public NavigationGroup(SelenideElement container) {
        super(container);
    }

    @Override
    public <T extends ViewContent> T castTo(Class<T> contentType) {
        return contentType.cast(this);
    }


    public SelenideElement getTitle() {
        return getContainer().$("div.title");
    }

    public ElementsCollection getCategories() {
        return getContainer().$$("div.listbox>ul>li");
    }

    public SelenideElement getCategory(String name) {
        ElementsCollection nodes = getCategories().filterBy(Condition.exactText(name));
        return nodes.shouldHaveSize(1).get(0);
    }

    public ElementsCollection getSubCategories(String name) {
        return getCategory(name).$$("ul.sublist>li");
    }

    public SelenideElement getSubCategory(String category, String name) {
        ElementsCollection nodes = getSubCategories(name).filterBy(Condition.exactText(name));
        return nodes.shouldHaveSize(1).get(0);
    }

    //click din left side bar navigation
    public View goToCategory(String category, ViewType viewType) {
        getCategory(category).click();
        return viewType.build(getContainer());
    }
}

