package com.hu.servlet;

import com.hu.entiry.User;
import com.hu.service.UserService;
import com.hu.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        User user;
        try {
            user = userService.login(username, password);
            HttpSession session = request.getSession();
            session.setAttribute("userInfo", user);
            response.sendRedirect(request.getContextPath() + "/GetServlet");
        } catch (RuntimeException e) {
            String msg = e.getMessage();
            System.out.println(msg);
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
