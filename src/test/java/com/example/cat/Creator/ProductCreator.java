package com.example.cat.Creator;

import com.example.cat.domain.Product;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
public class ProductCreator {

    public static final String NAME = "Test";
    public static final String DESCRIPTION = "testDescriptionTestDescription";
    public static final BigDecimal PRICE = BigDecimal.valueOf(1000);
    public static Product createTestProduct(){
        Product testProduct = new Product();

        testProduct.setName(NAME);
        testProduct.setDescription(DESCRIPTION);
        testProduct.setPrice(PRICE);

        return testProduct;
    }

    public static Set<Product> createTestProducts(){
        Set<Product> testProducts = new HashSet<>();

        testProducts.add(createTestProduct());
        testProducts.add(createTestProduct());
        testProducts.add(createTestProduct());

        return testProducts;
    }

}
