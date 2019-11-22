package com.cn.wanxi.utils;

import java.sql.*;

/**
 * java应用程序与数据库的连接步骤
 * 1.连接数据库
 * 2.输出数据
 * 3.输入数据
 * 4.关闭接口
 * 5.关闭数据库
 */
public class JDBC {

    //sql路径
//    private static final String URL = "jdbc:mysql://192.168.0.194:3306/tenmall?serverTimezone=PRC";
    //sql路径 本地测试
    private static final String URL = "jdbc:mysql://localhost:3306/tenmall?serverTimezone=PRC";
    //驱动
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
//    //sql 用户名
//    private static final String USER = "yd";
//    //密码
//    private static final String PASSWORD = "sss123456";

    //sql 用户名 本地测试
    private static final String USER = "root";
    //密码 本地测试
    private static final String PASSWORD = "zsl970211";

    //连接数据库的一个对象
    private static Connection conn = null;
    //准备输出数据的接口
    private static PreparedStatement pstmt = null;
    //查询时，数据存入在集合中，真正执行输出,因为查询时返回的数据是结果集
    private static ResultSet rs = null;

    /**
     * 连接数据库
     */
    //1.建立连接
    private static void getConn() {
        try {
            //1.1装在驱动
            Class.forName(DRIVER);
            //1.2 连接数据库，获得与数据库的连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //2.输出数据

    /**
     * 对数据库进行增删改操作，返回操作的条数
     */

    public static int update(String sql) {
        //1.连接数据库
        getConn();

        //2.输出数据
        //初始化返回的条数
        int i = 0;

        try {
            //2.1准备输出的数据
            pstmt = conn.prepareStatement(sql);
            //2.2真正执行输出
            i = pstmt.executeUpdate();
//            conn.commit();
            //打印
            System.out.println("修改的条数：update:" + i);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //3.关闭连接
            //3.1关闭接口的连接
            close();
        }
        return i;
    }


//对数据库进行查询操作

    /**
     * 对数据库进行查询操作，取得结果集，返回结果集
     *
     * @return
     */
    public static ResultSet query(String sql) {
        //1.连接数据库
        getConn();
        try {
            //2.1准备输出的数据
            pstmt = conn.prepareStatement(sql);
            //2.2真正执行输出
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * 3关闭连接
     */
    public static void close() {
        //3.1关闭集合存储数据的连接
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //3.2关闭接口的连接
        try {
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //3.3关闭数据库的连接
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
