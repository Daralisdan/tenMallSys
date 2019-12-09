package com.cn.wanxi.mall.controller.order.DelayQueue;

import com.cn.wanxi.service.order.IOrderService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * 具体执行相关业务的业务类
 */

public class DelayOrderWorker implements Runnable {
    private IOrderService iOrderService;
    public DelayOrderWorker(IOrderService iOrderService) {
        this.iOrderService = iOrderService;
    }
    @Override
    public void run() {
        iOrderService.update();
        System.out.println(Thread.currentThread().getName() + "订单id为:" + "已关闭");
    }
}
