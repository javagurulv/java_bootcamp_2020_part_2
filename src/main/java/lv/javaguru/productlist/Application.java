package lv.javaguru.productlist;

import lv.javaguru.productlist.businesslogic.ProductService;
import lv.javaguru.productlist.businesslogic.validation.*;
import lv.javaguru.productlist.database.ProductDatabase;
import lv.javaguru.productlist.ui.ProductUI;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        ProductDatabase database = new ProductDatabase();

        List<ProductValidationRule> rules = new ArrayList<>();
        rules.add(new ProductNameValidationRule());
        rules.add(new ProductDescriptionValidationRule());
        rules.add(new ProductUniqNameValidationRule(database));
        ProductValidator productValidator = new ProductValidator(rules);

        ProductService productService = new ProductService(database, productValidator);
        ProductUI ui = new ProductUI(productService);

        ui.executeProgram();
    }

}
