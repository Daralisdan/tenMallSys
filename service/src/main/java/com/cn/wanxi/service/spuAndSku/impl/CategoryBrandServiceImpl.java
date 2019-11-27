package com.cn.wanxi.service.spuAndSku.impl;

import com.cn.wanxi.dao.spuAndSku.CategoryBrandDao;
import com.cn.wanxi.entity.spuAndSku.WxTabCategoryBrand;
import com.cn.wanxi.service.spuAndSku.CategoryBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CategoryBrandServiceImpl implements CategoryBrandService {

    @Autowired
    private CategoryBrandDao categoryBrandDao;
    @Override
    public int insert(WxTabCategoryBrand wxTabCategoryBrand) {
        return categoryBrandDao.insert(wxTabCategoryBrand);
    }

    @Override
    public List<Map<String, Object>> queryAll() {
        return categoryBrandDao.queryAll();
    }

    @Override
    public WxTabCategoryBrand findById(int brandid, int categoryid) {
        return categoryBrandDao.findById(brandid,categoryid);
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
    public int deleteById(int brandid, int categoryid) {
        return categoryBrandDao.deleteById(brandid, categoryid);
    }
}
