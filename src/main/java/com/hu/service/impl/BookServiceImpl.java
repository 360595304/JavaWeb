package com.hu.service.impl;

import com.hu.dao.BookDao;
import com.hu.dao.impl.BookDaoImpl;
import com.hu.entiry.Book;
import com.hu.service.BookService;

import java.util.List;
import java.util.UUID;

/**
 * @author suhu
 * @createDate 2021/12/2
 */
public class BookServiceImpl implements BookService {

    private final BookDao bookDao = new BookDaoImpl();


    @Override
    public List<Book> getBookList(int current, int size, String key) {
        return bookDao.getBookList(current, size, key);
    }

    @Override
    public int getTotal(int current, int size, String key) {
        return bookDao.getTotal(current, size, key);
    }

    @Override
    public void addBook(Book book) {
        bookDao.insertBook(book);
    }

    @Override
    public void removeBook(int id) {
        bookDao.deleteBook(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book getById(int id) {
        return bookDao.getBookById(id);
    }
}
