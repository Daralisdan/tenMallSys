package com.cn.wanxi.mall.controller.order;

import com.cn.wanxi.entity.order.OrderEntity;
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.service.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

import static org.springframework.util.ObjectUtils.isEmpty;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService iOrderService;


    /**
     * 添加订单详细
     *
     * @param orderEntity
     * @return
     */
    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public Msg add(@RequestBody OrderEntity orderEntity) {
        Msg m;
        int result = iOrderService.add(orderEntity);
        if (!isEmpty(result)) {
            m = Msg.success().messageData("orderItem", orderEntity);
        } else {
            m = Msg.fail();
        }
        return m;
    }

    @PostMapping(value = "/findPage", produces = "application/json;charset=UTF-8")
    public Msg list(@RequestBody Map<String, Integer> param, HttpServletResponse response) {
        Msg msg = null;
        int page = param.get("page");
        int size = param.get("size");

        Map<String, Object> list = iOrderService.list(page, size);
        //判断集合是否有数据，如果没有数据返回失败
        if (list.isEmpty()) {
            msg = Msg.fail();
        } else {
            msg = Msg.success().messageData("order", list);
        }
        return msg;
    }

    @PostMapping(value = "/batchFindAll", produces = "application/json;charset=UTF-8")
    public Map<String, Object> list2(@RequestBody Map<String, String> param, HttpServletResponse response) {
        Msg msg = null;
        String ids=param.get("ids");
        Map<String, Object> list = iOrderService.batchlist(ids);
        //判断集合是否有数据，如果没有数据返回失败
        if (list.isEmpty()) {
            msg = Msg.fail();
        } else {
            msg = Msg.success().messageData("order", list);
        }
        return list;
    }

    @PostMapping(value = "/batchSendSubmit", produces = "application/json;charset=UTF-8")
    public Msg batchSendSubmit(@RequestBody Map<String, Integer> param, HttpServletResponse response) {
        Msg m;
        int orderId = param.get("orderId");
        int result = iOrderService.batchSendSubmit(orderId);
        if (!isEmpty(result)) {
            m = Msg.success().messageData("order", orderId);
        } else {
            m = Msg.fail();
        }
        return m;
    }
//    @PostMapping("/findbyorderid")
//    public Msg findByOrderId(int orderId) {
//        Msg msg = null;
//        OrderLogEntity byOrderId = iOrderService.findByOrderId(orderId);
//        if (byOrderId != null) {
//            msg = Msg.success().messageData("order", byOrderId);
//        } else {
//            msg = Msg.fail();
//        }
//        return msg;
//    }


    @PostMapping(value = "/findbyid", produces = "application/json;charset=UTF-8")
    public Msg findById(@RequestBody Map<String, Integer> param, HttpServletResponse response) {
        Msg msg = null;
        int id = param.get("id");
        OrderEntity byId = iOrderService.findById(id);
        if (byId != null) {
            msg = Msg.success().messageData("order", byId);
        } else {
            msg = Msg.fail();
        }
        return msg;
    }

    /**
     * 【根据id删除】
     *
     * @param param
     * @param response
     * @return
     */
    @PostMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public Msg deleteById(@RequestBody Map<String, Integer> param, HttpServletResponse response) {
        Msg msg = null;
        int id = param.get("id");
        int i = iOrderService.deleteById(id);
        if (i > 0) {
            msg = Msg.success();
        } else {
            msg = Msg.fail();
        }
        return msg;
    }


    /**
     * 查找所有的订单详细
     *
     * @return
     */
    @PostMapping("/findAll")
    public Msg findAll() {
        Msg msg;
        List<Map<String, Object>> list = iOrderService.findAll();
        //判断集合是否有数据，如果没有数据返回失败
        if (list.isEmpty()) {
            msg = Msg.fail();
        } else {
            msg = Msg.success().messageData("order", list);
        }
        return msg;
    }
}
