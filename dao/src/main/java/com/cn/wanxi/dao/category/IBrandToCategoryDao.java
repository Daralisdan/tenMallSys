package com.cn.wanxi.dao.category;

import com.cn.wanxi.entity.category.BrandToCategory;

import java.util.List;
import java.util.Map;

/**
 * @author LeesonWong
 * @date 2019/11/19 16:51
 */
public interface IBrandToCategoryDao {
    /**
     * 【添加商品分类信息】
     *
     * @param entity
     * @return
     */
    int insert(BrandToCategory entity);

    /**
     * 【查询所有商品分类信息】
     *
     * @return
     */
    List<Map<String, Object>> queryAll();

    /**
     * 【根据id查询商品分类信息】
     *
     * @param brand_id
     * @return
     */
    BrandToCategory findByBrandId(int brand_id);

    /**
     * 【修改商品分类信息】
     *
     * @param entity
     * @return
     */
    int update(BrandToCategory entity);

    /**
     * 【根据ID删除】
     *
     * @param brand_id
     * @return
     */
    int deleteById(int brand_id);

}
