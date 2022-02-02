package com.hu.dao.impl;

import com.hu.dao.BookDao;
import com.hu.entiry.Book;
import com.hu.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author suhu
 * @createDate 2021/11/21
 */
public class BookDaoImpl implements BookDao {

    @Override
    public List<Book> getBookList(int current, int size, String key) {
        List<Book> bookList = new ArrayList<>();
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select id, name, author, price, press, isbn, intro from book " +
                "where name like ? or author like ? or press like ? " +
                " limit ?,?";
        if (key == null) {
            key = "";
        }
        try {
            JDBCUtil.begin();
            ps = Objects.requireNonNull(connection).prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ps.setString(2, "%" + key + "%");
            ps.setString(3, "%" + key + "%");
            ps.setInt(4, (current - 1) * size);
            ps.setInt(5, size);
            rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getDouble("price"));
                book.setPress(rs.getString("press"));
                book.setIntro(rs.getString("intro"));
                book.setIsbn(rs.getString("isbn"));
                bookList.add(book);
            }
            JDBCUtil.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            JDBCUtil.rollback();
        } finally {
            JDBCUtil.closeAll(connection, ps, rs);
        }
        return bookList;
    }

    @Override
    public int getTotal(int current, int size, String key) {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select count(1) from book " +
                "where name like ? or author like ? or press like ?";
        if (key == null) {
            key = "";
        }
        int total = 0;
        try {
            JDBCUtil.begin();
            ps = Objects.requireNonNull(connection).prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ps.setString(2, "%" + key + "%");
            ps.setString(3, "%" + key + "%");
            rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }
            JDBCUtil.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            JDBCUtil.rollback();
        } finally {
            JDBCUtil.closeAll(connection, ps, rs);
        }
        return total;
    }

    @Override
    public void updateBook(Book book) {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        String sql = "update book set name=?, author=?, price=?, press=?, intro=?, isbn=? where id=?";
        try {
            JDBCUtil.begin();
            ps = Objects.requireNonNull(connection).prepareStatement(sql);
            ps.setString(1, book.getName());
            ps.setString(2, book.getAuthor());
            ps.setDouble(3, book.getPrice());
            ps.setString(4, book.getPress());
            ps.setString(5, book.getIntro());
            ps.setString(6, book.getIsbn());
            ps.setInt(7, book.getId());
            ps.executeUpdate();
            JDBCUtil.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            JDBCUtil.rollback();
        } finally {
            JDBCUtil.closeAll(connection, ps, null);
        }
    }

    @Override
    public void deleteBook(int id) {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        String sql = "delete from book where id=?";
        try {
            JDBCUtil.begin();
            ps = Objects.requireNonNull(connection).prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            JDBCUtil.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            JDBCUtil.rollback();
        } finally {
            JDBCUtil.closeAll(connection, ps, null);
        }
    }

    @Override
    public void insertBook(Book book) {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        String sql = "insert into book (name, author, price, press, isbn, intro) values (?,?,?,?,?,?)";
        try {
            JDBCUtil.begin();
            ps = Objects.requireNonNull(connection).prepareStatement(sql);
            ps.setString(1, book.getName());
            ps.setString(2, book.getAuthor());
            ps.setDouble(3, book.getPrice());
            ps.setString(4, book.getPress());
            ps.setString(5, book.getIsbn());
            ps.setString(6, book.getIntro());
            ps.executeUpdate();
            JDBCUtil.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            JDBCUtil.rollback();
        } finally {
            JDBCUtil.closeAll(connection, ps, null);
        }
    }

    @Override
    public Book getBookById(int id) {
        Book book = new Book();
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from book where id=?";
        try {
            JDBCUtil.begin();
            ps = Objects.requireNonNull(connection).prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                book.setId(id);
                book.setName(rs.getString(2));
                book.setAuthor(rs.getString(3));
                book.setPrice(rs.getDouble(4));
                book.setPress(rs.getString(5));
                book.setIsbn(rs.getString(6));
                book.setIntro(rs.getString(7));
            }
            JDBCUtil.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            JDBCUtil.rollback();
        } finally {
            JDBCUtil.closeAll(connection, ps, rs);
        }
        return book;
    }
}
