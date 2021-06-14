package com.ncov.service;

import com.ncov.bean.User;

public interface UserService {
    boolean register(User user);

    boolean login(User user);
}
