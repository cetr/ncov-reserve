package com.ncov.service.impl;

import com.ncov.bean.User;
import com.ncov.dao.UserDao;
import com.ncov.dao.impl.UserDaoImpl;
import com.ncov.service.UserService;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public boolean register(User user) {
        if (user.getUsername() == null || user.getUsername() == "") {
            return false;
        }
        return userDao.addUser(user);
    }

    @Override
    public boolean login(User user) {
        return userDao.login(user);
    }
}
