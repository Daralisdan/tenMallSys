package com.cn.wanxi.utils.simpSQL;

import com.cn.wanxi.utils.simpSQL.base.TimerMarker;
import com.cn.wanxi.utils.simpSQL.Helper.SQLHelper;
import com.cn.wanxi.utils.simpSQL.connection.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author LessonWong
 * @date 2019/11/16 14:32
 * 1、可以通过SQL语句得到PrepareStatement或ResultSet对象
 * 2、也可以直接通过该类，将对象作为参数实现增删查改
 */
public class SQL {
    private enum eSQLType {
        QUERY, UPDATE, INVALID
    }

    private enum eQueryPattern {
        SQL, ENTITY
    }

    private Connection connection;
    /*
    从sql语句到PreparedStatement对象的映射
    未完成的设计
     */
    private HashMap<String, PreparedStatement> sqlMap;
    /*
    从PreparedStatement语句到eSQLType类型的映射
     */
    private HashMap<PreparedStatement, eSQLType> registerMap;
    /*
    从PreparedStatement语句到ResultSet对象的映射
     */
    private HashMap<PreparedStatement, ResultSet> resultMap;

    private SQLHelper helper = new SQLHelper();

    public SQL() {
        connection = ConnectionPool.getConnection();
        sqlMap = new HashMap<>();
        registerMap = new HashMap<>();
        resultMap = new HashMap<>();
    }


/*
    通过SQL语句得到PrepareStatement或ResultSet对象
 */

    /**
     * 自定义sql获取Statement对象
     *
     * @param sql
     * @return
     */
    public PreparedStatement getStatement(String sql) {
        if (sqlMap.containsKey(sql)) return sqlMap.get(sql);
        return sql2Statement(sql);
    }

    /**
     * 仅能通过已注册的statement对象获取ResultSet对象
     * 对于注入的参数应有类型控制，待优化
     *
     * @param statement
     * @return
     */
    public ResultSet getResultSet(PreparedStatement statement) {
        ResultSet rs;
        if (registerMap.containsKey(statement)) {
            rs = getResultSetFromMappedStatement(statement);
        } else {
            rs = getResultSetFromUnMappedStatement(statement);
        }
        return rs;
    }

    private ResultSet getResultSetFromMappedStatement(PreparedStatement statement) {
        eSQLType type = registerMap.get(statement);
        /*
            已注册结果集映射的PreparedStatement直接返回
         */
        if (resultMap.containsKey(statement)) {
            return resultMap.get(statement);
        }
        /*
            未注册结果集映射的PreparedStatement，按照类型执行查询语句
            且仅有查询语句保存结果集
        */
        ResultSet rs = null;
        if (eSQLType.QUERY == type) {
            try {
                rs = statement.executeQuery();
                resultMap.put(statement, rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println(TimerMarker.getTimer() + "非查询语句的SQL无结果集");
        }

        return rs;
    }

    /**
     * 对于非注册的PreparedStatement对象
     * 未能找到有效方法获取SQL语句
     * 只能尝试注册到resultMap中
     *
     * @param statement
     * @return
     */
    private ResultSet getResultSetFromUnMappedStatement(PreparedStatement statement) {
        ResultSet rs = null;
        try {
            rs = statement.executeQuery();
            resultMap.put(statement, rs);
        } catch (SQLException e) {
            System.err.println(TimerMarker.getTimer() + "非查询语句的SQL无结果集");
        }
        return rs;
    }

    /**
     * 通过sql语句获取ResultSet对象
     *
     * @param sql
     * @return
     */
    public ResultSet getResultSet(String sql) {
        eSQLType type = getSQLType(sql);
        /*
            无效SQL（或暂不支持的SQL类型）
         */
        StringBuilder error = new StringBuilder();
        error.append("或暂不支持的SQL类型");

        ResultSet resultSet = null;
        switch (type) {
            case INVALID:
                System.err.println(TimerMarker.getTimer() + error.insert(0, "无效SQL"));
            case UPDATE:
                System.err.println(TimerMarker.getTimer() + error.insert(0, "修改类型的SQL不返回结果集"));
            case QUERY:
                /*
                    注册PreparedStatement与ResultSet
                 */
                PreparedStatement statement = getStatement(sql);
                resultSet = getResultSet(statement);
        }
        return resultSet;
    }

    /**
     * 通过查询语句直接得到对象
     *
     * @return
     */
    public <T> ArrayList<T> getEntities(String sql, T template) {
        Class classT = template.getClass();
        ResultSet rs = getResultSet(sql);
        if (null == rs) return null;

        ArrayList<T> result = new ArrayList<>();
        try {
            while (rs.next()) {
                result.add((T) helper.getObject(rs, classT.newInstance()));
            }
        } catch (SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        return result;
    }

    /*
        通过SQL获取PreparedStatement
        成功时将SQL与PreparedStatement、查询类型注册到
        sqlMap、registerMap中
     */
    private PreparedStatement sql2Statement(String sql) {
        eSQLType type = getSQLType(sql);
        if (eSQLType.INVALID == type) {
            System.err.println(TimerMarker.getTimer() + "无效或暂不支持的SQL语句");
        }

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            /*
            注册SQL映射与类型映射
             */
            sqlMap.put(sql, statement);
            registerMap.put(statement, type);
        } catch (SQLException e) {
            System.err.println(TimerMarker.getTimer() + "请检查SQL语句");
        }
        return statement;
    }

    /*
        通过已注册的PreparedStatement获取结果集
        成功时将PreparedStatement与ResultSet注册到
        resultMap中
     */
    private ResultSet statement2ResultSet(PreparedStatement statement) {
        if (!registerMap.containsKey(statement)) {
            System.err.println(TimerMarker.getTimer() + "未注册的PreparedStatement对象");
            return null;
        }

        eSQLType type = registerMap.get(statement);
        if (eSQLType.QUERY != type) {
            System.err.println(TimerMarker.getTimer() + "当前版本仅有QUERY类型可以得到结果集");
            return null;
        }

        ResultSet rs = null;
        try {
            rs = statement.executeQuery();
        } catch (SQLException e) {
            System.err.println(TimerMarker.getTimer() + "结果集获取失败,请检查查询条件与配置信息");
        }
        if (null != rs) {
            resultMap.put(statement, rs);
        }
        return rs;
    }

    /**
     * 通过对象添加数据
     */
    public <T> boolean add(T entity) {
        String sql = helper.addSentence(entity);
        return queryUpdate(sql);
    }

    public <T> boolean delete(T entity) {
        String sql = helper.deleteSentence(entity);
        return queryUpdate(sql);
    }

    public <T> boolean update(T entity) {
        String sql = helper.updateSentence(entity);
        return queryUpdate(sql);
    }

    /**
     * 只能通过id查询
     *
     * @param entities
     * @param <T>
     * @return
     */
    public <T> ArrayList<T> select(List<T> entities) {
        String sql = helper.selectSentence(entities);
        ArrayList<T> resultList;
        PreparedStatement statement;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resultList = getEntities(rs, entities);

        return resultList;
    }

    private <T> ArrayList<T> getEntities(ResultSet rs, List<T> entities) {
        ArrayList<T> resultList = new ArrayList<>();
        Object[] temp = new Object[entities.size()];
        try {
            for (int i = 0; i < entities.size() && rs.next(); ++i) {
                temp[i] = helper.getObject(rs, entities.get(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Object iter : temp) {
            resultList.add((T) iter);
        }

        return resultList;
    }


    /**
     * add、delete、update执行的executeUpdate语句合并
     *
     * @param sql
     * @return
     */
    private boolean queryUpdate(String sql) {
        try {
            return 0 != connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 归还Connection对象
     */
    public void close() {
        try {
            for (PreparedStatement iter : resultMap.keySet()) {
                resultMap.get(iter).close();
                iter.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConnectionPool.revertCon(connection);
    }

    private eSQLType getSQLType(String sql) {
        if (null == sql) {
            System.err.println(TimerMarker.getTimer() + "sql为空");
            return eSQLType.INVALID;
        }
        eSQLType type;
        String[] list = sql.split(" ");
        String typeStr;
        if (0 != list.length) {
            typeStr = sql.split(" ")[0];
        } else {
            typeStr = eSQLType.INVALID.toString();
        }

        switch (typeStr.toLowerCase()) {
            case "select":
                type = eSQLType.QUERY;
                break;
            case "insert":
            case "update":
            case "delete":
                type = eSQLType.UPDATE;
                break;
            default:
                type = eSQLType.INVALID;
        }
        return type;
    }
}

