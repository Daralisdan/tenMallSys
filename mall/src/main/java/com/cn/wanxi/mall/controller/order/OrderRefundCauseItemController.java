package com.cn.wanxi.mall.controller.order;


import com.cn.wanxi.entity.order.RefundCauseItemEntity;
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.service.order.IRefundCauseItemService;
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
@RequestMapping("/refundItem")
public class OrderRefundCauseItemController {
    @Autowired
    private IRefundCauseItemService iRefundCauseItemService;
    /**
     * 添加退货退款申请明细
     * @param refundCauseItemEntity
     * @return
     */
    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public Msg add(@RequestBody RefundCauseItemEntity refundCauseItemEntity) {
        Msg m;
        int result = iRefundCauseItemService.add(refundCauseItemEntity);
        if (!isEmpty(result)) {
            m = Msg.success().messageData(refundCauseItemEntity);
        } else {
            m = Msg.fail();
        }
        return m;
    }

    /**
     * 查找所有的退货退款申请明细
     * @return
     */
    @PostMapping("/findAll")
    public Msg findAll() {
        Msg msg;
        List<Map<String, Object>> list = iRefundCauseItemService.findAll();
        //判断集合是否有数据，如果没有数据返回失败
        if (list.isEmpty()) {
            msg = Msg.fail();
        } else {
            msg = Msg.success().messageData(list);
        }
        return msg;
    }

    /**
     * 【根据退货退款申请明细id查询信息】
     * @param param
     * @param response
     * @return
     */
    @PostMapping(value = "/findById", produces = "application/json;charset=UTF-8")
    public Msg findById(@RequestBody Map<String, Integer> param, HttpServletResponse response) {
        Msg msg = null;
        int id =param.get("id");
        RefundCauseItemEntity byId = iRefundCauseItemService.findById(id);
        if (byId != null) {
            msg = Msg.success().messageData(byId);
        } else {
            msg = Msg.fail();
        }
        return msg;
    }

    /**
     * 【修改退货退款申请明细信息】
     *
     * @param refundCauseItemEntity
     * @return
     */
    @PostMapping(value = "/update", produces = "application/json;charset=UTF-8")
    public Msg updateInfo(@RequestBody RefundCauseItemEntity refundCauseItemEntity) {
        Msg msg = null;

        int up = iRefundCauseItemService.update(refundCauseItemEntity);
        if (up > 0) {
            msg = Msg.success().messageData(refundCauseItemEntity);
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
    public Msg deleteById(@RequestBody Map<String, Integer> param, HttpServletResponse response) {
        Msg msg = null;
        int id =param.get("id");
        int i = iRefundCauseItemService.deleteById(id);
        if (i > 0) {
            msg = Msg.success();
        } else {
            msg = Msg.fail();
        }
        return msg;
    }


}
