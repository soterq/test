package pom.web.base;

public interface View {
    <T extends View> T castTo(Class<T> viewType);
}
