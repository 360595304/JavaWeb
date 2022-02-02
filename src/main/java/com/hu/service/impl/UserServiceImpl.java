package com.hu.service.impl;

import com.hu.dao.UserDao;
import com.hu.dao.impl.UserDaoImpl;
import com.hu.entiry.User;
import com.hu.service.UserService;

/**
 * @author suhu
 * @createDate 2021/12/2
 */
public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoImpl();

    public User login(String username, String password) {
        if (userDao.getByName(username) == null) {
            throw new RuntimeException("用户名不存在");
        }
        if (userDao.login(username, password)) {
            return userDao.getByName(username);
        } else {
            throw new RuntimeException("请输入正确的密码");
        }
    }

}
