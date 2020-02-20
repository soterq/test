package pom.web.complex;

import com.codeborne.selenide.SelenideElement;
import pom.web.base.ElementContainer;

public class FooterDisclaimer extends ElementContainer {
    public FooterDisclaimer(SelenideElement container) {
        super(container);
    }

    public SelenideElement self() {
        return getContainer().$("div.footer-disclaimer");
    }
}
