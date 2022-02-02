package com.hu.servlet;

import com.hu.entiry.Book;
import com.hu.service.BookService;
import com.hu.service.impl.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetServlet", value = "/GetServlet")
public class GetServlet extends HttpServlet {

    private final BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String current = request.getParameter("current");
        String size = request.getParameter("size");
        int c, s;
        if (current == null || "".equals(current)) {
            c = 1;
        } else {
            c = Integer.parseInt(current);
        }
        if (size == null || "".equals(size)) {
            s = 10;
        } else {
            s = Integer.parseInt(size);
        }
        String key = request.getParameter("key");
        List<Book> bookList = bookService.getBookList(c, s, key);
        int total = bookService.getTotal(c, s, key);
        int page = (total - 1) / 10 + 1;
        request.getSession().setAttribute("bookList", bookList);
        request.getSession().setAttribute("page", page);
        request.getSession().setAttribute("current", c);
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
