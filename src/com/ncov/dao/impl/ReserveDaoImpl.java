package com.ncov.dao.impl;

import com.ncov.bean.Reserve;
import com.ncov.dao.ReserveDao;
import com.ncov.util.BaseDaoUtil;

import java.util.List;

public class ReserveDaoImpl implements ReserveDao {
    static BaseDaoUtil baseDaoUtil = new BaseDaoUtil();

    @Override
    public boolean addReserve(Reserve reserve) {
        String sql = "insert into biz_reserve values(null,?,?,?,?,?,?)";
        Object[] object = {
                reserve.getName(),
                reserve.getPhone(),
                reserve.getSex(),
                reserve.getReserveTime(),
                reserve.getIsEnd(),
                reserve.getIdCard()
        };
        boolean isUpdate = baseDaoUtil.update(sql, object);
        return isUpdate;
    }

    @Override
    public List<Reserve> getAllReserve() {
        String sql = "select * from biz_reserve where is_end = '0'";
        Object[] object = {};
        List<Reserve> reserveList = baseDaoUtil.selectReserve(sql, object);
        return reserveList;
    }

    @Override
    public List<Reserve> getOneReservByIdcard(String id_card, Boolean isEnd) {
        String sql = "select * from biz_reserve ";
        Object[] object = {};

        if (id_card != null && !"".equals(id_card)) {
            sql += "where id_card = '" + id_card + "'";
            if (!isEnd) {
                sql += " and is_end = '0'";
            }
        }  else {
            if (!isEnd) {
                sql += " where is_end = '0'";
            }
        }
        return baseDaoUtil.selectReserve(sql, object);
    }

    @Override
    public boolean vaccinate(String id) {
        String sql = "update biz_reserve set is_end = \"1\" where id = ?";
        Object[] object = {
                id
        };
        boolean isUpdate = baseDaoUtil.update(sql, object);
        return isUpdate;
    }
}
