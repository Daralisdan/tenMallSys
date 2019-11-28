package com.cn.wanxi.mall.controller.order;


import com.cn.wanxi.entity.order.RefundCauseItemEntity;
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.service.order.IRefundCauseItemService;
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
        Msg msg = null;
        if (0 != refundCauseItemEntity.getOrderId()) {
            int result = iRefundCauseItemService.add(refundCauseItemEntity);
            if (0 != result) {
                msg = Msg.success().messageData(refundCauseItemEntity);
            }
        } else {
            msg = Msg.fail().messageData("退货退款申请明细ID不能为空");
        }
        return msg;
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
        int id = param.get("id");
        if (!StringUtils.isEmpty(id) && id > 0) {
            RefundCauseItemEntity byId = iRefundCauseItemService.findById(id);
            //判断是否有返回的数据
            if (!ObjectUtils.isEmpty(byId)) {
                msg = Msg.success().messageData(byId);
            } else {
                msg = Msg.fail().messageData("该退货退款明细不存在");
            }
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
        //先获取id
        int id = refundCauseItemEntity.getId();
        if (id > 0) {
            //根据id查询数据
            RefundCauseItemEntity byId = iRefundCauseItemService.findById(id);
            //判断是否查询到该品牌信息
            if (!ObjectUtils.isEmpty(byId)) {
                int result = iRefundCauseItemService.update(refundCauseItemEntity);
                if (result > 0) {
                    msg = Msg.success().messageData(refundCauseItemEntity);
                }
            } else {
                msg = Msg.fail().messageData("该退货退款明细不存在");
            }
        } else {
            msg = Msg.fail().messageData("请输入id");
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
        int id = param.get("id");
        if (id > 0) {
            int i = iRefundCauseItemService.deleteById(id);
            if (i > 0) {
                msg = Msg.success().messageData("删除成功");
            } else {
                msg = Msg.fail().messageData("删除失败,该退货退款明细不存在");
            }
        } else {
            msg = Msg.fail().messageData("请输入id");
        }
        return msg;
    }


}
