package com.cn.wanxi.dao.universal;

import com.cn.wanxi.entity.Universal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author LeesonWong
 * @date 2019/11/25 22:22
 */
public interface IUniversalDao {
    /**
     * 【添加商品分类信息】
     *
     * @param entity
     * @return
     */
    int insert(Universal entity);

    /**
     * 【根据条件删除】
     *
     * @param entity
     * @return
     */
    int delete(Universal entity);

    /**
     * 【修改商品分类信息】
     *
     * @param entity
     * @return
     */
    int update(Universal entity);

    /**
     * 【根据entity查询单条商品分类信息】
     *
     * @param entity
     * @return
     */
    List<Map<String, Object>> findOne(Universal entity);

    /**
     * 条件计数
     * @param entity
     * @param page
     * @param size
     * @return
     */
    int count(Universal entity,int page,int size);

    /**
     * 【根据条件查询商品分类信息】
     *
     * @param entity
     * @return
     */
    List<Map<String, Object>> findLimit(Universal entity, int page, int size);

    /**
     * 【根据条件查询所有商品分类信息】
     *
     * @return
     */
    List<Map<String, Object>> findAll(Universal entity);
}
