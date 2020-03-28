package lv.javaguru.productlist.businesslogic.validation;

import lv.javaguru.productlist.domain.Product;

public class ProductNameValidationRule
    implements ProductValidationRule {

    @Override
    public boolean isValid(Product product) {
        return product.getName() != null
                && !product.getName().equals("");
    }

    @Override
    public String errorMessage() {
        return "Empty product name!";
    }
}
