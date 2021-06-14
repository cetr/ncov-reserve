package com.nocv.dao;

import com.nocv.bean.Reserve;

import java.util.List;

public interface ReserveDao {
    /**
     * 添加一个预约资料
     *
     * @param reserve
     * @return
     */
    boolean addReserve(Reserve reserve);

    /**
     * 獲取全部已預約信息
     *
     * @return
     */
    List<Reserve> getAllReserve();

    Reserve getOneReservByIdcard(String id_card);

    boolean vaccinate(String id);
}
