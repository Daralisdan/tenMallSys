package com.cn.wanxi.dao.category;

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
// TODO: 2019/11/25 返回信息应该有一个状态码来提示是否成功，且是否有成功但不唯一或其他异常
public interface ICategoryDao {
    /**
     * 【添加商品分类信息】
     *
     * @param entity
     * @return
     */
    int insert(CategoryEntity entity);

    /**
     * 【根据条件删除】
     *
     * @param entity
     * @return
     */
    int delete(CategoryEntity entity);

    /**
     * 【修改商品分类信息】
     *
     * @param entity
     * @return
     */
    int update(CategoryEntity entity);

    /**
     * 【根据entity查询单条商品分类信息】
     *
     * @param entity
     * @return
     */
    List<Map<String, Object>> findOne(CategoryEntity entity);


    /**
     * 查询数量
     * @param entity
     * @param page
     * @param size
     * @return
     */
    int count(CategoryEntity entity,int page,int size);

    /**
     * 【根据条件查询商品分类信息】
     *
     * @param entity
     * @return
     */
    List<Map<String, Object>> findLimit(CategoryEntity entity,int page,int size);

    /**
     * 【根据条件查询所有商品分类信息】
     *
     * @return
     */
    List<Map<String, Object>> findAll(CategoryEntity entity);
}
