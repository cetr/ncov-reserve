package com.nocv.service.impl;

import com.nocv.bean.User;
import com.nocv.dao.UserDao;
import com.nocv.dao.impl.UserDaoImpl;
import com.nocv.service.UserService;

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
