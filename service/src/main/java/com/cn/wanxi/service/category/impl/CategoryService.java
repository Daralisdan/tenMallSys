package com.cn.wanxi.service.category.impl;

import com.cn.wanxi.entity.category.CategoryEntity;
import com.cn.wanxi.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 【商品分类管理】：商品分类，主要用户对商品进行类别管理。一个分类对应一种模板类型的参数
 *
 * 数据表： wx_tab_category （商品分类表）
 *
 * 2019/11/18,Create by yaodan
 */
@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private com.cn.wanxi.dao.category.ICategoryDao iCategoryDao;


    @Override
    public List<CategoryEntity> findAll() {
        return iCategoryDao.findAll();
    }

    @Override
    public List<CategoryEntity> findAllByParentId(int parentId) {
        return iCategoryDao.findAllByParentId(parentId);
    }

    @Override
    public boolean add(CategoryEntity categoryEntity) {
        return iCategoryDao.insert(categoryEntity);
    }

    @Override
    public boolean update(CategoryEntity categoryEntity) {
        return iCategoryDao.update(categoryEntity);
    }

    @Override
    public boolean delete(int id) {
        return iCategoryDao.deleteById(id);
    }
}
