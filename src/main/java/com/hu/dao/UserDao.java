package com.hu.dao;

import com.hu.entiry.User;

public interface UserDao {
    boolean login(String username, String password);
    User getByName(String username);
}
