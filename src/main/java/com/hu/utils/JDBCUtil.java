package com.hu.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author suhu
 * @createDate 2021/11/21
 */
public class JDBCUtil {
    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;

    // 静态代码块，类加载时执行
    static {
        try {
            Properties properties = new Properties();
            InputStream in = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
            try {
                properties.load(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String DRIVER = properties.getProperty("driver");
            URL = properties.getProperty("url");
            USERNAME = properties.getProperty("username");
            PASSWORD = properties.getProperty("password");
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static ThreadLocal<Connection> local = new ThreadLocal<>();

    public static Connection getConnection() {
        try {
            //从ThreadLocal中取对象
            Connection connection = local.get();
            //判断ThreadLocal中是否为空
            if (connection == null) {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                local.set(connection);
                return connection;
            } else
                return local.get();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    // 关闭资源
    public static void closeAll(Connection conn, Statement stat, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
                local.remove();
            }
            if (stat != null) stat.close();
            if (rs != null) rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //开启事务
    public static void begin() {
        Connection connection;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // 提交事务
    public static void commit() {
        Connection connection = null;
        try {
            connection = getConnection();
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll(connection, null, null);
        }
    }

    // 回滚
    public static void rollback() {
        Connection connection = null;
        try {
            connection = getConnection();
            connection.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll(connection, null, null);
        }
    }
}
