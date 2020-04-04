package lv.javaguru.productlist.businesslogic.validation;

import lv.javaguru.productlist.database.ProductDatabase;
import lv.javaguru.productlist.domain.Product;

import java.util.Optional;

public class ProductUniqNameValidationRule
        implements ProductValidationRule {

    private ProductDatabase database;

    public ProductUniqNameValidationRule(ProductDatabase database) {
        this.database = database;
    }

    @Override
    public boolean isValid(Product product) {
        Optional<Product> opt = database.findProductByName(product.getName());
        return !opt.isPresent();
    }

    @Override
    public String errorMessage() {
        return "Product name not unieq!";
    }
}
