package pom.web.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pom.web.container.BasePageContainer;

public class Categories extends BasePageContainer {

    private SelenideElement getCategoriesContainer() {
        return getPageContainer().$("div.block block-category-navigation");
    }

    private SelenideElement getTitle() {
        return getCategoriesContainer().$("div.title");
    }

    private ElementsCollection getCategories() {
        return getCategoriesContainer().$$("div.listbox>ul.list>li");
    }

    public ElementsCollection getSubCategories(String category) {
        return getCategory(category).$$("li.active>ul>li");
    }

    public SelenideElement getCategory(String name) {
        ElementsCollection nodes = getCategories().filterBy(Condition.exactText(name));
        return nodes.shouldHaveSize(1).get(0);
    }

    public SelenideElement getSubCategory(String category, String name) {
        ElementsCollection nodes = getSubCategories(category).filterBy(Condition.exactText(name));
        return nodes.shouldHaveSize(1).get(0);
    }

    public void selectCategory(String name) {
        SelenideElement category = getCategory(name);
        category.click();
        category.shouldHave(Condition.cssClass("active"));
    }

    public void selectCategory(String category, String subcategory) {
        selectCategory(category);
        SelenideElement subCategory = getSubCategory(category, subcategory);
        subCategory.click();
        subCategory.shouldHave(Condition.cssClass("active"));
    }

}

