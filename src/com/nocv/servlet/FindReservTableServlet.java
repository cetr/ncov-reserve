package com.nocv.servlet;

import com.nocv.bean.Reserve;
import com.nocv.bean.User;
import com.nocv.service.ReserveService;
import com.nocv.service.UserService;
import com.nocv.service.impl.ReserveServiceImpl;
import com.nocv.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/findReservTable")
public class FindReservTableServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        HttpSession httpSession = request.getSession();
        if (httpSession.getAttribute("islogin") != "y") {
            request.setAttribute("session_info", "暂未登录");
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        }

        ReserveService reserveService = new ReserveServiceImpl();
        List<Reserve> reserveList = reserveService.getAllReserv();

        if (reserveList.size() > 0) {
            request.setAttribute("reserveList", reserveList);
            request.setAttribute("info", "成功");
            request.getRequestDispatcher("reservmanage.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "失败");
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
