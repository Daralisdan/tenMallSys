package com.cn.wanxi.service.category;

import com.cn.wanxi.entity.category.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 【商品分类管理】：商品分类，主要用户对商品进行类别管理。一个分类对应一种模板类型的参数
 *
 * 数据表： wx_tab_category （商品分类表）
 *
 * 2019/11/18,Create by yaodan
 */
public interface ICategoryService {

    int add(CategoryEntity categoryEntity);

    int delete(CategoryEntity categoryEntity);

    int update(CategoryEntity categoryEntity);

    List<Map<String, Object>> findOne(CategoryEntity categoryEntity);

    int count(CategoryEntity categoryEntity,int page,int size);

    List<Map<String, Object>> findLimit(CategoryEntity categoryEntity,int page,int size);

    List<Map<String, Object>> findAll(CategoryEntity categoryEntity);
}
