package com.cn.wanxi.service.order;

import com.cn.wanxi.entity.order.ReturnCauseEntity;
import com.cn.wanxi.utils.utils.Msg;

public interface IReturnCauseService {
    Msg update(ReturnCauseEntity returnCauseEntity);

    Msg findById(int id);

    Msg add(ReturnCauseEntity returnCauseEntity);

    Msg findAll();


    Msg deleteById(int id);


}
