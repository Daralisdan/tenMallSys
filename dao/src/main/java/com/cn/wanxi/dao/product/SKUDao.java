package com.cn.wanxi.dao.product;

import com.cn.wanxi.entity.product.SKUEntity;

import java.util.List;
import java.util.Map;

/**
 * 【库存量单位信息管理】
 * 描述：SKU：stock keeping unit(库存量单位)
 *
 * 数据表： wx_tab_sku 表--库存量单元
 *
 * @author LessonWong
 * @date 2019/11/19 9:55
 */
public interface SKUDao {
    /**
     * 【添加标准产品单位信息】
     *
     * @param entity
     * @return
     */
    int insert(SKUEntity entity);

    /**
     * 【查询所有标准产品单位信息】
     *
     * @return
     */
    List<Map<String, Object>> queryAll();

    /**
     * 【根据id查询标准产品单位信息】
     *
     * @param id
     * @return
     */
    SKUEntity findById(int id);

    /**
     * 【修改标准产品单位信息】
     *
     * @param entity
     * @return
     */
    int update(SKUEntity entity);

    /**
     * 【根据ID删除】
     *
     * @param id
     * @return
     */
    int deleteById(int id);
}
