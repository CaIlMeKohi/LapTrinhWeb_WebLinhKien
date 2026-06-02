package com.electroshop.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.electroshop.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Product order by id desc", Product.class)
                .getResultList();
    }

    @Override
    public Product findById(Long id) {
        return sessionFactory.getCurrentSession().get(Product.class, id);
    }

    @Override
    public List<Product> findByCategory(String category) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Product where lower(category) = :category order by id desc", Product.class)
                .setParameter("category", category.toLowerCase())
                .getResultList();
    }

    @Override
    public List<Product> search(String keyword) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Product where lower(name) like :keyword order by id desc", Product.class)
                .setParameter("keyword", "%" + keyword.toLowerCase() + "%")
                .getResultList();
    }

    @Override
    public void save(Product product) {
        sessionFactory.getCurrentSession().saveOrUpdate(product);
    }

    @Override
    public void delete(Product product) {
        sessionFactory.getCurrentSession().delete(product);
    }
}
