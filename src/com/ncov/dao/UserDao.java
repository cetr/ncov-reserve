package com.ncov.dao;

import com.ncov.bean.User;

public interface UserDao {
    boolean addUser(User user);

    boolean login(User user);
}
