package com.ncov.service;

import com.ncov.bean.Reserve;

import java.util.List;

public interface ReserveService {
    boolean addReserver(Reserve reserve);

    /**
     * null true
     * @param id_card
     * @return
     */
    boolean isSubscribe(String id_card);

    List<Reserve> getAllReserv();

    Reserve getOneReservByIdcard(String id_card);

    boolean vaccinate(String id);
}