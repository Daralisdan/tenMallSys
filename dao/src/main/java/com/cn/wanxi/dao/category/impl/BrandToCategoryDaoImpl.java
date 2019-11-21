package com.cn.wanxi.dao.category.impl;

import com.cn.wanxi.dao.category.IBrandToCategoryDao;
import com.cn.wanxi.entity.category.BrandToCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author LeesonWong
 * @date 2019/11/19 16:54
 */

@Repository
public class BrandToCategoryDaoImpl implements IBrandToCategoryDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(BrandToCategory entity) {
        String exeSQL = "INSERT INTO wx_tab_category_brand(brand_Id,Category_Id) VALUES(?,?)";
        Object args[] = {entity.getBrand_id(),entity.getCategory_id()};
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
    public BrandToCategory findByBrandId(int brand_id) {
        BrandToCategory brandToCategoryEntity = null;
        String exeSQL = "select * from wx_tab_category_brand where brand_id=?";
        List<BrandToCategory> brandToCategoryEntities = jdbcTemplate.query(exeSQL, new Object[]{brand_id}, new BeanPropertyRowMapper<BrandToCategory>(BrandToCategory.class));
        if (null != brandToCategoryEntities && brandToCategoryEntities.size() > 0) {
            brandToCategoryEntity = brandToCategoryEntities.get(0);
        }
        return brandToCategoryEntity;
    }

    @Override
    public int update(BrandToCategory entity) {
        String exeSQL = "update wx_tab_category_brand set brand_Id=?,Category_Id=?  WHERE brand_Id=?";
        Object args[] = {entity.getBrand_id(),entity.getCategory_id(),entity.getBrand_id()};
        int temp = jdbcTemplate.update(exeSQL, args);
        return temp;
    }

    @Override
    public int deleteById(int brand_id) {
        String exeSQL = "DELETE FROM wx_tab_category_brand WHERE brand_Id=?";
        return jdbcTemplate.update(exeSQL, brand_id);
    }
}
