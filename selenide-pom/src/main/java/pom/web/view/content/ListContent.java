package pom.web.view.content;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pom.enums.ViewContentType;
import pom.web.base.ElementContainer;
import pom.web.base.ViewContent;

public class ListContent extends ElementContainer implements ViewContent {

    public ListContent(SelenideElement container) {
        super(container);
    }

    @Override
    public <T extends ViewContent> T castTo(Class<T> contentType) {
        return contentType.cast(this);
    }


    private ElementsCollection getPaths() {
        return getContainer().$$("div.breadcrumb>ul>li");
    }

    public SelenideElement getTitle() {
        return getContainer().$("div.page-title");
    }

    public ElementsCollection getItems() {
        return getContainer().$$("");
    }

    public SelenideElement getEItem(String name) {
        return null;
    }

    public ViewContent clickOnElement(String name, ViewContentType viewContentType) {
        getEItem(name).click();
        return viewContentType.build(getContainer());
    }

}
