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
public interface ICategoryDao {
    /**
     * 【添加商品分类信息】
     *
     * @param entity
     * @return
     */
    int insert(CategoryEntity entity);

    /**
     * 【查询所有商品分类信息】
     *
     * @return
     */
    List<Map<String, Object>> queryAll();

    /**
     * 【根据id查询商品分类信息】
     *
     * @param id
     * @return
     */
    CategoryEntity findById(int id);

    /**
     * 【根据parent_id查询商品分类信息】
     *
     * @param parent_id
     * @return
     */
    List<Map<String, Object>> findByParentId(int parent_id);

    /**
     * 【修改商品分类信息】
     *
     * @param entity
     * @return
     */
    int update(CategoryEntity entity);

    /**
     * 【根据ID删除】
     *
     * @param id
     * @return
     */
    int deleteById(int id);
}
