package com.cn.wanxi.dao.product.impl;

import com.cn.wanxi.dao.product.CategoryToBrandDao;
import com.cn.wanxi.entity.product.CategoryToBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 【商品分类与品牌对应信息管理】
 * 描述：描述商品分类与品牌的对应关系
 *
 * 数据表： wx_tab_category_brand表--商品分类与品牌对应关系
 *
 * @author LessonWong
 * @date 2019/11/19 10:24
 */
@Repository
public class CategoryToBrandDaoImpl implements CategoryToBrandDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(CategoryToBrand entity) {
        String exeSQL = "INSERT INTO wx_tab_category_brand(Category_Id,brand_Id) VALUES(?,?)";
        Object args[] = {entity.getCategory_id(),entity.getBrand_id()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    @Override
    public List<Map<String, Object>> queryAll() {
        String exeSQL = "select * from wx_tab_category_brand";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(exeSQL);
        return list;
    }

    @Override
    public CategoryToBrand findById(int id) {
        CategoryToBrand categoryToBrandEntity = null;
        String exeSQL = "select * from wx_tab_category_brand where id=?";
        List<CategoryToBrand> categoryToBrandEntities = jdbcTemplate.query(exeSQL, new Object[]{id}, new BeanPropertyRowMapper<CategoryToBrand>(CategoryToBrand.class));
        if (null != categoryToBrandEntities && categoryToBrandEntities.size() > 0) {
            categoryToBrandEntity = categoryToBrandEntities.get(0);
        }
        return categoryToBrandEntity;
    }

    @Override
    public int update(CategoryToBrand entity) {
        String exeSQL = "update wx_tab_category_brand set Category_Id=?,brand_Id=? WHERE brand_Id=?";
        Object args[] = {entity.getCategory_id(),entity.getBrand_id(),entity.getBrand_id()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    @Override
    public int deleteById(int id) {
        String exeSQL = "DELETE FROM wx_tab_category_brand WHERE id=?";
        return jdbcTemplate.update(exeSQL, id);
    }
}
