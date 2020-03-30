package lv.javaguru.productlist.businesslogic.validation;

import lv.javaguru.productlist.domain.Product;

public class ProductDescriptionValidationRule
implements ProductValidationRule {

    @Override
    public boolean isValid(Product product) {
        return product.getDescription() != null
                && !product.getDescription().equals("");
    }

    @Override
    public String errorMessage() {
        return "Empty description!";
    }
}
