package com.nocv.util;

import com.nocv.bean.Reserve;
import com.nocv.bean.User;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseDaoUtil {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    /**
     * 更新数据库，包括增加、删除、修改
     *
     * @param sql  字符串，要执行的sql语句
     * @param objs 对象数组，sql中要拼接的各种值
     * @return 是否更新成功
     */
    public boolean update(String sql, Object[] objs) {
        boolean flag = false;
        try {
            connection = DBTools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < objs.length; i++) {
                preparedStatement.setObject(i + 1, objs[i]);
            }
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTools.close(resultSet, preparedStatement, connection);
        }
        return flag;
    }

    /**
     * 查询User数据
     *
     * @param sql  字符串，要执行的sql语句
     * @param objs 对象数组，sql中要拼接的各种值
     * @return List<User>
     */
    public List<User> selectUser(String sql, Object[] objs) {
        connection = DBTools.getConnection();
        List<User> list = new ArrayList<User>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < objs.length; i++) {
                preparedStatement.setObject(i + 1, objs[i]);
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setPhone(resultSet.getString("phone"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTools.close(resultSet, preparedStatement, connection);
        }
        return list;
    }

    /**
     * 查询Reserve数据
     *
     * @param sql  字符串，要执行的sql语句
     * @param objs 对象数组，sql中要拼接的各种值
     * @return List<Student>
     */
    public List<Reserve> selectReserve(String sql, Object[] objs) {
        connection = DBTools.getConnection();
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < objs.length; i++) {
                preparedStatement.setObject(i + 1, objs[i]);
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Reserve reserve = new Reserve();
                reserve.setId(resultSet.getInt("id"));
                reserve.setName(resultSet.getString("name"));
                reserve.setPhone(resultSet.getString("phone"));
                reserve.setSex(resultSet.getString("sex"));
                reserve.setReserveTime(resultSet.getString("reserve_time"));
                reserve.setIsEnd(resultSet.getString("is_end"));
                reserve.setIdCard(resultSet.getString("id_card"));
                list.add(reserve);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTools.close(resultSet, preparedStatement, connection);
        }
        return list;
    }
}
