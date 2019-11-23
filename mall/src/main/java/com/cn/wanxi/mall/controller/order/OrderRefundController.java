package com.cn.wanxi.mall.controller.order;


import com.cn.wanxi.entity.order.RefundCauseEntity;
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.service.order.IOrderService;
import com.cn.wanxi.service.order.IRefundCauseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/refund")
public class OrderRefundController {
    @Autowired
    private IOrderService iOrderService;
    @Autowired
    private IRefundCauseService iRefundCauseService;

    @PostMapping("/list")
    public HashMap<String,Object> refundList(int page, int size) {
        LinkedHashMap<String,Object> rest = new LinkedHashMap<>();
        List<Map<String, Object>> list = iOrderService.refundList(page, size);
        rest.put("rows",list);
        rest.put("total",100);
        return rest;
    }

    @PostMapping("/approval")
    public Msg approval(RefundCauseEntity refundCauseEntity) {
        Msg msg = null;
        int up = iRefundCauseService.update(refundCauseEntity);
        if (up > 0) {
            msg = Msg.success();
        } else {
            msg = Msg.fail();
        }
        return msg;
    }



}
