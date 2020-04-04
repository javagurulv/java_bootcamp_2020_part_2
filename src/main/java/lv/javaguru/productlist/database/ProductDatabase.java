package lv.javaguru.productlist.database;

import lv.javaguru.productlist.domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDatabase {
    private int currentID = 1;
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        product.setId(currentID);
        products.add(product);
        this.currentID++;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Optional<Product> findProductByName(String productName) {
        return products.stream()
                .filter(product -> product.getName().equals(productName))
                .findFirst();
    }

}
