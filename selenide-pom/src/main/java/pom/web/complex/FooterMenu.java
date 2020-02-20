package pom.web.complex;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pom.web.base.ElementContainer;

public class FooterMenu extends ElementContainer {
    public FooterMenu(SelenideElement container) {
        super(container);
    }

    private ElementsCollection getOptions() {
        return getContainer().$$("div.footer-menu-wrapper>div>h3");
    }

    public SelenideElement getOption(String name) {
        ElementsCollection nodes = getOptions().filterBy(Condition.exactText(name));
        return nodes.shouldHaveSize(1).get(0);
    }

    public ElementsCollection getOptionLinks(String name) {
        return getOption(name).parent().$$("ul>li");
    }

    public SelenideElement getLink(String name, String link) {
        ElementsCollection nodes = getOptionLinks(name).filterBy(Condition.exactText(link));
        return nodes.shouldHaveSize(1).get(0);
    }

    public void clickOnLinkUnderOption(String option, String link) {
        getLink(option, link).click();
    }
}
