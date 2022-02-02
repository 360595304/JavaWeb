package com.hu.servlet;

import com.hu.entiry.Book;
import com.hu.service.impl.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BookDetailServlet", value = "/BookDetailServlet")
public class BookDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int bookId = id == null ? 0 : Integer.parseInt(id);
        BookServiceImpl bookService = new BookServiceImpl();
        Book book = bookService.getById(bookId);
        request.setAttribute("book", book);
        request.getRequestDispatcher("/bookDetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
