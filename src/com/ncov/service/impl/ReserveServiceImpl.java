package com.ncov.service.impl;

import com.ncov.bean.Reserve;
import com.ncov.dao.ReserveDao;
import com.ncov.dao.impl.ReserveDaoImpl;
import com.ncov.service.ReserveService;

import java.util.List;

public class ReserveServiceImpl implements ReserveService {

    ReserveDao reserveDao = new ReserveDaoImpl();

    @Override
    public boolean addReserver(Reserve reserve) {
        if (reserve.getIdCard() == null || reserve.getIdCard() == "") {
            return false;
        }
        return reserveDao.addReserve(reserve);
    }

    @Override
    public boolean isSubscribe(String id_card) {
        Reserve reserv = reserveDao.getOneReservByIdcard(id_card, true).get(0);
        //随便判断一个字段是否有数据
        if (reserv.getIdCard() == null) {
            return true;
        }
        return false;
    }

    @Override
    public List<Reserve> getAllReserv() {
        return reserveDao.getAllReserve();
    }

    @Override
    public List<Reserve> getOneReservByIdcard(String id_card, Boolean isEnd) {
        return reserveDao.getOneReservByIdcard(id_card, isEnd);
    }

    @Override
    public boolean vaccinate(String id) {
        if (id == "") {
            return false;
        }
        return reserveDao.vaccinate(id);
    }
}
