package com.electroshop.service;

import java.util.List;

import com.electroshop.entity.Product;

public interface ProductService {
    List<Product> findAll();

    Product findById(Long id);
    List<Product> findByCategory(String category);
    List<Product> search(String keyword);
    void save(Product product);
    void delete(Long id);
}
