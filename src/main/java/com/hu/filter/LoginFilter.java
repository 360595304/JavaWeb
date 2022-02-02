package com.hu.filter;

import com.hu.entiry.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", value = "/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest rq, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) rq;
        String uri = request.getRequestURI();
        System.out.println("uri: " + uri);
        // 验证请求路径
        if (uri.contains("login.jsp") || uri.contains("Login") || uri.endsWith(".css") || uri.endsWith(".js")
                || uri.endsWith(".jpg") || uri.endsWith(".png")) {
            chain.doFilter(rq, resp);
        } else {
            HttpSession session = request.getSession();
            User userInfo = (User) session.getAttribute("userInfo");
            if (userInfo != null) {
                System.out.println("ROLE = " + userInfo.getRole());
                chain.doFilter(rq, resp);
            } else {
                request.setAttribute("login_msg", "您尚未登陆，请先登陆！");
                request.getRequestDispatcher("/login.jsp").forward(request, resp);
            }
        }
    }
}
