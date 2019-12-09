package com.cn.wanxi.mall.controller.order.DelayQueue;

import com.cn.wanxi.service.order.IOrderService;
import com.cn.wanxi.service.order.impl.OrderServiceImpl;

import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        IOrderService iOrderService = new OrderServiceImpl();
        DelayOrderWorker work1 = new DelayOrderWorker(iOrderService);// 任务1
//        DelayOrderWorker work2 = new DelayOrderWorker();// 任务2
//        DelayOrderWorker work3 = new DelayOrderWorker();// 任务3
        // 延迟队列管理类，将任务转化消息体并将消息体放入延迟对列中等待执行
        Thread thread =new Thread(work1);
        DelayOrderQueueManager manager = DelayOrderQueueManager.getInstance();
        manager.put( work1, 3000, TimeUnit.MILLISECONDS);
//        manager.put(work2, 6000, TimeUnit.MILLISECONDS);
//        manager.put(work3, 9000, TimeUnit.MILLISECONDS);
    }
}
