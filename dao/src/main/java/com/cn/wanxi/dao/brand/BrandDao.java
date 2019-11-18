package com.cn.wanxi.dao.brand;

import com.cn.wanxi.entity.brand.BrandEntity;

import java.util.List;
import java.util.Map;

/**
 * 2019/11/16,Create by yaodan
 */
public interface BrandDao {
    /**
     * 【添加品牌信息】
     *
     * @param brand
     * @return
     */
    int insert(BrandEntity brand);

    /**
     * 【查询所有品牌信息】
     *
     * @return
     */
    List<Map<String, Object>> queryAll();

    /**
     * 【根据id查询品牌信息】
     *
     * @param id
     * @return
     */
    BrandEntity findById(int id);

    /**
     * 【修改品牌信息】
     *
     * @param brandEntity
     * @return
     */
    int update(BrandEntity brandEntity);

    /**
     * 【根据ID删除】
     *
     * @param id
     * @return
     */
    int deleteById(int id);
}
