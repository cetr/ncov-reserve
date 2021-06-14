package com.nocv.dao;

import com.nocv.bean.User;

public interface UserDao {
    boolean addUser(User user);

    boolean login(User user);
}
