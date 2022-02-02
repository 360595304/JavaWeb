package com.hu.servlet;

import com.hu.entiry.Book;
import com.hu.service.BookService;
import com.hu.service.impl.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetOneServlet", value = "/GetOneServlet")
public class GetOneServlet extends HttpServlet {

    private final BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id == null || "".equals(id)) {
            response.sendRedirect(request.getContextPath() + "/index.js");
        }
        Book book = bookService.getById(Integer.parseInt(id));
        request.getSession().setAttribute("editBook", book);
        response.sendRedirect(request.getContextPath() + "/updateBook.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
