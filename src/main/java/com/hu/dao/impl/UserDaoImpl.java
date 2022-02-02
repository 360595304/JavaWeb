package com.hu.dao.impl;

import com.hu.dao.UserDao;
import com.hu.entiry.User;
import com.hu.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * @author suhu
 * @createDate 2021/11/21
 */
public class UserDaoImpl implements UserDao {
    @Override
    public boolean login(String username, String password) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from user where username=? and password=?";
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            ps = Objects.requireNonNull(connection).prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            set = ps.executeQuery();
            if (set.next()) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeAll(connection, ps, set);
        }
        return false;
    }

    @Override
    public User getByName(String username) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from user where username=?";
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            ps = Objects.requireNonNull(connection).prepareStatement(sql);
            ps.setString(1, username);
            set = ps.executeQuery();
            if (set.next()) {
                int id = set.getInt("id");
                String role = set.getString("role");
                return new User(id, username, role);
            } else
                return null;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeAll(connection, ps, set);
        }
        return null;
    }
}
