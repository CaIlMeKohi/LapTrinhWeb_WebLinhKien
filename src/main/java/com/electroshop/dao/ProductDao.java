package com.electroshop.dao;

import java.util.List;

import com.electroshop.entity.Product;

public interface ProductDao {
    List<Product> findAll();

    Product findById(Long id);
    List<Product> findByCategory(String category);
    List<Product> search(String keyword);
    void save(Product product);
    void delete(Product product);
}
