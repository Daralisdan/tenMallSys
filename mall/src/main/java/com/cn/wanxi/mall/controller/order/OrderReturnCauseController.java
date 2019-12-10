package com.cn.wanxi.mall.controller.order;

import com.cn.wanxi.entity.order.ReturnCauseEntity;
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.service.order.IReturnCauseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/cause")
public class OrderReturnCauseController {
    @Autowired
    private IReturnCauseService iReturnCauseService;

    @PostMapping(value = "/casue", produces = "application/json;charset=UTF-8")
    public Msg casue(@RequestBody ReturnCauseEntity returnCauseEntity) {
        return iReturnCauseService.update(returnCauseEntity);
    }

    /**
     * 添加退货退款申请明细
     *
     * @param returnCauseEntity
     * @return
     */
    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public Msg add(@RequestBody ReturnCauseEntity returnCauseEntity) {
        return iReturnCauseService.add(returnCauseEntity);
    }

    /**
     * 查找所有的退货退款申请明细
     *
     * @return
     */
    @PostMapping("/findAll")
    public Msg findAll() {
        return iReturnCauseService.findAll();
    }

    /**
     * 【根据退货退款申请明细id查询信息】
     *
     * @param param
     * @param response
     * @return
     */
    @PostMapping(value = "/findById", produces = "application/json;charset=UTF-8")
    public Msg findById(@RequestBody Map<String, Integer> param, HttpServletResponse response) {
        int id = param.get("id");
        return iReturnCauseService.findById(id);
    }

    /**
     * 【修改退货退款申请明细信息】
     *
     * @param returnCauseEntity
     * @return
     */
    @PostMapping(value = "/update", produces = "application/json;charset=UTF-8")
    public Msg updateInfo(@RequestBody ReturnCauseEntity returnCauseEntity) {
        return iReturnCauseService.update(returnCauseEntity);
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
        int id = param.get("id");
        return iReturnCauseService.deleteById(id);
    }


}
