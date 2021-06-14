package com.ncov.dao.impl;

import com.ncov.bean.User;
import com.ncov.dao.UserDao;
import com.ncov.util.BaseDaoUtil;

import java.util.List;

public class UserDaoImpl implements UserDao {

    static BaseDaoUtil baseDaoUtil = new BaseDaoUtil();

    @Override
    public boolean addUser(User user) {
        String sql ="insert into sys_user values(null,?,?,?)";
        Object[] object = {
                user.getUsername(),
                user.getPassword(),
                user.getPhone()
        };
        return baseDaoUtil.update(sql, object);
    }

    @Override
    public boolean login(User user) {
        String sql = "select * from sys_user where (sys_user.username = ? or sys_user.phone = ?) and sys_user.password = ?";
        Object[] objects = {
                user.getUsername(),
                user.getPhone(),
                user.getPassword()
        };
        List<User> users = baseDaoUtil.selectUser(sql, objects);
        if(users.size() > 0){
            return true;
        }
        return false;
    }
}
