package lv.javaguru.productlist.businesslogic.validation;

import lv.javaguru.productlist.domain.Product;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductNameValidationRuleTest {

    private ProductValidationRule rule = new ProductNameValidationRule();

    @Test
    public void shouldReturnFalseWhenNameIsNull() {
        Product product = new Product(null, null);
        assertFalse(rule.isValid(product));
    }

}