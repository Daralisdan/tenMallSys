package com.cn.wanxi.dao.category.impl;

import com.cn.wanxi.dao.category.ICategoryDao;
import com.cn.wanxi.entity.category.CategoryEntity;
import com.cn.wanxi.utils.jdbcTemplateSentence.SQLSentence;
import com.cn.wanxi.utils.jdbcTemplateSentence.eunms.SQLTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 【商品分类管理】：商品分类，主要用户对商品进行类别管理。一个分类对应一种模板类型的参数
 * <p>
 * 数据表： wx_tab_category （商品分类表）
 * <p>
 * 2019/11/18,Create by yaodan
 */
@Repository
public class CategoryDaoImpl implements ICategoryDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    private SQLSentence sqlSentence = SQLSentence.getInstance();

    /**
     * 添加实体
     * @param entity
     * @return
     */
    @Override
    public int insert(CategoryEntity entity) {
        int counter = 0;
        Map.Entry<String,Object[]> entry = sqlSentence.getSentenceByEntity(entity, SQLTypeEnum.INSERT);
        if(null != entry){
            counter = jdbcTemplate.update(entry.getKey(), entry.getValue());
        }
        return counter;
    }

    /**
     * 删除实体
     * @param entity
     * @return
     */
    @Override
    public int delete(CategoryEntity entity) {
        int counter = 0;
        Map.Entry<String,Object[]> entry = sqlSentence.getSentenceByEntity(entity, SQLTypeEnum.DELETE);
        if(null != entry){
            counter = jdbcTemplate.update(entry.getKey(), entry.getValue());
        }
        return counter;
    }

    /**
     * 更新实体
     * @param entity
     * @return
     */
    @Override
    public int update(CategoryEntity entity) {
        int counter = 0;
        Map.Entry<String,Object[]> entry = sqlSentence.getSentenceByEntity(entity, SQLTypeEnum.UPDATE);
        if(null != entry){
            counter = jdbcTemplate.update(entry.getKey(), entry.getValue());
        }
        return counter;
    }

    @Override
    public List<Map<String, Object>> findOne(CategoryEntity entity) {
        Map.Entry<String,Object[]> entry = sqlSentence.getSentenceByEntity(entity, SQLTypeEnum.SELECT);
        String sql = entry.getKey() + " limit 0,1";
        Object[] args = entry.getValue();
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql,args);
        return list;
    }

    @Override
    public int count(CategoryEntity entity,int page,int size){
        int result;
        Map.Entry<String,Object[]> entry = sqlSentence.getSentenceByEntity(entity, SQLTypeEnum.COUNT);
        String sql = entry.getKey();
        Object[] args = entry.getValue();
        /**
         * 这里如果有参数则返回条件查询的结果
         * 没有任何有效参数则表示查询所有
         */
        if(0 == args.length){
            result = jdbcTemplate.queryForObject(sql,Integer.class);
        } else {
            result = jdbcTemplate.queryForObject(sql,args,Integer.class);
        }

        return result;
    }

    @Override
    public List<Map<String, Object>> findLimit(CategoryEntity entity, int page, int size) {
        Map.Entry<String,Object[]> entry = sqlSentence.getSentenceByEntity(entity, SQLTypeEnum.SELECT);
        String sql = entry.getKey() + " limit " + (page - 1)*size + "," + size;
        Object[] args = entry.getValue();
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql,args);
        return list;
    }

    @Override
    public List<Map<String, Object>> findAll(CategoryEntity entity) {
        Map.Entry<String,Object[]> entry = sqlSentence.getSentenceByEntity(entity, SQLTypeEnum.SELECT);
        String sql = entry.getKey();
        Object[] args = entry.getValue();
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql,args);
        return list;
    }






}
