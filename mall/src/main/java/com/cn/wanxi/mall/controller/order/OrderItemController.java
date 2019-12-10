package com.cn.wanxi.mall.controller.order;


import com.cn.wanxi.entity.order.OrderItemEntity;
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.service.order.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/orderItem")
public class OrderItemController {

    @Autowired
    private IOrderItemService iOrderItemService;


    /**
     * 查找所有的订单详细
     *
     * @return
     */
    @PostMapping("/findAll")
    public Msg findAll() {
        return iOrderItemService.findAll();
    }

    /**
     * 【根据订单详细id查询信息】
     *
     * @param param
     * @return
     */
    @PostMapping(value = "/findById", produces = "application/json;charset=UTF-8")
    public Msg findById(@RequestBody Map<String, Integer> param) {
        int id = param.get("id");
        return iOrderItemService.findById(id);
    }


    /**
     * 【修改订单详细信息】
     *
     * @param orderItemEntity
     * @return
     */
    @PostMapping(value = "/update", produces = "application/json;charset=UTF-8")
    public Msg updateInfo(@RequestBody OrderItemEntity orderItemEntity) {
        return iOrderItemService.update(orderItemEntity);
    }

    /**
     * 【根据id删除】
     *
     * @param orderItemEntity
     * @return
     */
    @PostMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public Msg deleteById(@RequestBody OrderItemEntity orderItemEntity) {
        int id = orderItemEntity.getId();
        return iOrderItemService.deleteById(id);
    }

}
