package com.cn.wanxi.dao.product;

import com.cn.wanxi.entity.product.CategoryToBrand;

import java.util.List;
import java.util.Map;

/**
 * 【商品分类与品牌对应信息管理】
 * 描述：描述商品分类与品牌的对应关系
 *
 * 数据表： wx_tab_category_brand表--商品分类与品牌对应关系
 *
 * @author LessonWong
 * @date 2019/11/19 10:23
 */
public interface CategoryToBrandDao {
    /**
     * 【添加商品分类与品牌对应信息】
     *
     * @param entity
     * @return
     */
    int insert(CategoryToBrand entity);

    /**
     * 【查询所有商品分类与品牌对应信息】
     *
     * @return
     */
    List<Map<String, Object>> queryAll();

    /**
     * 【根据id查询商品分类与品牌对应信息】
     *
     * @param id
     * @return
     */
    CategoryToBrand findById(int id);

    /**
     * 【修改商品分类与品牌对应信息】
     *
     * @param entity
     * @return
     */
    int update(CategoryToBrand entity);

    /**
     * 【根据ID删除】
     *
     * @param id
     * @return
     */
    int deleteById(int id);
}
