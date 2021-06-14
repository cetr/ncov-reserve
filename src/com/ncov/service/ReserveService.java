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

    List<Reserve> getOneReservByIdcard(String id_card, Boolean isEnd);

    boolean vaccinate(String id);
}