package com.nocv.service.impl;

import com.nocv.bean.Reserve;
import com.nocv.dao.ReserveDao;
import com.nocv.dao.impl.ReserveDaoImpl;
import com.nocv.service.ReserveService;

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
        Reserve reserv = reserveDao.getOneReservByIdcard(id_card);
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
    public Reserve getOneReservByIdcard(String id_card) {
        return reserveDao.getOneReservByIdcard(id_card);
    }

    @Override
    public boolean vaccinate(String id) {
        if (id == "") {
            return false;
        }
        return reserveDao.vaccinate(id);
    }
}
