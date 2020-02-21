package pom.web.base;

public interface ViewContent {
    <T extends ViewContent> T castTo(Class<T> contentType);
}
