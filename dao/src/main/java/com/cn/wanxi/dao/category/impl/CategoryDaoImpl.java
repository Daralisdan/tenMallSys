package com.cn.wanxi.dao.category.impl;

import com.cn.wanxi.dao.category.ICategoryDao;
import com.cn.wanxi.entity.category.CategoryEntity;
import com.cn.wanxi.entity.category.CategoryTreeNodeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

    private static final String attrMapper = "id as id,name as name,goods_num as goodsNum,is_show as isShow," +
            "is_menu as isMenu,seq as seq,parent_id as parentId,template_id as templateId";

    @Override
    public List<CategoryEntity> findAll() {
        String exeSQL = "select " + attrMapper + " from wx_tab_category";
        List<CategoryEntity> userEntities = jdbcTemplate.query(exeSQL,new BeanPropertyRowMapper<>(CategoryEntity.class));
        return userEntities;
    }

    @Override
    public List<CategoryEntity> findAllByParentId(int parentId) {
        String exeSQL = "select " + attrMapper + " from wx_tab_category where parent_id = ?";
        Object[] args = {parentId};
        List<CategoryEntity> userEntities = jdbcTemplate.query(exeSQL,args,new BeanPropertyRowMapper<>(CategoryEntity.class));
        return userEntities;
    }

    @Override
    public boolean insert(CategoryEntity categoryEntity) {
        String exeSQL = "INSERT INTO wx_tab_category(name,goods_num,is_show,is_menu,seq,parent_id,template_id) VALUES(?,?,?,?,?,?,?)";
        Object[] args = {categoryEntity.getName(),categoryEntity.getGoodsNum(),categoryEntity.getIsShow(),categoryEntity.getIsMenu(),
                categoryEntity.getSeq(),categoryEntity.getParentId(),categoryEntity.getTemplateId()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return 0 < temp;
    }

    @Override
    public boolean update(CategoryEntity categoryEntity) {
        String exeSQL = "update wx_tab_category set name = ?,goods_num = ?,is_show = ?,is_menu = ?," +
                "seq = ?,parent_id = ?,template_id = ? where id = ?";
        Object[] args = {categoryEntity.getName(),categoryEntity.getGoodsNum(),categoryEntity.getIsShow(),categoryEntity.getIsMenu(),
                categoryEntity.getSeq(),categoryEntity.getParentId(),categoryEntity.getTemplateId(),categoryEntity.getId()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return 0 < temp;
    }

    @Override
    public boolean deleteById(int id) {
        String exeSQL = "delete from wx_tab_category where id = ?";
        Object[] args = {id};
        int temp = jdbcTemplate.update(exeSQL, args);
        return 0 < temp;
    }

    @Override
    public List<CategoryTreeNodeEntity> findNodeAll() {
        String exeSQL = "select " + attrMapper + " from wx_tab_category";
        List<CategoryTreeNodeEntity> userEntities = jdbcTemplate.query(exeSQL,new BeanPropertyRowMapper<>(CategoryTreeNodeEntity.class));
        return userEntities;
    }
}
