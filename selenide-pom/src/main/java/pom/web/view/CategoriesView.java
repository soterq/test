package pom.web.view;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pom.enums.ViewContentType;
import pom.enums.ViewType;
import pom.web.base.ElementContainer;
import pom.web.base.View;
import pom.web.base.ViewContent;

public class CategoriesView extends ElementContainer implements View {

    public CategoriesView(SelenideElement container) {
        super(container);
    }

    @Override
    public <T extends View> T castTo(Class<T> viewType) {
        return viewType.cast(this);
    }

    private ElementsCollection getPaths() {
        return getContainer().$$("div.breadcrumb>ul>li");
    }

    public SelenideElement getTitle() {
        return getContainer().$("div.page-title>");
    }

    public ElementsCollection getCategories() {
        return getContainer().$$("div.sub-category-grid>div.item-box>div");
    }

    public SelenideElement getCategory(String name) {
        ElementsCollection nodes = getCategories().filterBy(Condition.exactText(name));
        return nodes.shouldHaveSize(1).get(0);
    }

    public ViewContent selectSection(String name, ViewContentType viewContentType) {
        getCategory(name).click();
        return viewContentType.build(getContainer());
    }

    public String getPath() {
        return "";
    }

    public View selectCategory(String name, ViewType viewType) {
        getCategory(name).scrollIntoView(true).click();
        return viewType.build(getContainer());
    }
}
