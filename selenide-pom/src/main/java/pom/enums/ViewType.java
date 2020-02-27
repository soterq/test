package pom.enums;

import com.codeborne.selenide.SelenideElement;
import pom.web.base.View;
import pom.web.view.CategoriesView;
import pom.web.view.ProductCollectionView;
import pom.web.view.ProductView;
import pom.web.view.SectionView;

public enum ViewType {
    SECTION,
    PRODUCT_COLLECTION,
    CATEGORY,
    PRODUCT;

    public View build(SelenideElement container) {
        switch (this) {
            case SECTION:
                return new SectionView(container);
            case PRODUCT_COLLECTION:
                return new ProductCollectionView(container);
            case CATEGORY:
                return new CategoriesView(container);
            case PRODUCT:
                return new ProductView(container);
            default:
                return null;
        }
    }
}
