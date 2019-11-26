package com.cn.wanxi.service.order;

import com.cn.wanxi.entity.order.ReturnCauseEntity;

import java.util.List;
import java.util.Map;

public interface IReturnCauseService {
    int update(ReturnCauseEntity returnCauseEntity);
    ReturnCauseEntity findById(int id);

    int add(ReturnCauseEntity returnCauseEntity);

    List<Map<String, Object>> findAll();



    int deleteById(int id);


}
