package com.cn.wanxi.utils.jdbcTemplateSentence;

import com.cn.wanxi.utils.jdbcTemplateSentence.base.FixedCapacityMap;
import com.cn.wanxi.utils.jdbcTemplateSentence.base.TimerMarker;
import com.cn.wanxi.utils.jdbcTemplateSentence.config.MappingConfig;
import com.cn.wanxi.utils.jdbcTemplateSentence.eunms.SQLTypeEnum;

import java.lang.reflect.Field;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * SQLHelper 不能直接应用于jdbcTemplate
 * 内部设置一个集合，缓存得到的SQL语句
 * 采用LRU策略，即最近被访问的元素在未来一段时间也很有可能被访问，在缓存长度有限的情况下淘汰最长时间没有被访问到的元素
 *
 * @author LeesonWong
 * @date 2019/11/23 9:37
 */
public class SQLSentence {
    private static final String EMPTY = "";
    private static SQLSentence sqlSentence = new SQLSentence();

    private FixedCapacityMap sqlMapper = new FixedCapacityMap();

    private MappingConfig mappingConfig = new MappingConfig();

    //私有构造，全局单例
    private SQLSentence() {
    }

    public static SQLSentence getInstance() {
        return sqlSentence;
    }

    /**
     * 从实体获取jdbcTemplate的SQL语句
     *
     * @param entity
     * @param <T>
     * @return
     */
    public <T> Map.Entry<String, Object[]> getSentenceByEntity(T entity, SQLTypeEnum type) {
        if(null == entity){
            System.err.println(TimerMarker.getTimer() + "传入对象为空！");
            return null;
        }
        Field[] fields = entity.getClass().getDeclaredFields();
        open(fields);

        /**
         * 拿到所有的有效值
         */
        Map.Entry<ArrayList<Field>, ArrayList<Object>> validsToValues = generateValidFields(entity, fields, type);
        ArrayList<Field> valids = validsToValues.getKey();
        if (0 == valids.size() && SQLTypeEnum.SELECT != type && SQLTypeEnum.COUNT != type) {
            System.err.println(TimerMarker.getTimer() + "输入对象没有任何有效值！");
            return null;
        }

        /**
         * 走到这里已经说明的输入的查询实体是有效的
         */
        String key = generateKey(entity, valids, type);

        /**
         * 如果SQL语句没有拼接成功则会返回空串且打印错误信息
         */
        String result = EMPTY;

        if (sqlMapper.containsKey(key)) {
            result = sqlMapper.get(key);
        } else {
            result = generateValue(entity, valids, type);
            sqlMapper.put(key, result);
        }


        close(fields);
        return new AbstractMap.SimpleEntry<>(result, validsToValues.getValue().toArray());
    }

    //将类的所有属性设为可获取
    private <T> void open(Field[] fields) {
        for (Field iter : fields) {
            iter.setAccessible(true);
        }
    }

    //将类的所有属性还原为不可获取
    private <T> void close(Field[] fields) {
        for (Field iter : fields) {
            iter.setAccessible(false);
        }
    }

    /**
     * 找到所有的有效属性与值
     *
     * @param entity
     * @param fields
     * @param <T>
     * @return
     */
    private <T> Map.Entry<ArrayList<Field>, ArrayList<Object>> generateValidFields(T entity, Field[] fields, SQLTypeEnum type) {
        ArrayList<Field> valids = new ArrayList<>();
        ArrayList<Object> validValues = new ArrayList<>();

        try {
            /**
             * 找到所有的有效值
             */
            for (Field iter : fields) {
                if (null != iter.get(entity)) {
                    valids.add(iter);
                }
            }
            if(SQLTypeEnum.UPDATE != type){
                /**
                 * 如果不是更新类型直接注入值
                 */
                for(Field iter : valids){
                    validValues.add(iter.get(entity));
                }
            } else{
                /**
                 * 如果是更新类型很难合并到其他sql语句
                 */
                Field idField = null;
                for(Field iter : valids){
                    if("id" == iter.getName()){
                        idField = iter;
                        break;
                    }
                }
                /**
                 * 如果没有找到有效id，也就是说没有更新条件
                 * 直接返回null
                 */
                if(null == idField){
                    return null;
                } else {
                    Object idValue = idField.get(entity);
                    valids.remove(idField);
                    for(Field iter : valids){
                        validValues.add(iter.get(entity));
                    }
                    validValues.add(idValue);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return new AbstractMap.SimpleEntry<>(valids, validValues);
    }

    /**
     * 这里必须要判定输入的对象是否包含有效值
     *
     * @param entity
     * @param <T>
     * @return
     */
    private <T> String generateKey(T entity, ArrayList<Field> valids, SQLTypeEnum type) {
        StringBuilder keyGenerator = new StringBuilder();
        keyGenerator.append(entity.getClass().getSimpleName() + "[");
        for (Field iter : valids) {
            keyGenerator.append(iter.getName() + ",");
        }
        keyGenerator.setCharAt(keyGenerator.length() - 1, ']');
        keyGenerator.append(type.name());
        return keyGenerator.toString();
    }

    private <T> String generateValue(T entity, ArrayList<Field> valids, SQLTypeEnum type) {
        String entityName = entity.getClass().getSimpleName();
        LinkedHashMap<String, String> attributeMap = mappingConfig.getAttributeMap(entityName);
        /*
          以上代码已通过junit单元测试，在配置文件没有出错的情况下可以拿到映射文件中的映射关系
         */

        /**
         * 将生产SQL语句的任务单独封装出一个类来处理
         */
        SentenceHelper helper = new SentenceHelper(entityName, valids, attributeMap, type);
        String sentence = helper.generateSentence();

        return sentence;
    }

}
