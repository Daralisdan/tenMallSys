package com.cn.wanxi.service.order;

import com.cn.wanxi.entity.order.ReturnCauseEntity;

public interface IReturnCauseService {
    int update(ReturnCauseEntity returnCauseEntity);
    ReturnCauseEntity findById(int id);
}
