package com.electroshop.service;

import com.electroshop.entity.AppUser;

public interface UserService {
    AppUser authenticate(String email, String password);

    AppUser findByEmail(String email);

    void save(AppUser user);
}
