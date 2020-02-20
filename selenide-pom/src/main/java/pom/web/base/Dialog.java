package pom.web.base;

import com.codeborne.selenide.SelenideElement;

public interface Dialog {

    <T extends Dialog> T castTo(Class<T> dialogType);

    SelenideElement getTitle();
}
