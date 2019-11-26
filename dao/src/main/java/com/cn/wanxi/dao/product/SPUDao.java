package com.cn.wanxi.dao.product;

import com.cn.wanxi.entity.product.SPUEntity;

import java.util.List;
import java.util.Map;

/**
 * 【标准产品单位信息管理】
 * 描述：SPU ：Standard Product Unit （标准产品单位）
 *
 * 数据表： wx_tab_spu 表--标准产品单元
 *
 * 2019/11/18,Create by yaodan
 */
public interface SPUDao {
    /**
     * 【添加标准产品单位信息】
     *
     * @param entity
     * @return
     */
    int insert(SPUEntity entity);

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
    SPUEntity findById(int id);

    /**
     * 【修改标准产品单位信息】
     *
     * @param entity
     * @return
     */
    int update(SPUEntity entity);

    /**
     * 【根据ID删除】
     *
     * @param id
     * @return
     */
    int deleteById(int id);
}
