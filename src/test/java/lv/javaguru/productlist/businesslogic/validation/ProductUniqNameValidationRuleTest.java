package lv.javaguru.productlist.businesslogic.validation;

import lv.javaguru.productlist.database.ProductDatabase;
import lv.javaguru.productlist.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.Assert.*;

public class ProductUniqNameValidationRuleTest {

    private ProductDatabase database;
    private ProductUniqNameValidationRule rule;

    @Before
    public void setup() {
        database = Mockito.mock(ProductDatabase.class);
        rule = new ProductUniqNameValidationRule(database);
    }

    @Test
    public void shouldReturnFalse() {
        Product milk1 = new Product("milk", "dfds");
        Product milk2 = new Product("milk", "9898");
        Mockito.when(database.findProductByName("milk"))
                .thenReturn(Optional.of(milk1));
        assertFalse(rule.isValid(milk2));
    }

    @Test
    public void shouldReturnTrue() {
        Product milk1 = new Product("milk", "dfds");
        Mockito.when(database.findProductByName("milk"))
                .thenReturn(Optional.empty());
        assertTrue(rule.isValid(milk1));
    }


}