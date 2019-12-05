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
    BrandEntity findById(Integer id);

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
    int deleteById(Integer id);

    /**
     * 【条件查询】
     *
     * @param brandEntity
     * @return
     */
    List<Map<String, Object>> findList(BrandEntity brandEntity);

    /**
     * 【分页查询】
     *
     * @param page
     * @param size
     * @return
     */

    List<Map<String, Object>> findAllbyPage(int page, int size);

    /**
     * 【统计查询出所有的记录】
     *
     * @return
     */
    int countAll();

    /**
     * 【分页+条件】
     *
     * @param brandEntity
     * @param page
     * @param size
     * @return
     */
    List<Map<String, Object>> findListAndPage(BrandEntity brandEntity, int page, int size);

    List<Map<String, Object>> queryNameId();
}
