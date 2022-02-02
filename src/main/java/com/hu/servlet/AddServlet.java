package com.hu.servlet;

import com.hu.entiry.Book;
import com.hu.service.BookService;
import com.hu.service.impl.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddServlet", value = "/AddServlet")
public class AddServlet extends HttpServlet {

    private final BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String price_s = request.getParameter("price");
        double price = Double.parseDouble(price_s);
        String press = request.getParameter("press");
        String intro = request.getParameter("intro");
        String isbn = request.getParameter("isbn");
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setPrice(price);
        book.setPress(press);
        book.setIntro(intro);
        book.setIsbn(isbn);
        bookService.addBook(book);
        response.sendRedirect(request.getContextPath() + "/GetServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
