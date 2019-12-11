package com.cn.wanxi.mall.controller.order;


import com.cn.wanxi.entity.order.OrderLogEntity;
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.service.order.IOrderLogService;
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
@RequestMapping("/orderLog")
public class OrderLogController {
    @Autowired
    private IOrderLogService iOrderLogService;

    /**
     * 添加日志详细
     * @param orderLogEntity
     * @return
     */
    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public Msg add(@RequestBody OrderLogEntity orderLogEntity) {
        Msg msg=null;
        if (0 != orderLogEntity.getOrderId()) {
            int result = iOrderLogService.add(orderLogEntity);
            if (0 != result) {
                msg = Msg.success().messageData(orderLogEntity);
            }
        } else {
            msg = Msg.fail().messageData("名字不能为空");
        }
        return msg;
    }
    /**
     * 查找所有的日志详细
     * @return
     */
    @PostMapping("/findAll")
    public Msg findAll() {
        Msg msg;
        List<Map<String, Object>> list = iOrderLogService.findAll();
        //判断集合是否有数据，如果没有数据返回失败
        if (list.isEmpty()) {
            msg = Msg.fail();
        } else {
            msg = Msg.success().messageData(list);
        }
        return msg;
    }

    /**
     * 【根据日志详细id查询信息】
     * @param param
     * @return
     */
    @PostMapping(value = "/findById", produces = "application/json;charset=UTF-8")
    public Msg findById(@RequestBody Map<String ,Integer>param) {
        Msg msg = null;
        int id = param.get("id");
        if (!StringUtils.isEmpty(id) && id > 0) {
            OrderLogEntity byId = iOrderLogService.findById(id);
            //判断是否有返回的数据
            if (!ObjectUtils.isEmpty(byId)) {
                msg = Msg.success().messageData(byId);
            } else {
                msg = Msg.fail().messageData("该订单日志不存在");
            }
        }
        return msg;
    }
    /**
     * 【修改日志信息】
     *
     * @param orderLogEntity
     * @return
     */
    @PostMapping(value = "/update", produces = "application/json;charset=UTF-8")
    public Msg updateInfo (@RequestBody OrderLogEntity orderLogEntity) {
        Msg msg = null;
        //先获取id
        int id = orderLogEntity.getId();
        if (id > 0) {
            //根据id查询数据
            OrderLogEntity byId = iOrderLogService.findById(id);
            //判断是否查询到该品牌信息
            if (!ObjectUtils.isEmpty(byId)) {
                int result = iOrderLogService.update(orderLogEntity);
                if (result > 0) {
                    msg = Msg.success().messageData(orderLogEntity);
                }
            } else {
                msg = Msg.fail().messageData("该订单日志不存在");
            }
        } else {
            msg = Msg.fail().messageData("请输入id");
        }
        return msg;
    }

    /**
     * 【根据id删除】
     * @param orderLogEntity
     * @return
     */
    @PostMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public Msg deleteById(@RequestBody OrderLogEntity orderLogEntity) {
        Msg msg = null;
        int id = orderLogEntity.getId();
        if (id > 0) {
            int i = iOrderLogService.deleteById(id);
            if (i > 0) {
                msg = Msg.success().messageData("删除成功");
            } else {
                msg = Msg.fail().messageData("删除失败,该日志不存在");
            }
        } else {
            msg = Msg.fail().messageData("请输入id");
        }
        return msg;
    }


}
