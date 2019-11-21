package com.cn.wanxi.dao.category.impl;

import com.cn.wanxi.dao.category.ICategoryDao;
import com.cn.wanxi.entity.category.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 【商品分类管理】：商品分类，主要用户对商品进行类别管理。一个分类对应一种模板类型的参数
 *
 * 数据表： wx_tab_category （商品分类表）
 *
 * 2019/11/18,Create by yaodan
 */
@Repository
public class CategoryDaoImpl implements ICategoryDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(CategoryEntity entity) {
        String exeSQL = "INSERT INTO wx_tab_category(name,goods_num,is_show,is_menu,seq,parent_id,template_id) VALUES(?,?,?,?,?,?,?)";
        Object args[] = {entity.getName(),entity.getGoods_num(),entity.getIs_show(),entity.getIs_menu(),entity.getSeq(),entity.getParent_id(),entity.getTemplate_id()};
        int counter = jdbcTemplate.update(exeSQL, args);
        return counter;
    }

    @Override
    public List<Map<String, Object>> queryAll() {
        String exeSQL = "select * from wx_tab_category";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(exeSQL);
        return list;
    }

    @Override
    public CategoryEntity findById(int id) {
        CategoryEntity categoryEntity = null;
        String exeSQL = "select * from wx_tab_category where id=?";
        List<CategoryEntity> categoryEntities = jdbcTemplate.query(exeSQL, new Object[]{id}, new BeanPropertyRowMapper<CategoryEntity>(CategoryEntity.class));
        if (null != categoryEntities && categoryEntities.size() > 0) {
            categoryEntity = categoryEntities.get(0);
        }
        return categoryEntity;
    }

    public List<Map<String, Object>> findByParentId(int parent_id){
        String exeSQL = "select * from wx_tab_category where parent_id = ?";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(exeSQL,parent_id);
        return list;
    }

    @Override
    public int update(CategoryEntity entity) {
        String exeSQL = "update wx_tab_category set name=?,goods_num=?,is_show=?,is_menu=?,seq=?,parent_id=?,template_id=?  WHERE id=?";
        Object args[] = {entity.getName(),entity.getGoods_num(),entity.getIs_show(),entity.getIs_menu(),entity.getSeq(),entity.getParent_id(),entity.getTemplate_id(),entity.getId()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    @Override
    public int deleteById(int id) {
        String exeSQL = "DELETE FROM wx_tab_category WHERE id=?";
        return jdbcTemplate.update(exeSQL, id);
    }
}
