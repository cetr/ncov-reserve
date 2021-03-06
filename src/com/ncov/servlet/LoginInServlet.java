package com.ncov.servlet;

import com.ncov.bean.User;
import com.ncov.service.UserService;
import com.ncov.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginInServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String usernameOrPhone = request.getParameter("usernameOrPhone");
        String password = request.getParameter("password");

        User user = new User();
        user.setPhone(usernameOrPhone);
        user.setUsername(usernameOrPhone);
        user.setPassword(password);

        UserService userService = new UserServiceImpl();
        if(userService.login(user)){
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("islogin","y");

            request.setAttribute("info", "登录成功");
            response.sendRedirect("/findReservTable");
        } else {
            request.setAttribute("error", "用户名或密码错误");
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
