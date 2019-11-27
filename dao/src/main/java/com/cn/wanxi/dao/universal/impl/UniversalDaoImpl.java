package com.cn.wanxi.dao.universal.impl;

import com.cn.wanxi.dao.universal.IUniversalDao;
import com.cn.wanxi.entity.Universal;
import com.cn.wanxi.utils.jdbcTemplateSentence.SQLSentence;
import com.cn.wanxi.utils.jdbcTemplateSentence.eunms.SQLTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author LeesonWong
 * @date 2019/11/25 22:24
 */
@Repository
public class UniversalDaoImpl implements IUniversalDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SQLSentence sqlSentence = SQLSentence.getInstance();

    @Override
    public int insert(Universal entity) {
        int counter = 0;
        Map.Entry<String, Object[]> entry = sqlSentence.getSentenceByEntity(entity, SQLTypeEnum.INSERT);
        if (null != entry) {
            counter = jdbcTemplate.update(entry.getKey(), entry.getValue());
        }
        return counter;
    }

    @Override
    public int delete(Universal entity) {
        int counter = 0;
        Map.Entry<String, Object[]> entry = sqlSentence.getSentenceByEntity(entity, SQLTypeEnum.DELETE);
        if (null != entry) {
            counter = jdbcTemplate.update(entry.getKey(), entry.getValue());
        }
        return counter;
    }

    @Override
    public int update(Universal entity) {
        int counter = 0;
        Map.Entry<String, Object[]> entry = sqlSentence.getSentenceByEntity(entity, SQLTypeEnum.UPDATE);
        if (null != entry) {
            counter = jdbcTemplate.update(entry.getKey(), entry.getValue());
        }
        return counter;
    }

    @Override
    public List<Map<String, Object>> findOne(Universal entity) {
        Map.Entry<String, Object[]> entry = sqlSentence.getSentenceByEntity(entity, SQLTypeEnum.SELECT);
        String sql = entry.getKey() + " limit 0,1";
        Object[] args = entry.getValue();
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, args);
//        if(list.size() > 1){
        // TODO: 2019/11/26 这里说明输入的条件不满足只找到一个的假设
//        }
        return list;
    }

    @Override
    public int count(Universal entity, int page, int size) {
        int result;
        Map.Entry<String, Object[]> entry = sqlSentence.getSentenceByEntity(entity, SQLTypeEnum.COUNT);
        String sql = entry.getKey();
        Object[] args = entry.getValue();
        /**
         * 这里如果有参数则返回条件查询的结果
         * 没有任何有效参数则表示查询所有
         */
        if (0 == args.length) {
            result = jdbcTemplate.queryForObject(sql, Integer.class);
        } else {
            result = jdbcTemplate.queryForObject(sql, args, Integer.class);
        }

        return result;
    }

    @Override
    public List<Map<String, Object>> findLimit(Universal entity, int page, int size) {
        Map.Entry<String, Object[]> entry = sqlSentence.getSentenceByEntity(entity, SQLTypeEnum.SELECT);
        String sql = entry.getKey() + " limit " + (page - 1) * size + "," + size;
        Object[] args = entry.getValue();
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, args);
        return list;
    }

    /**
     * 查询所有请传入没有任何值的空对象
     *
     * @param entity
     * @return
     */
    @Override
    public List<Map<String, Object>> findAll(Universal entity) {
        Map.Entry<String, Object[]> entry = sqlSentence.getSentenceByEntity(entity, SQLTypeEnum.SELECT);
        String sql = entry.getKey();
        Object[] args = entry.getValue();
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, args);
        return list;
    }

    /**
     * 不稳定的批量更新
     * 查询批量更新
     *
     * @param entity
     * @return
     */
//    @Override
    public List<Map<String, Object>> updateBatch(Universal entity) {
        // TODO: 2019/11/26
        Map.Entry<String, Object[]> entry = sqlSentence.getSentenceByEntity(entity, SQLTypeEnum.SELECT);
        String sql = entry.getKey();
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }
}
