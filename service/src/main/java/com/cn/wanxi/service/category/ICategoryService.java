package com.cn.wanxi.service.category;

import com.cn.wanxi.entity.category.CategoryEntity;
import com.cn.wanxi.entity.category.CategoryTreeNodeEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 【商品分类管理】：商品分类，主要用户对商品进行类别管理。一个分类对应一种模板类型的参数
 *
 * 数据表： wx_tab_category （商品分类表）
 *
 * 2019/11/18,Create by yaodan
 */
public interface ICategoryService {

    List<CategoryEntity> findAll();

    List<CategoryEntity> findAllByParentId(int parentId);

    boolean add(CategoryEntity categoryEntity);

    boolean update(CategoryEntity categoryEntity);

    boolean delete(int id);

    ArrayList<CategoryTreeNodeEntity> getCategoryTree();
}
