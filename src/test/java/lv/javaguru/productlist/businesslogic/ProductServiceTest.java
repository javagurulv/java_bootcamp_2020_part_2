package lv.javaguru.productlist.businesslogic;

import lv.javaguru.productlist.businesslogic.validation.ProductValidationResponse;
import lv.javaguru.productlist.businesslogic.validation.ProductValidator;
import lv.javaguru.productlist.database.ProductDatabase;
import lv.javaguru.productlist.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProductServiceTest {

    private ProductValidator validator;
    private ProductDatabase database;
    private ProductService service;

    @Before
    public void setup() {
        validator = Mockito.mock(ProductValidator.class);
        database = Mockito.mock(ProductDatabase.class);
        service = new ProductService(database, validator);
    }

    @Test
    public void shouldReturnFalseWhenValidationFails() {
        List<String> errors = new ArrayList<>();
        errors.add("Name is empty");
        ProductValidationResponse validationResponse =
                new ProductValidationResponse(false, errors);

        Product product = new Product(null, null);

        Mockito.when(validator.validate(product))
                .thenReturn(validationResponse);

        AddProductResponse response = service.addProduct(product);

        assertFalse(response.isSuccess());
        assertEquals(response.getErrorMessages(), errors);

        Mockito.verifyZeroInteractions(database);
    }

    @Test
    public void shouldReturnTrueWhenValidationSucceeds() {
        ProductValidationResponse validationResponse =
                new ProductValidationResponse(true, null);

        Product product = new Product("milk", "abc");

        Mockito.when(validator.validate(product))
                .thenReturn(validationResponse);

        AddProductResponse response = service.addProduct(product);

        assertTrue(response.isSuccess());
        assertNull(response.getErrorMessages());

        Mockito.verify(database).addProduct(product);
    }


}