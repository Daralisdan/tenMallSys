package com.cn.wanxi.mall.controller.order;


import com.cn.wanxi.entity.order.OrderItemEntity;
import com.cn.wanxi.entity.utils.Msg;
import com.cn.wanxi.service.order.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

import static org.springframework.util.StringUtils.isEmpty;

@RestController
@RequestMapping("/orderItem")
public class OrderItemController {

    @Autowired
    private IOrderItemService iOrderItemService;

    /**
     * 添加订单详细
     * @param brandEntity
     * @return
     */
    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")

    public Msg add(@RequestBody OrderItemEntity brandEntity) {
        Msg m;
        int result = iOrderItemService.add(brandEntity);
        if (!isEmpty(result)) {
            m = Msg.success().messageData("orderItem", brandEntity);
        } else {
            m = Msg.fail();
        }
        return m;
    }

    /**
     * 查找所有的订单详细
     * @return
     */
    @PostMapping("/findAll")
    public Msg findAll() {
        Msg msg;
        List<Map<String, Object>> list = iOrderItemService.findAll();
        //判断集合是否有数据，如果没有数据返回失败
        if (list.isEmpty()) {
            msg = Msg.fail();
        } else {
            msg = Msg.success().messageData("orderItem", list);
        }
        return msg;
    }

    /**
     * 【根据订单详细id查询信息】
     * @param param
     * @param response
     * @return
     */
    @PostMapping(value = "/findById", produces = "application/json;charset=UTF-8")
    public Msg findById(@RequestBody Map<String ,Integer>param, HttpServletResponse response) {
        Msg msg = null;
        int id =param.get("id");
        OrderItemEntity byId = iOrderItemService.findById(id);
        if (byId != null) {
            msg = Msg.success().messageData("orderItem", byId);
        } else {
            msg = Msg.fail();
        }
        return msg;
    }


    /**
     * 【修改订单详细信息】
     *
     * @param orderItemEntity
     * @return
     */
    @PostMapping(value = "/update", produces = "application/json;charset=UTF-8")
    public Msg updateInfo(@RequestBody OrderItemEntity orderItemEntity) {
        Msg msg = null;

        int up = iOrderItemService.update(orderItemEntity);
        if (up > 0) {
            msg = Msg.success().messageData("orderItem", orderItemEntity);
        } else {
            msg = Msg.fail();
        }
        return msg;
    }

    /**
     * 【根据id删除】
     * @param param
     * @param response
     * @return
     */
    @PostMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public Msg deleteById(@RequestBody Map<String ,Integer>param, HttpServletResponse response) {
        Msg msg = null;
        int id =param.get("id");
        int i = iOrderItemService.deleteById(id);
        if (i > 0) {
            msg = Msg.success();
        } else {
            msg = Msg.fail();
        }
        return msg;
    }

}