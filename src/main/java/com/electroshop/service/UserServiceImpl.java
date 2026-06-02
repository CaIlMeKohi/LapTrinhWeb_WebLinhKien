package com.electroshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.electroshop.dao.UserDao;
import com.electroshop.entity.AppUser;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public AppUser authenticate(String email, String password) {
        AppUser user = findByEmail(email);
        return user != null && user.getPassword().equals(password) ? user : null;
    }

    @Override
    @Transactional(readOnly = true)
    public AppUser findByEmail(String email) {
        return email == null || email.isBlank() ? null : userDao.findByEmail(email.trim());
    }

    @Override
    public void save(AppUser user) {
        userDao.save(user);
    }
}
