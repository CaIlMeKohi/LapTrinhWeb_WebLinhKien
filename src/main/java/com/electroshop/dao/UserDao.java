package com.electroshop.dao;

import com.electroshop.entity.AppUser;

public interface UserDao {
    AppUser findByEmail(String email);

    void save(AppUser user);
}
