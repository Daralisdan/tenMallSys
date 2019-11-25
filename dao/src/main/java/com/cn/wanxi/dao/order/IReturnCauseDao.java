package com.cn.wanxi.dao.order;


import com.cn.wanxi.entity.order.ReturnCauseEntity;

public interface IReturnCauseDao {
    int update(ReturnCauseEntity returnCauseEntity);


    /**
     * 【根据id查询品牌信息】
     *
     * @param id
     * @return
     */
    ReturnCauseEntity findById(int id);
}
