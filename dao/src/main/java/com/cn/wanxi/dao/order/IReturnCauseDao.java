package com.cn.wanxi.dao.order;


import com.cn.wanxi.entity.order.ReturnCauseEntity;

import java.util.List;
import java.util.Map;

public interface IReturnCauseDao {
    int update(ReturnCauseEntity returnCauseEntity);


    /**
     * 【根据id查询品牌信息】
     *
     * @param id
     * @return
     */
    ReturnCauseEntity findById(int id);

    int insert(ReturnCauseEntity returnCauseEntity);

    List<Map<String, Object>> queryAll();

    int deleteById(int id);

}
