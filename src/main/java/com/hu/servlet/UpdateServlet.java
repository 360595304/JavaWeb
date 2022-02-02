package com.hu.servlet;

import com.hu.entiry.Book;
import com.hu.service.BookService;
import com.hu.service.impl.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UpdateServlet", value = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {

    private final BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String price = request.getParameter("price");
        String press = request.getParameter("press");
        String isbn = request.getParameter("isbn");
        String intro = request.getParameter("intro");
        Book book = new Book(Integer.parseInt(id), name, author, Double.parseDouble(price), press, isbn, intro);
        System.out.println(book);
        bookService.updateBook(book);
        List<Book> bookList = bookService.getBookList(1, 10, null);
        request.getSession().setAttribute("bookList", bookList);
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
