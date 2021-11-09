package com.example.cat.services;

import com.example.cat.domain.Product;

import java.util.List;
public interface ProductService {
    void save(Product product);
    void edit(long id, Product newProduct);
    void delete(long id);
    Product findById(long id);

    long count();

}
