package com.cn.wanxi.mall.controller.order;

import com.cn.wanxi.entity.order.OrderEntity;
import com.cn.wanxi.entity.order.OrderLogEntity;
import com.cn.wanxi.entity.utils.Msg;
import com.cn.wanxi.service.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static org.springframework.util.ObjectUtils.isEmpty;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService iOrderService;


    @PostMapping("/list")
    public Msg  list(int page, int size) {
        Msg msg = null;

        List<Map<String, Object>>   list = iOrderService.list(page, size);
        //判断集合是否有数据，如果没有数据返回失败
        if (list.isEmpty()) {
            msg = Msg.fail();
        } else {
            msg = Msg.success().messageData("order", list);
        }
        return msg;
    }

    @PostMapping("/batchlist")
    public List<Map<String, Object>>  list(String ids) {
        Msg msg = null;
        List<Map<String, Object>>  list = iOrderService.batchlist(ids);
        //判断集合是否有数据，如果没有数据返回失败
        if (list.isEmpty()) {
            msg = Msg.fail();
        } else {
            msg = Msg.success().messageData("order", list);
        }
        return list;
    }

    @PostMapping("/batchSendSubmit")
    public Msg batchSendSubmit(int orderId) {
        Msg m;
        int result = iOrderService.batchSendSubmit(orderId);
        if (!isEmpty(result)) {
            m = Msg.success().messageData("order", orderId);
        } else {
            m = Msg.fail();
        }
        return m;
    }
    @PostMapping("/findbyorderid")
    public Msg findByOrderId(int orderId) {
        Msg msg = null;
        OrderLogEntity byOrderId = iOrderService.findByOrderId(orderId);
        if (byOrderId != null) {
            msg = Msg.success().messageData("order", byOrderId);
        } else {
            msg = Msg.fail();
        }
        return msg;
    }


    @PostMapping("/findbyid")
    public Msg findById(int id) {
        Msg msg = null;
        OrderEntity byId = iOrderService.findById(id);
        if (byId != null) {
            msg = Msg.success().messageData("order", byId);
        } else {
            msg = Msg.fail();
        }
        return msg;
    }
}
