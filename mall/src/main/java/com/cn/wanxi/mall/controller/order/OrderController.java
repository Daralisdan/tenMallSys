package com.cn.wanxi.mall.controller.order;


import com.cn.wanxi.entity.order.OrderEntity;
import com.cn.wanxi.entity.order.OrderItemEntity;
import com.cn.wanxi.entity.order.PageMap;
import com.cn.wanxi.mall.controller.order.DelayQueue.DelayOrderQueueManager;
import com.cn.wanxi.mall.controller.order.DelayQueue.DelayOrderWorker;
import com.cn.wanxi.service.order.IOrderItemService;
import com.cn.wanxi.service.order.IOrderService;
import com.cn.wanxi.utils.utils.Msg;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService iOrderService;
    @Autowired
    private IOrderItemService iOrderItemService;


    /**
     * 添加订单详细
     *
     * @param orderEntity
     * @return
     */
    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public Msg add(@RequestBody OrderEntity orderEntity) {

        return iOrderService.add(orderEntity);
    }

    /**
     * 条件分页
     *
     * @param param
     * @return
     */
    @PostMapping(value = "/findPage", produces = "application/json;charset=UTF-8")
    public Map<String, Object> list(@RequestBody Map<String, Object> param) {
        return iOrderService.list(param);
    }

    /**
     * 批量发货查询
     *
     * @return
     */
    @PostMapping(value = "/batchFindAll", produces = "application/json;charset=UTF-8")
    public Msg list2() {
        return iOrderService.batchlist();
    }

    /**
     * 批量发货查询
     *
     * @return
     */
    @PostMapping(value = "/item", produces = "application/json;charset=UTF-8")
    public Msg list3(@RequestBody Map<String, Integer> param) {
        int id = param.get("id");
        return iOrderService.item(id);
    }

    /**
     * 批量发货提交
     * @param param
     * @return
     */

    @PostMapping(value = "/batchSendSubmit", produces = "application/json;charset=UTF-8")
    public Msg batchSendSubmit(@RequestBody Map<String, Object> param) {
        return iOrderService.batchSendSubmit(param);
    }


    /**
     * 根据订单主表id查询信息
     *
     * @param param
     * @return
     */
    @PostMapping(value = "/findbyid", produces = "application/json;charset=UTF-8")
    public Msg findById(@RequestBody Map<String, Integer> param) {
        int id = param.get("id");
        return iOrderService.findById(id);
    }

    /**
     * 【根据id删除】
     *
     * @param orderEntity
     * @return
     */
    @PostMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public Msg deleteById(@RequestBody OrderEntity orderEntity) {
        int id = orderEntity.getId();
        return iOrderService.deleteById(id);
    }


    /**
     * 查找所有的订单详细
     *
     * @return
     */
    @PostMapping("/findAll")
    public Msg findAll() {
        return iOrderService.findAll();
    }

    /**
     * 查找所有的订单详细
     *
     * @return
     */
    @PostMapping("/update")
    public Msg update() {
        DelayOrderQueueManager.getInstance().put(new DelayOrderWorker(iOrderService), 3000, TimeUnit.MILLISECONDS);
        return null;
    }

}