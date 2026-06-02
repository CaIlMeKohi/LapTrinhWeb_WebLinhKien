package com.electroshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.electroshop.dao.ProductDao;
import com.electroshop.entity.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return productDao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findByCategory(String category) {
        return productDao.findByCategory(category);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> search(String keyword) {
        return productDao.search(keyword);
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public void delete(Long id) {
        Product product = productDao.findById(id);
        if (product != null) productDao.delete(product);
    }
}
