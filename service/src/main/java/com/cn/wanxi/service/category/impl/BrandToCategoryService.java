package com.cn.wanxi.service.category.impl;

import com.cn.wanxi.dao.category.IBrandToCategoryDao;
import com.cn.wanxi.entity.category.BrandToCategory;
import com.cn.wanxi.service.category.IBrandToCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author LeesonWong
 * @date 2019/11/19 17:09
 */
@Service
public class BrandToCategoryService implements IBrandToCategoryService {

    @Autowired
    private IBrandToCategoryDao iBrandToCategoryDao;

    @Override
    public int deleteById(int id) {
        return iBrandToCategoryDao.deleteById(id);
    }

    @Override
    public int add(BrandToCategory brandToCategoryEntity) {
        return iBrandToCategoryDao.insert(brandToCategoryEntity);
    }

    @Override
    public List<Map<String, Object>> findAll() {
        return iBrandToCategoryDao.queryAll();
    }

    @Override
    public BrandToCategory findById(int id) {
        return iBrandToCategoryDao.findByBrandId(id);
    }

    @Override
    public int update(BrandToCategory brandToCategoryEntity) {
        return iBrandToCategoryDao.update(brandToCategoryEntity);
    }


}
