package com.cn.wanxi.service.order;

import com.cn.wanxi.entity.order.OrderLogEntity;
import com.cn.wanxi.utils.utils.Msg;

public interface IOrderLogService {
    Msg add(OrderLogEntity orderLogEntity);

    Msg findAll();

    Msg findById(int id);

    Msg deleteById(int id);

    Msg update(OrderLogEntity orderLogEntity);
}
