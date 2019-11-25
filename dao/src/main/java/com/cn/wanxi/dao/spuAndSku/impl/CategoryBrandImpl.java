package com.cn.wanxi.dao.spuAndSku.impl;

import com.cn.wanxi.dao.spuAndSku.CategoryBrandDao;
import com.cn.wanxi.entity.spuAndSku.WxTabCategoryBrand;
import com.cn.wanxi.entity.spuAndSku.WxTabSpu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public class CategoryBrandImpl implements CategoryBrandDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(WxTabCategoryBrand wxTabCategoryBrand) {
        String exeSQL = "INSERT INTO wx_tab_category_brand(brand_Id,Category_Id,) VALUES(?,?)";
        Object args[] = {wxTabCategoryBrand.getBrandId(),wxTabCategoryBrand.getCategoryId()};
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
    public WxTabCategoryBrand findById(int brandid ,int categoryid ) {

        WxTabCategoryBrand wxTabCategoryBrand = null;
        String exeSQL = "select * from wx_tab_category_brand where brand_Id=? as brandId and Category_Id=? ";
        List<WxTabCategoryBrand> wxTabSpuu = jdbcTemplate.query(exeSQL, new Object[]{brandid,categoryid}, new BeanPropertyRowMapper<WxTabCategoryBrand>(WxTabCategoryBrand.class));
        if (null != wxTabSpuu && wxTabSpuu.size() > 0) {
            wxTabCategoryBrand = wxTabSpuu.get(0);
        }
        return wxTabCategoryBrand;
    }

    @Override
    public WxTabCategoryBrand findByName(String name) {
        return null;
    }

    @Override
    public int update(WxTabCategoryBrand wxTabCategoryBrand) {
        return 0;
    }

    @Override
    public int deleteById(int brandid ,int categoryid ) {
        String exeSQL = "DELETE FROM wx_tab_category_brand WHERE brand_Id=? and Category_Id=?";
        return jdbcTemplate.update(exeSQL, brandid,categoryid);
    }
}
