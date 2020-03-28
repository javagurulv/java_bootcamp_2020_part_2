package lv.javaguru.productlist.businesslogic.validation;

import lv.javaguru.productlist.domain.Product;

public interface ProductValidationRule {

    boolean isValid(Product product);

    String errorMessage();

}
