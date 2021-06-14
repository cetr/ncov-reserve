package com.nocv.service;

import com.nocv.bean.User;

public interface UserService {
    boolean register(User user);

    boolean login(User user);
}
