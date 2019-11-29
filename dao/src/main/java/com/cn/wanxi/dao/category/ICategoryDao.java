package com.cn.wanxi.dao.category;

import com.cn.wanxi.entity.category.CategoryEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 【商品分类管理】：商品分类，主要用户对商品进行类别管理。一个分类对应一种模板类型的参数
 *
 * 数据表： wx_tab_category （商品分类表）
 *
 * 2019/11/18,Create by yaodan
 */
// TODO: 2019/11/25 返回信息应该有一个状态码来提示是否成功，且是否有成功但不唯一或其他异常
public interface ICategoryDao {

    List<CategoryEntity> findAll();

    List<CategoryEntity> findAllByParentId(int parentId);

    boolean insert(CategoryEntity categoryEntity);

    boolean update(CategoryEntity categoryEntity);

    boolean deleteById(int id);
}
