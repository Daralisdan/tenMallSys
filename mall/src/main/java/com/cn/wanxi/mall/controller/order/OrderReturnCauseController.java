package com.cn.wanxi.mall.controller.order;

import com.cn.wanxi.entity.order.ReturnCauseEntity;
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.service.order.IReturnCauseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/refund")
public class OrderReturnCauseController {
    @Autowired
    private IReturnCauseService iReturnCauseService;
    @PostMapping("/casue")
    public Msg casue(ReturnCauseEntity returnCauseEntity) {
        Msg msg = null;
        int up = iReturnCauseService.update(returnCauseEntity);
        if (up > 0) {
            msg = Msg.success().messageData(returnCauseEntity);
        } else {
            msg = Msg.fail();
        }
        return msg;
    }


}
