package com.cn.wanxi.mall.controller.order;


import com.cn.wanxi.entity.order.RefundCauseEntity;
import com.cn.wanxi.entity.order.ReturnCauseEntity;
import com.cn.wanxi.service.order.IRefundCauseService;
import com.cn.wanxi.service.order.IReturnCauseService;
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.utils.utils.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/refund")
public class OrderRefundCauseController {
    @Autowired
    private IRefundCauseService iRefundCauseService;
    @Autowired
    private IReturnCauseService iReturnCauseService;

    @PostMapping(value = "/findAll", produces = "application/json;charset=UTF-8")
    public Map<String, Object> refundList(@RequestBody Map<String, Object> param) {
        return iRefundCauseService.findAll(param);

    }

    @PostMapping(value = "/approval", produces = "application/json;charset=UTF-8")
    public Msg approval(@RequestBody RefundCauseEntity refundCauseEntity) {
        return iRefundCauseService.updateStatus(refundCauseEntity);
    }

    /**
     * 添加退货退款申请表
     *
     * @param refundCauseEntity
     * @return
     */
    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public Msg add(@RequestBody RefundCauseEntity refundCauseEntity) {
        return iRefundCauseService.add(refundCauseEntity);
    }

    /**
     * 【根据退货退款申请表id查询信息】
     *
     * @param param
     * @return
     */

    @PostMapping(value = "/findById", produces = "application/json;charset=UTF-8")
    public Msg findById(@RequestBody Map<String, Integer> param) {
        int id = param.get("id");
        return iRefundCauseService.findById(id);
    }

    /**
     * 【修改退货退款申请表】
     *
     * @param refundCauseEntity
     * @return
     */
    @PostMapping(value = "/update", produces = "application/json;charset=UTF-8")
    public Msg updateInfo(@RequestBody RefundCauseEntity refundCauseEntity) {
        return iRefundCauseService.update(refundCauseEntity);
    }

    /**
     * 【根据id删除】
     *
     * @param param
     * @return
     */
    @PostMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public Msg deleteById(@RequestBody Map<String, Integer> param) {
        int id = param.get("id");
        return iRefundCauseService.deleteById(id);
    }

    @PostMapping(value = "/casue", produces = "application/json;charset=UTF-8")

    public Msg casue(@RequestBody Map<String, Integer> param) {
        int id = param.get("id");
        return iReturnCauseService.findById(id);
    }
}
