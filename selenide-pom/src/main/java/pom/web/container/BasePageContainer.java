package pom.web.container;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BasePageContainer {
    protected SelenideElement getPageContainer() {
        return $("div.master-wrapper-page");
    }

}
