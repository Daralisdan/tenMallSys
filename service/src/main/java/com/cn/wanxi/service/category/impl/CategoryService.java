package com.cn.wanxi.service.category.impl;

import com.cn.wanxi.entity.category.CategoryEntity;
import com.cn.wanxi.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    private com.cn.wanxi.dao.category.ICategoryDao ICategoryDao;


    @Override
    public int add(CategoryEntity categoryEntity) {
        return ICategoryDao.insert(categoryEntity);
    }

    @Override
    public int delete(CategoryEntity categoryEntity) {
        return ICategoryDao.delete(categoryEntity);
    }

    @Override
    public int update(CategoryEntity categoryEntity) {
        return ICategoryDao.update(categoryEntity);
    }

    @Override
    public List<Map<String, Object>> findOne(CategoryEntity categoryEntity) {
        return ICategoryDao.findOne(categoryEntity);
    }

    @Override
    public int count(CategoryEntity categoryEntity,int page,int size){

        return ICategoryDao.count(categoryEntity,page,size);
    }

    @Override
    public List<Map<String, Object>> findLimit(CategoryEntity categoryEntity, int page, int size) {
        return ICategoryDao.findLimit(categoryEntity,page,size);
    }

    @Override
    public List<Map<String, Object>> findAll(CategoryEntity categoryEntity) {
        return ICategoryDao.findAll(categoryEntity);
    }
}
