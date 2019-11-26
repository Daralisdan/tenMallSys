package com.cn.wanxi.mall.controller.order;


import com.cn.wanxi.entity.order.OrderLogEntity;
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.service.order.IOrderLogService;
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
        Msg m;
        int result = iOrderLogService.add(orderLogEntity);
        if (!isEmpty(result)) {
            m = Msg.success().messageData("orderLog", orderLogEntity);
        } else {
            m = Msg.fail();
        }
        return m;
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
            msg = Msg.success().messageData("orderLog", list);
        }
        return msg;
    }

    /**
     * 【根据日志详细id查询信息】
     * @param param
     * @param response
     * @return
     */
    @PostMapping(value = "/findById", produces = "application/json;charset=UTF-8")
    public Msg findById(@RequestBody Map<String ,Integer>param, HttpServletResponse response) {
        Msg msg = null;
        int id =param.get("id");
        OrderLogEntity byId = iOrderLogService.findById(id);
        if (byId != null) {
            msg = Msg.success().messageData("orderLog", byId);
        } else {
            msg = Msg.fail();
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

        int up = iOrderLogService.update(orderLogEntity);
        if (up > 0) {
            msg = Msg.success().messageData("orderLog", orderLogEntity);
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
        int i = iOrderLogService.deleteById(id);
        if (i > 0) {
            msg = Msg.success();
        } else {
            msg = Msg.fail();
        }
        return msg;
    }


}
