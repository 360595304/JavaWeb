package com.hu.dao;

import com.hu.entiry.Book;

import java.util.List;

public interface BookDao {

    List<Book> getBookList(int current, int size, String key);

    int getTotal(int current, int size, String key);

    void updateBook(Book book);

    void deleteBook(int id);

    void insertBook(Book book);

    Book getBookById(int id);
}
