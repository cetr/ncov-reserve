package com.ncov.servlet;

import com.ncov.bean.User;
import com.ncov.service.UserService;
import com.ncov.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class AddAdminUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setPhone(phone);
        user.setUsername(username);
        user.setPassword(password);

        UserService userService = new UserServiceImpl();
        if(userService.register(user)){
            request.setAttribute("info", "注册成功");
            response.sendRedirect("admin.jsp");
        } else {
            request.setAttribute("error", "注册失败");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
