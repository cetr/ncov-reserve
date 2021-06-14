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
        String sql = "select * from biz_reserve";
        Object[] object = {};
        List<Reserve> reserveList = baseDaoUtil.selectReserve(sql, object);
        return reserveList;
    }

    @Override
    public Reserve getOneReservByIdcard(String id_card) {
        String sql = "select * from biz_reserve where biz_reserve.id_card = ?";
        Object[] object = {
                id_card
        };
        List<Reserve> reserveList = baseDaoUtil.selectReserve(sql, object);
        Reserve reserve = new Reserve();
        if (reserveList.size() == 1) {
            reserve = reserveList.get(0);
        }
        return reserve;
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
