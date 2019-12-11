package com.cn.wanxi.mall.controller.order;


import com.cn.wanxi.entity.order.OrderItemEntity;
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.service.order.IOrderItemService;
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
@RequestMapping("/orderItem")
public class OrderItemController {

    @Autowired
    private IOrderItemService iOrderItemService;



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
            msg = Msg.success().messageData(list);
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
        int id = param.get("id");
        if (!StringUtils.isEmpty(id) && id > 0) {
            OrderItemEntity byId = iOrderItemService.findById(id);
            //判断是否有返回的数据
            if (!ObjectUtils.isEmpty(byId)) {
                msg = Msg.success().messageData(byId);
            } else {
                msg = Msg.fail().messageData("该订单详情不存在");
            }
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
        //先获取id
        int id = orderItemEntity.getId();
        if (id > 0) {
            //根据id查询数据
            OrderItemEntity byId = iOrderItemService.findById(id);
            //判断是否查询到该品牌信息
            if (!ObjectUtils.isEmpty(byId)) {
                int result = iOrderItemService.update(orderItemEntity);
                if (result > 0) {
                    msg = Msg.success().messageData(orderItemEntity);
                }
            } else {
                msg = Msg.fail().messageData("该订单详情不存在");
            }
        } else {
            msg = Msg.fail().messageData("请输入id");
        }
        return msg;
    }

    /**
     * 【根据id删除】
     * @param orderItemEntity
     * @return
     */
    @PostMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public Msg deleteById(@RequestBody OrderItemEntity orderItemEntity) {
        Msg msg = null;
        int id = orderItemEntity.getId();
        if (id > 0) {
            int i = iOrderItemService.deleteById(id);
            if (i > 0) {
                msg = Msg.success().messageData("删除成功");
            } else {
                msg = Msg.fail().messageData("删除失败,该订单详细不存在");
            }
        } else {
            msg = Msg.fail().messageData("请输入id");
        }
        return msg;
    }

}
