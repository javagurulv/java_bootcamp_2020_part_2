package lv.javaguru.productlist.businesslogic.validation;

import lv.javaguru.productlist.domain.Product;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;

public class ProductValidatorTest {

    private ProductValidator validator;

    @Test
    public void shouldReturnFalseResultOneRule() {
        ProductValidationRule rule = Mockito.mock(ProductValidationRule.class);

        List<ProductValidationRule> rules = new ArrayList<>();
        rules.add(rule);

        validator = new ProductValidator(rules);

        Product product = new Product("milk", "sfsf");

        Mockito.when(rule.isValid(product)).thenReturn(false);
        Mockito.when(rule.errorMessage()).thenReturn("Error!");

        ProductValidationResponse response = validator.validate(product);
        assertFalse(response.isSuccess());
        assertEquals(response.getErrorMessages().size(), 1);
        assertTrue(response.getErrorMessages().contains("Error!"));
    }

    @Test
    public void shouldReturnFalseResultTwoRule() {
        ProductValidationRule rule1 = Mockito.mock(ProductValidationRule.class);
        ProductValidationRule rule2 = Mockito.mock(ProductValidationRule.class);

        List<ProductValidationRule> rules = new ArrayList<>();
        rules.add(rule1);
        rules.add(rule2);

        validator = new ProductValidator(rules);

        Product product = new Product("milk", "sfsf");

        Mockito.when(rule1.isValid(product)).thenReturn(false);
        Mockito.when(rule1.errorMessage()).thenReturn("Error 1");

        Mockito.when(rule2.isValid(product)).thenReturn(false);
        Mockito.when(rule2.errorMessage()).thenReturn("Error 2");

        ProductValidationResponse response = validator.validate(product);
        assertFalse(response.isSuccess());
        assertEquals(response.getErrorMessages().size(), 2);
        assertTrue(response.getErrorMessages().contains("Error 1"));
        assertTrue(response.getErrorMessages().contains("Error 2"));
    }

    @Test
    public void shouldReturnTrueResultOneRule() {
        ProductValidationRule rule = Mockito.mock(ProductValidationRule.class);

        List<ProductValidationRule> rules = new ArrayList<>();
        rules.add(rule);

        validator = new ProductValidator(rules);

        Product product = new Product("milk", "sfsf");

        Mockito.when(rule.isValid(product)).thenReturn(true);

        ProductValidationResponse response = validator.validate(product);
        assertTrue(response.isSuccess());
        assertNull(response.getErrorMessages());

        Mockito.verify(rule, times(0)).errorMessage();
    }


}