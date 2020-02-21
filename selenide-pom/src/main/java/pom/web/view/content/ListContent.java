package pom.web.view.content;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pom.enums.ViewContentType;
import pom.web.base.ElementContainer;
import pom.web.base.View;
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
        return null;
    }

    public SelenideElement getTitle() {
        return null;
    }

    public ElementsCollection getDropdowns() {
        return null;
    }

    public SelenideElement getDropdown(String name) {
        return null;
    }

    public ElementsCollection getElements() {
        return null;
    }

    public SelenideElement getElement(String name) {
        return null;
    }

    public void clickOnElement(String name) {
        getElement(name).click();
    }

    public ViewContent selectElement(String name, ViewContentType viewContentType) {
        clickOnElement(name);
        return viewContentType.build(getContainer());
    }

}
