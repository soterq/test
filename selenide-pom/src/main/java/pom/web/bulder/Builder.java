package pom.web.bulder;

import com.codeborne.selenide.SelenideElement;
import pom.web.base.Dialog;
import pom.web.base.View;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Builder {
    public static <T extends Dialog> T buildWindow(Class<T> windowType, SelenideElement container) {
        try {
            Constructor<T> constructor = windowType.getConstructor(SelenideElement.class);
            constructor.setAccessible(true);
            return constructor.newInstance(container);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new IllegalStateException(String.format("Build Window Type '%s'", windowType.getName()), e);
        }
    }

    public <T extends View> T buildView(Class<T> viewType, SelenideElement container) {
        try {
            Constructor<T> constructor = viewType.getConstructor(SelenideElement.class);
            return constructor.newInstance(container);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new IllegalStateException(String.format("Build View Type '%s'", viewType.getName()), e);
        }
    }
}
