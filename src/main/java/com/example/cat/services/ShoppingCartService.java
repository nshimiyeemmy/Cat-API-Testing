package com.example.cat.services;

import com.example.cat.domain.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
public interface ShoppingCartService {
    void addProduct(Product product);
    void removeProduct(Product product);
    void clearProducts();
     Map<Product, Integer> productsInCart();
    BigDecimal totalPrice();
}
