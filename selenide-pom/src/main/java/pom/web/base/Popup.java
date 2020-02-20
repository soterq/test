package pom.web.base;

import com.codeborne.selenide.SelenideElement;

public interface Popup {

    SelenideElement self();

    void close();
}
