package com.cn.wanxi.utils.simpSQL.Helper;

import com.cn.wanxi.utils.simpSQL.config.Config;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 通过该类
 * 1、获取指定操作类型的SQL语句
 * 2、通过ResultSet结果集得到指定的实体对象
 */
public class SQLHelper {
    private enum eValueType {
        Integer, String, Date
    }

    /**
     * 我也没想好这个构造函数能干嘛
     */
    public SQLHelper() {

    }

    //按照增删改查的模式设计string语句
    public <T> String addSentence(T entity) {
        Field[] fields = entity.getClass().getDeclaredFields();
        StringBuilder sentence = new StringBuilder("insert into " +
                Config.getMappingConfig(entity.getClass().getSimpleName()) + " values(");

        Object[] values = new Object[fields.length];
        setValues(values, fields, entity);
        for (int i = 0; i < values.length; ++i) {
            sentence.append(values[i]).append(',');
        }
        if (0 != sentence.length()) {
            sentence.setCharAt(sentence.length() - 1, ')');
        }

        return sentence.toString();
    }

    public <T> String deleteSentence(T entity) {
        Field[] fields = entity.getClass().getDeclaredFields();
        Integer id = null;

        for (Field iter : fields) {
            if ("id".equals(iter.getName())) {
                try {
                    iter.setAccessible(true);
                    id = (Integer) iter.get(entity);
                    iter.setAccessible(false);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        if (null == id) {
            return null;
        } else {
            return "delete from " +
                    Config.getMappingConfig(entity.getClass().getSimpleName()) +
                    " where id = " + id;
        }
    }

    public <T> String updateSentence(T entity) {
        Field[] fields = entity.getClass().getDeclaredFields();
        Integer id = null;
        StringBuilder sentence = new StringBuilder("update " +
                Config.getMappingConfig(entity.getClass().getSimpleName()) + " set ");

        //获取值
        Object[] values = new Object[fields.length];
        setValues(values, fields, entity);
        for (int i = 0; i < fields.length; ++i) {
            String attribute = fields[i].getName();
            if (!"id".equals(attribute)) {
                sentence.append(attribute + " = " + values[i] + ",");
            } else {
                id = (Integer) values[i];
            }
        }
        sentence.setCharAt(sentence.length() - 1, ' ');
        sentence.append("where id = " + id);

        if (null == id) {
            return null;
        }
        return sentence.toString();
    }

    public <T> String selectSentence(List<T> entities) {
        if (0 == entities.size()) {
            return null;
        }
        Integer[] idList = new Integer[entities.size()];
        Field id = null;
        StringBuilder initialSentence = new StringBuilder("select * from " +
                Config.getMappingConfig(entities.get(0).getClass().getSimpleName()) + " where id in ");

        try {
            id = entities.get(0).getClass().getDeclaredField("id");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        try {
            id.setAccessible(true);
            for (int i = 0; i < entities.size(); ++i) {
                idList[i] = (Integer) id.get(entities.get(i));
            }
            id.setAccessible(false);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return selectSentence0(idList, initialSentence);
    }

    private String selectSentence0(Integer[] idList, StringBuilder initialSentence) {
        if (0 == idList.length) {
            return null;
        }
        StringBuilder maturedSentence = initialSentence;
        maturedSentence.append('(');
        for (Integer iter : idList) {
            maturedSentence.append(iter + ",");
        }
        maturedSentence.setCharAt(maturedSentence.length() - 1, ')');

        return maturedSentence.toString();
    }

    public <T> T getObject(ResultSet rs, T entity) {
        Field[] fields = entity.getClass().getDeclaredFields();
        injectValues(rs, entity, fields);
        return entity;
    }

    private <T> void setValues(Object[] values, Field[] fields, T entity) {
        if (null == fields) {
            return;
        }
        for (int i = 0; i < fields.length; ++i) {
            eValueType type = eValueType.valueOf(fields[i].getType().getSimpleName());
            fields[i].setAccessible(true);
            try {
                switch (type) {
                    case Integer:
                        values[i] = fields[i].get(entity);
                        break;
                    case String:
                        values[i] = "'" + fields[i].get(entity) + "'";
                        break;
                    case Date:
                        values[i] = UtilsHelper.formatDateTimer(fields[i].get(entity).toString());
                        break;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            fields[i].setAccessible(false);
        }
    }

    private <T> void injectValues(ResultSet rs, T entity, Field[] fields) {
        if (null != fields) {
            for (int i = 0; i < fields.length; ++i) {
                try {
                    fields[i].setAccessible(true);
                    switch (eValueType.valueOf(fields[i].getType().getSimpleName())) {
                        case Integer:
                            fields[i].set(entity, rs.getInt(i + 1));
                            break;
                        case String:
                            fields[i].set(entity, rs.getString(i + 1));
                            break;
                        case Date:
                            fields[i].set(entity, rs.getTimestamp(i + 1));
                            break;
                    }

                    fields[i].setAccessible(false);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
