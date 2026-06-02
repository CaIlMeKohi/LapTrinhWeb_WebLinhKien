package com.electroshop.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.electroshop.entity.AppUser;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public AppUser findByEmail(String email) {
        List<AppUser> users = sessionFactory.getCurrentSession()
                .createQuery("from AppUser where lower(email) = :email", AppUser.class)
                .setParameter("email", email.toLowerCase())
                .getResultList();
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public void save(AppUser user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }
}
