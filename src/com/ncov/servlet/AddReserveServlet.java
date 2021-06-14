package com.ncov.servlet;

import com.ncov.bean.Reserve;
import com.ncov.service.ReserveService;
import com.ncov.service.impl.ReserveServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/subscribe")
public class AddReserveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String sex = request.getParameter("sex");
        String id_card = request.getParameter("id_card");

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = simpleDateFormat.format(date);

        Reserve reserve = new Reserve();
        reserve.setName(name);
        reserve.setPhone(phone);
        reserve.setSex(sex);
        reserve.setReserveTime(nowTime);
        reserve.setIsEnd("0");
        reserve.setIdCard(id_card);

        ReserveService reserveService = new ReserveServiceImpl();

        //判断是否已经预约过了
        if (reserveService.isSubscribe(id_card)) {
            if (reserveService.addReserver(reserve)) {
                request.setAttribute("info", "预约成功");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "预约失败");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("info", "预约失败,已经预约过了！");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
