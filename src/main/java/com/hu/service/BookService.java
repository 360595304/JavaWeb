package com.hu.service;

import com.hu.entiry.Book;

import java.util.List;

/**
 * @author suhu
 * @createDate 2021/12/2
 */
public interface BookService {

    List<Book> getBookList(int current, int size, String key);

    int getTotal(int current, int size, String key);

    void addBook(Book book);

    void removeBook(int id);

    void updateBook(Book book);

    Book getById(int id);
}
