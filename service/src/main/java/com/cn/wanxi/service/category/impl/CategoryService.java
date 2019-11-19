package com.cn.wanxi.service.category.impl;

import com.cn.wanxi.dao.category.ICategoryDao;
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
    private ICategoryDao ICategoryDao;

    @Override
    public int deleteById(int id) {
        return ICategoryDao.deleteById(id);
    }

    @Override
    public int add(CategoryEntity categoryEntity) {
        return ICategoryDao.insert(categoryEntity);
    }

    @Override
    public List<Map<String, Object>> findAll() {
        return ICategoryDao.queryAll();
    }

    @Override
    public CategoryEntity findById(int id) {
        return ICategoryDao.findById(id);
    }

    @Override
    public int update(CategoryEntity categoryEntity) {
        int result = 0;
        //先根据id查询，当前数据是否存在
        int id = categoryEntity.getId();
        CategoryEntity byId = ICategoryDao.findById(id);
        //如果查询当前数据存在，则修改
        if (byId != null) {
            int up = ICategoryDao.update(categoryEntity);
            //如果修改成功，返回true
            if (up > 0) {
                result = up;
            }
        }
        return result;
    }
}
