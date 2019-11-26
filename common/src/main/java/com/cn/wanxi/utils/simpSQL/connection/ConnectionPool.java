package com.cn.wanxi.utils.simpSQL.connection;

import com.cn.wanxi.utils.simpSQL.config.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class ConnectionPool {

    /**
     * The default initial capacity - MUST be a power of two.
     * 这个默认值是从HashMap中抄过来的
     */
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
    private static int realCount = 0;
    //驱动
    private static String DRIVER;
    //sql路径
    private static String URL;

    //sql 用户名
    private static String USER;
    //密码
    private static String PASSWORD;

    //Connection对象缓存
    private static LinkedList<Connection> cache;

    /*
        读取配置信息并初始化资源
     */
    static {
        DRIVER = Config.getDBConfig("DRIVER");
        URL = Config.getDBConfig("URL");
        USER = Config.getDBConfig("USER");
        PASSWORD = Config.getDBConfig("PASSWORD");

        cache = new LinkedList<>();
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            for (int i = 0; i < DEFAULT_INITIAL_CAPACITY; ++i) {
                cache.add(newConnection());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (0 != cache.size()) {
            System.out.println("连接资源初始化成功");
            realCount = DEFAULT_INITIAL_CAPACITY;
        }
    }

    private static Connection newConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static void cacheGrow() {
        try {
            for (int i = 0; i < realCount + 2; ++i) {
                cache.add(newConnection());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        realCount = realCount << 1 + 2;
    }

    /**
     * 获取连接对象
     */
    public static synchronized Connection getConnection() {
        synchronized (ConnectionPool.class) {
            if (0 == cache.size()) cacheGrow();
        }
        return cache.removeFirst();
    }

    public static synchronized void revertCon(Connection revert) {
        cache.add(revert);
    }
}
