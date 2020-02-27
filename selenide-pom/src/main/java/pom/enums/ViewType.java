package pom.enums;

import com.codeborne.selenide.SelenideElement;
import pom.web.base.View;
import pom.web.view.CategoriesView;
import pom.web.view.ProductCollectionView;
import pom.web.view.ProductView;
import pom.web.view.ShoppingCartView;

public enum ViewType {
    PRODUCT_COLLECTION,
    CATEGORY,
    PRODUCT,
    SHOPPING_CART;

    public View build(SelenideElement container) {
        switch (this) {
            case PRODUCT_COLLECTION:
                return new ProductCollectionView(container);
            case CATEGORY:
                return new CategoriesView(container);
            case PRODUCT:
                return new ProductView(container);
            case SHOPPING_CART:
                return new ShoppingCartView(container);
            default:
                return null;
        }
    }
}
