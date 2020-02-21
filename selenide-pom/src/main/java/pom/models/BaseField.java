package pom.models;

import com.codeborne.selenide.SelenideElement;

public class BaseField {
    private final SelenideElement name;
    private final SelenideElement value;

    public BaseField(SelenideElement name, SelenideElement value) {
        this.name = name;
        this.value = value;
    }

    public SelenideElement getName() {
        return name;
    }

    public SelenideElement getValue() {
        return value;
    }
}
