package com.hu.service;

import com.hu.entiry.User;

public interface UserService {
    User login(String username, String password);
}
