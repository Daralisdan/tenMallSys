package com.cn.wanxi.mall.controller.order;


import com.cn.wanxi.entity.order.OrderLogEntity;
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.service.order.IOrderLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


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
       return iOrderLogService.add(orderLogEntity);
    }
    /**
     * 查找所有的日志详细
     * @return
     */
    @PostMapping("/findAll")
    public Msg findAll() {
       return iOrderLogService.findAll();
    }

    /**
     * 【根据日志详细id查询信息】
     * @param param
     * @return
     */
    @PostMapping(value = "/findById", produces = "application/json;charset=UTF-8")
    public Msg findById(@RequestBody Map<String ,Integer>param) {
        int id = param.get("id");
        return iOrderLogService.findById(id);
    }
    /**
     * 【修改日志信息】
     *
     * @param orderLogEntity
     * @return
     */
    @PostMapping(value = "/update", produces = "application/json;charset=UTF-8")
    public Msg updateInfo (@RequestBody OrderLogEntity orderLogEntity) {
        return iOrderLogService.update(orderLogEntity);
    }

    /**
     * 【根据id删除】
     * @param orderLogEntity
     * @return
     */
    @PostMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public Msg deleteById(@RequestBody OrderLogEntity orderLogEntity) {
        int id=orderLogEntity.getId();
        return iOrderLogService.deleteById(id);
    }


}
